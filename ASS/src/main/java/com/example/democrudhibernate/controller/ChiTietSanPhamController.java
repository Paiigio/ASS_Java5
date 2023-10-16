package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.ChiTietSP;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.model.SanPham;
import com.example.democrudhibernate.service.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    NSXService nsxService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    DongSPSerivce dongSPSerivce;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("/hien-thi")
    private String getALl(Model model){
        load(model);
        upTTNV(model);
        return "ChiTietSanPham";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        ChiTietSP chiTietSP = chiTietSanPhamService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",chiTietSP);
        model.addAttribute("list",chiTietSanPhamService.getALl());
        model.addAttribute("listSP",sanPhamService.getALl());
        model.addAttribute("listNSX",nsxService.getALl());
        model.addAttribute("listMS",mauSacService.getALl());
        model.addAttribute("listDSP",dongSPSerivce.getALl());
        upTTNV(model);
        return "ChiTietSanPham";

    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){
        ChiTietSP chiTietSP = chiTietSanPhamService.timTheoID(UUID.fromString(id));
        chiTietSanPhamService.delete(chiTietSP);
        load(model);
        upTTNV(model);
        return "ChiTietSanPham";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("cv") ChiTietSP chiTietSP, Model model){
        chiTietSanPhamService.add(chiTietSP);
        upTTNV(model);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        ChiTietSP chiTietSP = chiTietSanPhamService.timTheoID(UUID.fromString(id));
        load(model);
        upTTNV(model);
        model.addAttribute("sv", chiTietSP);
        return "ChiTietSanPhamUpdate";
    }

    @PostMapping("/update")
    private String update(@ModelAttribute("sv") ChiTietSP cv, Model model){
        chiTietSanPhamService.add(cv);
        model.addAttribute("ThongBao","Cập nhật thành công");
        load(model);
        upTTNV(model);
        return "ChiTietSanPham";
    }
    public void load(Model model){
        model.addAttribute("sv", new ChiTietSP());
        model.addAttribute("list",chiTietSanPhamService.getALl());
        model.addAttribute("listSP",sanPhamService.getALl());
        model.addAttribute("listNSX",nsxService.getALl());
        model.addAttribute("listMS",mauSacService.getALl());
        model.addAttribute("listDSP",dongSPSerivce.getALl());
    }
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
}
