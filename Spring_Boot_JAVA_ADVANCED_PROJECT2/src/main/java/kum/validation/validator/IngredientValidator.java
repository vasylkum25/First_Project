package kum.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import kum.repository.IngredientRepository;
import kum.validation.anotation.UniqueIngredient;

@Component
public class IngredientValidator implements ConstraintValidator<UniqueIngredient, String> {

	private final IngredientRepository ingredientRepository;
	
	
	public IngredientValidator(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	public void initialize(UniqueIngredient constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return !ingredientRepository.existsByName(arg0);
		
	}

}
