package com.adria.stage.mytest.belmahi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adria.stage.mytest.belmahi.model.Virement;
import com.adria.stage.mytest.belmahi.repository.IVirementDao;

@Service("iVirementService")
public class VirementServiceImpl implements IVirementService {
	
	@Autowired
	IVirementDao dao;
	
	@Override
	public Virement getVirement(Long idVirement) {
		return dao.getVirement(idVirement);
	}

	@Override
	public Virement addVirement(Virement virement) {
		return dao.addVirement(virement);
	}

	@Override
	public void updateVirement(Virement virement) {
		dao.updateVirement(virement);
	}

	@Override
	public void comfirmerVirement(Long IdVirement) {
		dao.comfirmerVirement(IdVirement);
	}

}
