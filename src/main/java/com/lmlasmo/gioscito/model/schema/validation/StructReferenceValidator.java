package com.lmlasmo.gioscito.model.schema.validation;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.ComponentSchema;
import com.lmlasmo.gioscito.model.schema.FullSchema;
import com.lmlasmo.gioscito.model.schema.StructSchema;
import com.lmlasmo.gioscito.model.schema.field.type.StructFieldType;

@Component
public class StructReferenceValidator implements SchemaValidator {

	@Override
	public void validate(FullSchema schema) {
		validate(schema.getCollections(), schema.getStructs());
		validate(schema.getStructs());
	}
	
	private void validate(Set<StructSchema> structSchemas) {
		validate(structSchemas, structSchemas);
	}
	
	private void validate(Set<? extends ComponentSchema> componentSchemas, Set<StructSchema> structSchemas) {
		componentSchemas.forEach(c -> {
			c.getFields().forEach(f -> {
					if(f.getType() instanceof StructFieldType structType) {
						boolean exists = structSchemas.stream()
								.map(ComponentSchema::getName)
								.anyMatch(structType.getStructName()::equals);
						
						if(!exists) {
							throw new SchemaValidationException("Struct '" + structType.getStructName() + "' not exists");
						}
					}
				});
			});	
	}

}
