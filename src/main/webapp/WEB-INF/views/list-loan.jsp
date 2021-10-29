<%@ include file="common/header.jspf"%>
<div class="container">
	<table class="table table-striped">
		<caption>Customer List</caption>

		<thead>
			<tr>
				<th>Account Number</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Loan Type</th>
				<th>Loan Amount</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${loans}" var="loan">
				<tr>
					<td>${loan.customer.accountNumber}</td>
					<td>${loan.customer.firstName}</td>
					<td>${loan.customer.lastName}</td>
					<td>${loan.type}</td>
					<td>${loan.amount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</div>
</body>
</html>