import '../../assets/Common';
import './index.scss';
import './index.html';

let contentId = Utils.getQueryString('id');
console.log('categoryCode:' + contentId);
/**
 * 根据栏目ID获取文章的ID，再根据文章ID获取文档正文的内容；
 */
Http({
    url: '/' + SERVER_FLAG + '/f/articleList/listData',
    data: { 'category.categoryCode': contentId },
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        console.log('!!!!!!!!!!!!!!!!!!!!!!!!');
        console.log(data.list[0].id);
        /**
         *  根据文章的ID获取文章的正文的内容
         */
        Http({
            url: '/' + SERVER_FLAG + '/f/articleData/listData',
            data: { 'id': data.list[0].id },
            isDefaultApiRequest: false,
            success: function (dataValue, textStatus, jqXHR) {
                // $('#shownews').find('.editor').first().html(data.list[0].content);
                // console.log(data.list[0].content);
                // $('#shownews').children('h1').html(data.list[0].title);
                // $('#shownews').children('h1').html(data.list[0].content);
                // $('#shownews').children('h1').html(data.list[0]);
                console.log(dataValue.list[0]);
                $('#shownews').children('h1').html(data.list[0].title);
                $('#shownews').find('.editor').first().html(dataValue.list[0].content);
            }
        }).get();

        // $('#shownews').children('h1').html(data.list[0]);
        // $.each(data.list, function (index, value) {
        //     $('#newslist').find('ul').append('<li class="list top"><span>' + value.updateDate + '</span><a href="news.html?id=' + value.id + '" title="" target="_self">' + value.title + '</a><p>' + value.description + '</p></li>');
        // });
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
            if (value.categoryCode === 'A1008') {
                // 关于我们
                // 给左边的导航栏赋值
                $('#leftNav').find('span').html(value.categoryName);
                $('#sidebar').remove();
                $('#contactUsTitle').html(value.categoryName);
            }
        });
    }
}).get();
