/**
 * 将所有的表单参数页面$("form").serializeArray()数组转换为json对象
 * @param form 
 * 			&lt;Jquery Object&gt; <br>
 * 			如果不指定form就调用使用$("form");
 */
function formQueryParamsToJson(form){
	var arr=[];
	if(form==undefined){
		arr=$("form").serializeArray();
	}
	var obj={};
	for(var i=0;i<arr.length;i++){
		var item=arr[i];
		var name=arr[i].name;
		var value=arr[i].value
		if(value!=undefined){
			if(obj[name]==undefined){
				obj[name]=value;
			}else if(typeof obj[name] == 'string'){
				var val=obj[name];
				obj[name]=[];
				obj[name].push(value);
			}else if(jQuery.isArray(obj[name])){
				obj[name].push(value);
			}
		}
	}
	return obj;
}

/*var mainContainerApp = angular.module("main-container-app", ["ngRoute"]);
mainContainerApp.directive("customTagDemo01", function() {
    return {
    	restrict : "E",//E 作为元素名使用  A 作为属性使用 C 作为类名使用 M 作为注释使用
        template : "<h1>自定义指令!</h1>"
    };
});
mainContainerApp.directive("customTagDemo02", function() {
    return {
    	restrict : "E",//E 作为元素名使用  A 作为属性使用 C 作为类名使用 M 作为注释使用
        template : "<h1>我是零零二!</h1>"
    };
});*/

/*setTimeout(function(){
	var demo01=$("#custom-tag-demo-01");
	demo01.after("<custom-tag-demo-02></custom-tag-demo-02>");
	//demo01.remove();
	console.log("custom-tag-demo-01 is removed!!");
}, 5000);
*/
/*mainContainerApp.config(function ($routeProvider) {
    $routeProvider
		.when("/menu", {
			templateUrl:function(){
				var args=arguments[0];
				console.log(typeof arguments[0])
				console.log(JSON.stringify(args))
			}
				//templateUrl: 'embedded.home.html',
				//controller: 'HomeController'
		})
		.otherwise({
	    	redirectTo: '/404'
	    })
});
*/
/**
 * 初始化菜单，绑定二级菜单的点击事件
 */
function initMenu(){
	var menus=$("#left-menu-id>li>ul>li>a,#left-menu-id>li>a[menu='true']");
	menus.each(function(){
		var $this=$(this);
		var href=$.trim(this.href);
		if(href){
			$this.click(function(){
				if(event){
					event.cancelBubble=true;//取消冒泡
					event.preventDefault();//取消默认行为
				}
				var $this=$(this);
				var $contentHeader=$("#content-header-id>h1")
				var $breadcrumb=$("#content-header-id>ol");
				var parentTitle=$.trim($this.parent().parent().prev().text());
				var ownTitle=$.trim($this.text());
				var breadcrumbHtml = "";
				var menuFlag=$this.attr("menu");
				if(!menuFlag){
					breadcrumbHtml += "<li>"+parentTitle+"</li>";
				}
				breadcrumbHtml += "<li ";
				if(!menuFlag){
					breadcrumbHtml += "class='active'";
				}
				breadcrumbHtml += ">"+ownTitle+"</li>";
				$breadcrumb.html(breadcrumbHtml);
				$contentHeader.html(ownTitle);
				//当前菜单样式激活状态
				$this.parent().addClass("active");
				//所有其他菜单未激活状态
				menus.each(function(){
					if($(this)[0].href!=$this[0].href){
						$(this).parent().removeClass("active");
					}
				});
				//加载主内容
				$.ajax({
					url:href,
					type:"GET",
					dataType:"html",
					context:$("#main-content-id"),
					success:function(data){
						$(this).html("").append(data);
					},
					error:function(){
						//渲染错误页面
						$(this).html("访问页面出错啦");
					}
				})
			});
		}
	});
}

$(function(){
	initMenu();
});





















