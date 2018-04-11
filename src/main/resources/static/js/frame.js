$(function () {
    $.framePage.nav();
    $.framePage.navRefresh();
    $.framePage.popState();
});

$.framePage = {
    //导航栏操作
    nav: function () {
        $(".am-nav li").on("click", function(){
            $(this).addClass("am-active");
            $(this).siblings().removeClass("am-active");
            var _id = $(this).attr("id");
            var _order = _id.substring(_id.lastIndexOf("-") + 1);
            var _hash = "#"+_order;
            $.framePage.loadPage(_hash);

        });
    },

    menuActive: function(_hash){
        var _active = $("#common-nav-" + _hash.substring(1));
        _active.addClass("am-active");
        _active.siblings().removeClass("am-active");
    },
    loadPage: function (_hash){
        var _url = "";
        switch (_hash) {
            case "#second":
                _url = "../record/query";
                break;
            case "#third":
                _url = "../record/add";
                break;
            case "#fourth":
                _url = "../admin/auth";
                break;
            case "#fifth":
                _url = "../access/other";
                break;
            default:
                _url = "../admin/index";
        }

        $(".frame_main").load(_url, function(response,status,xhr){
            if(xhr.status === 404 || xhr.status === 500){
                //location.href = "error";
                $(".am-modal-bd").html("该功能暂时未开放，敬请期待！");
                $("#common-modal-alert").modal({
                });
            } else {
                history.replaceState(_hash, null, "../admin/frame" + _hash);
                $.framePage.loadJS();
            }
        });
    },
    popState : function(){
        window.addEventListener("popstate", function() {
            var _hash = history.state;
            //alert("1. popState = " + _hash);
            if(_hash != null){
                $.framePage.menuActive(_hash);
                $.framePage.loadPage(_hash);
            }
        });
    },
    navRefresh : function(){
        window.onload = function () {
            var _hash = window.location.hash;
            if(_hash === ""){
                _hash = "#default";
            }
            $.framePage.menuActive(_hash);
            $.framePage.loadPage(_hash);
        }
    },
    loadJS: function () {
        $.getScript("../js/amazeui.min.js");
        $.getScript("../js/app.js");
    }

};