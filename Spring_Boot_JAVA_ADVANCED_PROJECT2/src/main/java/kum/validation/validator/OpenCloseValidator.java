package kum.validation.validator;

import java.time.LocalTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import kum.entity.OpenClose;
import kum.repository.OpenCloseRepository;
import kum.validation.anotation.UniqueOpenClose;

@Component
public class OpenCloseValidator implements ConstraintValidator<UniqueOpenClose, String> {

	private final OpenCloseRepository openRepository;
	
	
	
	public OpenCloseValidator(OpenCloseRepository openRepository) {
		this.openRepository = openRepository;
	}

	@Override
	public void initialize(UniqueOpenClose arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
	if(arg0.matches("^[0-9]:[0-5][0-9]$")) arg0="0"+arg0;
		if(!arg0.isEmpty()){
			OpenClose time = openRepository.findByTime(LocalTime.parse(arg0));
		if(time!=null){
		return false;
				}else return true;
							}return true;
	}

}











