package br.com.sec.adapters;

import java.util.List;

import br.com.sec.mocks.ClientMock;
import br.com.sec.models.Client;
import br.com.sec.models.vo.ClientVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DozerAdapterTest {

    ClientMock inputObject;

    @Before
    public void setUp() {
        inputObject = new ClientMock();
    }

    @Test
    public void parseEntityToVOTest() {
        ClientVO output = DozerAdapter.parseObject(inputObject.mockEntity(), ClientVO.class);

        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals(Long.valueOf(0L), output.getAge());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<ClientVO> outputList = DozerAdapter.parseListObjects(inputObject.mockEntityList(), ClientVO.class);
        ClientVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals(Long.valueOf(0L), outputZero.getAge());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());

        ClientVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getAge());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());

        ClientVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getAge());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
    }

    @Test
    public void parseVOToEntityTest() {
        Client output = DozerAdapter.parseObject(inputObject.mockVO(), Client.class);

        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals(Long.valueOf(0L), output.getAge());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Client> outputList = DozerAdapter.parseListObjects(inputObject.mockVOList(), Client.class);
        Client outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals(Long.valueOf(0L), outputZero.getAge());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());

        Client outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals(Long.valueOf(7L), outputZero.getAge());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());

        Client outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals(Long.valueOf(12L), outputZero.getAge());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
    }
}