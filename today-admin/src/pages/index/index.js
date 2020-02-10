import '../../assets/Common';
import jqGrid from 'free-jqgrid';

import '../../assets/js/app';
import '../../assets/js/demo_pages/dashboard';
import leftNavArt from '../../assets/templates/left.art';
// import Cookies from 'js-cookie';
// import moment from 'moment';

import './index.scss';
import './index.html';

/* eslint-disable */
let html = '';
const url = '../../assets/json/init.json';
let clipCloudUsageStatistic = '../../assets/json/FeHelper-20200207211426';
const Index = {
    init () {
        this.initData();
        // console.log('----222---');
    },
    // fetch init数据
    initData () {
        // let me = this,
        // let requestPara = '',
        Utils.doAjax(url, '', function (res) {
            let dataTemp = res.data;
            const questions = dataTemp.question;
            html = leftNavArt({ model: questions });
            //初始化left
            $('#leftNav').html(html);
        });

        console.log('----111---');
        console.log(Utils.getDay(0));
        console.log('----222---');

        // Utils.doAjax(clipCloudUsageStatistic, '', function (res) {
        //     let dataTemp = res.result;
        //     // const questions = dataTemp.question;
        //
        // });

        // jQuery("#list2").jqGrid({
        //     url: clipCloudUsageStatistic,
        //     datatype: "json",
        //     colNames: ['日期', '上传', '点播', '现场直播', '点播', '现场直播', '备注'],
        //     colModel: [
        //         {name: 'invdate', index: 'invdate', width: 80, align: 'center', sorttype: 'date',
        //             formatter: 'date', formatoptions: {newformat: 'd-M-Y'}, datefmt: 'd-M-Y'},
        //         {name: 'name', index: 'name', width: 70 },
        //         {name: 'amount', index: 'amount', width: 75, formatter: 'number', sorttype: 'number', align: 'right'},
        //         {name: 'tax', index: 'tax', width: 75, formatter: 'number', sorttype: 'number', align: 'right'},
        //         {name: 'closed', index: 'closed', width: 75, align: 'center', formatter: 'checkbox',
        //             edittype: 'checkbox', editoptions: {value: 'Yes:No', defaultValue: 'Yes'}},
        //         {name: 'ship_via', index: 'ship_via', width: 100, align: 'center', formatter: 'select',
        //             edittype: 'select', editoptions: {value: 'FE:FedEx;TN:TNT;IN:Intim', defaultValue: 'Intime'}},
        //         {name: 'note', index: 'note', width: 70, sortable: false}
        //     ],
        //     rowNum:10,
        //     width:700,
        //     rowList:[10,20,30],
        //     pager: '#pager2',
        //     sortname: 'invdate',
        //     viewrecords: true,
        //     sortorder: "desc",
        //     jsonReader: {
        //         repeatitems : false
        //     },
        //     caption: "Group Header",
        //     height: '100%'
        // });
        // jQuery("#list2").jqGrid('setGroupHeaders', {
        //     useColSpanStyle: true,
        //     groupHeaders:[
        //         {startColumnName: 'amount', numberOfColumns: 2, titleText: '生产'},
        //         {startColumnName: 'closed', numberOfColumns: 2, titleText: '分发'}
        //     ]
        // });

        let today = Utils.getDay(0);
        $("#list2").jqGrid({
            url: '/' + SERVER_FLAG + '/api/statistics/clipcloud/usage',
            datatype: "json",
            // jsonReader: {
            //     root: function(obj) { alert(JSON.stringify(obj[Utils.getDay(0)]));
            //     // if(obj){
            //     // }
            //          return obj[Utils.getDay(0)];
            //     },
            //     repeatitems: false
            // },
            colModel: [
                { name: "currentDate", label: "日期", width: 80 },
                { name: "uploadNum", label: "上传", width: 75, align: "center"},
                { name: "videoProduce", label: "点播", width: 65 },
                { name: "liveProduce", label: "现场直播", width: 80 },
                { name: "videoDist", label: "点播", width: 59},
                { name: "liveDist", label: "现场直播", width: 87, align: "center"},
                { name: "remarks", label: "备注", width: 100 },
            ],
            // data: [
            //     { id: "10",  currentDate: "2020-02-10", uploadNum: "test",   amount: "" },
            //     { id: "20",  currentDate: "2015-09-01", uploadNum: "test2",  amount: "300", tax: "20", closed: false, ship_via: "FE", remarks: "320" },
            //     { id: "30",  currentDate: "2015-09-01", uploadNum: "test3",  amount: "400", tax: "30", closed: false, ship_via: "FE", remarks: "430" },
            //     { id: "40",  currentDate: "2015-10-04", uploadNum: "test4",  amount: "200", tax: "10", closed: true,  ship_via: "TN", remarks: "210" },
            //     { id: "50",  currentDate: "2015-10-31", uploadNum: "test5",  amount: "300", tax: "20", closed: false, ship_via: "FE", remarks: "320" },
            // ],
            guiStyle: "bootstrap4",
            iconSet: "fontAwesome",
            idPrefix: "gb1_",
            rownumbers: true,
            sortname: "invdate",
            sortorder: "desc",
            caption: "The grid, which uses predefined formatters and templates"
        });

        jQuery("#list2").jqGrid('setGroupHeaders', {
            useColSpanStyle: true,
            groupHeaders:[
                {startColumnName: 'videoProduce', numberOfColumns: 2, titleText: '生产成功'},
                {startColumnName: 'videoDist', numberOfColumns: 2, titleText: '分发成功'}
            ]
        });
    },
};
/* eslint-disable */

