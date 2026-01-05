package com.lmlasmo.gioscito.model.schema.field.property;

import java.util.Set;

import com.lmlasmo.gioscito.model.schema.field.property.constraint.FieldConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ConstraintsProperty implements FieldProperty<Set<? extends FieldConstraint>>{
	
	private final FieldPropertyType type = FieldPropertyType.CONSTRAINTS;
	
	@EqualsAndHashCode.Exclude
	@NonNull 
	private final Set<? extends FieldConstraint> value;

}
