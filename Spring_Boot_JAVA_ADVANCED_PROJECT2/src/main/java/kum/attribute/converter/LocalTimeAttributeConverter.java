package kum.attribute.converter;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time>{

	LocalTime time = LocalTime.parse("09:00", DateTimeFormatter.ISO_LOCAL_TIME);
	
	@Override
	public Time convertToDatabaseColumn(LocalTime arg0) {
		return arg0==null?null:Time.valueOf(arg0) ;
	}

	@Override
	public LocalTime convertToEntityAttribute(Time arg0) {
		return arg0==null?null:arg0.toLocalTime();
	}

}
