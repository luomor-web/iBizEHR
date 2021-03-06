import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "pimstafftypeeditview": {
            "title": "员工类型编辑视图",
            "caption": "员工类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPEEditView",
            "viewtag": "003c49714be39f21f9a26d87a41095c0"
        },
        "pimpersonryinfogridview": {
            "title": "人员信息表格视图",
            "caption": "人员信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONRYInfoGridView",
            "viewtag": "009742a828fac8313709a1fa9f6a49b7"
        },
        "pimworkhistorypersoninfogridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYPersonInfoGridView",
            "viewtag": "00a2c5282527cf428bf391c8629a684f"
        },
        "pimpapereditview2": {
            "title": "论文信息编辑视图",
            "caption": "论文信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPAPEREditView2",
            "viewtag": "00dc6b9fd6ceb996b8053e6c2d959305"
        },
        "pimpersonabilitymgrgridview": {
            "title": "员工能力管理",
            "caption": "员工能力",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityMgrGridView",
            "viewtag": "014f973b52e0b9f2c9d9c23455fd7f1a"
        },
        "pimpersongridview": {
            "title": "员工信息表格视图",
            "caption": "员工信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONGridView",
            "viewtag": "0152964b7b7c749e3634a2f4fe12d37c"
        },
        "pimdistirbutiongrworkhistoryeditview": {
            "title": "工作履历编辑视图",
            "caption": "工作履历",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionGRWorkHistoryEditView",
            "viewtag": "015fcf2bd4d760e8c6d67fc272e530c9"
        },
        "pimdistirbutionexpereencegridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionEXPEREENCEGridView",
            "viewtag": "01c1894cc1cbcd11c02eea70ed16e937"
        },
        "pimeducationzdxlgridview": {
            "title": "教育背景",
            "caption": "教育背景",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONZDXLGridView",
            "viewtag": "037dec5c2fb3b0a65bc32d84e178e381"
        },
        "pimworkhistorygreditview": {
            "title": "工作履历编辑视图",
            "caption": "工作履历",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYGREditView",
            "viewtag": "03950f77ca696c85e2cf4b661f03752f"
        },
        "pimarmycadresgrarmygridview": {
            "title": "军转干部表格视图",
            "caption": "军转干部",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESGRARMYGridView",
            "viewtag": "03ff3ccc28a38beb06d154491f4948ee"
        },
        "pimqualmajormpickupview": {
            "title": "执业资格专业数据多项选择视图",
            "caption": "执业资格专业",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORMPickupView",
            "viewtag": "04a3c5326d897f8f1d1f4dbeb0fc0fb2"
        },
        "pimtitlegridview": {
            "title": "职称信息表格视图",
            "caption": "职称信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEGridView",
            "viewtag": "053ad31fdeb2b1fad51395e7e1a81c67"
        },
        "pimpersonmpickupview": {
            "title": "人员信息数据多项选择视图",
            "caption": "人员信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONMPickupView",
            "viewtag": "05bb45d27044777ec36aadd6117613dc"
        },
        "ormpostpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTPickupView",
            "viewtag": "06102d280c51b69276bd81656ae40201"
        },
        "pimexitandentrywfeditview9": {
            "title": "出入境管理工作流嵌入视图",
            "caption": "出入境管理",
            "viewtype": "DEWFEDITVIEW9",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYWFEditView9",
            "viewtag": "064a79ff1f3a8acffb190b7d6314fdee"
        },
        "pimqualmajoreditview2": {
            "title": "执业资格专业编辑视图",
            "caption": "执业资格专业",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJOREditView2",
            "viewtag": "065bba64d587282467d6c7abb0e38bac"
        },
        "pimpatentgreditview": {
            "title": "专利信息编辑视图",
            "caption": "专利信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTGREditView",
            "viewtag": "06ad339361e9022ca15e6af6c5fd9cab"
        },
        "pimvocationalcatalogmpickupview": {
            "title": "职（执）业资格目录管理数据多项选择视图",
            "caption": "执（职）业资格管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALCATALOGMPickupView",
            "viewtag": "07e59f6e01f3509c334a5a758e17fb2e"
        },
        "pimpersonneweditview2": {
            "title": "员工首页编辑视图",
            "caption": "员工首页",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONNewEditView2",
            "viewtag": "08314bb97f4b70cb40fb952c1e74029c"
        },
        "archivalcatalogueeditview": {
            "title": "档案类别编辑视图",
            "caption": "档案目录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVALCATALOGUEEditView",
            "viewtag": "08c1c77ca3cea710c6744dfce3699e61"
        },
        "pimcontractstopremindgridview": {
            "title": "合同信息表格视图(终止提醒)",
            "caption": "合同终止提醒",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTStopRemindGridView",
            "viewtag": "08c5124c92aeb7656cc47a957f4d95a8"
        },
        "pimpersonchangeeditview2": {
            "title": "人员信息变更审核编辑视图",
            "caption": "人员信息变更审核",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEEditView2",
            "viewtag": "08c5491725758bd374e19480450c240d"
        },
        "pimtitlecatalogueeditview2": {
            "title": "职称目录管理编辑视图",
            "caption": "职称目录",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUEEditView2",
            "viewtag": "08ff1bf16e986775126594852ae1e519"
        },
        "pimpersonabilitydetaileditview2": {
            "title": "员工能力明细编辑视图",
            "caption": "员工能力明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityDetailEditView2",
            "viewtag": "0a52928722200bae6838d6920fab1200"
        },
        "pimworkhistoryredirectview": {
            "title": "工作履历数据重定向视图",
            "caption": "工作履历",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYRedirectView",
            "viewtag": "0a71d00c555b79769fe55bc9387c367e"
        },
        "pimeducationeditview2": {
            "title": "教育信息编辑视图",
            "caption": "教育信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONEditView2",
            "viewtag": "0caa5b1386503797ac9558ea38637ed8"
        },
        "pimcontractmpickupview": {
            "title": "合同信息数据多项选择视图",
            "caption": "合同信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTMPickupView",
            "viewtag": "0cafe18834e85f2c4bc8ef753c5e0f35"
        },
        "pimexpaccounteditview": {
            "title": "费用台账编辑视图",
            "caption": "费用台账",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXPACCOUNTEditView",
            "viewtag": "0d9de3e10529046318626669a630433f"
        },
        "pimgwtypepickupgridview": {
            "title": "岗位类型",
            "caption": "岗位类型",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMGWTYPEPickupGridView",
            "viewtag": "0e6691a6a85dc66ca1339f4d8ad1e912"
        },
        "pimqualtypepickupview": {
            "title": "执业资格类别数据选择视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALTYPEPickupView",
            "viewtag": "0eb385744b0c54cba5449a03f65f3c22"
        },
        "pimenclosurefilepreviewcustomview": {
            "title": "表格附件预览",
            "caption": "附件预览",
            "viewtype": "DECUSTOMVIEW",
            "viewmodule": "PIM",
            "viewname": "PimEnclosureFilePreViewCustomView",
            "viewtag": "0f1f6848ec80f5ad6f5aa294769d22e2"
        },
        "pimarchivesrecordgridview": {
            "title": "档案目录缺失记录表格视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESRECORDGridView",
            "viewtag": "0f4180a3a35326dee7c0bad697307b23"
        },
        "pimexpaccountpickupgridview": {
            "title": "费用台账选择表格视图",
            "caption": "费用台账",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXPACCOUNTPickupGridView",
            "viewtag": "0f822e548410e8589a8cf29c4f87ef26"
        },
        "pimpersonabilitydetailmpickupview": {
            "title": "员工能力明细数据多项选择视图",
            "caption": "员工能力明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityDetailMPickupView",
            "viewtag": "0fe4c45657e80c525296e3ee2a6351cb"
        },
        "archivalcataloguepickupgridview": {
            "title": "档案目录选择表格视图",
            "caption": "档案目录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVALCATALOGUEPickupGridView",
            "viewtag": "0ff4bcadeab507d5531d6310b69e05e0"
        },
        "archivescentermpickupview": {
            "title": "档案室管理数据多项选择视图",
            "caption": "档案室管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESCENTERMPickupView",
            "viewtag": "10ac743aa6842b786bafe8a390a22e0f"
        },
        "pimrewardpunishmentgreditview": {
            "title": "奖励惩罚编辑视图",
            "caption": "奖惩信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTGREditView",
            "viewtag": "113e3fa6579163a66689f869be085207"
        },
        "pimarchivesrecordmpickupview": {
            "title": "档案目录缺失记录数据多项选择视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESRECORDMPickupView",
            "viewtag": "11a3517389efbf81bf0d4809ddb027d3"
        },
        "pimdistirbutionfenpeigridview": {
            "title": "分配信息表格视图",
            "caption": "分配信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionFenPeiGridView",
            "viewtag": "11cdabdfa7d7d2a5f74bcba9e238a17b"
        },
        "pimarchivesloanandreturnpickupgridview": {
            "title": "档案借阅及归还记录选择表格视图",
            "caption": "档案借阅及归还记录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESLOANANDRETURNPickupGridView",
            "viewtag": "12a336b86d5c43df4107673159c0cdd8"
        },
        "pimeducationpickupview": {
            "title": "教育信息数据选择视图",
            "caption": "教育信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONPickupView",
            "viewtag": "13462818fbcf8e1f3bc036d46b7522fa"
        },
        "pimrewardpunishmentmpickupview": {
            "title": "奖励惩罚数据多项选择视图",
            "caption": "奖惩信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTMPickupView",
            "viewtag": "13bdebeff6c770c96bb36dab0207d774"
        },
        "archivesmanagepickupgridview": {
            "title": "档案管理选择表格视图",
            "caption": "档案管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESMANAGEPickupGridView",
            "viewtag": "13dbfce5cc94878e04861b65384664e6"
        },
        "pimpersonyxzfppickupview": {
            "title": "员工库",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONYXZFPPickupView",
            "viewtag": "150345fcfe4001f1c07998a0a840e482"
        },
        "pimtypecontractgridview": {
            "title": "合同类型表格视图",
            "caption": "合同类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTYPECONTRACTGridView",
            "viewtag": "1645ed409a7f3aafd85689fdb860aac9"
        },
        "pimachievementspimjixgridview": {
            "title": "绩效信息表格视图",
            "caption": "绩效信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSPimJixGridView",
            "viewtag": "178ca8e0cbc9dd9641fe410584cc0a98"
        },
        "pimtitlewsseditview": {
            "title": "职称信息编辑视图",
            "caption": "职称信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEWSSEditView",
            "viewtag": "17a7ba15f517554f027aa805191ae63f"
        },
        "pimpersonpersoninfoeditview": {
            "title": "员工信息",
            "caption": "员工信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONPersonInfoEditView",
            "viewtag": "1804046b3715d3dcecec6303aa0ddc25"
        },
        "pimfaminfojtzycygridview": {
            "title": "家庭主要成员及重要社会关系",
            "caption": "家庭主要成员及重要社会关系",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOJTZYCYGridView",
            "viewtag": "181d4f25589a95d0df99e4d194ef062d"
        },
        "pimpersonabilitypickupview": {
            "title": "员工能力数据选择视图",
            "caption": "员工能力",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityPickupView",
            "viewtag": "1821f9523c27182d8a9023226b9846e0"
        },
        "pimpapergreditview": {
            "title": "论文信息编辑视图",
            "caption": "论文信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPERGREditView",
            "viewtag": "1877e30e20d6c24d6bbf10eedb4fa153"
        },
        "ormorghtgldwpickupview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGHTGLDWPickupView",
            "viewtag": "18b116e6d76d6c2a7001cfc63e9a926a"
        },
        "attendancemreportmxeditview": {
            "title": "考勤月报明细",
            "caption": "考勤月报明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "ATTENDANCEMREPORTMXEditView",
            "viewtag": "19e3a27c4763e3bf10b6c641848c2b4d"
        },
        "pimrewardpunishmenthonorgridview": {
            "title": "荣誉奖励",
            "caption": "奖惩信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTHONORGridView",
            "viewtag": "19f00009bc07fdec629eaaf02b39c92e"
        },
        "pimqualmajorpickupview": {
            "title": "执业资格专业数据选择视图",
            "caption": "执业资格专业",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORPickupView",
            "viewtag": "19f7564ebb4dde06860008bf2d7e65aa"
        },
        "pimstafftypeeditview2": {
            "title": "员工类型管理编辑视图",
            "caption": "员工类型管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPEEditView2",
            "viewtag": "1abc7f33abf1d4b24ad809adb0fc8738"
        },
        "pimlanguageabilityredirectview": {
            "title": "语言能力数据重定向视图",
            "caption": "语言能力",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYRedirectView",
            "viewtag": "1c019f22b42bcf349089d90bbccc5e3d"
        },
        "pimarchivesloyeenofilegridview": {
            "title": "员工不在档提醒表格视图",
            "caption": "员工不在档提醒",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESLOYEENOFILEGridView",
            "viewtag": "1c4f6656ae3964d921333fc8e521b0d6"
        },
        "pimexitandentrywfproxyresultview": {
            "title": "出入境管理工作流结果视图",
            "caption": "出入境管理",
            "viewtype": "DEWFPROXYRESULTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYWFProxyResultView",
            "viewtag": "1c64c7993559890b1b8a3d700a162df1"
        },
        "pimpersoncurleaderpickupview": {
            "title": "部门负责人选择",
            "caption": "部门负责人选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCurLeaderPickupView",
            "viewtag": "1d1bb2d28b9abee5250c7b61aedadb85"
        },
        "pimexitandentryeditview_ytg": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYEditView_YTG",
            "viewtag": "1d1c1bd5b4f245658ffe5ff9004ac0af"
        },
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGPickupGridView",
            "viewtag": "1d6fcc824784161e3fc1e49799a59f53"
        },
        "pimpersongrxscgeditview": {
            "title": "学术成果编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONGRXSCGEditView",
            "viewtag": "1d6fe859846be355395cafd4d1e39526"
        },
        "pimlabourcampanypickupview": {
            "title": "劳务派遣公司管理数据选择视图",
            "caption": "劳务派遣公司管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLABOURCAMPANYPickupView",
            "viewtag": "1e0dd7309a912e27176184e4409f2608"
        },
        "pimstafftypegridview": {
            "title": "员工类型表格视图",
            "caption": "员工类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPEGridView",
            "viewtag": "1e662f352a8f29e529e90f29e3b40f67"
        },
        "pcmjxsgzeditview": {
            "title": "见习期编辑视图",
            "caption": "见习期",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMJXSGZEditView",
            "viewtag": "1ee4cf83c19e727d121adf1c843509ac"
        },
        "parjxndkhjglasttwoyeargridview": {
            "title": "绩效考核成绩",
            "caption": "绩效考核成绩",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "PARJXNDKHJGLastTwoYearGridView",
            "viewtag": "1f15ab007f3182a7b4b1c8a02382cdbe"
        },
        "pimexitandentryeditview2": {
            "title": "出入境管理编辑视图",
            "caption": "出入境管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYEditView2",
            "viewtag": "1f6051531ec9bb305221db289c73158a"
        },
        "pimpersonbylygpickupview": {
            "title": "B/Y类员工选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONBYLYGPickupView",
            "viewtag": "1f97f4273dde89635118c8cf2a6ab698"
        },
        "pimgwtypempickupview": {
            "title": "岗位类型",
            "caption": "岗位类型",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMGWTYPEMPickupView",
            "viewtag": "202329c082bd388ad69e64e9dae9e1ee"
        },
        "pimpaperpickupgridview": {
            "title": "论文信息选择表格视图",
            "caption": "论文信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPERPickupGridView",
            "viewtag": "203432c30f2f0afc3a175b448ce695aa"
        },
        "pimpatentmpickupview": {
            "title": "专利信息数据多项选择视图",
            "caption": "专利信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTMPickupView",
            "viewtag": "212caa48269afb62d70bddf289c3b2f0"
        },
        "pimmajorsetypegridview": {
            "title": "专业序列类型表格视图",
            "caption": "专业序列类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMMAJORSETYPEGridView",
            "viewtag": "214df41357af6620ae908b4e429d558b"
        },
        "pimpersonchangegridview": {
            "title": "员工信息审核表格视图",
            "caption": "员工信息审核",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEGridView",
            "viewtag": "2151c9cf1466f04ddd57fb78ff15e3a3"
        },
        "pimarchivesredirectview": {
            "title": "档案信息数据重定向视图",
            "caption": "档案信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESRedirectView",
            "viewtag": "21ccd254338305d40bc75d2c4fb6cd3f"
        },
        "ormdutyormorgsectorpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrmOrgSectorPickupView",
            "viewtag": "2261894489aaf76aa3de57d4ee473ab1"
        },
        "pimpersonabilitydetaileditview": {
            "title": "员工能力明细编辑视图",
            "caption": "员工能力明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityDetailEditView",
            "viewtag": "229dc8a499c851813e30fbb07e10be8a"
        },
        "pimlanguageabilityyynlgridview": {
            "title": "语言能力表格视图",
            "caption": "语言能力",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYYYNLGridView",
            "viewtag": "229f46ac0aaea849d9b2ad137a920848"
        },
        "pimachievementseditview2": {
            "title": "绩效信息编辑视图",
            "caption": "绩效信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSEditView2",
            "viewtag": "23450e1bed60d2e07d95111301d42e57"
        },
        "pimarchivesrecordeditview2": {
            "title": "档案目录缺失记录编辑视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESRECORDEditView2",
            "viewtag": "2355f25f612b32fe0434826912099223"
        },
        "pimpersonchangeeditview": {
            "title": "员工信息审核编辑视图",
            "caption": "员工信息审核",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEEditView",
            "viewtag": "24219eb43eca0c36fcaa2b3a9c84c991"
        },
        "pcmjxsgzgridview": {
            "title": "见习期表格视图",
            "caption": "见习期",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMJXSGZGridView",
            "viewtag": "25198e8aef450efde8ac670d85e3622c"
        },
        "pimvocationalcatalogeditview2": {
            "title": "职（执）业资格目录管理编辑视图",
            "caption": "执（职）业资格管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALCATALOGEditView2",
            "viewtag": "257ffcbba888b52eb683cbf8214f7e88"
        },
        "pimarmycadresgridview": {
            "title": "军转干部表格视图",
            "caption": "军转干部",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESGridView",
            "viewtag": "25827bc6eb6e05277cd6d189e4c4a903"
        },
        "pimenclosurepickupgridview": {
            "title": "附件信息选择表格视图",
            "caption": "附件信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSUREPickupGridView",
            "viewtag": "2677385b9b6a64ce5713b862bb8587e8"
        },
        "pimqualtypempickupview": {
            "title": "执业资格类别数据多项选择视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALTYPEMPickupView",
            "viewtag": "26dcd75d948364470d8dea6c978f55d2"
        },
        "pimpersoncurorgpimpersonpickupgridview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCurOrgPimpersonPickupGridView",
            "viewtag": "26f175ad6aedf73419b783e13003751d"
        },
        "pimmajorsetypeeditview": {
            "title": "专业序列类型编辑视图",
            "caption": "专业序列类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMMAJORSETYPEEditView",
            "viewtag": "275b635e5e3dc5c88ddeb708e374cade"
        },
        "pimarchivesadmineditview": {
            "title": "档案信息编辑视图",
            "caption": "档案信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESAdminEditView",
            "viewtag": "27d77ceb01e071538422373affaf3cc1"
        },
        "trmlgbcosteditview": {
            "title": "老干部活动管理",
            "caption": "老干部活动管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TRMLGBCOSTEditView",
            "viewtag": "298ba053da5a29b926cee19df42b03cc"
        },
        "pimpersoneditview2": {
            "title": "员工首页编辑视图",
            "caption": "员工首页",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONEditView2",
            "viewtag": "29d56c84d92732195b0b61795c352dd6"
        },
        "pimcontractgrcontracteditview": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTGRContractEditView",
            "viewtag": "29dd891df658ec969a490185c71575a9"
        },
        "pimarchivesarchivesrecordeditview": {
            "title": "调档记录编辑视图",
            "caption": "档案信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESArchivesRecordEditView",
            "viewtag": "2bd345f6f0035c6eb43bd5e74c4f8348"
        },
        "pimqualmajorpickupgridview": {
            "title": "执业资格专业选择表格视图",
            "caption": "执业资格专业",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORPickupGridView",
            "viewtag": "2be3dceff0043f7541a2fda9f6db17d5"
        },
        "pimworkhistorygridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYGridView",
            "viewtag": "2cf541a6897301ccadef37d8e0037985"
        },
        "pimvocationalredirectview": {
            "title": "执（职）业资格信息数据重定向视图",
            "caption": "证书信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALRedirectView",
            "viewtag": "2e06f3062712093583d2319e9aac4f1e"
        },
        "ormorgallleveltwoorgpickupgridview": {
            "title": "管理单位",
            "caption": "管理单位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGAllLevelTwoOrgPickupGridView",
            "viewtag": "2ff83c71a7f8bb92d351501dfde6297c"
        },
        "pimfaminfojtlxrpickupview": {
            "title": "家庭联系人",
            "caption": "家庭情况",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOJTLXRPickupView",
            "viewtag": "304a9806fd309f2e9588331069ff2286"
        },
        "pimlabourcampanympickupview": {
            "title": "劳务派遣公司管理数据多项选择视图",
            "caption": "劳务派遣公司管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLABOURCAMPANYMPickupView",
            "viewtag": "30b8ce7c6e845a050a32f0d3bb33ff84"
        },
        "pimarchiveschangeeditview2": {
            "title": "档案归档地变更记录编辑视图",
            "caption": "档案归档地变更记录",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGEEditView2",
            "viewtag": "30bd9d1f5d218931aa89dbf54286b2cb"
        },
        "pimarchiveschangepickupgridview": {
            "title": "档案归档地变更记录选择表格视图",
            "caption": "档案归档地变更记录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGEPickupGridView",
            "viewtag": "3148aa8d515ef7d0e71184f2525c8dc3"
        },
        "pimpersonxscgeditview": {
            "title": "学术成果编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONXSCGEditView",
            "viewtag": "3152b6784b90b5b9192d25bd1bb87296"
        },
        "pimdistirbutionkddpickupview": {
            "title": "可调动的分配",
            "caption": "分配信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONKDDPickupView",
            "viewtag": "31d35f2ad72a0227285e92620634be84"
        },
        "pimexpaccountgridview": {
            "title": "费用台账表格视图",
            "caption": "费用台账",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXPACCOUNTGridView",
            "viewtag": "31d665cddd46d10553d2cc3e093f0d3c"
        },
        "pimfaminfopickupview": {
            "title": "家庭情况数据选择视图",
            "caption": "家庭情况",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOPickupView",
            "viewtag": "32bb1a9f9d638d47568f6c1c55320f02"
        },
        "ormpostpickupgridview": {
            "title": "岗位管理选择表格视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostPickupGridView",
            "viewtag": "32e52ab38bce18fb15d605419635af02"
        },
        "pimlabourcampanypickupgridview": {
            "title": "劳务派遣公司管理选择表格视图",
            "caption": "劳务派遣公司管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLABOURCAMPANYPickupGridView",
            "viewtag": "33511b7e64bcbd3289c425f2ac61ce95"
        },
        "pcmdetailmpickupview": {
            "title": "人员明细表数据多项选择视图",
            "caption": "人员花名册",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PCMDETAILMPickupView",
            "viewtag": "33ba89c6f3c9946eb58b15cd09ef8298"
        },
        "pimvocationalpickupview": {
            "title": "执（职）业资格信息数据选择视图",
            "caption": "证书信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALPickupView",
            "viewtag": "34436f2a0d8bb74224bf71611bdedf8a"
        },
        "pimpatenteditview": {
            "title": "专利信息编辑视图",
            "caption": "专利信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTEditView",
            "viewtag": "347141f7ddbcdfde987bd9c9284f982a"
        },
        "pimpersonpersoninfotreeexpview": {
            "title": "人员信息树导航视图",
            "caption": "员工信息",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONPersonInfoTreeExpView",
            "viewtag": "347d26e87bd47fdb345ac6f31f1de09f"
        },
        "pimvocationalcatalogredirectview": {
            "title": "职（执）业资格目录管理数据重定向视图",
            "caption": "执（职）业资格管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALCATALOGRedirectView",
            "viewtag": "355c1899a4bbdfc4b1dd5651bf4c0fa3"
        },
        "pimsearchfieldseteditview2": {
            "title": "组合查询条件设置编辑视图",
            "caption": "组合查询条件设置",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetEditView2",
            "viewtag": "35da249358e289c06af4b578694a274d"
        },
        "archivesmanageeditview": {
            "title": "档案管理编辑视图",
            "caption": "档案管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESMANAGEEditView",
            "viewtag": "36475364691f756687f5aaa4d32cb964"
        },
        "pimenclosurepickupview": {
            "title": "附件信息数据选择视图",
            "caption": "附件信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSUREPickupView",
            "viewtag": "3647d6f9bc2cdff7e628fd1d9cc903bf"
        },
        "pimfaminfoeditview2": {
            "title": "家庭情况编辑视图",
            "caption": "家庭情况",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOEditView2",
            "viewtag": "364b3eec355f1cb4c500d9aff367b440"
        },
        "archivescentereditview2": {
            "title": "档案室管理编辑视图",
            "caption": "档案室管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESCENTEREditView2",
            "viewtag": "3669e84e4164f2171e12b14e3e3898ea"
        },
        "pimarchivesloanandreturnredirectview": {
            "title": "档案借阅及归还记录数据重定向视图",
            "caption": "档案借阅及归还记录",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESLOANANDRETURNRedirectView",
            "viewtag": "36b293e164659669524c79c96504b743"
        },
        "pimsearchmodalmpickupview": {
            "title": "组合查询模版数据多项选择视图",
            "caption": "组合查询记录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchModalMPickupView",
            "viewtag": "36dad614a988ded2ce107c0aaf78c333"
        },
        "pimcontractpickupview": {
            "title": "合同信息数据选择视图",
            "caption": "合同信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTPickupView",
            "viewtag": "36eb5e728e5e1dfba145acef1fb8d286"
        },
        "pimarchivesrecordpickupgridview": {
            "title": "档案目录缺失记录选择表格视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESRECORDPickupGridView",
            "viewtag": "3779d77b990404874edb1b1df3c32216"
        },
        "pimenclosureeditview2": {
            "title": "附件信息编辑视图",
            "caption": "附件信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSUREEditView2",
            "viewtag": "37caa12e7d4b44b40da528dccef8a281"
        },
        "pimdistirbutiongrworkhistorygridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionGRWorkHistoryGridView",
            "viewtag": "3908d2b6ccf45f47d2ad80ec5f1c71be"
        },
        "pimpersonabilityeditview": {
            "title": "员工能力编辑视图",
            "caption": "员工能力",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityEditView",
            "viewtag": "39583f12f2d7e365df4385ef7770d414"
        },
        "pimarchivesrecordeditview": {
            "title": "档案目录缺失记录编辑视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESRECORDEditView",
            "viewtag": "3a28b973d4738f0945428cce75c4e059"
        },
        "archivalcataloguepickupview": {
            "title": "档案目录数据选择视图",
            "caption": "档案目录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVALCATALOGUEPickupView",
            "viewtag": "3a969b534843e4ebed7136d772f2f2bd"
        },
        "pimstafftypepickupgridview": {
            "title": "员工类型管理选择表格视图",
            "caption": "员工类型管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPEPickupGridView",
            "viewtag": "3b400232cd352a135015e6e3296a4140"
        },
        "pimtitlecataloguepickupview": {
            "title": "职称目录管理数据选择视图",
            "caption": "职称目录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUEPickupView",
            "viewtag": "3bb63802ad1e55ba0655d95432719b12"
        },
        "pimeducationeditview": {
            "title": "教育信息编辑视图",
            "caption": "教育信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONEditView",
            "viewtag": "3d1f954c894c998d194d1a689569a682"
        },
        "pimexpaccountmpickupview": {
            "title": "费用台账数据多项选择视图",
            "caption": "费用台账",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXPACCOUNTMPickupView",
            "viewtag": "3d38d9d694a58f3814af0ea9d10f98ec"
        },
        "pimcontractgridview": {
            "title": "合同信息表格视图",
            "caption": "合同信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTGridView",
            "viewtag": "3d3a14330db483a15da655cd3ebe262b"
        },
        "pimpersonsyjxeditview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonSYJXEditView",
            "viewtag": "3ea82284a147805bff89e283adf3f6ec"
        },
        "ormpostejormorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEJORMORGIDPickupView",
            "viewtag": "3f07ac3849e918f306166c69c96565a2"
        },
        "pimlabourcampanyeditview2": {
            "title": "劳务派遣公司管理编辑视图",
            "caption": "劳务派遣公司管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMLABOURCAMPANYEditView2",
            "viewtag": "40e53b3c65b08cf6221cb800e930dd40"
        },
        "ormorgxmbqpickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgXMBQPickupGridView",
            "viewtag": "41632650e23fc6ab2bb7b231b594f6e2"
        },
        "pimpersongzdqgridview": {
            "title": "挂职员工",
            "caption": "挂职员工",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONGZDQGridView",
            "viewtag": "4220fc763928ada26523887fb1455183"
        },
        "pcmdetaileditview": {
            "title": "人员明细表编辑视图",
            "caption": "人员花名册",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PCMDETAILEditView",
            "viewtag": "424f6764a55b3e5cf0a9e3f14bba8497"
        },
        "pimvocationalcatalogpickupgridview": {
            "title": "职（执）业资格目录管理选择表格视图",
            "caption": "执（职）业资格管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALCATALOGPickupGridView",
            "viewtag": "425f733a93e9cea8f2f2f61e13a44692"
        },
        "pimsearchmodaleditview": {
            "title": "组合查询模版编辑视图",
            "caption": "组合查询记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchModalEditView",
            "viewtag": "427e6dbbaea5115695a81822d525517c"
        },
        "pimtitlezyjszwgridview": {
            "title": "专业技术职务",
            "caption": "专业技术职务",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEZYJSZWGridView",
            "viewtag": "42c6a6b4c7ead888a9c69b4944622af5"
        },
        "pimachievementseditview": {
            "title": "绩效信息编辑视图",
            "caption": "绩效信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSEditView",
            "viewtag": "43465c939f93d942aa32dbe75022a73d"
        },
        "pimpersongzryhmcgridview": {
            "title": "挂职人员花名册",
            "caption": "挂职人员花名册",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONGZRYHMCGridView",
            "viewtag": "43e9630b7e34dc56c2ab28ebbea464d0"
        },
        "pimworkhistorympickupview": {
            "title": "工作履历数据多项选择视图",
            "caption": "工作履历",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYMPickupView",
            "viewtag": "455c9df08014de5ba1a79c208633e271"
        },
        "pimvocationalzyzggridview": {
            "title": "职业资格",
            "caption": "职业资格",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALZYZGGridView",
            "viewtag": "46741bef4da0d8e3e7462fb25da1d3f6"
        },
        "archivescenterpickupview": {
            "title": "档案室管理数据选择视图",
            "caption": "档案室管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESCENTERPickupView",
            "viewtag": "46869229f9dd0a60b350ddca0a8dc176"
        },
        "pimworkhistorypimworkgridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYPimWorkGridView",
            "viewtag": "47a51836a8ffb05c23362952df3db3d2"
        },
        "pimresearchfindingseditview2": {
            "title": "科研成果编辑视图",
            "caption": "科研成果",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSEditView2",
            "viewtag": "48944d09a1518ddb7267af53a4a1e49c"
        },
        "ormorgxjpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgXjPickupGridView",
            "viewtag": "492e5642bbb450d400f58157a24ffb6c"
        },
        "pimpersontxyggridview": {
            "title": "退休员工",
            "caption": "退休员工",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONTXYGGridView",
            "viewtag": "49ec91168dfefe19d491207dc94f8eb9"
        },
        "pimfaminfofazzsygridview": {
            "title": "家庭主要成员",
            "caption": "家庭主要成员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOFAZZSYGridView",
            "viewtag": "4a25a9cfbaf8716e938869449bc1b281"
        },
        "pimqualtypeeditview2": {
            "title": "执业资格类别编辑视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMQUALTYPEEditView2",
            "viewtag": "4a36569589fcdf7fb8329a515583b1b2"
        },
        "pimarchiveschangeredirectview": {
            "title": "档案归档地变更记录数据重定向视图",
            "caption": "档案归档地变更记录",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGERedirectView",
            "viewtag": "4b0a44b01a6a2f804c5a7b0986fdfb77"
        },
        "pimcontractwssgridview": {
            "title": "合同信息表格视图",
            "caption": "合同信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTWSSGridView",
            "viewtag": "4b6958ef9dc60ab64a03ec2fd1191d84"
        },
        "pimarchivesnotouteditview": {
            "title": "离职未转出档案编辑视图",
            "caption": "离职未转出档案",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESNotoutEditView",
            "viewtag": "4c7f5c05c2b83d378f5cfa17014d9719"
        },
        "pimdistirbutiongrdividereditview": {
            "title": "分配信息编辑视图",
            "caption": "分配信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionGRDividerEditView",
            "viewtag": "4ca0cccec501e3cbc13f558f18b5b085"
        },
        "pimtitlecatalogueselgridview": {
            "title": "职称目录管理表格视图",
            "caption": "职称目录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUESelGridView",
            "viewtag": "4cf59b2495e2d546815604184d96a90d"
        },
        "ormsignorgbdwpickupgridview": {
            "title": "注册单位选择",
            "caption": "注册单位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgBDWPickupGridView",
            "viewtag": "4d05a18be99502a79a879d5794ff6ab2"
        },
        "pimpersonkqjrypickupgridview": {
            "title": "请假人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONKQJRYPickupGridView",
            "viewtag": "4d26fb083adebf38c22dbb7acd897c78"
        },
        "pimcontractlwgridview": {
            "title": "劳务合同管理表格视图",
            "caption": "劳务合同管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTLWGridView",
            "viewtag": "4d3329e182f9a7d62e89d80a8e66677a"
        },
        "pimarmycadrespickupgridview": {
            "title": "军转干部选择表格视图",
            "caption": "军转干部",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESPickupGridView",
            "viewtag": "4d4e17dca3fd8260364efcf605d94805"
        },
        "pimarchiveschangempickupview": {
            "title": "档案归档地变更记录数据多项选择视图",
            "caption": "档案归档地变更记录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGEMPickupView",
            "viewtag": "4d51996da5769a11d004b77dbcfc03a2"
        },
        "pimcontracttypeeditview": {
            "title": "合同类型编辑视图",
            "caption": "合同类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTYPEEditView",
            "viewtag": "4d6fd810f234bfac9e4b95a531122148"
        },
        "archivalcataloguempickupview": {
            "title": "档案目录数据多项选择视图",
            "caption": "档案目录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVALCATALOGUEMPickupView",
            "viewtag": "4dd60c69e4da649e0a59dda606d16fe5"
        },
        "pimarchivesgridview": {
            "title": "档案信息表格视图",
            "caption": "档案信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESGridView",
            "viewtag": "4e67a1b41944cdaf106f4479e83da889"
        },
        "pimfaminfogreditview": {
            "title": "家庭情况编辑视图",
            "caption": "家庭情况",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOGREditView",
            "viewtag": "4e7558fcd35b008d275df0bfca9ebd85"
        },
        "trmtrianpersoneditview": {
            "title": "培训人员编辑视图",
            "caption": "培训记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TRMTRIANPERSONEditView",
            "viewtag": "4eaa3108dd715038d585d60f4bbce8fe"
        },
        "pimpersonyxzfppickupgridview": {
            "title": "有效主分配的人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONYXZFPPickupGridView",
            "viewtag": "4ef23822221309d5bca47826e4c4bff6"
        },
        "ormsignorghtqddwpickupgridview": {
            "title": "合同签订单位选择",
            "caption": "合同签订单位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgHTQDDWPickupGridView",
            "viewtag": "4fd5e0977a27531d39651da89bf8112c"
        },
        "pimcontractgrcontractgridview": {
            "title": "合同信息表格视图",
            "caption": "合同信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTGRContractGridView",
            "viewtag": "5067548e2c24cedacf8659935dcf7cf5"
        },
        "pimrewardpunishmentgridview": {
            "title": "奖励惩罚表格视图",
            "caption": "奖惩信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTGridView",
            "viewtag": "537f352e14f667825d344aa9c249e49b"
        },
        "pimcontractxygridview": {
            "title": "协议管理表格视图",
            "caption": "协议管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTXYGridView",
            "viewtag": "53d78334708005802af378469e1654f8"
        },
        "pimcontracteditview2": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTEditView2",
            "viewtag": "5556d8cc1b483508550e516bdba6ff2f"
        },
        "pimtitlempickupview": {
            "title": "职称信息数据多项选择视图",
            "caption": "职称信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEMPickupView",
            "viewtag": "556215d264fe59e73a37b0ca9ad52d53"
        },
        "pimsearchfieldsetcomplexsearchcustomview": {
            "title": "组合查询",
            "caption": "组合查询",
            "viewtype": "DECUSTOMVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetComPlexSearchCustomView",
            "viewtag": "561f02d608b8733d9d358e17dae644c0"
        },
        "pimqualtypepickupgridview": {
            "title": "执业资格类别选择表格视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALTYPEPickupGridView",
            "viewtag": "56677f8342ed6e0ff7317aa45aee40cd"
        },
        "pimenclosurepcmprofilefujgridview": {
            "title": "应聘者附件预览",
            "caption": "附件信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSUREPcmprofileFujGridView",
            "viewtag": "56bbdbe6913fc25d90f2677e1f2b66dd"
        },
        "pimpersoncurorgpimpersonpickupview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCurOrgPimpersonPickupView",
            "viewtag": "58109bdf3c48a8b1394b29a6b491409c"
        },
        "pimpersoncurorgpersonpickupview": {
            "title": "人员选择",
            "caption": "人员选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCurOrgPersonPickupView",
            "viewtag": "58dfa751a3c91ef76aa5891419d6767b"
        },
        "pimworkhistorypickupgridview": {
            "title": "工作履历选择表格视图",
            "caption": "工作履历",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYPickupGridView",
            "viewtag": "59b002b6ba6523a94b908d38c164bfe1"
        },
        "pimpersongrgridview": {
            "title": "人员信息表格视图",
            "caption": "人员信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONGRGridView",
            "viewtag": "5a99ab0b4ae4dd182cde4283f979ed52"
        },
        "pimvocationalwsseditview": {
            "title": "证书信息编辑视图",
            "caption": "证书信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALWSSEditView",
            "viewtag": "5ad2ef33c8d1adbb1c9353df20c1d7e9"
        },
        "pimpersonzdeditview": {
            "title": "员工信息",
            "caption": "员工信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONZDEditView",
            "viewtag": "5ad3a3ab6b6f19b045bcb40f35a9a06f"
        },
        "pimarmycadreseditview": {
            "title": "军转干部编辑视图",
            "caption": "军转干部",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESEditView",
            "viewtag": "5bd15b1edbb0dcaf3571002db07c19d5"
        },
        "pimcontractldeditview": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTLDEditView",
            "viewtag": "5beb45efff939848c3bc1bb34ee8fe99"
        },
        "archivescenterpickupgridview": {
            "title": "档案室管理选择表格视图",
            "caption": "档案室管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESCENTERPickupGridView",
            "viewtag": "5c25033ec9f323b8f0e1d73b1b9cd5e8"
        },
        "pimcontractsignremindgridview": {
            "title": "合同信息表格视图（初签/续签提醒）",
            "caption": "合同初签(续签)提醒",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTSignRemindGridView",
            "viewtag": "5c31c4266d7004246153b825cfa2ca7e"
        },
        "pimresearchfindingsgreditview": {
            "title": "科研成果编辑视图",
            "caption": "科研成果",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSGREditView",
            "viewtag": "5c393d4397684923de825f6d5306e7cc"
        },
        "pimgwtypepickupview": {
            "title": "岗位类型",
            "caption": "岗位类型",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMGWTYPEPickupView",
            "viewtag": "5cf3b09377a259410b1bff30ad61ded3"
        },
        "pimpersoncurjhrypickupview": {
            "title": "人员选择",
            "caption": "人员选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCurJHRYPickupView",
            "viewtag": "5d7db310af525714d9606146625e7f2b"
        },
        "pimpersonabilitydetailredirectview": {
            "title": "员工能力明细数据重定向视图",
            "caption": "员工能力明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityDetailRedirectView",
            "viewtag": "5d82eae7535225e388c48188353bb36d"
        },
        "ormorgsectorfpxxpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORFPXXPickupGridView",
            "viewtag": "5d869b0246fd03a6dc2ba7382089a310"
        },
        "pimeducationgreditview": {
            "title": "教育信息编辑视图",
            "caption": "教育信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONGREditView",
            "viewtag": "5dde3c2bbf45b9b69f8b130f36f86efe"
        },
        "pimvocationalpickupgridview": {
            "title": "执（职）业资格信息选择表格视图",
            "caption": "证书信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALPickupGridView",
            "viewtag": "5e61c5c94d5b82613946fa03d0ede413"
        },
        "pimdistirbutionygfenpeigridview": {
            "title": "分配信息表格视图",
            "caption": "分配信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONYGFenPeiGridView",
            "viewtag": "5e8063923fbd33440a4682a8d85feef4"
        },
        "pimvocationaleditview": {
            "title": "证书信息编辑视图",
            "caption": "证书信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALEditView",
            "viewtag": "5f0a67fb9bd2214c95a0042b00a85057"
        },
        "ormorgfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGFPXXPickupView",
            "viewtag": "5f3686cf1f5cebdd5a015151aaf1b953"
        },
        "pimfaminfopickupgridview": {
            "title": "家庭情况选择表格视图",
            "caption": "家庭情况",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOPickupGridView",
            "viewtag": "5f9c30bec3a40f31557ad024c01a4d51"
        },
        "pimsearchfieldsetpickupview": {
            "title": "组合查询条件设置数据选择视图",
            "caption": "组合查询条件设置",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetPickupView",
            "viewtag": "602939f735b8247834936b752ad1656a"
        },
        "pimexpaccounteditview2": {
            "title": "费用台账编辑视图",
            "caption": "费用台账",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMEXPACCOUNTEditView2",
            "viewtag": "6109daede9ec7cc3f995c978d16ec4ec"
        },
        "pimarchivesgreditview": {
            "title": "档案信息编辑视图",
            "caption": "档案信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESGREditView",
            "viewtag": "614028e08b2e928dbac9c81ea9f8d336"
        },
        "pimarmycadrespickupview": {
            "title": "军转干部数据选择视图",
            "caption": "军转干部",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESPickupView",
            "viewtag": "61991cd79b9a08fdb7bbba1caed1fc5d"
        },
        "pimsearchfieldsetusr2gridview": {
            "title": "组合查询条件设置表格视图",
            "caption": "组合查询条件设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetUsr2GridView",
            "viewtag": "61b5eaa9b523eabe57a6d00595fac058"
        },
        "pimsearchmodalredirectview": {
            "title": "组合查询模版数据重定向视图",
            "caption": "组合查询记录",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchModalRedirectView",
            "viewtag": "62e8d8dfb03473c101fd454a15af8a56"
        },
        "pimstafftypepickupview": {
            "title": "员工类型管理数据选择视图",
            "caption": "员工类型管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPEPickupView",
            "viewtag": "63a1bb30ff923eb9ac4df2d74c44d668"
        },
        "pimpersonjxqyggridview": {
            "title": "见习员工",
            "caption": "见习员工",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONJXQYGGridView",
            "viewtag": "64dfa07027b70064fc6dab4cbeac0d2d"
        },
        "pimarmycadresredirectview": {
            "title": "军转干部数据重定向视图",
            "caption": "军转干部",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESRedirectView",
            "viewtag": "65666d5f1faaf5338ad9bb8dd33eb644"
        },
        "pimcontractlweditview": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTLWEditView",
            "viewtag": "65b74d530e2f3a2a3bbb960ba56683d7"
        },
        "pimpersonabilityredirectview": {
            "title": "员工能力数据重定向视图",
            "caption": "员工能力",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityRedirectView",
            "viewtag": "65d8de4ae87e9b1fb24c674a215eb8e6"
        },
        "pimarchivesrecordredirectview": {
            "title": "档案目录缺失记录数据重定向视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESRECORDRedirectView",
            "viewtag": "66520242580b92b850fd7e2e9ea34a7b"
        },
        "pimexitandentrypimexitgridview": {
            "title": "出（国）境申请",
            "caption": "出（国）境基本信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYPimExitGridView",
            "viewtag": "668122fed6d5a6f4075bb8d940b2f4ff"
        },
        "pimtitlegreditview": {
            "title": "职称信息编辑视图",
            "caption": "职称信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEGREditView",
            "viewtag": "67361891f81ab9c6b591a34a4f19d8d0"
        },
        "pimpersonzddeditview": {
            "title": "人员首页编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONZDDEditView",
            "viewtag": "6802df4a263388456d2241b81f47a1d4"
        },
        "pimworkhistoryfazzsygridview": {
            "title": "工作履历",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYFAZZSYGridView",
            "viewtag": "687ded8f0a0afe913c868c1d03ab096b"
        },
        "pimcontracttypepickupview": {
            "title": "合同/协议类型管理数据选择视图",
            "caption": "合同类别",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTYPEPickupView",
            "viewtag": "6908bc40da5408f6ddc0a3b7f387a75f"
        },
        "pimpersongrzhzceditview": {
            "title": "证书信息编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONGRZHZCEditView",
            "viewtag": "696a6f8db4827b169cab745cfe16d4e7"
        },
        "pimvocationaleditview2": {
            "title": "执（职）业资格信息编辑视图",
            "caption": "证书信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALEditView2",
            "viewtag": "6970821790de4b72cbf27b1a71f00ff4"
        },
        "pimarchiveschangegridview": {
            "title": "调档记录表格视图",
            "caption": "调档记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGEGridView",
            "viewtag": "699f56dfd77ff3d47fdd4dcf226b8480"
        },
        "pimfaminfopimfimgridview": {
            "title": "家庭情况表格视图",
            "caption": "家庭情况",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOPimfimGridView",
            "viewtag": "6c4cbfc8f736328ae63518990928a246"
        },
        "pimarchiveseditview": {
            "title": "档案信息编辑视图",
            "caption": "档案信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESEditView",
            "viewtag": "6d0ccb404f6bbdea4aebbda249e975ed"
        },
        "pimeducationfazzsygridview": {
            "title": "教育背景",
            "caption": "教育背景",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONFAZZSYGridView",
            "viewtag": "6d40636efbc885882bbbde970fd72769"
        },
        "pimpersongreditview2": {
            "title": "个人信息编辑视图",
            "caption": "基本信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONGREditView2",
            "viewtag": "6d91ee27de098f3ecf6eda0c0b2e83c6"
        },
        "pimexitandentryformpickupdataview": {
            "title": "出入境管理表单选择数据视图",
            "caption": "出入境管理",
            "viewtype": "DEFORMPICKUPDATAVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYFormPickupDataView",
            "viewtag": "6dcd1d37af1d5ba8d3869d67271b618a"
        },
        "pimworkhistorypickupview": {
            "title": "工作履历数据选择视图",
            "caption": "工作履历",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYPickupView",
            "viewtag": "6dfbfe1f6d7649606bc4c7db40159ad1"
        },
        "pimresearchfindingsgrresearchgridview": {
            "title": "科研成果表格视图",
            "caption": "科研成果",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSGRRESEARCHGridView",
            "viewtag": "6e584bf144a5789ea78bbf293ec76973"
        },
        "pimdistirbutionmaturitydueeditview": {
            "title": "借调到期编辑视图",
            "caption": "借调到期",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONMaturityDueEditView",
            "viewtag": "6f4b078d3c031443a68b74847d25fd07"
        },
        "pimpersonabilitydetailgridview": {
            "title": "员工能力明细表格视图",
            "caption": "员工能力明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityDetailGridView",
            "viewtag": "6fdf97d8422be481526442e3043efb50"
        },
        "pimtitlecataloguenotpickupgridview": {
            "title": "职称目录管理选择表格视图",
            "caption": "职称目录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUENotPickupGridView",
            "viewtag": "70d5199756be96f6edee0ab9a0dec6fe"
        },
        "pimqualmajorselgridview": {
            "title": "执业资格专业表格视图",
            "caption": "执业资格专业",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORSelGridView",
            "viewtag": "70e54b3204eb4b22d2704e4ec0ab9086"
        },
        "pimachievementsmpickupview": {
            "title": "绩效信息数据多项选择视图",
            "caption": "绩效信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSMPickupView",
            "viewtag": "713bbf041d9e025b5b383db7c83a6b72"
        },
        "pimrewardpunishmentpimjanglgridview": {
            "title": "奖励惩罚表格视图",
            "caption": "奖惩信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTPimJanglGridView",
            "viewtag": "719049119fad9f3be18ffa99c24f8210"
        },
        "pimarchivesrecordpickupview": {
            "title": "档案目录缺失记录数据选择视图",
            "caption": "档案目录缺失记录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESRECORDPickupView",
            "viewtag": "7249fdded114526dd060cfcac1a5f209"
        },
        "pimvocationalgridview": {
            "title": "证书信息表格视图",
            "caption": "证书信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALGridView",
            "viewtag": "7268dd996b966c5cc72c0f62ae16e162"
        },
        "pimlanguageabilityeditview2": {
            "title": "语言能力编辑视图",
            "caption": "语言能力",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYEditView2",
            "viewtag": "727a87006d2965929466109fd95c09ac"
        },
        "parjxndkhjgeditview": {
            "title": "绩效年度考核结果编辑视图",
            "caption": "绩效年度考核结果",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "PARJXNDKHJGEditView",
            "viewtag": "735b59047f9e970b562e7edb6b8ed2f3"
        },
        "pimmajorsetypeeditview2": {
            "title": "专业序列类型编辑视图",
            "caption": "专业序列类型",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMMAJORSETYPEEditView2",
            "viewtag": "737e18bdbe10144ed95ac819ec55371a"
        },
        "pimeducationgrpimedugridview": {
            "title": "教育信息表格视图",
            "caption": "教育信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONGRPimEduGridView",
            "viewtag": "743edd9b24b03c784e7a5c484257b4b1"
        },
        "pimexitandentryeditview": {
            "title": "出（国）境管理编辑视图",
            "caption": "出（国）境申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYEditView",
            "viewtag": "74e08b2ad6a09563954713cbecebbff4"
        },
        "pimresearchfindingsgridview": {
            "title": "科研成果表格视图",
            "caption": "科研成果",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSGridView",
            "viewtag": "75ce5601a042351b5d51b164bb24dcf0"
        },
        "pimpersontxrypickupgridview": {
            "title": "退休人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONTXRYPickupGridView",
            "viewtag": "76e2968262248d2c01175dcee12c430b"
        },
        "pimpersonfalygmpickupview": {
            "title": "非A类员工",
            "caption": "人员信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONFALYGMPickupView",
            "viewtag": "7719efc97bcee8330fe943951b0ce5e8"
        },
        "pimexitandentrywfeditview": {
            "title": "补充信息",
            "caption": "补充信息",
            "viewtype": "DEWFEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYWFEditView",
            "viewtag": "77982666a6c74051cb07eff4fac7a894"
        },
        "pimcontracttreeexpview": {
            "title": "合同信息树导航视图",
            "caption": "合同信息",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTreeExpView",
            "viewtag": "78feec040fa2971a96fac3dbd7030080"
        },
        "pimfaminfoeditview": {
            "title": "家庭情况编辑视图",
            "caption": "家庭情况",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOEditView",
            "viewtag": "796f7a60de318a972fb9c335f4ca446f"
        },
        "pimpersoncurjhrypickupgridview": {
            "title": "人员选择",
            "caption": "人员选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCurJHRYPickupGridView",
            "viewtag": "7a08d5e7637c6b4ff0ae9e80ee8ba029"
        },
        "pimresearchfindingsmpickupview": {
            "title": "科研成果数据多项选择视图",
            "caption": "科研成果",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSMPickupView",
            "viewtag": "7b36987c87cb47fd31fdd133dc82e46a"
        },
        "ormpostejormorgidpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEJORMORGIDPickupGridView",
            "viewtag": "7c1e66c0fad42064a6e51ddd96c32d01"
        },
        "pimpersonchangehisrecgridview": {
            "title": "历史审核记录",
            "caption": "历史审核记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEHisRecGridView",
            "viewtag": "7c82bcf008bd9c66a7e08c5d1b3583ec"
        },
        "pimarchivesnoloyeenofilegridview": {
            "title": "非员工在档提醒表格视图",
            "caption": "非员工在档提醒",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESNOLOYEENOFILEGridView",
            "viewtag": "7c972c0604bdb8bddac7f9be3ce296f7"
        },
        "contractsignorgeditview2": {
            "title": "签约主体单位编辑视图",
            "caption": "签约主体单位",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "ContractSignORGEditView2",
            "viewtag": "7d0935884b082bafae53ac7249421257"
        },
        "pimcontractreneweditview": {
            "title": "合同信息编辑视图（新签/续签）",
            "caption": "合同新签/续签",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTRenewEditView",
            "viewtag": "7d8b1b3a6370fbb573da9956e2bff736"
        },
        "pimpersonhmdgridview": {
            "title": "黑名单表格视图",
            "caption": "黑名单",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONHMDGridView",
            "viewtag": "7d8f556220d7acf33780801065c39c8a"
        },
        "pimvocationalonlyreadeditview": {
            "title": "证书信息编辑视图",
            "caption": "证书信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALOnlyReadEditView",
            "viewtag": "7e906a7cf4a42c2e505c7bc2adc4dcee"
        },
        "pimvocationalcatalogpickupview": {
            "title": "职（执）业资格目录管理数据选择视图",
            "caption": "执（职）业资格管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALCATALOGPickupView",
            "viewtag": "7f18b9cb76b1b148c118a9ba7c431156"
        },
        "pimlanguageabilitygridview": {
            "title": "语言能力表格视图",
            "caption": "语言能力",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYGridView",
            "viewtag": "7f46a9805e74b7478c4f6f0e1ab245c5"
        },
        "pimmajorsetypempickupview": {
            "title": "专业序列类型数据多项选择视图",
            "caption": "专业序列类型",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMMAJORSETYPEMPickupView",
            "viewtag": "7fb241f3880cc8ba05a9b5782d2a35d1"
        },
        "pimdistirbutionpimfenpgridview": {
            "title": "分配信息表格视图",
            "caption": "分配信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionPImFenpGridView",
            "viewtag": "7fbc9b7e6a428e773b18ea130a7b86b3"
        },
        "archivalcatalogueredirectview": {
            "title": "档案目录数据重定向视图",
            "caption": "档案目录",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVALCATALOGUERedirectView",
            "viewtag": "7fc157542aabc5fefbe82f0915e7f8fc"
        },
        "pimvocationalpimziggridview": {
            "title": "证书信息表格视图",
            "caption": "证书信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALPimZigGridView",
            "viewtag": "80133c7eeb811cfeb62536c1dabafb0f"
        },
        "pimstafftypempickupview": {
            "title": "员工类型管理数据多项选择视图",
            "caption": "员工类型管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPEMPickupView",
            "viewtag": "804cc81bd7c2d2ebd7ef8ce6b1d78389"
        },
        "pimcontractylweditview": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTYLWEditView",
            "viewtag": "807483ea7abf9139ac9807293c3017c1"
        },
        "pimsearchfieldsetgridview": {
            "title": "组合查询条件设置表格视图",
            "caption": "组合查询条件设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetGridView",
            "viewtag": "819cf47180d621e44d6a2b3e4657771b"
        },
        "archivalcataloguegridview": {
            "title": "档案类别表格视图",
            "caption": "档案目录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVALCATALOGUEGridView",
            "viewtag": "81cf0534845590aa2ba94ec70460a34c"
        },
        "pimpersonkxzxygpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONKXZXYGPickupGridView",
            "viewtag": "82287d155d08b519d821d11fb296d2f0"
        },
        "pimtitlecataloguepickupgridview": {
            "title": "职称目录管理选择表格视图",
            "caption": "职称目录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUEPickupGridView",
            "viewtag": "826938fb17537ee4d18e8be9c06b4290"
        },
        "pimpersonabilityeditview2": {
            "title": "员工能力编辑视图",
            "caption": "员工能力",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityEditView2",
            "viewtag": "84170a18d1ecc3fb13ceebe17003a34a"
        },
        "pimpapermpickupview": {
            "title": "论文信息数据多项选择视图",
            "caption": "论文信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPERMPickupView",
            "viewtag": "853ab6798d19dc6146a9f9dfbc8030da"
        },
        "pimenclosureredirectview": {
            "title": "附件信息数据重定向视图",
            "caption": "附件信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSURERedirectView",
            "viewtag": "853c2bd28e76a454408348d184680a39"
        },
        "pimexitandentrypickupgridview": {
            "title": "出入境管理选择表格视图",
            "caption": "出入境管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYPickupGridView",
            "viewtag": "872a1916df873552b51c0bc15cf45e08"
        },
        "pimexitandentryyscgjxjeditview": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYYSCGJXJEditView",
            "viewtag": "873a148fca4068110c452146a61ed51c"
        },
        "pimeducationpimedugridview": {
            "title": "教育信息表格视图",
            "caption": "教育信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONPimEduGridView",
            "viewtag": "87e832e8a0468437a4c83ccbd3ff6fd2"
        },
        "pimarchivesnotoutgridview": {
            "title": "离职未转出档案表格视图",
            "caption": "离职未转出档案",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESNotoutGridView",
            "viewtag": "8a1f5bcb3efd6c1d19cda4b7769abab7"
        },
        "pimexitandentrywfactionview": {
            "title": "出入境管理工作流操作视图",
            "caption": "出入境管理",
            "viewtype": "DEWFACTIONVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYWFActionView",
            "viewtag": "8a51e75c965479950ac8ea920355fab0"
        },
        "pimmajorsetypepickupview": {
            "title": "专业序列类型数据选择视图",
            "caption": "专业序列类型",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMMAJORSETYPEPickupView",
            "viewtag": "8ac6c88ddba945cb91aae46458993976"
        },
        "pimvocationalcatalogeditview": {
            "title": "职（执）业资格目录管理编辑视图",
            "caption": "执（职）业资格管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALCATALOGEditView",
            "viewtag": "8b7bb8559ea51e3cb1f72c99bc6681d7"
        },
        "pimcontractredirectview": {
            "title": "合同信息数据重定向视图",
            "caption": "合同信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTRedirectView",
            "viewtag": "8b8c482e363815008539658f7a9c53e3"
        },
        "pimportalview": {
            "title": "Pim门户首页",
            "caption": "门户首页",
            "viewtype": "APPPORTALVIEW",
            "viewmodule": "Portal",
            "viewname": "PimPortalView",
            "viewtag": "8be166f8e5b8aec59faf7bdd19555a32"
        },
        "pimeducationgridview": {
            "title": "教育信息表格视图",
            "caption": "教育信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONGridView",
            "viewtag": "8c1be176ab915f4bd594dee492f411f5"
        },
        "pimdistirbutiongridview": {
            "title": "分配信息表格视图",
            "caption": "分配信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONGridView",
            "viewtag": "8ce3e86cef4e9e4e772f3b138c53bc7b"
        },
        "pimtitlegrpimzhicgridview": {
            "title": "职称信息表格视图",
            "caption": "职称信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEGRPimZhicGridView",
            "viewtag": "8d289990840370163ba7d2e04e702b87"
        },
        "pimvocationalgrpimziggridview": {
            "title": "证书信息表格视图",
            "caption": "证书信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALGRPimZigGridView",
            "viewtag": "8ee8762083879b62fcd0a752ade0db55"
        },
        "pimlabourcampanyeditview": {
            "title": "劳务派遣公司编辑视图",
            "caption": "劳务派遣公司管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLABOURCAMPANYEditView",
            "viewtag": "8f5bf5cb0d09fca031d70be078d42621"
        },
        "pimpersoneditview": {
            "title": "人员首页编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONEditView",
            "viewtag": "8fd92f189c89011b779240791ddce0b6"
        },
        "pimpersonxzkqrypickupgridview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONXZKQRYPickupGridView",
            "viewtag": "8fed2ba4c62c3ec5359e5c2a89a96835"
        },
        "pimtypecontractredirectview": {
            "title": "合同类型数据重定向视图",
            "caption": "合同类型",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTYPECONTRACTRedirectView",
            "viewtag": "900f6d253620ef1d48d8cfb5d5544a48"
        },
        "pimarchivesgrpimdangagridview": {
            "title": "档案信息表格视图",
            "caption": "档案信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESGRPimDangaGridView",
            "viewtag": "9169611f321f69156ca9500acf3a74e2"
        },
        "pimpersonabilitydetailpickupview": {
            "title": "员工能力明细数据选择视图",
            "caption": "员工能力明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityDetailPickupView",
            "viewtag": "920e11c94af311d21fbc5d9e6e9cedc7"
        },
        "pimworkhistoryeditview2": {
            "title": "工作履历编辑视图",
            "caption": "工作履历",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYEditView2",
            "viewtag": "92f82428e852521e3db04e82ae9a3e1e"
        },
        "pimvocationalmpickupview": {
            "title": "执（职）业资格信息数据多项选择视图",
            "caption": "证书信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALMPickupView",
            "viewtag": "94c3275ad81ae6f833545a92c24618d9"
        },
        "pimlabourcampanyredirectview": {
            "title": "劳务派遣公司管理数据重定向视图",
            "caption": "劳务派遣公司管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLABOURCAMPANYRedirectView",
            "viewtag": "9557e0658a255da307e5bb12da12c2c5"
        },
        "pimlabourcampanygridview": {
            "title": "劳务派遣公司表格视图",
            "caption": "劳务派遣公司",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLABOURCAMPANYGridView",
            "viewtag": "95c478e45c1b2660c25bb76dd2ea22d3"
        },
        "pimcontracttypeeditview2": {
            "title": "合同/协议类型管理编辑视图",
            "caption": "合同类别",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTYPEEditView2",
            "viewtag": "96537623ca43bbfc181567f66cd9bf41"
        },
        "pimfaminfogridview": {
            "title": "家庭情况表格视图",
            "caption": "家庭情况",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOGridView",
            "viewtag": "96a121142c496cc29aa017697da0713a"
        },
        "pimpersonchangereasoneditview": {
            "title": "驳回原因",
            "caption": "驳回原因",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEReasonEditView",
            "viewtag": "96b58b12bf963897510cd9e131a6365b"
        },
        "pimpersonquickeditview": {
            "title": "人员信息编辑视图",
            "caption": "员工信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONQuickEditView",
            "viewtag": "989e8d6cf1e2313c8bec03672ce0f7f9"
        },
        "pimsearchmodaleditview2": {
            "title": "组合查询模版编辑视图",
            "caption": "组合查询记录",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PimSearchModalEditView2",
            "viewtag": "98a9a548c85c0bb791f88eb269b8222c"
        },
        "pimvocationalgreditview": {
            "title": "证书信息编辑视图",
            "caption": "证书信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALGREditView",
            "viewtag": "9950b56d645056a8da079ac699ad6b4c"
        },
        "pimexitandentryeditview_spz": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYEditView_SPZ",
            "viewtag": "999e09e8da9eb8e818b7b6c814e56e82"
        },
        "pimsearchfieldsetcomplexsearchresultcustomview": {
            "title": "查询结果",
            "caption": "查询结果",
            "viewtype": "DECUSTOMVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetComPlexSearchResultCustomView",
            "viewtag": "99aec3fe8a1b270d2946ca010880b785"
        },
        "pimexitandentryyscgjgridview": {
            "title": "出入境管理实体表格视图（因私出国境）",
            "caption": "因私出（国）境",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYYSCGJGridView",
            "viewtag": "9a0fc29bb2f74862dd23e692fcbc12f9"
        },
        "pimpersonjxqpickupgridview": {
            "title": "见习期员工",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONJXQPickupGridView",
            "viewtag": "9a2c05af8951a2f278ffb5c7b579cb70"
        },
        "pimpersonxzkqrympickupview": {
            "title": "人员信息数据多项选择视图",
            "caption": "人员信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONXZKQRYMPickupView",
            "viewtag": "9a422142915db91049bf867e4f262fa2"
        },
        "ormorgsectorpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupGridView",
            "viewtag": "9a798be3d9be3d78987794d7465a1db6"
        },
        "ormorghtgldwqpickupgridview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGHTGLDWQPickupGridView",
            "viewtag": "9aa73807e56ba04b31b77a66659c1c94"
        },
        "pimarmycadreseditview2": {
            "title": "军转干部编辑视图",
            "caption": "军转干部",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESEditView2",
            "viewtag": "9ac92efaf99620778c3c7d2fd20cf33b"
        },
        "pimsearchfieldsetredirectview": {
            "title": "组合查询条件设置数据重定向视图",
            "caption": "组合查询条件设置",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetRedirectView",
            "viewtag": "9aee91cb29c180641d3ac7feefc6b752"
        },
        "pimeducationxlgridview": {
            "title": "学历",
            "caption": "学历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONXLGridView",
            "viewtag": "9b079bad0d0d43fe8d60f362f7922a51"
        },
        "index": {
            "title": "EHR—基础管理",
            "caption": "EHR—基础管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "PIM",
            "viewname": "Index",
            "viewtag": "9b447b0f9964dfe3ff240487c1d86342"
        },
        "pimrewardpunishmentpickupgridview": {
            "title": "奖励惩罚选择表格视图",
            "caption": "奖惩信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTPickupGridView",
            "viewtag": "9b7ed361d3a7e6580c4f8f3014c95508"
        },
        "pimpersonpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONPickupGridView",
            "viewtag": "9bbe3ca4d0fbd0ab1a333ff1f90cf105"
        },
        "pimdistirbutiongzllgridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionGZLLGridView",
            "viewtag": "9bd0fd6c3029eb4d1124d6207b635066"
        },
        "pimenclosureeditview": {
            "title": "附件信息编辑视图",
            "caption": "附件信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSUREEditView",
            "viewtag": "9c228a0fb01db04e9eddf0ca4275ce2e"
        },
        "pimdistirbutionworkrecordcustomview": {
            "title": "工作履历",
            "caption": "工作履历",
            "viewtype": "DECUSTOMVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionWorkRecordCustomView",
            "viewtag": "9c5e75d6468729cdfc5774aa8ddfa8d7"
        },
        "pimexitandentryeditview_ybh": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYEditView_YBH",
            "viewtag": "9cf772c0ac3be570bc8030ffe0d000da"
        },
        "pimpersonchangepickupgridview": {
            "title": "人员信息变更审核选择表格视图",
            "caption": "人员信息变更审核",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEPickupGridView",
            "viewtag": "9d6603782b6ef8e66c369ed58082708d"
        },
        "pimcontractpickupgridview": {
            "title": "合同信息选择表格视图",
            "caption": "合同信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTPickupGridView",
            "viewtag": "9d8ccc6c6e2f745ad59d92d9f8e09a94"
        },
        "pimrewardpunishmenteditview": {
            "title": "奖励惩罚编辑视图",
            "caption": "奖惩信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTEditView",
            "viewtag": "9ddb200191f860b35f61162eb6ad3a20"
        },
        "pimdistirbutioneditview": {
            "title": "分配信息编辑视图",
            "caption": "分配信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONEditView",
            "viewtag": "9def4871869e56f3eda70c8b29fcc463"
        },
        "pimpapergridview": {
            "title": "论文信息表格视图",
            "caption": "论文信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPERGridView",
            "viewtag": "9e5545699601eab0cd9354f80f265f44"
        },
        "pimarchivesloanandreturneditview2": {
            "title": "档案借阅及归还记录编辑视图",
            "caption": "档案借阅及归还记录",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESLOANANDRETURNEditView2",
            "viewtag": "a054950433bea5d2068be5ddfd866854"
        },
        "pimsearchmodalgridview": {
            "title": "组合查询模版表格视图",
            "caption": "组合查询记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchModalGridView",
            "viewtag": "a088e1e3045f5fb2f45cf38052101143"
        },
        "pimenclosurepimfujgridview": {
            "title": "附件信息表格视图",
            "caption": "附件信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSUREPimFujGridView",
            "viewtag": "a0d42b3740428217a63cf0bd45166d51"
        },
        "pcmrcxlpickupview": {
            "title": "人才序列数据选择视图",
            "caption": "人才序列",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMRCXLPickupView",
            "viewtag": "a0d8013080fccd9671334826f02bea04"
        },
        "pimarchiveschangepickupview": {
            "title": "档案归档地变更记录数据选择视图",
            "caption": "档案归档地变更记录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGEPickupView",
            "viewtag": "a0e845e3408c688f5a46472591ab341c"
        },
        "pimresearchfindingspickupview": {
            "title": "科研成果数据选择视图",
            "caption": "科研成果",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSPickupView",
            "viewtag": "a1267bca5d1002d0185d53935e95be1a"
        },
        "pimachievementsgrpimjixgridview": {
            "title": "绩效信息表格视图",
            "caption": "绩效信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSGRPimJixGridView",
            "viewtag": "a1b14701235d14c57d47f6792c85f8c3"
        },
        "pimtitlecataloguegridview": {
            "title": "职称目录管理表格视图",
            "caption": "职称目录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUEGridView",
            "viewtag": "a244f9fd24091560df1d952e8a6a282e"
        },
        "archivescentereditview": {
            "title": "档案室管理编辑视图",
            "caption": "档案室管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESCENTEREditView",
            "viewtag": "a2501af050813eae54209d97cbe16f1f"
        },
        "ormorgsectorpickupview": {
            "title": "部门管理数据选择视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupView",
            "viewtag": "a25f063acc6b1ebe129f9869c0a427b0"
        },
        "pimtitlepimzhicgridview": {
            "title": "职称信息表格视图",
            "caption": "职称信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEPimZhicGridView",
            "viewtag": "a2b904dc7d6f61660e5377b783da889e"
        },
        "pimsearchmodalpickupview": {
            "title": "组合查询模版数据选择视图",
            "caption": "组合查询记录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchModalPickupView",
            "viewtag": "a30501a2a9bedb2d4cfc309e75f1e074"
        },
        "pimlanguageabilitypickupview": {
            "title": "语言能力数据选择视图",
            "caption": "语言能力",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYPickupView",
            "viewtag": "a313abd8703b4d75947bb2e5a30547c6"
        },
        "pimpersoncurleaderpickupgridview": {
            "title": "部门负责人选择",
            "caption": "部门负责人选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCurLeaderPickupGridView",
            "viewtag": "a35cc1bab11157f3588b5ca6ada5e0d9"
        },
        "pimlanguageabilitygreditview": {
            "title": "语言能力编辑视图",
            "caption": "语言能力",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYGREditView",
            "viewtag": "a3ab7f76d0e6451aa6f98d3cc098b62e"
        },
        "pimworkhistorygrpimworkgridview": {
            "title": "工作履历表格视图",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYGRPimWorkGridView",
            "viewtag": "a471fab023da6cd1aa32b844c0770d14"
        },
        "ormorgsectorfpxxpickupview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORFPXXPickupView",
            "viewtag": "a4db4d02cef4b82eaba0a6bae9c38a88"
        },
        "pimtitlecatalogueeditview": {
            "title": "职称目录管理编辑视图",
            "caption": "职称目录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUEEditView",
            "viewtag": "a4e8b102553ecf95abf3f99f49571393"
        },
        "pimtitlecatalogueredirectview": {
            "title": "职称目录管理数据重定向视图",
            "caption": "职称目录",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUERedirectView",
            "viewtag": "a52ed72d7d95233b856d450e71ef4fee"
        },
        "pimpersoncurorgpersonpickupgridview": {
            "title": "人员选择",
            "caption": "人员选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCurOrgPersonPickupGridView",
            "viewtag": "a5c47cecf6e37e9999d17a67b0534876"
        },
        "pimpersongrzzeditview": {
            "title": "个人信息编辑视图",
            "caption": "基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONGRZZEditView",
            "viewtag": "a5cee92ec113ca98b2508d41a7009322"
        },
        "pimvocationalselgridview": {
            "title": "证书信息表格视图",
            "caption": "证书信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALSelGridView",
            "viewtag": "a68929f9efcd9790dfdf7ac787d4bf4d"
        },
        "pimpersonproinfoeditview2": {
            "title": "员工首页编辑视图",
            "caption": "员工首页",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONProInfoEditView2",
            "viewtag": "a73e3863450781ae4e390e6cd2c3fd6e"
        },
        "pimpersonzhzceditview": {
            "title": "证书信息编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONZHZCEditView",
            "viewtag": "a75234c9f1badf160bebfc6b1b00fc13"
        },
        "archivescenterredirectview": {
            "title": "档案室管理数据重定向视图",
            "caption": "档案室管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESCENTERRedirectView",
            "viewtag": "a7e8b69c03b08804486b80e82085c394"
        },
        "pimarmycadresmpickupview": {
            "title": "军转干部数据多项选择视图",
            "caption": "军转干部",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESMPickupView",
            "viewtag": "a876a0499f464f9f420c5a5cd76fc9c7"
        },
        "pimresearchfindingspickupgridview": {
            "title": "科研成果选择表格视图",
            "caption": "科研成果",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSPickupGridView",
            "viewtag": "a89481c7b76c1bf81a3e0df01a51eec2"
        },
        "pimtypecontractpickupgridview": {
            "title": "合同类型选择表格视图",
            "caption": "合同类型",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTYPECONTRACTPickupGridView",
            "viewtag": "a8e6e7eda63b37d598d7e093748a1460"
        },
        "pimcontracteditview": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTEditView",
            "viewtag": "a957fe4f2b902f476f50342656f65d19"
        },
        "pimexpaccountpickupview": {
            "title": "费用台账数据选择视图",
            "caption": "费用台账",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXPACCOUNTPickupView",
            "viewtag": "a98bdeb968be26f6fb7e0a62c4d78b27"
        },
        "pimpersonltxyggridview": {
            "title": "离（退）休人员",
            "caption": "离（退）休人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONLTXYGGridView",
            "viewtag": "a9ed8a2bef67f5ccfcde130ed72c28ba"
        },
        "pimpapergrpapergridview": {
            "title": "论文信息表格视图",
            "caption": "论文信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPERGrPAPERGridView",
            "viewtag": "aaa12f8e3c34f2dda731c14d5c4bd81a"
        },
        "pcmrcxlpickupgridview": {
            "title": "人才序列选择表格视图",
            "caption": "人才序列",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PCMRCXLPickupGridView",
            "viewtag": "ab4fdb5d4d8e9872e2949d4dc317736e"
        },
        "pimfaminfompickupview": {
            "title": "家庭情况数据多项选择视图",
            "caption": "家庭情况",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOMPickupView",
            "viewtag": "ab86e2b96015524ab54e8aac1b6408aa"
        },
        "pimlanguageabilitygryynlgridview": {
            "title": "语言能力表格视图",
            "caption": "语言能力",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYGRYYNLGridView",
            "viewtag": "ab8cfeb8fed141e3981d477b7544a75a"
        },
        "pimdistirbutionpickupgridview": {
            "title": "分配信息选择表格视图",
            "caption": "分配信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONPickupGridView",
            "viewtag": "ab922c7e9cd584c7f3c3ff47eb0812c7"
        },
        "pimarchivespickupview": {
            "title": "档案信息数据选择视图",
            "caption": "档案信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESPickupView",
            "viewtag": "abbd7388946c1b9969e038eecc01bf69"
        },
        "ormsignorgbdwpickupview": {
            "title": "注册单位选择",
            "caption": "注册单位选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgBDWPickupView",
            "viewtag": "ac7de56e61b78aaa25897700b290397a"
        },
        "pimrewardpunishmentredirectview": {
            "title": "奖励惩罚数据重定向视图",
            "caption": "奖惩信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTRedirectView",
            "viewtag": "ad1765381c4fc2a19463d7bf35ceae02"
        },
        "pimexitandentryygcgjgridview": {
            "title": "出入境管理实体表格视图（因公出国境）",
            "caption": "因公出（国）境",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYYGCGJGridView",
            "viewtag": "adafd3d52426b170e4c9731d99309ecb"
        },
        "pimdistirbutionddcoptionview": {
            "title": "调出",
            "caption": "分配信息",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONDDCOptionView",
            "viewtag": "af3d3d4dc74296b41cee1377231d3d06"
        },
        "contractsignorgpickupgridview": {
            "title": "签约主体单位选择表格视图",
            "caption": "签约主体单位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "ContractSignORGPickupGridView",
            "viewtag": "b0fd4b0a5cd44eceb16dba3fe515e730"
        },
        "pimarchivestreeexpview": {
            "title": "档案信息树导航视图",
            "caption": "档案信息",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESTreeExpView",
            "viewtag": "b1b7fe14a7dd0761bcf4844d0377ddde"
        },
        "pimresearchfindingseditview": {
            "title": "科研成果编辑视图",
            "caption": "科研成果",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSEditView",
            "viewtag": "b2d8bf186815cb39915a2856f121724d"
        },
        "ormsignorgpickupview": {
            "title": "法人主体数据选择视图",
            "caption": "法人主体",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgPickupView",
            "viewtag": "b2e88fc228c7b89b15bcb65d1b7b23a2"
        },
        "pimpersonchangereadeditview": {
            "title": "人员信息变更审核编辑视图",
            "caption": "员工信息审核记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEReadEditView",
            "viewtag": "b3b03c0f7d3bfb3dbb7f10662857bdbb"
        },
        "ormorgallleveltwoorgpickupview": {
            "title": "管理单位",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGAllLevelTwoOrgPickupView",
            "viewtag": "b3bea7eebaa3725e7530ca9d74511cf5"
        },
        "pimtitleeditview": {
            "title": "职称信息编辑视图",
            "caption": "职称信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEEditView",
            "viewtag": "b55357d4e36ad334e8f4f4174f796d27"
        },
        "pimpersonchangepickupview": {
            "title": "人员信息变更审核数据选择视图",
            "caption": "人员信息变更审核",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEPickupView",
            "viewtag": "b5585d4adbb1780797c8f639a80527da"
        },
        "archivalcatalogueeditview2": {
            "title": "档案目录编辑视图",
            "caption": "档案目录",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "ARCHIVALCATALOGUEEditView2",
            "viewtag": "b55d497981a20d9064c8ea5a209150fa"
        },
        "pimpersonsyqyggridview": {
            "title": "试用员工",
            "caption": "试用员工",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONSYQYGGridView",
            "viewtag": "b67bcd30b457b30ca3f0de999d97cef4"
        },
        "pimarchiveschangeeditview": {
            "title": "档案归档地变更记录编辑视图",
            "caption": "档案归档地变更记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGEEditView",
            "viewtag": "b75c19668934a942420d205ebc7bf4e2"
        },
        "pimlanguageabilityeditview": {
            "title": "语言能力编辑视图",
            "caption": "语言能力",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYEditView",
            "viewtag": "b8db05015388b6e80064e32729a09ea4"
        },
        "pimdistirbutionpickupview": {
            "title": "分配信息数据选择视图",
            "caption": "分配信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONPickupView",
            "viewtag": "b934c0066d025989a526c4ebd7a708dc"
        },
        "archivesmanagepickupview": {
            "title": "档案管理数据选择视图",
            "caption": "档案管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESMANAGEPickupView",
            "viewtag": "b971fbaebfc5ecebcda9ee78d23383bd"
        },
        "pimpersonkqjrypickupview": {
            "title": "选择请假人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONKQJRYPickupView",
            "viewtag": "bae22339aa20b0d05e7d0337c7ed5db8"
        },
        "pimdistirbutionmpickupview": {
            "title": "分配信息数据多项选择视图",
            "caption": "分配信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONMPickupView",
            "viewtag": "bb34b8478bf8259d0194a90e4975be4c"
        },
        "pimeducationmpickupview": {
            "title": "教育信息数据多项选择视图",
            "caption": "教育信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONMPickupView",
            "viewtag": "bb38beddc682fe47820190b5132e6674"
        },
        "pimachievementspickupgridview": {
            "title": "绩效信息选择表格视图",
            "caption": "绩效信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSPickupGridView",
            "viewtag": "bb6d7b7e4b801458081c0b2734f05391"
        },
        "pimpatentpickupview": {
            "title": "专利信息数据选择视图",
            "caption": "专利信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTPickupView",
            "viewtag": "bba5afc530935778cb1afce5211f74d8"
        },
        "pimrewardpunishmentgrpimjanglgridview": {
            "title": "奖励惩罚表格视图",
            "caption": "奖惩信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTGRPimJanglGridView",
            "viewtag": "bbb3532df1db989667a994204c98def1"
        },
        "pimpaperpapergridview": {
            "title": "论文信息表格视图",
            "caption": "论文信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPERPAPERGridView",
            "viewtag": "bc1613ceada47cb79ffba584ae33206d"
        },
        "pimcontracttyperedirectview": {
            "title": "合同/协议类型管理数据重定向视图",
            "caption": "合同类别",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTYPERedirectView",
            "viewtag": "bc1b818905f16a5ae7078e91eaf37670"
        },
        "pimpersontxqreditview": {
            "title": "请确认/修改退休信息",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonTXQREditView",
            "viewtag": "bcbbd9e4830d5e5c37306d5084f1d674"
        },
        "pimarchivespimdangagridview": {
            "title": "档案信息表格视图",
            "caption": "档案信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESPimDangaGridView",
            "viewtag": "bdaf31b6411a15672bec48d830fd7fa7"
        },
        "pimachievementsredirectview": {
            "title": "绩效信息数据重定向视图",
            "caption": "绩效信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSRedirectView",
            "viewtag": "be9637c8474eea63ae68dc33036ba37e"
        },
        "pimpersonabilitypickupgridview": {
            "title": "员工能力选择表格视图",
            "caption": "员工能力",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityPickupGridView",
            "viewtag": "be96e973a7213b911d905dbc165a3daf"
        },
        "pimtitleeditview2": {
            "title": "职称信息编辑视图",
            "caption": "职称信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEEditView2",
            "viewtag": "bebf24408408daa65b963c41ff58079e"
        },
        "pimpersonryinfoeditview": {
            "title": "人员信息编辑视图",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONRYInfoEditView",
            "viewtag": "c05753c87731f02b862491ae2d4fc908"
        },
        "pimfaminfojtlxrpickupgridview": {
            "title": "家庭联系人",
            "caption": "家庭情况",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOJTLXRPickupGridView",
            "viewtag": "c0d6ffd5c6d3b970644e05220cbba672"
        },
        "pimcontractydtxgridview9": {
            "title": "合同信息表格视图",
            "caption": "合同信息",
            "viewtype": "DEGRIDVIEW9",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTYDTXGridView9",
            "viewtag": "c0f1bc736dfc3ab0725853ea44be8121"
        },
        "pimlanguageabilitypickupgridview": {
            "title": "语言能力选择表格视图",
            "caption": "语言能力",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYPickupGridView",
            "viewtag": "c16f0ac8c597e77dc75e685594b23c38"
        },
        "pimrewardpunishmentpickupview": {
            "title": "奖励惩罚数据选择视图",
            "caption": "奖惩信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTPickupView",
            "viewtag": "c19d3490981193d4543883074d4d9e59"
        },
        "pimstafftypeselgridview": {
            "title": "员工类型表格视图",
            "caption": "员工类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPESelGridView",
            "viewtag": "c266cb80d9c6ac7756f8e188c9737280"
        },
        "archivesmanagegridview": {
            "title": "档案管理表格视图",
            "caption": "档案管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESMANAGEGridView",
            "viewtag": "c277ab0dab0e7112bd1199bf16408331"
        },
        "pimpersonchangeredirectview": {
            "title": "人员信息变更审核数据重定向视图",
            "caption": "人员信息变更审核",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGERedirectView",
            "viewtag": "c2f97aa6a957271ce38bbd9cf1bf3f59"
        },
        "pimpersonjxspickupview": {
            "title": "见习生选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONJXSPickupView",
            "viewtag": "c4478bdc1c086ead09a90be43e752df2"
        },
        "pimpersonkxzxygpickupview": {
            "title": "试用期员工",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONKXZXYGPickupView",
            "viewtag": "c4bb597f7c1bdb7d35ac3e71c0b1ffb1"
        },
        "pimexitandentryygcgjxjeditview": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYYGCGJXJEditView",
            "viewtag": "c5ffcee9c740d6d420ec6159d25df1aa"
        },
        "pimachievementspickupview": {
            "title": "绩效信息数据选择视图",
            "caption": "绩效信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSPickupView",
            "viewtag": "c6cc7bf58db6e771eb68662d8e4de102"
        },
        "pimexitandentrypickupview": {
            "title": "出入境管理数据选择视图",
            "caption": "出入境管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYPickupView",
            "viewtag": "c74d7660fcd0fde7b31ac4bf6a3e0294"
        },
        "archivesmanageeditview2": {
            "title": "档案管理编辑视图",
            "caption": "档案管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESMANAGEEditView2",
            "viewtag": "c98e6c181ba5f766936e2d1aa1e53c3f"
        },
        "ormorgfpxxpickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGFPXXPickupGridView",
            "viewtag": "ca7667cedba153dc03d8c8c09cc1f1a3"
        },
        "pimdistirbutiongrpimfenpgridview": {
            "title": "分配信息表格视图",
            "caption": "分配信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionGRPImFenpGridView",
            "viewtag": "ca97bed3bb453441300668716e458757"
        },
        "pimtitlepickupview": {
            "title": "职称信息数据选择视图",
            "caption": "职称信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEPickupView",
            "viewtag": "cb4732a1482c2c319a0bb6e95750bc2e"
        },
        "pimcontracttypempickupview": {
            "title": "合同/协议类型管理数据多项选择视图",
            "caption": "合同类别",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTYPEMPickupView",
            "viewtag": "cb8d1fc019c5947d8db04e9b3e3ac94c"
        },
        "pimarmycadresarmygridview": {
            "title": "军转干部表格视图",
            "caption": "军转干部",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESARMYGridView",
            "viewtag": "cc266564b3f51daaea8b907e94e9dd04"
        },
        "pimarchivesmpickupview": {
            "title": "档案信息数据多项选择视图",
            "caption": "档案信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESMPickupView",
            "viewtag": "cd8fe14b9e228da6e6ce6d7526663b62"
        },
        "pimpatentpatentgridview": {
            "title": "专利信息表格视图",
            "caption": "专利信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTPATENTGridView",
            "viewtag": "ce1160d87a00bc775eaa92013a0f2ef3"
        },
        "contractsignorggridview": {
            "title": "法人主体设置",
            "caption": "法人主体设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "ContractSignORGGridView",
            "viewtag": "cee8f56f1c0a83afa076d103777a75e8"
        },
        "archivescentergridview": {
            "title": "档案室管理表格视图",
            "caption": "档案室管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESCENTERGridView",
            "viewtag": "cf07226cf97f3e8429dd04917035b611"
        },
        "contractsignorgeditview": {
            "title": "法人主体设置编辑视图",
            "caption": "签约主体单位",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "ContractSignORGEditView",
            "viewtag": "cf999616e09e379c2a0a46be3ed99e0b"
        },
        "pimpapereditview": {
            "title": "论文信息编辑视图",
            "caption": "论文信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPEREditView",
            "viewtag": "cfe4f5afb6a17974025709324fd1aec9"
        },
        "pimarchivesloanandreturneditview": {
            "title": "档案借阅及归还记录编辑视图",
            "caption": "档案借阅及归还记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESLOANANDRETURNEditView",
            "viewtag": "cff19d2a8e287146de758291301506d6"
        },
        "pimcontractexpiregridview": {
            "title": "合同到期表格视图",
            "caption": "合同到期",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTExpireGridView",
            "viewtag": "d1a9a1664fb83bdf890bafd2f12ff984"
        },
        "pimexitandentryformpickupview": {
            "title": "出入境管理数据选择视图",
            "caption": "出入境管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYFormPickupView",
            "viewtag": "d227fea187b028c56e6b2af8a170be88"
        },
        "pimdistirbutionredirectview": {
            "title": "分配信息数据重定向视图",
            "caption": "分配信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONRedirectView",
            "viewtag": "d2626af89490fcbaed39b480fba63609"
        },
        "pimpatentgridview": {
            "title": "专利信息表格视图",
            "caption": "专利信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTGridView",
            "viewtag": "d28335eaacc4e94ccbefbceebad7d232"
        },
        "pimenclosurempickupview": {
            "title": "附件信息数据多项选择视图",
            "caption": "附件信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSUREMPickupView",
            "viewtag": "d2d7208da29279d5531cc770a21f3363"
        },
        "pimpatentgrpatentgridview": {
            "title": "专利信息表格视图",
            "caption": "专利信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTGRPATENTGridView",
            "viewtag": "d3daf721f525e937b4b7b1e77db21003"
        },
        "pimexitandentrympickupview": {
            "title": "出入境管理数据多项选择视图",
            "caption": "出入境管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYMPickupView",
            "viewtag": "d3e16252bac98766bb18f45acdebb6e7"
        },
        "pimtitlepickupgridview": {
            "title": "职称信息选择表格视图",
            "caption": "职称信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLEPickupGridView",
            "viewtag": "d4835d9e053dae1b44d3d5f86629bfce"
        },
        "pimtitlecataloguenotpickupview": {
            "title": "职称目录管理数据选择视图",
            "caption": "职称目录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUENotPickupView",
            "viewtag": "d49fd7fa079e107b7f31f415b4cc8537"
        },
        "pimqualmajoreditview": {
            "title": "执业资格专业",
            "caption": "执业资格专业",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJOREditView",
            "viewtag": "d4b210c054213905f88419649974a419"
        },
        "pimexpaccountredirectview": {
            "title": "费用台账数据重定向视图",
            "caption": "费用台账",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXPACCOUNTRedirectView",
            "viewtag": "d5e7597c1af7bc7d6ebf289570809db1"
        },
        "pimarchiveseditview2": {
            "title": "档案信息编辑视图",
            "caption": "档案信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESEditView2",
            "viewtag": "d7c9c28e6e2a3327a7c79f299b6680d7"
        },
        "pcmdetailpickupview": {
            "title": "人员明细表数据选择视图",
            "caption": "人员花名册",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PCMDETAILPickupView",
            "viewtag": "d854545202fb61ea0e57b836ec17c547"
        },
        "pimtypecontractpickupview": {
            "title": "合同类型数据选择视图",
            "caption": "合同类型",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTYPECONTRACTPickupView",
            "viewtag": "d87898d3830ac381c5022dac83bf3245"
        },
        "pimresearchfindingsredirectview": {
            "title": "科研成果数据重定向视图",
            "caption": "科研成果",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSRedirectView",
            "viewtag": "d914a6f2f5bb02ac70cd225e69d8ee4c"
        },
        "pimpaperpickupview": {
            "title": "论文信息数据选择视图",
            "caption": "论文信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPERPickupView",
            "viewtag": "d92bdd291eb3a092dd2a3eec2b80450e"
        },
        "pimarchivesloanandreturnpickupview": {
            "title": "档案借阅及归还记录数据选择视图",
            "caption": "档案借阅及归还记录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESLOANANDRETURNPickupView",
            "viewtag": "d965dd93de209e08e3b511d9af0cd821"
        },
        "contractsignorgredirectview": {
            "title": "签约主体单位数据重定向视图",
            "caption": "签约主体单位",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "ContractSignORGRedirectView",
            "viewtag": "daad0739d561a4bfde57e4cf39d337a9"
        },
        "pimstafftypeseleditview": {
            "title": "员工类型编辑视图",
            "caption": "员工类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPESelEditView",
            "viewtag": "dab91dcbd91df7f69e652598b8d3228b"
        },
        "pimworkhistorygbllgridview": {
            "title": "工作履历",
            "caption": "工作履历",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYGBLLGridView",
            "viewtag": "dae003e488bbbf5fc12b8f781c2b292a"
        },
        "pimtypecontracteditview2": {
            "title": "合同类型编辑视图",
            "caption": "合同类型",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMTYPECONTRACTEditView2",
            "viewtag": "db560fc4da30cc525e1b16b9e25ef3db"
        },
        "pimcontracttypeselgridview": {
            "title": "合同类型表格视图",
            "caption": "合同类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTYPESelGridView",
            "viewtag": "dbc94f78072cd79aadfb2db24fade536"
        },
        "pimtitleredirectview": {
            "title": "职称信息数据重定向视图",
            "caption": "职称信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLERedirectView",
            "viewtag": "dc3f604354c20e8882be6f2ed5a352d3"
        },
        "pimresearchfindingsresearchgridview": {
            "title": "科研成果表格视图",
            "caption": "科研成果",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMRESEARCHFINDINGSRESEARCHGridView",
            "viewtag": "dc68131064e2696cebab97f195439653"
        },
        "pimcontractstoptimeselecteditview": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTStopTimeSelectEditView",
            "viewtag": "dc934f359f06860942bf24bc7cf5bc8b"
        },
        "pcmdetailpickupgridview": {
            "title": "人员明细表选择表格视图",
            "caption": "人员花名册",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PCMDETAILPickupGridView",
            "viewtag": "dcf05680df55ea6c64e42df3209fbed0"
        },
        "pimpersonpickupview": {
            "title": "人员信息数据选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONPickupView",
            "viewtag": "dd1cb79d950f565eaa08292a68f2bdd2"
        },
        "pimqualtyperedirectview": {
            "title": "执业资格类别数据重定向视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALTYPERedirectView",
            "viewtag": "ddad3ed0b796b2992aab7492cf507dda"
        },
        "trmlgbcostgridview": {
            "title": "老干部活动管理",
            "caption": "老干部活动管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TRMLGBCOSTGridView",
            "viewtag": "dddc3f0be62026e4d2ede67e62746f4e"
        },
        "archivesmanagempickupview": {
            "title": "档案管理数据多项选择视图",
            "caption": "档案管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESMANAGEMPickupView",
            "viewtag": "de585858f088c99f8aae7eac044eba63"
        },
        "pimdistirbutionjddqgridview": {
            "title": "借调人员",
            "caption": "借调人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONJDDQGridView",
            "viewtag": "de88c4bca349bbc6bcb02f478970cde5"
        },
        "pimpatentpickupgridview": {
            "title": "专利信息选择表格视图",
            "caption": "专利信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTPickupGridView",
            "viewtag": "ded7534535d36f84b864cd3f8c3733ca"
        },
        "pimqualmajorredirectview": {
            "title": "执业资格专业数据重定向视图",
            "caption": "执业资格专业",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORRedirectView",
            "viewtag": "df1f1e4f44013b7f69b45de627f168ad"
        },
        "pimpersonabilitygridview": {
            "title": "员工能力表格视图",
            "caption": "员工能力",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityGridView",
            "viewtag": "e1101a28fb6703dc5a9a9e01d726fe01"
        },
        "pimqualmajorgridview": {
            "title": "执业资格专业",
            "caption": "执业资格专业",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALMAJORGridView",
            "viewtag": "e1fa33d9a9ef62606b265a129ed77cbe"
        },
        "pimqualtypeeditview": {
            "title": "岗位（技能）证书编辑视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALTYPEEditView",
            "viewtag": "e22aa356608b9bc9452dc1264c887bee"
        },
        "ormdutyormorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrmOrgSectorPickupGridView",
            "viewtag": "e24b90687ff51628929b268024bc9a84"
        },
        "pimpersontxrypickupview": {
            "title": "选择退休人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONTXRYPickupView",
            "viewtag": "e27c534bdf9b6a24c3ce01958e6c4c5d"
        },
        "pimarmycadresgreditview": {
            "title": "军转干部编辑视图",
            "caption": "军转干部",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARMYCADRESGREditView",
            "viewtag": "e2f413329297be240e97ccb90f2c0005"
        },
        "pimpersonchangempickupview": {
            "title": "人员信息变更审核数据多项选择视图",
            "caption": "人员信息变更审核",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONCHANGEMPickupView",
            "viewtag": "e31465b1e63e066d57a46f01711b7b9e"
        },
        "pimarchivesloanandreturngridview": {
            "title": "借阅记录表格视图",
            "caption": "借阅记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESLOANANDRETURNGridView",
            "viewtag": "e4578fcf28ac57284ff4ca985773edf6"
        },
        "pimtitlecataloguempickupview": {
            "title": "职称目录管理数据多项选择视图",
            "caption": "职称目录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTITLECATALOGUEMPickupView",
            "viewtag": "e4b5268de0fe3c1610e2fae2b4875643"
        },
        "pimsearchfieldsetdictionarymgrgridview": {
            "title": "属性字典管理",
            "caption": "组合查询条件设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetDictionaryMgrGridView",
            "viewtag": "e4b97312969bf75b4501f77cdaced827"
        },
        "pimlanguageabilitympickupview": {
            "title": "语言能力数据多项选择视图",
            "caption": "语言能力",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMLANGUAGEABILITYMPickupView",
            "viewtag": "e5849bb3c19ccdfcf0006f87a908afac"
        },
        "pimpersonbylygpickupgridview": {
            "title": "B/Y类员工",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONBYLYGPickupGridView",
            "viewtag": "e6c2b59b8af33f4972c4681656df01ae"
        },
        "pimpatentredirectview": {
            "title": "专利信息数据重定向视图",
            "caption": "专利信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTRedirectView",
            "viewtag": "e7fca2c7c5771a2e110e331b4afe4fa5"
        },
        "pimexitandentrygridview": {
            "title": "出入境管理",
            "caption": "出入境管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYGridView",
            "viewtag": "e8199777e7497d39817f8d7c48b9a067"
        },
        "pimcontractxylweditview": {
            "title": "合同信息编辑视图",
            "caption": "合同信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTXYLWEditView",
            "viewtag": "e854e8d4d2ca3421547fd89368c956ce"
        },
        "pimexitandentryygzzgridview": {
            "title": "出入境管理实体表格视图（员工自助）",
            "caption": "出（国）境申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYYGZZGridView",
            "viewtag": "e897a4c32e46f3f67d02d96bee5656e8"
        },
        "pimtypecontracteditview": {
            "title": "合同类型编辑视图",
            "caption": "合同类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTYPECONTRACTEditView",
            "viewtag": "e8db54a4b997adaeebdb886851e17369"
        },
        "pimfaminfogrpimfimgridview": {
            "title": "家庭情况表格视图",
            "caption": "家庭情况",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFOGRPimfimGridView",
            "viewtag": "ea3a716f3b88eb8dc81adf5b899a1b13"
        },
        "pimdistirbutioneditview2": {
            "title": "分配信息编辑视图",
            "caption": "分配信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionEditView2",
            "viewtag": "eb36f882b7cde138668e4de83557ea8a"
        },
        "pimcontracttypegridview": {
            "title": "合同类别表格视图",
            "caption": "合同类别",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTYPEGridView",
            "viewtag": "eb48eb4459e5cfe548c9a052b7097548"
        },
        "pimrewardpunishmenteditview2": {
            "title": "奖励惩罚编辑视图",
            "caption": "奖惩信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMREWARDPUNISHMENTEditView2",
            "viewtag": "eb7798cfe9a071d7fc06d0a769ddb9b3"
        },
        "pimexitandentryeditview_ng": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYEditView_NG",
            "viewtag": "eb782be65606634b8d2dbd29b6c6c97a"
        },
        "pimpersonlzyghmcgridview": {
            "title": "离职员工",
            "caption": "离职员工",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPERSONLZYGHMCGridView",
            "viewtag": "eb9653f376333616bccf8f9560e62c93"
        },
        "pimdistirbutionkddfppickupgridview": {
            "title": "可调动的分配",
            "caption": "分配信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONKDDFPPickupGridView",
            "viewtag": "ebfa27253101450e2433d28cf037682b"
        },
        "pimmajorsetypepickupgridview": {
            "title": "专业序列类型选择表格视图",
            "caption": "专业序列类型",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMMAJORSETYPEPickupGridView",
            "viewtag": "ec3c29eba3009f1ecc2dad64aa0a6213"
        },
        "pimtypecontractmpickupview": {
            "title": "合同类型数据多项选择视图",
            "caption": "合同类型",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMTYPECONTRACTMPickupView",
            "viewtag": "ecd8a7f8619377d0a4a84f2b5434cff1"
        },
        "contractsignorgpickupview": {
            "title": "签约主体单位数据选择视图",
            "caption": "签约主体单位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "ContractSignORGPickupView",
            "viewtag": "ecdd77ccf5051101a590a9d5b64fa516"
        },
        "pimdistirbutionjdryhmcgridview": {
            "title": "借调人员花名册",
            "caption": "借调人员花名册",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionJDRYHMCGridView",
            "viewtag": "ed44db0490d330fba632498accfecc6a"
        },
        "pimdistirbutionkddmpickupview": {
            "title": "可调动的分配",
            "caption": "分配信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMDISTIRBUTIONKDDMPickupView",
            "viewtag": "ed52265ef5148ab978467955b761bd1a"
        },
        "pimpaperredirectview": {
            "title": "论文信息数据重定向视图",
            "caption": "论文信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPAPERRedirectView",
            "viewtag": "ed59ccdb32be2d2b6cb28b83f7f7c584"
        },
        "pimpatenteditview2": {
            "title": "专利信息编辑视图",
            "caption": "专利信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PIMPATENTEditView2",
            "viewtag": "edd969b76a369bfdf8611b828ec9bbf2"
        },
        "pimcontractldgridview": {
            "title": "劳动合同管理表格视图",
            "caption": "劳动合同管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTLDGridView",
            "viewtag": "ee09e261fc3acfe72cc903661b561931"
        },
        "pimarchiveschangearchiveseditview": {
            "title": "档案调档记录编辑视图",
            "caption": "档案归档地变更记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGEArchivesEditView",
            "viewtag": "eed3edb04a9f23a14222887616af4ccb"
        },
        "pimsearchfieldsetpickupgridview": {
            "title": "组合查询条件设置选择表格视图",
            "caption": "组合查询条件设置",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetPickupGridView",
            "viewtag": "ef63d71d2c0cc943082c62757d398732"
        },
        "pimdistirbutiongzlleditview": {
            "title": "工作履历编辑视图",
            "caption": "工作履历",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionGZLLEditView",
            "viewtag": "f1915e9b6d210f5364baf497579d33e6"
        },
        "ormsignorgpickupgridview": {
            "title": "法人主体选择表格视图",
            "caption": "法人主体",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgPickupGridView",
            "viewtag": "f2785102952f75ba5496239372fd18a0"
        },
        "trmtrianpersongridview": {
            "title": "培训记录表格视图",
            "caption": "培训记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TRMTRIANPERSONGridView",
            "viewtag": "f293b599f7feaaffd1d3c7519a579118"
        },
        "pimstafftyperedirectview": {
            "title": "员工类型管理数据重定向视图",
            "caption": "员工类型管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMSTAFFTYPERedirectView",
            "viewtag": "f2a46591aa5789a2f008221d3e12836f"
        },
        "pimarchivespickupgridview": {
            "title": "档案信息选择表格视图",
            "caption": "档案信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESPickupGridView",
            "viewtag": "f2be7ee88f6c6da58992eb86bb02b367"
        },
        "archivesmanageredirectview": {
            "title": "档案管理数据重定向视图",
            "caption": "档案管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "ARCHIVESMANAGERedirectView",
            "viewtag": "f2d70fefe4800e93ea8ceae9466079da"
        },
        "pcmdetaileditview2": {
            "title": "人员明细表编辑视图",
            "caption": "人员花名册",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PIM",
            "viewname": "PCMDETAILEditView2",
            "viewtag": "f2d7ff5edc5a38af3176c51791acde5e"
        },
        "pimsearchfieldsetmpickupview": {
            "title": "组合查询条件设置数据多项选择视图",
            "caption": "组合查询条件设置",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetMPickupView",
            "viewtag": "f338226fd0e8b1ee34053076b832e0a5"
        },
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGPickupView",
            "viewtag": "f371e4070e801887340a0116f23d291a"
        },
        "pimpersonabilitydetailpickupgridview": {
            "title": "员工能力明细选择表格视图",
            "caption": "员工能力明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityDetailPickupGridView",
            "viewtag": "f3d9d52717239a215f869382fe000445"
        },
        "ormorgxmbqpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGXMBQPickupView",
            "viewtag": "f40af2e1d984fea080dbb6b564c68d84"
        },
        "pimexitandentryeditview_yqx": {
            "title": "出（国）境基本信息",
            "caption": "出（国）境基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEXITANDENTRYEditView_YQX",
            "viewtag": "f4345496a02e72acba25ebfded4323cd"
        },
        "pimarchivesloanandreturnmpickupview": {
            "title": "档案借阅及归还记录数据多项选择视图",
            "caption": "档案借阅及归还记录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESLOANANDRETURNMPickupView",
            "viewtag": "f468cfee241a5510d763b420ea715a23"
        },
        "pimenclosuregridview": {
            "title": "附件信息表格视图",
            "caption": "附件信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMENCLOSUREGridView",
            "viewtag": "f46b9de3a7438d9fca1e71aab42b107c"
        },
        "contractsignorgmpickupview": {
            "title": "签约主体单位数据多项选择视图",
            "caption": "签约主体单位",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "ContractSignORGMPickupView",
            "viewtag": "f56a991e37ba4a28598e5e7b0a4ab85a"
        },
        "ormorgxjpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGXjPickupView",
            "viewtag": "f5975ab13d8dd051888a72bd5783c03b"
        },
        "pimqualtypeselgridview": {
            "title": "执业资格类别表格视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALTYPESelGridView",
            "viewtag": "f5a5a4c07f3310c58e402340360bf05a"
        },
        "pimsearchfieldseteditview": {
            "title": "组合查询条件设置编辑视图",
            "caption": "组合查询条件设置",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchFieldSetEditView",
            "viewtag": "f5a70415a5b8015463b1c213e1a1c282"
        },
        "pimachievementsgridview": {
            "title": "绩效信息表格视图",
            "caption": "绩效信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMACHIEVEMENTSGridView",
            "viewtag": "f8235125582236baaebfbdd8657f6ffe"
        },
        "pimvocationalcataloggridview": {
            "title": "职（执）业资格目录管理表格视图",
            "caption": "执（职）业资格管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMVOCATIONALCATALOGGridView",
            "viewtag": "f82c1ccdf47a3d995f7904256392ac41"
        },
        "pimeducationpickupgridview": {
            "title": "教育信息选择表格视图",
            "caption": "教育信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONPickupGridView",
            "viewtag": "f86d9627a69e42c205024f54e20f4bf0"
        },
        "pimmajorsetyperedirectview": {
            "title": "专业序列类型数据重定向视图",
            "caption": "专业序列类型",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMMAJORSETYPERedirectView",
            "viewtag": "f8ca53db69de42d1b555d77b30ad8a8b"
        },
        "attendancemreportmxwscgridview": {
            "title": "考勤信息",
            "caption": "考勤信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "ATTENDANCEMREPORTMXWscGridView",
            "viewtag": "fab303ed55b60ecd0e8b6e77f938d2ab"
        },
        "pimworkhistoryeditview": {
            "title": "工作履历编辑视图",
            "caption": "工作履历",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMWORKHISTORYEditView",
            "viewtag": "face08be9bcc54a8c02a259269d44e5f"
        },
        "pimqualtypegridview": {
            "title": "岗位（技能）证书别表格视图",
            "caption": "岗位（技能）证书",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMQUALTYPEGridView",
            "viewtag": "fb5e26840aacac6a9dec7336e5ae1c8c"
        },
        "pimsearchmodalpickupgridview": {
            "title": "组合查询模版选择表格视图",
            "caption": "组合查询记录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimSearchModalPickupGridView",
            "viewtag": "fbd7bcb4ae3624e381ed924210e89134"
        },
        "pimdistirbutionlgeditview": {
            "title": "轮岗查询编辑视图",
            "caption": "轮岗查询",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimDistirbutionLGEditView",
            "viewtag": "fc41d3f5d38424e69ff086dd8c712b95"
        },
        "pimcontracttypepickupgridview": {
            "title": "合同/协议类型管理选择表格视图",
            "caption": "合同类别",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMCONTRACTTYPEPickupGridView",
            "viewtag": "fc4a8b19851004d81514700f4c083146"
        },
        "pimpersonabilitympickupview": {
            "title": "员工能力数据多项选择视图",
            "caption": "员工能力",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMPersonAbilityMPickupView",
            "viewtag": "fc4fd6d874faca7a3998b7baa6fcc1f4"
        },
        "ormsignorghtqddwwpickupview": {
            "title": "合同签订单位选择",
            "caption": "合同签订单位选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgHTQDDWWPickupView",
            "viewtag": "fcf2d558671f105049ccb96321a1f72d"
        },
        "pimfaminforedirectview": {
            "title": "家庭情况数据重定向视图",
            "caption": "家庭情况",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMFAMINFORedirectView",
            "viewtag": "fcfe84d61ee46b0dad5a3eee3af5053b"
        },
        "pcmdetailredirectview": {
            "title": "人员明细表数据重定向视图",
            "caption": "人员花名册",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PCMDETAILRedirectView",
            "viewtag": "fe36e01368dc1faab06e9c03ff5bab6c"
        },
        "pimarchiveschangedadcjlgridview": {
            "title": "档案调出记录",
            "caption": "档案调出记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMARCHIVESCHANGEDADCJLGridView",
            "viewtag": "fe7b00219922eede26cfaddc3ad03115"
        },
        "pimeducationredirectview": {
            "title": "教育信息数据重定向视图",
            "caption": "教育信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PIM",
            "viewname": "PIMEDUCATIONRedirectView",
            "viewtag": "fed60f5ddd7904ea5e13a7ef07374f99"
        },
        "pcmdetailgridview": {
            "title": "人员花名册",
            "caption": "人员花名册",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PCMDETAILGridView",
            "viewtag": "ff905ccbd2eb91da54e121c5b3b7e1ac"
        }
    }];
});