package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SanPhamRespon extends JpaRepository<SanPham, UUID> {
    SanPham findSanPhamById(UUID id);
}
