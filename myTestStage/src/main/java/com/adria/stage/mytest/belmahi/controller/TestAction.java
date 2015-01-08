package com.adria.stage.mytest.belmahi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adria.stage.mytest.belmahi.model.Abonne;
import com.adria.stage.mytest.belmahi.service.IAbonneService;

@Controller
@RequestMapping("/Test")
public class TestAction {
	
	@Autowired
	IAbonneService abonneService;
	
	
	@RequestMapping(value="/addAbonne", method = RequestMethod.GET)
	public String testAddAbonne(){
		
		Abonne abonne = new Abonne();
		abonne.setNom("amiral");
		abonne.setPrenom("mohamed");
		abonne.setUsername("user1");
		abonne.setPassword("123456");
		
		abonneService.AddAbonne(abonne);
		
//		Post dbpost = repository.findOne(post.getPostId());
//		assertNotNull(dbpost);
		System.out.println("here we goo !!");
		
		return "index";
	}
	
}
