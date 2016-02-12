package hr.pbz.sirius.admin.app.controllers;

import hr.pbz.sirius.admin.app.model.Content;
import hr.pbz.sirius.admin.app.services.ContentService;
import hr.pbz.sirius.admin.app.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by matija on 05.12.15..
 */

/**
 * REST service for content cms.
 */

@Controller
@SessionAttributes(ContentController.CONTENT_LIST)
@RequestMapping("/content")
public class ContentController {

  private static final Logger LOGGER = Logger.getLogger(UserController.class);
  public static final String CONTENT_LIST = "contentList";

  @Autowired
  UserService userService;

  @Autowired
  ContentService contentService;

  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = RequestMethod.GET)
  public List<Content> getContentList(final ModelMap modelMap) {
       /* List<BasicContent> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            res.add(new FooterContent("091/3100144", "Radnicka cesta 44", "www.pbz.hr"));
        }
        modelMap.addAttribute(CONTENT_LIST, res);*/

    final List<Content> pageableContent = contentService.findPageableContent(0, 10);
    modelMap.addAttribute(CONTENT_LIST, pageableContent);
    return pageableContent;
  }

  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
  public Content getContentDetails(@PathVariable(value = "id") Long id,
      final @ModelAttribute(CONTENT_LIST) List<Content> list) {
    Assert.notNull(id);
    Content result = null;
    for (Content content : list ) {
      if (content.getId().equals(id)){
        result = content;
      }
    }
    return result;
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
