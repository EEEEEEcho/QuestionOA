$(function(){$(".dd").nestable();$(".dd").on("change",function(){var a=$(this);var b=window.JSON.stringify($(a).nestable("serialize"));a.parents("div.body").find("textarea").val(b)});$(".dd4").nestable();$(".dd4").on("change",function(){var a=$(this);var b=window.JSON.stringify($(a).nestable("serialize"))})});