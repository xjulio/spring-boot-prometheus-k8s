/*
 * @(#)VersionService.java
 *
 * Copyright 2018
 */
package org.xjulio.mb.services;

import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:xjulio@gmail.com">Julio Cesar Damasceno</a>
 */
@Component
public class VersionService {

	public String getJarVersion() {
	    VersionService object = new VersionService();
	    Package objPackage = object.getClass().getPackage();
	    String version = objPackage.getImplementationVersion();
	    
	    return version;		
	}
}
