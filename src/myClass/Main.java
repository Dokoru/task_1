package myClass;

public class Main {

    public static void main(String[] args) throws Exception {
        Test();
    }

    public static void Test() throws Exception {
        Class cl = new Class();
        cl.setAccessModifier("public");
        cl.setName("class1");
        Method method = new Method();
        method.setAccessModifier("protected");
        method.setName("method1");
        method.setReturnDataType("void");
        Argument argument1 = new Argument("int", "a");
        Argument argument2 = new Argument("double", "c");
        Argument argument3 = new Argument("int", "b");
        method.addArgument(argument1);
        method.addArgument(argument2);
        method.addArgument(argument3);
        method.deleteArgument(argument2);
        cl.addMethod(method);
        Data data1 = new Data("private", "char", "ch1", "'x'");
        Data data2 = new Data("private", "char", "ch2");
        cl.addData(data1);
        cl.addData(data2);
        cl.addData(data2);
        cl.deleteData(data2);
        System.out.println(cl.getStringBuffer());
    }
}