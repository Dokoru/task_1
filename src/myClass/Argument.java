package myClass;

public class Argument {
    private String fieldType, name;

    public Argument(String fieldType, String name) {
        this.fieldType = fieldType;
        this.name = name;
    }

    public Argument() {
        this.fieldType = null;
        this.name = null;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(fieldType).append(' ').append(name);
        return stringBuffer;
    }
}
