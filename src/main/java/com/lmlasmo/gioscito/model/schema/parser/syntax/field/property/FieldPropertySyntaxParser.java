package com.lmlasmo.gioscito.model.schema.parser.syntax.field.property;

import com.lmlasmo.gioscito.model.schema.field.property.FieldProperty;
import com.lmlasmo.gioscito.model.schema.field.type.FieldType;

public interface FieldPropertySyntaxParser<T extends FieldProperty<?>> {
	
	public boolean matches(String raw);
	
	public T parse(Object value, FieldType fieldType);
	
	public default boolean isGenericProperty() {
		return true;
	}

}
