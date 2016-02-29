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
//@RequestMapping("/fiscalizables")
public class FiscalizableRestController {


    
    @Autowired
    private FiscalizableService service;
    
    @RequestMapping(value="/fiscalizables",method = RequestMethod.GET)
    public List<Fiscalizable> obtenerFiscalizables() {
    	
    	System.out.println("##### path : GET /fiscalizables ");
    	
    
    	
        return service.listaFiscalizable();
    }
    
/*    @RequestMapping(value ="/fiscalizables", method = RequestMethod.GET)
    public Fiscalizable obtenerFiscalizablesxParametro(
    					@RequestParam(value="numRuc", required = false) String numRuc
    		    		) {
    	
    	System.out.println("##### path : GET /fiscalizables?numRuc= ");
    	System.out.println("##### param : numRuc : " + numRuc);
    	
    	
        return service.obtenerFiscalizable(numRuc);
    }*/
    
    
    @RequestMapping(value ="/fiscalizables", method = RequestMethod.POST)
    public int actualizarFiscalizables(@RequestBody Fiscalizable fiscalizable) {
    	
    	System.out.println("##### path : POST /auditoria/fiscalizables ");
    	
    	System.out.println("##### param : Fiscalizable json : " + fiscalizable);
    	
        return service.insertarFiscalizable(fiscalizable);
    }
    
    @RequestMapping(value ="/{idFiscalizable}", method = RequestMethod.PUT)
    public int actualizarFiscalizables(@PathVariable String idFiscalizable, @RequestBody Fiscalizable fiscalizable) {
    	
    	System.out.println("##### path : PUT /fiscalizables/{idFiscalizable} ");
    	System.out.println("##### param : idFiscalizable : " + idFiscalizable);
    	System.out.println("##### param : Fiscalizable json : " + fiscalizable);
    	
        return service.actualizarFiscalizable(idFiscalizable, fiscalizable);
    }
    
    @RequestMapping(value ="/{idFiscalizable}", method = RequestMethod.DELETE)
    public int eliminarFiscalizables(@PathVariable String idFiscalizable) {
    	
    	System.out.println("##### path : DELETE /fiscalizables/"+idFiscalizable);
    	
    	System.out.println("##### pathVariable : idFiscalizable  : " + idFiscalizable);
    	
        return service.eliminarFiscalizable(idFiscalizable);
    }
}
