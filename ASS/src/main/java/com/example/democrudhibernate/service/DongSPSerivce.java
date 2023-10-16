package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.DongSP;

import java.util.List;
import java.util.UUID;

public interface DongSPSerivce {

    List<DongSP> getALl();
    Boolean add(DongSP dsp);
    Boolean delete(DongSP dsp);
    DongSP timTheoID(UUID id);
}
