import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "ormpostejormorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位集",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEJORMORGIDPickupView",
            "viewtag": "09de889eff18f3439d11da7604fda3fb"
        },
        "pcmworkresumegzllgridview": {
            "title": "工作履历（要求：带*必填）",
            "caption": "工作履历（要求：带*必填）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMWORKRESUMEGZLLGridView",
            "viewtag": "0a36bba4db0f174309b0dbcd9fbcdb55"
        },
        "pimpersontxrypickupview": {
            "title": "选择退休人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONTXRYPickupView",
            "viewtag": "0b217f6381763746161a9725cee6cafc"
        },
        "ormorgypzxxsypickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGYPZXXSYPickupGridView",
            "viewtag": "128376d374a95b9d98fb658a9d33dc77"
        },
        "testresultcpjggridview": {
            "title": "测评结果摘要信息（要求：带*必填）",
            "caption": "测评结果摘要信息（要求：带*必填）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "TestResultCPJGGridView",
            "viewtag": "3d7985f2b41ff52bea5ebcf3bacc6169"
        },
        "pcmprofilexzwizardview": {
            "title": "校招应聘者信息录入向导",
            "caption": "校招应聘者信息录入向导",
            "viewtype": "DEWIZARDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEXZWizardView",
            "viewtag": "4229f6c634e435919e19f0af081f94e7"
        },
        "pcmprofileypzxx_lrgridview": {
            "title": "应聘者信息",
            "caption": "应聘者信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZXX_LRGridView",
            "viewtag": "43659d36205f0188071e2809bae87960"
        },
        "ormpostejormorgidpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEJORMORGIDPickupGridView",
            "viewtag": "44bf9eda90dffdccfacfac9a8c182e91"
        },
        "pcmschoolofficezxzwgridview": {
            "title": "在校职务（要求：带*必填）",
            "caption": "在校职务（要求：带*必填）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMSCHOOLOFFICEZXZWGridView",
            "viewtag": "56c145537274f073f9b98375809e6010"
        },
        "pcmcertofregeditview": {
            "title": "注册证书编辑视图",
            "caption": "注册证书",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMCERTOFREGEditView",
            "viewtag": "61ab26467e764252135370d1e6451aed"
        },
        "ormdutyormorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrmOrgSectorPickupGridView",
            "viewtag": "743374253b5e705d698020bf94257a4a"
        },
        "pimqualmajorpickupview": {
            "title": "执业资格专业数据选择视图",
            "caption": "执业资格专业",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORPickupView",
            "viewtag": "79011b4b8919b94eaf3c825f6acc8102"
        },
        "index": {
            "title": "招聘管理",
            "caption": "招聘管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "PCM",
            "viewname": "Index",
            "viewtag": "7ABD0219-F56E-46AE-AF96-593BE5751BB9"
        },
        "pcmprofileypzxx_lreditview": {
            "title": "应聘者信息",
            "caption": "应聘者信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZXX_LREditView",
            "viewtag": "992ecee21f22b4daf3ecaf7ad516c1e3"
        },
        "pcmcertofregzczsgridview": {
            "title": "注册证书（要求：带*必填）",
            "caption": "注册证书（要求：带*必填）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMCERTOFREGZCZSGridView",
            "viewtag": "a6fe2d0f44d114e686eb214a6dd4b209"
        },
        "ormdutyormorgsectorpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrmOrgSectorPickupView",
            "viewtag": "ad50beef4cfa8848053a8e607ed0d7a6"
        },
        "pimpersontxrypickupgridview": {
            "title": "退休人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONTXRYPickupGridView",
            "viewtag": "b147b7948f382bb3a0d15382e3663687"
        },
        "pcmawardswonshjqkgridview": {
            "title": "获奖情况（要求：带*必填）",
            "caption": "获奖情况（要求：带*必填）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMAWARDSWONSHJQKGridView",
            "viewtag": "b73b674c74676f40d1c9a1663b14d6ab"
        },
        "pcmpracticeexperiencesxjygridview": {
            "title": "实习信息（要求：带*必填）",
            "caption": "实习信息（要求：带*必填）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPRACTICEEXPERIENCESXJYGridView",
            "viewtag": "b7850952c7fc5ac38fe2077bbe70485b"
        },
        "pcmeducationexperiencejybjgridview": {
            "title": "教育信息（要求：1.高中以上，2.带*必填，3.大专学位证用毕业证代替）",
            "caption": "教育信息（要求：1.高中以上，2.带*必填，3.大专学位证用毕业证代替）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMEducationExperienceJYBJGridView",
            "viewtag": "c1296113c6baff077df6b1f1b1711266"
        },
        "ormorgypzsyfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGYPZSYFPXXPickupView",
            "viewtag": "d0d1c5e2fea8eb48ebcb507b6126df20"
        },
        "ormorgsectorydbmpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORYDBMPickupGridView",
            "viewtag": "ebd5595f0455c8bbeefdf665db2d754b"
        },
        "pimqualmajorpickupgridview": {
            "title": "执业资格专业选择表格视图",
            "caption": "执业资格专业",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORPickupGridView",
            "viewtag": "fe2c9423e322f159b6b437009463be03"
        },
        "tdzwxxtdzwgridview": {
            "title": "投递职位摘要信息（要求：带*必填）",
            "caption": "投递职位摘要信息（要求：带*必填）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "TDZWXXTDZWGridView",
            "viewtag": "feefa68dff81c415ed3f7dfa3ffcc084"
        },
        "ormorgsectorydbmpickupview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORYDBMPickupView",
            "viewtag": "fff47154e7d5fc117b240c1141c142f4"
        }
    }];
});