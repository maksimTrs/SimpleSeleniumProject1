package setupdata;

public class UserBuilder {
    private static final String USERNAME = "XXXXXX@gmail.com";
    private static final String USERPASSWORD ="XXXX";

    public static User createUserMethod() {
        return new User(USERNAME, USERPASSWORD);
    }
}
