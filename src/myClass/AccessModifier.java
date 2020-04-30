package myClass;

public enum AccessModifier {
    PACKAGE_PRIVATE(""),
    PUBLIC("public"),
    PROTECTED("protected"),
    PRIVATE("private");

    private final String name;

    AccessModifier(String accessModifier) {
        name = accessModifier;
    }

    public String toString() {
        return this.name;
    }

    public static String getEnumNameForValue(String value){
        AccessModifier[] values = AccessModifier.values();
        String enumValue = null;
        for(AccessModifier eachValue : values) {
            enumValue = eachValue.toString();

            if (enumValue.equalsIgnoreCase(value)) {
                return eachValue.name();
            }
        }
        return enumValue;
    }
}
