package com.lmlasmo.gioscito.model.schema.parser.syntax.type;

import com.lmlasmo.gioscito.model.schema.type.FieldType;

public interface FieldTypeSyntaxParser {

	public boolean matches(String raw);
    public FieldType parse(String raw);
	
}
