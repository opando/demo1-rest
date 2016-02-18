package pe.opm.bpm.taller.model;

public class Auditor {

	public Auditor(){
		
		this.nroRegistro = "";
		this.nombre = "";
		this.apePat = "";
		this.apeMat = "";
		this.supervision = "";
		this.nroCasos = 0;
	}
	
	public Auditor(String nroRegistro, String nombre, String apePat,
			String apeMat, String supervision, Integer nroCasos) {
		super();
		this.nroRegistro = nroRegistro;
		this.nombre = nombre;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.supervision = supervision;
		this.nroCasos = nroCasos;
	}

	private String nroRegistro;

	private String nombre;
	
	private String apePat;
	
	public String getNroRegistro() {
		return nroRegistro;
	}

	public void setNroRegistro(String nroRegistro) {
		this.nroRegistro = nroRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getSupervision() {
		return supervision;
	}

	public void setSupervision(String supervision) {
		this.supervision = supervision;
	}

	public Integer getNroCasos() {
		return nroCasos;
	}

	public void setNroCasos(Integer nroCasos) {
		this.nroCasos = nroCasos;
	}

	private String apeMat;
	
	private String supervision;
	
	private Integer nroCasos;
}
