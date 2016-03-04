package pe.opm.bpm.taller.model;

public class Debito {

	private String idCuenta;
	private Double montoDebito;
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	
	
	public Debito(){}
	public Debito(String idCuenta, Double montoDebito) {
		super();
		this.idCuenta = idCuenta;
		this.setMontoDebito(montoDebito);
	}
	public Double getMontoDebito() {
		return montoDebito;
	}
	public void setMontoDebito(Double montoDebito) {
		this.montoDebito = montoDebito;
	}
	
	
	
}