/* eslint-disable */
$('#fullScreen').click(function() {
    if ($(this).data('isOpen') == 'true') {
        $(this).data('isOpen', 'false');
        if (document.exitFullscreen) {
            document.exitFullscreen()
        } else {
            if (document.msExitFullscreen) {
                document.msExitFullscreen()
            } else {
                if (document.mozCancelFullScreen) {
                    document.mozCancelFullScreen()
                } else {
                    if (document.webkitCancelFullScreen) {
                        document.webkitCancelFullScreen()
                    }
                }
            }
        }
    } else {
        $(this).data('isOpen', 'true');
        const d = document.documentElement;
        if (d.requestFullscreen) {
            d.requestFullscreen()
        } else {
            if (d.msRequestFullscreen) {
                d.msRequestFullscreen()
            } else {
                if (d.mozRequestFullScreen) {
                    d.mozRequestFullScreen()
                } else {
                    if (d.webkitRequestFullScreen) {
                        d.webkitRequestFullScreen()
                    }
                }
            }
        }
    }
    return false
}).tooltip();
/* eslint-disable */

/* eslint-disable */
// 鼠标移动到导航菜单上立即展开二级菜单的效果
// $(".dropdown").mouseover(function(){
//     $(this).addClass("show").find(".dropdown-menu").addClass("show");
// });
// $(".dropdown").mouseout(function(){
//     $(this).removeClass("show").parent(".dropdown").removeClass("show");
// });
/* eslint-disable */

