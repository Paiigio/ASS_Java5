package com.example.democrudhibernate.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoaDonChiTiet {
    @EmbeddedId
    private IdHoaDonChiTiet id;

    private Integer soLuong;

    private BigDecimal donGia;

}
