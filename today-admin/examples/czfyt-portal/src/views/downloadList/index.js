import '../../assets/Common';
import '../../assets/libs/jqueryPagination/css/pagination.css';
import '../../assets/libs/jqueryPagination/js/pagination.min';
import './index.scss';
import './index.html';

/**
 * 获取新闻中心的数据列表
 */
// Http({
//     url: '/js/f/articleList/listData',
//     isDefaultApiRequest: false,
//     success: function (data, textStatus, jqXHR) {
//         $.each(data.list, function (index, value) {
//             $('#newslist').find('ul').append('<li class="list top"><span>' + value.updateDate + '</span><a href="news.html?id=' + value.id + '" title="" target="_self">' + value.title + '</a><p>' + value.description + '</p></li>');
//         });
//     }
// }).get();
let currPageData = '1';
let pageSizeData = '10';
let requestData = { pageNo: currPageData, pageSize: pageSizeData };
loadPaginationData(currPageData, pageSizeData);
function loadPaginationData(currPage, pageSize) {
    Http({
        url: '/' + SERVER_FLAG + '/f/articleList/listData',
        data: requestData,
        isDefaultApiRequest: false,
        success: function (data, textStatus, jqXHR) {
            // 设置分页插件显示
            $('#pagination_8').whjPaging('setPage', { currPage: data.pageNo, totalPage: Math.ceil(data.count / data.pageSize), totalSize: data.count });
            pageSizeData = data.pageSize;
            if (data.pageNo !== '1') {
                $('#newslist').find('ul').children('li').remove();
            }
            $.each(data.list, function (index, value) {
                $('#newslist').find('ul').append('<li class="list top"><span>' + value.updateDate + '</span><a href="news.html?id=' + value.id + '" title="" target="_self">' + value.title + '</a><p>' + value.description + '</p></li>');
            });
        }
    }).get();
}
$('#pagination_8').whjPaging({
    // totalPage: 18,
    // isShowTotalSize: false,
    // isShowTotalPage: false,
    isShowRefresh: false,
    isShowSkip: false,
    isShowPageSizeOpt: false,
    // 设为true时，ajax里的success函数必须调用setPage方法，否则分页插件显示保持不变
    isResetPage: true,
    callBack: function (currPage, pageSize) {
        currPageData = currPage;
        requestData = { pageNo: currPageData, pageSize: pageSizeData };
        loadPaginationData(currPageData, pageSizeData);
    }
});

/**
 * 获取栏目信息填写左侧的导航栏
 */
Http({
    url: '/' + SERVER_FLAG + '/f/category/listData',
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        $.each(data, function (index, value) {
            if (value.categoryCode === 'A1002') {
                // 关于我们
                // 给左边的导航栏赋值
                $('#leftNav').find('span').html(value.categoryName);
                $('#sidebar').remove();

            }
        });
    }
}).get();
