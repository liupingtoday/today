const baseWebpackConfig = require('./webpack.base.conf');
const webpack = require('webpack');
const path = require('path');
const merge = require('webpack-merge');
const OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');
// const CleanWebpackPlugin = require('clean-webpack-plugin');
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
            minimize: true,
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
            new CleanWebpackPlugin({
                // Simulate the removal of files
                //
                // default: false
                dry: true,

                // Write Logs to Console
                // (Always enabled when dry is true)
                //
                // default: false
                verbose: true,

                // Automatically remove all unused webpack assets on rebuild
                //
                // default: true
                cleanStaleWebpackAssets: false,

                // Do not allow removal of current webpack assets
                //
                // default: true
                protectWebpackAssets: false,

                // **WARNING**
                //
                // Notes for the below options:
                //
                // They are unsafe...so test initially with dry: true.
                //
                // Relative to webpack's output.path directory.
                // If outside of webpack's output.path directory,
                //    use full path. path.join(process.cwd(), 'build/**/*')
                //
                // These options extend del's pattern matching API.
                // See https://github.com/sindresorhus/del#patterns
                //    for pattern matching documentation

                // Removes files once prior to Webpack compilation
                //   Not included in rebuilds (watch mode)
                //
                // Use !negative patterns to exclude files
                //
                // default: ['**/*']
                cleanOnceBeforeBuildPatterns: ['**/*', '!static-files*'],
                cleanOnceBeforeBuildPatterns: [], // disables cleanOnceBeforeBuildPatterns

                // Removes files after every build (including watch mode) that match this pattern.
                // Used for files that are not created directly by Webpack.
                //
                // Use !negative patterns to exclude files
                //
                // default: []
                cleanAfterEveryBuildPatterns: ['static*.*', '!static1.js'],
                // exclude:  ['test.html'], // 排除

                // Allow clean patterns outside of process.cwd()
                //
                // requires dry option to be explicitly set
                //
                // default: false
                dangerouslyAllowCleanPatternsOutsideProject: true,
            }),
            // new CleanWebpackPlugin(['dist']),
            // 压缩css
            new OptimizeCssAssetsPlugin({ // 压缩css
                cssProcessorOptions: {
                    safe: true
                }
            }),
            new HashOutput(),
            new webpack.BannerPlugin('CopyRight © 2015-2028 All Right Reserved Today Technology Co.,Ltd'),
            // 生成包依赖图
            new BundleAnalyzerPlugin({ analyzerPort: 8787 }),
            // 打包进度
            new ProgressBarPlugin(),
        ]
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
            proxy: {
                '/api': {
                    target: 'http://localhost:8081/services/portalInterface',
                    changeOrigin: true,
                    // localAddress: 'localhost:8081',
                    toProxy: true,
                     // pathRewrite: {"^/api": ""} // 将/api重写为""空字符串
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
