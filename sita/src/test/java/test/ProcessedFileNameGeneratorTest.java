package test;

import myprj.ProcessedFileNameGenerator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class ProcessedFileNameGeneratorTest {

	private ProcessedFileNameGenerator generator;

	@Before
	public void setUp() {
		generator = new ProcessedFileNameGenerator();
	}

	@After
	public void tearDown() {
		generator = null;
	}

	@Test
	public void fileNameVerify() {
		Message<?> message = MessageBuilder.withPayload("Sample")
				.setHeader("file_name", "XYZ.txt").build();
		String generatedFileName = generator.generateFileName(message);
		Assert.assertEquals("The generated file name is wrong ",
				"XYZ.txt.PROCESSED", generatedFileName);
	}
}
