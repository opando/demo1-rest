package pe.opm.bpm.taller.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.opm.bpm.taller.model.Fiscalizable;
import pe.opm.bpm.taller.service.FiscalizableService;



@RestController
public class FiscalizableRestController {
    
    @Autowired
    private FiscalizableService service;
    
    @ApiOperation(value = "obtenerFiscalizables", nickname = "obtenerFiscalizables")         
    @RequestMapping(value="/fiscalizables",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fiscalizable> obtenerFiscalizables() {
    	
    	System.out.println("##### path : GET /fiscalizables ");
    	
    
    	
        return service.listaFiscalizable();
    }
    
    @RequestMapping(value ="/fiscalizables/{idFiscalizable}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Fiscalizable obtenerFiscalizablesxParametro(
    					@PathVariable String idFiscalizable
    		    		) {
    	
    	System.out.println("##### path : GET /fiscalizables , idFiscalizable= " + idFiscalizable);
    	
    	
    	
        return service.obtenerFiscalizable(idFiscalizable);
    }
    
    
    @RequestMapping(value ="/fiscalizables", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String actualizarFiscalizables(@RequestBody Fiscalizable fiscalizable) {
    	
    	System.out.println("##### path : POST /auditoria/fiscalizables ");
    	
    	System.out.println("##### param : Fiscalizable json : " + fiscalizable);
    	
        return service.insertarFiscalizable(fiscalizable);
    }
    
    @RequestMapping(value ="/fiscalizables/{idFiscalizable}", method = RequestMethod.PUT
    		,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String actualizarFiscalizables(@PathVariable String idFiscalizable, @RequestBody Fiscalizable fiscalizable) {
    	
    	System.out.println("##### path : PUT /fiscalizables/{idFiscalizable} ");
    	System.out.println("##### param : idFiscalizable : " + idFiscalizable);
    	System.out.println("##### param : Fiscalizable json : " + fiscalizable);
    	
        return service.actualizarFiscalizable(idFiscalizable, fiscalizable);
    }
    
    @RequestMapping(value ="/fiscalizables/{idFiscalizable}", method = RequestMethod.DELETE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public int eliminarFiscalizables(@PathVariable String idFiscalizable) {
    	
    	System.out.println("##### path : DELETE /fiscalizables/"+idFiscalizable);
    	
    	System.out.println("##### pathVariable : idFiscalizable  : " + idFiscalizable);
    	
        return service.eliminarFiscalizable(idFiscalizable);
    }
}
