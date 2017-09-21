package kum.converter;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kum.entity.OpenClose;
import kum.repository.OpenCloseRepository;

@Component
public class OpenCloseConverter implements Converter<String, OpenClose> {

	private OpenCloseRepository repository;

	public OpenCloseConverter(OpenCloseRepository repository) {
		this.repository = repository;
	}

	@Override
	public OpenClose convert(String arg0) {
		return repository.findByTime(LocalTime.parse(arg0));
	
	}

}
