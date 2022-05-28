public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name.length() >= 3 &&
                name.length() <= 19 &&
                name.contains(" ") &&
                !name.startsWith(" ") &&
                !name.endsWith(" ") && name != null) {
            return true;
        }
        return false;
    }
}
