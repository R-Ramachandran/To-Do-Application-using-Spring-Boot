<%@ include file="common/header.jspf" %>
		<div class="bg-dark h-100">
			<div class="container bg-light py-2 h-100">
				<%@ include file="common/navigation-bar.jspf" %>
				<h1 class="text-dark text-center">List of Todos</h1>
				<p class="lead">${ name }'s Todo List</p>
				<a href="add-todo" class="btn btn-info btn-block">Add Todo</a>
				<table class="table table-striped table-bordered table-hover my-1 table-responsive">
					<thead class="thead-dark">
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Priority</th>
							<th>Start Date</th>
							<th>Due Date</th>
							<th>Estimated Time</th>
							<th>Place</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ todos }" var="todo">
							<tr>
								<td>${ todo.todoTitle }</td>
								<td>${ todo.detail }</td>
								<td>${ todo.priority }</td>
								<td><fmt:formatDate value="${ todo.startDate }" pattern="dd/MM/yyyy"/></td>
								<td><fmt:formatDate value="${ todo.dueDate }"  pattern="dd/MM/yyyy"/></td>
								<td>${ todo.estTime }</td>
								<td>${ todo.place }</td>
								<td><a href="update-todo?id=${todo.id}" class="btn btn-warning"><i class="fas fa-pen-alt"></i></a></td>
								<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
<%@ include file="common/footer.jspf" %>