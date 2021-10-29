<%@ include file="common/header.jspf"%>
<div class="container">
	<div class="col-md-offset-2 col-md-7">
		<h3 class="text-center">Apply Loan</h3>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Loan Request</div>
			</div>
			<div class="panel-body">
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<form:errors path="customer" cssClass="error">
							
				</form:errors>
				<form:form action="saveLoan" cssClass="form-horizontal"
					method="post" modelAttribute="loan">

					<!-- need to associate this data with loan id -->
					<form:hidden path="id" />

					<div class="form-group">
						<label for="accountNumber" class="col-md-3 control-label">Username
							(account number)</label>
						<div class="col-md-9">
							<input name="accountNumber" class="form-control" type="number"
								required min="1" max="999999999"
								placeholder="9 digit account number" value="${account}" />
						</div>
						<form:errors path="accountNumber" cssClass="error">
							
						</form:errors>
					</div>
					<div class="form-group">
						<label for="type" class="col-md-3 control-label">Type</label> <input
							type="radio" id="Agriculture" name="type" value="Agriculture">
						<label for="Agriculture ">Agriculture</label> <input type="radio"
							id="Commercial" name="type" value="Commercial"> <label
							for="Commercial">Commercial</label><input type="radio" id="Home"
							name="type" value="Home"> <label for="other">Home</label>
						<form:errors path="type" cssClass="error">
							
						</form:errors>
					</div>

					<div class="form-group">
						<label for="amount" class="col-md-3 control-label">Amount</label>
						<div class="col-md-9">
							<input name="amount" class="form-control" type="number" required
								maxlength="7" size="7" placeholder="5,00,000" />
						</div>
						<form:errors path="amount" cssClass="error">
							
						</form:errors>
					</div>

					<div class="form-group">
						<label for="numberOfEmi" class="col-md-3 control-label">EMI
							Terms</label>
						<div class="col-md-9">
							<input name="range" class="form-control" type="range" required
								min="36" max="120" value="60"
								onchange="updateTextInput(this.value);" /> <input type="text"
								name="numberOfEmi" id="numberOfEmi" value="60" readonly>
						</div>
						<form:errors path="numberOfEmi" cssClass="error">
							
						</form:errors>
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
<script type="text/javascript">
	function updateTextInput(val) {
		document.getElementById('numberOfEmi').value = val;
	}
</script>
</html>