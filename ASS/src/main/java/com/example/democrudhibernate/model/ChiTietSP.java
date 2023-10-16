package com.example.democrudhibernate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name="chi_tiet_sp")
@Entity
@Data
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne()
    @JoinColumn(name = "id_sp")
    public SanPham sanPham;
    @ManyToOne()
    @JoinColumn(name="id_nsx")
    public NSX nsx;
    @ManyToOne()
    @JoinColumn(name="id_mau_sac")
    public MauSac mauSac;
    @ManyToOne()
    @JoinColumn(name="id_dong_sp")
    public DongSP dongSP;
    private int namBh;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private String hinh;

}
