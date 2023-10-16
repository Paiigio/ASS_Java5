package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.NSX;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    List<NSX> getALl();
    Boolean add(NSX nsx);
    Boolean delete(NSX nsx);
    NSX timTheoID(UUID id);
}
