const baseWebpackConfig = require('./webpack.base.conf');
const webpack = require('webpack');
const path = require('path');
const merge = require('webpack-merge');
const OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');
const {CleanWebpackPlugin} = require('clean-webpack-plugin')
const HashOutput = require('webpack-plugin-hash-output');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
const ProgressBarPlugin = require('progress-bar-webpack-plugin');
const TerserPlugin = require('terser-webpack-plugin');



if (process.env.NODE_ENV === 'prod') {
    module.exports = merge(baseWebpackConfig, {
        mode: 'production',
        optimization: {
            minimizer: [
                new TerserPlugin({
                    test: /(\.jsx|\.js)$/,
                    extractComments: true,
                    cache: true,
                    parallel: true,
                    sourceMap: true, // Must be set to true if using source-maps in production
                    terserOptions: {
                        // https://github.com/webpack-contrib/terser-webpack-plugin#terseroptions
                    }
                }),
            ],
            minimize: false,
            splitChunks: {
                chunks: 'async',
                minSize: 30000,
                // minRemainingSize: 0,  // webpack 5
                maxSize: 0,
                // minSize: 0,
                minChunks: 1,
                maxAsyncRequests: 50,
                maxInitialRequests: 30,
                name: true,
                automaticNameDelimiter: '~',
                automaticNameMaxLength: 30,
                cacheGroups: {
                    vendors: {
                        test: /[\\/]node_modules[\\/]/,
                        priority: -1,
                        chunks: 'all',
                        name: 'vendors',
                        // reuseExistingChunk: true,
                        enforce:true
                    },
                    easyui: {
                        test: path.resolve(__dirname, './src/assets/libs/jquery-easyui'),
                        priority: -5,
                        chunks: 'initial',
                        name: 'easyui'
                    },
                    echarts: {
                        test: path.resolve(__dirname, './src/assets/libs/echarts'),
                        priority: -6,
                        chunks: 'initial',
                        name: 'echarts'
                    },
                    assets: {
                        test: path.resolve(__dirname, './src/assets'),
                        priority: -10,
                        chunks: 'all',
                        name: 'assets'
                    }
                }
            }
        },
        plugins: [
            new HashOutput(),
            new CleanWebpackPlugin(),
            // new CleanWebpackPlugin(['dist']),
            // 压缩css
            new OptimizeCssAssetsPlugin({ // 压缩css
                cssProcessorOptions: {
                    safe: true
                }
            }),
            // new webpack.NamedModulesPlugin(),
            new webpack.BannerPlugin('CopyRight © 2015-2028 All Right Reserved Today Technology Co.,Ltd'),
            // 生成包依赖图
            new BundleAnalyzerPlugin({ analyzerPort: 8787 }),
            // 打包进度
            new ProgressBarPlugin(),
        ],
        // 抽离第三方库
        // externals: [
        //     {
        //         // String
        //         react: 'react',
        //         // Object
        //         lodash : {
        //             commonjs: 'lodash',
        //             amd: 'lodash',
        //             root: '_' // indicates global variable
        //         },
        //         // Array
        //         subtract: ['./math', 'subtract']
        //     },
        //     // Function
        //     function(context, request, callback) {
        //         if (/^yourregex$/.test(request)){
        //             return callback(null, 'commonjs ' + request);
        //         }
        //         callback();
        //     },
        //     // Regex
        //     /^(jquery|\$)$/i
        // ],

    });
} else if (process.env.NODE_ENV === 'dev') {
    module.exports = merge(baseWebpackConfig, {
        mode: 'development',
        plugins: [
            new webpack.HotModuleReplacementPlugin(),
            new webpack.NoEmitOnErrorsPlugin(),
            new webpack.NamedModulesPlugin()
        ],
        devtool: 'eval-source-map',
        devServer: {
            inline: true,
            open: true, // 自动打开浏览器
            contentBase: path.join(__dirname, 'dist'),
            openPage: 'login.html',
            publicPath: '',
            compress: true,
            progress: true,
            // index: '', // specify to enable root proxying
            hot: true,
            host: 'localhost', // 0.0.0.0 localhost
            port: 8888,
            overlay: {
                warnings: false,
                errors: true
            },
            // before(app) {
            //     app.get('/test/get', function(req, res){
            //
            //         res.json({ get: 'response get' });
            //
            //     });
            // },
            proxy: {
                '/api': {
                    target: 'http://localhost:8081/services/portalInterface',
                    changeOrigin: true,
                    // localAddress: 'localhost:8081',
                    toProxy: true,
                     // pathRewrite: {"^/api": ""} // 将/api重写为""空字符串
                },
                '/statistics': {
                    target: 'http://jian.mam.miguvideo.com:48080/api/statistic',
                    changeOrigin: true,
                    // localAddress: 'localhost:8081',
                    toProxy: true,
                    // pathRewrite: {"^/api": ""} // 将/api重写为""空字符串
                    bypass: function(req, res, proxyOptions) {
                        // if (req.headers && req.headers.referer) {
                        //     url = new URL(req.headers.referer);
                        //     url.host = 'jian.mam.miguvideo.com';
                        //     url.port = '48080';
                        //     req.headers.referer = url.href;
                        // }

                        // if (req.headers.accept.indexOf('html') !== -1) {
                        //     console.log('Skipping proxy for browser request.');
                        //     return '/index.html';
                        //
                        //
                        // }
                    }
                },
                // '/js': {
                //     target: 'http://localhost:1818',
                //     changeOrigin: true,
                //     // localAddress: 'localhost:8081',
                //     toProxy: true,
                //     // pathRewrite: {"^/api": ""} // 将/api重写为""空字符串
                // },
            /*    '/admin': {
                    target: 'http://39.107.138.29:1818',
                    changeOrigin: true,
                    // localAddress: 'localhost:8081',
                    toProxy: true,
                    // pathRewrite: {"^/api": ""} // 将/api重写为""空字符串
                },*/
                '/admin': {
                    target: 'http://localhost:1818',
                    changeOrigin: true,
                    // localAddress: 'localhost:8081',
                    toProxy: true,
                    // pathRewrite: {"^/api": ""} // 将/api重写为""空字符串
                }
            }
        }
    });
}
