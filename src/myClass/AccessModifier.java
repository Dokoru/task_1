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
}
