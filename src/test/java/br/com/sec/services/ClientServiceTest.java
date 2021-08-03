package br.com.sec.services;

import br.com.sec.models.Client;
import br.com.sec.models.vo.ClientVO;
import br.com.sec.repositories.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepositoryMock;

    @InjectMocks
    private ClientService clientService;

    private Client clientMock;

    @Before
    public void setUp() {
        Client clientToReturnRepository = new Client();

        clientToReturnRepository.setId(1L);
        clientToReturnRepository.setAge(20L);
        clientToReturnRepository.setFirstName("João");
        clientToReturnRepository.setLastName("Lenon");

        this.clientMock = clientToReturnRepository;

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findById() {
        doReturn(Optional.of(clientMock)).when(clientRepositoryMock).findById(1L);

        Long id = 1L;
        ClientVO clientVO = this.clientService.findById(id);

        Assert.assertEquals(id, clientVO.getKey());
        Assert.assertEquals("João", clientVO.getFirstName());
    }

    @Test
    public void save() {
        Client client = new Client();

        client.setId(2L);
        client.setAge(44L);
        client.setFirstName("Juares");
        client.setLastName("Martini");

        doReturn(client).when(clientRepositoryMock).save(ArgumentMatchers.any(Client.class));

        ClientVO clientVOToCreate = new ClientVO();

        clientVOToCreate.setAge(44L);
        clientVOToCreate.setFirstName("Juares");
        clientVOToCreate.setLastName("Martini");

        ClientVO clientVO = this.clientService.create(clientVOToCreate);

        Assert.assertEquals(client.getId(), clientVO.getKey());
        Assert.assertEquals(client.getFirstName(), clientVO.getFirstName());
    }
}
