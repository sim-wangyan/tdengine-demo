package io.xream.demo;


import io.xream.x7.EnableCorsConfig;
import io.xream.x7.EnableDateToLongForJackson;
import io.xream.x7.EnableX7Repository;
import io.xream.x7.repository.id.autoconfigure.IdGeneratorAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {IdGeneratorAutoConfiguration.class})
@EnableX7Repository(mappingPrefix = "t_",mappingSpec = "_")
@EnableDateToLongForJackson
@EnableCorsConfig("${access.domain}")
public class App {

    public static void main( String[] args )
    {
    	SpringApplication.run(App.class);
    }

}