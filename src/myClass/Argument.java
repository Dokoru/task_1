package myClass;

public class Argument {
    private String dataType, name;
    private StringBuffer stringBuffer;

    public Argument(String dataType, String name) {
        this.dataType = dataType;
        this.name = name;
    }

    public Argument() {
        this.dataType = null;
        this.name = null;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setStringBuffer() {
        stringBuffer = new StringBuffer(dataType).append(' ').append(name);
    }

    protected StringBuffer getStringBuffer() {
        if (stringBuffer == null) {
            setStringBuffer();
        }
        return stringBuffer;
    }
}