package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by user on 03.02.2017.
 */
public class PropertyWorker {

    private String fileLocation = "resources/config.properties";
    private Properties property = new Properties();

    public PropertyWorker(){
        try {
            FileInputStream fis = new FileInputStream(fileLocation);
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String get(String key){
        return property.get(key).toString();
    }

    public void add(String key, String value){
        property.put(key, value);
    }

    public void write(String key, String value) {
        add(key, value);
        write();
    }

    public void write(){
        try {

            FileOutputStream fileOut = new FileOutputStream(fileLocation);
            property.store(fileOut, "Write Parameters");
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
