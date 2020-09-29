package com.wf.training.mavenweb.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletConfig 
		extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		// array of classes which are config classes for spring based res (DB, security, bean etc)
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		// array of classes which are config classes for the servlet
		return new Class[] { ServletSupportConfig.class };
	}

	// to config the url mapping
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		// array of urls to map with servlet
		return new String[] {"/"};
	}

}
