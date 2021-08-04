package br.com.sec.controller;

import br.com.sec.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(tags = {"Welcome Resource"})
@RestController
@RequestMapping(value="/")
public class WelcomeController {
    @ApiOperation(value="Home")
    @GetMapping(value = "/", produces = { "application/json", "application/xml", "application/x-yaml" })
    public Greeting home() throws IOException {
        return new Greeting("/", "Welcome to Builder Test API");
    }

    @ApiOperation(value="Healthcheck")
    @GetMapping(value = "/healthcheck", produces = { "application/json", "application/xml", "application/x-yaml" })
    public Greeting healthcheck() throws IOException {
        return new Greeting("/healthcheck", "Welcome to Builder Test API");
    }
}
