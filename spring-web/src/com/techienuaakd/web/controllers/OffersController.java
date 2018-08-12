package com.techienuaakd.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techienuaakd.web.dao.Offer;
import com.techienuaakd.web.service.OfferService;

@Controller
public class OffersController {
	private OfferService daoService;
	
	@RequestMapping("/offers")
	public String showHome(Model model)
	{
		//daoService.throwTestException();
		List<Offer> offers= daoService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "home";
	}
	
	/*@ExceptionHandler(DataAccessException.class)
	public String handleException(DataAccessException ex)
	{
		return "error";
	}*/
	
	@RequestMapping(value="/createOffer",method=RequestMethod.GET)
	public String create(Model model)
	{
		
		model.addAttribute("offers", new Offer());
		return "createOffer";
	}
	
	@RequestMapping(value="/addOffer",method=RequestMethod.POST)
	public String addOffer(@Valid @ModelAttribute("offers") Offer offer,BindingResult result)
	{
		
		if(result.hasErrors())
		{
			/*System.out.println("Invalidate");
			List<ObjectError> err = result.getAllErrors();
			for(ObjectError e:err)
			{System.out.println(e);}*/			
			return "createOffer";			
		}
		daoService.addOffer(offer);		
		return "offerCreated";
	}
	public OfferService getDaoService() {
		return daoService;
	}
	
	@Autowired
	public void setDaoService(OfferService daoService) {
		this.daoService = daoService;
	}

	
}
