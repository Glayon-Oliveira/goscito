package com.lmlasmo.gioscito.model.schema.field.type;

import java.util.Collection;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class EnumFieldType implements FieldType {

	private final FieldTypeConstant type = FieldTypeConstant.ENUM;
	private final Set<String> values;
	
	public EnumFieldType(Collection<String> values) {
		this.values = Set.copyOf(values);
	}
	
}
