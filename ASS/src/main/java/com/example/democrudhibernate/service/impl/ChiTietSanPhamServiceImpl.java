package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.ChiTietSP;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.responsitory.ChiTietSanPhamRespon;
import com.example.democrudhibernate.responsitory.NhanVienRespon;
import com.example.democrudhibernate.service.ChiTietSanPhamService;
import com.example.democrudhibernate.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRespon chiTietSanPhamRespon;
    @Override
    public List<ChiTietSP> getALl() {
        return chiTietSanPhamRespon.findAll();
    }

    @Override
    public Boolean add(ChiTietSP ctsp) {
        chiTietSanPhamRespon.save(ctsp);
        return true;
    }

    @Override
    public Boolean delete(ChiTietSP ctsp) {
        chiTietSanPhamRespon.delete(ctsp);
        return null;
    }

    @Override
    public ChiTietSP timTheoID(UUID id) {
        return chiTietSanPhamRespon.findChiTietSPById(id);
    }

}
