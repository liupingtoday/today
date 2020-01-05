const dirJSON = require('./src/pages/pages.json');
const path = require('path');
const HtmlWebpackPlugin  = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const isProd = (process.env.NODE_ENV === 'prod');

let entry = {};
let plugins = [];
dirJSON.forEach(page => {
    entry[page.url] = path.resolve(__dirname, `./src/pages/${page.url}/index.js`);
    let chunks = [page.url];
    if (isProd) {
        chunks.splice(0, 0, 'assets');
        page.easyui && chunks.splice(0, 0, 'easyui');
        page.echarts && chunks.splice(0, 0, 'echarts');
        chunks.splice(0, 0, 'vendors');
    }
    plugins.push(
        new HtmlWebpackPlugin ({  // 打包输出HTML
            title: '111111',
            favicon: path.resolve(__dirname, `./src/assets/images/favicon.ico`),
            filename: path.resolve(__dirname, `./dist/${page.url}.html`),
            template: path.resolve(__dirname, `./src/pages/${page.url}/index.html`),
            chunks: chunks,
            showErrors: true,
            // excludeChunks: ['devor.js'], //和的等等效
            hash: true,
            chunksSortMode: 'manual',
            inject: true,
            // minify: isProd ? {
            //     // 期初属性引号
            //     // removeAttributeQuotes:true,
            //     // 移除注释
            //     removeComments: true,
            //     // 移除空白格
            //     collapseWhitespace: true,
            //     // removeScriptTypeAttributes:true,
            //     // removeStyleLinkTypeAttributes:true
            // minifyCSS: true// 压缩内联css
            // } : false
        })
    );
});

if (isProd) {
    plugins.push(
        new MiniCssExtractPlugin({
            filename: 'css/' + (isProd ? '[name].[contenthash:8].min.css' : '[name].css'),
            chunkFilename: 'css/' + (isProd ? '[name].chunk.[contenthash:8].min.css' : '[name].chunk.css'),
            // ignoreOrder: false
        })
    );
    plugins.push(new CopyWebpackPlugin([
        {
            from: path.resolve(__dirname, './src/assets/public'), to: 'public'
        }
    ])
    );
}

