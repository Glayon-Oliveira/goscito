package com.lmlasmo.gioscito.model.schema;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class FullSchema {
	
	private Set<CollectionSchema> collections;
	private Set<StructSchema> structs;
	
}
