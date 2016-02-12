package hr.pbz.sirius.admin.config;


import hr.pbz.sirius.admin.config.root.AppSecurityConfig;
import hr.pbz.sirius.admin.config.root.DevelopmentConfiguration;
import hr.pbz.sirius.admin.config.root.RootContextConfig;
import hr.pbz.sirius.admin.config.root.TestConfiguration;
import hr.pbz.sirius.admin.config.servlet.ServletContextConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * Replacement for most of the content of web.xml, sets up the root and the servlet context config.
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootContextConfig.class, DevelopmentConfiguration.class, TestConfiguration.class,
                AppSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {ServletContextConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}


