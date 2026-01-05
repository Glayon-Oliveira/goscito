package com.lmlasmo.gioscito.model.schema.parser.syntax.field.type;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.field.type.FieldType;
import com.lmlasmo.gioscito.model.schema.field.type.StructFieldType;

@Component
public class StructTypeSyntaxParser implements FieldTypeSyntaxParser {
	
	private static final Pattern PATTERN = Pattern.compile("^struct\\(\\s*([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\)$");

	@Override
	public boolean matches(String raw) {
		return raw != null && PATTERN.matcher(raw).matches();
	}

	@Override
	public FieldType parse(String raw) {
		String trimmed = raw.trim();
		
		int begin = trimmed.indexOf("(") + 1;
		int end = trimmed.length() - 1;
		
		String inner = trimmed.substring(begin, end).trim();
		return new StructFieldType(inner);
	}

}
