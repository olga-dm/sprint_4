import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private final String name;
    private final Pattern namePattern = Pattern.compile("((?=(^[а-яА-Я-]+\\s[а-яА-Я-]+$))(?=(^.{3,19}$)))", Pattern.COMMENTS);

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name == null || name.isEmpty())
            return false;
        Matcher matcher = namePattern.matcher(name);
        return matcher.find();
    }
}
