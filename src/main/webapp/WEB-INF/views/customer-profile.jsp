<%@ include file="common/header.jspf"%>
<div class="container">
	<div class="col-md-offset-2 col-md-7">
		<h3 class="text-center">Customer Profile</h3>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Update Customer Profile</div>
			</div>
			<div class="panel-body">
				<form:form action="saveCustomerProfile" cssClass="form-horizontal"
					method="post" modelAttribute="customerProfile">

					<form:hidden path="id" />
					<input type="hidden" name="account" value="${account}"/>
					<form:input path="account" cssClass="form-control" type="hidden" />

					<div class="form-group">
						<form:label path="email" class="col-md-3 control-label">Email</form:label>
						<div class="col-md-9">
							<form:input path="email" cssClass="form-control" type="text" />
							<form:errors path="email" class="error">
							</form:errors>
						</div>
						
					</div>

					<div class="form-group">
						<form:label path="phone" class="col-md-3 control-label">Phone</form:label>
						<div class="col-md-9">
							<form:input path="phone" cssClass="form-control" type="text" />
							<form:errors path="phone" class="error">
							</form:errors>
						</div>
						
					</div>

					<div class="form-group">
						<form:label path="addressLine1" class="col-md-3 control-label">Address Line1</form:label>
						<div class="col-md-9">
							<form:input path="addressLine1" cssClass="form-control"
								type="text" />
							<form:errors path="addressLine1" class="error">
							</form:errors>
						</div>
						
					</div>

					<div class="form-group">
						<form:label path="addressLine2" class="col-md-3 control-label">Address Line2</form:label>
						<div class="col-md-9">
							<form:input path="addressLine2" class="form-control" type="text" />
							<form:errors path="addressLine2" class="error">
							</form:errors>
						</div>
						
					</div>

					<div class="form-group">
						<form:label path="city" class="col-md-3 control-label">City</form:label>
						<div class="col-md-9">
							<form:input path="city" class="form-control" type="text" />
							<form:errors path="city" class="error">
							</form:errors>
						</div>
						
					</div>

					<div class="form-group">
						<form:label path="state" class="col-md-3 control-label">State</form:label>
						<div class="col-md-9">
							<form:input path="state" class="form-control" type="text" />
							<form:errors path="state" class="error">
							</form:errors>
						</div>
						
					</div>
					<div class="form-group">
						<form:label path="zip" class="col-md-3 control-label">ZIP</form:label>
						<div class="col-md-9">
							<form:input path="zip" class="form-control" type="text" />
							<form:errors path="zip" class="error">
							</form:errors>
						</div>
						
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<form:button cssClass="btn btn-primary">Submit</form:button>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>