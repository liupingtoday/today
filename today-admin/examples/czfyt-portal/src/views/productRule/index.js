import '../../assets/Common';
import './index.scss';
import './index.html';

let contentId = Utils.getQueryString('id');

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
            if (value.categoryCode === 'A1014') {
                // 设置页面title
                $('#czfyt_title').html(value.categoryName);
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
