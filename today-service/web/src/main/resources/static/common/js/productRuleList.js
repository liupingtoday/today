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
                        $('#sidebar').find('dl').append('<dt id=""><a href="/admin/front/productsList/' + val.id + '" title="" class="zm"><span>' + val.categoryName + '</span></a></dt>');
                    }
                );

            }
        });
    }
}).get();
