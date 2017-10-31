/**
 * Created by owen on 2017/3/6.
 */


/**
 * 点击提交按钮后 从前台获取数据 发送到服务端
 */

$('#addshopbtn').click(function () {

    var tel = $('#shoptel').val();
    var email=$('#shopemail').val();
    var address=$('#shopaddress').val();
    var descript = $('#shopdetail').val();

    var notice = $('#shopnotice').val();

    $.ajaxFileUpload({
        url: '../shopkeeper/updateshop',
        fileElementId: 'file',
        data: {
            shoptel: tel,
            shopemail:email,
            shopaddress:address,
            shopdescript: descript,
            shopnotice:notice

        },
        dataType: 'txt',
        secureuri: false,
        success: function (data) {
            if (data == "yes") {
                alert("更新店铺成功！！！");
            }
        },
        error: function (data, status, e) {
            alert("更新店铺失败！！！");
        }

    });

});

$('#img-change').click(function () {

    $("#file").click();
});

function filechange(event) {

    var files = event.target.files, file2;

    if (files && files.length > 0) {
        // 获取目前上传的文件
        file2 = files[0];// 文件大小校验的动作
        if (file2.size > 1024 * 1024 * 2) {
            alert('图片大小不能超过 2MB!');
            return false;
        }
        // 获取 window 的 URL 工具
        var URL = window.URL || window.webkitURL;
        // 通过 file 生成目标 url
        var imgURL = URL.createObjectURL(file2);
        //用attr将img的src属性改成获得的url
        $("#img-change").attr("src", imgURL);
        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
        // URL.revokeObjectURL(imgURL);


    }


};