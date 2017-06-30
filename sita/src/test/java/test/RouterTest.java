package test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import myprj.Router;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;


public class RouterTest {

	private Router router;

	@Before
	public void setUp() {
		router = new Router();
	}

	
	@After
	public void tearDown() {
		router = null;
	}

	
	@Test
	public void routeInvalidMessage() {
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("file_name", "abc.txt");
		headers.put("correlation_id", "askssdjeddlxer");
		MessageHeaders messageHeaders = new MessageHeaders(headers);
		Message<String> message = MessageBuilder.createMessage("1234\n1234x\n32", messageHeaders);
		String channel = router.handleFile(message);
		Assert.assertEquals("Message redirected to failure channel ", "failureChannel", channel);
	}

	
	@Test
	public void routeValidMessage() {
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("file_name", "abc.txt");
		headers.put("correlation_id", "askssdjeddlxer");
		MessageHeaders messageHeaders = new MessageHeaders(headers);
		Message<String> message = MessageBuilder.createMessage("1234\n1234\n32345", messageHeaders);
		String channel = router.handleFile(message);
		Assert.assertEquals("Message redirected to Success channel ", "successChannel", channel);
	}
}
