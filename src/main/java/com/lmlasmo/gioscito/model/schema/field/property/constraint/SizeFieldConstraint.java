package com.lmlasmo.gioscito.model.schema.field.property.constraint;

import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class SizeFieldConstraint implements FieldConstraint {
	
	private final FieldConstraintType constraint = FieldConstraintType.SIZE;
	
	@EqualsAndHashCode.Exclude
	private final int min;
	
	@EqualsAndHashCode.Exclude
	private final int max;
	
	public SizeFieldConstraint(Integer min, Integer max) {
		this.min = min != null ? min : 0;
		this.max = max != null ? max : Integer.MAX_VALUE;
	}
	
	public void valid(Object value) {
		if(value == null) return;
		
		if(value instanceof String valueStr) {
			if(valueStr.length() < min) throw new ConstraintViolationException("The size of '" + valueStr + "' is less than " + min);
			
			if(valueStr.length() > max) throw new ConstraintViolationException("The size of '" + valueStr + "' is greater than " + min);
		}else if(value instanceof Collection<?> valueCollection) {
			valueCollection.stream()
				.forEach(this::valid);
		}
	}

}
