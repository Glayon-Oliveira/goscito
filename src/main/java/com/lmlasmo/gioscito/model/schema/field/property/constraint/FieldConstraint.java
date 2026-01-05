package com.lmlasmo.gioscito.model.schema.field.property.constraint;

public interface FieldConstraint {

	public FieldConstraintType getConstraint();
	
	public void valid(Object value);
	
}
