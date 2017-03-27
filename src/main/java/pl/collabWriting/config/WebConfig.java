package pl.collabWriting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author kattie95
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("user/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}