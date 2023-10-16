package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getALl();
    Boolean add(SanPham sp);
    Boolean delete(SanPham sp);
    SanPham timTheoID(UUID id);
}
