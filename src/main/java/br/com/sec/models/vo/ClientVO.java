package br.com.sec.models.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "id", "age", "firstName", "lastName" })
public class ClientVO extends ResourceSupport {
    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    @JsonProperty("age")
    private Long age;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
}
