import '../../assets/Common';
import Swiper from 'swiper/js/swiper.min';
import 'swiper/css/swiper.min.css';
import './index.scss';
import './index.html';

// 返回顶部按钮
Helper.backTop();

// 监听滚动事件，更改navbar背景色透明度
$(window).scroll(function () {
    let s = $(window).scrollTop();
    $('.navbar-warp').css('background-color', `rgba(255, 255, 255, ${s / 120})`);
});

new Swiper('.index-swiper', {
    autoHeight: true, // enable auto height
    slidesPerView: 1,
    spaceBetween: 30,
    observer: true, // 修改swiper自己或子元素时，自动初始化swiper
    observeParents: true, // 修改swiper的父元素时，自动初始化swiper
    centeredSlides: true,
    autoplay: {
        delay: 5000,
        disableOnInteraction: false,
    },
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },
});

new Swiper('.index-product-swiper', {
    slidesPerView: 2,
    // parallax: true,
    spaceBetween: 30,
    loop: true,
    autoplay: {
        delay: 5000,
        disableOnInteraction: false,
    },
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
});
// 动态从后台获取首页的slides
Http({
    url: '/' + SERVER_FLAG + '/f/company/companyInfo/listData',
    data: {},
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        $.each(data.list, function (index, value) {
            // console.log('&&&&&&&&&&&&&^^^^^^1^^^^^^^^^^1');
            // console.log(value.path);
            // console.log('&&&&&&&&&&&&&^^^^^^1^^^^^^^^^^2');
            let slidePathList = value.path.split('|');
            for (let i in slidePathList) {
                if (slidePathList.hasOwnProperty(i)) {

                    let imgSlideSrc = Utils.getRootPath() + SERVER_FLAG + slidePathList[i];
                    console.log('&&&&&&&&&&&&&^^^^^^1^^^^^^^^^^1');
                    console.log(imgSlideSrc);
                    console.log('&&&&&&&&&&&&&^^^^^^1^^^^^^^^^^2');
                    $('#index-swiper').find('.swiper-wrapper').append('<div class="swiper-slide"><img src="' + imgSlideSrc + '"/></div>');

                }
            }
        });
    }
}).get();
/*
*  获取友情链接的信息
* */
Http({
    url: '/' + SERVER_FLAG + '/f/links/listData',
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        $.each(data.list, function (index, value) {
            $('#fr-lk').find('ul').append('<li><a href="' + value.linkUrl + '" title="' + value.linkName + '" target="_blank">' + value.linkName + '</a></li>');
        });
    }
}).get();

let categoryCode = 'A1002';
let currPageData = '1';
let pageSizeData = '10';
let requestData = { categoryCode: categoryCode, pageNo: currPageData, pageSize: pageSizeData };
/**
 * 获取首页的新闻中心的数据
 */
Http({
    url: '/' + SERVER_FLAG + '/f/articleList/listDataDetail',
    data: requestData,
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        $.each(data.result, function (index, value) {
            console.log(value.id);
            // 控制首页的新闻中心的数量在10条内；
            if (index < 10) {
                $('#index-news').find('ol').append('<li class="list top"><span class="time">' + value.updateDate + '</span><a href="news.html?id=' + value.id + '" title="" target="_self">' + value.title + '</a></li>');
            }
        });
    }
}).get();

