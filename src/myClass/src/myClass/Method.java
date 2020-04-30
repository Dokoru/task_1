package myClass;

import java.util.HashMap;

public class Method {
    private String accessModifier, returnFieldType, name;
    private HashMap<Integer, Argument> argumentMap;
    private int numbOfArg;

    public Method(String accessModifier, String returnFieldType, String name) throws Exception {
        if (!AccessModifier.check(accessModifier)) {
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
        if (!AccessModifier.check(accessModifier)) {
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

    protected StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(accessModifier).append(' ').append(returnFieldType).
                append(' ').append(name).append(" (");
        for (Integer key : argumentMap.keySet()) {
            stringBuffer.append(argumentMap.get(key).toStringBuffer()).append(", ");
        }
        if (numbOfArg > 1) {
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        }
        stringBuffer.append(')').append(" {\n\t}");
        return stringBuffer;
    }
}
