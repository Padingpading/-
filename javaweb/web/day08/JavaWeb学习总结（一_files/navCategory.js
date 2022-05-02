//生成目录索引列表
$(document).ready(
function addCategory() {
	if($("#navCategory").length>0) return;

  var blog = $("#cnblogs_post_body");
	if( blog.length > 0 ){
		var title_h2 = $("#cnblogs_post_body h2");
		if( title_h2.length > 1 ){
			var category = "<a name='labelTop'/><div id='navCategory'><b>本文目录</b><ul>";
			title_h2.each(function(n){
				$(this).before("<div style='text-align: right;color:#399AB2'><a href='#labelTop'>回到顶部</a><a name='label" + n + "'></a></div>");
				category += "<li><a href='#label" + n + "'>" + $(this).text() + "</a></li>";
			});
			category += "</ul></div>";
			blog.prepend(category);
		};
	}
	followme();
	
	$("#ad_text_under_commentbox").remove();
	$("#site_nav_under").remove();
	$("#ad_under_post_holder").remove();
});


function followme(){
	if( $("#div_digg").length < 1 ){
		setTimeout(followme, 1000); 
		return;
	}

	$("<div style='padding-bottom: 5px'></div>")
		.append($("<span class='icon_favorite' style='padding-top: 2px; padding-bottom: 2px'></span>"))
		.append($("#green_channel_follow").clone(true).text("关注 JanaChen")
				.removeAttr("id").css({ "font-weight": "bold", "padding-left": "5px", "color":"#399AB2","border-bottom":"0 none" }))
		.prependTo("#div_digg");
}