package myClass;

import java.util.HashMap;

public class Class {
    private String name;
    private AccessModifier accessModifier;
    private HashMap<Integer, Method> methodMap;
    private HashMap<Integer, Field> fieldMap;
    private int numbOfMethods;
    private int numbOfFields;

    public Class(AccessModifier accessModifier, String name) {
        if (accessModifier == null) {
            accessModifier = AccessModifier.PACKAGE_PRIVATE;
        }
        this.name = name;
        this.accessModifier = accessModifier;
        this.numbOfMethods = 0;
        this.numbOfFields = 0;
        this.methodMap = new HashMap<>();
        this.fieldMap = new HashMap<>();
    }

    public Class() {
        this.name = null;
        this.accessModifier = null;
        this.numbOfMethods = 0;
        this.numbOfFields = 0;
        this.methodMap = new HashMap<>();
        this.fieldMap = new HashMap<>();
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        if (accessModifier == null) {
            accessModifier = AccessModifier.PACKAGE_PRIVATE;
        }
        this.accessModifier = accessModifier;
    }

    protected void add(Method method) throws Exception {
        if (method.getReturnFieldType() == null || method.getName() == null) {
            throw new Exception("NotCorrectMethod");
        }
        numbOfMethods++;
        methodMap.put(numbOfMethods, method);
    }

    protected void remove(Method method) {
        methodMap.values().remove(method);
    }

    protected void add(Field field) throws Exception {
        if (field.getFieldType() == null || field.getName() == null) {
            throw new Exception("NotCorrectField");
        }
        numbOfFields++;
        fieldMap.put(numbOfFields, field);
    }

    protected void remove(Field field) {
        fieldMap.values().remove(field);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.format("%s class %s { \n", accessModifier.toString(), name));
        for (Integer key : fieldMap.keySet()) {
            stringBuffer.append(String.format("\t %s \n", fieldMap.get(key).toString()));
        }
        for (Integer key : methodMap.keySet()) {
            stringBuffer.append(String.format("\t %s \n", methodMap.get(key).toString()));
        }
        String string = stringBuffer.append('}').toString();
        return string;
    }
}

