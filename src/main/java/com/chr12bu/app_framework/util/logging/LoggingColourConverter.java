package com.chr12bu.app_framework.util.logging;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiElement;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.CompositeConverter;


/**
 * Include in logback-spring.xml using
 *  
 * <pre> 
 *     <conversionRule conversionWord="highlightex" converterClass="com.chr12bu.app_framework.util.logging.LoggingColourConverter" />
 * </pre>
 *  
 * And then in an appender, use it with the keyword "highlightex" per example below.
 *  
 * <pre>
 *   <encoder>
 *     <pattern>[%thread] %highlightex(%-5level) %cyan(%logger{15}) - %msg %n</pattern>
 *   </encoder>
 * </pre>
 *  		 	
 * To change the colours, change the values in ansiLevels in the code below.  
 * They don't get picked up as part of spring-boot hot restart, so you need to stop and start the app again.
 * 
 * Chris B 2020
 * 
 * 
 * This code was taken from:
 * {@link https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/logging/logback/ColorConverter.java}
 * 
 *
 * -- Original javadoc and copyright
 *
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Logback {@link CompositeConverter} colors output using the {@link AnsiOutput} class. A
 * single 'color' option can be provided to the converter, or if not specified color will
 * be picked based on the logging level.
 *
 * @author Phillip Webb (modified in this application by Chris Buckett)
 * @since 1.0.0
 */
public class LoggingColourConverter extends CompositeConverter<ILoggingEvent> {

	private static final Map<String, AnsiElement> ELEMENTS;

	static {
		Map<String, AnsiElement> ansiElements = new HashMap<>();
		ansiElements.put("faint", AnsiStyle.FAINT);
		ansiElements.put("red", AnsiColor.RED);
		ansiElements.put("green", AnsiColor.GREEN);
		ansiElements.put("yellow", AnsiColor.YELLOW);
		ansiElements.put("blue", AnsiColor.BLUE);
		ansiElements.put("magenta", AnsiColor.MAGENTA);
		ansiElements.put("cyan", AnsiColor.CYAN);
		ELEMENTS = Collections.unmodifiableMap(ansiElements);
	}

	private static final Map<Integer, AnsiElement> LEVELS;

	// Change these colours for different colour scheme.
	static {
		Map<Integer, AnsiElement> ansiLevels = new HashMap<>();
		ansiLevels.put(Level.ERROR_INTEGER, AnsiColor.BRIGHT_RED);
		ansiLevels.put(Level.WARN_INTEGER, AnsiColor.YELLOW);
		ansiLevels.put(Level.INFO_INTEGER, AnsiColor.BLACK);
		ansiLevels.put(Level.DEBUG_INTEGER, AnsiColor.BLUE);
		ansiLevels.put(Level.TRACE_INTEGER, AnsiColor.BRIGHT_BLACK);
		LEVELS = Collections.unmodifiableMap(ansiLevels);
	}

	@Override
	protected String transform(ILoggingEvent event, String in) {
		AnsiElement element = ELEMENTS.get(getFirstOption());		
		
		if (null == element) {
			// Assume highlighting
			element = LEVELS.get(event.getLevel().toInteger());
			element = (element != null) ? element : AnsiColor.GREEN;
		}
		else {
			// do nothing.
		}
		return toAnsiString(in, element);
	}

	protected String toAnsiString(String in, AnsiElement element) {
		return AnsiOutput.toString(element, in);
	}

}