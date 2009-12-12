/*
 * Copyright (C) 2009 Leandro de Oliveira Aparecido <lehphyro@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.configprocessor.ant;

import java.util.*;

import org.apache.tools.ant.*;

import com.google.code.configprocessor.expression.*;

public class AntExpressionResolver implements ExpressionResolver {

	/**
	 * True if placeholders must be replaced.
	 */
	private boolean replacePlaceholders;

	/**
	 * Ant project.
	 */
	private Project project;
	
	/**
	 * Properties to use when resolving.
	 */
	private Hashtable<Object, Object> properties;

	public AntExpressionResolver(Project project, Hashtable<Object, Object> properties, boolean replacePlaceholders) {
		this.project = project;
		this.properties = properties;
		this.replacePlaceholders = replacePlaceholders;
	}
	
	public String resolve(String value, boolean isPropertiesValue) {
		String resolvedValue;
		
		if (replacePlaceholders) {
			PropertyHelper ph = PropertyHelper.getPropertyHelper(project);
			resolvedValue = ph.replaceProperties(null, value, properties);
		} else {
			resolvedValue = value;
		}
		
		return resolvedValue;
	}

}
