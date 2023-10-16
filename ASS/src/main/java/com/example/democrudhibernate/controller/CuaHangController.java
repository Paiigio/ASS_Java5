package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.NhanVien;
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
@RequestMapping("/cua-hang")
public class CuaHangController {

    @Autowired
    CuaHangService cuaHangService;
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
        model.addAttribute("list", cuaHangService.getAll());
        model.addAttribute("sv", new CuaHang());
        upTTNV(model);
        return "CuaHang";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("sv") CuaHang cv, Model model){
        cuaHangService.add(cv);
        model.addAttribute("list",cuaHangService.getAll());
        model.addAttribute("sv", new CuaHang());
        upTTNV(model);
        return "CuaHang";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("sv") CuaHang ch, Model model){
        cuaHangService.add(ch);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("list",cuaHangService.getAll());
        model.addAttribute("sv", new CuaHang());
        upTTNV(model);
        return "CuaHang";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        CuaHang ch = cuaHangService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",ch);
        model.addAttribute("list",cuaHangService.getAll());
        upTTNV(model);
        return "CuaHangUpdate";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id,Model model){
        CuaHang cuaHang = cuaHangService.timTheoID(UUID.fromString(id));
        model.addAttribute("sv",cuaHang);
        model.addAttribute("list",cuaHangService.getAll());
        upTTNV(model);
        return "CuaHang";
    }
    @GetMapping("/update/{id}")
    private String update(@PathVariable String id,Model model,@ModelAttribute("sv") CuaHang ch){
        cuaHangService.update(UUID.fromString(id),ch);
//        model.addAttribute("list",cuaHangService.getAll());
        upTTNV(model);
        return "redirect:/cua-hang/hien-thi";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id,Model model){
        CuaHang cuaHang = cuaHangService.timTheoID(UUID.fromString(id));
        cuaHangService.delete(cuaHang);
        model.addAttribute("sv",new CuaHang());
        model.addAttribute("list",cuaHangService.getAll());
        upTTNV(model);
        return "CuaHang";
    }

}
