package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.responsitory.NhanVienRespon;
import com.example.democrudhibernate.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRespon nhanVienRespon;
    @Override
    public List<NhanVien> getALl() {
        return nhanVienRespon.findAll();
    }

    @Override
    public Boolean add(NhanVien nv) {
        nhanVienRespon.save(nv);
        return true;
    }

    @Override
    public Boolean delete(NhanVien nv) {
        nhanVienRespon.delete(nv);
        return null;
    }

    @Override
    public NhanVien timTheoID(UUID id) {
        return nhanVienRespon.findNhanVienById(id);
    }

    @Override
    public NhanVien findNhanVienByMaAndMatKhau(String user, String pass) {
        return nhanVienRespon.findNhanVienByMaAndMatKhau(user,pass);
    }
}
