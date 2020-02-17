// 导航栏的选择器
// $navBar = $('#metismenu');
/**
 * 获取站点信息
 */
// Http({
//     url: '/' + SERVER_FLAG + '/f/site/listData',
//     isDefaultApiRequest: false,
//     success: function (data, textStatus, jqXHR) {
//         // console.log(data.list);
//         $.each(data.list, function (index, value) {
//             // console.log(data.list[index].siteCode);
//             let siteCode = data.list[index].siteCode;
//             if (siteCode === 'main') {
//                 // czfyt站点
//                 let logo = data.list[index].logo;
//                 let domain = data.list[index].domain;
//                 let copyright = data.list[index].copyright;
//                 let title = data.list[index].title;
//                 $('footer').html(copyright);
//                 $('#siteLogo').find('img').attr('src', window.location.origin + logo);
//                 console.log(domain);
//                 console.log(copyright);
//                 console.log(title);
//             }
//         });
//     }
// }).get();


/**
 * 获取详情页面的公司联系方式
 */
// Http({
//     url: '/' + SERVER_FLAG + '/f/company/companyInfo/listData',
//     isDefaultApiRequest: false,
//     success: function (data, textStatus, jqXHR) {
//         console.log('%%%%%%%%%%%%%%');
//         console.log(data.list[0]);
//         console.log('**************');
//         $('#contactUs').find('span').eq(0).html(data.list[0].companyName);
//         $('#companySite').find('span').eq(0).html(data.list[0].companySite);
//         $('#telPhone').find('span').eq(0).html(data.list[0].telPhone);
//         $('#mobilePhone').find('span').eq(0).html(data.list[0].mobilePhone);
//         $('#email').find('span').eq(0).html(data.list[0].email);
//         $('#website').find('span').eq(0).html(data.list[0].website);
//         // 设置右上角的客服热线的电话
//          $('#hotline').find('li').eq(1).find('span').html(data.list[0].telPhone);
//     }
// }).get();
