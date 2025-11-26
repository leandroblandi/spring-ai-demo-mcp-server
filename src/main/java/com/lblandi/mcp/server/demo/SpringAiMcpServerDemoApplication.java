package com.lblandi.mcp.server.demo;

import com.lblandi.mcp.server.demo.service.PersonServiceImpl;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringAiMcpServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiMcpServerDemoApplication.class, args);
    }

    @Bean
    List<ToolCallback> tools(PersonServiceImpl personService) {
        return List.of(ToolCallbacks.from(personService));
    }
}
