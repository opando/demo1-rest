package pe.opm.bpm.taller.service;

import java.util.List;
import java.util.Map;

import pe.opm.bpm.taller.model.Cuenta;
import pe.opm.bpm.taller.model.Debito;
import pe.opm.bpm.taller.model.Recibo;

public interface DummyService {

	public List<Cuenta> listaCuenta() ;
	
	public Cuenta obtenerCuenta(String idCuenta) throws Exception;
	
	public String actualizarCuenta(Debito  debito) throws Exception ;
	
	public String extornoCuenta(Debito debito) throws Exception ;

	public List<Recibo> listaPagoRecibo() ;
	
	public Recibo obtenerRecibo(String idRecibo) throws Exception;
	
	public String actualizarRecibo(String idRecibo, Recibo recibo) throws Exception;

	public String pagarRecibo(Recibo recibo) throws Exception;
}
