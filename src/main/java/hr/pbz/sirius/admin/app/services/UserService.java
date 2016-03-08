package hr.pbz.sirius.admin.app.services;

import hr.pbz.sirius.admin.app.dao.UserRepository;
import hr.pbz.sirius.admin.app.model.User;
import hr.pbz.sirius.admin.app.model.UserFilteringParams;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * Business service for User entity related operations
 *
 */
@Service
public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);
    private static final Pattern PASSWORD_REGEX = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}");
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * creates a new user in the database
     *
     * @param username - the username of the new user
     * @param email - the user email
     * @param password - the user plain text password
     */
    @Transactional
    public void createUser(String username, String email, String password) {

        ValidationUtils.assertNotBlank(username, "Username cannot be empty.");
        ValidationUtils.assertMinimumLength(username, 6, "Username must have at least 6 characters.");
        ValidationUtils.assertNotBlank(email, "Email cannot be empty.");
        ValidationUtils.assertMatches(email, EMAIL_REGEX, "Invalid email.");
        ValidationUtils.assertNotBlank(password, "Password cannot be empty.");
        ValidationUtils.assertMatches(password, PASSWORD_REGEX, "Password must have at least 6 characters, with 1 numeric and 1 uppercase character.");

        if (!userRepository.isUsernameAvailable(username)) {
            throw new IllegalArgumentException("The username is not available.");
        }

        User user = new User(username, new BCryptPasswordEncoder().encode(password), email, User.UserStatus.ACTIVE);

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Transactional(readOnly = true)
    public List<User> findUsers(UserFilteringParams filteringParams) {
        return userRepository.findUsers(filteringParams);
    }

}
