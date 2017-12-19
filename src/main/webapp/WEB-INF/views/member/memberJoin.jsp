<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		var job="S";
		
		$("#join").click(function() {
			if(job=="S"){
				$("#T").remove();
				$("#frm").attr("action","./student/memberJoin")
			}else{
				$("#S").remove();
				$("#frm").attr("action","./teacher/memberJoin")
			}
			$("#frm").submit();
		});
		
		
		$(".job").click(function() {
			var job=$(this).val();
			if(job=='T'){
				$("#T").css("display","block");
				$("#S").css("display","none");
			}else{
				$("#T").css("display","none");
				$("#S").css("display","block");
			}
		});
		
	});

</script>
<style type="text/css">
	#T {
		display:none;
	}
</style>
</head>
<body>
	<form id="frm" action="./memberJoin" method="POST">
		<p>ID<input type="text" name="id"></p>
		<p>PW<input type="password" name="pw"></p>
		<p>NAME<input type="text" name="name"></p>
		<p>AGE<input type="text" name="age"></p>
		<p>PHONE<input type="text" name="phone"></p>
		<p><input type="radio" class="job" name="job" checked="checked" value="S">Student
		<input type="radio" class="job" name="job" value="T">Teacher</p>
		
		<div id="S">
			<p>TID <input type="text" name="studentDTO.tid"></p>
			<p>Birth <input type="date" name="studentDTO.birth"></p>
			<p>Grade <input type="number" name="studentDTO.grade" value="1"></p>
		</div>
		
		<div id="T">
			<p>HireDate <input type="date" name="teacherDTO.hiredate"></p>
			<p>Subject <input type="text" name="teacherDTO.subject"></p>
			<p>Sal <input type="number" name="teacherDTO.sal" value="0"></p>
		
		</div>
	
	<input type="button" value="join" id="join">JOIN</button>
	</form>

</body>
</html>