<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Aviators - byaviators.com">
    <link href='http://fonts.useso.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
    <link rel="shortcut icon" href="assets/img/favicon.png" type="image/png">
    <link rel="stylesheet" href="assets/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="assets/css/bootstrap-responsive.css" type="text/css">
    <link rel="stylesheet" href="assets/libraries/chosen/chosen.css" type="text/css">
    <link rel="stylesheet" href="assets/libraries/bootstrap-fileupload/bootstrap-fileupload.css" type="text/css">
    <link rel="stylesheet" href="assets/libraries/jquery-ui-1.10.2.custom/css/ui-lightness/jquery-ui-1.10.2.custom.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/realia-blue.css" type="text/css" id="color-variant-default">
    <link rel="stylesheet" href="#" type="text/css" id="color-variant">
    <#include "title.ftl"/>
</head>
<body>
<div id="wrapper-outer" >
    <div id="wrapper">
        <div id="wrapper-inner">
            <!-- BREADCRUMB -->
            <!-- HEADER -->
            <#include "header.ftl"/>
            <!-- NAVIGATION -->
            <!-- CONTENT -->
            <div id="content">
<div class="container">
    <div>
        <div id="main">
            <h1 class="page-header">登录</h1>
            <div class="login-register">
<div class="row">
<div class="span4">
    <div class="tab-content">
       

        <div class="tab-pane active" id="register">
            <form method="post" action="toLogin.do">
                <div class="control-group">
                    <label class="control-label" for="inputRegisterFirstName">
                        用户名
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="text" id="name" name="name">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->

                <div class="control-group">
                    <label class="control-label" for="inputRegisterSurname">
                        密码
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="text" id="inputRegisterSurname" name="password">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group 

                <div class="control-group">
                    <label class="control-label" for="inputRegisterEmail">
                        E-mail
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="text" id="inputRegisterEmail">
                    </div>
                    <!-- /.controls
                </div>
                -->
                <div class="form-actions">
                    <input type="submit" value="登录" class="btn btn-primary arrow-right">
                </div>
                <!-- /.form-actions -->
            </form>
        </div>
        <!-- /.tab-pane -->
    </div>
    <!-- /.tab-content -->
</div>
<!-- /.span4-->

<div class="span8">
    <h2 class="page-header">Why to work with us?</h2>

    <div class="images row">
        <div class="item span2">
            <img src="assets/img/icons/circle-dollar.png" alt="">

            <h3>Cheap services</h3>
        </div>
        <!-- /.item -->
        <div class="item span2">
            <img src="assets/img/icons/circle-search.png" alt="">

            <h3>Easy to find you</h3>
        </div>
        <!-- /.item -->
        <div class="item span2">
            <img src="assets/img/icons/circle-global.png" alt="">

            <h3>Act global or local</h3>
        </div>
        <!-- /.item -->
        <div class="item span2">
            <img src="assets/img/icons/circle-package.png" alt="">

            <h3>All in one package</h3>
        </div>
        <!-- /.item -->
    </div>
    <!-- /.row -->

    <hr class="dotted">

    <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ullamcorper libero sed ante auctor vel
        gravida nunc placerat. Suspendisse molestie posuere sem, in viverra dolor venenatis sit amet. Aliquam
        gravida nibh quis justo pulvinar luctus. Phasellus a malesuada massa.
    </p>

    <ul class="unstyled dotted">
        <li>
                                        <span class="inner">
                                            <strong>Lorem ipsum dolor sit amet</strong><br>

                                                Consectetur adipiscing elit. Proin aliquam lorem sed urna viverra
                                                accumsan. Aliquam sit amet dui et diam rutrum aliquet. Sed vulputate,
                                                arcu vitae aliquet facilisis, ligula sem posuere nisl, sit amet pretium
                                                ligula dolor

                                        </span>
        </li>

        <li>
                                        <span class="inner">
                                            <strong>Lorem ipsum dolor sit amet</strong><br>
                                                Consectetur adipiscing elit. Proin aliquam lorem sed urna viverra
                                                accumsan. Aliquam sit amet dui et diam rutrum aliquet. Sed vulputate,
                                                arcu vitae aliquet facilisis, ligula sem posuere nisl, sit amet pretium
                                                ligula dolor
                                        </span>
        </li>

        <li>
                                        <span class="inner">
                                            <strong>Lorem ipsum dolor sit amet</strong><br>
                                                Consectetur adipiscing elit. Proin aliquam lorem sed urna viverra
                                                accumsan. Aliquam sit amet dui et diam rutrum aliquet. Sed vulputate,
                                                arcu vitae aliquet facilisis, ligula sem posuere nisl, sit amet pretium
                                                ligula dolor
                                        </span>
        </li>
    </ul>
</div>
</div>
<!-- /.row -->
</div><!-- /.login-register -->        </div>
    </div>
</div>

    </div><!-- /#content -->
</div><!-- /#wrapper-inner -->

<#include "footer.ftl"/>
</body>
</html>