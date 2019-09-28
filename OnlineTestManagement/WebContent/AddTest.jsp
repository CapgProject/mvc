<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Add Test

	<table>

		<fo:form action="addtestsubmit" method="POST" modelAttribute="test">

			<tr>
				<td>Test Id :</td>
				<td><fo:input path="testId" /></td>
			</tr>

			<tr>
				<td>Test Name :</td>
				<td><fo:input path="testName" /></td>
			</tr>

			<tr>
				<td>Test Duration :</td>
				<td><fo:input path="testDuration" />
			</tr>

			<tr>
				<td>Test Total Marks :</td>
				<td><fo:input path="testTotalMarks" /></td>
			</tr>

			<tr>
				<td>Test Start Time :</td>
				<td><fo:input path="startTime" /></td>
			</tr>

			<tr>
				<td>Test End Time :</td>
				<td><fo:input path="endTime" /></td>
			</tr>
			<tr>
				<td>Test Marks Scored :</td>
				<td><fo:input path="testMarksScored" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Product" />
				<td><input type="reset" value="Clear">
			</tr>

		</fo:form>

	</table>
	<table>

	</table>
</body>
</html>