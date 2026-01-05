package com.lmlasmo.gioscito.model.schema.parser.syntax.field.property.constraint;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.field.property.constraint.FieldConstraint;
import com.lmlasmo.gioscito.model.schema.field.type.FieldType;
import com.lmlasmo.gioscito.model.schema.field.type.StringFieldType;

@Component
public class SizeConstraintSyntaxParser implements FieldConstraintSyntaxParser {

	@Override
	public boolean matches(String raw, FieldType fieldType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FieldConstraint parse(String raw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FieldConstraint defaultConstraint(FieldType fieldType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Class<? extends FieldType>> getSupportedFieldTypes() {
		return Set.of(
				StringFieldType.class
				);
	}

}
