package cybersoft.backend.java11.gira.utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorUtils {
	public static List<String> getErrorMessages(BindingResult result){
		List<String> messages = new LinkedList<>();
		List<ObjectError> errors = result.getAllErrors();
		
		for (ObjectError error : errors) {
			messages.add(error.getDefaultMessage());
		}
		
		return messages;
		
	}
	
	public static List<String> errorOf(String message){
		List<String> messages = new LinkedList<String>();
		messages.add(message);
		return messages;
	}
}
