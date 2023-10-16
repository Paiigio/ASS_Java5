package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.KhachHang;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.service.KhachHangSerivce;
import com.example.democrudhibernate.service.NhanVienService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired

    KhachHangSerivce khachHangSerivce;
    @Autowired
    HttpServletRequest request;
    @Autowired
    NhanVienService nhanVienService;
    public void upTTNV(Model model){
        String value = "";
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("idNV")) {
                    value = cookie.getValue();
                }
            }
        }
        NhanVien nhanVien=nhanVienService.timTheoID(UUID.fromString(value));
        model.addAttribute("tenDN",nhanVien.getTen());
        model.addAttribute("maDN",nhanVien.getMa());
        model.addAttribute("hinhDN",nhanVien.getHinh());
    }
    @GetMapping("/hien-thi")
    private String getALl(Model model){
        model.addAttribute("sv",new KhachHang());
        model.addAttribute("list",khachHangSerivce.getALl());
        upTTNV(model);
        return "KhachHang";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        KhachHang khachHang = khachHangSerivce.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",khachHang);
        model.addAttribute("list",khachHangSerivce.getALl());
        upTTNV(model);
        return "KhachHang";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){
        KhachHang khachHang = khachHangSerivce.timTheoID(UUID.fromString(id));
        khachHangSerivce.delete(khachHang);
        model.addAttribute("sv", new KhachHang());
        model.addAttribute("list",khachHangSerivce.getALl());
        upTTNV(model);
        return "KhachHang";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("cv") KhachHang khachHang, Model model){
        khachHangSerivce.add(khachHang);
        model.addAttribute("sv", new KhachHang());
        model.addAttribute("list",khachHangSerivce.getALl());
        upTTNV(model);
        return "KhachHang";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("sv") KhachHang khachHang, Model model){
        khachHangSerivce.add(khachHang);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("list",khachHangSerivce.getALl());
        model.addAttribute("sv", new KhachHang());
        upTTNV(model);
        return "KhachHang";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        KhachHang khachHang = khachHangSerivce.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",khachHang);
        model.addAttribute("list",khachHangSerivce.getALl());
        upTTNV(model);
        return "KhachHangUpdate";
    }
}
