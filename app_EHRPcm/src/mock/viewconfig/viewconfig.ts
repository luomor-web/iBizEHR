import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "pcmworkresumegzll_wsswbjgridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMWORKRESUMEGZLL_WSSWBJGridView",
            "viewtag": "01a06bd6730d3199229fd1b9f8aca1a8"
        },
        "ormpostejormorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位集",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEJORMORGIDPickupView",
            "viewtag": "09de889eff18f3439d11da7604fda3fb"
        },
        "wzd0001ypzbdoptionview": {
            "title": "报到",
            "caption": "报到",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "PCM",
            "viewname": "WZD0001YPZBDOptionView",
            "viewtag": "0a35c2cf7b8d373478092b5561546a82"
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
        "pcmschoolofficeeditview": {
            "title": "在校职务",
            "caption": "在校职务",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMSCHOOLOFFICEEditView",
            "viewtag": "0e0ec3aacabc80d01e9fd4d788aa8dc5"
        },
        "ormorgypzxxsypickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGYPZXXSYPickupGridView",
            "viewtag": "128376d374a95b9d98fb658a9d33dc77"
        },
        "pcmprofilefjeditview": {
            "title": "应聘者附件编辑视图",
            "caption": "应聘者附件",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEFJEditView",
            "viewtag": "1977e8d438054097b13de37ff789b517"
        },
        "pcmeducationexperienceeditview": {
            "title": "教育背景",
            "caption": "教育背景",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMEducationExperienceEditView",
            "viewtag": "19cce11f58776909dbd6caa9a9fd3946"
        },
        "pcmeducationexperiencejybj_wsswbjgridview": {
            "title": "教育信息",
            "caption": "教育信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMEducationExperienceJYBJ_WSSWBJGridView",
            "viewtag": "1c918b48d7fa656129630687c6f681e5"
        },
        "tdzwxxeditview": {
            "title": "投递职位摘要信息",
            "caption": "投递职位摘要信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "TDZWXXEditView",
            "viewtag": "26f69f4ff507ad80fa6fb9a194aca149"
        },
        "testresultcpjggridview": {
            "title": "测评结果摘要信息（要求：带*必填）",
            "caption": "测评结果摘要信息（要求：带*必填）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "TestResultCPJGGridView",
            "viewtag": "3d7985f2b41ff52bea5ebcf3bacc6169"
        },
        "pcmprofilerlsb_xgeditview": {
            "title": "人力上报",
            "caption": "人力上报",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERLSB_XGEditView",
            "viewtag": "42097975f67e4a2a8b076ce6dbd228cf"
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
        "pcmpracticeexperienceeditview": {
            "title": "实习经验",
            "caption": "实习经验",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPRACTICEEXPERIENCEEditView",
            "viewtag": "47328693892b4aabde90acf085237c98"
        },
        "pcmprofilerlsbgridview": {
            "title": "人力上报",
            "caption": "人力上报",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERLSBGridView",
            "viewtag": "542a69a23fcce66c228b0a9dd3d8ac3a"
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
        "testresulteditview": {
            "title": "测评结果摘要信息",
            "caption": "测评结果摘要信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "TestResultEditView",
            "viewtag": "642e7abba6964fca1715f07242cc34b1"
        },
        "pcmprofileypzbdeditview": {
            "title": "拟录用人员",
            "caption": "拟录用人员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZBDEditView",
            "viewtag": "65c9c019ec8de91077c1d8c58da97caf"
        },
        "pcmawardswonshjqk_wsswbjgridview": {
            "title": "获奖情况表格视图",
            "caption": "获奖情况",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMAWARDSWONSHJQK_WSSWBJGridView",
            "viewtag": "71cdb539d218e7a24362fa84ffa78813"
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
        "pcmprofileapprovaljjgridview": {
            "title": "应聘者审批表",
            "caption": "应聘者审批表",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEAPPROVALJJGridView",
            "viewtag": "7e25063f664b76124359fc1ffcaacb51"
        },
        "pcmcertofregzczs_wsswbjgridview": {
            "title": "注册证书",
            "caption": "注册证书",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMCERTOFREGZCZS_WSSWBJGridView",
            "viewtag": "95bcee42df5fcece9493f5aabfd9f42c"
        },
        "pcmprofileypzxx_lreditview": {
            "title": "应聘者信息",
            "caption": "应聘者信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZXX_LREditView",
            "viewtag": "992ecee21f22b4daf3ecaf7ad516c1e3"
        },
        "pcmprofilebhspgridview": {
            "title": "编号审批",
            "caption": "编号审批",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEBHSPGridView",
            "viewtag": "a5ff9e62a82d14a07d81db0c0ef586e1"
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
        "testresultcpjg_wsswbjgridview": {
            "title": "测评结果摘要信息",
            "caption": "测评结果摘要信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "TestResultCPJG_WSSWBJGridView",
            "viewtag": "b11d32b948546b8182fe02016f89ec41"
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
        "wzd0001jcsoptionview": {
            "title": "局总部初审",
            "caption": "局总部初审",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "PCM",
            "viewname": "WZD0001JCSOptionView",
            "viewtag": "b8a34744d439abfff6ca42202a0c9d85"
        },
        "pcmprofileypzbdgridview": {
            "title": "拟录用人员",
            "caption": "拟录用人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZBDGridView",
            "viewtag": "bf2d5739527f564355ffe5ffce92d9a6"
        },
        "pcmeducationexperiencejybjgridview": {
            "title": "教育信息（要求：1.高中以上，2.带*必填，3.大专学位证用毕业证代替）",
            "caption": "教育信息（要求：1.高中以上，2.带*必填，3.大专学位证用毕业证代替）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMEducationExperienceJYBJGridView",
            "viewtag": "c1296113c6baff077df6b1f1b1711266"
        },
        "pcmprofilebhspeditview": {
            "title": "编号审批",
            "caption": "编号审批",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEBHSPEditView",
            "viewtag": "c2c9f03c03a45ea71e0fc82836b8e5a0"
        },
        "index": {
            "title": "招聘管理",
            "caption": "招聘管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "PCM",
            "viewname": "Index",
            "viewtag": "c6b154dd2f5d680dda854191ae62d388"
        },
        "pcmpracticeexperiencesxjy_wsswbjgridview": {
            "title": "实习信息",
            "caption": "实习信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPRACTICEEXPERIENCESXJY_WSSWBJGridView",
            "viewtag": "c8ed6bc3b1fb98097433f84d7b885917"
        },
        "ormorgypzsyfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGYPZSYFPXXPickupView",
            "viewtag": "d0d1c5e2fea8eb48ebcb507b6126df20"
        },
        "tdzwxxtdzw_wsswbjgridview": {
            "title": "投递职位摘要信息",
            "caption": "投递职位摘要信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "TDZWXXTDZW_WSSWBJGridView",
            "viewtag": "d11d7cff3a3a81ba0788cddd5506d701"
        },
        "pcmawardswonseditview": {
            "title": "获奖情况",
            "caption": "获奖情况",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMAWARDSWONSEditView",
            "viewtag": "d29ed45e3397bfcda1f4763b9b3e8686"
        },
        "pcmprofilerlsbeditview": {
            "title": "人力上报",
            "caption": "人力上报",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERLSBEditView",
            "viewtag": "dafc83fe4f8c489f4209eb5852c38a3b"
        },
        "pcmprofilezpdwsheditview": {
            "title": "用人单位初审",
            "caption": "用人单位初审",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEZPDWSHEditView",
            "viewtag": "db6481cf0fd233088402d584a67338a8"
        },
        "pcmprofilefjprofilefjgridview": {
            "title": "应聘者附件",
            "caption": "应聘者附件",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEFJProfileFJGridView",
            "viewtag": "eab174bdd0d26c696e5a0e0d433af6c6"
        },
        "ormorgsectorydbmpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORYDBMPickupGridView",
            "viewtag": "ebd5595f0455c8bbeefdf665db2d754b"
        },
        "pcmworkresumeeditview": {
            "title": "工作履历",
            "caption": "工作履历",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMWORKRESUMEEditView",
            "viewtag": "eca902f7ff75f15ff107b7f7c49f13ab"
        },
        "pcmprofilerzspeditview": {
            "title": "局总部初审",
            "caption": "局总部初审",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERZSPEditView",
            "viewtag": "f41dc12715664fd5a5678c0442e3e962"
        },
        "pcmprofilezpdwshgridview": {
            "title": "用人单位初审",
            "caption": "用人单位初审",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEZPDWSHGridView",
            "viewtag": "f666d946fa169ea6c954caff48070694"
        },
        "pcmschoolofficezxzw_wsswbjgridview": {
            "title": "在校职务",
            "caption": "在校职务",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMSCHOOLOFFICEZXZW_WSSWBJGridView",
            "viewtag": "fa6e04043d654177e570ab09a58791bd"
        },
        "pimqualmajorpickupgridview": {
            "title": "执业资格专业选择表格视图",
            "caption": "执业资格专业",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORPickupGridView",
            "viewtag": "fe2c9423e322f159b6b437009463be03"
        },
        "pcmprofilerzspgridview": {
            "title": "局总部初审",
            "caption": "局总部初审",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERZSPGridView",
            "viewtag": "feaa15f9310a9dc4cc089eac9844e85f"
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