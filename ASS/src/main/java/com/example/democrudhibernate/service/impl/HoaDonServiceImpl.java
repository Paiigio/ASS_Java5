package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.HoaDon;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.responsitory.HoaDonRepon;
import com.example.democrudhibernate.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepon hoaDonRepon;
    @Override
    public List<HoaDon> getALl() {
        return hoaDonRepon.findAll();
    }

    @Override
    public Boolean add(HoaDon hd) {
        hoaDonRepon.save(hd);
        return null;
    }

    @Override
    public Boolean delete(HoaDon dsp) {
        hoaDonRepon.delete(dsp);
        return null;
    }

    @Override
    public List<HoaDon> findHoaDonByNhanVienAndTinhTrang(NhanVien nhanVien, int TT) {
        return hoaDonRepon.findHoaDonByNhanVienAndTinhTrang(nhanVien,TT);
    }

    @Override
    public HoaDon updateKHofHD(String idkh, String idHD) {
        return hoaDonRepon.updateKHofHD(idkh,idHD);
    }

    @Override
    public HoaDon findHDbyID(UUID id) {
        return hoaDonRepon.findHoaDonById(id);
    }

    @Override
    public BigDecimal getDoanhThuNgay() {
        return getDoanhThuNgay();
    }

    @Override
    public BigDecimal getDoanhThuThang() {
        return getDoanhThuThang();
    }

    @Override
    public BigDecimal getDoanhThuNam() {
        return getDoanhThuNam();
    }


}
