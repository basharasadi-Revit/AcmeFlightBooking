package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String calculateDate(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Now use today date.
        calendar.add(Calendar.DATE, 15);
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
        String strDate = dateFormat.format(calendar.getTime());
        strDate = strDate.replace(".", "");
        return strDate;

    }

}
