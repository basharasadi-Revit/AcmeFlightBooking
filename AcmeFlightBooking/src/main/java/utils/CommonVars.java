package utils;
import java.util.Properties;

public class CommonVars {
    private CommonVars() {

    }
    private static CommonVars instance;

    public static CommonVars getInstance() {
        if (instance == null) {
            return new CommonVars();
        } else {
            return instance;
        }
    }

//    private Properties propObject = GenericUtils.getConfigPropObject();
//    propObject.getProperty("autURL");
    public String autURL="https://www.qantas.com/au/en/book-a-trip/flights.html";
    public String autDateFormat="EEE MMM dd yyyy";
}
