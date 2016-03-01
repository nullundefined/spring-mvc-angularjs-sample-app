package hr.pbz.sirius.admin.app.controllers;

import hr.pbz.sirius.admin.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mcurkovic on 01.03.2016..
 */
@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String findUsers() {
    return "users";
  }

}
