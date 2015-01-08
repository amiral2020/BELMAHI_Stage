package com.adria.stage.mytest.belmahi.response;

public class GenericVirementMultiDo {
	private boolean success;
	private String message;
	
	private Long idVirementMulti;
	
	public Long getIdVirementMulti() {
		return idVirementMulti;
	}
	public void setIdVirementMulti(Long idVirementMulti) {
		this.idVirementMulti = idVirementMulti;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
