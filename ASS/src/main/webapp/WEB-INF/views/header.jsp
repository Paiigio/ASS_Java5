
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<div id="sidebar-wrapper" data-simplebar="" data-simplebar-auto-hide="true">
    <div class="brand-logo">
        <a href="/trang-chu/hien-thi">
            <img src="../../assets/images/LogoShop.png" class="logo-icon" alt="logo icon">
            <h5 class="logo-text">Paiigio Shop</h5>
        </a>
    </div>
    <ul class="sidebar-menu do-nicescrol">
        <li class="sidebar-header">Menu</li>
        <li>
            <a href="/trang-chu/hien-thi">
                <i class="zmdi zmdi-view-dashboard"></i> <span>Trang chủ</span>
            </a>
        </li>
        <li>
            <a href="/trang-chu/ban-hang">
                <i class="zmdi zmdi-invert-colors"></i> <span>Bán hàng</span>
            </a>
        </li>

        <li>
            <a href="/cua-hang/hien-thi">
                <i class="zmdi zmdi-invert-colors"></i> <span>Cửa hàng</span>
            </a>
        </li>

        <li>
            <a href="/nsx/hien-thi">
                <i class="zmdi zmdi-format-list-bulleted"></i> <span>NSX</span>
            </a>
        </li>

        <li>
            <a href="/mau-sac/hien-thi">
                <i class="zmdi zmdi-grid"></i> <span>Màu sắc</span>
            </a>
        </li>

        <li>
            <a href="/dongSP/hien-thi">
                <i class="zmdi zmdi-calendar-check"></i> <span>Dòng sản phẩm</span>
                <small class="badge float-right badge-light">New</small>
            </a>
        </li>

        <li>
            <a href="/chi-tiet-san-pham/hien-thi">
                <i class="zmdi zmdi-face"></i> <span>Chi tiết sản phẩm</span>
            </a>
        </li>

        <li>
            <a href="/san-pham/hien-thi" >
                <i class="zmdi zmdi-lock"></i> <span>Sản phẩm</span>
            </a>
        </li>

        <li>
            <a href="/khach-hang/hien-thi" >
                <i class="zmdi zmdi-account-circle"></i> <span>Khách hàng</span>
            </a>
        </li>

        <li class="sidebar-header">LABELS</li>
        <li><a href="/nhan-vien/hien-thi"><i class="zmdi zmdi-coffee text-danger"></i> <span>Nhân viên</span></a></li>
        <li><a href="/khach-hang/hien-thi"><i class="zmdi zmdi-chart-donut text-success"></i> <span>Khách hàng</span></a></li>
        <li><a href="/chuc-vu/hien-thi"><i class="zmdi zmdi-share text-info"></i> <span>Chức vụ</span></a></li>

    </ul>

</div>
<!--End sidebar-wrapper-->

<!--Start topbar header-->
<header class="topbar-nav">
    <nav class="navbar navbar-expand fixed-top">
        <ul class="navbar-nav mr-auto align-items-center">
            <li class="nav-item">
                <a class="nav-link toggle-menu" href="javascript:void();">
                    <i class="icon-menu menu-icon"></i>
                </a>
            </li>
            <li class="nav-item">
                <form class="search-bar">
                    <input type="text" class="form-control" placeholder="Enter keywords">
                    <a href="javascript:void();"><i class="icon-magnifier"></i></a>
                </form>
            </li>
        </ul>

        <ul class="navbar-nav align-items-center right-nav-link">
            <li class="nav-item dropdown-lg">
                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();">
                    <i class="fa fa-envelope-open-o"></i></a>
            </li>
            <li class="nav-item dropdown-lg">
                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();">
                    <i class="fa fa-bell-o"></i></a>
            </li>
            <li class="nav-item language">
                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();"><i class="fa fa-flag"></i></a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="dropdown-item"> <i class="flag-icon flag-icon-gb mr-2"></i> English</li>
                    <li class="dropdown-item"> <i class="flag-icon flag-icon-fr mr-2"></i> French</li>
                    <li class="dropdown-item"> <i class="flag-icon flag-icon-cn mr-2"></i> Chinese</li>
                    <li class="dropdown-item"> <i class="flag-icon flag-icon-de mr-2"></i> German</li>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown" href="#">
                    <span class="user-profile"><img src='/hinh/${hinhDN}' class="img-circle" alt="user avatar"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="dropdown-item user-details">
                        <a href="javaScript:void();">
                            <div class="media">
                                <div class="avatar"><img src='/hinh/${hinhDN}' alt="user avatar"></div>
                                <div class="media-body" style="margin-left: 20px">
                                    <h6 class="mt-2 user-title">${maDN}</h6>
                                    <p class="user-subtitle" style="color: white">${tenDN}</p>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="dropdown-divider"></li>
                    <li class="dropdown-item"><i class="icon-envelope mr-2"></i> Inbox</li>
                    <li class="dropdown-divider"></li>
                    <li class="dropdown-item"><i class="icon-wallet mr-2"></i> Account</li>
                    <li class="dropdown-divider"></li>
                    <li class="dropdown-item"><i class="icon-settings mr-2"></i> Setting</li>
                    <li class="dropdown-divider"></li>
                    <li class="dropdown-item"><i class="icon-power mr-2"></i> <a href="/trang-chu/dangXuat">Đăng xuất</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>


