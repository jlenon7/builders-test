package br.com.sec.services;

import java.util.List;

import br.com.sec.adapters.DozerAdapter;
import br.com.sec.models.Client;
import br.com.sec.models.vo.ClientVO;
import br.com.sec.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.sec.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientVO findById(Long id) {
        Client entity = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("No records found for this ID"));

        return DozerAdapter.parseObject(entity, ClientVO.class);
    }

    public ClientVO create(ClientVO client) {
        Client entity = DozerAdapter.parseObject(client, Client.class);
        System.out.println(entity);

        return DozerAdapter.parseObject(clientRepository.save(entity), ClientVO.class);
    }

    public ClientVO update(Long id, ClientVO client) {
        ClientVO entity = findById(id);

        entity.setAge(client.getAge());
        entity.setFirstName(client.getFirstName());
        entity.setLastName(client.getLastName());

        return create(entity);
    }

    public void delete(Long id) {
        clientRepository.delete(DozerAdapter.parseObject(findById(id), Client.class));
    }

    public List<ClientVO> findAll(Integer page, Integer size) {
        return DozerAdapter.parsePageObjects(clientRepository.findAll(PageRequest.of(page, size)), ClientVO.class);
    }
}
