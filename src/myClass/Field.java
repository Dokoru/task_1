package myClass;

public class Field {
    private String fieldType, name, value;
    private AccessModifier accessModifier;

    public Field(AccessModifier accessModifier, String fieldType, String name, String value) {
        if (accessModifier == null) {
            accessModifier = AccessModifier.PACKAGE_PRIVATE;
        }
        this.accessModifier = accessModifier;
        this.fieldType = fieldType;
        this.name = name;
        this.value = value;
    }

    public Field(AccessModifier accessModifier, String fieldType, String name) {
        if (accessModifier == null) {
            accessModifier = AccessModifier.PACKAGE_PRIVATE;
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

    public void setAccessModifier(AccessModifier accessModifier) {
        if (accessModifier == null) {
            accessModifier = AccessModifier.PACKAGE_PRIVATE;
        }
        this.accessModifier = accessModifier;
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

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        String string;
        if (value == null || value.length() == 0) {
            string = String.format("%s %s %s;", accessModifier.toString(), fieldType, name);
        } else {
            string = String.format("%s %s %s = %s;", accessModifier.toString(), fieldType, name, value);
        }
        return string;
    }
}

