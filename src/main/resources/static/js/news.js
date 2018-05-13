//去除标签
function parseContent(str){

    return str.replace(/<\/?.+?>/g,"").replace(/ /g,"");
}


$(document).ready(function(){

	var newListApi=config.ip+config.api.newsList;
	var p1 = {'pageNo': 1,'pageSize': 4,'type':1};
    var p2 = {'pageNo': 1,'pageSize': 5,'type':2};


     $.ajax({
		  	url:newListApi,
		  	type:"post",
		  	contentType:"application/json;charset=utf-8",
		  	data:JSON.stringify(p1),
			dataType:"json",
			processData:true,
			traditional:true,
			complete:function(data){
				var data=JSON.parse(data.responseText).data.data;
				var str=[];
				if(data.length == 0){
					$("#top-article-0").html("<div class='page-news-img-text' >网络故障</div>");
					$("#top-article-1").html("<div class='page-news-img-text' >网络故障</div>");
					return;
				}
				for(var i=0;i<data.length;i++){
					str.push('<div class="page-news-img-text " >'+
        				'<a href="./article.html?type=1&id='+data[i].id+'" class="title">'+data[i].title+'</a>'+
        				'<div class="brief">'+parseContent(data[i].content).substring(0,100)+"..."+'</div></div>');

				}
				$("#top-article-0").html(str[0]);
				$("#top-article-1").html(str.slice(1).join("\n"));
			},
			error:function(){
				$("#top-article-0").html("<div class='page-news-img-text' >网络故障</div>");
				$("#top-article-1").html("<div class='page-news-img-text' >网络故障</div>");
			}

		  });

          $.ajax({
		  	url:newListApi,
		  	type:"post",
		  	contentType:"application/json;charset=utf-8",
		  	data:JSON.stringify(p2),
			dataType:"json",
			processData:true,
			traditional:true,
			complete:function(data){
				var data=JSON.parse(data.responseText).data.data;
				var str=[];
				if(data.length == 0){
					$("#bottom-article").html("<div class='news-item' >网络故障</div>");
					return;
				}
				for(var i=0;i<data.length;i++){
					str.push(
						'<div class="news-item">'+
	        				'<div class="news-time">'+
	        					'<div style="padding-top: 20px;font-size: 25px;">'+data[i].createTime.substring(8,10)+'</div>'+
	        					'<div style="font-size: 14px">'+data[i].createTime.substring(0,4)+'/'+data[i].createTime.substring(5,7)+'</div>'+
	        				'</div>'+
	        				'<div class="news-item-right">'+
	        				   '<a href="./article.html?type=2&id='+data[i].id+'" class="title">'+data[i].title+'</a>'+
	        				   '<div class="brief">'+parseContent(data[i].content).substring(0,100)+"..."+'</div>'+
        			       '</div>'+
        			     '</div>'
        			);

				}
		
				$("#bottom-article").html(str.join("\n"));
			},
			error:function(){
				$("#bottom-article").html("<div class='news-item' >网络故障</div>");
			}

		  });

});