package com.lmlasmo.gioscito.model.schema.field.property.constraint;

import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class MaxFieldConstraint implements FieldConstraint {

	private final FieldConstraintType constraint = FieldConstraintType.MAX;
	
	@NonNull
	@EqualsAndHashCode.Exclude	
	private final Long max;
	
	public void valid(Object value) {
		if(max == null) return;
		
		if(value instanceof Long valueNumber) {
			if(valueNumber > max) throw new ConstraintViolationException("Value '" + valueNumber + "' is greater than " + max);
		}else if(value instanceof Collection<?> valueCollection) {
			valueCollection.stream()
					.forEach(this::valid);
		}
	}
	
}
