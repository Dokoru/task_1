package myClass;

public class Field {
    private String accessModifier, fieldType, name, value;

    public Field(String accessModifier, String fieldType, String name, String value) throws Exception {
        try {
            AccessModifier.valueOf(AccessModifier.getEnumNameForValue(accessModifier));
        } catch (IllegalArgumentException e) {
            throw new Exception("WrongAccessModifier");
        }
        this.accessModifier = accessModifier;
        this.fieldType = fieldType;
        this.name = name;
        this.value = value;
    }

    public Field(String accessModifier, String fieldType, String name) throws Exception {
        try {
            AccessModifier.valueOf(AccessModifier.getEnumNameForValue(accessModifier));
        } catch (IllegalArgumentException e) {
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
        try {
            AccessModifier.valueOf(AccessModifier.getEnumNameForValue(accessModifier));
        } catch (IllegalArgumentException e) {
            throw new Exception("WrongAccessModifier");
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
            string = accessModifier + ' ' + fieldType + ' ' + name + ";";
        } else {
            string = accessModifier + ' ' + fieldType + ' ' + name + " = " + value + ";";
        }
        return string;
    }
}

