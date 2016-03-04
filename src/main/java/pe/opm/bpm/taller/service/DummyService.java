package pe.opm.bpm.taller.service;

import java.util.List;
import java.util.Map;

import pe.opm.bpm.taller.model.Cuenta;
import pe.opm.bpm.taller.model.Debito;
import pe.opm.bpm.taller.model.Recibo;

public interface DummyService {

	public List<Cuenta> listaCuenta() ;
	
	public Cuenta obtenerCuenta(String idCuenta);
	
	public String actualizarCuenta(Debito  debito) ;

	public List<Recibo> listaPagoRecibo() ;
	
	public Recibo obtenerRecibo(String idRecibo);
	
	public String actualizarRecibo(String idRecibo, Recibo recibo) ;

	public String pagarRecibo(Recibo recibo);
}
