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

    public boolean equals(String accessModifier) {
        return name.equals(accessModifier);
    }

    public String toString() {
        return this.name;
    }

    public static boolean check(String accessModifier) {
        if (accessModifier == null) {
            return true;
        }
        for (AccessModifier accMod : AccessModifier.values()) {
            if (accMod.equals(accessModifier)) {
                return true;
            }
        }
        return false;
    }
}
