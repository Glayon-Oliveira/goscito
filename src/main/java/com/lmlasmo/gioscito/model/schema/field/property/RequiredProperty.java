package com.lmlasmo.gioscito.model.schema.field.property;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class RequiredProperty implements FieldProperty<Boolean> {

	private final FieldPropertyType type = FieldPropertyType.REQUIRED;
	
	@EqualsAndHashCode.Exclude
	@NonNull
	private final Boolean value;
	
}
