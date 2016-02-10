package calories.tracker.app.dao;

import calories.tracker.app.model.Content;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mcurkovic on 08.02.2016..
 */
@Repository
public interface ContentRepository extends PagingAndSortingRepository<Content,Long> {

}
