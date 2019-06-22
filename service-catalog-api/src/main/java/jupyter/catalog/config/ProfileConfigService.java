package jupyter.catalog.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("services")
@Getter
public class ProfileConfigService {
    String notebookEndpoint;
    int notebookPort;
}
