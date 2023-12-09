package Ex.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreatObject {
    //// Tried to use String like: equals(String) but didn't work! ////
    // private static Class<?> String;
    public static Object createInstanceWithRandomString(Object o) throws InstantiationException, IllegalAccessException {
        Class<?> clz = o.getClass();
        Constructor<?>[] classConstructors = clz.getConstructors();
        for (Constructor<?> constructor: classConstructors) {
            if(constructor.getParameterCount() == 1 && constructor.getParameterTypes()[0].equals(String.class)){
                String randomCarString = generateCar();
                try {
                   return constructor.newInstance(randomCarString);
                }catch (InvocationTargetException e){
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("No constructor founded with 1 string parameter.");
        return null;
    }
    public static String generateCar(){
        Random rand = new Random();
        ArrayList<String> myCars = new ArrayList<>(Arrays.asList("Toyota", "BMW", "Fiat", "Mercedes", "Ford", "Chevrolet", "Honda", "Nissan", "Hyundai"));
        int randomCar = rand.nextInt(myCars.size());
        return myCars.get(randomCar);
    }
}
