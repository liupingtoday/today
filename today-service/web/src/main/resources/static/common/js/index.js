// 返回顶部按钮
// Helper.backTop();

// 监听滚动事件，更改navbar背景色透明度
// $(window).scroll(function () {
//     let s = $(window).scrollTop();
//     $('.navbar-warp').css('background-color', `rgba(255, 255, 255, ${s / 120})`);
// });

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



