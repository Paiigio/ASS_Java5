package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.SanPham;
import com.example.democrudhibernate.responsitory.SanPhamRespon;
import com.example.democrudhibernate.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    SanPhamRespon sanPhamRespon;
    @Override
    public List<SanPham> getALl() {
        return sanPhamRespon.findAll();
    }

    @Override
    public Boolean add(SanPham sp) {
        sanPhamRespon.save(sp);
        return true;
    }

    @Override
    public Boolean delete(SanPham sp) {
        sanPhamRespon.delete(sp);
        return true;
    }

    @Override
    public SanPham timTheoID(UUID id) {
        return sanPhamRespon.findSanPhamById(id);
    }
}
