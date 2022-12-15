package com.develop.springapi.mapper;

public interface IMapper <I, O>{

    public O map(I in);
}
