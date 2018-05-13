$(document).ready(function(){
	/**lunbo*/

		var leftBtn=$(".swider-left-arrow");
		var rightBtn=$(".swider-right-arrow");

	    function rollTwo(){  
            $(".page-swider-container").stop().animate({marginLeft:"-100%"},1000,"linear",function(){  
                $(".page-swider-container").css({marginLeft:"0px"});  
                $(".page-swider-container .swider-con:first").remove().clone(true).appendTo(".page-swider-container");  
            })  
        }  
        

        function rollLeft(){  
        	
               $(".page-swider-container").css('marginLeft','-100%');  
               $(".page-swider-container .swider-con:last").prependTo($(".page-swider-container"));  
                $(".page-swider-container").stop().animate({marginLeft:"0px"},1000);  
        }  

        var startRollTwo=setInterval(rollTwo,3000); 

        leftBtn.click(function(){
        	clearInterval(startRollTwo);  
             rollLeft();
        	startRollTwo=setInterval(rollTwo,3000); 
        });
         rightBtn.click(function(){
        	clearInterval(startRollTwo);  
        	rollTwo();
        	startRollTwo=setInterval(rollTwo,3000); 
        });


	
})