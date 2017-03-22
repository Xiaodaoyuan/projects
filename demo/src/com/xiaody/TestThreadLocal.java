package com.xiaody;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Xiaody on 2017/3/15.
 */
public class TestThreadLocal {
    static ExecutorService service = Executors.newFixedThreadPool(3);
    private static ThreadLocal<Map<String, SimpleDateFormat>> local = new ThreadLocal<Map<String, SimpleDateFormat>>() {

        @Override
        protected Map<String, SimpleDateFormat> initialValue() {
            return new HashMap<>();
        }
    };


    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat get(String pattern) {
        Map<String, SimpleDateFormat> sdfMap = local.get();
        SimpleDateFormat sdf = sdfMap.get(pattern);
        if (sdf == null) {
            sdf = new SimpleDateFormat(pattern);
            sdfMap.put(pattern, sdf);
        }
        return sdf;
    }

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 25; i++) {
                service.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(TestThreadLocal.get("yyyy-MM-dd HH:mm:ss").parse("2017-03-15 15:33:22"));
                        Thread.sleep(1000);
//                    System.out.println(sdf.parse("2017-03-15 15:33:22"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
