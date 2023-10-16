package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.HoaDonChiTiet;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietSerivce {

        boolean add(HoaDonChiTiet hoaDonChiTiet);
        HoaDonChiTiet findHoaDonChiTietbyIDHDandIDCTSP(UUID idhd,UUID idctsp);

        List<HoaDonChiTiet> findHoaDonChiTietById_IDHD(UUID idHD);
        BigDecimal getTongTien(UUID id);
        Boolean delete(HoaDonChiTiet hoaDonChiTiet);
}
