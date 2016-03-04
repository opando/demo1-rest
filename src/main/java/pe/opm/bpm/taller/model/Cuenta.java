package pe.opm.bpm.taller.model;

public class Cuenta {

	private String idCuenta;
	private Double saldo;
	
	
	public Cuenta(String idCuenta, Double saldo) {
		super();
		this.idCuenta = idCuenta;
		this.saldo = saldo;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
