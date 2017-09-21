package kum.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kum.entity.Cafe;
import kum.repository.CafeRepository;

@Component
public class CafeConverter implements Converter<String, Cafe> {

	private final CafeRepository repository;

	public CafeConverter(CafeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Cafe convert(String arg0) {
		return repository.findByName(arg0);
	}
	
	
	

}
