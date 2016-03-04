package hr.pbz.sirius.admin.app.services;

import hr.pbz.sirius.admin.app.dao.RoleRepository;
import hr.pbz.sirius.admin.app.dto.RoleDTO;
import hr.pbz.sirius.admin.app.model.role.Role;
import hr.pbz.sirius.admin.app.model.role.RoleFilteringParams;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mcurkovic on 04.03.2016..
 */
@Service
public class RoleService {

  @Autowired
  private MapperFacade mapper;

  @Autowired
  private RoleRepository roleRepository;

  public List<RoleDTO> findRoles(final RoleFilteringParams filteringParams){
    final Iterable<Role> roles = roleRepository.findAll();
    final List<RoleDTO> rolesDTOs = mapper.mapAsList(roles, RoleDTO.class);
    return rolesDTOs;
  }

  public void save(final RoleDTO roleDTO){
    final Role role = mapper.map(roleDTO, Role.class);
    roleRepository.save(role);
  }


}
