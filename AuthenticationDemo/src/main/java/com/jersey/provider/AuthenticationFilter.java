package com.jersey.provider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceinfo;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHORIZATION_SCHEME = "Basic";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.FORBIDDEN)
			.entity("Accesss denied for all users").build();

	@Override
	public void filter(ContainerRequestContext requestContext) {
		Method method = resourceinfo.getResourceMethod();
		// Access allowed for all
		if (!method.isAnnotationPresent(PermitAll.class)) {
			// Access denied for all
			if (method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(ACCESS_DENIED);
				return;
			}
			// Get request headers
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();
			// Fetch authorization header
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
			// if no authorization information present;block access
			if (authorization == null || authorization.isEmpty()) {
				requestContext.abortWith(ACCESS_DENIED);
				return;
			}
			// Get encoded username and password

			final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHORIZATION_SCHEME + "", "");
			// Decode username and password tokens
			String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));
			final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();

			// Verifying Username and Password
			System.out.println(username);
			System.out.println(password);

			// Verify user access
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
				Set<String> roleSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

				// Is user valid?
				if (!isUserAllowed(username, password, roleSet)) {
					requestContext.abortWith(ACCESS_DENIED);
				}
			}

		}

	}

	private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {
		boolean isAllowed = false;
		if (username.equals("abc") && password.equals("123")) {
			String userRole = "ADMIN";
			if (rolesSet.contains(userRole)) {
				isAllowed = true;
			}
		}
		return isAllowed;
	}

}
