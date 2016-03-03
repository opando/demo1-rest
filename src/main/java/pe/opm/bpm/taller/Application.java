package pe.opm.bpm.taller;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("pe.opm.bpm.taller")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)        		
        		.groupName("fisca-api")
        		.select()        		
        		.apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
                .apiInfo(apiInfo());
                
        
        //.paths(regex("/fiscalizables.*"))
        //.pathMapping("/")
                //.genericModelSubstitutes(ResponseEntity.class);
    }
     
    @SuppressWarnings("unchecked")
	private Predicate<String> paths() {
        return or(
            regex("/fiscalizables.*"),
            regex("/auditores.*")
            );
      }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Servicios taller IIB")
                .description("Servicios de prueba para los laboratorios")
                //.termsOfServiceUrl("https://github.com/opando")
                .contact("opando")
                //.license("Apache License Version 2.0")
                //.licenseUrl("https://github.com/opando")
                .version("1.0")
                .build();
    }
}
