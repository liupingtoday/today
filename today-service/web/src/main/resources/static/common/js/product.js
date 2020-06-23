// 初始化内容
// let base = document.getElementById("ctx").href;
// let baseURL = Utils.getRootPath(base);
// console.log("--+++baseURL:" + baseURL);

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