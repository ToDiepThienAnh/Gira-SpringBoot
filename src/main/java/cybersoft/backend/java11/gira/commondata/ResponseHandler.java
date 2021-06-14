package cybersoft.backend.java11.gira.commondata;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cybersoft.backend.java11.gira.utils.ErrorUtils;
import cybersoft.backend.java11.gira.utils.ListUtils;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object content, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		map.put("message", ListUtils.emptyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(BindingResult errors, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ErrorUtils.getErrorMessages(errors));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(String errors, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ErrorUtils.errorOf(errors));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ListUtils.emptyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
}
