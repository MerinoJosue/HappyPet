<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("vendedor") != null) {
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sistema Bodega| Inicio</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>

        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect. -->
        <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>

<body class="skin-blue sidebar-mini" style="height: auto; min-height: 100%;">
        <div class="wrapper" style="height: auto; min-height: 100%;">

            <!-- Main Header -->
            <header class="main-header">
                <a href="#" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>SH</b>PP</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Happy </b>Pet</span>
                </a>

                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- User Account Menu -->
                            <li class="dropdown user user-menu">
                                <!-- Menu Toggle Button -->
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <!-- The user image in the navbar-->
                                    <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                                    <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                    <span class="hidden-xs">STEPHANO</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- The user image in the menu -->
                                    <li class="user-header">
                                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                        <p>                    
                                            Bienvenido - STEPHANO
                                            <small>Usted es, cliente </small>
                                        </p>
                                    </li>
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-right">
                                            <a href="srvUsuario?accion=cerrar" class="btn btn-default btn-flat">Cerrar Session</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Bienvenido, STEPHANO</p>
                            <!-- Status -->
                            <a href="#"><i class="fa fa-circle text-success"></i> En línea</a>
                        </div>
                    </div>

                    <!-- search form (Optional) -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Buscar..." autofill-information="overall type: UNKNOWN_TYPE
server type: NO_SERVER_DATA
heuristic type: UNKNOWN_TYPE
ml type: NO_SERVER_DATA
raw ml type: NO_SERVER_DATA
label: Search...
parseable name: q
section: q_0_38
field signature: 1012080445
form signature: 16297389673655997237
form signature in host form: 16297389673655997237
alternative form signature: 11468629280104699077
field frame token: 7C0D5277E08313F9283C3C5EF3479145
form renderer id: 34
field renderer id: 38
visible: true
focusable: true
field rank: 0
field rank in signature group: 0
field rank in host form: 0
field rank in host form signature group: 0
field signature string: q&amp;text
form signature string: 
form order: RegularForm0
field order: 0
form signatureV2: -6930874236453214944
field signatureV2: -3890603570666514431
domain signature: 3693946771987704403
c id: 
block suggestion reasons: None
crowd decisions: crowd_decision_0:0, crowd_decision_1:0, crowd_decision_2:0, crowd_decision_3:0" title="overall type: UNKNOWN_TYPE
server type: NO_SERVER_DATA
heuristic type: UNKNOWN_TYPE
ml type: NO_SERVER_DATA
raw ml type: NO_SERVER_DATA
label: Search...
parseable name: q
section: q_0_38
field signature: 1012080445
form signature: 16297389673655997237
form signature in host form: 16297389673655997237
alternative form signature: 11468629280104699077
field frame token: 7C0D5277E08313F9283C3C5EF3479145
form renderer id: 34
field renderer id: 38
visible: true
focusable: true
field rank: 0
field rank in signature group: 0
field rank in host form: 0
field rank in host form signature group: 0
field signature string: q&amp;text
form signature string: 
form order: RegularForm0
field order: 0
form signatureV2: -6930874236453214944
field signatureV2: -3890603570666514431
domain signature: 3693946771987704403
c id: 
block suggestion reasons: None
crowd decisions: crowd_decision_0:0, crowd_decision_1:0, crowd_decision_2:0, crowd_decision_3:0" autofill-prediction="UNKNOWN_TYPE">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->

                    <!-- Sidebar Menu -->
                    <ul class="sidebar-menu tree" data-widget="tree">
                        <li class="header">INICIO</li>
                        <!-- Optionally, you can add icons to the links -->
                        <li class="active"><a href="#"><i class="fa fa-link"></i> <span>Panel Administrativo</span></a></li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-cart-arrow-down"></i> <span>Ventas</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-cart-arrow-down"></i>Nueva Venta</a></li>
                                <li><a href="#"><i class="fa fa-tags"></i>Administrar Ventas</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper" style="min-height: 976.906px;">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Page Header
                        <small>Optional description</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="active">Panel Administrativo</li>
                    </ol>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <footer class="main-footer">
                <!-- To the right -->
                <div class="pull-right hidden-xs">
                    Anything you want
                </div>
                <!-- Default to the left -->
                <strong>Copyright © 2020 <a href="#">IDAT</a>.</strong> Todos los derechos reservados.
            </footer>

            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED JS SCRIPTS -->

        <!-- jQuery 3 -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>

        <!-- Optionally, you can add Slimscroll and FastClick plugins.
             Both of these plugins are recommended to enhance the
             user experience. -->
    


</body>
</html>
<%        
    } else {
        response.sendRedirect("identificar.jsp");
    }
%>