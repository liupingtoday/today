import '../../assets/Common';
import './index.scss';
import './index.html';

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
