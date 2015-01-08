package com.adria.stage.mytest.belmahi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adria.stage.mytest.belmahi.service.IAbonneService;
import com.adria.stage.mytest.belmahi.service.IBeneficiaireService;
import com.adria.stage.mytest.belmahi.service.ICompteService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class MyCastTest {
	
	@Autowired
	IAbonneService abonneService;
	
	@Autowired
	IBeneficiaireService beneficiaireService;
	
	@Autowired
	ICompteService compteService;
	
	@Test
	public void test() {
		try {
        	// create SimpleDateFormat object with source string date format
            SimpleDateFormat sdfSource = new SimpleDateFormat(
                    "dd-mm-yyyy");
            // parse the string into Date object
//			Date date = sdfSource.parse("Wed Jan 07 2015");
			Date date = sdfSource.parse("01-01-2015");
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
