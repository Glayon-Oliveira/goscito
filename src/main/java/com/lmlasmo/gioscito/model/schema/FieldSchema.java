package com.lmlasmo.gioscito.model.schema;

import java.util.Set;

import com.lmlasmo.gioscito.model.schema.field.property.FieldProperty;
import com.lmlasmo.gioscito.model.schema.field.type.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class FieldSchema {

	private String name;
	
	private FieldType type;
	
	private Set<FieldProperty<?>> properties;
	
}
