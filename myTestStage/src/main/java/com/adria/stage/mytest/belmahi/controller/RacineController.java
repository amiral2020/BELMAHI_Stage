package com.adria.stage.mytest.belmahi.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.adria.stage.mytest.belmahi.response.GenericResponse;
import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class RacineController {
	
	
	@RequestMapping
	public String index(){
		return "index";
	}
	
	
	@RequestMapping("compte")
	public String compte(){
		return "menu";
	}
	
	@RequestMapping("login")
	public @ResponseBody ModelAndView getLoginForm(@RequestParam(required = false) String authfailed, String logout, String denied, String success){
		
		
		GenericResponse genericResponse = new GenericResponse();
		String message = "";
		genericResponse.setSuccess(false);
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
		} else if (logout != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
			message = "Logged Out successfully, login again to continue !";
			return new ModelAndView("login", "message", message);
			
		} else if (denied != null) {
			message = "Access denied for this user !";
		} else if(success !=null){
			message = "successfully login";
			genericResponse.setSuccess(true);
		}else{

			return new ModelAndView("login", "message", null);
		}
		
		
		genericResponse.setMessage(message);
		
		Gson gson = new Gson();
		String json = gson.toJson(genericResponse);
		
		/*MappingJacksonJsonView myVar = new MappingJacksonJsonView();
		myVar.setContentType(json);*/
		
		ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
		mav.addObject(genericResponse);
		
		return mav;
	}
	
	/*@RequestMapping("login")
	public ModelAndView getLoginForm(
			@RequestParam(required = false) String authfailed, String logout, String denied) {
		String message = "";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		} else if (denied != null) {
			message = "Access denied for this user !";
		}
		return new ModelAndView("login", "message", message);
	}*/
	
	@RequestMapping("user")
	public String geUserPage() {
		return "user";
	}
	
	
}
