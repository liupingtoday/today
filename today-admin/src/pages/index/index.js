import '../../assets/Common';
import '../../assets/js/app';
import '../../assets/js/demo_pages/dashboard';
import leftNavArt from '../../assets/templates/left.art';
import './index.scss';
import './index.html';

/* eslint-disable */
let html = '';
const url = '../../assets/json/init.json';
const Index = {
    init () {
        this.initData();
    },
    // fetch init数据
    initData () {
        // let me = this,
        // let requestPara = '',
        Utils.doAjax(url, '', function (res) {
            let dataTemp = res.data;
            const questions = dataTemp.question;
            html = leftNavArt({ model: questions });
            //初始化left
            $('#leftNav').html(html);
        });
    },
};
/* eslint-disable */

/* eslint-disable */
$('#fullScreen').click(function() {
    if ($(this).data('isOpen') == 'true') {
        $(this).data('isOpen', 'false');
        if (document.exitFullscreen) {
            document.exitFullscreen()
        } else {
            if (document.msExitFullscreen) {
                document.msExitFullscreen()
            } else {
                if (document.mozCancelFullScreen) {
                    document.mozCancelFullScreen()
                } else {
                    if (document.webkitCancelFullScreen) {
                        document.webkitCancelFullScreen()
                    }
                }
            }
        }
    } else {
        $(this).data('isOpen', 'true');
        const d = document.documentElement;
        if (d.requestFullscreen) {
            d.requestFullscreen()
        } else {
            if (d.msRequestFullscreen) {
                d.msRequestFullscreen()
            } else {
                if (d.mozRequestFullScreen) {
                    d.mozRequestFullScreen()
                } else {
                    if (d.webkitRequestFullScreen) {
                        d.webkitRequestFullScreen()
                    }
                }
            }
        }
    }
    return false
}).tooltip();
/* eslint-disable */

/* eslint-disable */
// 鼠标移动到导航菜单上立即展开二级菜单的效果
// $(".dropdown").mouseover(function(){
//     $(this).addClass("show").find(".dropdown-menu").addClass("show");
// });
// $(".dropdown").mouseout(function(){
//     $(this).removeClass("show").parent(".dropdown").removeClass("show");
// });
/* eslint-disable */

$(function () {
    Index.init();
});
