package com.example.demo.client;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;

import javax.inject.Inject;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * elastic search client
 */
@Configuration
public class ESClient {

    private Client client;

    @Inject
    public void init() throws Exception {

        // es集群节点
        TransportAddress node1 = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);
        TransportAddress node2 = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9301);
        TransportAddress node3 = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9302);

        // es集群配置
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .put("client.transport.sniff", true)
                .build();

        TransportClient transportClient = new PreBuiltTransportClient(settings);

        transportClient.addTransportAddress(node1)
                .addTransportAddress(node2)
                .addTransportAddress(node3);

        client = transportClient;
    }
}
