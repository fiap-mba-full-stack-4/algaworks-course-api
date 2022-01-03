package com.algaworks.courseapi.core.enums;

import lombok.Getter;

@Getter
public enum CourseLevelEnum {

	INICIANTE("Iniciante"),
	INTERMEDIARIO("Intermediário"),
	AVANCADO("Avançado");

	private final String description;

	CourseLevelEnum(String description) {
		this.description = description;
	}
}
