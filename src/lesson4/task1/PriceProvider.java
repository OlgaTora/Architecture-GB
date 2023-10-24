package lesson4.task1;

import java.util.Random;

public class PriceProvider {

    static Random random = new Random();

    public static double getPrice(int componentId){
        return random.nextInt(20, 100);
    }

}
