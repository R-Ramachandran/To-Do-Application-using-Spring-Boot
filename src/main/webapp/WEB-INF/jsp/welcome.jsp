<%@ include file="common/header.jspf" %>
		<div class="bg-dark custom-h-100">
		<%@ include file="common/navigation-bar.jspf" %>
			<div class="jumbotron jumbotron-fluid">
				<div class="container">
					<h1 class="display-4">Welcome ${ name }!</h1>
					<p class="lead">Here is your <a href="todo-list">List of Todo's</a></p>
				</div>
			</div>
		</div>
		<div hidden="hidden">
			${ username }
		</div>
<%@ include file="common/footer.jspf" %>