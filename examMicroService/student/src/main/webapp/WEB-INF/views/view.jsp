<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">  
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>  
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"> </script>  
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"> </script>  
	  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">   
	  <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>  
	    		
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>  
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>  
	<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link> 

<title>View</title>
</head>

<body>
	<c:if test="${msg == 'success' }">
		<script>
			swal("Success",'Student Enrollment Successful', "success");
		</script>
	</c:if>
	<c:if test="${msg == 'emptyFiled' }">
		<script>
		swal("Error", "Fields Cannot be blank", "error");
		</script>
	</c:if>

<div class="container mt-3" style="margin-left: 200px">
<div class="card-body">

	<form action="/studentWeb/saveStudentCourseDetail" method="post" name="courseEnrollmentForm" id="courseEnrollmentForm">
	  <div class="form-group row">
	    <label for="studentId" class="col-sm-2 col-form-label">Student Name</label>
	    <div class="col-sm-5">
	      <select class="form-control" id="studentId" name="studentId">
	      	<option value="0">SELECT</option>
		      	<c:forEach items="${details }" var="p">
		      		<option value="${p.studentId }">${p.studentName }</option>
		      	</c:forEach>
	      </select>
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="courseName" class="col-sm-2 col-form-label">Course Name</label>
	    <div class="col-sm-5">
	      <input type="text" class="form-control" id="courseName" name="courseName">
	    </div>
	  </div>
	  
	  <div>
	  	<input type="button" value="SUBMIT" class="btn btn-success" onclick="save()">
	  	<input type="reset" value="reset" class="btn btn-warning">
	  </div>
	  
	</form>


	
	</div>
	<script>
		function save(){
			var studentId = $('#studentId').val();
			var courseName = $('#courseName').val();
			
			if(studentId == '0'){
				swal("Error", "Select Student Name", "error");
				return false;
			}
			else if(courseName.length == 0){
				swal("Error", "Enter Course Name", "error");
				return false;
			}
			else{
				$('#courseEnrollmentForm').submit();
			}
		}
	</script>
</body>
</html>