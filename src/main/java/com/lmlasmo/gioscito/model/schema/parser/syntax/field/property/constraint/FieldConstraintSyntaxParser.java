package com.lmlasmo.gioscito.model.schema.parser.syntax.field.property.constraint;

import java.util.Set;

import com.lmlasmo.gioscito.model.schema.field.property.constraint.FieldConstraint;
import com.lmlasmo.gioscito.model.schema.field.type.FieldType;

public interface FieldConstraintSyntaxParser {

	public boolean matches(String raw, FieldType fieldType);
	
	public FieldConstraint parse(String raw);
	
	public FieldConstraint defaultConstraint(FieldType fieldType);
	
	public Set<Class<? extends FieldType>> getSupportedFieldTypes();
	
	public default boolean supports(FieldType field) {
		return getSupportedFieldTypes().stream()
				.anyMatch(c -> c.isAssignableFrom(field.getClass()));
	}
	
}
