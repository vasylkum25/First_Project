package kum.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kum.entity.Cuisine;
import kum.repository.CuisineRepository;

@Component
public class CuisineConverter implements Converter<String, Cuisine> {

	private final CuisineRepository repository;

	public CuisineConverter(CuisineRepository repository) {
		this.repository = repository;
	}

	@Override
	public Cuisine convert(String arg0) {
		return repository.findByName(arg0);
	}
	
	
	

}
