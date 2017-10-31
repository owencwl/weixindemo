/**
 * Created by owen on 2017/4/9.
 */
$(document).ready(function () {


    $.ajax({
        url: "../shopkeeper/showshop",
        type: "get",
        success: function (data) {

            console.log(data);

            showshop(data);

        },
        errors: function (msg) {
            alert(msg);
            console.log("error!!!  error!!!  error!!!");
        }
    });


});

function showshop(data) {


    $("#shopname_id").text(data.shopname);
    $("#shoptel_id").text(data.shoptel);
    $("#shopemail_id").text(data.shopemail);
    $("#shopaddress_id").text(data.shopaddress);
    $("#shopdescript_id").text(data.shopdescript);
    $("#shopnotice_id").text(data.shopnotice);
    $("#shoplogo_id").attr('src',"..\\"+data.shopimagename);


}
