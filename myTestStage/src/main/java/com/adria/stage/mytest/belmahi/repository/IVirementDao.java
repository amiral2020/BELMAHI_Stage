package com.adria.stage.mytest.belmahi.repository;

import com.adria.stage.mytest.belmahi.model.Virement;

public interface IVirementDao {
	public Virement getVirement(Long idVirement);
	public Virement addVirement(Virement virement);
	public void updateVirement(Virement virement);
	
	public void comfirmerVirement(Long IdVirement);
}
