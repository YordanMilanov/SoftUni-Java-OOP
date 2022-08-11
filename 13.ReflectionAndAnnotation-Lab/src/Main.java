import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = forName("Reflection");

        System.out.println(clazz);

        Class superClass = clazz.getSuperclass();

        System.out.println(superClass);

        Class[] interfaces = clazz.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Constructor constructor = clazz.getDeclaredConstructor();

        Object newInstance = constructor.newInstance();

        System.out.println(newInstance);
    }
}
