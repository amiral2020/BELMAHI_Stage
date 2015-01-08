package com.adria.stage.mytest.belmahi.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.adria.stage.mytest.belmahi.helper.GenericComfirmationRequest;
import com.adria.stage.mytest.belmahi.helper.GenericVirementRequest;
import com.adria.stage.mytest.belmahi.helper.HashCode;
import com.adria.stage.mytest.belmahi.model.Abonne;
import com.adria.stage.mytest.belmahi.model.Beneficiaire;
import com.adria.stage.mytest.belmahi.model.BeneficiaireDuVirement;
import com.adria.stage.mytest.belmahi.model.Compte;
import com.adria.stage.mytest.belmahi.model.Virement;
import com.adria.stage.mytest.belmahi.model.VirementMultiple;
import com.adria.stage.mytest.belmahi.model.VirementMultipleBeneficiare;
import com.adria.stage.mytest.belmahi.response.GenericResponse;
import com.adria.stage.mytest.belmahi.response.GenericVirementMultiDo;
import com.adria.stage.mytest.belmahi.service.IAbonneService;
import com.adria.stage.mytest.belmahi.service.ICompteService;
import com.adria.stage.mytest.belmahi.service.IVirementMulitpleBeneficiaireService;
import com.adria.stage.mytest.belmahi.service.IVirementService;


@Controller
@RequestMapping("/compte")
public class CompteController {
	
	@Autowired
	IAbonneService abonneService;
	
	@Autowired
	IVirementService virementService;
	
	@Autowired
	IVirementMulitpleBeneficiaireService virementMultipleBeneficiaireService;
	
	@Autowired
	ICompteService compteService;
	
	@Autowired
	HashCode passwordEncoder;

	
	@RequestMapping(value="/getUsername", method = RequestMethod.GET)
	public String printUser(ModelMap model) {

		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username
		
		System.out.println("username : "+username);

//		model.addAttribute("username", name);
		return "hello";

	}
	
