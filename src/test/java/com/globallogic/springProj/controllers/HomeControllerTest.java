package com.globallogic.springProj.controllers;
/*
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
 

import com.globallogic.springProj.model.*;
import com.globallogic.springProj.service.*;
import com.globallogic.springProj.service.impl.UserServiceImpl;

import static org.springframework.test.web.ModelAndViewAssert.*;
//Mockito imports
import static org.mockito.Mockito.*;

/*
I will leave this line until further notice
If i forget how how to mount application context in the test environment
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/WEB-INF/applicationContext.xml",
					"/WEB-INF/action-servlet.xml"})
*/
public class HomeControllerTest {
	 
	/*
	 * The same goes here to
	 * let it stay for a while (virtually forever)
	 * 
	@Autowired
	private ApplicationContext applicationContext;
	

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    private HandlerAdapter handlerAdapter;
    
    private HomeController homeController;

    private UserService mockUserService;

    @Before
    public void setUp() {
    	//Making mock Request and Response 
       request = new MockHttpServletRequest();
       response = new MockHttpServletResponse();

       //Creating HandlerAdapter to handle our request
       //in this case this is AnnotationMethodHandlerAdapter
       //coz my controller is an annotation driven controller 
       handlerAdapter = new AnnotationMethodHandlerAdapter();
       
       //Mocking live(mock) stub for UserController
       mockUserService = mock(UserServiceImpl.class);
       
       //I could get the controller from the context here but i won't
       //Coz my goal is to make something like unit test after all
       //So i create my controller from scratch
       homeController = new HomeController();

       //Wiring Controller and manager together
       //I threw Spring context away so now i have to do it myself
       //What a shame
       homeController.setUserManager(mockUserService);
    }

    @Test
    public void testGet() throws Exception {
    	//Creating Mock request
    	//no response is expected
    	request.setRequestURI("/appuser.htm");
    	request.setMethod("GET");
    	response = null;
 
    	//Recording mock behaviour
        when(mockUserManager.getUsers()).thenReturn(new ArrayList<User>());
        
       //Pretending our servlet container handled our request and made something to the ModelAndView
       final ModelAndView mav = handlerAdapter.handle(request, response, userController);

       //checking for a model name
       assertViewName(mav, "appuser");
       
       //checking model attributes were shared
       assertModelAttributeAvailable(mav, "message");
       assertModelAttributeAvailable(mav, "users");
       
       //checking mock activities
       verify(mockUserManager, times(1)).getUsers();
       
       //Looks pretty lively, for now at least
    }
    */
}
