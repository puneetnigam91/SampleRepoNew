package test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import myprj.MessageProcessor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class MessageProcessorTest {

	private MessageProcessor processor;

	@Before
	public void setUp() {
		processor = new MessageProcessor();
	}

	@After
	public void tearDown() {
		processor = null;
	}

	@Test
	public void checkOutMessageWithHeaders() {
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("file_name", "abc.txt");
		headers.put("correlation_id", "askssdjeddlxer");
		MessageHeaders messageHeaders = new MessageHeaders(headers);
		Message<?> message = MessageBuilder.createMessage("12\n12\n12",
				messageHeaders);
		Message<?> output = (Message<?>) processor.processMessage(message);
		Assert.assertEquals("Output is wrong ", "36", output.getPayload()
				.toString());
		Assert.assertEquals("Filename modified ", "abc.txt", output
				.getHeaders().get("file_name"));
		Assert.assertEquals("correlation_id modified ", "askssdjeddlxer",
				output.getHeaders().get("correlation_id"));
	}
}
