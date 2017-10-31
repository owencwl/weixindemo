/**
 * Created by owen on 2017/3/6.
 */


$(document).ready(function () {

    /*
     获取店铺类型的数据 共下拉列表使用
     */


    $.ajax({
        url: "../admin/showshoptype",
        type: "get",
        dataType: 'json',
        success: function (data) {

            selectaddoption(data);

        },
        errors: function (msg) {
            alert(msg);
            console.log("error!!!  error!!!  error!!!");
        }
    });


});

function selectaddoption(data) {


    for (var i = 0; data.length > 0; i++) {

        $('#typeselect').append("<option >" + data[i].shoptypename + "</option>");
    }


};
/**
 * 点击提交按钮后 从前台获取数据 发送到服务端
 */

$('#addshopbtn').click(function () {

    var name = $("#shopname").val();
    var type = $('#typeselect').val();
    var tel = $('#shoptel').val();
    var mail=$('#shopmail').val();
    var address=$('#shopaddress').val();
    var detail = $('#shopdetail').val();



    $.ajaxFileUpload({
        url: '../admin/addshop',
        fileElementId: 'file',
        data: {
            shopname: name,
            typeselect: type,
            shoptel: tel,
            shopmail:mail,
            shopaddress:address,
            shopdetail: detail

        },
        dataType: 'txt',
        secureuri: false,
        success: function (data) {
            if (data == "yes") {
                alert("添加店铺成功！！！");
            }
        },
        error: function (data, status, e) {
            alert("添加店铺失败！！！");
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