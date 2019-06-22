package jupyter.notebook;


import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import jupyter.notebook.generated.swagger.client.api.DisplayControllerApi;
import jupyter.notebook.generated.swagger.model.RenderedNotebookDTO;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayControllerApiTest {

    @EnabledIfSystemProperty(named = "os.name", matches = "Mac OS X")
    @Test
    public void displayNotebook() {

        val displayClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(DisplayControllerApi.class))
                .logLevel(Logger.Level.FULL)
                .target(DisplayControllerApi.class, "http://localhost:9092/api");

        val path = "asset/notebook/1ambda/hello_world.ipynb";
        RenderedNotebookDTO dto = displayClient.displayNotebook(path);
        assertThat(dto.getPath()).isEqualTo(path);
    }
}
