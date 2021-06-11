<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrap{
	width:100%;
	height:100%;
	margin:0 auto;
}

.header{
	height:100%;
	background: #FBCFD0;
}

.container{
	height:100%;
	background: #FBCFD0;
}

.aside{
	width:100%;
	height: 100%;
	background:#D3D5F5;
	float:left;
}

.contents{
	width:100%;
	height: 100%;
	background:#FFFA99;
	float:left;
}

.footer{
	height: 100%;
	background:#C8EFD4;
	clear:both;
}
</style>
</head>
<%@ include file = "common/top.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	//alert("dddd");
	var params = {
		"consumerId" : "tester",
		"amount" : "7",
		"error" : 0
	};
	var jsonString = JSON.stringify(params)
	$("#btnSel").click(function(){
		alert("btn");
		$.ajax({
			url:"json",
			type:"POST",
			data:jsonString,
			dataType:"json",
			contentType:"application/json; charset=UTF-8",
			async:false,
			success:function(data){
				alert(JSON.stringify(data));
			},
			error:function(err){
				alert("error");
			}
		});
		//$("#frm").submit();
	});
});
</script>
<body>
<div class="wrap">
	<div class="header">
		<h1>header</h1>
	</div>
	<div class="container">
		<div class="aside">aside</div>
		<div class="contents">
			<p>카드 결제</p>
			<form id="frm" action="json" method="post">
			
				고객 아이디 : <input type="text" name="consumerId"/> <br/>
				티켓 구매수 : <input type="text" name="amount"/> <br/>
				에러 발생 여부 : <input type="text" name="error" value="0"/> <br/>
				<!-- <input type="submit" value="구매"/> <br/> -->
				<input type="button" id="btnSel" value="구매"/> <br/>
				
			</form>
			
			<hr>
			에러 발생 여부에 1을 입력하면 포함시키는 곳에서 에러가 발생합니다.<br/>
			에러 발생 여부에 2을 입력하면 포함시키는 곳에서 에러가 발생합니다.<br/>
			${result }
		</div>
	</div>
	<div class="footer">
		<h1>footer</h1>
	</div>
</div>

</body>
</html>