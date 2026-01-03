package com.lmlasmo.gioscito.model.schema.parser;

import java.util.regex.Pattern;

public class PatternSyntaxParserException extends SyntaxParserException {

	private static final long serialVersionUID = 1L;
	private static final String messageTemplate = "%s. It must match regex \"%s\". See Java Pattern/Regex documentation for reference";

	public PatternSyntaxParserException(String message, Pattern pattern) {
		super(messageTemplate.formatted(message.replaceAll("\\.+$", ""), pattern.toString()));
	}
	
}
