package com.adria.stage.mytest.belmahi;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adria.stage.mytest.belmahi.helper.GenericVirementRequest;
import com.adria.stage.mytest.belmahi.model.Abonne;
import com.adria.stage.mytest.belmahi.model.BeneficiaireDuVirement;
import com.adria.stage.mytest.belmahi.model.Virement;
import com.adria.stage.mytest.belmahi.model.VirementMultiple;
import com.adria.stage.mytest.belmahi.service.IAbonneService;
import com.adria.stage.mytest.belmahi.service.IBeneficiaireService;
import com.adria.stage.mytest.belmahi.service.ICompteService;
import com.adria.stage.mytest.belmahi.service.IVirementMulitpleBeneficiaireService;
import com.adria.stage.mytest.belmahi.service.IVirementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-context.xml")
public class MyVirementMultipleTest {

	@Autowired
	IAbonneService abonneService;

	@Autowired
	IBeneficiaireService beneficiaireService;

	@Autowired
	ICompteService compteService;
	
	@Autowired
	IVirementService virementService;
	
	@Autowired
	IVirementMulitpleBeneficiaireService virementMultipleBeneficiaireService;

	@Test
	public void test() {

		VirementMultiple virementMultiple = new VirementMultiple();
		
		virementMultiple = (VirementMultiple) virementService.getVirement(11L);
		
		virementMultiple.setStatut(Virement.CONFIRME_SIGNE);
		virementService.comfirmerVirement(virementMultiple.getIdVirement());
		
		/*Abonne abonne = abonneService.getAbonneByUsername("belmahi");

		GenericVirementRequest genericVirementRequest = new GenericVirementRequest();
		
		genericVirementRequest.setDateExecution("02-02-2015");
		genericVirementRequest.setIdCompte(1);
		genericVirementRequest.setMontant(1000);
		genericVirementRequest.setMotif("My Motif");
		List<BeneficiaireDuVirement> beneficiairesDuVirements = new ArrayList<BeneficiaireDuVirement>();
		BeneficiaireDuVirement b = new BeneficiaireDuVirement();
		b.setIdBeneficiaire(1L);
		b.setNom("ahmad");
		b.setMontant(new BigDecimal(1000));
		BeneficiaireDuVirement b2 = new BeneficiaireDuVirement();
		b2.setIdBeneficiaire(3L);
		b2.setNom("ahmad");
		b2.setMontant(new BigDecimal(1000));
		beneficiairesDuVirements.add(b);
		beneficiairesDuVirements.add(b2);
		genericVirementRequest.setBeneficiairesDuVirement(beneficiairesDuVirements);
		
		VirementMultiple virementMultiple = new VirementMultiple();

		virementMultiple.setAbonne(abonne);
		virementMultiple.setMontant(new BigDecimal(genericVirementRequest
				.getMontant()));
		virementMultiple.setMotif(genericVirementRequest.getMotif());
		virementMultiple.setNombreBenificiaires(genericVirementRequest
				.getBeneficiairesDuVirement().size());
		virementMultiple.setDateCreation(new Date());
		virementMultiple.setCompte(compteService
				.getCompte((long) genericVirementRequest.getIdCompte()));
		try {
			// create SimpleDateFormat object with source string date format
			SimpleDateFormat sdfSource = new SimpleDateFormat("dd-mm-yyyy");
			// parse the string into Date object
			Date date = sdfSource.parse(genericVirementRequest
					.getDateExecution());
			virementMultiple.setDateExecution(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		virementMultiple = (VirementMultiple) virementService
				.addVirement(virementMultiple);
		System.out.println(virementMultiple.getIdVirement());
		virementMultipleBeneficiaireService
				.makeAllVirement(virementMultipleBeneficiaireService
						.getListVirementMultipleBeneficiare(
								genericVirementRequest
										.getBeneficiairesDuVirement(),
								virementMultiple));*/

		// assertNotNull(dbpost);
		System.out.println("here we goo !!");
	}
}
