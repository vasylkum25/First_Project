package kum.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kum.entity.Ingredient;
import kum.repository.IngredientRepository;

@Component
public class IngredientConverter implements Converter<String, Ingredient> {

	private final IngredientRepository repository;

	public IngredientConverter(IngredientRepository repository) {
		this.repository = repository;
	}

	@Override
	public Ingredient convert(String arg0) {
		return repository.findByName(arg0);
	}
	
}
