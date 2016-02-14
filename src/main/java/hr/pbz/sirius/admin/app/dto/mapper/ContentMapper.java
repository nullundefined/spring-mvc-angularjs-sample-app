package hr.pbz.sirius.admin.app.dto.mapper;

import hr.pbz.sirius.admin.app.dto.ContentDTO;
import hr.pbz.sirius.admin.app.model.Content;
import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

/**
 * Created by mcurkovic on 14.02.2016..
 */
@Component
public class ContentMapper extends CustomMapper<Content, ContentDTO>{

}
