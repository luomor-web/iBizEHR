iBizEHR是iBiz企业级管理系统群的一个组成部分，iBiz将会把EHR、CRM、EAM、ERP等企业级管理系统群以全新理念、最新技术逐步开源，iBizEHR是开源的第一步。

iBiz企业级管理系统群全面采取中台模式、SpringBoot+VUE前后台分离架构、MDD/MDA全方位建模技术，满足上万级用户的高性能需求，致力于提供高可用度、全业务覆盖的重度开源项目，iBizEHR覆盖了人力资源管理的六大模块。

iBiz致力于提升中国软件软件建设和应用的价值，从业务到技术，从用户到开发者，我们希望iBiz能帮助尽可能多的人：
* 如果你是企业CTO，不仅可以获取运行系统和完整源码，更可获取完整的业务模型，获得系统的实施建设能力和对软件资产的全面管控；
* 如果你是业务或者技术专家，你不仅可以获取全部的业务模型和完整源码，更可获取更强大的自动化实施能力，延伸强者的手臂；
* 如果你是一个初学者，我想从没有一个开源项目可以把最先进的业务和技术全面开放，完整的呈现在你的面前，任你所取。


# 项目总述
* iBizEHR是一套可满足万人应用的高性能人力资源管理软件。
* iBizEHR依托iBiz生产体系，不仅提供源码开放，更可提供EHR全面的业务模型，包括每一个数据实体、每一个服务设计、每一个页面UI、每一个流程模型，源码和业务模型完全对应。
* 通过对人力资源进行分析、规划、实施和调整，最大化企业人力资源的价值，助力企业发展。有兴趣请帮点一下 **Star** 哦！
* **[iBiz开源社区](https://www.ibizlab.cn)**
* **[iBizEHR在线演示-基础管理](http://ehr.ibizlab.cn)**
* **[iBizEHR在线演示-招聘管理](http://ehrpcm.ibizlab.cn)**
* **[iBizEHR在线演示-组织管理](http://ehrorm.ibizlab.cn)**
* **[iBizEHR在线演示-假勤管理](http://ehratt.ibizlab.cn)**
* **[iBizEHR在线演示-人员异动](http://ehrpcm2.ibizlab.cn)**
* **[iBizEHR在线演示-绩效管理](http://ehrpar.ibizlab.cn)**
* **[iBizEHR在线演示-薪酬管理](http://ehrsal.ibizlab.cn)**
* **[iBizEHR在线演示-培训管理](http://ehrtrm.ibizlab.cn)**
* **[iBizEHR在线演示-社保管理](http://ehrsoc.ibizlab.cn)**
* **[iBizEHR解决方案](http://demo.ibizlab.cn/ibizehr)**
* **[iBizEHR训练营](http://demo.ibizlab.cn/ibizehr_practice)**
* **[如何在演示系统中建立Issue](https://gitee.com/ibizlab/iBizEHR/wikis/pages?sort_id=2251813&doc_id=692797)**
* **[iBizEHR配置平台](http://mos.ibizlab.cn/mos/#/common_mosindex/srfkeys=C3D0D486-94AD-402E-A7DF-2E7D431D7C4E)**

* **[更多开源项目](https://gitee.com/ibizlab)**


**建模平台内测申请：[iBiz建模平台内测申请通道](https://gitee.com/ibizlab/iBizEHR/wikis/%E5%BB%BA%E6%A8%A1%E5%B9%B3%E5%8F%B0%E5%86%85%E6%B5%8B%E9%A1%BB%E7%9F%A5?sort_id=2992220)**

**我们给您更多的EHR系统选择：[iBizHumanResources（人力资源管理）](https://gitee.com/ibizlab/iBizHumanResources)**

iBizHumanResources区别于iBizEHR：iBizHumanResources为iBiz商业套件重要组成部分，基于iBiz商业套件针对企业人力资源管理的业务管理系统；iBizEHR为针对企业人力资源管理的独立运行的业务管理系统。


* **欢迎加入iBizEHR交流QQ群：1056401976**

![输入图片说明](https://images.gitee.com/uploads/images/2020/0520/135506_3a2bca15_7580957.png "iBizEHR_QQ.png")


# 业务描述
iBizEHR划分为六大模块:
* 人力资源规划
* 员工关系管理
* 招聘与配置
* 培训与开发
* 绩效管理
* 薪酬福利管理

![输入图片说明](https://images.gitee.com/uploads/images/2020/0513/151506_9b82c34c_1181347.png "iBizEHR业务模块.png")


# 技术框架
**后台技术架构  [参考Wiki文档](https://gitee.com/ibizlab/iBizEHR/wikis/pages?sort_id=2231366&doc_id=692797)**
* 核心框架：Spring Boot
* 持久层框架: Mybatis-plus
* 服务发现：Nacos
* 日志管理：Logback
* 项目管理框架: Maven

**前端技术架构  [参考Wiki文档](https://gitee.com/ibizlab/iBizEHR/wikis/pages?sort_id=2231096&doc_id=692797)**
* 前端MVVM框架：vue.js 2.6.10
* 路由：vue-router 3.1.3
* 状态管理：vue-router 3.1.3
* 国际化：vue-i18n 8.15.3
* 数据交互：axios 0.19.1
* UI框架：element-ui 2.13.0, view-design 4.1.0
* 工具库：qs, path-to-regexp, rxjs
* 图标库：font-awesome 4.7.0
* 引入组件： tinymce 4.8.5
* 代码风格检测：eslint


# 开发环境
* JDK
* Maven
* Node.js
* Yarn
* Vue Cli


# 开源说明
* 本系统100%开源，遵守MIT协议


# 项目部署
* 本地化部署说明   [参考Wiki文档](https://gitee.com/ibizlab/iBizEHR/wikis/pages?sort_id=2234729&doc_id=692797)



# 模型设计
* ER图设计
![输入图片说明](https://images.gitee.com/uploads/images/2020/0513/205626_e5119d6c_1181347.png "ER图设计.png")
* 故事板
![输入图片说明](https://images.gitee.com/uploads/images/2020/0513/210421_a713a5a6_1181347.png "故事板.png")
* 表单设计
![输入图片说明](https://images.gitee.com/uploads/images/2020/0513/210711_0fe1582f_1181347.png "表单设计.png")
* 图表设计
![输入图片说明](https://images.gitee.com/uploads/images/2020/0513/210907_98be8d20_1181347.png "图表设计.png")



# 服务接口
![输入图片说明](https://images.gitee.com/uploads/images/2020/0531/192112_4357bcef_7580957.png "服务接口1.png")
![输入图片说明](https://images.gitee.com/uploads/images/2020/0531/192444_d494ec42_7580957.png "服务接口2.png")


# 系统美图
* 门户首页
![输入图片说明](https://images.gitee.com/uploads/images/2020/0519/093754_d6221095_7370452.png "门户首页.png")
* 员工信息
![输入图片说明](https://images.gitee.com/uploads/images/2020/0519/093820_a3bb8da8_7370452.png "员工信息.png")
* 员工首页
![输入图片说明](https://images.gitee.com/uploads/images/2020/0513/151506_91ff6a43_1181347.png "员工首页.png")
* 招聘信息
![输入图片说明](https://images.gitee.com/uploads/images/2020/0606/164508_6aae40e2_7580957.png "招聘信息.png")


# 捐赠
开源不易，坚持更难！如果您觉得iBizEHR不错，可以捐赠请作者喝杯咖啡~，在此表示感谢^_^。

点击以下链接，将页面拉到最下方点击“捐赠”即可。

[前往捐赠](https://gitee.com/ibizlab/iBizEHR)
