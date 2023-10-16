package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.HoaDon;
import com.example.democrudhibernate.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Repository
public interface HoaDonRepon extends JpaRepository<HoaDon, UUID> {
    List<HoaDon> findHoaDonByNhanVienAndTinhTrang(NhanVien nhanVien, int tt);
    HoaDon findHoaDonById(UUID id);
    @Query(value = "update HoaDon set KhachHang.id =:idKH where id=:id ",nativeQuery = true)
    HoaDon updateKHofHD(String idKH,String id);

    @Query(value = "SELECT SUM(thanh_tien) FROM hoa_don WHERE YEAR(ngay_thanh_toan)=YEAR(getdate()) AND MONTH(ngay_thanh_toan)=MONTH(getdate()) AND DAY(ngay_thanh_toan)=DAY(getdate()) AND tinh_trang=1",nativeQuery = true)
    BigDecimal getDoanhThuNgay();
    @Query(value = "SELECT SUM(thanh_tien) FROM hoa_don WHERE YEAR(ngay_thanh_toan)=YEAR(getdate()) AND MONTH(ngay_thanh_toan)=MONTH(getdate()) AND tinh_trang=1",nativeQuery = true)
    BigDecimal getDoanhThuThang();
    @Query(value = "SELECT SUM(thanh_tien) FROM hoa_don WHERE YEAR(ngay_thanh_toan)=YEAR(getdate())  AND tinh_trang=1",nativeQuery = true)
    BigDecimal getDoanhThuNam();

    @Query(value = "SELECT COUNT(ma) FROM hoa_don WHERE YEAR(ngay_thanh_toan)=YEAR(getdate()) AND MONTH(ngay_thanh_toan)=MONTH(getdate()) AND DAY(ngay_thanh_toan)=DAY(getdate()) AND tinh_trang=1",nativeQuery = true)
    Integer getHDNgay();
}
