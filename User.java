/**
 * The User class represents a user in the system.
 */
public class User {
    private Integer id; // The ID of the user
    private String name; // The name of the user
    private String username; // The username of the user
    private String password; // The password of the user
    private String userType; // The type of user

    /**
     * Constructor to initialize a new User object.
     * @param id The ID of the user.
     * @param name The name of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param userType The type of user (e.g., "Student", "Lecturer", "Admin").
     */
    public User(Integer id, String name, String username, String password, String userType) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    /**
     * Retrieves the ID of the user.
     * @return The ID of the user.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Retrieves the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the username of the user.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the type of the user.
     * @return The type of the user (e.g., "Student", "Lecturer", "Admin").
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Generates a string representation of the user object.
     * @return The string representation of the user object.
     */
    @Override
    public String toString() {
        return userType + ": " + username;
    }
}

