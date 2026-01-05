package com.lmlasmo.gioscito.model.schema.parser.syntax.field.type;

import java.util.regex.Pattern;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.field.type.ArrayFieldType;
import com.lmlasmo.gioscito.model.schema.field.type.FieldType;
import com.lmlasmo.gioscito.model.schema.parser.FieldTypeParser;

@Component
public class ArrayTypeSyntaxParser implements FieldTypeSyntaxParser {
	
	private static final Pattern PATTERN = Pattern.compile("^.+\\[\\]$");
		
	private final FieldTypeParser mainParser;
	
	@Lazy
	public ArrayTypeSyntaxParser(FieldTypeParser mainParser) {
		this.mainParser = mainParser;
	}

	@Override
	public boolean matches(String raw) {
		return raw != null && PATTERN.matcher(raw).matches();
	}

	@Override
	public FieldType parse(String raw) {
		String trimmed = raw.trim();
		String inner = trimmed.substring(0, trimmed.length() - 2).trim();
		
		FieldType subtype = mainParser.parse(inner);
		
        return new ArrayFieldType(subtype);
	}

}
