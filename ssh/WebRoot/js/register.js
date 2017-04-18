

		function checkForm(){
		//检验用户名
		//获得用户名文本框的值
		
		var username=document.getElementById("username").value;
		if(username==null||username==""){
			
			alert("用户名不能为空！")
			return false;	
		}
			
		//检验密码
		//获得密码文本框的值
			
		var password=document.getElementById("password").value;
		if(password==null||password==""){
		
		alert("密码不能为空！")
		return false;	
		}
		//检验确认密码
		
		
		var repassword=document.getElementById("repassword").value;
		if(password!=repassword ){
		
		alert("两次密码输入不一致！")
		return false;
		
		}
		
		
		//验证邮箱格式
		var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
		var email=document.getElementById("email").value;
        if ( regex.test(email) )
        {
           return true;
        }
        else
        {
            alert( "您输入的电子邮件地址不合法" );
            return false;
        }
		
		
		var name=document.getElementById("name").value;
		if(name==null||name==""){
			
			alert("名字不能为空！")
			return false;	
		}
		
		
		var addr=document.getElementById("addr").value;
		if(addr==null||addr==""){
			
			alert("地址不能为空！")
			return false;	
		}
		
		
	}
		
		
		function checkUsername(){
		// 获得文件框值:
		var username = document.getElementById("username").value;
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		}
		// 3.打开连接
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&username="+username,true);
		// 4.发送
		xhr.send(null);
	}	
		
		
		function createXmlHttp(){
		   var xmlHttp;
		   try{ // Firefox, Opera 8.0+, Safari
		        xmlHttp=new XMLHttpRequest();
		    }
		    catch (e){
			   try{// Internet Explorer
			         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			      }
			    catch (e){
			      try{
			         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			      }
			      catch (e){}
			      }
		    }

			return xmlHttp;
		 }
		

