package calories.tracker.app.controllers;

import calories.tracker.app.dto.NewUserDTO;
import calories.tracker.app.dto.UserInfoDTO;
import calories.tracker.app.model.User;
import calories.tracker.app.model.content.BasicContent;
import calories.tracker.app.model.content.FooterContent;
import calories.tracker.app.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by matija on 05.12.15..
 */

/**
 * REST service for content cms.
 */

@Controller
@RequestMapping("/content")
public class ContentController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<BasicContent> getContentList() {
        final FooterContent fc = new FooterContent("091/3100144", "Radnicka cesta 44", "www.pbz.hr");
        fc.setType(BasicContent.ContentType.FOOTER);
        return Arrays.asList(fc);
    }

/*    @ResponseBody
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


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorHandler(Exception exc) {
        LOGGER.error(exc.getMessage(), exc);
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }*/

}
