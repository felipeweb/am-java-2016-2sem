package br.com.fiap.am.infra;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by felipeweb on 8/29/16.
 */

public class Digester {
	private final static String SALT = "sadifhasdu34hqo9ihadfsoivuhaewuihfasiuasiufhifaew";

	public static String encrypt(String toDigest) {
		return DigestUtils.sha256Hex(toDigest + SALT);
	}
}
