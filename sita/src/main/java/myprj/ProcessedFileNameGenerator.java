package myprj;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

/**
 * Processed File NameGenerator for appending .ERRROR to the file name.
 * 
 * @author Puneet.Nigam
 * 
 */
public class ProcessedFileNameGenerator implements FileNameGenerator {

	/**
	 * generateFileName.
	 * 
	 * @param message
	 *            , not null
	 */
	public String generateFileName(Message<?> message) {
		return message.getHeaders().get("file_name").toString() + ".PROCESSED";
	}
}
