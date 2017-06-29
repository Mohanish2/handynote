/**
 * 
 */
package com.gp.mohanish.helper;

import javax.xml.bind.DatatypeConverter;

/**
 * @author mohanish
 *
 */
public class AuthHelper {

	public static String[] getUserDetailsFromAuthHelper(String authStr) {
		String[] userObj = null;
		if (authStr != null && authStr.startsWith("Basic")) {
			String authString = authStr.substring("Basic".length()).trim();
			byte[] decodeds1= DatatypeConverter.parseBase64Binary(authString);
			String tokenForAuth = new String(decodeds1);
			userObj = tokenForAuth.split(":", 2);
		}
		return userObj;
	}

}