// let cookie = 'accessToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwd2Rfc3RhdHVzIjoxLCJ1c2VyX2lkIjoxMDAzMzYwMSwiYWRkaXRpb25hbF9pbmZvIjp7fSwidXNlcl9uYW1lIjoieWZ6eDAwM2xpdXBpbmciLCJ1c2VyX3NvdXJjZSI6IjEiLCJleHAiOjE1ODAzODEzNzksImp0aSI6IjQ3NDc2ZmMwLTZlMTYtNGU5ZS04YjQ4LWUyMDhiNTU1NDE0MSIsImNsaWVudF9pZCI6ImlubmVyQ2xpZW50In0.TfYervbj-zsmNhPwKoA0EpYAan04mKVgl3Av_zrkmlfAK4B0LXRmMJ6Ar0MOuQOG_-hC95QwFKREZcyb_xE5wmowTMzclTlrQ2b_Uh87PqhYzTZaePvSoDeuPYbVCF8CIor8hfTugzYkrp60-S5WmW-O_hYM2JvETEVIv9B0DTE; refreshToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwd2Rfc3RhdHVzIjoxLCJ1c2VyX2lkIjoxMDAzMzYwMSwiYWRkaXRpb25hbF9pbmZvIjp7fSwidXNlcl9uYW1lIjoieWZ6eDAwM2xpdXBpbmciLCJ1c2VyX3NvdXJjZSI6IjEiLCJhdGkiOiI0NzQ3NmZjMC02ZTE2LTRlOWUtOGI0OC1lMjA4YjU1NTQxNDEiLCJleHAiOjE1ODAzODM3NzksImp0aSI6IjcxMzdlNmZiLTY5MTItNDc2OC1hOTlhLTY4YmVjYjdkMGIzOCIsImNsaWVudF9pZCI6ImlubmVyQ2xpZW50In0.hF9ltNTzuJwYw8g7KwXp6k-an2-U6MQNraz00YFC8gkElMfnBWmKscSkyLlelUIUXd8l9__P9Lq4FSkhkHBUPhFjMbk1lrJKrcyd0zcI-riz_n0xGzjRL5bv5nYjZADuWA_FYOIsb9CaPfTmW14aXmpZV684ICVgNCpVovGAQYk; interceptionTime=40; pictureFrameRate=%7B%22frameRate%22%3A%22430*270%22%2C%22list%22%3A2%7D';
// Cookies.remove('Idea-2d512e8');
// Cookies.remove('Idea-2d512e8', { path: '' });
// Cookies.set('accessToken','eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwd2Rfc3RhdHVzIjpudWxsLCJ1c2VyX2lkIjoxMDAzMzYwMSwiYWRkaXRpb25hbF9pbmZvIjp7fSwidXNlcl9uYW1lIjoieWZ6eDAwM2xpdXBpbmciLCJ1c2VyX3NvdXJjZSI6IjIiLCJleHAiOjE1ODEwMDcxNTAsImp0aSI6IjMxOWQ1ODQ1LWNkMmMtNDNjMC1hOTMxLTA5M2ZmN2YzNjI1MiIsImNsaWVudF9pZCI6ImlubmVyQ2xpZW50In0.Sz39OwNIIeQsUotk6wuQCtD1jlWPYFeAARrsRtTUBo4gd41ou0tY7EXwZm8JfgddgLW3u3euUdZqL4tK-8RamxBEg0ajlQvyD1NhmsEcgWLld01cWzJ8ExkD-aU_plzTEmP_jLzWwkMmcJ6IvsmV6fc3A6bKqRkGPFVQelDhYJE; refreshToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwd2Rfc3RhdHVzIjpudWxsLCJ1c2VyX2lkIjoxMDAzMzYwMSwiYWRkaXRpb25hbF9pbmZvIjp7fSwidXNlcl9uYW1lIjoieWZ6eDAwM2xpdXBpbmciLCJ1c2VyX3NvdXJjZSI6IjIiLCJhdGkiOiIzMTlkNTg0NS1jZDJjLTQzYzAtYTkzMS0wOTNmZjdmMzYyNTIiLCJleHAiOjE1ODEwMDk1NTAsImp0aSI6ImFlOTI3MThjLWE4MTAtNDMzNy04NjU5LWMzMTNmOWJhYzNhZSIsImNsaWVudF9pZCI6ImlubmVyQ2xpZW50In0.IDTlCAEFxO9QVVu25c4eGkt54f7od4GpUagjIhYXe3NX50ReZOFFzGyeBhxKQbqve-MTK2n8Nqk1Fd-UmEGOrN4nwAvRtLzO0IN3oDsL9TtlnYCDoX-WlpiUNVYq1k0c5xfXkEkSDcQDR36bG17jwM48PfEQjCw6cU90voLacgk');
// Cookies.set('','checked_token=STnid0000011581005944062zCJzMH0qlQov4KuFhe68XaiofFcx4GI0; userInfo={%22userId%22:%22105007292%22%2C%22userToken%22:%224CB114889E98A766B3E8%22%2C%22clientId%22:%2279acd784-cbbb-4cae-8778-8723e001164b%22%2C%22carrierCode%22:%22CM%22%2C%22sname%22:%22158****4759%22%2C%22mobile%22:%2215851974759%22%2C%22picture%22:%22http://img.cmvideo.cn:8080/publish/voms2/uic_service/picture/userImage/543/626/5181.jpg%22%2C%22sex%22:%22%22%2C%22ssotoken%22:%22STnid0000011581005944062zCJzMH0qlQov4KuFhe68XaiofFcx4GI0%22%2C%22clientProvinceCode%22:%22250%22%2C%22clientCityId%22:%220519%22%2C%22sign%22:%22CFFD097928203B88E4600947D6B1393D%22%2C%22userInfo%22:%22{%5C%22userId%5C%22:%5C%22105007292%5C%22%2C%5C%22userNum%5C%22:%5C%228615851974759%5C%22%2C%5C%22mobile%5C%22:%5C%2215851974759%5C%22%2C%5C%22areaId%5C%22:%5C%22250%5C%22%2C%5C%22cityId%5C%22:%5C%220519%5C%22%2C%5C%22carrierCode%5C%22:%5C%22CM%5C%22%2C%5C%22passId%5C%22:%5C%223674136819957%5C%22%2C%5C%22userToken%5C%22:%5C%224CB114889E98A766B3E8%5C%22%2C%5C%22expiredOn%5C%22:%5C%221583597944787%5C%22}%22}; UserInfo=105007292|4CB114889E98A766B3E8; WT_FPC=id=254f5f9bca8d3cbbfe41581005757816:lv=1581005946752:ss=1581005757816; accessToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwd2Rfc3RhdHVzIjowLCJ1c2VyX2lkIjoxMDAzMzYwMSwiYWRkaXRpb25hbF9pbmZvIjp7fSwidXNlcl9uYW1lIjoieWZ6eDAwM2xpdXBpbmciLCJ1c2VyX3NvdXJjZSI6IjEiLCJleHAiOjE1ODEwODAwNTEsImp0aSI6ImM0M2M4ZjA5LThmNTYtNDczZi04ODI3LTJiNTkzMTkzYmQ0YiIsImNsaWVudF9pZCI6ImlubmVyQ2xpZW50In0.HQWtQ5yid4xxUqY7_2x9f9v_afBDsMzN4wYouVsV7DXf5rGBF2-hNbiJXG6Lx3yPDybgTCKRE4L8hup-n2Zr2im5Wdgil9W_ExU8pLOH22egWDnpZ0BaaKuEgoEAflD20xi1mzkRpCibojrb4mI9Q7A8owV0zi3Cdo607Z7FR94; refreshToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwd2Rfc3RhdHVzIjowLCJ1c2VyX2lkIjoxMDAzMzYwMSwiYWRkaXRpb25hbF9pbmZvIjp7fSwidXNlcl9uYW1lIjoieWZ6eDAwM2xpdXBpbmciLCJ1c2VyX3NvdXJjZSI6IjEiLCJhdGkiOiJjNDNjOGYwOS04ZjU2LTQ3M2YtODgyNy0yYjU5MzE5M2JkNGIiLCJleHAiOjE1ODEwODI0NTEsImp0aSI6IjI1Zjg0NzI3LTAzNmYtNDM0ZS1hNzY0LTI1OWY1NmRiNmQ3ZSIsImNsaWVudF9pZCI6ImlubmVyQ2xpZW50In0.Dd4dpiZ-WQuhc8VSOYTdI6boF0LqphrZ4zBnlpgs5ZfG9MiDegCtZh9lyAN673ba4XvNEEDosaSWeJwunCdKclCk46OEGpzHlFyhCqRgJGHdap-gb6uvVHrw_jULhMR-fev6DNNDbyNnVh-IgfkmkZjA711LjiYB4P_QUvicMgA');

/**
 * 获取统计信息
 */
// Http({
//     url: '/' + SERVER_FLAG + '/success/rate',
//     isDefaultApiRequest: false,
//     headers: { 'Content-Type': 'application/json;charset=UTF-8' },
//     success: function (data, textStatus, jqXHR) {
//         console.log(data);
//     }
// }).get();



$(function () {
    Index.init();
});
