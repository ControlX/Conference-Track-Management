package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Abhishek on 12/12/2016.
 */
public class Utils {
    public static String getTime(String initialTime, int addMinutes) {
        Date d = null;
        String myTime = initialTime;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        try {
            d = df.parse(myTime);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MINUTE, addMinutes);
        return df.format(cal.getTime());
    }
}
