package myClass;

public class Class {
    private final int sumOtherChar = 10;
    private String accessModifier, name;
    private StringBuffer stringBuffer;

    public Class(String accessModifier, String name) throws Exception {
        if (!AccessModifier.check(accessModifier)) {
            throw new Exception("WrongAccessModifier");
        }
        this.name = name;
        this.accessModifier = accessModifier;
    }

    public Class() {
        this.name = null;
        this.accessModifier = null;
    }

    private void setStringBuffer() {
        stringBuffer = new StringBuffer(accessModifier + ' ' + "class" + ' ' + name + " { \n" +'}');
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAccessModifier(String accessModifier) throws Exception {
        if (!AccessModifier.check(accessModifier)) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
    }

    public StringBuffer create() {
        return stringBuffer;
    }

    protected StringBuffer getStringBuffer() {
        if (stringBuffer == null) {
            setStringBuffer();
        }
        return stringBuffer;
    }

    private int fieldLength() {
        return accessModifier.length() + name.length() + sumOtherChar;
    }

    public void addMethod(Method method) {
        getStringBuffer().insert(fieldLength(), "\n\t" + method.getStringBuffer());
    }

    public void deleteMethod(Method method) throws Exception {
        StringBuffer sbClass = getStringBuffer();
        StringBuffer sbMethod = method.getStringBuffer();
        int pos = sbClass.indexOf(sbMethod.toString(), fieldLength());
        if (pos == -1) {
            throw new Exception ("MethodNotInClass");
        } else {
            sbClass.delete(pos - 2, pos + sbMethod.length());
        }
    }

    public void addData(Field field) {
        getStringBuffer().insert(fieldLength(), "\n\t" + field.getStringBuffer());
    }

    public void deleteData(Field field) throws Exception {
        StringBuffer sbClass = getStringBuffer();
        StringBuffer sbField = field.getStringBuffer();
        int pos = sbClass.indexOf(sbField.toString(), fieldLength());
        if (pos == -1) {
            throw new Exception ("DataNotInClass");
        } else {
            sbClass.delete(pos - 2, pos + sbField.length());
        }
    }
}

