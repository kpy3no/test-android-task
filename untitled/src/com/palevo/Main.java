package com.palevo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.LogManager;

public class Main {
    public static final String LOG_TAG = "Main";

    public class SomeException extends Exception{}
    public class Another extends Exception{}
    public interface I {
        void m() throws IOException, Another;
    }

    public class A implements I{
        @Override
        public void m() throws IOException, Another, NullPointerException, F {

        }
    }

    public enum S{
        int s;
        S,d
    }
    

    public static int power(int x, int n){
        if (n == 0 ) return 1;
        int result = power(x, n/2);
        result *= result;
        if (n * n <= x) return result * x;
        return result;
    }
    public static void main(String[] args) {

	// write your code here
        int chislo = power(2,3);
        List<Integer> list = new ArrayList<>();
        list.stream().filter()
        Logger logger = LoggerFactory.getLogger(Main.class);
        java.util.logging.Logger logger1 = java.util.logging.Logger.getLogger(LOG_TAG);
        logger1.info("sdasdasd");
        logger.info("privet EPTA");
        TempClass s = new TempClass("eeeeeee");
        HashMap<TempClass, Integer> hashMap = new HashMap<>();
        hashMap.put(null, null);
        Integer ssd = hashMap.get(null);
        ssd += 1;
        ArrayList<Integer> newAr = new ArrayList<>();
        newAr.size();

    }
}
