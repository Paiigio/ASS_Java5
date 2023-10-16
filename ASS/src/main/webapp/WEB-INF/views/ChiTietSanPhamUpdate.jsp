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
    <!--End topbar header-->

    <div class="clearfix"></div>

    <div class="content-wrapper">
        <div class="container-fluid">

            <!--Start Dashboard Content-->
            <div class="container ">
                <%--@elvariable id="sv" type=""--%>
                <form:form action="/chi-tiet-san-pham/update" modelAttribute="sv">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="col-md-4">
                                <form:input type="hidden" value="${sv.id}" path="id"/>
                                <h5>Sản phẩm</h5>
                                <form:select cssStyle="width: 250px" path="sanPham.id">
                                    <c:forEach items="${listSP}" var="c">
                                        <form:option value="${c.id}">${c.ten}</form:option>
                                    </c:forEach>
                                </form:select>
                                <h5>Nhà sản xuất</h5>
                                <form:select cssStyle="width: 250px" path="nsx.id">
                                    <c:forEach items="${listNSX}" var="c">
                                        <form:option value="${c.id}">${c.ten}</form:option>
                                    </c:forEach>
                                </form:select>
                                <h5>Màu sắc</h5>
                                <form:select cssStyle="width: 250px" path="mauSac.id">
                                    <c:forEach items="${listMS}" var="c">
                                        <form:option value="${c.id}">${c.ten}</form:option>
                                    </c:forEach>
                                </form:select>
                                <h5>Dòng sản phảm </h5>
                                <form:select cssStyle="width: 250px" path="dongSP.id">
                                    <c:forEach items="${listDSP}" var="c">
                                        <form:option value="${c.id}">${c.ten}</form:option>
                                    </c:forEach>
                                </form:select>

                            </div>
                        </div>
                        <div class="col-md-4">
                            <br>
                            <div class="form-group">
                                <form:input type="file" value="${sv.hinh}" path="hinh"/>
                            </div>
                            <div class="form-group ">
                                <h5>Năm BH</h5>
                                <form:input type="number" path="namBh" value="${sv.namBh}" cssStyle="width: 250px"/>
                                <p style="color: red">${loiten}</p>
                            </div>
                            <div class="form-group">
                                <h5>Mô tả</h5>
                                <form:input type="text" path="moTa" value="${sv.moTa}" cssStyle="width: 250px"/>
                                <p style="color: red">${loidiachi}</p>
                            </div>


                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <h5>Số lượng tồn</h5>
                                <form:input type="number" path="soLuongTon" value="${sv.soLuongTon}" cssStyle="width: 250px"/>
                                <p style="color: red">${loidiachi}</p>
                            </div>
                            <div class="form-group">
                                <h5>Giá nhập</h5>
                                <form:input type="number" path="giaNhap" value="${sv.giaNhap}" cssStyle="width: 250px"/>
                                <p style="color: red">${loidiachi}</p>
                            </div>
                            <div class="form-group">
                                <h5>Giá bán</h5>
                                <form:input type="number" path="giaBan" value="${sv.giaBan}" cssStyle="width: 250px"/>
                                <p style="color: red">${loidiachi}</p>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-success justify-content-center" style="margin-left: 500px">
                            Update
                        </button>
                    </div>


                </form:form>

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

        </div>
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
