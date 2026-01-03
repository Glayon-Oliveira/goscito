package com.lmlasmo.gioscito.model.schema;

import java.util.Set;

public interface ComponentSchema {

	public String getName();
	public Set<FieldSchema> getFields();	
	
}
