package Ex.generics;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Callable<Integer> CallableFunction = () -> {
            int randomNumber = (int) (Math.random() * 100);
            System.out.println("Generated Number: " + randomNumber);
            return randomNumber;
        };

        try {
            int finalResult = Generics.RetryCount(CallableFunction, 3, 2000);
            System.out.println("Result: " + finalResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
