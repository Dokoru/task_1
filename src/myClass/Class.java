package myClass;

public class Class {
    private String accessModifier, name;
    private StringBuffer stringBuffer;

    public Class(String accessModifier, String name) throws Exception {
        if (!(accessModifier.equals("public") || accessModifier.equals("protected") || accessModifier.equals("private"))) {
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
        if (!(accessModifier.equals("public") || accessModifier.equals("protected") || accessModifier.equals("private"))) {
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

    private int getLengthToField() {
        return accessModifier.length() + name.length() + 10;
    }

    public void addMethod(Method method) {
        getStringBuffer().insert(getLengthToField(), "\n\t" + method.getStringBuffer());
    }

    public void deleteMethod(Method method) throws Exception {
        StringBuffer sbClass = getStringBuffer();
        StringBuffer sbMethod = method.getStringBuffer();
        int pos = sbClass.indexOf(sbMethod.toString(), getLengthToField());
        if (pos == -1) {
            throw new Exception ("MethodNotInClass");
        } else {
            sbClass.delete(pos - 2, pos + sbMethod.length());
        }
    }

    public void addData(Data data) {
        getStringBuffer().insert(getLengthToField(), "\n\t" + data.getStringBuffer());
    }

    public void deleteData(Data data) throws Exception {
        StringBuffer sbClass = getStringBuffer();
        StringBuffer sbData = data.getStringBuffer();
        int pos = sbClass.indexOf(data.toString(), getLengthToField());
        if (pos == -1) {
            throw new Exception ("DataNotInClass");
        } else {
            sbClass.delete(pos - 2, pos + sbData.length());
        }
    }
}
