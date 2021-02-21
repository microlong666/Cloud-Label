//如果修改后不生效请清除浏览器缓存后刷新重试
window.eruptSiteConfig = {
    //erupt接口地址，在前后端分离时指定
    domain: "",
    //附件地址，一般情况下不需要指定，如果自定义对象存储空间，则需在此指定附件资源访问地址
    fileDomain: "",
    //标题
    title: "Cloud Label",
    //描述
    desc: "一站式电子标签云管理平台",
    //高德地图api key,使用地图组件须指定此属性，amapKey获取地址：https://lbs.amap.com
    amapKey: "6ba79a8d6ba79a8d",
    //logo路径
    logoPath: "erupt.svg",
    //logo文字
    logoText: "CloudLabel",
    //是否开启路由复用
    routerReuse: true,
    //自定义导航栏按钮，配置后将会出现在页面右上角
    r_tools: [{
        text: "在 GitHub 上查看",
        icon: "fa-github",
        mobileHidden: true,
        click: function () {
            window.open("https://github.com/microlong666/Cloud-Label")
        }
    }]
};