package com.lmlasmo.gioscito.model.schema.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class StringFieldType implements FieldType {
	
	private final FieldTypeConstant type = FieldTypeConstant.STRING;

}
