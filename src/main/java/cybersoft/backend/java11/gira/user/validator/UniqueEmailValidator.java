package cybersoft.backend.java11.gira.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.backend.java11.gira.user.service.UserService;
import cybersoft.backend.java11.gira.user.validation.annotation.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	@Autowired
	private UserService _serivice;
	private String message;
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		this.message = constraintAnnotation.message();
		
	}
	
	


	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		boolean isTakenEmail = _serivice.isTakenEmail(email);
		
		if(!isTakenEmail)
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
														.addConstraintViolation()
														.disableDefaultConstraintViolation();
		return false;
	}

}
