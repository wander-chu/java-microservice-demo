package com.demo.democonsumer.client.fallback;

import com.demo.democonsumer.client.InfoClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class InfoFallBack implements InfoClient {

    @Override
    public String getDefaultInfo() {
        return "fallback info";
    }

    @Override
    public String getInfo(String name) {
        return "fallback default info";
    }

}
