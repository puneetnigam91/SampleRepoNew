package myprj;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * MessageProcessor for processing the received message
 * 
 * @author Puneet.Nigam
 * 
 */
public class MessageProcessor {

	/**
	 * processMessage.
	 * 
	 * @param message
	 *            , not null
	 * @return Object
	 */
	public Object processMessage(Message<?> message) {
		String content = getSum(message.getPayload().toString());
		Message<String> output = MessageBuilder.withPayload(content)
				.copyHeaders(message.getHeaders()).build();
		return output;
	}

	/**
	 * getSum.
	 * 
	 * @param payload
	 *            , not null
	 * @return sum , not null
	 */

	private String getSum(String payload) {
		long sum = 0;
		String[] lines = payload.split("\n");
		for (String line : lines) {
			sum = sum + Long.valueOf(line.trim());
		}
		return String.valueOf(sum);
	}
}
