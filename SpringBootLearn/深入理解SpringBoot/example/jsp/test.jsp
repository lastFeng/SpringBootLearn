<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!--testPage-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>�����Ʒ����</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js">
		</script>
	</head>
	<script type="text/javascript">
			var params = {
				userId : 1,
				productId : 1,
				quantity : 3
			};
			
			// ͨ��post������
			$.post("./example/purchase", params, function(result){
				alert(result.message);
			});
			
			// �߲�������
			for(var i=0; i<=500000; i++){
					var params = {
						userId : 1,
						productId : 1,
						quantity: 1
					};
					$.post("./example/purchase", params, function(result){
						
					});
			}
	</script>
	
	<body>
		<h1>������Ʒ����</h1>
	</body>
</html>