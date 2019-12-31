// 1.先创建一个项目文件夹
mkdir webpack-001

// 2.进入该文件目录下
cd webpack-001

// 3.初始化配置，假设不要-y，会出现很多true和false的选项，-y的意思全默认true，然后直接初始化完成
npm init -y
// 此时，该目录下会多出一个 package.json 的文件，内容为以下：

// 4. 安装 webpack-cli
npm install webpack webpack-cli --save-dev

// 5.和package.json同级目录下，新增并配置webpack.config.js文件，由于webpack是基于node的，所以配置文件要遵循commonJS规范；创建src文件夹及其index.js入口文件(默认)

// 6.webpack 引入 eslint, 首先安装webpack支持eslint三件套: yarn add eslint eslint-loader eslint-friendly-formatter -D

// 7.npm install eslint --save-dev

// 8.生成eslint配置文件:  npx eslint --init

常用命令汇总：
npm install swiper --registry=https://registry.npm.taobao.org
npm install --registry=https://registry.npm.taobao.org

node-v12.14.0-x64

* 本项目集成了bootstrap4，jquery，easyui(可配置)等
* 采用webpack4多页面(多入口)配置，实现常用webpack配置
* [在线demo](https://www.yanxiaojun617.com/webpack4-bootstrap4-demo/)
* [项目源码](https://github.com/yanxiaojun617/webpack4-bootstrap4-demo)
* [项目文档](https://yanxiaojun617.gitbook.io/webpack4-bootstrap4-demo/)
* 链接——[Bootstrap](https://getbootstrap.com/)、 [jQuery](https://www.jquery123.com/)、[Font Awesome](http://fontawesome.dashgame.com/)、[EasyUi](http://www.jeasyui.com/demo/main/index.php)、[sass/scss](https://www.sass.hk/)， [webpack](https://www.webpackjs.com/configuration/)

# 项目适用于哪些人
* 想使用bootstrap、jquery开发项目，尤其是简单的门户网站，宣传页面等小项目
* 想学习webpack4配置
  > 还不知道webpack是干什么的？
它就是一个打包工具，能帮我们压缩代码，处理图片，热启动（开发时修改代码自动刷新浏览器），代码转义（写[es6](http://es6.ruanyifeng.com/)转成es5，写[scss](https://www.sass.hk/)转成css）等

# 如何运行？
* 确保已安装nodejs，最好是8.x以上，该项目在v8.9.4上测试。
> 如果不会安装nodejs可以参考[这里](https://www.jianshu.com/p/81072e9be3e4),如果想安装多个nodejs版本可以参考[这里](https://www.jianshu.com/p/17d3249e0619),
> 如果本地网络不好可以安装cnpm,详情看[这里](https://www.jianshu.com/p/79d4430e0a9d)
* 检出项目到本地
```
git clone https://github.com/yanxiaojun617/webpack4-bootstrap4-demo.git
```
* 进入项目并安装依赖
```
cd webpack4-bootstrap4-demo
cnpm i
```
* 跑起来
```
npm run dev
```
* 运行步骤参考图
![运行步骤.png](./doc/img/run.png)

# 打包
```
npm run build
```
> 打包后资源放在dist目录下

* 了解更多请阅读[项目文档](https://yanxiaojun617.gitbook.io/webpack4-bootstrap4-demo/)
