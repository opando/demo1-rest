package pe.opm.bpm.taller.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import pe.opm.bpm.taller.model.Auditor;
import pe.opm.bpm.taller.model.Cuenta;
import pe.opm.bpm.taller.model.Debito;
import pe.opm.bpm.taller.model.Fiscalizable;
import pe.opm.bpm.taller.model.Recibo;

@Service
public class DummyServiceImpl implements DummyService {

	public static Map<String, Cuenta> cuentas;

	public static Map<String, Recibo> recibos; 
		

	
	
	public static int n = 0;
	static
    {
		cuentas = new HashMap<String, Cuenta>();
		cuentas.put("1", new Cuenta("1",100000.00));
		cuentas.put("2", new Cuenta("2",200000.00));
		cuentas.put("3", new Cuenta("3",300000.00));
				
		recibos = new HashMap<String, Recibo>();
		recibos.put("R01",new Recibo("R01",1000.00 , "0") );
		recibos.put("R02",new Recibo("R02",500.00 , "0") );
		
		
    }
	

	@Override
	public List<Cuenta> listaCuenta() {
		// TODO Auto-generated method stub
		return new ArrayList<Cuenta>(cuentas.values());
	}

	@Override
	public Cuenta obtenerCuenta(String idCuenta) {
		// TODO Auto-generated method stub
		return cuentas.get(idCuenta);
	}

	@Override
	public String actualizarCuenta(Debito debito) {
		
		
		Cuenta c = obtenerCuenta(debito.getIdCuenta());
		
		c.setSaldo( c.getSaldo() - debito.getMontoDebito()  );
		
		
		cuentas.put(c.getIdCuenta(), c);
		
		return c.getIdCuenta();	
	}

	@Override
	public List<Recibo> listaPagoRecibo() {
		// TODO Auto-generated method stub
		return new ArrayList<Recibo>(recibos.values());
	}

	@Override
	public Recibo obtenerRecibo(String idRecibo) {
		// TODO Auto-generated method stub
		return recibos.get(idRecibo);
	}

	@Override
	public String actualizarRecibo(String idRecibo, Recibo recibo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String pagarRecibo(Recibo recibo) {
		
		Recibo r = obtenerRecibo(recibo.getIdRecibo());
		
		if (Double.compare(r.getMonto(),0.0000)>0) {
			r.setMonto( r.getMonto() - recibo.getMonto()  );
			
			if (Double.compare(0.0000, r.getMonto())<0) {
				r.setEstado("1");
			}
		}
		
		
		
		
		
		recibos.put(r.getIdRecibo(), r);
		
		System.out.println("$$$$$$$$$$$$$$" + r.getMonto());
		return r.getIdRecibo();
	}
}
