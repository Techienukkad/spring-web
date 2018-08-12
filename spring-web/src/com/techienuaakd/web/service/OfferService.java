package com.techienuaakd.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techienuaakd.web.dao.Offer;
import com.techienuaakd.web.dao.OffersDAO;

@Service("OfferService")
public class OfferService {

	private OffersDAO dao;
	
	public OffersDAO getDao() {
		return dao;
	}
	
	@Autowired
	public void setDao(OffersDAO dao) {
		this.dao = dao;
	}

	public List<Offer> getCurrent()
	{
		
		return dao.getAllOffers();
	}

	public void addOffer(Offer offer) {
		dao.addOffer(offer);
	}

	public void throwTestException() {
		// TODO Auto-generated method stub
		dao.getOffer(10000);
		
	}
}
