package hr.pbz.sirius.admin.app.services;

import hr.pbz.sirius.admin.app.dao.ContentRepository;
import hr.pbz.sirius.admin.app.dto.ContentDTO;
import hr.pbz.sirius.admin.app.model.Content;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mcurkovic on 08.02.2016..
 */
@Service
public class ContentService {
  private static final Logger LOGGER = Logger.getLogger(MealService.class);

  @Autowired
  public ContentRepository repository;


  public List<Content> findPageableContent(int page, int pageSize) {
    return repository.findAll(new PageRequest(page, pageSize)).getContent();
  }

  public void save(Content content) {
    repository.save(Arrays.asList(content));
  }

  public Content findById(final Long id){
    return repository.findOne(id);
  }
}
