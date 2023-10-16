package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();
    boolean add(CuaHang c);
    List<CuaHang> timTheoTen(String ten,String ma);
    CuaHang timTheoID(UUID id);
    CuaHang update(UUID id ,CuaHang cuaHang);
    Boolean delete(CuaHang ch);
}
