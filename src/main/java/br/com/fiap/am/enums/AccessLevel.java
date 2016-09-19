package br.com.fiap.am.enums;

import java.util.Arrays;
import java.util.List;

public enum AccessLevel {
	WEBMASTER("Webmaster"), INVESTIDOR("Investidor"), COMPRADOR("Comprador"), ADMINISTRADOR("Adminsitrador");
	
	private String name;
	
	private AccessLevel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static List<AccessLevel> levels(){
		return Arrays.asList(AccessLevel.values());
	}
}
