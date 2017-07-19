<div class="panel panel-default" style="margin-top: 15px;">
	<div class="panel-heading">Login</div>
	<div class="panel-body">
		<form:form class="form-horizontal"
			action="${pageContext.request.contextPath}/login" method="post"
			modelAttribute="userDTO">
			<div class="form-group">
				<label class="control-label col-md-4">Email/Username*</label>
				<div class="col-md-8">
					<form:input type="text" class="form-control" id="email"
						path="email" required="true" placeholder="Enter email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4">Password*</label>
				<div class="col-md-8">
					<form:input type="password" class="form-control" id="password"
						placeholder="Enter Password" path="password" required="true" />
				</div>
			</div>
			<button type="button" class="btn btn-link" style="margin-top: 25px;">Forgot
				Password</button>
			<button type="submit" class="btn btn-default"
				style="margin-left: 100px; margin-top: 25px;">Login</button>
		</form:form>
	</div>
</div>