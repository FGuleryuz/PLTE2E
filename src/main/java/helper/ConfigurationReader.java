package helper;



import java.io.FileInputStream;
import java.util.Properties;


public class ConfigurationReader {



    private static Properties properties = new Properties();

   static {

       String path="configuration.properties";

        try{

            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file=new FileInputStream(path);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}