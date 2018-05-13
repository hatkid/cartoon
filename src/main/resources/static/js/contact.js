$(document).ready(function(){
    var baidumap=$("#baidumap");
	    if(baidumap.length>0){
	    	var map = new BMap.Map("baidumap");    // 创建Map实例 
			// 百度地图API功能
			var point = new BMap.Point(config.location.gps[0],config.location.gps[1]);
			var marker = new BMap.Marker(point);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			map.centerAndZoom(point, 15);
			var opts = {
			  width : 200,     // 信息窗口宽度
			  height: 100,     // 信息窗口高度
			  title : config.location.title 
			}
			var infoWindow = new BMap.InfoWindow(config.location.address, opts);  // 创建信息窗口对象 
			marker.addEventListener("click", function(){          
				map.openInfoWindow(infoWindow,point); //开启信息窗口
			});
		   
	    }

	   //  if($(".check").length>0){
				// 	var basicTimeline = anime.timeline({
				// 	  autoplay: false
				// 	});

				// var pathEls = $(".check");
				// for (var i = 0; i < pathEls.length; i++) {
				//   var pathEl = pathEls[i];
				//   var offset = anime.setDashoffset(pathEl);
				//   pathEl.setAttribute("stroke-dashoffset", offset);
				// }

				// basicTimeline
				// 	  .add({
				// 	    targets: ".text",
				// 	    duration: 1,
				// 	    opacity: "0"
				// 	  })
				// 	  .add({
				// 	    targets: ".button",
				// 	    duration: 1300,
				// 	    height: 20,
				// 	    width: 230,
				// 	    border: "0",
				// 	    borderRadius: 100
				// 	  })
				// 	  .add({
				// 	    targets: ".progress-bar",
				// 	    duration: 2000,
				// 	    width: 230,
				// 	    easing: "linear"
				// 	  })
				// 	  .add({
				// 	    targets: ".button",
				// 	    width: 0,
				// 	    duration: 1
				// 	  })
				// 	  .add({
				// 	    targets: ".progress-bar",
				// 	    width: 80,
				// 	    height: 80,
				// 	    bottom:"-40px",
				// 	    delay: 500,
				// 	    duration: 750,
				// 	    borderRadius: 80,
				// 	    backgroundColor: "#71DFBE"
				// 	  })
				// 	  .add({
				// 	    targets: ".svg",
				// 	    left: "155px",
				// 	    duration: 1
				// 	  })
				// 	  .add({
				// 	    targets: pathEl,
				// 	    strokeDashoffset: [offset, 0],
				// 	    duration: 200,
				// 	    easing: "easeInOutSine"
				// 	  });

					

				
				// }

	$(".button").click(function() {
		  
		  var require=$("#require").val();
		  var name=$("#name").val();
		  var phone=$("#phone").val();

		  if(require === ""){
		  	$("#requireerrmsg").show();
		  	return;
		  }else{
		  	$("#requireerrmsg").hide();
		  }

		  if(name === ""){
		  	$("#nameerrmsg").show();
		  	return;

		  }else{
		  	$("#nameerrmsg").hide();
		  }

		  if(phone === ""){
		  	$("#phoneerrmsg").show();
		  	return;
		  }else{
		  	$("#phoneerrmsg").hide();
		  }
		  var params={"demandContent": require,"name": name,"phone": phone};

		  $.ajax({
		  	url:config.ip+config.api.require,
		  	type:"post",
		  	contentType:"application/json;charset=utf-8",
		  	data:JSON.stringify(params),
			dataType:"json",
			processData:true,
			traditional:true,
			complete:function(data){
				var data=JSON.parse(data.responseText);
				if(data.msg==="success"){
					// basicTimeline.play();
					alert("提交成功")
					$("#require").val("");
					$("#name").val("");
					$("#phone").val("");
				}else{
					alert("网路故障，请稍后重试");
				}
				
			},
			error:function(){
				alert("网路故障，请稍后重试");
			}

		  });

		});

	});