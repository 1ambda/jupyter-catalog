package jupyter.notebook.common;

import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

import java.nio.charset.Charset;

public class SwaggerClientApi {

    public static String getBaseUrl(String host, int port) {
        return new StringBuilder()
                .append("http://")
                .append(host)
                .append(":")

                .append(port)
                .append("/api")
                .toString();
    }

    public static <T> T buildClient(Class<? extends T> type,
                                    String host, int port,
                                    String username, String password,
                                    Logger.Level level) {
        Feign.Builder builder =
                Feign.builder()
                        .decoder(new JacksonDecoder())
                        .encoder(new JacksonEncoder())
                        .logLevel(level)
                        .logger(new Slf4jLogger(type))
                        .errorDecoder(new SwaggerClientErrorDecoder());

        if (username != null && password != null) {
            builder.requestInterceptor(
                    new BasicAuthRequestInterceptor(username, password, Charset.forName("UTF-8")));
        }

        T client = builder.target(type, getBaseUrl(host, port));
        return client;
    }
}
