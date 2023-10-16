package com.example.democrudhibernate.controller;


import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.model.SanPham;
import com.example.democrudhibernate.service.NhanVienService;
import com.example.democrudhibernate.service.SanPhamService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController{
    @Autowired
    SanPhamService sanPhamService;
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
    private String getALL(Model model) {
        model.addAttribute("list", sanPhamService.getALl());
        model.addAttribute("sv", new SanPham());
        return "SanPham";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("sv") SanPham cv, Model model){
        sanPhamService.add(cv);
        model.addAttribute("list",sanPhamService.getALl());
        model.addAttribute("sv", new SanPham() );
        upTTNV(model);
        return "SanPham";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("sv") SanPham cv, Model model){
        sanPhamService.add(cv);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("list",sanPhamService.getALl());
        model.addAttribute("sv", new SanPham());
        upTTNV(model);
        return "SanPham";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        SanPham cv = sanPhamService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",cv);
        model.addAttribute("list",sanPhamService.getALl());
        upTTNV(model);
        return "SanPhamUpdate";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        SanPham sanPham = sanPhamService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",sanPham);
        model.addAttribute("list",sanPhamService.getALl());
        upTTNV(model);
        return "SanPham";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id,Model model){
        SanPham sanPham = sanPhamService.timTheoID(UUID.fromString(id));
        sanPhamService.delete(sanPham);
        model.addAttribute("sv",new SanPham());
        model.addAttribute("list",sanPhamService.getALl());
        upTTNV(model);
        return "SanPham";
    }

}
