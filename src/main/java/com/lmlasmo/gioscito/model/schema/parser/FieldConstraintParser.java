package com.lmlasmo.gioscito.model.schema.parser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.lmlasmo.gioscito.model.schema.constraints.FieldConstraint;
import com.lmlasmo.gioscito.model.schema.parser.syntax.constraint.FieldConstraintSyntaxParser;
import com.lmlasmo.gioscito.model.schema.type.FieldType;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FieldConstraintParser {

	@NonNull
	private Set<FieldConstraintSyntaxParser> fieldConstraintParsers;
	
	public Set<FieldConstraint> parse(Collection<String> constraints, FieldType fieldType) {
		if(constraints == null) constraints = new HashSet<>();
		
		Set<FieldConstraint> fieldConstraints = new HashSet<>();
		
		for(String constraint: constraints) {
			FieldConstraint fieldConstraint = fieldConstraintParsers.stream()
					.filter(p -> p.matches(constraint, fieldType))
					.findFirst()
					.map(p -> p.parse(constraint))
					.orElseThrow(() -> new RuntimeException("Constraint '" + constraint +"' is invalid"));
			
			fieldConstraints.add(fieldConstraint);
		}
		
		for (FieldConstraintSyntaxParser parser : fieldConstraintParsers) {
	        if (!parser.supports(fieldType)) continue;

	        FieldConstraint defaultConstraint = parser.defaultConstraint(fieldType);
	        
	        if (defaultConstraint == null) continue;

	        boolean exists = fieldConstraints.stream()
	        		.anyMatch(fc -> fc.getConstraint() == fc.getConstraint());
	        
	        if (!exists) fieldConstraints.add(defaultConstraint);
	    }
		
		return fieldConstraints;
	}
	
}
