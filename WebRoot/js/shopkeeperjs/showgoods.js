/**
 * Created by owen on 2017/4/10.
 */
$(document).ready(function () {


    $.ajax({
        url: "../shopkeeper/showshopgoods",
        type: "get",
        dataType: 'json',
        success: function (data) {

            console.log(data);

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
              <td style="display:none;vertical-align:middle" id="goodsid" >${data[i].goodsid}</td>
             <td style="display:table-cell;vertical-align:middle" id="goodsimagenameid"><img  src="../${data[i].goodsimagename}" style="width: 80px;"></td>
             <td style="display:table-cell;vertical-align:middle" id="goodsnameid">${data[i].goodsname}</td>
             <td style="display:table-cell;vertical-align:middle" id="goodstypeid">${data[i].goodstype}</td>
             <td style="display:table-cell;vertical-align:middle" id="goodspriceid">${data[i].goodsprice}元</td>
             <td style="display:table-cell;vertical-align:middle" id="goodscountid">${data[i].goodscount}份</td>
             <td style="display:table-cell;vertical-align:middle" id="goodsdescriptid">${data[i].goodsdescript}</td>
             <td style="display:table-cell;vertical-align:middle"><button onclick="showmodal(this);" class="btn btn-primary btn-sm">修改</button></td>
             </tr>
        `;


        $('#shoptbody').append(tr);
    }
};


$('#addgoods').click(function () {

    //清空菜品类型下拉列表
    $('#goodstypeselect_modal').empty();

//为菜品类型下拉列表准备数据
    requesttype();




});

function requesttype() {

    $.ajax({
        url: "../shopkeeper/showgoodstype",
        type: "get",
        dataType: 'json',
        success: function (data) {

            for (var i = 0; data.length > 0 && i < data.length; i++) {

                $('#goodstypeselect_modal').append("<option >" + data[i].goodstypename + "</option>");
            }


        },
        errors: function (msg) {
            alert(msg);
            console.log("showgoodstype error!!!  error!!!  error!!!");
        }
    });



}

$('#img_change_modal').click(function () {

    $("#file_modal").click();
});

$('#confirm_modal').click(function () {


    var goodsname = $('#goodsname_modal').val();
    var goodstypeselect = $('#goodstypeselect_modal').val();

    var goodsprice = $('#goodsprice_modal').val();
    var goodscount = $('#goodscount_modal').val();
    var goodsdescript = $('#goodsdescript_modal').val();



    $.ajaxFileUpload({
        url: '../shopkeeper/addgoods',
        fileElementId: 'file_modal',
        data: {
            goodsname: goodsname,
            goodsdescript: goodsdescript,
            goodsprice: goodsprice,
            goodscount:goodscount,
            goodstype:goodstypeselect,

        },
        dataType: 'txt',
        secureuri: false,
        success: function (data) {
            if (data == "yes") {
                alert("添加菜品成功！！！");

                $('#addmodal').modal('hide');
                window.location.reload();//刷新当前页面.


            }
        },
        error: function (data, status, e) {
            alert("添加菜品失败！！！");
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
$("#deletegoods").click(function () {

    var num = $(':checkbox:checked').length;

    if (num == 0) {

        $('#bodytext').html("<span style='color: red;'>请选择店铺进行删除！！！</span>");
        $('#confirmdel').attr('disabled', "true");
    } else {

        $('#bodytext').html("确定删除" + num + "个菜品？");
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

        var id = $(this).parents("tr").find('#goodsid').html();

        var jsonTemp = {"goodsid": id};
        jsonarray.push(jsonTemp);
        $('tbody').find("tr:eq(" + n + ")").remove();


    });

    $(function () {
        var json_id = JSON.stringify(jsonarray);

       // console.log(json_id);

        $.ajax({
            url: "../shopkeeper/delgoods",
            type: "post",
            dataType: 'json',
            data: json_id,
            contentType: "application/json",
            success: function (msg) {
                alert("删除成功！！！");

            },
            errors: function (msg) {
                alert(msg);
                console.log("error!!!  error!!!  error!!!");
            }
        });

    });

    //隐藏模态框
    $('#delgoods_model').modal('hide');

    // alert(array);


});



function showmodal(obj) {


    //清空下拉列表
    $('#goodstypeselect_modal').empty();

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