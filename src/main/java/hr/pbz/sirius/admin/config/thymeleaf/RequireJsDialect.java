package hr.pbz.sirius.admin.config.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matija on 30.11.15..
 */
public class RequireJsDialect extends AbstractDialect {


    @Autowired
    private DataMainAttrProcessor dataMainAttrProcessor;

    public RequireJsDialect() {
        super();
    }

    //
    // All of this dialect's attributes and/or tags
    // will start with 'hello:'
    //
    public String getPrefix() {
        return "require";
    }


    //
    // The processors.
    //
    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(dataMainAttrProcessor);
        return processors;
    }

}