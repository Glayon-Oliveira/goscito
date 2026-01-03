package com.lmlasmo.gioscito.model.schema.parser;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.parser.syntax.type.ArrayTypeSyntaxParser;
import com.lmlasmo.gioscito.model.schema.parser.syntax.type.FieldTypeSyntaxParser;
import com.lmlasmo.gioscito.model.schema.type.FieldType;

import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FieldTypeParser {
	
	@NonNull
	private List<FieldTypeSyntaxParser> typeParsers;
	
	@PostConstruct
    void sort() {
		typeParsers.sort(Comparator.comparingInt(this::priority));
    }

    private int priority(FieldTypeSyntaxParser p) {
        if(p instanceof ArrayTypeSyntaxParser) return 1;
        return 2;
    }
	
	public FieldType parse(String raw) {
		return typeParsers.stream()
				.filter(p -> p.matches(raw))
				.findFirst()
				.map(p -> p.parse(raw))
				.orElseThrow(() -> new ValueParserException("Type '" + raw + "' is not supported. Verify syntax"));
	}
	
}
