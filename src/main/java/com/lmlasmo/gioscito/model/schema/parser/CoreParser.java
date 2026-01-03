package com.lmlasmo.gioscito.model.schema.parser;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.CollectionSchema;
import com.lmlasmo.gioscito.model.schema.FullSchema;
import com.lmlasmo.gioscito.model.schema.StructSchema;
import com.lmlasmo.gioscito.model.schema.validation.SchemaValidatorRunner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CoreParser {
	
	private CollectionParser collectionParser;
	private StructParser structParser;
	private SchemaValidatorRunner validatorRunner;

	public FullSchema parse(Map<String, Map<String, Object>> mapSchema) {
		Set<CollectionSchema> collectionSchemas = new HashSet<>();
		Set<StructSchema> structSchemas = new HashSet<>();
		
		mapSchema.forEach((k, v) -> {
			switch(k) {
				case "collections":
					collectionSchemas.addAll(collectionParser.parse(v));
					break;
				case "structs":
					structSchemas.addAll(structParser.parse(v));
					break;
				default: throw new KeyParserException("Key '" + k + "' is not supported");
			}
		});
		
		FullSchema schema = new FullSchema(collectionSchemas, structSchemas);
		validatorRunner.validate(schema);
		
		return schema;
	}
	
}
