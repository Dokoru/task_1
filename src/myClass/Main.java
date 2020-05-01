package myClass;

public class Main {

    public static void main(String[] args) throws Exception {
        Test1();
    }

    public static void Test1() throws Exception {
        Class c = new Class();
        c.setName("class");
        c.setAccessModifier(AccessModifier.PRIVATE);
        Field f1 = new Field(AccessModifier.PUBLIC, "int", "f1", "1");
        Field f2 = new Field(AccessModifier.PROTECTED, "int", "f2");
        Method m1 = new Method(AccessModifier.PRIVATE, "void", "method1");
        Method m2 = new Method(AccessModifier.PACKAGE_PRIVATE, "void", "method2");
        Argument a1 = new Argument("int", "a1");
        Argument a2 = new Argument("int", "a2");
        m1.add(a1);
        m1.add(a2);
        m1.remove(a2);
        m2.add(a1);
        m2.add(a2);
        c.add(m1);
        c.add(m2);
        c.add(f1);
        c.add(f2);
        System.out.println(c.toString());
        c.setAccessModifier(AccessModifier.PROTECTED);
        c.remove(f2);
        c.remove(m1);
        System.out.println(c.toString());
    }

    public static void Test2() throws Exception {
        Class c = new Class(AccessModifier.PRIVATE, "class");
        Method m = new Method();
        c.add(m);
    }

    public static void Test3() throws Exception {
        Class c = new Class(AccessModifier.PACKAGE_PRIVATE, "class");
        Field f1 = new Field(AccessModifier.PUBLIC, "int", "f1", "1");
        Field f2 = new Field(AccessModifier.PRIVATE, "int", "f2");
        Method m1 = new Method(AccessModifier.PROTECTED, "void", "method1");
        Method m2 = new Method(AccessModifier.PACKAGE_PRIVATE, "void", "method2");
        Argument a1 = new Argument("int", "a1");
        Argument a2 = new Argument("int", "a2");
        c.add(f1);
        c.add(m1);
        m1.add(a1);
        m1.add(a1);
        c.add(f2);
        m1.remove(a1);
        c.add(m2);
        m1.add(a2);
        System.out.println(c.toString());
    }

    public static void Test4() throws Exception {
        Class c = new Class(AccessModifier.PACKAGE_PRIVATE, "class");
        c.setAccessModifier(null);
        System.out.println(c.toString());
    }
}