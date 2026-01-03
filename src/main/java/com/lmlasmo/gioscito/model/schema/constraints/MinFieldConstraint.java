package com.lmlasmo.gioscito.model.schema.constraints;

import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class MinFieldConstraint implements FieldConstraint {
		
	private final FieldConstraintType constraint = FieldConstraintType.MIN;
		
	@EqualsAndHashCode.Exclude
	private final Long min;
	
	public MinFieldConstraint(Long min) {
		this.min = min != null ? min : Long.MIN_VALUE;
	}

	@Override
	public void valid(Object value) {
		if(min == null) return;
		
		if(value instanceof Long valueNumber) {
			if(valueNumber < min) throw new ConstraintViolationException("Value '" + valueNumber + "' is less than " + min);
		}else if(value instanceof Collection<?> valueCollection) {
			valueCollection.stream()
				.forEach(this::valid);
		}
	}

}
