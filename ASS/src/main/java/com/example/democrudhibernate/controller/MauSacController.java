package com.example.democrudhibernate.controller;


import com.example.democrudhibernate.model.MauSac;
import com.example.democrudhibernate.model.NSX;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.service.MauSacService;
import com.example.democrudhibernate.service.NhanVienService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    MauSacService mauSacService;
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
        model.addAttribute("list", mauSacService.getALl());
        model.addAttribute("sv", new MauSac());
        upTTNV(model);
        return "MauSac";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("sv") MauSac cv, Model model){
        mauSacService.add(cv);
        model.addAttribute("list",mauSacService.getALl());
        model.addAttribute("sv", new MauSac());
        upTTNV(model);
        return "MauSac";
    }

    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        MauSac mauSac = mauSacService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",mauSac);
        model.addAttribute("list",mauSacService.getALl());
        upTTNV(model);
        return "MauSac";
    }
//    @GetMapping("/update/{id}")
//    private String update(@PathVariable String id,Model model,@ModelAttribute("sv") CuaHang cv){
//        mauSacService.add(UUID.fromString(id),cv);
//        model.addAttribute("list",cuaHangService.getAll());
//        return "redirect:/cua-hang/hien-thi";
//    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id,Model model){
        MauSac mauSac = mauSacService.timTheoID(UUID.fromString(id));
        mauSacService.delete(mauSac);
        model.addAttribute("sv",new MauSac());
        model.addAttribute("list",mauSacService.getALl());
        upTTNV(model);
        return "MauSac";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("sv") MauSac mauSac, Model model){
        mauSacService.add(mauSac);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("list",mauSacService.getALl());
        model.addAttribute("sv", new MauSac());
        upTTNV(model);
        return "MauSac";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        MauSac mauSac = mauSacService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",mauSac);
        model.addAttribute("list",mauSacService.getALl());
        upTTNV(model);
        return "MauSacUpdate";
    }
}
