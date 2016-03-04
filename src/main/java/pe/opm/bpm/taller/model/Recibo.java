package pe.opm.bpm.taller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Recibo {

	
	private String idRecibo;
	private Double monto;
	
	
	private String estado;
	
	public Recibo(){}
	
	public Recibo(String idRecibo, Double monto, String estado) {
		super();
		this.idRecibo = idRecibo;
		this.monto = monto;
		this.estado = estado;
	}
	public String getIdRecibo() {
		return idRecibo;
	}
	public void setIdRecibo(String idRecibo) {
		this.idRecibo = idRecibo;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
