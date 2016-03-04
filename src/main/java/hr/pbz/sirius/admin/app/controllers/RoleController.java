package hr.pbz.sirius.admin.app.controllers;

import hr.pbz.sirius.admin.app.dto.RoleDTO;
import hr.pbz.sirius.admin.app.model.role.RoleFilteringParams;
import hr.pbz.sirius.admin.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mcurkovic on 04.03.2016..
 */
@Controller
@RequestMapping(value = "roles")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public void save(@RequestBody RoleDTO role) {
    roleService.save(role);
  }

  @ResponseBody
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<RoleDTO> findRoles() {
    final RoleFilteringParams filteringParams = new RoleFilteringParams();
    return roleService.findRoles(filteringParams);
  }
}
