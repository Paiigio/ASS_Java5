package com.example.democrudhibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "cua_hang")
@Entity
@Data
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;
    private String ma;
    private String ten;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
}
