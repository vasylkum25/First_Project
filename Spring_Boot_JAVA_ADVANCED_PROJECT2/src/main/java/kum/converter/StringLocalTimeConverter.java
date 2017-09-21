package kum.converter;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringLocalTimeConverter implements Converter<LocalTime, String>{

	@Override
	public String convert(LocalTime arg0) {
		return String.valueOf(arg0);
	}

}
 