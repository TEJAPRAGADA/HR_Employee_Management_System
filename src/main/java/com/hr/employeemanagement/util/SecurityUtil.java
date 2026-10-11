package com.hr.employeemanagement.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtil {

	private static final String SYSTEM_USER = "system";

	private SecurityUtil() {
	}

	public static String currentUsername() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()
				|| "anonymousUser".equals(authentication.getName())) {
			return SYSTEM_USER;
		}

		return authentication.getName();
	}
}
