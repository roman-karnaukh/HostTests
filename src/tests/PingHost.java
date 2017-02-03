package tests;

import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by user on 03.02.2017.
 */
public class PingHost extends Runner {

    @Test
    public void pingArcher() throws IOException {
        testExecutor.pingHost("http://www.archer-soft.com/ru/", 20);
    }

    @Test
    public void pingDou() throws IOException {
        testExecutor.pingHost("https://dou.ua/", 20);
    }

    @Test
    public void pingGoogle() throws IOException {
        testExecutor.pingHost("https://www.google.com.ua/", 20);
    }

}