module.exports = {
    entry: entry,
    output: {
        publicPath: isProd ? './' : '',
        path: path.resolve(__dirname, './dist'),
        filename: 'js/' + (isProd ? '[name].[chunkhash:8].min.js' : '[name].js'),
        chunkFilename: 'js/' + (isProd ? '[name].chunk.[chunkhash:8].min.js' : '[name].chunk.js'),
    },
    module: {
        rules: [
            {
                test: require.resolve('jquery'),
                use: [{
                    loader: 'expose-loader',
                    options: 'jQuery'
                }, {
                    loader: 'expose-loader',
                    options: '$'
                }]
            },

            // {
            //     test:/\.(jpg|png|gif|bmp|jpeg)$/,
            //     use: [{
            //         loader: 'url-loader',
            //         options: {
            //             esModule: false,
            //             name: '[name].[ext]',
            //             limit: 10240
            //         }
            //     }]
            // },

            {
                test: /\.(htm|html)$/i,
                use: ['html-withimg-loader']
            },
            // {
            //     test: /\.(htm|html)$/i,
            //     use: ['html-withimg-loader',
            //         {
            //             loader: 'html-loader',
            //             options: {
            //                 attrs: ['img:src', 'img:data-src', 'audio:src'],
            //                 minimize: false
            //             }
            //         }
            //     ]
            // },

            {
                test: /\.(gif|png|jpe?g|svg|bmp|ico)$/i,
                use: [
                    {
                        loader:'url-loader',
                        options:{
                            esModule: false,
                            limit:4096,//小于limit限制(4kb)的图片将转为base64嵌入引用位置
                            fallback: {
                                loader: 'file-loader',
                                // options: {
                                //     name: 'images/[name].[hash:8].[ext]'
                                // }
                            },//大于limit限制的将转fa交给指定的loader处理
                            outputPath:'images/', // options会直接传给llback指定的loader  //输出的图片会生成并放在当前设置的文件夹下
                            name:'[name]' + (isProd ? '.[hash:8]' : '') + '.[ext]',
                            // publicPath:"/dist/images/"   //会在打包后图片路径拼上该设置
                        }
                    },
                    {
                        loader: 'image-webpack-loader',
                        options: {
                            bypassOnDebug: true, // webpack@1.x
                            disable: true, // webpack@2.x and newer
                            mozjpeg: {
                                progressive: true,
                                quality: 65
                            },
                            // optipng.enabled: false will disable optipng
                            optipng: {
                                enabled: false,
                            },
                            pngquant: {
                                quality: [0.65, 0.90],
                                speed: 4
                            },
                            gifsicle: {
                                interlaced: false,
                            },
                            // the webp option will enable WEBP
                            webp: {
                                quality: 75
                            }
                        }
                    },
                ],
            },

            // {
            //     test: /\.(png|jpg|jpe?g|gif)$/,
            //     use: ['url-loader?limit=4096&name=[name]' + (isProd ? '.[hash:8]' : '') + '.[ext]&outputPath=images/', 'image-webpack-loader']
            // },

            //处理ejs模板中的loader,以.tpl后缀结尾的
            // {
            //     test: /\.tpl$/,
            //     loader: 'ejs-loader'
            // },

            {
                test: /\.art$/,
                loader: "art-template-loader",
                options: {
                    // art-template options (if necessary)
                    // @see https://github.com/aui/art-template
                }
            },

            {
                test: /\.(webp)$/,
                use: ['file-loader?&name=[name]' + (isProd ? '.[hash:8]' : '') + '.[ext]&outputPath=images/']
            },
            {
                test: /\.(svg|woff|woff2|ttf|eot)(\?.*$|$)/,
                loader: 'file-loader?name=font/[name].[hash:8].[ext]'
            },
            {
                test: /\.(css)$/,
                use: [isProd ? ({
                    loader: MiniCssExtractPlugin.loader,
                    options: {
                        publicPath: '../'
                    }
                }) : 'style-loader', 'css-loader']
            },
            {
                test: /\.(scss)$/,
                use: [isProd ? ({
                    loader: MiniCssExtractPlugin.loader,
                    options: {
                        publicPath: '../'
                    }
                }) : 'style-loader', 'css-loader', {
                    loader: 'postcss-loader',
                    options: {
                        plugins: function () {
                            return [
                                require('autoprefixer')
                            ];
                        }
                    }
                }, 'sass-loader']
            },
            {
                enforce: 'pre',
                test: /\.js$/,
                include: [path.resolve(__dirname, 'src/pages'), path.resolve(__dirname, 'assets/js')], // 指定eslint检查的目录
                loader: 'eslint-loader'
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        // "presets": ["env"],
                        presets: ['@babel/preset-env'],
                        // plugins: ['transform-runtime']
                        plugins: ['@babel/plugin-proposal-object-rest-spread','@babel/plugin-transform-runtime']
                    }
                }
            }
            // {
            //     enforce: 'pre', // 编译前检查
            //     test: /\.js$/,
            //     // exclude: /node_modules/, // 不检测的文件
            //     include: [path.resolve(__dirname, 'src/views'), path.resolve(__dirname, 'assets/js')], // 指定eslint检查的目录
            //     // options: { // 这里的配置项参数将会被传递到 eslint 的 CLIEngine
            //     //     formatter: require('eslint-friendly-formatter'), // 指定错误报告的格式规范
            //     //     // 不符合Eslint规则时只警告(默认运行出错)
            //     //     // emitWarning: !config.dev.showEslintErrorsInOverlay
            //     // },
            //     loader: 'eslint-loader'
            // },
            // {
            //     test: /\.js$/,
            //     exclude: /node_modules/, // 排除掉node_modules，优化打包速度
            //     // include: /src/, // 只转化src目录下的js
            //     use: {
            //         loader: 'babel-loader',
            //         options: {
            //             // presets: ['es2015-nostrict'],
            //             // plugins: ['transform-runtime']
            //             presets: ['@babel/preset-env'],
            //             plugins: ['@babel/plugin-transform-runtime']
            //         }
            //     }
            // }
        ]
    },
    // htmlLoader: {
    //     ignoreCustomFragments: [/\{\{.*?}}/],
    //     root: path.resolve(__dirname, `./src/views`),
    //     attrs: ['img:src', 'link:href']
    // },
    plugins: [
        ...plugins
    ]
};
