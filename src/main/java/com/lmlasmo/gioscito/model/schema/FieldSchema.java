package com.lmlasmo.gioscito.model.schema;

import java.util.Set;

import com.lmlasmo.gioscito.model.schema.constraints.FieldConstraint;
import com.lmlasmo.gioscito.model.schema.type.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class FieldSchema {

	private String name;
	private FieldType type;
	private boolean required;
	private boolean unique;
	private Object defaultValue;
	private Set<FieldConstraint> constraints;
	
}
