<%@ include file="common/header.jspf" %>
		<div class="container-fluid d-flex justify-content-center bg-dark align-items-center text-dark custom-h-100">
			<div class="custom-container-2 p-3 rounded">
				<div class="d-flex justify-content-center">
					<h3>Login</h3>
				</div>
				<form method="post">
					<div class="form-group">
						<label for="username">Username</label>
						<input class="form-control" type="text" id="username" name="username">
					</div>
					<div class="form-group">
						<label for="password">Password </label>
						<input class="form-control" type="password" id="password" name="password">
					</div>
					<input class="btn btn-primary btn-block" type="submit">
					<c:if test="${param.error != null}">
						<div class="text-danger pt-1">
							Invalid User ID and Password
						</div>
					</c:if>
				</form>
			</div>
		</div>
<%@ include file="common/footer.jspf" %>