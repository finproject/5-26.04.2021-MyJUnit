package my_junit;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {
    private final HashSet<Class> cache = new LinkedHashSet<>();
    {
        cache.addAll(List.of(
                RunBeforeEachTest.class,
                MyTest.class,
                RunAfterEachTest.class
        ));
    }
    @SneakyThrows
    public void runAllTestsOfClass(String className) {
        Class<?> testClass = Class.forName(className);
        if (testClass == null) {
            throw new NullPointerException("Method " + className + " = NULL");
        }
        final Object instanceTestClass = testClass.getDeclaredConstructor().newInstance();
        final Method[] declaredMethods = testClass.getDeclaredMethods();
        for (Class classAnnotation : cache) {
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(classAnnotation)) {
                    method.invoke(instanceTestClass);
                }
            }
        }
    }
}
