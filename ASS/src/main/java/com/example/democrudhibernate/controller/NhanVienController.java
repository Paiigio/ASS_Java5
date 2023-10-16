package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.NSX;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.service.ChucVuService;
import com.example.democrudhibernate.service.CuaHangService;
import com.example.democrudhibernate.service.NhanVienService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    ChucVuService chucVuService;
    @Autowired
    CuaHangService cuaHangService;
    @Autowired
    HttpServletRequest request;


    @GetMapping("/hien-thi")
    private String getALl(Model model){
        model.addAttribute("sv",new NhanVien());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        model.addAttribute("list",nhanVienService.getALl());

        upTTNV(model);
        return "NhanVien";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        NhanVien nhanVien = nhanVienService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",nhanVien);
        model.addAttribute("list",nhanVienService.getALl());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        upTTNV(model);
        return "NhanVien";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){
        NhanVien nhanVien = nhanVienService.timTheoID(UUID.fromString(id));
        nhanVienService.delete(nhanVien);
        model.addAttribute("sv", new NhanVien());
        model.addAttribute("list",nhanVienService.getALl());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        upTTNV(model);
        return "NhanVien";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("cv") NhanVien nhanVien, Model model){
        nhanVienService.add(nhanVien);
        model.addAttribute("sv", new NhanVien());
        upTTNV(model);
        return "redirect:/nhan-vien/hien-thi";
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
