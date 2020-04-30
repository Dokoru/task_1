package myClass;

public class Data {
    private String accessModifier, dataType, name, value;
    private StringBuffer stringBuffer;

    public Data(String accessModifier, String dataType, String name, String value) throws Exception {
        if (!(accessModifier.equals("public") || accessModifier.equals("protected") || accessModifier.equals("private"))) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
        this.dataType = dataType;
        this.name = name;
        this.value = value;
    }

    public Data() {
        this.accessModifier = null;
        this.dataType = null;
        this.name = null;
        this.value = null;
    }

    public void setAccessModifier(String accessModifier) throws Exception {
        if (!(accessModifier.equals("public") || accessModifier.equals("protected") || accessModifier.equals("private"))) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private void setStringBuffer() {
        if (value == null || value.length() == 0) {
            stringBuffer =  new StringBuffer(accessModifier).append(' ').append(dataType).append(' ').
                    append(name).append(";");
        } else {
            stringBuffer = new StringBuffer(accessModifier).append(' ').append(dataType).append(' ').
                    append(name).append(" = ").append(value).append(";");
        }
    }

    protected StringBuffer getStringBuffer() {
        if (stringBuffer == null) {
            setStringBuffer();
        }
        return stringBuffer;
    }
}
