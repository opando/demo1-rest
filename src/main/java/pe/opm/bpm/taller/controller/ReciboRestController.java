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
import pe.opm.bpm.taller.model.Recibo;
import pe.opm.bpm.taller.service.DummyService;
import pe.opm.bpm.taller.service.FiscalizableService;



@RestController
public class ReciboRestController {
    
    @Autowired
    private DummyService service;
    
    @ApiOperation(value = "recibos", nickname = "obtenerRecibos")         
    @RequestMapping(value="/recibos",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Recibo> obtenerRecibos() {
    	
    	System.out.println("##### path : GET /obtenerRecibos ");
    	
    
    	
        return service.listaPagoRecibo();
    }
    

    
    
    @RequestMapping(value ="/pagosrecibo", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, String> debitar(@RequestBody Recibo recibo) {
    	
    	System.out.println("##### path : POST /pagarecibo ");
    	
    	System.out.println("##### param : recibo json : " + recibo);
    	
    	Map<String, String> map = new HashMap<String, String>();
    			map.put("idRecibo", service.pagarRecibo(recibo));
        return map;
    }
  
}
