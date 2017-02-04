package tests;

import org.testng.annotations.Test;

/**
 * Created by user on 03.02.2017.
 */
public class PingHost extends Runner {

    enum constants {
        REQUEST_COUNT,
        archer,
        dou,
        google;

        public String s(){
            return property.get(this.name());
        }

        public int i(){
            return  Integer.valueOf(property.get(this.name()));
        }
    };

    int attempts = constants.REQUEST_COUNT.i();

    @Test
    public void pingArcher() {
        testExecutor.pingHost(constants.archer.s(), attempts);
    }

    @Test
    public void pingDou() {
        testExecutor.pingHost(constants.dou.s(), attempts);
    }

    @Test
    public void pingGoogle() {
        testExecutor.pingHost(constants.google.s(), attempts);
    }

}
