package com.lmlasmo.gioscito.model.schema.validation;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.FullSchema;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SchemaValidatorRunner {

	@NonNull private Set<SchemaValidator> schemaValidators;
	
	public void validate(FullSchema schema) {
		schemaValidators.forEach(v -> v.validate(schema));
	}
}
