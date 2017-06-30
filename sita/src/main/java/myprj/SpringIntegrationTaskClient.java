package myprj;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringIntegrationTaskClient {
    
    private static final File RESOURCES_DIR = new File("src/main/resources/spring");
   
    private static final Logger LOGGER = Logger.getLogger(SpringIntegrationTaskClient.class);

    private static String configFile = "spring/SpringIntegrationSampleTaskConfig.xml";
    
    /**
     * private constructor.
     */
    private SpringIntegrationTaskClient(){
        
    }
    
    public static String getConfigFile() {
        return configFile;
    }

    public static void setConfigFile(final String configFile) {
        SpringIntegrationTaskClient.configFile = configFile;
    }

   
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = null;
        try {
            DOMConfigurator.configure(RESOURCES_DIR + "/log4j.xml");
            context = new ClassPathXmlApplicationContext(configFile);
        } catch (BeansException e) {
            LOGGER.error("Bean Exception occured in the application."+e);
        } 
        if(context != null) {
            context.close();
        }
    }
}
