package pe.opm.bpm.taller.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import pe.opm.bpm.taller.model.Auditor;
import pe.opm.bpm.taller.model.Fiscalizable;

@Service
public class FiscalizableServiceImpl implements FiscalizableService {

	public static Map<String, Fiscalizable> fiscalizables
	; 
	public static Map<String, Auditor> auditores; 
		
	public List<Fiscalizable> listaFiscalizable() {
		// TODO Auto-generated method stub
		return new ArrayList<Fiscalizable>(fiscalizables.values());
	}

	public Fiscalizable obtenerFiscalizable(String idFiscalizable) {
		// TODO Auto-generated method stub
		return fiscalizables.get(idFiscalizable);
	}
	
	public String actualizarFiscalizable(String idFiscalizable, Fiscalizable f) {
		// TODO Auto-generated method stub
		f.setIdFiscalizable(idFiscalizable);
		
		fiscalizables.put(idFiscalizable, f);
		
		return f.getIdFiscalizable();
	}


	public String insertarFiscalizable(Fiscalizable f) {
		// TODO Auto-generated method stub
		fiscalizables.put(f.getIdFiscalizable(), f);
		return f.getIdFiscalizable();
	}

	
	public List<Auditor> listaAuditores() {
				
		return new ArrayList<Auditor>(auditores.values());
	}

	public List<Auditor> listaAuditores(String supervision) {
		// TODO Auto-generated method stub
		
		List<Auditor> lista = new ArrayList<Auditor>(auditores.values());
		List<Auditor> listaTemp = new ArrayList<Auditor>();
		
		for (int i = 0; i < lista.size(); i++) {
			Auditor a = lista.get(i);
			
			if(a.getSupervision().equalsIgnoreCase(supervision))
				listaTemp.add( a );
						
		}
		
		Map<String, Auditor> map;
		
		if(listaTemp.size()==0){
			map = getAuditores(supervision);
			auditores.putAll(map);
			return new ArrayList<Auditor>(map.values());
		}else{
			return listaTemp;
		}
		
	}
	
	
	public static int n = 0;
	static
    {
		fiscalizables = new HashMap<String, Fiscalizable>();
		fiscalizables.put("1", new Fiscalizable("1","10312345678", "SagaFallabella", "REG.LIMA", new Auditor(), "PERSONA JURIDICA", "JR XYZ", true));
		fiscalizables.put("2", new Fiscalizable("2","10434512334", "SODIMAC SAC", "REG.AQP", new Auditor(), "PERSONA JURIDICA", "JR XYZ", false));
		fiscalizables.put("3", new Fiscalizable("3","10312345456", "IBK", "REG.LIMA", new Auditor(), "PERSONA JURIDICA", "JR XYZ", true));
		fiscalizables.put("4", new Fiscalizable("4","10312345654", "Juan Reyes", "REG.LIMA", new Auditor(), "PERSONA NATURAL", "AV. ERD 352", false));
		fiscalizables.put("5", new Fiscalizable("5","10312345789", "BBVA", "REG.LIMA", new Auditor(), "PERSONA JURIDICA", "JR XYZ", true));
		fiscalizables.put("6", new Fiscalizable("6","10312345890", "RIPLEY SAC", "REG.AQP", new Auditor(), "PERSONA JURIDICA", "JR XYZ", true));
		fiscalizables.put("7", new Fiscalizable("7","10312345423", "ALICORP", "REG.LIMA", new Auditor(), "PERSONA JURIDICA", "JR XYZ", true));
		fiscalizables.put("8", new Fiscalizable("8","10312345157", "HSBC", "REG.AQP", new Auditor(), "PERSONA JURIDICA", "JR XYZ", false));
		
		auditores = new HashMap<String, Auditor>();
		auditores.putAll( getAuditores("REG.LIMA.SUP1") );
		auditores.putAll( getAuditores("REG.AQP.SUP1") );
		
		
    }
	
	private static Map<String, Auditor> getAuditores(String supervision) {
		
		int na = (int) (Math.random() * 10) +1;
		String[] nom = new String[]{"Juan","Carlos","Ricardo","Jose","Luis"};
		String[] ape = new String[]{"Guerra","Ramirez","Mazza","Chavez",
									"Becerra","Sosaya","Cardenas","Izaquirre","Caceres","Lujan"};
		
		Map<String, Auditor> map = new HashMap<String, Auditor>();
		
		for(int i = 0 ; i<na ; i++){
			
			String nr = (int) (Math.random() * 100) +"";
			String nroRegistro = "QW" + nr;
			if(!auditores.containsKey(nroRegistro))
			map.put("QW", new Auditor(nroRegistro, nom[((int) (Math.random() * 100))%5], 
					ape[((int) (Math.random() * 100))%10], ape[((int) (Math.random() * 100))%10], 
					supervision, (int) (Math.random() * 10) ));
		}
		
		return map;
	}

	@Override
	public int eliminarFiscalizable(String idFiscalizable) {
		// TODO Auto-generated method stub
		fiscalizables.remove(idFiscalizable);
		return 0;
	}
}
