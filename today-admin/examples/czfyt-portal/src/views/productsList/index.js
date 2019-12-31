import '../../assets/Common';
import '../../assets/libs/jqueryPagination/css/pagination.css';
import '../../assets/libs/jqueryPagination/js/pagination.min';
import './index.scss';
import './index.html';

// let contentId = Utils.getQueryString('id');
let rootPath = Utils.getRootPath();
let currPageData = '1';
let pageSizeData = '12';
let article = {};
let category = {};
// article.pageNo = currPageData;
// article.pageSize = pageSizeData;
let categoryCode = Utils.getQueryString('id');
console.log('!!!!!category.categoryCode!!!!!!!! :' + category.categoryCode);
// article['category']['categoryCode'] = contentId;
// let requestData = { categoryCode: categoryCode, article: article, pageNo: currPageData, pageSize: pageSizeData };
loadPaginationData(currPageData, pageSizeData);
function loadPaginationData(currPage, pageSize) {
    console.log('----loadPaginationData----currPage:' + currPage + ' pageSize:' + pageSize);
    Http({
        url: '/' + SERVER_FLAG + '/f/articleList/listDataDetail',
        data: { categoryCode: categoryCode, article: article, pageNo: currPage, pageSize: (pageSize === null ? 12 : pageSize) },
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
    showPageNum: 12,
    isShowRefresh: false,
    isShowSkip: false,
    isShowPageSizeOpt: false,
    // 设为true时，ajax里的success函数必须调用setPage方法，否则分页插件显示保持不变
    isResetPage: true,
    callBack: function (currPage, pageSize) {
        // currPageData = currPage;
        // requestData = { pageNo: currPageData, pageSize: pageSizeData };
        console.log('----callBack----currPage:' + currPage + ' pageSize:' + pageSize);
        loadPaginationData(currPage, pageSize);
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
                // 设置页面title
                $('#czfyt_title').html(value.categoryName);
                // 关于我们
                // 给左边的导航栏赋值
                $('#leftNav').find('span').html(value.categoryName);
                value.childList.forEach(
                    function (val) {
                        $('#sidebar').find('dl').append('<dt id=""><a href="/productsList.html?id=' + val.id + '" title="" class="zm"><span>' + val.categoryName + '</span></a></dt>');
                    }
                );

            }
        });
    }
}).get();
