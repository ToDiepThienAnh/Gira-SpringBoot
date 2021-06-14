package cybersoft.backend.java11.gira.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.backend.java11.gira.user.service.UserService;
import cybersoft.backend.java11.gira.user.validation.annotation.UniqueUserName;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {
	@Autowired
	private UserService _serivice;
	private String message;
	
	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		this.message = constraintAnnotation.message();
		
	}
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean isTakenUserName = _serivice.isTakenUsername(username);
		
		if(!isTakenUserName)
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
														.addConstraintViolation()
														.disableDefaultConstraintViolation();
		return false;
	}
	
}
