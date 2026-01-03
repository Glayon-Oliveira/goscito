package com.lmlasmo.gioscito.model.schema.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import com.lmlasmo.gioscito.model.schema.FullSchema;
import com.lmlasmo.gioscito.model.schema.parser.CoreParser;

@Configuration
public class SchemaLoad {

	@Bean
	public FullSchema fullSchema(@Value("${gioscito.schema.locations.path}") Resource filePath, CoreParser parser) throws FileNotFoundException, IOException {
		try(InputStream is = filePath.getInputStream()) {
			Yaml yaml = new Yaml();
			
			Map<String, Map<String, Object>> mapa = yaml.load(is);
			
			return parser.parse(mapa);
		}
	}
	
}
