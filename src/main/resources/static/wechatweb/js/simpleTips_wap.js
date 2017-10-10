/**
 * Created by ·YinLi· on 2017/08/25.
 */
$(".header").css({"display":"none"});
$(".empty").css({"height":"40px"});
var websiteUrl="/smallbluewhale";//接口主路径，失物发布与宿舍报修表单路径一致，变动请修改

function openTips(showText)
{
    $(".tipsMask").remove();
    var str = "<div class='tipsMask'><div class='tips_content'><div class='empty_pop'><p class='tipsMaskText'></p>"+
        "<div class='ButtonTwo'>"+        
        "<input type='text' class='tipsYes'  value='确&nbsp;&nbsp;定' onfocus='this.blur()'/>"+
        "</div></div></div></div>";
    $("body").append(str);
    $(".tipsMaskText").html("<span>" + showText + "</span>");
    $(".tipsMask").css("display","block").delay(2500).hide(3000);
    $(".tipsYes").click(function(){
        $(".tipsMask").hide();        
    })
}

function login(showText)
{
    $("#tipsMask2").remove();
    var str = "<div class='tipsMask' id='tipsMask2'><div class='tips_content'><div class='empty_pop'><p class='tipsMaskText' id='tipsMaskText2'></p>"+
    "<div class='ButtonTwo'>"+
    "<input type='text' id='studentNo' class='studentNo' value='' placeholder='输入学号立即登入' /><br><br>"+
    "<input type='text' class='tipsYes' id='login' value='确&nbsp;&nbsp;定' onfocus='this.blur()'/>"+
        "</div></div></div></div>";
    $("body").append(str);
    $("#tipsMaskText2").html("<span>" + showText + "</span>");
    $("#tipsMask2").css("display","block");
    $("#login").click(function(){
        var studentNo1=document.getElementById("studentNo").value;
        window.localStorage.studentNo=studentNo1;
        starFun();
        $("#tipsMask2").hide();
    })
}

function replaceString(pic){
    pic=pic.replace(/\[/g,"");
    pic=pic.replace(/\]/g,"");
    pic=pic.replace(/\"/g,"");
    pic= pic.split(',');

    return pic;
}

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

document.writeln("<link href='font-awesome/css/font-awesome.min.css' rel='stylesheet'>");
document.writeln("<div class='footer'>");
document.writeln("    <a href='activity.html'>");
document.writeln("       <i class='fa fa-tags fa-2x'></i>");
document.writeln("       <span class='tableTitle'>活动</span> ");
document.writeln("    </a>");
document.writeln("    <a href='style.html'>");
document.writeln("       <i class='fa fa-female fa-2x'></i>");
document.writeln("       <span class='tableTitle'>风采</span> ");
document.writeln("    </a>");
document.writeln("    <a href='dormRepair.html'>");
document.writeln("       <i class='fa fa-plug fa-2x'></i>");
document.writeln("       <span class='tableTitle'>报修</span> ");
document.writeln("    </a>");
document.writeln("    <a href='lostAdd.html'>");
document.writeln("       <i class='fa fa-leaf fa-2x'></i>");
document.writeln("       <span class='tableTitle'>失物</span> ");
document.writeln("    </a>");
document.writeln("    <a href='myinfor.html'>");
document.writeln("       <i class='fa fa-user-circle fa-2x'></i>");
document.writeln("       <span class='tableTitle'>我的</span> ");
document.writeln("    </a>");
document.writeln("</div>");
