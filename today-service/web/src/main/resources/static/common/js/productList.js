// 初始化内容
let base = document.getElementById("ctx").href;
let baseURL = Utils.getRootPath(base);
console.log("--+++baseURL:" + baseURL);

let categoryCodeProductList = Utils.getQueryString('id');
// console.log('!!!!!category.categoryCode!!!!!!!! :' + category.categoryCode);
// loadPaginationData(currPageData, pageSizeData);
function loadPaginationData(currPage, pageSize) {
    console.log('----loadPaginationData----currPage:' + "${currentPage}" + ' totalPage:' + "${totalPage}");
    $('#pagination_productList').whjPaging('setPage', { currPage: "${currentPage}", totalPage: "${totalPage}", totalSize: "${totalCount}" });
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