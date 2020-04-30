package myClass;

public class Field {
    private String accessModifier, fieldType, name, value;
    private StringBuffer stringBuffer;

    public Field(String accessModifier, String fieldType, String name, String value) throws Exception {
        if (!AccessModifier.check(accessModifier)) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
        this.fieldType = fieldType;
        this.name = name;
        this.value = value;
    }

    public Field(String accessModifier, String fieldType, String name) throws Exception {
        if (!AccessModifier.check(accessModifier)) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
        this.fieldType = fieldType;
        this.name = name;
        this.value = null;
    }

    public Field() {
        this.accessModifier = null;
        this.fieldType = null;
        this.name = null;
        this.value = null;
    }

    public void setAccessModifier(String accessModifier) throws Exception {
        if (!AccessModifier.check(accessModifier)) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private void setStringBuffer() {
        if (value == null || value.length() == 0) {
            stringBuffer =  new StringBuffer(accessModifier).append(' ').append(fieldType).append(' ').
                    append(name).append(";");
        } else {
            stringBuffer = new StringBuffer(accessModifier).append(' ').append(fieldType).append(' ').
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

