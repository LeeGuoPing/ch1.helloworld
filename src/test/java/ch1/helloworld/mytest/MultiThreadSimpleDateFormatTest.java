package ch1.helloworld.mytest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liguoping
 * @version 1.0
 * @description 多线程场景下SimpleDateFormat测试
 * @time 2019/4/16 10:59
 */
public class MultiThreadSimpleDateFormatTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }

     public static String formatDate(Date date) throws ParseException {
        return sdf.format(date);
    }

    /**
     *  formatDate没有测试出问题, parse会出现问题.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
//                        System.out.println(formatDate(new Date()));
                        System.out.println(parse("2019-04-16 10:00:00"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.DAYS);
    }
}
