package Model;

import Service.ConfigurationStrings;

public class Password {
    private final String from;
    private String username;
    private String password;

    public Password(String from, String username, String password) {
        this.from = from;
        this.username = username;
        this.password = password;
    }

    public String getFrom() {
        return from;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getFrom() + ConfigurationStrings.itemsSeparator + getUsername() + ConfigurationStrings.itemsSeparator + getPassword();
    }
}
