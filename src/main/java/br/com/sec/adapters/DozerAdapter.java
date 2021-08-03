package br.com.sec.adapters;

import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class DozerAdapter {
    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();

        for (Object o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }

    public static <O, D> List<D> parsePageObjects(Page<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();

        for (Object o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
