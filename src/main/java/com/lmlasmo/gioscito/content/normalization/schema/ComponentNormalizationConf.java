package com.lmlasmo.gioscito.content.normalization.schema;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentNormalizationConf {

	@Bean
	public Set<CollectionNormalizer> collectionValidations(ContentNormalizerCompiler normalizer) {
		return normalizer.generateCollectionNormalizers();
	}
	
}
