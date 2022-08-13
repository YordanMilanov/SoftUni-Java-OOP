import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GettersAndSetters_02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = Reflection.class;
        //creating a new Class type called clazz usually.

        Method[] declaredMethods = clazz.getDeclaredMethods();

        TreeSet<Method> getters = filterMethodsBy(declaredMethods, "get");

        TreeSet<Method> setters = filterMethodsBy(declaredMethods, "set");

        Function<Class<?> , String> formatType = c -> c == int.class ? "class int" : c.toString();

        getters.stream()
                .forEach(method -> System.out.printf("%s will return %s%n",method.getName(), formatType.apply(method.getReturnType())));
        setters.stream()
                .forEach(method -> System.out.printf("%s and will set field of %s%n",method.getName(), formatType.apply(method.getParameterTypes()[0])));

    }

    public static TreeSet<Method> filterMethodsBy(Method[] methods, String filter) {
        return Arrays.stream(methods)
                .filter(method -> method.getName().contains(filter))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Method::getName))));
    }
}
