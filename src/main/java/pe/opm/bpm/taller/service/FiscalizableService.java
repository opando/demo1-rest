package pe.opm.bpm.taller.service;

import java.util.List;

import pe.opm.bpm.taller.model.Auditor;
import pe.opm.bpm.taller.model.Fiscalizable;

public interface FiscalizableService {

	public List<Fiscalizable> listaFiscalizable() ;
	
	public Fiscalizable obtenerFiscalizable(String idFiscalizable);
	
	public String actualizarFiscalizable(String idFiscalizable, Fiscalizable f) ;

	public String insertarFiscalizable(Fiscalizable f);

	public List<Auditor> listaAuditores();

	public int eliminarFiscalizable(String idFiscalizable);
}
