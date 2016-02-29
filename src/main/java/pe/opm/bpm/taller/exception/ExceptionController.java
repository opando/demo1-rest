package pe.opm.bpm.taller.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorJson handler(HttpRequestMethodNotSupportedException e ,  HttpServletRequest req,  HttpServletResponse res){
				
		ErrorJson json = new ErrorJson(HttpStatus.NOT_FOUND.toString(),"Error",ExceptionUtils.getStackTrace(e));		
		return json;			
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public @ResponseBody ErrorJson handlerHttpMetholdNotSupported(HttpRequestMethodNotSupportedException e ,  HttpServletRequest req,  HttpServletResponse res){
				
		ErrorJson json = new ErrorJson(HttpStatus.METHOD_NOT_ALLOWED.toString(),"Error",ExceptionUtils.getStackTrace(e));		
		return json;			
	}
	
	
	/*
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorJson handlerThrowable(Throwable t ,  HttpServletRequest req,  HttpServletResponse res){
				
		ErrorJson json = new ErrorJson("500","Error",ExceptionUtils.getStackTrace(t));		
		return json;			
	}*/
}
