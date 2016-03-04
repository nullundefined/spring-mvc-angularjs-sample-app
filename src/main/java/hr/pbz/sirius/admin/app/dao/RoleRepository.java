package hr.pbz.sirius.admin.app.dao;

import hr.pbz.sirius.admin.app.model.role.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mcurkovic on 04.03.2016..
 */
@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role,Long> {

}
