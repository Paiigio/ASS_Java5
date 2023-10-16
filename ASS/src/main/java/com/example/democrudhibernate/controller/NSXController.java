package com.example.democrudhibernate.controller;


import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.DongSP;
import com.example.democrudhibernate.model.NSX;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.service.NSXService;
import com.example.democrudhibernate.service.NhanVienService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/nsx")
public class NSXController {

    @Autowired
    NSXService nsxService;
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
        model.addAttribute("sv",new NSX());
        model.addAttribute("list",nsxService.getALl());
        upTTNV(model);
        return "NSX";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        NSX nsx = nsxService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",nsx);
        model.addAttribute("list",nsxService.getALl());
        upTTNV(model);
        return "NSX";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){
        NSX nsx = nsxService.timTheoID(UUID.fromString(id));
        nsxService.delete(nsx);
        model.addAttribute("sv", new NSX());
        model.addAttribute("list",nsxService.getALl());
        upTTNV(model);
        return "NSX";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("cv") NSX nsx,Model model){
        nsxService.add(nsx);
        model.addAttribute("sv", new NSX());
        model.addAttribute("list",nsxService.getALl());
        upTTNV(model);
        return "NSX";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("sv") NSX nsx, Model model){
        nsxService.add(nsx);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("list",nsxService.getALl());
        model.addAttribute("sv", new NSX());
        upTTNV(model);
        return "NSX";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        NSX nsx = nsxService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",nsx);
        model.addAttribute("list",nsxService.getALl());
        upTTNV(model);
        return "NSXUpdate";
    }
}
