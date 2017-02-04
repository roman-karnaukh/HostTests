package utils;

import model.PingResult;
import model.Statistic;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 03.02.2017.
 */
public class HostUtils {

    public static PingResult checkPing(String link) throws IOException {
        long starTime;
        long execTime = 0;
        URL url;

        boolean isReachable = false;

        try {
            url = new URL(link);

            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setConnectTimeout(1000 * 20);

            starTime = System.currentTimeMillis();
            urlc.connect();

            execTime = System.currentTimeMillis() - starTime;
            urlc.disconnect();

            isReachable = (urlc.getResponseCode() == 200);

//            System.out.println("ResponseTime: " + execTime);
//            System.out.println("isReachable: " + isReachable);
        } catch (IOException e) {

        }
        return new PingResult( execTime, isReachable);
    }

    public static String getHostIp( String link ){
        try {
            URI uri = null;
            try {
                uri = new URI( link );
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            return InetAddress.getByName(uri.getHost()).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String, Statistic> calculateStatistic(HashMap<String, List<PingResult>> pingMap){
        HashMap<String, Statistic> result = new HashMap<>();

        for(Map.Entry<String, List<PingResult>> entry : pingMap.entrySet()) {
            long timeSumm = 0;
            int reached = 0;
            int requestCount;

            String ip = entry.getKey();
            List<PingResult> pingResults = entry.getValue();

            for (PingResult pingResult: pingResults) {
                timeSumm = timeSumm + pingResult.getTime();

                if (pingResult.getResult()) {
                    reached ++;
                }
            }

            requestCount = pingResults.size();
            result.put(ip, new Statistic(timeSumm/requestCount, (requestCount - reached )/requestCount * 100));
        }
        return result;
    }

    public static void printStatistic(HashMap<String, Statistic> statisticHashMap){
        for(Map.Entry<String, Statistic> entry : statisticHashMap.entrySet()) {
            Statistic statistic = entry.getValue();

            System.out.println("==============Result==============");
            System.out.println("IP: " + entry.getKey());
            System.out.println("Average time: " + statistic.getAverageTime() + " ms");
            System.out.println("Lost: " + statistic.getReched() + "%");
            System.out.println("==================================");

        }
    }
}
