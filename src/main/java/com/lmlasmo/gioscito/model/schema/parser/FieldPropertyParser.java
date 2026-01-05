package com.lmlasmo.gioscito.model.schema.parser;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.field.property.FieldProperty;
import com.lmlasmo.gioscito.model.schema.field.type.FieldType;
import com.lmlasmo.gioscito.model.schema.parser.syntax.field.property.FieldPropertySyntaxParser;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FieldPropertyParser {

	@NonNull private Set<FieldPropertySyntaxParser<?>> fieldPropertyParsers;
	
	public Set<FieldProperty<?>> parse(Map<String, Object> constraints, FieldType fieldType) {
		
		Set<FieldProperty<?>> properties = new HashSet<>();
		
		constraints.forEach((k, v) -> {
			if(k.equals("type")) return;
			
			FieldProperty<?> property = fieldPropertyParsers.stream()
					.filter(p -> p.matches(k))
					.findFirst()
					.map(p -> p.parse(v, fieldType))
					.orElseThrow(() -> new KeyParserException("Property '" + k + "' is not supported"));
			
			properties.add(property);
		});
		
		return properties;
	}
	
}
