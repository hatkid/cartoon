$(document).ready(function(){


	 // 获取页面视口高度
    var viewportHeight = $(window).height();
    var lazyload = function() {
        // 获取窗口滚动条距离
            var scrollTop = $(window).scrollTop();
            $('.animateneeded').each(function(){      
                var x = scrollTop + viewportHeight - $(this).position().top;        
                if (x > 0){
                    $(this).addClass('animated slideInUp');
                }
             })
       }
       
    lazyload();

    $(window).scroll(function(){
    	lazyload();
    });

});