<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Paiigio</title>
    <!-- loader-->
    <link href="../../assets/css/pace.min.css" rel="stylesheet"/>
    <script src="../../assets/js/pace.min.js"></script>
    <!--favicon-->
    <link rel="icon" href="../../assets/images/favicon.ico" type="image/x-icon">
    <!-- Vector CSS -->
    <link href="../../assets/plugins/vectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet"/>
    <!-- simplebar CSS-->
    <link href="../../assets/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
    <!-- Bootstrap core CSS-->
    <link href="../../assets/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- animate CSS-->
    <link href="../../assets/css/animate.css" rel="stylesheet" type="text/css"/>
    <!-- Icons CSS-->
    <link href="../../assets/css/icons.css" rel="stylesheet" type="text/css"/>
    <!-- Sidebar CSS-->
    <link href="../../assets/css/sidebar-menu.css" rel="stylesheet"/>
    <!-- Custom Style-->
    <link href="../../assets/css/app-style.css" rel="stylesheet"/>

</head>

<body class="bg-theme bg-theme1">

<!-- Start wrapper-->
<div id="wrapper">

<jsp:include page="header.jsp"/>

    <div class="clearfix"></div>

    <div class="content-wrapper">


        <!--Start Dashboard Content-->
        <h4 align="center">Bán hàng </h4>
        <div class="container-fluid  mx-auto">
            <div class="col-md-12 row border-radius   ">
                <div class="row col-md-7 border-radius"  style=" margin-right: 15px;margin-left: 10px">
                    <div class="col-md-12 border-radius " style="border:white solid 2px;">
                        <a class="btn btn-primary float-right mt-1 mb-2 cusor" href="/trang-chu/add-hoa-don">Tạo hóa
                            đơn</a>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên</th>
                                <th scope="col">Tên KH</th>
                                <th scope="col">Ngày tạo</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${LISTHDBD}" var="c" varStatus="stt">
                                <tr>
                                    <th scope="row">${stt.index+1}</th>
                                    <th scope="row">${c.ma}</th>
                                    <th scope="row">${c.nhanVien.ten}</th>
                                    <th scope="row">${c.khachHang.ten}</th>
                                    <th scope="row">${c.ngayTao}</th>
                                    <th>
                                        <a href="/trang-chu/chonHD/${c.id}" class="btn btn-primary">Chọn</a>
                                        <a href="/trang-chu/update-hd-khach-hang/${c.id}" class="btn btn-success">ChọnKH</a>
                                        <a href="/mau-sac/detail/${c.id}" class="btn btn-danger">Xóa</a>
                                    </th>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 mt-4" style="border:white solid 2px;">
                        <h4 class="text-center mt-2">Giỏ hàng</h4>
                        <table class="table">

                            <a href="/trang-chu/san-pham/${idHD}" class="btn btn-success float-right mb-3">Mua SP</a>

                            <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Tên SP</th>
                                <th scope="col">SL</th>
                                <th scope="col">Đơn giá</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${listHDCT}" var="h" varStatus="stt">
                                <tr>
                                    <th scope="row">${stt.index+1}</th>
                                    <th scope="row">${h.id.idChiTietSp.sanPham.ten}</th>
                                    <th scope="row">${h.soLuong}</th>
                                    <th scope="row">${h.donGia}</th>
                                    <th>
                                        <a href="/trang-chu/delete-san-pham/${h.id.idHoaDon.id}/${h.id.idChiTietSp.id}" class="btn btn-danger">Xóa</a>
                                    </th>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>

                </div>

                <div class="col-md-4 border-radius" style=" border: white solid 2px;">
                    <h4 class="text-center">Chi tiết hóa đơn</h4>
                    <form action="/trang-chu/thanh-toan"  method="post">
                        <input type="hidden" name="id" value="${hd.id}">
                        <div class="from-group">
                            <h5>Mã hóa đơn</h5>
                            <input type="text" name="ma" value="${hd.ma}" class="form-control" >
                        </div>
                        <div class="from-group mt-3">
                            <h5>Tên nhân viên</h5>
                            <input type="text" name="nhanVien.ten" value="${hd.nhanVien.ten}" class="form-control">
                        </div>
                        <div class="from-group mt-3">
                            <h5>Tên khách hàng</h5>
                            <input type="text" name="khachHang.ten"  value="${hd.khachHang.ten}" class="form-control" >
                        </div>
                        <div class="from-group mt-3">
                            <h5>Thành tiền</h5>
                            <input type="text"  id="tienTong" value="${tongTien}" class="form-control" >
                        </div>
                        <div class="from-group mt-3">
                            <h5>Tiền khách đưa</h5>
                            <input type="text"  id="tienKH" onchange="hieu()" class="form-control" >
                        </div>
                        <div class="from-group mt-3">
                            <h5>Tiền trả lại</h5>
                            <input type="text"  id="tienThua"  class="form-control" >
                        </div>
                        <button class="btn btn-success mt-4 mb-3 float-right" type="submit">Thanh toán</button>
                    </form>
                </div>
            </div>
        </div>
        <c:if test="${not empty thongbao}">
            <script>
                alert("${thongbao}")
            </script>
        </c:if>


        <!--End Dashboard Content-->

        <!--start overlay-->
        <div class="overlay toggle-menu"></div>
        <!--end overlay-->


        <!-- End container-fluid-->

    </div><!--End content-wrapper-->
    <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->

    <!--Start footer-->
    <footer class="footer">
        <div class="container">
            <div class="text-center">
                Copyright © 2018 Dashtreme Admin
            </div>
        </div>
    </footer>
    <!--End footer-->

    <!--start color switcher-->
    <div class="right-sidebar">
        <div class="switcher-icon">
            <i class="zmdi zmdi-settings zmdi-hc-spin"></i>
        </div>
        <div class="right-sidebar-content">

            <p class="mb-0">Gaussion Texture</p>
            <hr>

            <ul class="switcher">
                <li id="theme1"></li>
                <li id="theme2"></li>
                <li id="theme3"></li>
                <li id="theme4"></li>
                <li id="theme5"></li>
                <li id="theme6"></li>
            </ul>

            <p class="mb-0">Gradient Background</p>
            <hr>

            <ul class="switcher">
                <li id="theme7"></li>
                <li id="theme8"></li>
                <li id="theme9"></li>
                <li id="theme10"></li>
                <li id="theme11"></li>
                <li id="theme12"></li>
                <li id="theme13"></li>
                <li id="theme14"></li>
                <li id="theme15"></li>
            </ul>

        </div>
    </div>
    <!--end color switcher-->
    <script>
        function hieu(){

                var a= Number(document.getElementById("tienTong").value);
                var b=Number( document.getElementById("tienKH").value);
                if(b>a){
                    var c = b-a;
                    document.getElementById("tienThua").value=c;

                }else {
                   let d="";
                     document.getElementById("tienKH").value=""
                    alert("Không đủ điều kiện thanh toán")

                }


        }
    </script>
</div><!--End wrapper-->

<!-- Bootstrap core JavaScript-->
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/popper.min.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>

<!-- simplebar js -->
<script src="../../assets/plugins/simplebar/js/simplebar.js"></script>
<!-- sidebar-menu js -->
<script src="../../assets/js/sidebar-menu.js"></script>
<!-- loader scripts -->
<script src="../../assets/js/jquery.loading-indicator.js"></script>
<!-- Custom scripts -->
<script src="../../assets/js/app-script.js"></script>
<!-- Chart js -->

<script src="../../assets/plugins/Chart.js/Chart.min.js"></script>

<!-- Index js -->
<script src="../../assets/js/index.js"></script>


</body>
</html>
