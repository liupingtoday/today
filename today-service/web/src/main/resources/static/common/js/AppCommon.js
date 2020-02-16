// 导航栏的选择器
$navBar = $('#metismenu');
/**
 * 获取站点信息
 */
Http({
    url: '/' + SERVER_FLAG + '/f/site/listData',
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        // console.log(data.list);
        $.each(data.list, function (index, value) {
            // console.log(data.list[index].siteCode);
            let siteCode = data.list[index].siteCode;
            if (siteCode === 'main') {
                // czfyt站点
                let logo = data.list[index].logo;
                let domain = data.list[index].domain;
                let copyright = data.list[index].copyright;
                let title = data.list[index].title;
                $('footer').html(copyright);
                $('#siteLogo').find('img').attr('src', window.location.origin + logo);
                console.log(domain);
                console.log(copyright);
                console.log(title);
            }
        });
    }
}).get();

/**
 * 获取栏目信息
 */
Http({
    url: '/' + SERVER_FLAG + '/category/getAll',
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        $.each(data, function (index, value) {
            console.log(value);
            // console.log(value.categoryName);
            if (value.treeLeaf=== '0') {
                if ( value.id === 'A1005') {
                    // 产品与应用
                    let html = '<li id="' + value.id + '"><a class="" href="/productsList.html?id=' + value.id + '" title="' + value.categoryName + '">' + value.categoryName + '</a></li>';
                    let $a = $(html).has('a');
                    // 导航菜单的列表
                    let liList = '';
                    // 搜索条件下方的菜单列表
                    let indexliList = '';

                    value.childList.forEach(
                        function (val) {
                            liList += '<li id="' + val.id + '"><a href="/productsList.html?id=' + val.id + '" title="' + val.categoryName + '">' + val.categoryName + '</a></li>';
                            indexliList += '<li class="nav"><a href="/productsList.html?id=' + val.id + '" title="' + val.categoryName + '">' + val.categoryName + '</a></li>';
                        }
                    );
                    liList = '<ul>' + liList + '</ul>';
                    indexliList = '<ul>' + indexliList + '</ul>';
                    $a.append(liList);
                    $navBar.append($a);
                    /**
                     * 如果是首页，赋值给搜索框下面的标题
                     * */

                    if ($('#index-product-list').length !== 0) {
                        // 给标题赋值
                        $('#index-product-list').html(value.categoryName);
                        // 给列表赋值
                        $('#index-product-list-item').append(indexliList);
                        $('#index-product-list-item').append('<div class="clear"></div>');

                    };

                } else if (value.id === 'A1002') {
                    // 新闻中心
                    let html = '<li id="' + value.id + '"><a class="" href="/newsList.html" title="' + value.categoryName + '">' + value.categoryName + '</a></li>';
                    let $a = $(html).has('a');
                    let liList = '';
                    value.childList.forEach(
                        function (val) {
                            liList += '<li id="' + val.id + '"><a href="/" title="' + val.categoryName + '">' + val.categoryName + '</a></li>';
                        }
                    );
                    liList = '<ul>' + liList + '</ul>';
                    $a.append(liList);
                    $navBar.append($a);
                } else if ( value.id === 'A1011') {
                    // 资料下载
                } else if ( value.id === 'A1012') {
                    // 公司相册
                } else if ( value.id === 'A1013') {
                    // 招聘信息
                } else if ( value.id === 'A1014') {
                    // 产品规格表
                    let html = '<li id="' + value.id + '"><a class="" href="/productRuleList.html?id=' + value.id + '" title="' + value.categoryName + '">' + value.categoryName + '</a></li>';
                    let $a = $(html).has('a');
                    let liList = '';
                    value.childList.forEach(
                        function (val) {
                            liList += '<li id="' + val.id + '"><a href="/productRule.html?id=' + val.id + '" title="' + val.categoryName + '">' + val.categoryName + '</a></li>';
                        }
                    );
                    liList = '<ul>' + liList + '</ul>';
                    $a.append(liList);
                    $navBar.append($a);
                } else if ( value.id === 'A1002') {
                    // 新闻中心
                    let html = '<li id="' + value.id + '"><a class="" href="/newsList.html" title="' + value.categoryName + '">' + value.categoryName + '</a></li>';
                    let $a = $(html).has('a');
                    let liList = '';
                    value.childList.forEach(
                        function (val) {
                            liList += '<li id="' + val.id + '"><a href="/" title="' + val.categoryName + '">' + val.categoryName + '</a></li>';
                        }
                    );
                    liList = '<ul>' + liList + '</ul>';
                    $a.append(liList);
                    $navBar.append($a);
                } else if ( value.id === 'A1009') {
                    // 技术支持
                } else if ( value.categoryCode === 'A1008') {
                    // 联系我们
                }

            } else {
                if (value.categoryCode === 'A1015') {
                    // 关于我们
                    $navBar.append('<li id="' + value.id + '"><a class="" href="/about.html?id=' + value.id + '" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.id === 'A1002') {
                    // 新闻中心
                    $navBar.append('<li id="' + value.id + '"><a class="" href="/newsList.html" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.id === 'A1001') {
                    // 首页
                    $navBar.append('<li id="' + value.id + '"><a class="" href="/" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.id === 'A1005') {
                    // // 产品与应用
                    // $navBar.append('<li id="' + value.id + '"><a class="" href="/productsList.html" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.id === 'A1011') {
                    // 资料下载
                    $navBar.append('<li id="' + value.id + '"><a class="" href="/downloadList.html" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.id === 'A1012') {
                    // 公司相册
                    $navBar.append('<li id="' + value.id + '"><a class="" href="/albumList.html" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.id === 'A1013') {
                    // 招聘信息
                    $navBar.append('<li id="' + value.id + '"><a class="" href="/recruit.html" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.id === 'A1014') {
                    // // 产品规格表
                    // $navBar.append('<li id="' + value.id + '"><a class="" href="/about.html?id=' + value.id + '" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.id === 'A1009') {
                    // 技术支持
                    $navBar.append('<li id="' + value.id + '"><a class="" href="/support.html?id=' + value.id + '" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                } else if ( value.categoryCode === 'A1008') {
                    // 联系我们
                    $navBar.append('<li id="' + value.id + '"><a class="" href="/contactUs.html?id=' + value.id + '" title="' + value.categoryName + '">' + value.categoryName + '</a></li>');
                }
            }

        });
    }
}).get();

/**
 * 获取详情页面的公司联系方式
 */
Http({
    url: '/' + SERVER_FLAG + '/f/company/companyInfo/listData',
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {
        console.log('%%%%%%%%%%%%%%');
        console.log(data.list[0]);
        console.log('**************');
        $('#contactUs').find('span').eq(0).html(data.list[0].companyName);
        $('#companySite').find('span').eq(0).html(data.list[0].companySite);
        $('#telPhone').find('span').eq(0).html(data.list[0].telPhone);
        $('#mobilePhone').find('span').eq(0).html(data.list[0].mobilePhone);
        $('#email').find('span').eq(0).html(data.list[0].email);
        $('#website').find('span').eq(0).html(data.list[0].website);
        // 设置右上角的客服热线的电话
         $('#hotline').find('li').eq(1).find('span').html(data.list[0].telPhone);
    }
}).get();
