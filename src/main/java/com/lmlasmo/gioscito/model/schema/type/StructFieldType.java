package com.lmlasmo.gioscito.model.schema.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class StructFieldType implements FieldType {
	
	private final FieldTypeConstant type = FieldTypeConstant.STRUCT;
	
	@NonNull private final String structName;

}
