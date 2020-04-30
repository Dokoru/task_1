package myClass;

import java.util.HashMap;

public class Method {
    private String accessModifier, returnFieldType, name;
    private HashMap<Integer, Argument> argumentMap;
    private int numbOfArg;

    public Method(String accessModifier, String returnFieldType, String name) throws Exception {
        try {
            AccessModifier.valueOf(accessModifier);
        } catch (IllegalArgumentException e) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
        this.returnFieldType = returnFieldType;
        this.name = name;
        this.argumentMap = new HashMap<>();
        this.numbOfArg = 0;
    }

    public Method() {
        this.accessModifier = null;
        this.returnFieldType = null;
        this.name = null;
        this.argumentMap = new HashMap<>();
        this.numbOfArg = 0;
    }

    public void setAccessModifier(String accessModifier) throws Exception {
        try {
            AccessModifier.valueOf(accessModifier);
        } catch (IllegalArgumentException e) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
    }

    public void setReturnFieldType(String returnFieldType) {
        this.returnFieldType = returnFieldType;
    }

    public String getReturnFieldType() {
        return returnFieldType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void add(Argument argument) throws Exception {
        if (argument.getFieldType() == null || argument.getName() == null) {
            throw new Exception("NotCorrectMethod");
        }
        numbOfArg++;
        argumentMap.put(numbOfArg, argument);
    }

    protected void remove(Argument argument) {
        argumentMap.values().remove(argument);
    }

    public String toString() {
        String string = accessModifier + ' ' + returnFieldType + ' ' + name + " (";
        for (Integer key : argumentMap.keySet()) {
            string = string + argumentMap.get(key).toStringBuffer() + ", ";
        }
        if (numbOfArg > 1) {
            StringBuffer sb = new StringBuffer(string);
            sb.delete(sb.length() - 2, sb.length());
            string = sb.toString();
        }
        string = string + ')' + " {\n\t}";
        return string;
    }
}
