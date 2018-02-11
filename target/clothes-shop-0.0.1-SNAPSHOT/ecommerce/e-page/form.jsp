<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!-- Favicons -->
    <link rel="apple-touch-icon" href="<%=request.getContextPath()%>/assets/img/apple-icon.png">
    <link rel="icon" href="<%=request.getContextPath()%>/assets/img/favicon.png">
    <title>
        Signup &#45; Material Kit PRO by Creative Tim
    </title>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/material-kit.css?v=2.0.0">
    <!-- Documentation extras -->
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="<%=request.getContextPath()%>/assets/assets-for-demo/demo.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/assets/assets-for-demo/vertical-nav.css" rel="stylesheet" />
</head>

<body class="signup-page ">
    <nav class="navbar  navbar-transparent    navbar-absolute  navbar-expand-lg " color-on-scroll="100" id="sectionsNav">
        <div class="container">
            <div class="navbar-translate">
              
                <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                    <span class="navbar-toggler-icon"></span>
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
          
        </div>
    </nav>
    <div class="page-header header-filter" filter-color="purple" style="background-image: url(&apos;<%=request.getContextPath()%>/assets/img/bg7.jpg&apos;); background-size: cover; background-position: top center;">
        <div class="container">
            <div class="row">
                <div class="col-md-10 ml-auto mr-auto">
                    <div class="card card-signup">
                        <h2 class="card-title text-center">Please fill out the form</h2>
                        <div class="card-body">
                            <div class="row">
                               
                                <div class="col-md-12 mr-auto">
                                    <div class="social text-center">
                                        <button class="btn btn-just-icon btn-round btn-twitter">
                                            <i class="fa fa-twitter"></i>
                                        </button>
                                        <button class="btn btn-just-icon btn-round btn-dribbble">
                                            <i class="fa fa-dribbble"></i>
                                        </button>
                                        <button class="btn btn-just-icon btn-round btn-facebook">
                                            <i class="fa fa-facebook"> </i>
                                        </button>
                                        <h4> or be classical </h4>
                                    </div>
                                    <form class="form" method="POST" action="form">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">face</i>
                                                </span>
                                                <input type="text" class="form-control" placeholder="Full Name" name="fullName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">email</i>
                                                </span>
                                                <input type="text" class="form-control" placeholder="Email" name="mail">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">phone</i>
                                                </span>
                                                <input type="text" placeholder="Phone" class="form-control" name="phone" />
                                            </div>
                                        </div>
                                        <div class="form-check">
                                            <label class="form-check-label">
                                                <input class="form-check-input" type="checkbox" value="" checked>
                                                <span class="form-check-sign">
                                                    <span class="check"></span>
                                                </span>
                                                I agree to the
                                                <a href="#something">terms and conditions</a>.
                                            </label>
                                        </div>
                                        <div class="text-center">
                                            <a href="<%=request.getContextPath()%>/ecommerce" type="submit" class="btn btn-primary btn-round">Okay!</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer ">
           
        </footer>
    </div>
    <!--   Core JS Files   -->
    <script src="<%=request.getContextPath()%>/assets/js/core/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/core/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap-material-design.js"></script>
    <!--  Plugin for Date Time Picker and Full Calendar Plugin-->
    <script src="<%=request.getContextPath()%>/assets/js/plugins/moment.min.js"></script>
    <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
    <script src="<%=request.getContextPath()%>/assets/js/plugins/bootstrap-selectpicker.js"></script>
    <!--	Plugin for Tags, full documentation here: http://xoxco.com/projects/code/tagsinput/  -->
    <script src="<%=request.getContextPath()%>/assets/js/plugins/bootstrap-tagsinput.js"></script>
    <!--	Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
    <script src="<%=request.getContextPath()%>/assets/js/plugins/jasny-bootstrap.min.js"></script>
    <!--	Plugin for Small Gallery in Product Page -->
    <script src="<%=request.getContextPath()%>/assets/js/plugins/jquery.flexisel.js"></script>
    <!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
    <script src="<%=request.getContextPath()%>/assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
    <!--	Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="<%=request.getContextPath()%>/assets/js/plugins/nouislider.min.js"></script>
    <!-- Material Kit Core initialisations of plugins and Bootstrap Material Design Library -->
    <script src="<%=request.getContextPath()%>/assets/js/material-kit.js?v=2.0.0"></script>
    <!-- Fixed Sidebar Nav - js With initialisations For Demo Purpose, Don't Include it in your project -->
    <script src="<%=request.getContextPath()%>/assets/assets-for-demo/js/material-kit-demo.js"></script>
    <!-- Plugins for presentation and navigation  -->
    <script src="<%=request.getContextPath()%>/assets/assets-for-demo/js/modernizr.js"></script>
    <script src="<%=request.getContextPath()%>/assets/assets-for-demo/js/vertical-nav.js"></script>
    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
</body>

</html>