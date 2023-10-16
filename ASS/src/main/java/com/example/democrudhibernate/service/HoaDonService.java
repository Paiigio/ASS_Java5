package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.HoaDon;
import com.example.democrudhibernate.model.NhanVien;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    List<HoaDon> getALl();

    Boolean add(HoaDon dsp);

    Boolean delete(HoaDon dsp);

    List<HoaDon> findHoaDonByNhanVienAndTinhTrang(NhanVien nhanVien, int TT);

    HoaDon updateKHofHD(String idkh, String idHD);

    HoaDon findHDbyID(UUID id);
    BigDecimal getDoanhThuNgay();
    BigDecimal getDoanhThuThang();
    BigDecimal getDoanhThuNam();
}
