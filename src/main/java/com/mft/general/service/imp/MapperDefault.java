package com.mft.general.service.imp;

import com.mft.general.service.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author m.fatahi
 */
@Component
@RequiredArgsConstructor
public class MapperDefault implements Mapper {

    private final ModelMapper mapper;

    /**
     *
     * @param source
     * @param destinationType
     * @param <T>
     * @param <S>
     * @return
     */
    @Override
    public <T, S> T map(@NotNull S source, Class<T> destinationType) {
        return mapper.map(source, destinationType);
    }

    /**
     *
     * @param sources
     * @param destinationType
     * @param <T>
     * @param <S>
     * @return
     */
    @Override
    public <T, S> List<T> map(@NotNull Collection<S> sources, Class<T> destinationType) {
        return sources.stream().map(source -> map(source, destinationType)).collect(Collectors.toList());
    }
}
