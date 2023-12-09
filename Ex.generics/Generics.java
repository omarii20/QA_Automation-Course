package Ex.generics;

import java.util.concurrent.Callable;

public class Generics {
    public static <T> T RetryCount(Callable<T> callable, int maximumRetry, int sleepBetweenRetry){
        int counter = 1;
        T result = null;

        while(counter <= maximumRetry){
            try{
                result = callable.call();
                //// checked typeOf result,to see how the result built. ////
                //System.out.printf("Type of result: %s%n", result.getClass().getName());

                //condition for a successful result
                if (isSuccessful(result)) {
                    break;
                }
                // If the result doesn't expected condition, retry it
                counter++;
                // Sleep
                Thread.sleep(sleepBetweenRetry);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    private static boolean isSuccessful(Object result) {
        // Example: Check if the result is an even number
        if (result instanceof Integer) {
            return ((Integer) result) % 2 == 0;
        }
        return false;
    }
}

