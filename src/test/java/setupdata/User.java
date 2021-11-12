package setupdata;

public class User {
    private String username;
    private String userpassword;


    public User(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
