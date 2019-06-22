package jupyter.notebook;


import feign.Logger;
import feign.RetryableException;
import jupyter.common.exception.BadRequestException;
import jupyter.common.SwaggerClientApi;
import jupyter.notebook.generated.swagger.client.api.DisplayControllerApi;
import jupyter.notebook.generated.swagger.model.RenderedNotebookDTO;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayControllerApiTest {

    @EnabledIfSystemProperty(named = "os.name", matches = "Mac OS X")
    @Test
    public void displayNotebook() {

        val displayClient = SwaggerClientApi.buildClient(
                DisplayControllerApi.class,
                "localhost", 9092, null, null,
                Logger.Level.FULL);

        val path = "asset/notebook/1ambda/hello_world.ipynb";
        RenderedNotebookDTO dto = displayClient.displayNotebook(path);
        assertThat(dto.getPath()).isEqualTo(path);
    }

    @EnabledIfSystemProperty(named = "os.name", matches = "Mac OS X")
    @Test
    public void displayNotebook_returnBadRequest() {
        Assertions.assertThrows(BadRequestException.class, () -> {
            DisplayControllerApi client = SwaggerClientApi.buildClient(
                    DisplayControllerApi.class,
                    "localhost", 9092, null, null,
                    Logger.Level.FULL);

            String path = "asset/notebook/1ambda/non_existing_notebook.ipynb";
            client.displayNotebook(path);
        });
    }

    @Test
    public void displayNotebook_returnConnectionRefused() {
        final int unknownPort = 3092;
        val thrown = Assertions.assertThrows(RetryableException.class, () -> {
            DisplayControllerApi client = SwaggerClientApi.buildClient(
                    DisplayControllerApi.class,
                    "localhost", unknownPort, null, null,
                    Logger.Level.NONE);

            String path = "asset/notebook/1ambda/non_existing_notebook.ipynb";
            client.displayNotebook(path);
        });

        assertThat(thrown).hasMessageContaining("Connection refused");
    }
}
