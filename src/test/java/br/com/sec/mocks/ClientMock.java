package br.com.sec.mocks;

import br.com.sec.models.Client;
import br.com.sec.models.vo.ClientVO;

import java.util.ArrayList;
import java.util.List;

public class ClientMock {
    public Client mockEntity() {
        return mockEntity(0);
    }

    public ClientVO mockVO() {
        return mockVO(0);
    }

    public List<Client> mockEntityList() {
        List<Client> entities = new ArrayList<Client>();

        for (int i = 0; i < 14; i++) {
            entities.add(mockEntity(i));
        }

        return entities;
    }

    public List<ClientVO> mockVOList() {
        List<ClientVO> entities = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            entities.add(mockVO(i));
        }

        return entities;
    }

    private Client mockEntity(Integer number) {
        Client entity = new Client();

        entity.setId(number.longValue());
        entity.setAge(number.longValue());
        entity.setFirstName("First Name Test Entity" + number);
        entity.setLastName("Last Name Test Entity" + number);

        return entity;
    }

    private ClientVO mockVO(Integer number) {
        ClientVO entity = new ClientVO();

        entity.setKey(number.longValue());
        entity.setAge(number.longValue());
        entity.setFirstName("First Name Test EntityVO" + number);
        entity.setLastName("Last Name Test EntityVO" + number);

        return entity;
    }

}