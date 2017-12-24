
$(function(){
	$.frame.nav();
	$.login.validate();
	$.login.submit();

	window.localStorage.setItem("test", "this is a test!");
	window.localStorage.setItem("test", "2222!");
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

$.login = {
	//校验
    validate: function(){
        $("#login-form").validator({
            onInValid: function(validity) {
                var $field = $(validity.field);
                // 使用自定义的提示信息 或 插件内置的提示信息
                var msg = $field.data('validationMessage') || this.getValidationMessage(validity);
                $field.attr("placeholder", msg);
            }
        });
    },
	submit: function(){
		$("#login-form").submit(function(){
			var _name = $("#login-name").val();
			var _pwd = $("#login-pwd").val();
			if(!_name || !_pwd ){
				return;
			}
			// $.cookie("test","xiongfeng1",{expires:9999,path:"/"});
			// alert($.cookie("test"));

			$.ajax({
				type:"POST",
				url:"../access/checkUser",
				data:"name="+_name + "&password=" + _pwd + "&rememberMe="+$("#remember-me").is(":checked"),
				dataType:"json",
				success: function(obj){
					if(obj.code === "01"){
						if(!obj.token){
							$.cookie("token", obj.token, {expires:30,path:"/"})
						}
                        location.href = "../admin/frame";
					} else {
						var tip = $(".am-panel");
						tip.removeClass("hidden").addClass("visible");
						tip.children("div").html("用户名或密码错误!");
					}
				}
			});
            return false;
		})
	}
}






