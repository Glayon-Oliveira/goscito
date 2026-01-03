package com.lmlasmo.gioscito.model.schema.parser;

import java.util.regex.Pattern;

public interface PatternConstants {

	public static final Pattern TOP_COMPONENT_NAME_PATTERN =  Pattern.compile("^[a-zA-Z\\d_-]+$");
	
}
