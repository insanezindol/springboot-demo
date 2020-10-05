package kr.co.lunasoft.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.PostConstruct;
import java.net.InetAddress;

@EnableElasticsearchRepositories
@Configuration
public class ElasticConfiguration implements AutoCloseable {

    @Value("${spring.elasticsearch.clusterName}")
    private String clusterName;

    @Value("${spring.elasticsearch.host}")
    private String host;

    @Value("${spring.elasticsearch.port}")
    private int port;

    @Value("${spring.elasticsearch.resthost}")
    private String resthost;

    @Value("${spring.elasticsearch.restport}")
    private int restport;

    RestClient restClient;

    TransportClient client;

    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    @Bean
    public Client client() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();

        client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }

    @Bean
    public RestClient restClient() {
        restClient = RestClient.builder(new HttpHost(resthost, restport)).build();
        return restClient;
    }

    @Override
    public void close() throws Exception {
        client.close();
        restClient.close();
    }

}