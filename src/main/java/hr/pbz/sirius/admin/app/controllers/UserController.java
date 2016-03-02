package hr.pbz.sirius.admin.app.controllers;

import hr.pbz.sirius.admin.app.dto.UserInfoDTO;
import hr.pbz.sirius.admin.app.model.User;
import hr.pbz.sirius.admin.app.model.UserFilteringParams;
import hr.pbz.sirius.admin.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcurkovic on 01.03.2016..
 */
@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/usersView", method = RequestMethod.GET)
  public String getUsersView() {
    return "users";
  }



}
