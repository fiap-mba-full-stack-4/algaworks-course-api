package com.algaworks.courseapi.core.enums;

import lombok.Getter;

@Getter
public enum CourseLevelEnum {

	INICIANTE("INICIANTE"),
	INTERMEDIARIO("INTERMEDIÁRIO"),
	AVANCADO("AVANÇADO");

	private final String description;

	CourseLevelEnum(String description) {
		this.description = description;
	}
}
