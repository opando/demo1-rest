package pe.opm.bpm.taller;

import static springfox.documentation.builders.PathSelectors.regex;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.google.common.base.Predicates.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;
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

	private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws UnknownHostException {
        //SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        //addDefaultProfile(app, source);
        Environment env = app.run(args).getEnvironment();
        log.info("Access URLs:\n----------------------------------------------------------\n\t" +
                "Local: \t\thttp://127.0.0.1:{}\n\t" +
                "External: \thttp://{}:{}/demo-iib/swagger-ui.html\n----------------------------------------------------------",
            env.getProperty("server.port"),
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"));
    }
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)        		
        		.groupName("demo-iib-api")
        		.select()        		
        		.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
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
            regex("/auditores.*"),
            regex("/cuentas.*"),
            regex("/debitar.*"),
            regex("/pagar.*"),
            regex("/recibos.*")
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
