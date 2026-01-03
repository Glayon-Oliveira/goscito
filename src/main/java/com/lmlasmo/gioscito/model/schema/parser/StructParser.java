package com.lmlasmo.gioscito.model.schema.parser;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.FieldSchema;
import com.lmlasmo.gioscito.model.schema.StructSchema;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class StructParser {
	
	private static final Pattern STRUCT_NAME_PATTERN =  PatternConstants.TOP_COMPONENT_NAME_PATTERN;
	
	private FieldParser fieldParser;
	
	@SuppressWarnings("unchecked")
	public Set<StructSchema> parse(Map<String, Object> structsMap) {
		Set<StructSchema> structSchemas = new HashSet<>();
		
		structsMap.forEach((k, v) -> {
			Map<String, Object> map = (Map<String, Object>) v; 
			StructSchema struct = parse(k, map);
			structSchemas.add(struct);
		});
		
		return structSchemas;
	}
	
	public StructSchema parse(String structName, Map<String, Object> fieldsMapSchema) {
		if(!STRUCT_NAME_PATTERN.matcher(structName).matches()) {
			throw new PatternSyntaxParserException("Syntax of collection name '" + structName + "' is invalid", STRUCT_NAME_PATTERN);
		}
		
		Set<FieldSchema> fieldSchemas = new HashSet<>();
		
		fieldsMapSchema.forEach((k, v) -> {
			FieldSchema field = fieldParser.parse(k, v);
			
			fieldSchemas.add(field);
		});
		
		return new StructSchema(structName, fieldSchemas);
	}

}
