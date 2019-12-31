import '../../assets/Common';
import '../../assets/libs/jqueryPagination/css/pagination.css';
import '../../assets/libs/jqueryPagination/js/pagination.min';
import './index.scss';
import './index.html';

let rootPath = Utils.getRootPath();
let currPageData = '1';
let pageSizeData = '12';
let article = {};
// let category = {};
// article.pageNo = currPageData;
// article.pageSize = pageSizeData;
let categoryCode = Utils.getQueryString('id');
console.log('!!!!!categoryCode!!!!!!!! :' + categoryCode);
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
            $('#pagination_9').whjPaging('setPage', { currPage: data.pageNo, totalPage: data.totalPageNum, totalSize: data.totalRowNum });
            pageSizeData = data.pageSize;
            // if (data.pageNo !== '1') {
            //     $('#productRuleList').find('ul').children('li').remove();
            // }
            let $ul = $('#imglist').find('ul');
            $.each(data.result, function (index, value) {
                console.log('WWWW!!!!1********************');
                console.log(value);
                console.log('WWWW!!!!2&&&&&&&&&&&&');
                $ul.append('<li class="list" style="width: 223px; margin-left: 11px; margin-right: 11px; height: 165px;"><a href="/productRule.html?id=' + value.id + '" title="' + value.title + '" target="_self" class="img"><img src="' + rootPath + value.image + '" alt="" title="" width="221" height="130"/></a><h3><a href="/productRule.html?id=' + value.id + '" title="' + value.title + '" target="_self">' + value.title + '</a></h3></li>');
            });
            $ul.append('<div class="clear"></div>');
        }
    }).get();
}
$('#pagination_9').whjPaging({
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
                $('#productRuleListTitle').find('span').html(value.categoryName);

            }
        });
    }
}).get();
