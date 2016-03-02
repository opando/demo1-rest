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
import org.springframework.web.bind.annotation.RestController;

import pe.opm.bpm.taller.model.Fiscalizable;
import pe.opm.bpm.taller.service.FiscalizableService;



@RestController
@RequestMapping(value="/api")
public class FiscalizableRestController {
    
    @Autowired
    private FiscalizableService service;
    
    @ApiOperation(value = "obtenerFiscalizables", nickname = "obtenerFiscalizables")
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Fiscalizable.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})     
    @RequestMapping(value="/fiscalizables",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fiscalizable> obtenerFiscalizables() {
    	
    	System.out.println("##### path : GET /fiscalizables ");
    	
    
    	
        return service.listaFiscalizable();
    }
    
    @RequestMapping(value ="/fiscalizables/{idFiscalizable}", method = RequestMethod.GET)
    public Fiscalizable obtenerFiscalizablesxParametro(
    					@PathVariable String idFiscalizable,
    					@RequestParam(value="numRuc", required = false) String numRuc
    		    		) {
    	
    	System.out.println("##### path : GET /fiscalizables?numRuc= ");
    	System.out.println("##### param : numRuc : " + numRuc);
    	
    	
        return service.obtenerFiscalizable(numRuc);
    }
    
    
    @RequestMapping(value ="/fiscalizables", method = RequestMethod.POST)
    public int actualizarFiscalizables(@RequestBody Fiscalizable fiscalizable) {
    	
    	System.out.println("##### path : POST /auditoria/fiscalizables ");
    	
    	System.out.println("##### param : Fiscalizable json : " + fiscalizable);
    	
        return service.insertarFiscalizable(fiscalizable);
    }
    
    @RequestMapping(value ="/fiscalizables/{idFiscalizable}", method = RequestMethod.PUT)
    public int actualizarFiscalizables(@PathVariable String idFiscalizable, @RequestBody Fiscalizable fiscalizable) {
    	
    	System.out.println("##### path : PUT /fiscalizables/{idFiscalizable} ");
    	System.out.println("##### param : idFiscalizable : " + idFiscalizable);
    	System.out.println("##### param : Fiscalizable json : " + fiscalizable);
    	
        return service.actualizarFiscalizable(idFiscalizable, fiscalizable);
    }
    
    @RequestMapping(value ="/fiscalizables/{idFiscalizable}", method = RequestMethod.DELETE)
    public int eliminarFiscalizables(@PathVariable String idFiscalizable) {
    	
    	System.out.println("##### path : DELETE /fiscalizables/"+idFiscalizable);
    	
    	System.out.println("##### pathVariable : idFiscalizable  : " + idFiscalizable);
    	
        return service.eliminarFiscalizable(idFiscalizable);
    }
}
