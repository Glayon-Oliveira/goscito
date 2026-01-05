package com.lmlasmo.gioscito.model.schema.parser.syntax.field.type;

import com.lmlasmo.gioscito.model.schema.field.type.FieldType;

public interface FieldTypeSyntaxParser {

	public boolean matches(String raw);
    public FieldType parse(String raw);
	
}
