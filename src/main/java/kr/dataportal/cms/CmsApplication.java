package kr.dataportal.cms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CmsApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CmsApplication.class)
                .properties("spring.config.location=" +
                        "classpath:/application.properties" +
                        ",classpath:/application-jpa.properties"
                )
                .run(args);
    }

}
