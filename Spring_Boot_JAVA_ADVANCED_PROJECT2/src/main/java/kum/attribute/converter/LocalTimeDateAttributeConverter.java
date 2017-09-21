package kum.attribute.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeDateAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime time) {
		return time == null ? null : Timestamp.valueOf(time);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp time) {
		return time == null ? null : time.toLocalDateTime();
	}
	
}