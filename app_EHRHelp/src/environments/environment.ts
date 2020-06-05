export const Environment = {
    // 原型示例数模式
    SampleMode: false,
    // 应用名称
    AppName: 'EHRHelp',
    // 应用 title
    AppTitle: 'EHRHELP（员工自助）',
    // 应用基础路径
    BaseUrl: '../',
    // 系统名称
    SysName: 'ehr',
    // 远程登录地址，本地开发调试使用
    RemoteLogin: 'ibizutil/login',
    // 文件导出
    ExportFile: 'ibizutil/download',
    // 文件上传
    UploadFile: 'ibizutil/upload',
    // 是否为pc端应用
    isAppMode: true,
    //统一地址
    uniteAddress: "http://172.16.100.202:8114",
    // 是否为开发模式
    devMode: true,
    // 是否开启权限认证
    enablePermissionValid:false,
    // 项目模板地址
    ProjectUrl: "http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7plus",
    // 配置平台地址
    StudioUrl: "http://neko.org.cn:3333/",
    // 方案标识
    SlnId: "AFFB70EF-A2CF-470A-B1AE-38156EAF4A50",
    // 系统标识
    SysId: "8A26FD38-06D7-495C-88B1-77238F3AB96D",
    // 前端应用标识
    AppId: "0df1f39e51db7152428a905a11c28a16",
    // 项目发布文件地址
    PublishProjectUrl: 'https://oauth2:0fc5b56b52f5ad87efd3850b6536e034@gitee.com/ibizlab/iBizEHR.git',
    // ibiz开放平台地址
    ibizlabtUrl: 'https://www.ibizlab.cn',
    // ibiz论坛地址
    ibizbbstUrl: 'https://bbs.ibizlab.cn',
};
// 挂载外部配置文件
if ((window as any).Environment) {
    Object.assign(Environment, (window as any).Environment);
}