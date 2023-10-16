package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.*;
import com.example.democrudhibernate.responsitory.HoaDonRepon;
import com.example.democrudhibernate.service.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/trang-chu")
public class TrangChuController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    HoaDonChiTietSerivce hoaDonChiTietSerivce;
    @Autowired
    HoaDonRepon hoaDonRepon;

@Autowired
    KhachHangSerivce khachHangSerivce;
    @GetMapping("/hien-thi")
    private String trangchu(Model model) {
        upTTNV(model);
        model.addAttribute("doanhThuNgay",hoaDonRepon.getDoanhThuNgay());
        model.addAttribute("doanhThuThang",hoaDonRepon.getDoanhThuThang());
        model.addAttribute("doanhThuNam",hoaDonRepon.getDoanhThuNam());
        model.addAttribute("HDngay",hoaDonRepon.getHDNgay());
        String value = "";
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("idNV")) {
                    value = cookie.getValue();
                }
            }
        }
        System.out.println(value);
        NhanVien nhanVien=nhanVienService.timTheoID(UUID.fromString(value));
        model.addAttribute("LISTHDTT",hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,1));
        return "index";
    }

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @PostMapping("/dangNhap")
    private String danNhap(Model model) {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        NhanVien nv = nhanVienService.findNhanVienByMaAndMatKhau(user, pass);
        if (nv == null) {
            return "login";
        } else {
            request.setAttribute("tenDN", nv.getTen());
            request.setAttribute("maDN", nv.getMa());
            request.setAttribute("hinhDN",nv.getHinh());
            Cookie idNV = new Cookie("idNV", String.valueOf(nv.getId()));
            Cookie tenNV = new Cookie("tenNV", String.valueOf(nv.getTen()));
            idNV.setMaxAge(10 * 60 * 60);
            tenNV.setMaxAge(10 * 60 * 60);
            idNV.setPath("/");
            tenNV.setPath("/");
            response.addCookie(idNV);
            response.addCookie(tenNV);
            return "index";
        }
    }
    @GetMapping("/dangXuat")
    private String dangXuat(){

        Cookie ck = new Cookie("tenNV", "");
        Cookie ck1 = new Cookie("idNV", "");
        ck.setMaxAge(0);
        ck.setMaxAge(0);
        ck1.setMaxAge(0);
        response.addCookie(ck);
        response.addCookie(ck1);
     return "login";
    }
    @GetMapping("/ban-hang")
    private String Hoadon(Model model){
        String value = "";
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("idNV")) {
                    value = cookie.getValue();
                }
            }
        }
        System.out.println(value);
        NhanVien nhanVien=nhanVienService.timTheoID(UUID.fromString(value));

        List<HoaDon> list = hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,0);
        model.addAttribute("LISTHDBD",list);
        upTTNV(model);
        return "BanHang";
    }
    @GetMapping("/update-hd-khach-hang/{id}")
    private String updateKHbyHD(@PathVariable String id, Model model){
        HoaDon hd = hoaDonService.findHDbyID(UUID.fromString(id));
        model.addAttribute("idHD",hd.getId());
        model.addAttribute("sv",new KhachHang());
        model.addAttribute("list",khachHangSerivce.getALl());
        upTTNV(model);
        return "updateHDbyKhachHang";
    }
    @GetMapping ("/add-hoa-don")
    private String addHD(HoaDon hoaDon,Model model){
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
        List<HoaDon> list = hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,0);
        if(list.size()>=5){
            model.addAttribute("thongbao","Tối đa 5 hóa đơn");
            model.addAttribute("LISTHDBD",hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,0));
        }else {
            hoaDon.setNhanVien(nhanVien);
            hoaDon.setMa("HD"+((hoaDonService.getALl().size())+1));
            LocalDate localDate = LocalDate.now();
            hoaDon.setNgayTao(Date.valueOf(localDate));
            hoaDonService.add(hoaDon);
            model.addAttribute("LISTHDBD",hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,0));
        }

        return "BanHang";

    }
    @GetMapping("/add-khach-hang/{idKH}/{idHD}")
    private String addKH(@PathVariable("idKH") String idKH,
                         @PathVariable("idHD") String idHD,Model model

    ){
        String value = "";
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("idNV")) {
                    value = cookie.getValue();
                }
            }
        }
        NhanVien nv=nhanVienService.timTheoID(UUID.fromString(value));
        request.setAttribute("tenDN", nv.getTen());
        request.setAttribute("maDN", nv.getMa());
        request.setAttribute("hinhDN",nv.getHinh());
        KhachHang kh = khachHangSerivce.timTheoID(UUID.fromString(idKH));
        HoaDon hoaDon= hoaDonService.findHDbyID(UUID.fromString(idHD));
        hoaDon.setKhachHang(kh);
        hoaDonService.add(hoaDon);
        List<HoaDon> list = hoaDonService.findHoaDonByNhanVienAndTinhTrang(nv,0);
        model.addAttribute("LISTHDBD",list);
        upTTNV(model);
        return "redirect:/trang-chu/ban-hang";
    }
    @GetMapping("/san-pham/{idHD}")
    private String sanPham(@PathVariable("idHD") String idHD, Model model){
       List<ChiTietSP> listSP= chiTietSanPhamService.getALl();
       model.addAttribute("listSP",listSP);
        upTTNV(model);
        return "SanPhamBanHang";
    }

    @GetMapping("/chonHD/{idHD}")
    private String chiTietHD(@PathVariable("idHD") String idHD,Model model){
        HoaDon hoaDon=hoaDonService.findHDbyID(UUID.fromString(idHD));
        model.addAttribute("hd",hoaDon);
        List<HoaDonChiTiet> listHDCT=hoaDonChiTietSerivce.findHoaDonChiTietById_IDHD(UUID.fromString(idHD));

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
        List<HoaDon> list = hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,0);
        model.addAttribute("listHDCT", listHDCT);
        model.addAttribute("LISTHDBD",list);
        model.addAttribute("tongTien",hoaDonChiTietSerivce.getTongTien(UUID.fromString(idHD)));
        upTTNV(model);
        return "BanHang";
    }
    @PostMapping("/san-pham/add")
    private String addSPGH(@RequestParam("idSP") String idSp,Model model ){
        String idHD = request.getParameter("idHD");
        if(hoaDonChiTietSerivce.findHoaDonChiTietbyIDHDandIDCTSP(UUID.fromString(idHD),UUID.fromString(idSp))==null){
            ChiTietSP chiTietSP = chiTietSanPhamService.timTheoID(UUID.fromString(idSp));
            String sl = request.getParameter("soLuong");
            HoaDon hd = hoaDonService.findHDbyID(UUID.fromString(idHD));
            HoaDonChiTiet hoaDonChiTiet= new HoaDonChiTiet();
            IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet();
            idHoaDonChiTiet.setIdChiTietSp(chiTietSP);
            idHoaDonChiTiet.setIdHoaDon(hd);
            hoaDonChiTiet.setId(idHoaDonChiTiet);
            Double gia=Integer.valueOf(sl)*chiTietSP.getGiaBan().doubleValue();
            hoaDonChiTiet.setSoLuong(Integer.valueOf(sl));
            hoaDonChiTiet.setDonGia(BigDecimal.valueOf(gia));
            hd.setThanhTien(BigDecimal.valueOf(gia));
            hoaDonService.add(hd);
            hoaDonChiTietSerivce.add(hoaDonChiTiet);

        }
        else {
            ChiTietSP chiTietSP = chiTietSanPhamService.timTheoID(UUID.fromString(idSp));
            HoaDon hd = hoaDonService.findHDbyID(UUID.fromString(idHD));
            HoaDonChiTiet hoaDonChiTiet= new HoaDonChiTiet();
            IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet();
            idHoaDonChiTiet.setIdChiTietSp(chiTietSP);
            idHoaDonChiTiet.setIdHoaDon(hd);
            hoaDonChiTiet.setId(idHoaDonChiTiet);
            String sl = request.getParameter("soLuong");
            HoaDonChiTiet hoaDonChiTiet1= hoaDonChiTietSerivce.findHoaDonChiTietbyIDHDandIDCTSP(UUID.fromString(idHD),UUID.fromString(idSp));
            int slUPdate= Integer.parseInt(sl)+hoaDonChiTiet1.getSoLuong();
            hoaDonChiTiet.setSoLuong(slUPdate);
            Double gia=(Integer.valueOf(sl)*chiTietSP.getGiaBan().doubleValue())+hoaDonChiTiet1.getDonGia().doubleValue();
            hoaDonChiTiet.setDonGia(BigDecimal.valueOf(gia));
            hd.setThanhTien(BigDecimal.valueOf(gia));
            hoaDonService.add(hd);
            hoaDonChiTietSerivce.add(hoaDonChiTiet);
        }
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
        HoaDon hoaDon=hoaDonService.findHDbyID(UUID.fromString(idHD));
        model.addAttribute("hd",hoaDon);
        List<HoaDon> list = hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,0);
        List<HoaDonChiTiet> listHDCT=hoaDonChiTietSerivce.findHoaDonChiTietById_IDHD(UUID.fromString(idHD));
        model.addAttribute("LISTHDBD",list);
        model.addAttribute("listHDCT", listHDCT);
        model.addAttribute("tongTien",hoaDonChiTietSerivce.getTongTien(UUID.fromString(idHD)));
        model.addAttribute("idHD",idHD);
        return "BanHang";
    }
    @GetMapping("/delete-san-pham/{idHD}/{idCTSP}")
    private  String xoaSP(@PathVariable("idHD") String idHD,@PathVariable("idCTSP") String idCTSP, Model model){

        HoaDonChiTiet hoaDonChiTiet=hoaDonChiTietSerivce.findHoaDonChiTietbyIDHDandIDCTSP(UUID.fromString(idHD),UUID.fromString(idCTSP));
        hoaDonChiTietSerivce.delete(hoaDonChiTiet);
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
        HoaDon hoaDon=hoaDonService.findHDbyID(UUID.fromString(idHD));
        model.addAttribute("hd",hoaDon);
        List<HoaDon> list = hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,0);
        List<HoaDonChiTiet> listHDCT=hoaDonChiTietSerivce.findHoaDonChiTietById_IDHD(UUID.fromString(idHD));
        model.addAttribute("LISTHDBD",list);
        model.addAttribute("listHDCT", listHDCT);
        model.addAttribute("tongTien",hoaDonChiTietSerivce.getTongTien(UUID.fromString(idHD)));
        model.addAttribute("idHD",idHD);
//        return "BanHang";
        return "redirect:/trang-chu/chonHD/{idHD}";
    }
    @PostMapping("/thanh-toan")
    private String thanhToan(@RequestParam("id") String idHD, Model model){
        HoaDon hoaDon= hoaDonService.findHDbyID(UUID.fromString(idHD));
        hoaDon.setId(UUID.fromString(idHD));
        LocalDate localDate =  LocalDate.now();
        hoaDon.setNgayThanhToan(Date.valueOf(localDate));
        hoaDon.setTinhTrang(1);
        hoaDonService.add(hoaDon);
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

        List<HoaDon> list = hoaDonService.findHoaDonByNhanVienAndTinhTrang(nhanVien,0);
        model.addAttribute("LISTHDBD",list);
        upTTNV(model);
        return "BanHang";

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
