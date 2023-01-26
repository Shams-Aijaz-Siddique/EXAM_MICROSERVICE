<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Web Form</title>
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.8/dist/sweetalert2.all.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>  
	<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>
</head>
<body>
<c:if test="${msg == 'success' }">
		<script>
			swal("Success",'Student Saved Successfully', "success");
		</script>
	</c:if>
	<c:if test="${msg == 'emptyFiled' }">
		<script>
		swal("Error", "Fields Cannot be blank", "error");
		</script>
	</c:if>

<div class="container mt-3" style="margin-left: 200px">
<form action="/studentWeb/saveStudentData" method="post" style="margin-top: 50px">
  <div class="form-group row">
    <label for="studentName" class="col-sm-2 col-form-label">Student Name</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="studentName" id = "studentName" name="studentName">
    </div>
  </div>
  <div class="form-group row">
    <label for="studentEmail" class="col-sm-2 col-form-label">Student Email</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="studentEmail" id = "studentEmail" name="studentEmail">
    </div>
  </div>
  
  <div class="col-5">
  	<button class="btn btn-success">SUBMIT</button>
  	<a href="/studentWeb/viewDetails">Go To View</a>
  </div>
  
  
</form>
</div>

<!-- <script>
	function goToView(){
		$.ajax({
            type: 'GET',
            url: '${pageContext.request.contextPath }' + '/studentWeb/viewDetails',
            contentType: 'application/json', // this
            datatype: 'json',
            async:false,
            /*data: {provider : JSON.stringify(provider)}, */// and this
            success: function (result) {
                alert(result);
                
            }
            
        });
	}
</script> -->

</body>
</html>