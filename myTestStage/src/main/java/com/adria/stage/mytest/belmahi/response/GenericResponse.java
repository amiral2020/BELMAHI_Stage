package com.adria.stage.mytest.belmahi.response;

import com.adria.stage.mytest.belmahi.model.Abonne;

public class GenericResponse {
	private boolean success;
	private String message;
	private Abonne abonne;
	
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
	public Abonne getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}
	
	
	
	
}
