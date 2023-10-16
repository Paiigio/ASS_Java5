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
                <form:form action="/nhan-vien/add" modelAttribute="sv">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <h5>Mã</h5>
                                    <form:input type="text" path="ma" value="${sv.ma}" cssStyle="width: 250px"/>
                                    <p style="color: red">${loithanhpho}</p>
                                </div>
                                <div class="form-group ">
                                    <h5>Tên</h5>
                                    <form:input type="text" path="ten" value="${sv.ten}" cssStyle="width: 250px"/>
                                    <p style="color: red">${loiten}</p>
                                </div>
                                <div class="form-group ">
                                    <h5>Tên đệm</h5>
                                    <form:input type="text" path="tenDem" value="${sv.tenDem}" cssStyle="width: 250px"/>
                                    <p style="color: red">${loiten}</p>
                                </div>
                                <div class="form-group ">
                                    <h5>Họ</h5>
                                    <form:input type="text" path="ho" value="${sv.ho}" cssStyle="width: 250px"/>
                                    <p style="color: red">${loiten}</p>
                                </div>

                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group ">
                                <h5>Ngày Sinh</h5>
                                <form:input type="date" path="ngaySinh" value="${sv.ngaySinh}" cssStyle="width: 250px"/>
                                <p style="color: red">${loiten}</p>
                            </div>
                            <div class="form-group">
                                <h5>SDT</h5>
                                <form:input type="text" path="sdt" value="${sv.sdt}" cssStyle="width: 250px"/>
                                <p style="color: red">${loidiachi}</p>
                            </div>
                            <div class="form-group">
                                <h5>Địa chỉ</h5>
                                <form:input type="text" path="diaChi" value="${sv.diaChi}" cssStyle="width: 250px"/>
                                <p style="color: red">${loidiachi}</p>
                            </div>
                            <br>
                            <div class="form-group">
                                <form:input type="file" value="${sv.hinh}" path="hinh"/>
                            </div>

                        </div>
                        <div class="col-md-4">
                            <div class="form-group ">
                                <h5>Mật khẩu</h5>
                                <form:input type="text" path="matKhau" value="${sv.matKhau}" cssStyle="width: 250px"/>
                                <p style="color: red">${loiquocgia}</p>
                            </div>
                            <div class="form-group ">
                                <h5>Chức vụ</h5>
                                <form:select cssStyle="width: 250px" path="chucVu.id">
                                    <c:forEach items="${listCV}" var="c">
                                        <form:option value="${c.id}">${c.ten}</form:option>
                                    </c:forEach>
                                </form:select>
                                <h5>Cửa hàng</h5>
                                <form:select cssStyle="width: 250px" path="cuaHang.id">
                                    <c:forEach items="${listCH}" var="c">
                                        <form:option value="${c.id}">${c.ten}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <h5>Trạng thái</h5>
                            <form:radiobutton value="0" path="trangThai"/> Đi làm
                            <form:radiobutton value="1" path="trangThai"/> Nghỉ làm


                        </div>

                        <button type="submit" class="btn btn-success justify-content-center" style="margin-left: 500px">
                            Add
                        </button>
                    </div>


                </form:form>

            </div>
            <div class="container">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Hình</th>
                        <th scope="col">Mã</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Ngày Sinh</th>
                        <th scope="col">SDT</th>
                        <th scope="col">Địa chỉ</th>
                        <th scope="col">CV</th>
                        <th scope="col">CH</th>
                        <th scope="col">Mật khẩu</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col">Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="c" varStatus="stt">
                        <tr>
                            <th scope="row">${stt.index+1} </th>
                            <td><img src='/hinh/${c.hinh}' style="width: 150px;height: 150px" alt=""></td>
                            <th scope="row">${c.ma}</th>
                            <th scope="row">${c.ho} <br>${c.tenDem} <br>${c.ten} </th>
                            <th scope="row">${c.ngaySinh}</th>
                            <th scope="row">${c.sdt}</th>
                            <th scope="row">${c.diaChi}</th>
                            <th scope="row">${c.chucVu.ten}</th>
                            <th scope="row">${c.cuaHang.ten}</th>
                            <th scope="row">${c.matKhau}</th>
                            <th>
                                <c:if test="${c.trangThai==0}">
                                Đi làm
                               </c:if>
                                <c:if test="${c.trangThai ==1}">
                                    Nghỉ làm
                                </c:if></th>
                            <th>
                                <a href="/nhan-vien/detail/${c.id}" class="btn btn-success">Detail</a><br>
                                <a href="/nhan-vien/update/${c.id}" class="btn btn-primary">Update</a><br>
                                <a href="/nhan-vien/delete/${c.id}" class="btn btn-danger mt-3">Delete</a>


                            </th>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
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
