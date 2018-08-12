package com.techienuaakd.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techienuaakd.web.dao.User;
import com.techienuaakd.web.service.UsersService;

@Controller
public class loginController {
	
	private UsersService daoService;

	public UsersService getDaoService() {
		return daoService;
	}
	@Autowired
	public void setDaoService(UsersService daoService) {
		this.daoService = daoService;
	}

	@RequestMapping("/login")
	public String showLogin()
	{
		return "loginPage";
	}
	
	@RequestMapping("/register")
	public String showSignUp(Model model)
	{
		model.addAttribute("user", new User());
		return "signUp";
	}
	
	/*@RequestMapping("/newUser")
	public String addNewUSer(Model request)
	{
		
		request.addAttribute("created", "true");
		return "loginPage";
	}*/
	
	@RequestMapping(value="/newUser",method=RequestMethod.POST)
	public String addOffer(@Valid @ModelAttribute("user") User user,BindingResult result,Model m)
	{
		
		if(result.hasErrors())
		{
			/*System.out.println("Invalidate");
			List<ObjectError> err = result.getAllErrors();
			for(ObjectError e:err)
			{System.out.println(e);}*/			
			return "signUp";			
		}
		user.setAuthority("user");
		user.setEnabled(true);
		daoService.createUser(user);	
		m.addAttribute("created", "true");
		return "loginPage";
	}
}
