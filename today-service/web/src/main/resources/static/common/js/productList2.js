// 初始化内容
let base = document.getElementById("ctx").href;
let currentPage = $("#currentPage").attr("data-value");
let totalPage = $("#totalPage").attr("data-value");
let totalCount = $("#totalCount").attr("data-value");
let baseURL = Utils.getRootPath(base);
console.log("--+++baseURL:" + baseURL);
console.log("--+++currentPage:" + currentPage);
console.log("--+++totalPage:" + totalPage);
console.log("--+++totalCount:" + totalCount);

let categoryCodeProductList = Utils.getQueryString('id');
// console.log('!!!!!category.categoryCode!!!!!!!! :' + category.categoryCode);
loadPaginationData(currentPage, 12);
function loadPaginationData(currPage, pageSize) {
    console.log('----loadPaginationData----currPage:' + currPage + ' pageSize:' + pageSize);
    $('#pagination_productList').whjPaging('setPage', { currPage: currPage, totalPage: totalPage, totalSize: totalCount });
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
    isResetPage: false,
    callBack: function (currPage, pageSize) {
        // currPageData = currPage;
        // requestData = { pageNo: currPageData, pageSize: pageSizeData };
        console.log('----callBack----currPage:' + currPage + ' pageSize:' + pageSize);
        loadPaginationData(currPage, pageSize);
    }
});