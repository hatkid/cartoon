
window._bd_share_config={"share":{bdCustomStyle :"./style/share.css"}};
with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];

$(".slideDown_sub").hover(function(){
		$(this).addClass("slideCur_sub");
		$(this).stop().animate({height:"440px"},"slow");
		$(this).find(".selectBox_sub").show();
	},function(){
		$(this).stop().css({height:"43px"});
		$(this).find(".selectBox_sub").hide();
		$(this).removeClass("slideCur_sub");
	
});


/*分享到图标*/
$(".cnt_share .icon a").each(function(i){
	$(this).mouseenter(function(){
		$(this).stop().animate({top:"-10px"},"normal",function(){$(this).animate({top:"0px"},"normal")});
	});
	$(this).mouseleave(function(){
		$(this).stop().animate({top:"0px"},"normal");
	});
})