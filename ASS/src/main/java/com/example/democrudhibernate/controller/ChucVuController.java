package com.example.democrudhibernate.controller;


import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.service.ChucVuService;
import com.example.democrudhibernate.service.NhanVienService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/chuc-vu")
public class ChucVuController {

    @Autowired
    ChucVuService chucVuService;
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
        System.out.println(value+"2222222222222222222222222");
//        NhanVien nhanVien=nhanVienService.timTheoID(UUID.fromString(value));
//        System.out.println(nhanVien);
//        model.addAttribute("tenDN",nhanVien.getTen());
//        model.addAttribute("maDN",nhanVien.getMa());
//        model.addAttribute("hinhDN",nhanVien.getHinh());
    }
    @GetMapping("/hien-thi")
    private String getALl(Model model){
        model.addAttribute("sv",new ChucVu());
        model.addAttribute("list",chucVuService.getAll());
        upTTNV(model);
        return "ChucVu";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        ChucVu chucVu = chucVuService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",chucVu);
        model.addAttribute("list",chucVuService.getAll());
        upTTNV(model);
        return "ChucVu";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("sv") ChucVu ch, Model model){
        chucVuService.add(ch);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("list",chucVuService.getAll());
        model.addAttribute("sv", new ChucVu());
        upTTNV(model);
        return "ChucVu";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        ChucVu chucVu = chucVuService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",chucVu);
        model.addAttribute("list",chucVuService.getAll());
        upTTNV(model);
        return "ChucVuUpdate";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){
        ChucVu chucVu = chucVuService.timTheoID(UUID.fromString(id));
        chucVuService.delete(chucVu);
        model.addAttribute("sv", new ChucVu());
        model.addAttribute("list",chucVuService.getAll());
        upTTNV(model);
        return "ChucVu";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("cv") ChucVu chucVu,Model model){
        chucVuService.add(chucVu);
        model.addAttribute("sv", new ChucVu());
        model.addAttribute("list",chucVuService.getAll());
        upTTNV(model);
        return "ChucVu";
    }
}
