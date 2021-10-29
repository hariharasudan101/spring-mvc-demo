<%@ include file="common/header.jspf"%>
<div class="container">
	<div class="col-md-offset-2 col-md-7">
		<h3 class="text-center">Customer Registration</h3>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Add Customer</div>
			</div>
			<div class="panel-body">
				<form:form action="saveCustomer" cssClass="form-horizontal"
					method="post" modelAttribute="customer">

					<!-- need to associate this data with customer id -->
					<form:hidden path="id" />

					<div class="form-group">
						<label for="accountNumber" class="col-md-3 control-label">Username
							(account number)</label>
						<div class="col-md-9">
							<input name="accountNumber" class="form-control" type="number"
								required size="9" min="111111111" max="999999999"
								placeholder="9 digit account number" />
						</div>
						<form:errors path="accountNumber" cssClass="error">
							<span id="accountNumber.errors" class="error">Invalid
								account number</span>
						</form:errors>
					</div>

					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input name="password" class="form-control" type="password"
								required minlength="6" maxlength="12" placeholder="Password" />
						</div>
					</div>

					<div class="form-group">
						<label for="firstname" class="col-md-3 control-label">First
							Name</label>
						<div class="col-md-9">
							<input name="firstName" class="form-control" type="text" required
								maxlength="20" placeholder="First name" />
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-md-3 control-label">Last
							Name</label>
						<div class="col-md-9">
							<input name="lastName" class="form-control" type="text" required
								maxlength="20" placeholder="Last name" />
						</div>
					</div>

					<div class="form-group">
						<label for="salary" class="col-md-3 control-label">Salary
							(per annum)</label>
						<div class="col-md-9">
							<input name="salary" class="form-control" type="number" required
								min="1" maxlength="6" />
						</div>
					</div>

					<div class="form-group">
						<label for="dob" class="col-md-3 control-label">Date of
							Birth</label>
						<div class="col-md-9">
							<input name="dob" class="form-control" type="date" required
								min="1940-01-01" min="2010-01-01" />
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