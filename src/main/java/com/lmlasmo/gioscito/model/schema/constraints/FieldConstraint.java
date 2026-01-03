package com.lmlasmo.gioscito.model.schema.constraints;

public interface FieldConstraint {

	public FieldConstraintType getConstraint();
	
	public void valid(Object value);
	
}
