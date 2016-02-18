package pe.opm.bpm.taller.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.opm.bpm.taller.model.Fiscalizable;
import pe.opm.bpm.taller.service.FiscalizableService;



@RestController
@RequestMapping("/auditoria/fiscalizables")
public class FiscalizableRestController {

    
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private FiscalizableService service;
    

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Fiscalizable> listaFiscalizables() {
//    	System.out.println("##### GET path : /auditoria/fiscalizables | date " + new Date());
//        return service.listaFiscalizable();
//    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Fiscalizable> obtenerFiscalizablesFields(@RequestParam(value="f", required = false) String fields) {
    	
    	System.out.println("##### path : GET /auditoria/fiscalizables ");
    	
    	System.out.println("##### param : f : " + fields);
    	
        return service.listaFiscalizable();
    }
    
    @RequestMapping(value ="/{ruc}", method = RequestMethod.GET)
    public Fiscalizable obtenerFiscalizablesxParametro(@PathVariable String ruc, 
    		    		@RequestParam(value="intendencia", required = false) String intendencia,
    		    		@RequestParam(value="domicilioBloqueado", required = false) Boolean domicilioBloqueado,
    		    		@RequestParam(value="tipoContribuyente", required = false) String tipoContribuyente) {
    	
    	System.out.println("##### path : GET /auditoria/fiscalizables/{ruc}?intendencia=&domicilioBloqueado= ");
    	System.out.println("##### param : ruc : " + ruc);
    	System.out.println("##### param - intendencia : " + intendencia);
    	System.out.println("##### param - domicilioBloqueado : " + domicilioBloqueado);
    	
        return service.obtenerFiscalizable(ruc);
    }
    
    
    @RequestMapping( method = RequestMethod.POST)
    public int actualizarFiscalizables(@RequestBody Fiscalizable f) {
    	
    	System.out.println("##### path : POST /auditoria/fiscalizables ");
    	
    	System.out.println("##### param : Fiscalizable json : " + f);
    	
        return service.insertarFiscalizable(f);
    }
    
    @RequestMapping(value ="/{ruc}", method = RequestMethod.PUT)
    public int actualizarFiscalizables(@PathVariable String ruc, @RequestBody Fiscalizable f) {
    	
    	System.out.println("##### path : PUT /auditoria/fiscalizables/{ruc} ");
    	System.out.println("##### param : ruc : " + ruc);
    	System.out.println("##### param : Fiscalizable json : " + f);
    	
        return service.actualizarFiscalizable(ruc, f);
    }
    
    @RequestMapping(value ="/{ruc}", method = RequestMethod.DELETE)
    public int eliminarFiscalizables(@PathVariable String ruc) {
    	
    	System.out.println("##### path : DELETE /auditoria/fiscalizables/"+ruc);
    	
    	System.out.println("##### pathVariable : ruc  : " + ruc);
    	
        return service.eliminarFiscalizable(ruc);
    }
}
