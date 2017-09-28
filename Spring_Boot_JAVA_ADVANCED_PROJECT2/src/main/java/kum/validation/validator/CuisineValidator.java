package kum.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import kum.repository.CuisineRepository;
import kum.validation.anotation.UniqueCuisine;

@Component
public class CuisineValidator implements ConstraintValidator<UniqueCuisine, String>{

	private final CuisineRepository cuisineRepository;
	
	
	public CuisineValidator(CuisineRepository cuisineRepository) {
		this.cuisineRepository = cuisineRepository;
	}

	@Override
	public void initialize(UniqueCuisine constraintAnnotation) {}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return !cuisineRepository.existsByName(arg0);
	}

}
