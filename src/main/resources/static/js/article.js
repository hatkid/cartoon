function getDetail(id,type){
	var params={"id": id,"type":type};
	$("html,body").animate({scrollTop:0}, 500);
 	$.ajax({
	  	url:config.ip+config.api.currentNew,
	  	type:"post",
	  	contentType:"application/json;charset=utf-8",
	  	data:JSON.stringify(params),
		dataType:"json",
		processData:true,
		traditional:true,
		complete:function(data){
			var data=JSON.parse(data.responseText).data;
			if(data.current){
				var current=data.current;
				var content=current.content;
				var title=current.title;
				$("#title").html(title);
				$("#content").html(content);
				$("title").html(title);
			}else{
				$("#content").html("<p>网路故障，请稍后重试</p>");
			}

			$("#pre").html("");
			$("#next").html("");

			if(data.pre){
				var prev=data.pre;
				$("#pre").html("上一篇<a href='javascript:void(0)' onclick=getDetail("+prev.id+","+type+")>"+prev.title+"</a>");
			}

			if(data.next){
				var next=data.next;
				$("#next").html("下一篇<a href='javascript:void(0)' onclick=getDetail("+next.id+","+type+")>"+next.title+"</a>");
			}
			
		},
		error:function(){
			$("#content").html("<p>网路故障，请稍后重试</p>");
		}

	  });
 }

 function getUrlParam(name) {  
       var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象  
       var r = window.location.search.substr(1).match(reg);  //匹配目标参数  
       if (r != null) return unescape(r[2]); return null; //返回参数值  
   }  

$(document).ready(function(){
	 var id=getUrlParam("id");
	 var type=getUrlParam("type");
     getDetail(id,type);
});