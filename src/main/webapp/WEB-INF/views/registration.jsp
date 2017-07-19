<div class="panel panel-default" style="margin-top: 15px;">
	<div class="panel-heading">Register</div>
	<div class="panel-body">
		<form:form class="form-horizontal"
			action="${pageContext.request.contextPath}/register" method="post"
			modelAttribute="userDTO" enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-md-4">First Name*</label>
				<div class="col-md-8">
					<form:input type="text" path="firstName" class="form-control"
						id="firstName" placeholder="Enter First Name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4">Last Name*</label>
				<div class="col-md-8">
					<form:input type="text" class="form-control" id="lastName"
						placeholder="Enter Last Name" path="lastName" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4">Email*</label>
				<div class="col-md-8">
					<form:input type="email" class="form-control" id="regemail"
						placeholder="Enter email" path="email" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4">Username*</label>
				<div class="col-md-8">
					<form:input type="text" class="form-control" id="username"
						placeholder="Enter username" path="username" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4">Password*</label>
				<div class="col-md-8">
					<form:input type="password" class="form-control" id="regpassword"
						placeholder="Enter password" path="password" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4"> Confirm Password*</label>
				<div class="col-md-8">
					<form:input type="password" class="form-control" id="confpassword"
						placeholder="Confirm password" path="confPassword" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4">Photo*</label> <input
					type="file" name="userImage" />

			</div>
			<input type="submit" class="btn btn-default"
				style="margin-left: 280px; margin-top: 15px;" />
		</form:form>
	</div>
</div>