package pe.opm.bpm.taller.model;

import io.swagger.annotations.ApiModelProperty;

public class Fiscalizable {
	
	private String idFiscalizable;
	private String ruc;

	private String razonSocial;
	
	private String intendencia;
	
	private Auditor auditor;
	
	private String tipoContribuyente;
	
	private String direccion;
	
	private Boolean domicilioBloqueado;

	public Fiscalizable(){}
	
	public Fiscalizable(String idFiscalizable, String ruc, String razonSocial, String intendencia,
			Auditor auditor, String tipoContribuyente, String direccion,
			Boolean domicilioBloqueado) {
		super();
		this.setIdFiscalizable(idFiscalizable);
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.intendencia = intendencia;
		this.auditor = auditor;
		this.tipoContribuyente = tipoContribuyente;
		this.direccion = direccion;
		this.domicilioBloqueado = domicilioBloqueado;
	}

	public String getRuc() {
		return ruc;
	}

	@ApiModelProperty(notes = "numero ruc", required = false)
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getIntendencia() {
		return intendencia;
	}

	public void setIntendencia(String intendencia) {
		this.intendencia = intendencia;
	}

	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

	public String getTipoContribuyente() {
		return tipoContribuyente;
	}

	public void setTipoContribuyente(String tipoContribuyente) {
		this.tipoContribuyente = tipoContribuyente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getDomicilioBloqueado() {
		return domicilioBloqueado;
	}

	public void setDomicilioBloqueado(Boolean domicilioBloqueado) {
		this.domicilioBloqueado = domicilioBloqueado;
	}

	public String getIdFiscalizable() {
		return idFiscalizable;
	}

	public void setIdFiscalizable(String idFiscalizable) {
		this.idFiscalizable = idFiscalizable;
	}
	
}
