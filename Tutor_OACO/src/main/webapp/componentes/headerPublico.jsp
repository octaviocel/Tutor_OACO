<!-- <header class="text-center container">
	<div class="row py-lg-2">
		<div class="col-lg-6 col-md-8 mx-auto">
			<p>
				<a href="<%=request.getContextPath()%>/index.jsp"
					class="btn btn-info my-2"> Inicio</a>
			</p>
		</div>
	</div>
</header>
-->

<header id="masthead" class="site-header">
	<nav id="primary-navigation" class="site-navigation">
		<div class="container">

			<div class="navbar-header">

				<a href="<%=request.getContextPath()%>/index.jsp" class="site-title"><span>TUTOR</span> OACO</a>

			</div>
			<!-- /.navbar-header -->

			<div class="collapse navbar-collapse" id="agency-navbar-collapse">

				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="<%=request.getContextPath()%>/index.jsp" data-toggle="dropdown">Home</a></li>
					
					<li class="active"><a href="<%=request.getContextPath()%>/usuario/registrar.jsp" >Register</a></li>
					
					<li><a href="<%=request.getContextPath()%>/usuario/login.jsp">LOGIN</a></li>

				</ul>

			</div>

		</div>
	</nav>
	<!-- /.site-navigation -->
</header>
<!-- /#mastheaed -->