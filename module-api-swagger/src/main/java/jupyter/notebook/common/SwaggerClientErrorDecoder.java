package jupyter.notebook.common;

import java.io.IOException;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import jupyter.common.exception.*;

public class SwaggerClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        int status = response.status();

        Decoder.Default decoder = new Decoder.Default();
        String body;
        try {
            body = (String) decoder.decode(response, String.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch (status) {
            case 400:
                return new BadRequestException(body);
            case 401:
                return new UnauthorizedException(body);
            case 403:
                return new ForbiddenException(body);
            case 404:
                return new NotFoundException(body);
            case 409:
                return new DuplicatedException(body);
            case 500:
                return new InternalServerException(body);
            default:
                throw new RuntimeException("Unknown response");
        }
    }
}
