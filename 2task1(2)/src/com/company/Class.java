package com.company;

public class Class {
    private String accessModifier, name;
    private StringBuffer stringBufferClass;
    public Class (String accessModifier, String name) throws Exception {
        if(!(accessModifier == "public" || accessModifier == "protected" || accessModifier == "private")) {
            throw new Exception("WrongAccessModifier");
        }
        this.name = name;
        this.accessModifier = accessModifier;
    }
    public Class () {
        this.name = null;
        this.accessModifier = null;
    }
    private void setStringBufferClass () {
        stringBufferClass = new StringBuffer(accessModifier + ' ' + "class" + ' ' + name + " { \n" +'}');
    }
    public void setName (String newName) {
        name = newName;
    }
    public void setAccessModifier (String accessModifier) throws Exception {
        if(!(accessModifier == "public" || accessModifier == "protected" || accessModifier == "private")) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
    }
    public StringBuffer createClass () {
        return stringBufferClass;
    }
    protected StringBuffer getStringBufferClass() {
        if(stringBufferClass == null) {
            setStringBufferClass();
        }
        return stringBufferClass;
    }
    private int getLengthClassToField () {
        return accessModifier.length() + name.length() + 10;
    }
    public void addMethod (Method method) {
        getStringBufferClass().insert(getLengthClassToField(), "\n\t" + method.getStringBufferMethod());
    }
    public void deleteMethod (Method method) throws Exception {
        StringBuffer class_ = getStringBufferClass();
        StringBuffer sbMethod = method.getStringBufferMethod();
        int pos = class_.indexOf(sbMethod.toString(), getLengthClassToField());
        if (pos == -1) {
            throw new Exception ("MethodNotInClass");
        } else {
            class_.delete(pos - 2, pos + sbMethod.length());
        }
    }
    public void addData (Data data) {
        getStringBufferClass().insert(getLengthClassToField(), "\n\t" + data.getStringBufferData());
    }
    public void deleteData (Data data) throws Exception {
        StringBuffer class_ = getStringBufferClass();
        StringBuffer sbData = data.getStringBufferData();
        int pos = class_.indexOf(data.toString(), getLengthClassToField());
        if (pos == -1) {
            throw new Exception ("DataNotInClass");
        } else {
            class_.delete(pos - 2, pos + sbData.length());
        }
    }
}

class Data {
    private String accessModifier, dataType, name, value;
    private StringBuffer stringBufferData;
    public Data (String accessModifier, String dataType, String name, String value) throws Exception {
        if(!(accessModifier == "public" || accessModifier == "protected" || accessModifier == "private")) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
        this.dataType = dataType;
        this.name = name;
        this.value = value;
    }
    public Data () {
        this.accessModifier = null;
        this.dataType = null;
        this.name = null;
        this.value = null;
    }
    public void setAccessModifier (String accessModifier) throws Exception {
        if(!(accessModifier == "public" || accessModifier == "protected" || accessModifier == "private")) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
    }
    public void setDataType (String dataType) {
        this.dataType = dataType;
    }
    public void setName (String name) {
        this.name = name;
    }
    public void setValue (String value) {
        this.value = value;
    }
    private void setStringBufferData () {
        if (value == null || value.length() == 0) {
            stringBufferData =  new StringBuffer(accessModifier).append(' ').append(dataType).append(' ').
                    append(name).append(";");
        } else {
        stringBufferData = new StringBuffer(accessModifier).append(' ').append(dataType).append(' ').
                append(name).append(" = ").append(value).append(";");
        }
    }
    protected StringBuffer getStringBufferData () {
        if(stringBufferData == null) {
            setStringBufferData();
        }
        return stringBufferData;
    }
}

class Method {
    private String accessModifier, returnDataType, name;
    private StringBuffer stringBufferMethod;
    public Method (String accessModifier, String returnDataType, String name) throws Exception {
        if(!(accessModifier == "public" || accessModifier == "protected" || accessModifier == "private")) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
        this.returnDataType = returnDataType;
        this.name = name;
    }
    public Method () {
        this.accessModifier = null;
        this.returnDataType = null;
        this.name = null;
    }
    private void setStringBufferMethod () {
        stringBufferMethod = new StringBuffer(accessModifier).append(' ').append(returnDataType).
                append(' ').append(name).append(" (").append(')').append(" {\n\t}");
    }
    public void setAccessModifier (String accessModifier) throws Exception {
        if(!(accessModifier == "public" || accessModifier == "protected" || accessModifier == "private")) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
    }
    public void setReturnDataType (String returnDataType) {
        this.returnDataType = returnDataType;
    }
    public void setName (String name) {
        this.name = name;
    }
    protected StringBuffer getStringBufferMethod () {
        if(stringBufferMethod == null) {
            setStringBufferMethod();
        }
        return stringBufferMethod;
    }
    private int getLengthMethodToArgs () {
        return accessModifier.length() + returnDataType.length() + name.length() + 4;
    }
    public void addArgument (Argument argument) {
        StringBuffer method = getStringBufferMethod();
        int length = getLengthMethodToArgs();
        StringBuffer arg = argument.getStringBufferArgument();
        if (method.length() - 6 == getLengthMethodToArgs()) {
            method.insert(length, arg);
        } else {
            method.insert(length, arg + ", ");
        }
    }
    public void deleteArgument (Argument argument) throws Exception {
        int pos = getStringBufferMethod().indexOf(argument.getStringBufferArgument().toString(), getLengthMethodToArgs());
        int argLength = argument.getStringBufferArgument().length();
        StringBuffer method = getStringBufferMethod();
        if (pos == -1) {
            throw new Exception ("ArgumentNotInMethod");
        } else {
            if (method.length() - 6 - argLength == getLengthMethodToArgs()) {
                method.delete(pos, pos + argLength);
            }
            else {
                method.delete(pos, pos + argLength + 2);
            }
        }
    }
}

class Argument {
    private String dataType, name;
    private StringBuffer stringBufferArgument;
    public Argument(String dataType, String name) {
        this.dataType = dataType;
        this.name = name;
    }
    public Argument() {
        this.dataType = null;
        this.name = null;
    }
    public void setDataType (String dataType) {
        this.dataType = dataType;
    }
    public void setName (String name) {
        this.name = name;
    }
    private void setStringBufferArgument () {
        stringBufferArgument = new StringBuffer(dataType).append(' ').append(name);
    }
    protected StringBuffer getStringBufferArgument () {
        if (stringBufferArgument == null) {
            setStringBufferArgument();
        }
        return stringBufferArgument;
    }
}
