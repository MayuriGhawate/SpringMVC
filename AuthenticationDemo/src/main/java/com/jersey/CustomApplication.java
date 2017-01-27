package com.jersey;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.jersey.provider.AuthenticationFilter;
import com.jersey.provider.GsonMessageBodyHandler;

public class CustomApplication extends ResourceConfig {
	
	public CustomApplication()
	{
		packages("com.jersey");
		register(LoggingFilter.class);
		register(GsonMessageBodyHandler.class);
		register(AuthenticationFilter.class);
	}

}
