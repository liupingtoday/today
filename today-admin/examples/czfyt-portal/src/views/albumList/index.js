import '../../assets/Common';
import '../../assets/libs/jqueryPagination/css/pagination.css';
import '../../assets/libs/jqueryPagination/js/pagination.min';
import './index.scss';
import './index.html';

// let contentId = Utils.getQueryString('id');
let rootPath = Utils.getRootPath();
/**
 *
 */
// Http({
//     url: '/' + SERVER_FLAG + '/f/articleList/listDataDetail',
//     data: { 'id': contentId },
//     isDefaultApiRequest: false,
//     success: function (data, textStatus, jqXHR) {
//         // console.log('!!!!!!!!!!!!!!!!!!!!!!!!');
//         // console.log(data.list[0].title);
//         $('#shownews').children('h1').html(data.list[0].title);
//         // $.each(data.list, function (index, value) {
//         //     $('#newslist').find('ul').append('<li class="list top"><span>' + value.updateDate + '</span><a href="news.html?id=' + value.id + '" title="" target="_self">' + value.title + '</a><p>' + value.description + '</p></li>');
//         // });
//     }
// }).get();
let currPageData = '1';
let pageSizeData = '10';
let article = {};
let category = {};
article.pageNo = currPageData;
article.pageSize = pageSizeData;
let categoryCode = Utils.getQueryString('id');
console.log('!!!!!category.categoryCode!!!!!!!! :' + category.categoryCode);
// article['category']['categoryCode'] = contentId;
let requestData = { categoryCode: categoryCode, pageNo: currPageData, pageSize: pageSizeData };
loadPaginationData(categoryCode, article, currPageData, pageSizeData);
function loadPaginationData(categoryCode, article, currPage, pageSize) {
    Http({
        url: '/' + SERVER_FLAG + '/f/articleList/listDataDetail',
        data: requestData,
        isDefaultApiRequest: false,
        success: function (data, textStatus, jqXHR) {
            console.log('WWWW!!!!1111');
            console.log(data);
            console.log('WWWW!!!!2222');
            // 设置分页插件显示
            $('#pagination_8').whjPaging('setPage', { currPage: data.pageNo, totalPage: data.totalPageNum, totalSize: data.totalRowNum });
            pageSizeData = data.pageSize;
            if (data.pageNo !== '1') {
                $('#productlist').find('ul').children('li').remove();
            }
            $.each(data.result, function (index, value) {
                console.log('WWWW!!!!1********************');
                console.log(value);
                console.log('WWWW!!!!2&&&&&&&&&&&&');
                $('#productlist').find('ul').append('<li class="list" style="width:152px; margin-left:14px; margin-right:14px;"><a href="/product.html?id=' + value.id + '" title="' + value.title + '" target="_self" class="img"><img src="' + rootPath + value.image + '" alt="" title="" width="150" height="120"/></a><h3><a href="/product.html?id=' + value.id + '" title="' + value.title + '" target="_self">' + value.title + '</a></h3></li>');
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
        // currPageData = currPage;
        // requestData = { pageNo: currPageData, pageSize: pageSizeData };
        loadPaginationData(categoryCode, article, currPage, pageSize);
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
