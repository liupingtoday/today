import '../../assets/Common';
import './index.scss';
import './index.html';

// Http({
//     url: '/api/content/getById',
//     data: { 'id': contentId },
//     isDefaultApiRequest: false,
//     success: function (data, textStatus, jqXHR) {
//         // console.log(data);
//         $('#shownews').children('h1').html(data.title);
//         $('#shownews').find('.editor').first().html(data.content);
//         // $('#index-news').find('li').each(function (index, domEle) {
//         //     // console.log($(domEle).find('span').length);
//         //     $(domEle).find('a').html(data.content[index].title);
//         //     $(domEle).find('a').attr('title', data.content[index].title);
//         //     $(domEle).find('a').attr('href', 'news.html?id=' + data.content[index].id);
//         //     $(domEle).find('span').html(data.content[index].updatedTime);
//         // });
//     }
// }).get();

let contentId = Utils.getQueryString('id');

/**
 * 获取新闻中心的数据列表
 */
Http({
    url: '/' + SERVER_FLAG + '/f/articleList/listData',
    data: { 'id': contentId },
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        // console.log('!!!!!!!!!!!!!!!!!!!!!!!!');
        // console.log(data.list[0].title);
        $('#shownews').children('h1').html(data.list[0].title);
        // $.each(data.list, function (index, value) {
        //     $('#newslist').find('ul').append('<li class="list top"><span>' + value.updateDate + '</span><a href="news.html?id=' + value.id + '" title="" target="_self">' + value.title + '</a><p>' + value.description + '</p></li>');
        // });
    }
}).get();


/**
 * 获取新闻的数据详情
 */
Http({
    url: '/' + SERVER_FLAG + '/f/articleData/listData',
    data: { 'id': contentId },
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        $('#shownews').find('.editor').first().html(data.list[0].content);
        // console.log(data.list[0].content);
        // $('#shownews').children('h1').html(data.list[0].content);

    }
}).get();

/**
 * 获取栏目信息填写左侧的导航栏
 */
Http({
    url: '/' + SERVER_FLAG + '/f/category/listData',
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        $.each(data, function (index, value) {
            // console.log(value);
            // console.log(value.categoryName);
            if (value.categoryCode === 'A1005') {
                // 关于我们
                // 给左边的导航栏赋值
                $('#leftNav').find('span').html(value.categoryName);
                value.childList.forEach(
                    function (val) {
                        $('#sidebar').find('dl').append('<dt id=""><a href="" title="" class="zm"><span>' + val.categoryName + '</span></a></dt>');
                    }
                );

            }
        });
    }
}).get();
