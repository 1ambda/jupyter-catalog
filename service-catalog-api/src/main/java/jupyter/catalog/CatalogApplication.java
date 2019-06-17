package jupyter.catalog;

import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogApplication {

  public static void main(String[] args) {
    SpringApplication.run(CatalogApplication.class, args);
  }

  @PostConstruct
  void afterStartup() {
    // TODO: based on configuration
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));

    // set local
    Locale.setDefault(new Locale("en", "US"));
  }

  @PreDestroy
  void beforeShutdown() {

  }
}
