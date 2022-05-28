import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean isExpectedCheckNameToEmbosst;

    public AccountTest(String name, boolean isExpectedCheckNameToEmbosst) {
        this.name = name;
        this.isExpectedCheckNameToEmbosst = isExpectedCheckNameToEmbosst;
    }

    @Parameterized.Parameters
    public static Object[][] getNameEmboss() {
        return new Object[][]{
                {"Иван Иванов", true},
                {" ИванИванов", false},
                {"ИванИвванов ", false},
                {" ИванИвванов ", false},
                {" Иван Ивванов ", false},
                {"Ива", false},
                {"И а", true},
                {"Лерой Максимилианов", true},
                {"Лерой Максимилианович", false},
                {"Л", false},
                {" Л ", false},
                {" ", false},
                {null, false}
        };
    }

    @Test
    @Step("Expected check name to emboss")
    public void checkNameEmboss() {
        Account account = new Account(name);
        Assert.assertEquals(isExpectedCheckNameToEmbosst, account.checkNameToEmboss());
    }
}
