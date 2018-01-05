
$(function(){
    $.login.showDeny();
	$.frame.nav();
	$.login.validate();
	$.login.submit();
	$.login.hideDeny();
})

$.frame = {
	//导航栏操作
	nav: function () {
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
					_url = "../record/query";
					break;
				case "third":
					_url = "../record/add";
					break;
				case "fourth":
					_url = "../admin/auth";
					break;
				default:
					_url = "../access/other";
					break;
				}
				$(".frame_main").load(_url);
			});
		}
}

$.login = {
	//校验
    validate: function () {
        $("#login-form").validator({
            onInValid: function(validity) {
                var $field = $(validity.field);
                // 使用自定义的提示信息 或 插件内置的提示信息
                var msg = $field.data('validationMessage') || this.getValidationMessage(validity);
                $field.attr("placeholder", msg);
            }
        });
    },
	submit: function () {
		$("#login-form").submit(function(){
			var _name = $("#login-name").val();
			var _pwd = $("#login-pwd").val();
			if(!_name || !_pwd ){
				return;
			}

			$.ajax({
				type:"POST",
				url:"../access/checkUser",
				data:"name="+_name + "&password=" + _pwd + "&rememberMe="+$("#remember-me").is(":checked"),
				dataType:"json",
				success: function(obj){
					if(obj.code === "01"){
						$.cookie("token", obj.token, {expires:30,path:"/"});
						$.cookie("series", obj.series, {expires:30,path:"/"});
                        location.href = "../admin/frame";
					} else {
                        var _deny = $("#login-deny");
                        _deny.children("div").html("用户名或密码错误!");
                        _deny.removeClass("hidden").addClass("visible");
					}
				}
			});
            return false;
		})
	},
	showDeny: function () {
    	var _deny = $("#login-deny");
		if(_deny.children("div").html()){
			_deny.removeClass("hidden").addClass("visible");
		}
    },
    hideDeny: function () {
		$("#login-form").find("input").click(function(){
            $("#login-deny").removeClass("visible").addClass("hidden")
		});
    },

	autoLogin: function () {

    }


}

$.ajaxSetup({
    //type: 'POST',
    complete: function(xhr,status) {
        var sessionStatus = xhr.getResponseHeader('sessionStatus');
        if(sessionStatus === 'timeout') {
            $("#common-confirm-div").modal({
                //relatedTarget: this,
                onConfirm: function(options) {
                    top.location.href = '../access/login?deny=96';
                }
                // closeOnConfirm: false,
                // onCancel: function() {
                // }
            });
        }
    }
});





