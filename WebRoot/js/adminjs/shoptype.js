/**
 * Created by owen on 2017/3/6.
 */
/**
 * 直接获得数据库数据
 */
$(document).ready(function () {


    $.ajax({
        url: "../admin/showshoptype",
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

    for (var i = 0; data.length > 0&&i<data.length ; i++) {

        var tr = " <tr><td> " + "<input  type=" + '"checkbox"' + "></td><td>" + data[i].shoptypeid + "</td><td id='shoptypename'>" + data[i].shoptypename + "</td></tr>"

        $('#shoptypeTbody').append(tr);
    }
};
/**
 * 监听回车
 */
$('#typename').keyup(function (e) {

    if (e.keyCode == 13) {

        submit();

    }
});

/**
 * 按钮监听
 */
$(function () {

    $("#deletetype").click(function () {

        var num = $(':checkbox:checked').length;

        if(num==0){

            $('#bodytext').html("<span style='color: red;'>请选择类型进行删除！！！</span>");
            $('#confirmdel').attr('disabled',"true");
        }else{

            $('#bodytext').html("确定删除" + num + "个门店类型？");
        }


    });

    $('#submitType').click(function () {
        submit();
    });
    /*
     删除按钮监听
     */
    $('#confirmdel').click(function () {

        var num = $(':checkbox:checked').length;

        //console.log($(':checkbox:checked'));


        var array = new Array;

        $(':checkbox:checked').each(function () {

            // var strname = $(this).getElementById("shoptypename").val();
            // array.push(strname);

            var n = $(this).parents("tr").index();

            var name = $(this).parents("tr").find('#shoptypename').html();

            // console.log(name);

            array.push(name);

            $('tbody').find("tr:eq(" + n + ")").remove();


        });

        $(function () {
            var typejson = JSON.stringify(array);

            console.log(typejson);
            $.ajax({
                url: "../admin/delshoptype",
                type: "post",
                dataType: 'json',
                data: typejson,
                contentType:"application/json",
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

});
/**
 * 获取文本框值 准备提交数据
 */
function submit() {
    var typename = $('#typename').val();
    if (typename.length == "") {
        alert("账户名和密码不能为空！！！！NULL错误！！！")
    } else {
        addTypeRequest(typename);
        $('#mymodal').modal('hide');
        refresh();
    }
};
/**
 * 向服务器提交数据
 * @param typename
 */
function addTypeRequest(typename) {


    $.ajax({
        url: "../admin/addshoptype",
        type: "post",
        dataType: 'json',
        data: {
            shoptypename: typename,
        },
        success: function (msg) {

        },
        errors: function (msg) {
            alert(msg);
            console.log("error!!!  error!!!  error!!!");
        }
    });

};
/**
 * 刷新当前页面
 */
function refresh() {
    window.location.reload();//刷新当前页面.

    //或者下方刷新方法
    //parent.location.reload()刷新父亲对象（用于框架）--需在iframe框架内使用
    // opener.location.reload()刷新父窗口对象（用于单开窗口
    //top.location.reload()刷新最顶端对象（用于多开窗口）
};