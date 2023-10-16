package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.DongSP;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.service.ChucVuService;
import com.example.democrudhibernate.service.DongSPSerivce;
import com.example.democrudhibernate.service.NhanVienService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/dongSP")
public class DongSPController {
    @Autowired
    DongSPSerivce dongSPSerivce;
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
        model.addAttribute("sv",new DongSP());
        model.addAttribute("list",dongSPSerivce.getALl());
        upTTNV(model);
        return "DongSP";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        DongSP dongSP = dongSPSerivce.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",dongSP);
        model.addAttribute("list",dongSPSerivce.getALl());
        upTTNV(model);
        return "DongSP";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){
        DongSP dongSP = dongSPSerivce.timTheoID(UUID.fromString(id));
        dongSPSerivce.delete(dongSP);
        model.addAttribute("sv", new DongSP());
        model.addAttribute("list",dongSPSerivce.getALl());
        upTTNV(model);
        return "DongSP";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("cv") DongSP dongSP, Model model){
        dongSPSerivce.add(dongSP);
        model.addAttribute("sv", new DongSP());
        model.addAttribute("list",dongSPSerivce.getALl());
        upTTNV(model);
        return "DongSP";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("sv") DongSP dongSP, Model model){
        dongSPSerivce.add(dongSP);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("list",dongSPSerivce.getALl());
        model.addAttribute("sv", new CuaHang());
        upTTNV(model);
        return "DongSP";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        DongSP dongSP = dongSPSerivce.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",dongSP);
        model.addAttribute("list",dongSPSerivce.getALl());
        upTTNV(model);
        return "DongSPUpdate";
    }
}
