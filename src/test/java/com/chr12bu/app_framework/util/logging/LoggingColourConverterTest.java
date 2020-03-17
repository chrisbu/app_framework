package com.chr12bu.app_framework.util.logging;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.chr12bu.app_framework.util.logging.LoggingColourConverter;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;

class LoggingColourConverterTest {

	@Test
	void testTransformNullElement() {
		LoggingColourConverter converter = new LoggingColourConverter();
		
		// ALL isn't provided as a level in the ELEMENT map
		ILoggingEvent eventAll = new LoggingEvent() {
			@Override
			public Level getLevel() {
				return Level.ALL;
			};
		};
		
		// test for a missing level (ALL)
		String result = converter.transform(eventAll, "log text ALL");	
		assertNotNull(result);
	
	}
}
