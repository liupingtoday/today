// 初始化内容
let categoryId = window.Utils.getQueryString("id");
console.log("--+++categoryId:" + categoryId);


// 动态从后台获取首页的slides
// Http({
//     url: '/' + SERVER_FLAG + '/f/company/companyInfo/listData',
//     data: {},
//     isDefaultApiRequest: false,
//     success: function (data, textStatus, jqXHR) {
//         $.each(data.list, function (index, value) {
//             // console.log('&&&&&&&&&&&&&^^^^^^1^^^^^^^^^^1');
//             // console.log(value.path);
//             // console.log('&&&&&&&&&&&&&^^^^^^1^^^^^^^^^^2');
//             let slidePathList = value.path.split('|');
//             for (let i in slidePathList) {
//                 if (slidePathList.hasOwnProperty(i)) {
//
//                     let imgSlideSrc = Utils.getRootPath() + SERVER_FLAG + slidePathList[i];
//                     console.log('&&&&&&&&&&&&&^^^^^^1^^^^^^^^^^1');
//                     console.log(imgSlideSrc);
//                     console.log('&&&&&&&&&&&&&^^^^^^1^^^^^^^^^^2');
//                     $('#index-swiper').find('.swiper-wrapper').append('<div class="swiper-slide"><img src="' + imgSlideSrc + '"/></div>');
//
//                 }
//             }
//         });
//     }
// }).get();

let categoryCode = 'A1005';
let currPageData = '1';
let pageSizeData = '12';
let requestData = { categoryCode: categoryCode, pageNo: currPageData, pageSize: pageSizeData };
/**
 * 获取首页的新闻中心的数据
 */
Http({
    url: '/' + SERVER_FLAG + '/front/about/queryArticleByCategoryCode',
    data: requestData,
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        console.log('111---=+++');
        // $.each(data.result, function (index, value) {
        //     console.log(value.id);
        //     // 控制首页的新闻中心的数量在10条内；
        //     // if (index < 10) {
        //     //     $('#index-news').find('ol').append('<li class="list top"><span class="time">' + value.updateDate + '</span><a href="news.html?id=' + value.id + '" title="" target="_self">' + value.title + '</a></li>');
        //     // }
        // });
    }
}).get();

