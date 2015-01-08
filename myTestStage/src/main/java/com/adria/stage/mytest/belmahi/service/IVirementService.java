package com.adria.stage.mytest.belmahi.service;

import com.adria.stage.mytest.belmahi.model.Virement;

public interface IVirementService {
	public Virement getVirement(Long idVirement);
	public Virement addVirement(Virement virement);
	public void updateVirement(Virement virement);
	public void comfirmerVirement(Long IdVirement);
	
}
