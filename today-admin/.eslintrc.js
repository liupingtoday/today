module.exports = {
  env: {
    browser: true,
    es6: true,
  },
  extends: [
    'airbnb-base',
  ],
  globals: {
    document: true,
    localStorage: true,
    window: true,
    Atomics: 'readonly',
    SharedArrayBuffer: 'readonly',
    // 这里填入你的项目需要的全局变量
    // 这里值为 false 表示这个全局变量不允许被重新赋值，比如：
    jQuery: false,
    $: false
  },
  parserOptions: {
    ecmaVersion: 2018,
    sourceType: 'module',
  },
  // add your custom rules here
  // 下面这些rules是用来设置从插件来的规范代码的规则，使用必须去掉前缀eslint-plugin-
  // 主要有如下的设置规则，可以设置字符串也可以设置数字，两者效果一致
  // "off" -> 0 关闭规则
  // "warn" -> 1 开启警告规则
  //"error" -> 2 开启错误规则
  rules: {
    // 自定义的规则
    "/src/assets/libs": "off",
    // allow async-await
    'generator-star-spacing': 'off',
    "no-new": "off", // 允许直接new一个对象而不赋值
    // "no-debugger": "off", // 允许使用debugger
    // allow debugger during development
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    "no-undef": "off",// 允许使用未定义的变量，因为项目中有许多全局变量，如Utils，Helper
    // @fixable 一个缩进必须用两个空格替代
    'space-before-function-paren': 0, // 在函数左括号的前面是否有空格
    // 关键字后面使用一致的空格
    'keyword-spacing': 0,
    // 三等号
    'eqeqeq': 0,
    // 强制在注释中 // 或 /* 使用一致的空格
    'spaced-comment': 0,
    'eol-last': 0, // 不检测新文件末尾是否有空行
    'semi': ['off', 'always'], // 必须在语句后面加分号
    // "quotes": ["error", "double"],// 字符串没有使用单引号
    "no-console": ["error",{allow:["log","warn"]}],// 允许使用console.log()
    "linebreak-style": [0 ,"error", "windows"],
    // 禁止出现未使用过的变量
    'no-unused-vars': 0,
    // 要求或禁止末尾逗号
    'comma-dangle': 0,
    'indent': ['error',4,{SwitchCase: 1,flatTernaryExpressions: true}] // error类型，缩进4个空格
  },
};
