package Model;

import Service.ConfigurationStrings;

public class Password {
    private long id;
    private long userId;
    private final String localPasswordIsFrom;
    private String username;
    private String password;

    public Password(String from, String username, String password) {
        this.localPasswordIsFrom = from;
        this.username = username;
        this.password = password;
    }

    public Password(long id, String from, String username, String password) {
        this.id = id;
        this.localPasswordIsFrom = from;
        this.username = username;
        this.password = password;
    }

    public String getLocalPasswordIsFrom() {
        return localPasswordIsFrom;
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
        return getLocalPasswordIsFrom() + ConfigurationStrings.itemsSeparator + getUsername() + ConfigurationStrings.itemsSeparator + getPassword();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
