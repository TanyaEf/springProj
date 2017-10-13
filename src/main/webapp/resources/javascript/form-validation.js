/**
 * 
 */

$(document).ready(function() {

	$("form").validate({
		rules : {
			login : {
				required : true,
				minlength : 4,
				maxlength : 16,
			},

			password : {
				required : true,
				minlength : 4,
				maxlength : 16,
			},

			passconf : {
				required : true,
				equalTo : "#password"
			},
			roles : {
				required : true,
			}
		},

		messages : {

			login : {
				required : "This field is required",
				minlength : "Minimal length is  4 symbols",
				maxlength : "Maximal length is  16 symbols",
			},

			password : {
				required : "This field is required",
				minlength : "Minimal length is  4 symbols",
				maxlength : "Maximal length is  16 symbols",
			},

			passconf : {
				required : "This field is required",
				equalTo : "Confirmation should be equal to password"
			},

			roles : {
				required : "Choose one of the roles",
			}

		},
		 errorPlacement: function(error, element) {
	            if (element.attr('type') == "checkbox") {
	                error.insertBefore(element.parent().parent());
	            }
	            else {
	                error.insertBefore(element);
	            }
	        }
	});

});