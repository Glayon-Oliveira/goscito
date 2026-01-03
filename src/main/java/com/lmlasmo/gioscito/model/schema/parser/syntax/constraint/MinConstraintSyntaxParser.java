package com.lmlasmo.gioscito.model.schema.parser.syntax.constraint;

import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.constraints.FieldConstraint;
import com.lmlasmo.gioscito.model.schema.constraints.MinFieldConstraint;
import com.lmlasmo.gioscito.model.schema.type.ArrayFieldType;
import com.lmlasmo.gioscito.model.schema.type.FieldType;
import com.lmlasmo.gioscito.model.schema.type.NumberFieldType;

@Component
public class MinConstraintSyntaxParser implements FieldConstraintSyntaxParser {
	
	private static final Pattern PATTERN = Pattern.compile("^min\\(\\s*-?\\d+\\s*\\)$");

	@Override
	public boolean matches(String raw, FieldType fieldType) {
		return raw != null && PATTERN.matcher(raw).matches() && supports(fieldType);
	}

	@Override
	public FieldConstraint parse(String raw) {
		String inner = raw.substring("min(".length(), raw.length()-1);
		inner = inner.replaceAll("\\s*", "");
		
		String[] parts = inner.split(",");
		
		try {
			Long min = Long.parseLong(parts[0]);
			
			return new MinFieldConstraint(min);
		}catch(Exception e) {
			throw new RuntimeException("Min value '" + raw + "' is not supported. Min must be number");
		}
	}

	@Override
	public FieldConstraint defaultConstraint(FieldType fieldType) {
		if(fieldType instanceof ArrayFieldType arrayType) {
			return defaultConstraint(arrayType);
		}else if(supports(fieldType)) {
			new MinFieldConstraint(Long.MIN_VALUE);
		}
		
		return null;
	}

	@Override
	public Set<Class<? extends FieldType>> getSupportedFieldTypes() {
		return Set.of(
				NumberFieldType.class
				);
	}

}
