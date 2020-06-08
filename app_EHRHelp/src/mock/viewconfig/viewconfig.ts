import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "pimqualtypepickupview": {
            "title": "执业资格类别数据选择视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMQUALTYPEPickupView",
            "viewtag": "008718d499f309da8c98bde30329f513"
        },
        "pimeducationgrpimedugridview": {
            "title": "教育信息表格视图",
            "caption": "教育信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEDUCATIONGRPimEduGridView",
            "viewtag": "0381f5daeb17f3c1f499e56ec297fc33"
        },
        "pimgwtypegridview": {
            "title": "岗位类型对照表表格视图",
            "caption": "岗位类型对照表",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMGWTYPEGridView",
            "viewtag": "08cf11562e14b8fc5defd81353ccfc7b"
        },
        "pimpersongrzhzceditview": {
            "title": "证书信息编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONGRZHZCEditView",
            "viewtag": "0c0779e60a7602a2adf535e82704ed05"
        },
        "ormdutyorgsectorpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMDUTYOrgSectorPickupView",
            "viewtag": "0c36b92aa2b669bef744692b2314f70d"
        },
        "vacleavedetailjhqjmx_editview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VacLeaveDetailJHQJMX_EditView",
            "viewtag": "0f731a857ff34f575337c534880d7743"
        },
        "pimrewardpunishmentgrpimjanglgridview": {
            "title": "奖励惩罚表格视图",
            "caption": "奖惩信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMREWARDPUNISHMENTGRPimJanglGridView",
            "viewtag": "101f36644e505d91300c1d0f914a6fb3"
        },
        "vacleavemanageytgeditview": {
            "title": "请假管理",
            "caption": "请假管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEMANAGEYTGEditView",
            "viewtag": "11867fa6541f59b9913dcbe1a959e23b"
        },
        "pimmajorsetypeeditview": {
            "title": "专业序列类型编辑视图",
            "caption": "专业序列类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMMAJORSETYPEEditView",
            "viewtag": "1395ab68e08f746c2fa9b0830503423d"
        },
        "pimachievementsgrpimjixgridview": {
            "title": "绩效信息表格视图",
            "caption": "绩效信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMACHIEVEMENTSGRPimJixGridView",
            "viewtag": "13c485c96cbc38055b4a81363aad8049"
        },
        "vacleavedetailsjqjmx_editview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEDETAILSJQJMX_EditView",
            "viewtag": "14f8499b1252ace2a37fbc566e81bd29"
        },
        "pimmajorsetypegridview": {
            "title": "专业序列类型表格视图",
            "caption": "专业序列类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMMAJORSETYPEGridView",
            "viewtag": "16d67f7d7d79822fb62b241ab2abf1b7"
        },
        "pimtitlecataloguegridview": {
            "title": "职称目录管理表格视图",
            "caption": "职称目录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMTITLECATALOGUEGridView",
            "viewtag": "17a23f765c0504cdf0f07f96794b6715"
        },
        "pimqualtypepickupgridview": {
            "title": "执业资格类别选择表格视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMQUALTYPEPickupGridView",
            "viewtag": "1894993663d83e5135955b8f9bf09953"
        },
        "pimtitlecataloguepickupview": {
            "title": "职称目录管理数据选择视图",
            "caption": "职称目录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMTITLECATALOGUEPickupView",
            "viewtag": "1a55612e2b968838cd2774963495d125"
        },
        "pimtitlegreditview": {
            "title": "职称信息编辑视图",
            "caption": "职称信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMTITLEGREditView",
            "viewtag": "1aa41bd8b13187fdf1035288990d5fb3"
        },
        "pimqualmajorgridview": {
            "title": "执业资格专业",
            "caption": "执业资格专业",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMQUALMAJORGridView",
            "viewtag": "1b230be239196f534e71742d41a27004"
        },
        "pimgwtypeeditview2": {
            "title": "岗位类型对照表编辑视图",
            "caption": "岗位类型对照表",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "Shp",
            "viewname": "PIMGWTYPEEditView2",
            "viewtag": "1f4a9d2fb094d190fc7f62b638058752"
        },
        "pimresearchfindingsgreditview": {
            "title": "科研成果编辑视图",
            "caption": "科研成果",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMRESEARCHFINDINGSGREditView",
            "viewtag": "1fa2e31993185c35bc914a39ede37e1b"
        },
        "pimfaminfogreditview": {
            "title": "家庭情况编辑视图",
            "caption": "家庭情况",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMFAMINFOGREditView",
            "viewtag": "2032ea08c1256e8fe0d5c1a580115b3d"
        },
        "questionsyh_checkeditview": {
            "title": "用户查看表单",
            "caption": "问题收集",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "QUESTIONSYH_CheckEditView",
            "viewtag": "22927e3e256fe74ec2bccb549b0d6071"
        },
        "pimmajorsetypepickupview": {
            "title": "专业序列类型数据选择视图",
            "caption": "专业序列类型",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMMAJORSETYPEPickupView",
            "viewtag": "2348b2374d19f22a7aa8754ec5cfb3a1"
        },
        "pimexitandentryeditview_ng": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYEditView_NG",
            "viewtag": "24a75afb38af6db6c5b5ec5352599219"
        },
        "pimexitandentryeditview_ybh": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYEditView_YBH",
            "viewtag": "25292afea61d4ed12d14a9068cdfd3fa"
        },
        "archivalcataloguepickupgridview": {
            "title": "档案目录选择表格视图",
            "caption": "档案目录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ARCHIVALCATALOGUEPickupGridView",
            "viewtag": "28092ec40a62fc4dd76a8ba4618f8cf0"
        },
        "pimtitlecataloguenotpickupgridview": {
            "title": "职称目录管理选择表格视图",
            "caption": "职称目录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMTITLECATALOGUENotPickupGridView",
            "viewtag": "2b08f3156ac69641440614a50d023590"
        },
        "vacleavemanagexjeditview": {
            "title": "销假",
            "caption": "销假",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEMANAGEXJEditView",
            "viewtag": "2be99c3cf13e616ace5bb131ef4652f5"
        },
        "ormorgypzsyfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGYPZSYFPXXPickupView",
            "viewtag": "2e62b6d331f2ea2524288401fd4d01e8"
        },
        "ormsignorgbdwpickupview": {
            "title": "注册单位选择",
            "caption": "注册单位选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "OrmSignOrgBDWPickupView",
            "viewtag": "2f0b3a36dc6866bde5841041eca8649f"
        },
        "archivescenterpickupview": {
            "title": "档案室管理数据选择视图",
            "caption": "档案室管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ARCHIVESCENTERPickupView",
            "viewtag": "311ca5845e5160283a21d4d2b70f55ad"
        },
        "pimfaminfogrpimfimgridview": {
            "title": "家庭情况表格视图",
            "caption": "家庭情况",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMFAMINFOGRPimfimGridView",
            "viewtag": "3314b53b31b1a65581eb64c278b11166"
        },
        "pimgwtypepickupgridview": {
            "title": "岗位类型",
            "caption": "岗位类型",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMGWTYPEPickupGridView",
            "viewtag": "33a76312dc62fbb9fbf6fb6a986c00ef"
        },
        "pimexitandentrywfproxyresultview": {
            "title": "出入境管理工作流结果视图",
            "caption": "出入境管理",
            "viewtype": "DEWFPROXYRESULTVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYWFProxyResultView",
            "viewtag": "33adfb3e9d5747d7b8fb9efd5872b013"
        },
        "pimexitandentryeditview_yqx": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYEditView_YQX",
            "viewtag": "363952e74a4876225b303bdf0f2f17ff"
        },
        "archivalcataloguegridview": {
            "title": "档案类别表格视图",
            "caption": "档案目录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ARCHIVALCATALOGUEGridView",
            "viewtag": "36a52329f69c839ae83e4e7f41dbb062"
        },
        "pimqualtypegridview": {
            "title": "岗位（技能）证书别表格视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMQUALTYPEGridView",
            "viewtag": "3b5a81d912919af9e0d4ab704f19b813"
        },
        "pimexitandentrywfeditview": {
            "title": "补充信息",
            "caption": "补充信息",
            "viewtype": "DEWFEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYWFEditView",
            "viewtag": "3e1d12b9ae1bf2020d5552f4ed57ea9b"
        },
        "pimqualmajorpickupgridview": {
            "title": "执业资格专业选择表格视图",
            "caption": "执业资格专业",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMQUALMAJORPickupGridView",
            "viewtag": "41d820670ae95c9a8be99532979e1ee1"
        },
        "ormorgsectorydbmpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGSECTORYDBMPickupGridView",
            "viewtag": "43df43f52566487f90d228cb199a78d4"
        },
        "attendencesetupkqbpickupgridview": {
            "title": "考勤设置选择表格视图",
            "caption": "考勤设置",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ATTENDENCESETUPKQBPickupGridView",
            "viewtag": "45966cb93d8366c9c2ea7a09a1cb2bb8"
        },
        "pimarmycadresgrarmygridview": {
            "title": "军转干部表格视图",
            "caption": "军转干部",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARMYCADRESGRARMYGridView",
            "viewtag": "4668af609fb63607ee49e3b93210ff6b"
        },
        "pimarchivesrecordgridview": {
            "title": "档案目录缺失记录表格视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESRECORDGridView",
            "viewtag": "471a9efa0b61157afe1fd08d1f2ac022"
        },
        "pimtitlecataloguenotpickupview": {
            "title": "职称目录管理数据选择视图",
            "caption": "职称目录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMTITLECATALOGUENotPickupView",
            "viewtag": "49f353b92646fdf07927269db352e288"
        },
        "pimdistirbutiongrpimfenpgridview": {
            "title": "分配信息表格视图",
            "caption": "分配信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PimDistirbutionGRPImFenpGridView",
            "viewtag": "4bfac398a112a783a48db95e77335987"
        },
        "pimpatentgreditview": {
            "title": "专利信息编辑视图",
            "caption": "专利信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPATENTGREditView",
            "viewtag": "4eb64fa1062180d016cb0503d77565f4"
        },
        "shenqingmenu": {
            "title": "应用数据看板视图",
            "caption": "我的申请",
            "viewtype": "APPPORTALVIEW",
            "viewmodule": "Shp",
            "viewname": "ShenqingMenu",
            "viewtag": "4f2ae15c5693d3b23d47ade773b40665"
        },
        "pimarchiveschangegridview": {
            "title": "调档记录表格视图",
            "caption": "调档记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESCHANGEGridView",
            "viewtag": "50c4c9e1e32c2f7c8f8b9fa44c2d39ce"
        },
        "ormorgfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGFPXXPickupView",
            "viewtag": "55b84f79795f0633332fc5f2e87705d8"
        },
        "pcmrcxlgridview": {
            "title": "人才序列表格视图",
            "caption": "人才序列",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PCMRCXLGridView",
            "viewtag": "56535ad1c19199e2594954b3ac9bada1"
        },
        "pimarmycadresgreditview": {
            "title": "军转干部编辑视图",
            "caption": "军转干部",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARMYCADRESGREditView",
            "viewtag": "57be995a9006a6533352630814a8be63"
        },
        "pimtitlegrpimzhicgridview": {
            "title": "职称信息表格视图",
            "caption": "职称信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMTITLEGRPimZhicGridView",
            "viewtag": "57ec9f3986f46390ea3a5758a56efbf9"
        },
        "pimpersonkqjrypickupview": {
            "title": "选择请假人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONKQJRYPickupView",
            "viewtag": "5a19a58e9941cb2b0e4f3a6c174cbd45"
        },
        "vacleavemanageygzzgridview": {
            "title": "休假申请",
            "caption": "休假申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEMANAGEYGZZGridView",
            "viewtag": "5bfc1e915d05e3e6fd7dc0694aa9d26c"
        },
        "pimexitandentrywfproxystartview": {
            "title": "流程启动",
            "caption": "流程启动",
            "viewtype": "DEWFPROXYSTARTVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYWFProxyStartView",
            "viewtag": "6133c2a1b8ce0c2aaeff67d8f1d6d7d8"
        },
        "questionseditview": {
            "title": "问题收集编辑视图",
            "caption": "问题收集",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "QUESTIONSEditView",
            "viewtag": "61daa649ca5305c2437224d030618eeb"
        },
        "pimqualmajorpickupview": {
            "title": "执业资格专业数据选择视图",
            "caption": "执业资格专业",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMQUALMAJORPickupView",
            "viewtag": "663516854d75d31845cf72d601715b33"
        },
        "ormdutyormorgsectorpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMDUTYOrmOrgSectorPickupView",
            "viewtag": "66d9ab2de7e9208dfca94b86c74947ed"
        },
        "pimpersongrxscgeditview": {
            "title": "学术成果编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONGRXSCGEditView",
            "viewtag": "681af33140cd7bd6e18443429441ed59"
        },
        "attendencesetupkqbypickupview": {
            "title": "考勤设置数据选择视图",
            "caption": "考勤设置",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ATTENDENCESETUPKQBYPickupView",
            "viewtag": "687543f7f197e4ff7b20002375aee54a"
        },
        "ormpostejormorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMPOSTEJORMORGIDPickupView",
            "viewtag": "69e796a8fe7fc64748720f005dec0377"
        },
        "ormsignorghtqddwwpickupview": {
            "title": "合同签订单位选择",
            "caption": "合同签订单位选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "OrmSignOrgHTQDDWWPickupView",
            "viewtag": "6a4a031e1595b20ef30fee4c9c90dc31"
        },
        "pimdistirbutiongrdividereditview": {
            "title": "分配信息编辑视图",
            "caption": "分配信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PimDistirbutionGRDividerEditView",
            "viewtag": "6afa61d020d536cac86d31e8276b6e36"
        },
        "pimexitandentryformpickupview": {
            "title": "出入境管理数据选择视图",
            "caption": "出入境管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYFormPickupView",
            "viewtag": "6b4343785d96d91df5085d7821b3927e"
        },
        "chaxunmenu": {
            "title": "应用数据看板视图",
            "caption": "我的查询",
            "viewtype": "APPPORTALVIEW",
            "viewmodule": "Shp",
            "viewname": "ChaxunMenu",
            "viewtag": "6b8cffba8e27e9c835f88e9133eb1bec"
        },
        "pimexitandentrywfeditview9": {
            "title": "出入境管理工作流嵌入视图",
            "caption": "出入境管理",
            "viewtype": "DEWFEDITVIEW9",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYWFEditView9",
            "viewtag": "6cda79a997d48450a54b02232f43a0a4"
        },
        "pimarchivesrecordeditview": {
            "title": "档案目录缺失记录编辑视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESRECORDEditView",
            "viewtag": "6ef9aa94fd4e86a60d46d29c6b229b20"
        },
        "pimexitandentryeditview_ytg": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYEditView_YTG",
            "viewtag": "6f7de06858117c06c5f802534983dbc8"
        },
        "pimtitlecataloguepickupgridview": {
            "title": "职称目录管理选择表格视图",
            "caption": "职称目录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMTITLECATALOGUEPickupGridView",
            "viewtag": "714673632df2fc6df82f1e5b30214e1a"
        },
        "pimexitandentryygzzgridview": {
            "title": "出入境管理实体表格视图（员工自助）",
            "caption": "出（国）境申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYYGZZGridView",
            "viewtag": "71745cf2abffaef1c6df14d241ffb2d8"
        },
        "ormpostorgidpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMPOSTORGIDPickupGridView",
            "viewtag": "71c01ca8cc2c1fedee751b1ada56fe2c"
        },
        "archivalcataloguepickupview": {
            "title": "档案目录数据选择视图",
            "caption": "档案目录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ARCHIVALCATALOGUEPickupView",
            "viewtag": "71c91199b831ae7a2fd84b3dbfdfe13f"
        },
        "ormorgxmbqpickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "OrmOrgXMBQPickupGridView",
            "viewtag": "71e85e533ce5c0c7f918c04040087bc4"
        },
        "ormorgxmbqpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGXMBQPickupView",
            "viewtag": "730cd6493e6f09f5faeaf33356883f45"
        },
        "ormsignorgbdwpickupgridview": {
            "title": "注册单位选择",
            "caption": "注册单位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "OrmSignOrgBDWPickupGridView",
            "viewtag": "74ddd2e3b3708c24cb75e7bea4e06404"
        },
        "pimarchivesgrpimdangagridview": {
            "title": "档案信息表格视图",
            "caption": "档案信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESGRPimDangaGridView",
            "viewtag": "766f929bbf90b24ccc6802900ad5fab4"
        },
        "questionscurrentquestionsgridview": {
            "title": "本页问题表格",
            "caption": "问题收集",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "QUESTIONSCurrentQuestionsGridView",
            "viewtag": "7914abb3b075bd414eaf7991771b8df9"
        },
        "vacleavemanagengeditview": {
            "title": "请假管理",
            "caption": "请假管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VacLeaveManageNGEditView",
            "viewtag": "792e12b2f40584136a4c6643c87ee9d7"
        },
        "pimgwtyperedirectview": {
            "title": "岗位类型对照表数据重定向视图",
            "caption": "岗位类型对照表",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMGWTYPERedirectView",
            "viewtag": "7abea2acebecb0898fdb435131b8b30b"
        },
        "pimgwtypeeditview": {
            "title": "岗位类型对照表编辑视图",
            "caption": "岗位类型对照表",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMGWTYPEEditView",
            "viewtag": "827abc9cb1813e8df244c902de18d8b9"
        },
        "vacleavedetailjhqjmx_ck_editview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEDETAILJHQJMX_CK_EditView",
            "viewtag": "83686d68de58d2cc4092599680525ece"
        },
        "vacleavemanageyqxeditview": {
            "title": "请假管理",
            "caption": "请假管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEMANAGEYQXEditView",
            "viewtag": "849a9c99197d52f730adb4d70edcdb46"
        },
        "pimpersontxrypickupview": {
            "title": "选择退休人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONTXRYPickupView",
            "viewtag": "86a48dbc7931f0d156f96f862264315b"
        },
        "ormorgsectorydbmpickupview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGSECTORYDBMPickupView",
            "viewtag": "8a0a5f8d350ff1c38b819cafcb657140"
        },
        "pimpersonpickupview": {
            "title": "人员信息数据选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONPickupView",
            "viewtag": "8a2817e2bb850dfb10add4a01de30f80"
        },
        "ormorgsectorfpxxpickupview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGSECTORFPXXPickupView",
            "viewtag": "8b00e8857e6fb067d185d133c2e7059e"
        },
        "archivescenterpickupgridview": {
            "title": "档案室管理选择表格视图",
            "caption": "档案室管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ARCHIVESCENTERPickupGridView",
            "viewtag": "8b5a33843c0bec1f17766e1fdd1b249d"
        },
        "vacleavedetailjhqjmx_gridview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "VacLeaveDetailJHQJMX_GridView",
            "viewtag": "8bcc6b59d8eb2a403ab018d9a9f42a9f"
        },
        "vacleavemanageybheditview": {
            "title": "请假管理",
            "caption": "请假管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEMANAGEYBHEditView",
            "viewtag": "8dac134de81ebe22b4c2f462c8c6eb3e"
        },
        "pimvocationalgrpimziggridview": {
            "title": "证书信息表格视图",
            "caption": "证书信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMVOCATIONALGRPimZigGridView",
            "viewtag": "8dad9b1569e0c57b455b03c77c6030d0"
        },
        "pimachievementseditview": {
            "title": "绩效信息编辑视图",
            "caption": "绩效信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMACHIEVEMENTSEditView",
            "viewtag": "8f514cf629904a6692ca3431a101b850"
        },
        "pcmrcxleditview": {
            "title": "人才序列设置",
            "caption": "人才序列设置",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PCMRCXLEditView",
            "viewtag": "9160db3333a985e98853bdcfcfe5e07c"
        },
        "pimqualtypeeditview": {
            "title": "岗位（技能）证书编辑视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMQUALTYPEEditView",
            "viewtag": "937d14ed55bc4764286f15b2c4c221fc"
        },
        "pimpatentgrpatentgridview": {
            "title": "专利信息表格视图",
            "caption": "专利信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPATENTGRPATENTGridView",
            "viewtag": "940fc200799331fea59fb89973f1d281"
        },
        "pimarchivesgreditview": {
            "title": "档案信息编辑视图",
            "caption": "档案信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESGREditView",
            "viewtag": "9569255e78b1a27e32a605184fa1918e"
        },
        "ormsignorghtqddwpickupgridview": {
            "title": "合同签订单位选择",
            "caption": "合同签订单位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "OrmSignOrgHTQDDWPickupGridView",
            "viewtag": "9a3d492025eb18989577e6ac1ec38d67"
        },
        "pimrewardpunishmentgreditview": {
            "title": "奖励惩罚编辑视图",
            "caption": "奖惩信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMREWARDPUNISHMENTGREditView",
            "viewtag": "9ad84d63471935d53313e5981f88fe63"
        },
        "pimexitandentrywfactionview": {
            "title": "出入境管理工作流操作视图",
            "caption": "出入境管理",
            "viewtype": "DEWFACTIONVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYWFActionView",
            "viewtag": "9e53e1de3e68a75b0b6b6ee9ee1b351f"
        },
        "ormpostejormorgidpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMPOSTEJORMORGIDPickupGridView",
            "viewtag": "a2152f7dfaee0a7333ff9c4012d9b920"
        },
        "pimworkhistorygrpimworkgridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMWORKHISTORYGRPimWorkGridView",
            "viewtag": "a27997a7ab6cfbcecdeb079e81422d1f"
        },
        "pimarchivesloanandreturngridview": {
            "title": "借阅记录表格视图",
            "caption": "借阅记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESLOANANDRETURNGridView",
            "viewtag": "a312b0a9771b834c87f8f0f328276d48"
        },
        "pimeducationgreditview": {
            "title": "教育信息编辑视图",
            "caption": "教育信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEDUCATIONGREditView",
            "viewtag": "a35d53d794e229e9012b26dac5268034"
        },
        "vacleavemanagespzeditview": {
            "title": "请假管理",
            "caption": "请假管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEMANAGESPZEditView",
            "viewtag": "a35f924ce2c0826b5a452639e5531012"
        },
        "pcmrcxlpickupgridview": {
            "title": "人才序列选择表格视图",
            "caption": "人才序列",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PCMRCXLPickupGridView",
            "viewtag": "a4214002a10c65eef11446a17447107c"
        },
        "pcmrcxlpickupview": {
            "title": "人才序列数据选择视图",
            "caption": "人才序列",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PCMRCXLPickupView",
            "viewtag": "a8e865c43c3119d16b4adb58c1498539"
        },
        "pimcontractgrcontracteditview": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMCONTRACTGRContractEditView",
            "viewtag": "aa1d98345f845c6bae1d129cd4de751b"
        },
        "pimtitlecatalogueeditview": {
            "title": "职称目录管理编辑视图",
            "caption": "职称目录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMTITLECATALOGUEEditView",
            "viewtag": "acb578ed352d851b81b64e745cc237eb"
        },
        "pimpapergrpapergridview": {
            "title": "论文信息表格视图",
            "caption": "论文信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPAPERGrPAPERGridView",
            "viewtag": "b400171da8f193d395641c45ecb8d568"
        },
        "ormorgsectorfpxxpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGSECTORFPXXPickupGridView",
            "viewtag": "b60fd68d90c098f45a3cc37613d0322a"
        },
        "questionsgridview": {
            "title": "问题收集表格视图",
            "caption": "问题收集",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "QUESTIONSGridView",
            "viewtag": "b727c68d42dc0c66afa800d0b0936e7a"
        },
        "vacleavedetailjhqjmx_ck_gridview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEDETAILJHQJMX_CK_GridView",
            "viewtag": "b7bde6adb20c2ff22ff8005d941e91de"
        },
        "ormdutyorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMDUTYOrgSectorPickupGridView",
            "viewtag": "b7ce0b1b00698891bf19385cb04f687c"
        },
        "ormorgfpxxpickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGFPXXPickupGridView",
            "viewtag": "b9b5316fe51246dd5a98586025ffc502"
        },
        "pimgwtypempickupview": {
            "title": "岗位类型",
            "caption": "岗位类型",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMGWTYPEMPickupView",
            "viewtag": "ba4e5958216f6627a3b810b3c3c612ef"
        },
        "index": {
            "title": "员工自助",
            "caption": "员工自助",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "Shp",
            "viewname": "index",
            "viewtag": "bc5382555aeebd3973a2efddc1762e35"
        },
        "pimvocationalgreditview": {
            "title": "证书信息编辑视图",
            "caption": "证书信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMVOCATIONALGREditView",
            "viewtag": "bd4420b3b2d9f07affedbf6c37a4a94f"
        },
        "pimresearchfindingsgrresearchgridview": {
            "title": "科研成果表格视图",
            "caption": "科研成果",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMRESEARCHFINDINGSGRRESEARCHGridView",
            "viewtag": "bfcf94c7a9b500349ebc8ba0beb70159"
        },
        "vacleavedetailsjqjmx_ck_editview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEDETAILSJQJMX_CK_EditView",
            "viewtag": "c0153c4f6c573b038a6f44c5c250529a"
        },
        "pimqualmajoreditview": {
            "title": "执业资格专业",
            "caption": "执业资格专业",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMQUALMAJOREditView",
            "viewtag": "c117760119e966e0765f5ee89528d2ee"
        },
        "pimexitandentryeditview_spz": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMEXITANDENTRYEditView_SPZ",
            "viewtag": "c19efad192874c560309ef84e50a15c0"
        },
        "ormdutyormorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMDUTYOrmOrgSectorPickupGridView",
            "viewtag": "c3d7a8b8af6434c1da6d0e0d223ebad0"
        },
        "pimpersonkqjrypickupgridview": {
            "title": "请假人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONKQJRYPickupGridView",
            "viewtag": "c65ab5ee258cd28e525d4de6500d4fac"
        },
        "pimpersontxrypickupgridview": {
            "title": "退休人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONTXRYPickupGridView",
            "viewtag": "c94655e1a8854a9d3e573328a9f5b1ac"
        },
        "ormorgsectorpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "OrmOrgsectorPickupGridView",
            "viewtag": "cb61afa314a0a29770f90e3972a03de0"
        },
        "pimlanguageabilitygryynlgridview": {
            "title": "语言能力表格视图",
            "caption": "语言能力",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMLANGUAGEABILITYGRYYNLGridView",
            "viewtag": "cd0b6c276c4cb5a0d32d1ffa5d4c3852"
        },
        "ormorghtgldwpickupview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGHTGLDWPickupView",
            "viewtag": "cd39ffab1fd9504de5d831382ae725f1"
        },
        "questionsdev_checkeditview": {
            "title": "开发者查看表单",
            "caption": "问题收集",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "QUESTIONSDev_CheckEditView",
            "viewtag": "d0fce621491e76429d9d193c3a709f48"
        },
        "pimarchiveseditview": {
            "title": "档案信息编辑视图",
            "caption": "档案信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESEditView",
            "viewtag": "d7fde92b9fdcee757dba8d32d387ea25"
        },
        "ormorghtgldwqpickupgridview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGHTGLDWQPickupGridView",
            "viewtag": "d923779ec6ee471bcc559dc582b716d9"
        },
        "pimpersonpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONPickupGridView",
            "viewtag": "dc03e83df99dc805b73c0f9181572a62"
        },
        "pimworkhistorygreditview": {
            "title": "工作履历编辑视图",
            "caption": "工作履历",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMWORKHISTORYGREditView",
            "viewtag": "dd6b082a3d33315bc205b86369ded6f4"
        },
        "pimlanguageabilitygreditview": {
            "title": "语言能力编辑视图",
            "caption": "语言能力",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMLANGUAGEABILITYGREditView",
            "viewtag": "dfbabc9f4c755d80386a1c5b6c67f907"
        },
        "pimmajorsetypepickupgridview": {
            "title": "专业序列类型选择表格视图",
            "caption": "专业序列类型",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMMAJORSETYPEPickupGridView",
            "viewtag": "e29c8100dc12cb3d7d53ca7a2998886c"
        },
        "pimpersongrzzeditview": {
            "title": "个人信息编辑视图",
            "caption": "基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPERSONGRZZEditView",
            "viewtag": "ecb6b8273853b96079b84245e8a2a4a6"
        },
        "archivalcatalogueeditview": {
            "title": "档案类别编辑视图",
            "caption": "档案目录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "ARCHIVALCATALOGUEEditView",
            "viewtag": "ece405129cd538118496ca95ccc8556a"
        },
        "vacleavedetailsjqjmx_ck_gridview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEDETAILSJQJMX_CK_GridView",
            "viewtag": "edd151ee6faa6806d346d2a96d2dce5e"
        },
        "ormpostorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMPOSTORGIDPickupView",
            "viewtag": "ee5c1e444c7f21c632920128924907b9"
        },
        "ormorgypzxxsypickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "ORMORGYPZXXSYPickupGridView",
            "viewtag": "ef2da28079b4937d887c8afd7044de3e"
        },
        "pimarchiveschangeeditview": {
            "title": "档案归档地变更记录编辑视图",
            "caption": "档案归档地变更记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESCHANGEEditView",
            "viewtag": "f30243e3909c9dabf83c513fc71278af"
        },
        "pimarchivesloanandreturneditview": {
            "title": "档案借阅及归还记录编辑视图",
            "caption": "档案借阅及归还记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMARCHIVESLOANANDRETURNEditView",
            "viewtag": "f66418edcffccccde4209412dab02987"
        },
        "pimgwtypepickupview": {
            "title": "岗位类型",
            "caption": "岗位类型",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMGWTYPEPickupView",
            "viewtag": "f72fbaf08bab143c47b00dce1f14fd13"
        },
        "pimpapergreditview": {
            "title": "论文信息编辑视图",
            "caption": "论文信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMPAPERGREditView",
            "viewtag": "f7871bd47b05f40c765241c34b118f34"
        },
        "pimcontractgrcontractgridview": {
            "title": "合同信息表格视图",
            "caption": "合同信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "PIMCONTRACTGRContractGridView",
            "viewtag": "fcc2d91b5309470d632f56c66938be02"
        },
        "vacleavedetailsjqjmx_gridview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "Shp",
            "viewname": "VACLEAVEDETAILSJQJMX_GridView",
            "viewtag": "fed14324e88f2e47f5fb67c1192ba27f"
        },
        "xinximenu": {
            "title": "应用数据看板视图",
            "caption": "我的信息",
            "viewtype": "APPPORTALVIEW",
            "viewmodule": "Shp",
            "viewname": "XinxiMenu",
            "viewtag": "fffe4b621ccaf6f135bdd74cf6c1675b"
        }
    }];
});