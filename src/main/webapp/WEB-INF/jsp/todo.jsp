<%@ include file="common/header.jspf" %>
		<div class="bg-dark custom-h-100">
			<div class="container bg-light custom-h-100 py-3">
			<%@ include file="common/navigation-bar.jspf" %>
				<h1 class="text-dark text-center">${ newOrUpdate } Todo</h1>
				<p class="lead">${ name }! you can ${ newOrUpdateDescription } Todo below</p>
				<div class="d-flex justify-content-center">
					<div class="custom-container-1 p-3 rounded text-white">
						<form:form method="post" modelAttribute="todo">
							<div hidden="hidden">
								<form:label path="id" for="title">Todo Title</form:label>
								<form:input path="id" cssClass="form-control" id="id" type="number"></form:input>
							</div>
							<div class="form-group">
								<form:label path="todoTitle" for="title">Todo Title</form:label>
								<form:input path="todoTitle" cssClass="form-control" id="title" type="text" required="required"></form:input>
								<form:errors path="todoTitle" cssClass="text-warning"></form:errors>
							</div>
							<div class="form-group">
								<form:label path="detail" for="description">Description</form:label>
								<form:textarea path="detail" cssClass="form-control" id="description" rows="3"  required="required"></form:textarea>
								<form:errors path="detail" cssClass="text-warning"></form:errors>
							</div>
							<div class="form-group">
								<form:label path="startDate" for="startDate">Start Date</form:label>
								<form:input path="startDate" cssClass="form-control" id="startDate" required="required"></form:input>
								<form:errors path="startDate" cssClass="text-warning"></form:errors>
							</div>
							<div class="form-group">
								<form:label path="dueDate" for="endDate">End Date</form:label>
								<form:input path="dueDate" cssClass="form-control" id="endDate" required="required"></form:input>
								<form:errors path="dueDate" cssClass="text-warning"></form:errors>
							</div>
							<div class="form-group">
								<form:label path="priority" for="priority">Priority</form:label>
								<form:select path="priority" cssClass="custom-select" id="priority">
									<form:option value="High">High</form:option>
									<form:option value="Medium">Medium</form:option>
									<form:option value="Low" selected="selected">Low</form:option>
								</form:select>
							</div>
							<div class="form-group">
								<form:label path="estTime" for="estTime">Estimated Time</form:label>
								<form:input path="estTime" cssClass="form-control" id="estTime" type="text"></form:input>
							</div>
							<div class="form-group">
								<form:label path="place" for="place">Place</form:label>
								<form:input path="place" cssClass="form-control" id="place" type="text"></form:input>
							</div>
							
							<div class="d-flex justify-content-around">
								<a class="btn btn-danger" href="cancel">Cancel</a>
								<input class="btn btn-primary" type="submit">
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
<%@ include file="common/footer.jspf" %>