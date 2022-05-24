package com.gabriel.amaristest.price.interfaces;

public interface ModelMapperService {

    <D, E> D convert(E element, Class<D> destinationType);
}
