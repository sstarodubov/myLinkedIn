package configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import java.io.IOException;

@Configuration
@ComponentScan({
        "controllers",
        "filters",
        "listeners",
        "services"
})
public class ServiceConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(getResult());
        return conf;
    }

    private static Resource[] getResult() {
        return new Resource[] {new ClassPathResource("application.properties")};
    }
}
