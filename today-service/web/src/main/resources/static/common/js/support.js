// 初始化内容
let categoryId = window.Utils.getQueryString("id");
console.log("--+++categoryId:" + categoryId);


let categoryCode = 'A1005';
let currPageData = '1';
let pageSizeData = '12';
let requestData = { categoryCode: categoryCode, pageNo: currPageData, pageSize: pageSizeData };

/**
 * 获取栏目信息填写左侧的导航栏
 */
Http({
    url: baseURL + '/front/category/getAll',
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        $.each(data, function (index, value) {
            console.log(value);
            // console.log(value.categoryName);
            if (value.categoryCode === 'A1009') {
                // 关于我们
                // 给左边的导航栏赋值
                $('#leftNav').find('span').html(value.categoryName);
                $('#sidebar').remove();

            }
        });
    }
}).get();

