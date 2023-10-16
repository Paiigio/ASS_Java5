package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.ChucVu;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChucVuRespon extends JpaRepository<ChucVu, UUID> {
    ChucVu findChucVuById(UUID id);

}
