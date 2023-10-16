package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CuaHangRespon extends JpaRepository<CuaHang, UUID> {
    List<CuaHang> findByTenAndMaOrderByMaDesc(String ten, String ma);

    CuaHang findCuaHangById(UUID id);
//    @Query (value = "select * from cua_hang", nativeQuery = true);
//    List<CuaHang> getAll();
}