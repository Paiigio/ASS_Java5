package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChiTietSanPhamRespon  extends JpaRepository<ChiTietSP, UUID> {
    ChiTietSP findChiTietSPById(UUID id);
}