	@RequestMapping("/virementMultiple")
	public String viewVirementMultiple(){
		System.out.println("you are here /virementMultiple");
		return "virementMulti";
	}
	

	
	@RequestMapping(value="/rest/getBeneficiaires", method = RequestMethod.GET, produces={"application/xml", "application/json"})
	public @ResponseBody ModelAndView getBeneficiairesAbonne(){
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username
		
		Abonne abonne = abonneService.getAbonneByUsername(username);
		
		List<Beneficiaire> beneficiaireList = new ArrayList<Beneficiaire>();
		beneficiaireList.addAll(abonne.getBeneficiares());
		
		ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
		mav.addObject(beneficiaireList);
		
		
		return mav;
	}
	
	
	@RequestMapping(value="/rest/getComptes", method = RequestMethod.GET, produces={"application/xml", "application/json"})
	public @ResponseBody ModelAndView getComptesAbonne(){
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username
		
		Abonne abonne = abonneService.getAbonneByUsername(username);
				
 		List<Compte> comptesList = new ArrayList<Compte>();
		comptesList.addAll(abonne.getComptes());
		
		ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
		mav.addObject(comptesList);
		
		return mav;
	}
	
	
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML})
	@RequestMapping(value="virmentMultiple/do", method = RequestMethod.POST)
	public @ResponseBody ModelAndView doVirementMultiple(@RequestBody final GenericVirementRequest genericVirementRequest){
		
		VirementMultiple virementMultiple = new VirementMultiple();
		
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username
		Abonne abonne = abonneService.getAbonneByUsername(username);
		
		virementMultiple.setAbonne(abonne);
		virementMultiple.setMontant(new BigDecimal(genericVirementRequest.getMontant()));
		virementMultiple.setMotif(genericVirementRequest.getMotif());
		virementMultiple.setNombreBenificiaires(genericVirementRequest.getBeneficiairesDuVirement().size());
		virementMultiple.setDateCreation(new Date());
		virementMultiple.setStatut(Virement.ENTREGISTRE);
		virementMultiple.setCompte(compteService.getCompte((long) genericVirementRequest.getIdCompte()));
        try {
        	// create SimpleDateFormat object with source string date format
            SimpleDateFormat sdfSource = new SimpleDateFormat(
                    "dd-mm-yyyy");
            // parse the string into Date object
			Date date = sdfSource.parse(genericVirementRequest.getDateExecution());
			virementMultiple.setDateExecution(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        virementMultiple = (VirementMultiple) virementService.addVirement(virementMultiple);
        System.out.println(virementMultiple.getIdVirement());
        virementMultipleBeneficiaireService.makeAllVirement(
        		virementMultipleBeneficiaireService.getListVirementMultipleBeneficiare(
        				genericVirementRequest.getBeneficiairesDuVirement(), virementMultiple));
        
		
		GenericVirementMultiDo genericVirementMultiDo = new GenericVirementMultiDo();
		genericVirementMultiDo.setMessage("Le virement multiple est bien éffectué Merci de le valide");
		genericVirementMultiDo.setSuccess(true);
		genericVirementMultiDo.setIdVirementMulti(virementMultiple.getIdVirement());
		ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
		mav.addObject(genericVirementMultiDo);

		return mav;
	}
	
	
	@RequestMapping(value="/consulterSigner/{idVirement}", method = RequestMethod.GET)
	public String consulterSigner(ModelMap model,@Description("id du virement") @PathVariable(value="idVirement") final Long idVirement) {
 
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username
		
		Abonne abonne = abonneService.getAbonneByUsername(username);
		
		System.out.println(idVirement);
		
		VirementMultiple virementMultiple = (VirementMultiple) virementService.getVirement(idVirement);
		
		
		if(virementMultiple != null && abonneService.virementProprietaire(abonne, virementMultiple.getIdVirement()) && virementMultiple.getStatut() == Virement.ENTREGISTRE){
			
			model.addAttribute("nomAbonne", abonne.fullName());
			model.addAttribute("virement", virementMultiple);
			List<BeneficiaireDuVirement> beneficiaireDuVirements = new ArrayList<BeneficiaireDuVirement>();
			for(VirementMultipleBeneficiare vB : virementMultiple.getVirementMultipleBeneficiares()){
				BeneficiaireDuVirement b = new BeneficiaireDuVirement(vB.getMontant(), vB.getBeneficiaire());
				beneficiaireDuVirements.add(b);
			}
			model.addAttribute("listBeneficiaire", beneficiaireDuVirements);
			
			
		}else{
			model.addAttribute("ErrorExist", true);
			model.addAttribute("Error","ce virement n\'existe pas ou vous n\'avez pas le droit de le consulter ou déja signé");
		}
		
		// you can add any Collection Objects to ModelMap
		// including JSON, String, Array, Map, List, etc...
		
		
		
		return "consulter-signer";
	}
	
	
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML})
	@RequestMapping(value="virmentMultiple/signer", method = RequestMethod.POST)
	public @ResponseBody ModelAndView signerVirementMultiple(@RequestBody final GenericComfirmationRequest genericComfirmationRequest){
		
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername(); // get logged in username
		
		Abonne abonne = abonneService.getAbonneByUsername(username);
		
		GenericResponse genericResponse = new GenericResponse();
		
		if(passwordEncoder.passwordVirefication(genericComfirmationRequest.getPassword(), abonne.getPassword())){
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		if(passwordEncoder.passwordVirefication(genericComfirmationRequest.getPassword(), abonne.getPassword())){
			
//			VirementMultiple virementMultiple = new VirementMultiple();
			
//			virementMultiple = (VirementMultiple) virementService.getVirement(genericComfirmationRequest.getIdVirement());
			
//			virementMultiple.setStatut(Virement.CONFIRME_SIGNE);
			virementService.comfirmerVirement(genericComfirmationRequest.getIdVirement());
			
			genericResponse.setSuccess(true);
			genericResponse.setMessage("Le virement été confirmé ...!");
			
			
		}else{
			genericResponse.setSuccess(false);
			genericResponse.setMessage("Mot de passe n'est pas correct");
		}
		
		
		
		
		ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
		mav.addObject(genericResponse);
		
		return mav;
	}
	
	
}
