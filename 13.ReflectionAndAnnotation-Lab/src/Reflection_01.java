import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Class.forName;

public class Reflection_01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = forName("Reflection1");
        //creating a new Class type called clazz usually.

        System.out.println(clazz);
        //printing the clazz toString method

        Class superClass = clazz.getSuperclass();
        //getting the super class of the clazz by using the method getSuperclass

        System.out.println(superClass);
        //again printing the superClass(which is equal to the superClass of the clazz) toString.

        Class[] interfaces = clazz.getInterfaces();
        //getting all Interfaces of the clazz, and we collect them to an array of Class[].

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //foreach loop to print every interface in the interfaces[].


        //Creating a new instance of the class

        //first we get the constructor
        Constructor constructor = clazz.getDeclaredConstructor();

        Object newInstance = constructor.newInstance();

        System.out.println(newInstance);

        Method[] declaredMethods = clazz.getDeclaredMethods();

        TreeSet<Method> getters = filterMethodsBy(declaredMethods, "get");
        TreeSet<Method> setters = filterMethodsBy(declaredMethods, "set");

        Function<Class<?> , String> formatType = c -> c == int.class ? "class int" : c.toString();

        getters.stream()
                .forEach(method -> System.out.printf("%s will return class %s%n",method.getName(), formatType.apply(method.getReturnType())));
        setters.stream()
                .forEach(method -> System.out.printf("%s and will set field of class %s%n",method.getName(), formatType.apply(method.getParameterTypes()[0])));

    }

    public static TreeSet<Method> filterMethodsBy(Method[] methods, String filter) {
       return Arrays.stream(methods)
                .filter(method -> method.getName().contains(filter))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Method::getName))));
    }
}
