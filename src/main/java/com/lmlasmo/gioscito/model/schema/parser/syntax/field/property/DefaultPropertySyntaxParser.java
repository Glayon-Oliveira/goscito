package com.lmlasmo.gioscito.model.schema.parser.syntax.field.property;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.field.property.DefaultProperty;
import com.lmlasmo.gioscito.model.schema.field.type.FieldType;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Component
public class DefaultPropertySyntaxParser implements FieldPropertySyntaxParser<DefaultProperty> {
	
	private static final Pattern PATTERN = Pattern.compile("^default$");
	
	@Override
	public boolean matches(String raw) {
		return raw != null && PATTERN.matcher(raw).matches();
	}

	@Override
	public DefaultProperty parse(Object value, FieldType fieldType) {
		if(value == null) return new DefaultProperty(null);
		
		return new DefaultProperty(value);
	}

}
