<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/app.js"></script>


<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="#" method="post" modelAttribute="userAcc">
		<table>
			<tr>
				<th>First Name:</th>
				<td><form:input path="userFname" /></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><form:input path="userLname" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input path="userEmail" /></td>
			</tr>
			<tr>
				<th>Mobile:</th>
				<td><form:input path="userPhone" /></td>
			</tr>
			<tr>
				<th>Date-Of-Birth:</th>
				<td><form:input path="DOB"/></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td>Male:<form:radiobutton path="userGender" value="M"
						id="gender" /> Female:<form:radiobutton path="userGender"
						value="F" id="gender" />
				</td>
			</tr>
			<tr>
				<th>Country:</th>
				<td><form:select path="countryId">
						<form:option value="">-Select-</form:option>
						<form:options items="${countryMap}" />
					</form:select></td>
			</tr>
			<tr>
				<th>State:</th>
				<td><form:select path="stateId">
						<form:option value="">-Select-</form:option>
					</form:select></td>
			</tr>
			<tr>
				<th>City:</th>
				<td><form:select path="cityId">
						<form:option value="">-Select-</form:option>
					</form:select></td>
					
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" value="Reset">&nbsp;<input
					type="submit" value="save"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>