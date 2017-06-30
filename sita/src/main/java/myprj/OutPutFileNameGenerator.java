package myprj;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

/**
 * OutPutFile File NameGenerator for appending .ERRROR to the file name.
 * @author Puneet.Nigam
 *
 */
public class OutPutFileNameGenerator implements FileNameGenerator {


	  /**
     * generateFileName.
     * @param message , not null
     */
    public String generateFileName(Message<?> message) {        
        return message.getHeaders().get("file_name").toString()+".OUTPUT ";
    }
}
