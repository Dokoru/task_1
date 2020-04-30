package myClass;

public class Method {
    private String accessModifier, returnDataType, name;
    private StringBuffer stringBuffer;

    public Method(String accessModifier, String returnDataType, String name) throws Exception {
        if (!(accessModifier.equals("public") || accessModifier.equals("protected") || accessModifier.equals("private"))) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
        this.returnDataType = returnDataType;
        this.name = name;
    }

    public Method() {
        this.accessModifier = null;
        this.returnDataType = null;
        this.name = null;
    }

    private void setStringBuffer() {
        stringBuffer = new StringBuffer(accessModifier).append(' ').append(returnDataType).
                append(' ').append(name).append(" (").append(')').append(" {\n\t}");
    }

    public void setAccessModifier(String accessModifier) throws Exception {
        if (!(accessModifier.equals("public") || accessModifier.equals("protected") || accessModifier.equals("private"))) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
    }

    public void setReturnDataType(String returnDataType) {
        this.returnDataType = returnDataType;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected StringBuffer getStringBuffer() {
        if (stringBuffer == null) {
            setStringBuffer();
        }
        return stringBuffer;
    }

    private int getLengthToArgs() {
        return accessModifier.length() + returnDataType.length() + name.length() + 4;
    }

    public void addArgument(Argument argument) {
        StringBuffer sbMethod = getStringBuffer();
        int length = getLengthToArgs();
        StringBuffer sbArg = argument.getStringBuffer();
        if (sbMethod.length() - 6 == getLengthToArgs()) {
            sbMethod.insert(length, sbArg);
        } else {
            sbMethod.insert(length, sbArg + ", ");
        }
    }

    public void deleteArgument(Argument argument) throws Exception {
        int pos = getStringBuffer().indexOf(argument.getStringBuffer().toString(), getLengthToArgs());
        int argLength = argument.getStringBuffer().length();
        StringBuffer method = getStringBuffer();
        if (pos == -1) {
            throw new Exception ("ArgumentNotInMethod");
        } else {
            if (method.length() - 6 - argLength == getLengthToArgs()) {
                method.delete(pos, pos + argLength);
            }
            else {
                method.delete(pos, pos + argLength + 2);
            }
        }
    }
}
