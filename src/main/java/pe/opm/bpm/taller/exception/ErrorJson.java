package pe.opm.bpm.taller.exception;

import java.io.Serializable;

public class ErrorJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -304659155746388091L;
	private String cod;
	private String msj;
	private String exc;
	
	public ErrorJson(){}
	
	public ErrorJson(String cod, String msj, String exc) {
		super();
		this.cod = cod;
		this.msj = msj;
		this.exc = exc;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMsj() {
		return msj;
	}
	public void setMsj(String msj) {
		this.msj = msj;
	}
	public String getExc() {
		return exc;
	}
	public void setExc(String exc) {
		this.exc = exc;
	}
	
	
	
}
