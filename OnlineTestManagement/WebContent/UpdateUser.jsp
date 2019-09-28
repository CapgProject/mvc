<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form action="updateusersubmit" method="POST"
			modelAttribute="userupdate">
			<tr>
				<td>User Name :</td>
				<td><fo:input path="userName" /></td>
			</tr>

			<tr>
				<td>User Password :</td>
				<td><fo:input path="userpassword" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Update User" /></td>
				<td><input type="reset" value="Clear"></td>
			</tr>

	
	</form>
	</table>

</body>
</html>