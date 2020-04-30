package myClass;

import java.util.HashMap;

public class Class {
    private String accessModifier, name;
    private HashMap<Integer, Method> methodMap;
    private HashMap<Integer, Field> fieldMap;
    private int numbOfMethods;
    private int numbOfFields;

    public Class(String accessModifier, String name) throws Exception {
        try {
            AccessModifier.valueOf(accessModifier);
        } catch (IllegalArgumentException e) {
            throw new Exception("WrongAccessModifier");
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

    public void setAccessModifier(String accessModifier) throws Exception {
        try {
            AccessModifier.valueOf(accessModifier);
        } catch (IllegalArgumentException e) {
            throw new Exception("WrongAccessModifier");
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
            throw new Exception("NotCorrectMethod");
        }
        numbOfFields++;
        fieldMap.put(numbOfFields, field);
    }

    protected void remove(Field field) {
        fieldMap.values().remove(field);
    }

    public String toString() {
        String string = accessModifier + ' ' + "class" + ' ' + name + " { \n";
        for (Integer key : fieldMap.keySet()) {
            string = string + '\t' + fieldMap.get(key).toString() + '\n';
        }
        for (Integer key : methodMap.keySet()) {
            string = string + '\t' + methodMap.get(key).toString() + '\n';
        }
        string = string + '}';
        return string;
    }
}

