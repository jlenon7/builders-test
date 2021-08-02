package br.com.sec.config;

import br.com.sec.converters.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // Via Extension, localhost:8080/persons.xml

        // configurer
        //     .favorParameter(false)
        //     .ignoreAcceptHeader(false)
        //     .defaultContentType(MediaType.APPLICATION_JSON)
        //     .mediaType("json", MediaType.APPLICATION_JSON)
        //     .mediaType("xml", MediaType.APPLICATION_XML);

        // Via Query param, localhost:8080/persons?mediaType=xml

        // configurer
        //    .favorPathExtension(false)
        //    .favorParameter(true)
        //    .parameterName("mediaType")
        //    .ignoreAcceptHeader(true)
        //    .useRegisteredExtensionsOnly(false)
        //    .defaultContentType(MediaType.APPLICATION_JSON)
        //    .mediaType("json", MediaType.APPLICATION_JSON)
        //    .mediaType("xml", MediaType.APPLICATION_XML);

        // Via Header, pelo Accept=application/xml

         configurer
            .favorPathExtension(false)
            .favorParameter(false)
            .ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML)
            .mediaType("x-yaml", MEDIA_TYPE_YML);
    }
}
