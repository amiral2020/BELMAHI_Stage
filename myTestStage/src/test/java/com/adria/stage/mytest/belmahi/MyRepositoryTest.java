package com.adria.stage.mytest.belmahi;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adria.stage.mytest.belmahi.model.Abonne;
import com.adria.stage.mytest.belmahi.model.Beneficiaire;
import com.adria.stage.mytest.belmahi.model.Compte;
import com.adria.stage.mytest.belmahi.service.IAbonneService;
import com.adria.stage.mytest.belmahi.service.IBeneficiaireService;
import com.adria.stage.mytest.belmahi.service.ICompteService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class MyRepositoryTest {
	
	@Autowired
	IAbonneService abonneService;
	
	@Autowired
	IBeneficiaireService beneficiaireService;
	
	@Autowired
	ICompteService compteService;
	
	@Test
	public void test() {
		Abonne abonne = abonneService.getAbonneByUsername("belmahi");
		System.out.println("username : "+abonne.getUsername());
		Compte compte = new Compte();
		compte.setAbonne(abonne);
		compte.setIntitule("BELMHAI 2");
		compte.setNumeroCompte("KKKKSLLDJ");
		compte.setSoldeComptable(new BigDecimal(1000));
		
		compteService.addCompte(compte);
		
		Compte compte1 = new Compte();
		compte1.setAbonne(abonne);
		compte1.setIntitule("BELMHAI 3");
		compte1.setNumeroCompte("DDSS");
		compte1.setSoldeComptable(new BigDecimal(2000));
		
		compteService.addCompte(compte1);
		
		/*abonne.setNom("amiral");
		abonne.setPrenom("mohamed");
		abonne.setUsername("belmahi");
		abonne.setPassword("stage");
		
		
		abonneService.AddAbonne(abonne);*/
		
		Abonne abonneNew = new Abonne();
		abonneNew.setNom("amiralon");
		abonneNew.setPrenom("han");
		abonneNew.setUsername("stage");
		abonneNew.setPassword("stage");
		
//		abonneService.AddAbonne(abonneNew);
		
		System.out.println("username : "+abonne.getUsername());
		
		/*System.out.println("abonne added");
		Beneficiaire beneficiaire = new Beneficiaire();
		beneficiaire.setAbonne(abonne);
		beneficiaire.setNom("ahmad");
		beneficiaire.setPrenom("dolmi");
		beneficiaire.setNumeroCompte("773HHDHHY");
		
		System.out.println("you are here 1 ");
		
		beneficiaireService.addBeneficiaire(beneficiaire);
		
		System.out.println("you are here 2 ");
		
		Beneficiaire beneficiaire_2 = new Beneficiaire();
		beneficiaire_2.setAbonne(abonne);
		beneficiaire_2.setNom("ahmad");
		beneficiaire_2.setPrenom("dolmi");
		beneficiaire_2.setNumeroCompte("773HHDHHZ");
		
		beneficiaireService.addBeneficiaire(beneficiaire_2);*/
		
//		abonneService.getAbonne(1L);
		
//		Post dbpost = repository.findOne(post.getPostId());
//		assertNotNull(dbpost);
		System.out.println("here we goo !!");
	}

}
