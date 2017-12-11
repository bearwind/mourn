
$(function(){
	$.frame.nav();
})

$.frame = {
	//导航栏操作
	nav: function(){
			$(".am-nav li").click(function(){
				$(this).addClass("am-active");
				$(this).siblings().removeClass("am-active");
				var _id = $(this).attr("id");
				var _order = _id.substring(_id.indexOf("nav") + 4);
				var _url = "";
				switch (_order) {
				case "first":
					_url = "../admin/index";
					break;
				case "second":
					_url = "../record/module/query";
					break;
				case "third":
					_url = "../record/module/add";
					break;
				case "fourth":
					_url = "../admin/auth";
					break;
				default:
					_url = "../access/logout";
					break;
				}
				$(".frame_main").load(_url);
			});
		}
}






