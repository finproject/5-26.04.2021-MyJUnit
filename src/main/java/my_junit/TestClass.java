package my_junit;

public class TestClass {

    @RunAfterEachTest
    public void testMySomething() {
        System.out.println("This method is annotated @RunAfterEachTest");
    }

    @MyTest
    public void kaki() {
        System.out.println("This method is annotated @MyTest String 1");
    }

    @RunBeforeEachTest
    public void before() {
       System.out.println("This method is annotated @RunBeforeEachTest");
    }

    @MyTest
    public void test1() {
        System.out.println("This method is annotated @MyTest String 2");
    }
}
