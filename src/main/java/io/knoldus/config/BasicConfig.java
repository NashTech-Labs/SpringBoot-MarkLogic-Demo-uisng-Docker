package io.knoldus.config;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.JSONDocumentManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class BasicConfig {
    @Value("${marklogic.host}")
    private String host;

    @Value("${marklogic.port}")
    private int port;

    @Value("${marklogic.username}")
    private String username;

    @Value("${marklogic.password}")
    private String password;

    @Bean
    public DatabaseClient databaseClient() {
        return DatabaseClientFactory.newClient(host, port, new DatabaseClientFactory.DigestAuthContext(username, password));
    }

    @Bean
    public JSONDocumentManager getJSONDocumentManager() {
        return databaseClient().newJSONDocumentManager();
    }


    @Bean
    public String getMarkLogicBaseURL() {
        return String.format("http://%s:%d", host, port);
    }
}
