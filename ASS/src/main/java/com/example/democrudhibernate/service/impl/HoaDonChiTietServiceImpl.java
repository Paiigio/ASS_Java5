package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.HoaDonChiTiet;
import com.example.democrudhibernate.responsitory.HoaDonChiTietRespon;
import com.example.democrudhibernate.service.HoaDonChiTietSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietSerivce {
    @Autowired
    HoaDonChiTietRespon hoaDonChiTietRespon;

    @Override
    public boolean add(HoaDonChiTiet hoaDonChiTiet) {
         hoaDonChiTietRespon.save(hoaDonChiTiet);
        return true;
    }

    @Override
    public HoaDonChiTiet findHoaDonChiTietbyIDHDandIDCTSP(UUID idhd, UUID idctsp) {
        return hoaDonChiTietRespon.findHoaDonChiTietById_IdHoaDon_IdAndId_IdChiTietSp_Id(idhd,idctsp);
    }

    @Override
    public List<HoaDonChiTiet> findHoaDonChiTietById_IDHD(UUID idHD) {
        return hoaDonChiTietRespon.findHoaDonChiTietsById_IdHoaDon_Id(idHD);
    }

    @Override
    public BigDecimal getTongTien(UUID id) {
        return hoaDonChiTietRespon.getTongTien(id);
    }

    @Override
    public Boolean delete(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRespon.delete(hoaDonChiTiet);
        return null;
    }


}
