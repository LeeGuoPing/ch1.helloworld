package ch1.helloworld.mytest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liguoping
 * @version 1.0
 * @description 单线程下测试SimpleDateFormat
 * @time 2019/4/16 10:56
 */
public class SimpleDateFormatTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date) throws ParseException {
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }

    public static void main(String[] args) throws InterruptedException, ParseException {

        System.out.println(sdf.format(new Date()));

    }
}
