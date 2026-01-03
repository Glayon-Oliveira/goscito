package com.lmlasmo.gioscito.model.schema.parser.syntax.constraint;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.constraints.FieldConstraint;
import com.lmlasmo.gioscito.model.schema.type.FieldType;
import com.lmlasmo.gioscito.model.schema.type.StringFieldType;

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
