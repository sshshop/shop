

		function checkForm(){
		//�����û���
		//����û����ı����ֵ
		
		var username=document.getElementById("username").value;
		if(username==null||username==""){
			
			alert("�û�������Ϊ�գ�")
			return false;	
		}
			
		//��������
		//��������ı����ֵ
			
		var password=document.getElementById("password").value;
		if(password==null||password==""){
		
		alert("���벻��Ϊ�գ�")
		return false;	
		}
		//����ȷ������
		
		
		var repassword=document.getElementById("repassword").value;
		if(password!=repassword ){
		
		alert("�����������벻һ�£�")
		return false;
		
		}
		
		
		//��֤�����ʽ
		var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
		var email=document.getElementById("email").value;
        if ( regex.test(email) )
        {
           return true;
        }
        else
        {
            alert( "������ĵ����ʼ���ַ���Ϸ�" );
            return false;
        }
		
		
		var name=document.getElementById("name").value;
		if(name==null||name==""){
			
			alert("���ֲ���Ϊ�գ�")
			return false;	
		}
		
		
		var addr=document.getElementById("addr").value;
		if(addr==null||addr==""){
			
			alert("��ַ����Ϊ�գ�")
			return false;	
		}
		
		
	}
		
		
		function checkUsername(){
		// ����ļ���ֵ:
		var username = document.getElementById("username").value;
		// 1.�����첽��������
		var xhr = createXmlHttp();
		// 2.���ü���
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		}
		// 3.������
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&username="+username,true);
		// 4.����
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
		

