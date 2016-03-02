package hr.pbz.sirius.admin.app.controllers;

import hr.pbz.sirius.admin.app.dto.NewUserDTO;
import hr.pbz.sirius.admin.app.dto.UserInfoDTO;
import hr.pbz.sirius.admin.app.model.User;
import hr.pbz.sirius.admin.app.model.UserFilteringParams;
import hr.pbz.sirius.admin.app.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * REST service for users.
 */

@Controller
@RequestMapping("/user")
public class ProfileController {

  private static final Logger LOGGER = Logger.getLogger(ProfileController.class);

  @Autowired
  UserService userService;

  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = RequestMethod.GET)
  public UserInfoDTO getUserInfo(Principal principal) {

    User user = userService.findUserByUsername(principal.getName());
    Long todaysCalories = userService.findTodaysCaloriesForUser(principal.getName());

    final UserInfoDTO userInfoDTO = new UserInfoDTO();
    userInfoDTO.setUserName(principal.getName());
    userInfoDTO.setFirstName("N/A");
    userInfoDTO.setLastName("N/A");
    userInfoDTO.setFullName("N/A");
    return user != null ? userInfoDTO : null;
  }

  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = RequestMethod.PUT)
  public void updateUserMaxCaloriesPerDay(Principal principal, @RequestBody Long newMaxCalories) {
    userService.updateUserMaxCaloriesPerDay(principal.getName(), newMaxCalories);
  }

  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = RequestMethod.POST)
  public void createUser(@RequestBody NewUserDTO user) {
    userService.createUser(user.getUsername(), user.getEmail(), user.getPlainTextPassword());
  }

  @ResponseBody
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public List<UserInfoDTO> findUsers() {
    final UserFilteringParams filteringParams = new UserFilteringParams();
    filteringParams.setStatus(User.UserStatus.ACTIVE);
    List<User> users = userService.findUsers(filteringParams);
    List<UserInfoDTO> userDTOs = new ArrayList<UserInfoDTO>();
    for (User user : users) {
      final UserInfoDTO userInfoDTO = new UserInfoDTO();
      userInfoDTO.setUserName(user.getUsername());
      userInfoDTO.setFirstName("N/A");
      userInfoDTO.setLastName("N/A");
      userInfoDTO.setFullName("N/A");
      userDTOs.add(userInfoDTO);
    }
    return userDTOs;
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> errorHandler(Exception exc) {
    LOGGER.error(exc.getMessage(), exc);
    return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
  }

}
