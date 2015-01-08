package com.adria.stage.mytest.belmahi.controller.restful;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.adria.stage.mytest.belmahi.model.Abonne;
import com.adria.stage.mytest.belmahi.model.Beneficiaire;
import com.adria.stage.mytest.belmahi.service.IAbonneService;

@Component("restfulCompte")
public class RestfulCompteImpl implements IRestfulCompte {

	@Autowired
	IAbonneService abonneService;
	
	@Override
	public Set<Beneficiaire> getBeneficiairesAbonne() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username
		
		Abonne abonne = abonneService.getAbonneByUsername(username);
		
		return abonne.getBeneficiares();
	}

}
