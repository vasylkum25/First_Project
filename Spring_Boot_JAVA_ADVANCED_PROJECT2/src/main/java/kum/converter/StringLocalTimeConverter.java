package kum.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringLocalTimeConverter implements Converter<LocalTime, String>{

	@Override
	public String convert(LocalTime arg0) {
		return arg0.format(DateTimeFormatter.ofPattern("HH:mm"));
	}

}
 