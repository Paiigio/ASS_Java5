package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.ChiTietSP;
import com.example.democrudhibernate.model.NhanVien;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTietSP> getALl();
    Boolean add(ChiTietSP ctsp);
    Boolean delete(ChiTietSP ctsp);
    ChiTietSP timTheoID(UUID id);
}
