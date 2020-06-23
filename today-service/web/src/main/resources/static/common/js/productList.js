// 初始化内容
// let base = document.getElementById("ctx").href;
// let baseURL = Utils.getRootPath(base);
// console.log("--+++baseURL:" + baseURL);

let currPageData = '1';
let pageSizeData = '12';

let categoryCodeProductList = Utils.getQueryString('id');
// console.log('!!!!!category.categoryCode!!!!!!!! :' + category.categoryCode);
loadPaginationData(currPageData, pageSizeData);
function loadPaginationData(currPage, pageSize) {
    console.log('----loadPaginationData----currPage:' + currPage + ' pageSize:' + pageSize);
    Http({
        url: baseURL + '/front/productList/getProductListPagable',
        data: {categoryCode: categoryCodeProductList, pageNo: currPage, pageSize: (pageSize === null ? 12 : pageSize) },
        isDefaultApiRequest: false,
        success: function (data, textStatus, jqXHR) {
            console.log('WWWW!!!!1111');
            console.log(data);
            console.log('WWWW!!!!2222');
            // 设置分页插件显示
            $('#pagination_productList').whjPaging('setPage', { currPage: data.currentPage, totalPage: data.totalPage, totalSize: data.totalCount });
            // pageSizeData = data.pageSize;
            if (data.currentPage !== '1') {
                $('#productlist').find('ul').children('li').remove();
            }
            $.each(data.data, function (index, value) {
                console.log('WWWW!!!!1********************');
                console.log(value);
                console.log('WWWW!!!!2&&&&&&&&&&&&');
                $('#productlist').find('ul').append('<li class="list" style="width:152px; margin-left:14px; margin-right:14px;"><a href="/admin/front/product/' + value.id + '" title="' + value.title + '" target="_self" class="img"><img src="' + value.image + '" alt="" title="" width="150" height="120"/></a><h3><a href="/admin/front/product/' + value.id + '" title="' + value.title + '" target="_self">' + value.title + '</a></h3></li>');
            });
        }
    }).get();
}

$('#pagination_productList').whjPaging({
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
    url: baseURL + '/front/category/getAll',
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
                        $('#sidebar').find('dl').append('<dt id=""><a href="/admin/front/productList/' + val.categoryCode + '?id=' + val.categoryCode + '" title="" class="zm"><span>' + val.categoryName + '</span></a></dt>');
                    }
                );

            }
        });
    }
}).get();