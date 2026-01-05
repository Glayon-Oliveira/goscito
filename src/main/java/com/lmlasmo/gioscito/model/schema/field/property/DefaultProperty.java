package com.lmlasmo.gioscito.model.schema.field.property;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class DefaultProperty implements FieldProperty<Object> {
	
	private final FieldPropertyType type = FieldPropertyType.DEFAULT;
	
	@EqualsAndHashCode.Exclude
	private final Object value;
	
}
