package com.mft.general.service;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

public interface Mapper {

    <T, S> T map(@NotNull S source, Class<T> destinationType);

    <T, S> List<T> map(@NotNull Collection<S> list, Class<T> destinationType);

}
