/*
	r10.net
	technic
	@technic.js
*/

	$(function(){
		// sosyal hover
		$("#sosyal").hover(function(){
				var ok = $(this).find("i");
					ok.slideDown();
			},function(){
				var ok = $(this).find("i");
					ok.slideUp();
		});
		// manşet
		$(".mansetresim").bxSlider({
			auto: true,
			pager: true
		});
		// günün fırsatı
		$("#gf ul").bxSlider({
			auto: true,
			mode : 'vertical',
			displaySlideQty: 3,
			moveSlideQty: 1
		});
	});