package br.com.sec.controller;


import br.com.sec.exception.NotFoundException;
import br.com.sec.models.vo.ClientVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sec.services.ClientService;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

// @CrossOrigin
@Api(tags = {"Client Resource"})
@RestController
@RequestMapping(value="/v1/clients")
public class ClientControllerV1 {
    @Autowired
    private ClientService clientService;

    @ApiOperation(value="List Clients")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<ClientVO> index(
            @RequestParam(name = "page", defaultValue = "0") String page,
            @RequestParam(name = "size", defaultValue = "10") String size,
            @RequestParam(name = "since_age", defaultValue = "0") String sinceAge,
            @RequestParam(name = "max_age", defaultValue = "9999") String maxAge
    ) {
        List<ClientVO> clients = clientService.findAll(Integer.parseInt(page), Integer.parseInt(size), Long.parseLong(sinceAge), Long.parseLong(maxAge));
        clients.forEach(p -> p.add(linkTo(methodOn(ClientControllerV1.class).show(p.getKey())).withSelfRel()));

        return clients;
    }

    // @CrossOrigin(origins = {"http://localhost:8080"})
    @ApiOperation(value="Create Client")
    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = { "application/json", "application/xml", "application/x-yaml" })
    public ClientVO create(@RequestBody ClientVO client) {
        ClientVO clientVo = clientService.create(client);
        clientVo.add(linkTo(methodOn(ClientControllerV1.class).show(clientVo.getKey())).withSelfRel());

        return clientVo;
    }

    @ApiOperation(value="Show Client")
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public ClientVO show(@PathVariable("id") Long id) throws NotFoundException {
        ClientVO clientVo = clientService.findById(id);
        clientVo.add(linkTo(methodOn(ClientControllerV1.class).show(id)).withSelfRel());

        return clientVo;
    }

    @ApiOperation(value="Update Client")
    @PutMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = { "application/json", "application/xml", "application/x-yaml" })
    public ClientVO update(@PathVariable("id") Long id, @RequestBody ClientVO client) throws NotFoundException {
        ClientVO clientVo = clientService.update(id, client);
        clientVo.add(linkTo(methodOn(ClientControllerV1.class).show(clientVo.getKey())).withSelfRel());

        return clientVo;
    }

    @ApiOperation(value="Delete Client")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws NotFoundException {
        clientService.delete(id);

        return ResponseEntity.ok().build();
    }
}
