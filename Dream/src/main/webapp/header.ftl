  <div class="breadcrumb-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="span12">
                            <ul class="breadcrumb pull-left">
                                <li><a href="index.do">Home</a></li>
                            </ul><!-- /.breadcrumb -->
                            <div class="account pull-right">
                                <ul class="nav nav-pills">
                                <#if user??>
                                    <li><a href="userCenter.do">${user.name!}</a></li>
                                 <#else>
                                      <li><a href="login.do">登录</a></li>
                                    <li><a href="register.do">注册</a></li>
                                 </#if>
                                </ul>
                            </div>
                      </div><!-- /.span12 -->
                  </div><!-- /.row -->
          </div><!-- /.container -->
  </div><!-- /.breadcrumb-wrapper -->
  <!--header -->
  <div id="header-wrapper">
                <div id="header">
                    <div id="header-inner">
                        <div class="container">
                            <div class="navbar">
                                <div class="navbar-inner">
                                    <div class="row">
                                        <div class="logo-wrapper span4">
                                            <a href="#nav" class="hidden-desktop" id="btn-nav">Toggle navigation</a>

                                            <div class="logo">
                                                <a href="index.do" title="Home">
                                                    <img src="assets/img/logo.png" alt="Home">
                                                </a>
                                            </div><!-- /.logo -->

                                            <div class="site-name">
                                                <a href="index.do" title="Home" class="brand">Realia</a>
                                            </div><!-- /.site-name -->
                                        </div><!-- /.logo-wrapper -->

                                        <a class="btn btn-primary btn-large list-your-property arrow-right" href="list-your-property.html">List your property</a>
                                    </div><!-- /.row -->
                                </div><!-- /.navbar-inner -->
                            </div><!-- /.navbar -->
                        </div><!-- /.container -->
                    </div><!-- /#header-inner -->
                </div><!-- /#header -->
</div><!-- /#header-wrapper -->
 <div class="copyrights">Your Company Name</div>
