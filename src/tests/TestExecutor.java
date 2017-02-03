package tests;

import interfaces.TestMethods;
import model.PingResult;
import utils.HostUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 03.02.2017.
 */
public class TestExecutor implements TestMethods {

    @Override
    public void pingHost(String url, int times) {
        HashMap<String, List<PingResult>> pingMap = new HashMap<>();
        List<PingResult> pingResults  = new ArrayList<>();
        String ip = HostUtils.getHostIp(url);

        while(times > 0) {

            try {
                pingResults.add(HostUtils.checkPing(url));
                HostUtils.checkPing(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            times --;
        }

        pingMap.put(ip, pingResults);

        HostUtils.printStatistic(HostUtils.calculateStatistic(pingMap));
    }
}
