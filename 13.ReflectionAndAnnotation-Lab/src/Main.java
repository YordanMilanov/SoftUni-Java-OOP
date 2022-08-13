import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Field[] declaredFields = clazz.getDeclaredFields();

        TreeSet<Field> fields = collectByName(Arrays.stream(declaredFields));

        fields.forEach(f -> {

        });

    }

    public static <T extends Member> Stream<T> filterMembersByName(T[] members, String filter) {
        return filterMembers(Arrays.stream(members), predicate);
    }


    public static <T extends Member> TreeSet<T> collectByName (Stream<T> stream) {
        return stream.collect(Collectors.toCollection(
                () -> new TreeSet<>(Comparator.comparing(Member::getName))));
    }

    public static <T extends Member> Stream<T> filterMembers(T[] members, Predicate<T> predicate) {
        return Arrays.stream(members)
                .filter(predicate);
    }
}
