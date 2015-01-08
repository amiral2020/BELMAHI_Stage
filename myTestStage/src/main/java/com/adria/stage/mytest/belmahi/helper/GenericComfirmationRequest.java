package com.adria.stage.mytest.belmahi.helper;

public class GenericComfirmationRequest {
	private Long idVirement;
	private String Password;
	
	
	public GenericComfirmationRequest() {
		super();
	}
	
	public Long getIdVirement() {
		return idVirement;
	}
	public void setIdVirement(Long idVirement) {
		this.idVirement = idVirement;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
