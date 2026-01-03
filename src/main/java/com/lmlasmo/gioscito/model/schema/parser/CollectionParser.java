package com.lmlasmo.gioscito.model.schema.parser;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.CollectionSchema;
import com.lmlasmo.gioscito.model.schema.FieldSchema;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CollectionParser {
	
	private static final Pattern COLLECTION_NAME_PATTERN =  PatternConstants.TOP_COMPONENT_NAME_PATTERN;
	
	private FieldParser fieldParser;
	
	@SuppressWarnings("unchecked")
	public Set<CollectionSchema> parse(Map<String, Object> collectionsMap) {
		Set<CollectionSchema> collectionsSchema = new HashSet<>();
		
		collectionsMap.forEach((k, v) -> {	
			Map<String, Object> map = (Map<String, Object>) v; 
			CollectionSchema collection = parse(k, map);
			collectionsSchema.add(collection);
		});
		
		return collectionsSchema;
	}
	
	public CollectionSchema parse(String collectionName, Map<String, Object> fieldsMapSchema) {
		if(!COLLECTION_NAME_PATTERN.matcher(collectionName).matches()) {
			throw new PatternSyntaxParserException("Syntax of collection name '" + collectionName + "' is invalid", COLLECTION_NAME_PATTERN);
		}
		
		Set<FieldSchema> fieldSchemas = new HashSet<>();
		
		fieldsMapSchema.forEach((k, v) -> {
			FieldSchema field = fieldParser.parse(k, v);
			
			fieldSchemas.add(field);
		});
		
		return new CollectionSchema(collectionName, fieldSchemas);
	}

}
