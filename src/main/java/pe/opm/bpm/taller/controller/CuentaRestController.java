package pe.opm.bpm.taller.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import pe.opm.bpm.taller.model.Cuenta;
import pe.opm.bpm.taller.model.Debito;
import pe.opm.bpm.taller.model.Fiscalizable;
import pe.opm.bpm.taller.service.DummyService;
import pe.opm.bpm.taller.service.FiscalizableService;



@RestController
public class CuentaRestController {
    
    @Autowired
    private DummyService service;
    
    @ApiOperation(value = "cuentas", nickname = "obtenercuentas")         
    @RequestMapping(value="/cuentas",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cuenta> obtenerCuentas() {
    	
    	System.out.println("##### path : GET /cuentas ");
    	
    
    	
        return service.listaCuenta();
    }
    

    
    
    @RequestMapping(value ="/debitar", method = RequestMethod.POST
    		,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, String> debitar(@RequestBody Debito debito) throws Exception {
    	
    	System.out.println("##### path : POST /debitar ");
    	
    	System.out.println("##### param : debitar json : " + debito);
    	
    	Map<String, String> map = new HashMap<String, String>();
		map.put("idCuenta", service.actualizarCuenta(debito));
		
        return map ;
    }
    
    @RequestMapping(value ="/extornar", method = RequestMethod.POST
    		,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, String> extorno(@RequestBody Debito debito) throws Exception {
    	
    	System.out.println("##### path : POST /debitar ");
    	
    	System.out.println("##### param : debitar json : " + debito);
    	
    	Map<String, String> map = new HashMap<String, String>();
		map.put("idCuenta", service.extornoCuenta(debito));
		
        return map ;
    }
  
}
