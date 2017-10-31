/**
 * Created by owen on 2017/3/31.
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

function addTr(data) {

    console.log(data.toString());

    for (var i = 0; (data.length > 0) && i < data.length; i++) {


        var line = `

            <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                <div class="am-u-sm-4 am-list-thumb">
                    <a href="../customer/shop.html?shopid=${data[i].shopid}" class="">
                        <img style="width: 100px;" src="../${data[i].shopimagename}" alt="点我"/>
                    </a>
                </div>

                <div class=" am-u-sm-8 am-list-main">
                    <h3 class="am-list-item-hd"><a href="../customer/shop.html?shopid=${data[i].shopid}" class="">
                    ${data[i].shopname}</a></h3>

                    <div class="am-list-item-text">${data[i].shopaddress}</div>
                    <div class="am-list-item-text">起送价：10元</div>

                </div>
            </li>
`;

        $('#allshop_id').append(line);
    }
};