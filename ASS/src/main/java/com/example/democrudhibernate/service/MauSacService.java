package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getALl();
    Boolean add(MauSac ms);
    Boolean delete(MauSac ms);
    MauSac timTheoID(UUID id);
}
