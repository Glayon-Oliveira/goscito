package com.lmlasmo.gioscito.model.schema.field.property;

public interface FieldProperty<T> {

	public FieldPropertyType getType();
	
	public T getValue();
	
}
