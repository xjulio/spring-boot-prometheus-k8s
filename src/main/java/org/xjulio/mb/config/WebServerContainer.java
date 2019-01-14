/*
 * @(#)WebServerContainer.java
 *
 * Copyright 2018
 */
package org.xjulio.mb.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
/**
 * @author <a href="mailto:xjulio@gmail.com">Julio Cesar Damasceno</a>
 */
public class WebServerContainer implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {

		container.setPort(80);
	}
}