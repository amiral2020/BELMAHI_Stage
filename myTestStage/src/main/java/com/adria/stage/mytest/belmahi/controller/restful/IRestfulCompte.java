package com.adria.stage.mytest.belmahi.controller.restful;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import com.adria.stage.mytest.belmahi.model.Beneficiaire;

@Path("/compte")
public interface IRestfulCompte {
	
	@GET
	@Description(value = "Resource", target = DocTarget.RESOURCE)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Path(value="/rest/getBeneficiaires")
	public Set<Beneficiaire> getBeneficiairesAbonne();
}
