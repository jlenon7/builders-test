package br.com.sec.models.vo;

import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "age", "firstName", "lastName" })
public class ClientVO extends ResourceSupport {
    public ClientVO() {}

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    @JsonProperty("age")
    private Long age;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    /**
     * Getters & Setters
     */

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Equals & Hash Code
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientVO)) return false;
        if (!super.equals(o)) return false;

        ClientVO clientVO = (ClientVO) o;

        if (!getKey().equals(clientVO.getKey())) return false;
        if (!getAge().equals(clientVO.getAge())) return false;
        if (!getFirstName().equals(clientVO.getFirstName())) return false;
        return getLastName().equals(clientVO.getLastName());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getKey().hashCode();
        result = 31 * result + getAge().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }
}
