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
        "pcmprofilespyygridview": {
            "title": "应聘者审批原因表格视图",
            "caption": "应聘者审批原因",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILESPYYGridView",
            "viewtag": "03d90de71e9cd72a66f040a42cd48d1b"
        },
        "ormpostejormorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
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
        "pcmprofileypzbd_csrcyjgridview": {
            "title": "拟录用人员",
            "caption": "拟录用人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZBD_CSRCYJGridView",
            "viewtag": "1178128e98145594a3c2fb6ba6a24b53"
        },
        "ormorgypzxxsypickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGYPZXXSYPickupGridView",
            "viewtag": "128376d374a95b9d98fb658a9d33dc77"
        },
        "pcmprofilerlsb_csrcyjgridview": {
            "title": "人力上报",
            "caption": "人力上报",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERLSB_CSRCYJGridView",
            "viewtag": "15fb46caf3382c9945d236ca18ebb8b7"
        },
        "pcmgxmlcurndgridview": {
            "title": "高校名录表格视图",
            "caption": "高校名录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmGxmlCurNDGridView",
            "viewtag": "16f45c559b919f73db542c707116ce73"
        },
        "pcmprofilebhsp_csrcyjeditview": {
            "title": "编号审批",
            "caption": "编号审批",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEBHSP_CSRCYJEditView",
            "viewtag": "1764fbdf94409bb512f6860c9304be08"
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
        "pcmzpmegltreeexpview": {
            "title": "招聘名额管理树导航视图",
            "caption": "招聘名额管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMZPMEGLTreeExpView",
            "viewtag": "1f920c8cc89727194baf86209f07b039"
        },
        "pcmprofilebhsp_csrcyjgridview": {
            "title": "编号审批",
            "caption": "编号审批",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEBHSP_CSRCYJGridView",
            "viewtag": "22c7bdfbf9ee4e1c7e58c4f5dcae4eb3"
        },
        "tdzwxxeditview": {
            "title": "投递职位摘要信息",
            "caption": "投递职位摘要信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "TDZWXXEditView",
            "viewtag": "26f69f4ff507ad80fa6fb9a194aca149"
        },
        "pcmxkmlpickupgridview": {
            "title": "学科目录选择表格视图",
            "caption": "学科目录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMXKMLPickupGridView",
            "viewtag": "37004b147c76141470829eebc5f12e99"
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
        "pcmprofilerzsp_csrcyjgridview": {
            "title": "局总部初审",
            "caption": "局总部初审",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERZSP_CSRCYJGridView",
            "viewtag": "4f5dde5e2adf0c18d9177424546f212f"
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
        "pcmxkmlxkmltreeexpview": {
            "title": "学科目录树导航视图",
            "caption": "学科目录",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMXKMLXKMLTreeExpView",
            "viewtag": "59ba44be62d172eb0369428a2d3475ef"
        },
        "pcmxkmleditview": {
            "title": "学科目录编辑视图",
            "caption": "学科目录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMXKMLEditView",
            "viewtag": "5c8f3c9220d882d449e521694f4896e0"
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
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGPickupView",
            "viewtag": "654b0d69b59342ca52e3ae8392ec318d"
        },
        "pcmprofileypzbdeditview": {
            "title": "拟录用人员",
            "caption": "拟录用人员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZBDEditView",
            "viewtag": "65c9c019ec8de91077c1d8c58da97caf"
        },
        "pcmprofilerlsb_csrcyjxgeditview": {
            "title": "人力上报",
            "caption": "人力上报",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERLSB_CSRCYJXGEditView",
            "viewtag": "6c770bb20aaa1013407496ae0236904e"
        },
        "pcmprofileszyjtjmpickupview": {
            "title": "应聘者社招引进条件选择",
            "caption": "应聘者社招引进条件",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILESZYJTJMPickupView",
            "viewtag": "6dabeb1f930b9a81c11e6ea38ceb5e1b"
        },
        "pcmawardswonshjqk_wsswbjgridview": {
            "title": "获奖情况表格视图",
            "caption": "获奖情况",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMAWARDSWONSHJQK_WSSWBJGridView",
            "viewtag": "71cdb539d218e7a24362fa84ffa78813"
        },
        "pcmprofilefpwizardview": {
            "title": "返聘应聘者信息录入向导",
            "caption": "返聘应聘者信息录入向导",
            "viewtype": "DEWIZARDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEFPWizardView",
            "viewtag": "725c3f336173556ff1f901c52577ad16"
        },
        "ormdutyormorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrmOrgSectorPickupGridView",
            "viewtag": "743374253b5e705d698020bf94257a4a"
        },
        "pcmprofileszyjtjpickupgridview": {
            "title": "应聘者社招引进条件选择表格视图",
            "caption": "应聘者社招引进条件",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILESZYJTJPickupGridView",
            "viewtag": "76d32dc8e0679ba7242a5568fc65e75a"
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
        "pcmprofileyrdwcs_csrcyjgridview": {
            "title": "用人单位初审",
            "caption": "用人单位初审",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYRDWCS_CSRCYJGridView",
            "viewtag": "7e2d64b3935aa65a617cf850dbc29143"
        },
        "pcmgxxktempgridview": {
            "title": "高校学科",
            "caption": "高校学科",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMGXXKTEMPGridView",
            "viewtag": "837202b8e92e08b7c5d64fddf63a106b"
        },
        "pcmprofilerzsp_csrcyjeditview": {
            "title": "局总部初审",
            "caption": "局总部初审",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERZSP_CSRCYJEditView",
            "viewtag": "86a86d39e6ca1afad826b2ca38d842bc"
        },
        "pcmgxmlgxmltreeexpview": {
            "title": "高校名录树导航视图",
            "caption": "高校名录",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMGXMLGXMLTreeExpView",
            "viewtag": "8c624a8a7afa528599e117ccc80655e3"
        },
        "pcmprofilerlsb_csrcyjeditview": {
            "title": "人力上报",
            "caption": "人力上报",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILERLSB_CSRCYJEditView",
            "viewtag": "922db9227bd8bb968fd3b3dd5e89f9b0"
        },
        "pcmzpmeglcurndgridview": {
            "title": "招聘名额管理表格视图",
            "caption": "招聘名额管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMZPMEGLCurNDGridView",
            "viewtag": "92d6e3a013c18695f7b151d402b408e1"
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
        "pcmprofileypzxx_csrcyjeditview": {
            "title": "应聘者信息",
            "caption": "应聘者信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZXX_CSRCYJEditView",
            "viewtag": "a5d79ef05115df649b491f8f4a66d527"
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
        "pcmprofileypzbd_csrcyjeditview": {
            "title": "拟录用人员",
            "caption": "拟录用人员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZBD_CSRCYJEditView",
            "viewtag": "ab78da2e98f22cb3f601923cf66db13f"
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
        "pcmzpmegleditview": {
            "title": "招聘名额管理编辑视图",
            "caption": "招聘名额管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMZPMEGLEditView",
            "viewtag": "b372c9dfc12170a7ab4bc56e4038f4b9"
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
        "pcmprofileqtzpwizardview": {
            "title": "其他招聘应聘者信息录入向导",
            "caption": "其他招聘应聘者信息录入向导",
            "viewtype": "DEWIZARDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEQTZPWizardView",
            "viewtag": "b8a30edae7c11d128c2162bbf21def52"
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
        "pcmgxmlpickupgridview": {
            "title": "高校名录选择表格视图",
            "caption": "高校名录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMGXMLPickupGridView",
            "viewtag": "c17373aefb5d5528751aef889fdd9862"
        },
        "pcmprofileszwizardview": {
            "title": "社招应聘者信息录入向导",
            "caption": "社招应聘者信息录入向导",
            "viewtype": "DEWIZARDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILESZWizardView",
            "viewtag": "c20756541eb3db24da51a2a9e8db3b80"
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
            "title": "EHR—招聘管理",
            "caption": "EHR—招聘管理",
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
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGPickupGridView",
            "viewtag": "d4c49aa233ac2d674d4a2e3107f961c3"
        },
        "pcmprofileyrdwcs_csrcyjeditview": {
            "title": "用人单位初审",
            "caption": "用人单位初审",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYRDWCS_CSRCYJEditView",
            "viewtag": "d99f304040bb4070220a9fec3969387d"
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
        "pcmzpmeglmxzpmeglmxgridview": {
            "title": "招聘名额管理明细表格视图",
            "caption": "招聘名额管理明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMZPMEGLMXZPMEGLMXGridView",
            "viewtag": "df39bc60733c4cefb8b8230033645777"
        },
        "pcmprofilespyyeditview": {
            "title": "应聘者审批原因编辑视图",
            "caption": "应聘者审批原因",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILESPYYEditView",
            "viewtag": "e8039e63e4243185036c8869e1baf911"
        },
        "pcmgxmleditview": {
            "title": "高校名录编辑视图",
            "caption": "高校名录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMGXMLEditView",
            "viewtag": "e8cca29d9578f296af25b69b86bb4a45"
        },
        "pcmxkmlmpickupview": {
            "title": "学科目录数据多项选择视图",
            "caption": "学科目录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMXKMLMPickupView",
            "viewtag": "e8ecbd69de09c2f47066ca1d9eb04d71"
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
        "pcmprofileypzxx_csrcyjgridview": {
            "title": "应聘者信息",
            "caption": "应聘者信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMPROFILEYPZXX_CSRCYJGridView",
            "viewtag": "f5db4770bcce6f7852031664b852654c"
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
        "pcmxkmlcurndgridview": {
            "title": "学科目录表格视图",
            "caption": "学科目录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMXKMLCurNDGridView",
            "viewtag": "fb83d5b87842f3c688ba91ee5d031233"
        },
        "pcmgxmlmpickupview": {
            "title": "高校名录数据多项选择视图",
            "caption": "高校名录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMGXMLMPickupView",
            "viewtag": "fd4aa1f72c775c6e42df2c41c6d5f6f6"
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