$(document).ready(function() {
	$('#allUsers').click(function() {
		$.getJSON("userJson/all",{}, function(data) {
			$('#right-content').empty().html('<h3> Users (Ajax way) </h3> '
					+ '<table id="users-table"> <tr> '
					+ '<th>User ID</th>'
					+ '<th>User name</th>'
					+ '<th>user password</th>'
					+ '<th>user roles</th>'
					+ '<th>&nbsp;</th>'
					+ '<th>&nbsp;</th>'
					+ '</tr>');
			drawTable(data);
			});
	});
	
	$('#adminLog').click(function(){
		$('#right-content').empty();
		
			$('#admin-log-container').load(ctx + "/controllers.txt", {}, function() {
				alert("dsfgfg");
			});
	});
	

	$('#allUsersjTable').click(function() {
		$('#right-content').empty();
		$('#user-table-container').jtable({
			title : 'jTable of users',
			selecting : true,
			paging : true,
			pageSize : 10,
			sorting : true,
			loadingAnimationDelay: 100,
			actions : {
				listAction : 'userJTable/all',
				createAction : 'userJTable/add',
				updateAction : 'userJTable/update',
				deleteAction : 'userJTable/delete'
					},
			fields : {userId : {title : 'Id',
								list : true,
								key : true,
								edit : false,
								create : false
								},
					login : {title : 'Login',
							width : '20%'
							},
					password : {title : 'Password',
								width : '20%',
								type: 'password'
								},
					cofirmPassword : {title : 'Confirm password',
									width : '20%',
									type: 'password',
									list: false,
									edit: true,
									create: true
									},
					roles : {title : 'Roles',
							width : '30%',
							edit : false,
							create : false,
							display : function(data) {
													var result = [];
													for ( var index in data.record.roles) {
														result.push(" "+ data.record.roles[index].name)
														};
													return result.toString();
													}
							},
							/*
							 * checkboxes for roles
							 * */
					allRoles: {
						title : 'User roles',
						list : false,
						edit : true,
						create : true,
						type: 'multiselectddl',
//						type: 'radiobutton',
						
						options: { '1': 'admin', 
		                       '2': 'user', '3': 'guest' }
						/*display : function(data) {
													var result = [];
													for ( var index in data.record.roles) {
														result.push(" "+ data.record.roles[index].name)
														};
													return result.toString();
													}
							}*/
						},
						
					
					},
					 
			formCreated: function (event, data) {
			                data.form.find('input[name="login"]').addClass(
			                  'validate[required,minSize[4], maxSize[12]]');
			                data.form.find('input[name="password"]').addClass(
			                  'validate[required, minSize[4], maxSize[12]]');
			                data.form.find('input[name="cofirmPassword"]').addClass(
			                  'validate[required,  equals[Edit-password]]');
			                data.form.find('input[name="allRoles"]').addClass(
			                  'validate[required]');
			                
			                data.form.validationEngine();
		                    data.form.find('select[name=CityId]').attr('multiple','multiple');
			            },
			 formSubmitting: function (event, data) {
			                return data.form.validationEngine('validate');
			            },
			 formClosed: function (event, data) {
			                data.form.validationEngine('hide');
			                data.form.validationEngine('detach');
			            }
			});
		$('#user-table-container').jtable("load");
	});
});

function drawRow(rowData) {
	var row = $("<tr />");
	$("#users-table").append(row);
	row.append($("<td>" + rowData.userId + "</td>"));
	row.append($("<td>" + rowData.login + "</td>"));
	row.append($("<td>" + rowData.password + "</td>"));
	row.append($("<td>" + getRoles(rowData.roles).toString() + "</td>"));
	row.append($("<td>" + "<a href='user/delete?id='" + rowData.userId
			+ "'>Delete</a></td>"));
	row.append($("<td>" + "<a href='user/edit?id=" + rowData.userId
			+ "'>Edit</a>" + "</td>"));
};

function getRoles(list) {
	var result = [];
	for ( var index in list) {
		result.push(list[index].name);
	}
	return result;
}

function drawTable(data) {
	for ( var index in data) {
		drawRow(data[index]);
	}

};

