<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Login Form</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
</head>
<body>
	<div class="container py-5 h-100">
		<div class="row d-flex justify-content-center  h-100">
	        <div class="card align-items-center" style="border-radius: 1rem;">
	          <div class="align-items-center" >
					<h2 class="fw-bold mb-2 text-uppercase text-center fontstytle">Đăng nhập</h2>
						<form action="<%=request.getContextPath()%>/login" method = "post"  >
							<!-- Tai khoan input -->
						    <div class="input-group mb-3" style="width: 500px;">
								<span class="input-group-text" id="basic-addon1">
									<i class="bi bi-person-circle"></i>
								</span>
								<input type="text" class="form-control" id="validationCustomUsername" placeholder="Nhập tên tài khoản"
								aria-describedby="inputGroupPrepend" required name="taikhoan" style="width: 300px;">		      
							</div>
							<!-- Mat khau input -->
							<div class="input-group mb-3" style="width: 500px;">
								<span class="input-group-text" id="basic-addon2">
							  		<i class="bi bi-key-fill"></i>
							    </span>
							    <input type="password" class="form-control" id="validationCustomPassword" placeholder="Nhập mật khẩu" 
							    aria-describedby="basic-addon2" required name="matkhau" style="width: 300px;">					  
							</div>
							<!-- Phân quyền -->
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="loai" id="option2" value="2" >
								  <label class="form-check-label" for="option2">Sinh viên</label>
								</div>
								<div class="form-check form-check-inline">
									  <input class="form-check-input" type="radio" name="loai" id="option1" value="1">
									  <label class="form-check-label" for="option1">Chuyên viên PCTSV</label>
								</div>
								<div class="form-check form-check-inline">
									  <input class="form-check-input" type="radio" name="loai" id="option0" value="0" checked>
									  <label class="form-check-label" for="option0">Quản trị viên </label>
								</div>
							<!-- Button Đăng nhập -->
							<div>
							<button type="submit" class="btn btn-primary btn-block mb-4" style="width: 500px;" >
							    Đăng nhập
					  		 </button>
							</div>				
							
						</form> 
						
			  </div>
            </div>
        </div>
	</div>
</body>
</html>