/**
 * Created by owen on 2017/3/11.
 */
$(document).ready(function () {


    $.ajax({
        url: "../admin/showshop",
        type: "get",
        dataType: 'json',
        success: function (data) {

            addTr(data);

        },
        errors: function (msg) {
            alert(msg);
            console.log("error!!!  error!!!  error!!!");
        }
    });


});

/**
 * 打印表格一行
 * @param data
 */
function addTr(data) {

    console.log(data.toString());

    for (var i = 0; (data.length > 0) && i < data.length; i++) {
        var tr = `
             <tr>
             <td style="display:table-cell;vertical-align:middle"><input type="checkbox"></td>
              <td style="display:none;vertical-align:middle" id="shopid">${data[i].shopid}</td>
             <td style="display:table-cell;vertical-align:middle" id="imgid"><img  src="../${data[i].shopimagename}" style="width: 80px;"></td>
             <td style="display:table-cell;vertical-align:middle" id="shopnameid">${data[i].shopname}</td>
             <td style="display:table-cell;vertical-align:middle" id="typeid">${data[i].shoptypename}</td>
             <td style="display:table-cell;vertical-align:middle">陈总</td>
             <td style="display:table-cell;vertical-align:middle" id="telid">${data[i].shoptel}</td>
             <td style="display:table-cell;vertical-align:middle" id="shopemailid">${data[i].shopemail}</td>
             <td style="display:table-cell;vertical-align:middle" id="shopaddressid">${data[i].shopaddress}</td>
             <td style="display:table-cell;vertical-align:middle"><button onclick="showmodal(this);" class="btn btn-primary btn-sm">修改</button></td>
             </tr>
        `;

        $('#shoptbody').append(tr);
    }
};


$("#deleteshop").click(function () {

    var num = $(':checkbox:checked').length;

    if (num == 0) {

        $('#bodytext').html("<span style='color: red;'>请选择店铺进行删除！！！</span>");
        $('#confirmdel').attr('disabled', "true");
    } else {

        $('#bodytext').html("确定删除" + num + "个门店？");
    }

});

/*
 删除按钮监听
 */
$('#confirmdel').click(function () {

    var num = $(':checkbox:checked').length;

    //console.log($(':checkbox:checked'));


    var array = new Array;
    var array1 = {};


    var jsonstr = "[]";

    var jsonarray = eval('(' + jsonstr + ')');

    $(':checkbox:checked').each(function () {


        var n = $(this).parents("tr").index();

        var name = $(this).parents("tr").find('#shopnameid').html();
        var email = $(this).parents("tr").find('#shopemailid').html();
        var address = $(this).parents("tr").find('#shopaddressid').html();

        var jsonTemp = {"shopname": name, "shopemail": email, "shopaddress": address};
        jsonarray.push(jsonTemp);

        // array.push(name);
        // array.push(email);
        // array.push(address);


        // array. splice(0,array.length);
        // array.length=0;
        $('tbody').find("tr:eq(" + n + ")").remove();


    });

    $(function () {
        var typejson = JSON.stringify(jsonarray);

        console.log(typejson);

        $.ajax({
            url: "../admin/delshop",
            type: "post",
            dataType: 'json',
            data: typejson,
            contentType: "application/json",
            success: function (msg) {

            },
            errors: function (msg) {
                alert(msg);
                console.log("error!!!  error!!!  error!!!");
            }
        });

    });

    //隐藏模态框
    $('#mymodal2').modal('hide');

    // alert(array);


});

function showmodal(obj) {


    //清空下拉列表
    $('#typeselect_modal').empty();

//为下拉列表准备数据
    requesttype();

    var id = $(obj).parents("tr").find('#shopid').text();
    var imgpath = $(obj).parents("tr").find('#imgid').children('img')[0].src;
    var name = $(obj).parents("tr").find('#shopnameid').text();
    var type = $(obj).parents("tr").find('#typeid').text();
    var tel = $(obj).parents("tr").find('#telid').text();
    var email = $(obj).parents("tr").find('#shopemailid').text();
    var address = $(obj).parents("tr").find('#shopaddressid').text();

   // alert(id+"  "+imgpath + "  " + name + type + tel + email + address);

    $('#shopid_modal').html(id);
    $('#shopname_modal').val(name);

    //目前这里存在问题
    //$('#typeselect_modal').val(type);
    $("#typeselect_modal option[value='" + type + "']").attr("selected", true);
    $('#shoptel_modal').val(tel);

    $('#shopemail_modal').val(email);
    $('#shopaddress_modal').val(address);

    $('#img_change_modal').attr('src', imgpath);



    $('#mymodal3').modal();
}

/**

 获取店铺类型的数据 共下拉列表使用

 */
function requesttype() {


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

    function selectaddoption(data) {


        for (var i = 0; data.length > 0 && i < data.length; i++) {

            $('#typeselect_modal').append("<option >" + data[i].shoptypename + "</option>");
        }


    };


}

/**
 * 图片框点击事件
 */
$('#img_change_modal').click(function () {

    $('#file_modal').click();

});

$('#confirm_modal').click(function () {

   var updateid =$('#shopid_modal').html();
    var updatename = $('#shopname_modal').val();
    var updatetype = $('#typeselect_modal').val();
    var updatetel = $('#shoptel_modal').val();
    var updateemail = $('#shopemail_modal').val();
    var updateaddress = $('#shopaddress_modal').val();
    //alert(updateid+updatename+updatetype+updatetel+updateemail+updateaddress);

    $.ajaxFileUpload({
        url: '../admin/updateshop',
        fileElementId: 'file_modal',
        data: {
            shopid:updateid,
            shopname: updatename,
            typeselect: updatetype,
            shoptel: updatetel,
            shopemail: updateemail,
            shopaddress: updateaddress,

        },
        dataType: 'txt',
        secureuri: false,
        success: function (data) {
            if (data == "yes") {
                alert("修改店铺成功！！！");
            }else if(data=="no"){
                alert("修改店铺失败！！！");
            }
        },
        error: function (data, status, e) {
            alert("修改店铺失败！！！");
        }

    });


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
        $("#img_change_modal").attr("src", imgURL);
        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
        // URL.revokeObjectURL(imgURL);


    }


};

