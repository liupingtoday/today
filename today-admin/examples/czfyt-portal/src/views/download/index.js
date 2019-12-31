import '../../assets/Common';
import './index.scss';
import './index.html';

let contentId = Utils.getQueryString('id');
console.log('categoryCode:' + contentId);

// $navBar.find('li:[id=' + contentId + ']').find('a').attr('title');
/**
 * 根据栏目ID获取文章的ID，再根据文章ID获取文档正文的内容；
 */
Http({
    url: '/' + SERVER_FLAG + '/f/articleList/listData',
    data: { 'category.categoryCode': contentId },
    isDefaultApiRequest: false,
    success: function (data, textStatus, jqXHR) {

        /**
         *  根据文章的ID获取文章的正文的内容
         */
        Http({
            url: '/' + SERVER_FLAG + '/f/articleData/listData',
            data: { 'id': data.list[0].id },
            isDefaultApiRequest: false,
            success: function (dataValue, textStatus, jqXHR) {
                console.log(dataValue.list[0]);
                $('#shownews').children('h1').html(data.list[0].title);
                $('#shownews').find('.editor').first().html(dataValue.list[0].content);
            }
        }).get();
    }
}).get();

// 给左边的导航栏赋值
$('#leftNav').find('span').html(' 66');

// 根据id获取title的值
console.log('*************88888');
console.log($('li[id=\"' + contentId + '\"]').length);
console.log('*************9999');
