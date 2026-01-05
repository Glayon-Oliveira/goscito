package com.lmlasmo.gioscito.model.schema.parser.syntax.field.type;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.field.type.FieldType;
import com.lmlasmo.gioscito.model.schema.field.type.StringFieldType;

@Component
public class StringTypeSyntaxParser implements FieldTypeSyntaxParser {
	
	private static final Pattern PATTERN = Pattern.compile("^string$");

	@Override
	public boolean matches(String raw) {
		return raw != null && PATTERN.matcher(raw).matches();
	}

	@Override
	public FieldType parse(String raw) {
		return new StringFieldType(); 
	}

}
