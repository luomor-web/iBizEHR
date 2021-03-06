import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "ormxmbqeditview": {
            "title": "项目标签编辑视图",
            "caption": "项目标签",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBQEditView",
            "viewtag": "00167068a07a6fd8bf6af7d42bcdb7fe"
        },
        "ormorgsectorpxmbpickupview": {
            "title": "项目部选择",
            "caption": "项目部选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORPXMBPickupView",
            "viewtag": "00ecbb9fd1e54c86b378d211f2ed1180"
        },
        "ormorgsectorbmkqszgridview": {
            "title": "考勤设置",
            "caption": "考勤设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORBMKQSZGridView",
            "viewtag": "0168c1c9e32f678b4caf3c837949d678"
        },
        "ormxmbqredirectview": {
            "title": "项目标签数据重定向视图",
            "caption": "项目标签",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBQRedirectView",
            "viewtag": "01b62bf4ee2d769386b7340ce0194d03"
        },
        "ormpostlibredirectview": {
            "title": "岗位库数据重定向视图",
            "caption": "岗位库",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostLibRedirectView",
            "viewtag": "0231831987f217c1ac06c9f2d435155e"
        },
        "ormsignorgeditview2": {
            "title": "法人主体编辑视图",
            "caption": "法人主体",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgEditView2",
            "viewtag": "027822e9e2ba528a82e78ec34de9b285"
        },
        "ormsignorghtqddwpickupgridview": {
            "title": "合同签订单位选择",
            "caption": "合同签订单位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgHTQDDWPickupGridView",
            "viewtag": "02d3dd23f6e7f76cbe2b908ee93ab1a4"
        },
        "ormorgxmbqpickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgXMBQPickupGridView",
            "viewtag": "03478df3682bcaae0f318d655b7373a4"
        },
        "ormdepestmangridview": {
            "title": "部门编制管理表格视图",
            "caption": "部门职务编制",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManGridView",
            "viewtag": "03cb206cebf250d64379f5afe20335da"
        },
        "ormxmgleditview": {
            "title": "ERP项目信息",
            "caption": "ERP项目",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMGLEditView",
            "viewtag": "0510210a4b9130f383d5bede5257acfa"
        },
        "ormorgdzeditview2": {
            "title": "组织地址维护编辑视图",
            "caption": "组织地址维护",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMORGDZEditView2",
            "viewtag": "07f5aba18665e67110b05f8c81b40d25"
        },
        "ormorgeditview9_editmode": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "ORM",
            "viewname": "ORMORGEditView9_EditMode",
            "viewtag": "0873c4b0b1d17e12e06877c537c308f6"
        },
        "ormpostlibmpickupview": {
            "title": "标准岗位",
            "caption": "标准岗位",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostLibMPickupView",
            "viewtag": "0a73019b4898b090e1b0888e7243e623"
        },
        "ormorgsectoreditview2": {
            "title": "部门管理编辑视图",
            "caption": "部门管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTOREditView2",
            "viewtag": "0a89d6513bc1186fa422e5b871701789"
        },
        "ormbmgwbzpickupgridview": {
            "title": "部门岗位编制选择表格视图",
            "caption": "部门岗位编制",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMGWBZPickupGridView",
            "viewtag": "0b1b6b603074c3c1d264f7f2b0ced330"
        },
        "ormqyglpickupview": {
            "title": "区域补贴",
            "caption": "区域补贴",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYGLPickupView",
            "viewtag": "0bed2d27bed82cb41de695eec8d7ae31"
        },
        "ormxmglpickupview": {
            "title": "ERP项目库",
            "caption": "ERP项目库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMGLPickupView",
            "viewtag": "0c174f5840924ca06915e66bc28d4ac0"
        },
        "pimpersonpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "PIMPERSONPickupGridView",
            "viewtag": "0d0168d0e6cb4ad17054b601763ca5c2"
        },
        "ormorgsectormpickupview": {
            "title": "部门管理数据多项选择视图",
            "caption": "部门管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorMPickupView",
            "viewtag": "0e46f8be3d5e20ad6335a555f1980a61"
        },
        "ormorgsectorcurzzbmkqszgridview": {
            "title": "考勤设置",
            "caption": "考勤设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORCurZZBMKQSZGridView",
            "viewtag": "0eeb52282fd08f91bc9c41d434b4cdc5"
        },
        "ormorginfosubsubsuborggridview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoSubSubSubOrgGridView",
            "viewtag": "105526ebbb117b495e7f3a69f6d6d11d"
        },
        "ormerporgeditview2": {
            "title": "ERP组织中间表编辑视图",
            "caption": "ERP组织中间表",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGEditView2",
            "viewtag": "10f8f030c7711a08f5d0663ecf2180b7"
        },
        "ormbmkqdzeditview": {
            "title": "考勤地址信息",
            "caption": "考勤地址信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZEditView",
            "viewtag": "1204f602861ee84407a280392ef01ad3"
        },
        "ormrelationeditview2": {
            "title": "组织管理关系表编辑视图",
            "caption": "组织管理关系表",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMRelationEditView2",
            "viewtag": "1621943e035775a1211bb58a24967374"
        },
        "ormdepestmanredirectview": {
            "title": "部门编制管理数据重定向视图",
            "caption": "部门职务编制",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManRedirectView",
            "viewtag": "17be95697d6cb7660e00b03a30bfe5ee"
        },
        "ormorgqbzzpickupview": {
            "title": "选择组织",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGQBZZPickupView",
            "viewtag": "183a9f50d89b59c40f31318266a26242"
        },
        "ormdepestmanzwgridview": {
            "title": "职务编制明细",
            "caption": "职务编制明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManZWGridView",
            "viewtag": "18e432f89fca5dc481d3dd4f883bd1b0"
        },
        "contractsignorgredirectview": {
            "title": "签约主体单位数据重定向视图",
            "caption": "签约主体单位",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ContractSignORGRedirectView",
            "viewtag": "19a9e098cd1907c0470c60b78271ca84"
        },
        "ormorgsjyxzzpickupgridview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSJYXZZPickupGridView",
            "viewtag": "1a088b3d3fe63301a93f2eee2a1c3286"
        },
        "ormorgorgtreeexpview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGOrgTreeExpView",
            "viewtag": "1a4b3351937fb97f3f1a296bb63e5665"
        },
        "ormsignorghtqddwwpickupview": {
            "title": "合同签订单位选择",
            "caption": "合同签订单位选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgHTQDDWWPickupView",
            "viewtag": "1a4f9348d653fa9b3ffbf6e757eef909"
        },
        "ormorggridview": {
            "title": "组织单元管理",
            "caption": "组织单元管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGGridView",
            "viewtag": "1b37bb8ead62da05ae58776d394e4b5e"
        },
        "ormorgdzredirectview": {
            "title": "组织地址维护数据重定向视图",
            "caption": "组织地址维护",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGDZRedirectView",
            "viewtag": "1bae30eba13afd1729c5850bcbae2822"
        },
        "contractsignorggridview": {
            "title": "法人主体设置",
            "caption": "法人主体设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ContractSignORGGridView",
            "viewtag": "1c14464d67d8176e1e3836cbe5f262b9"
        },
        "ormxmbmxeditview": {
            "title": "项目部人员明细",
            "caption": "项目部人员明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBMXEditView",
            "viewtag": "1cc2d0b0bb43dbf894d937d1da73b369"
        },
        "ormbmgwbzredirectview": {
            "title": "部门岗位编制数据重定向视图",
            "caption": "部门岗位编制",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMGWBZRedirectView",
            "viewtag": "1d4fbfcdc67086dfd37e4a0bef895b8d"
        },
        "ormorgsectorbmbzglgridview": {
            "title": "部门管理",
            "caption": "部门管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORBMBZGLGridView",
            "viewtag": "1ea00488f7a66d1492ec775504ef7cc0"
        },
        "ormerporgredirectview": {
            "title": "ERP组织中间表数据重定向视图",
            "caption": "ERP组织中间表",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGRedirectView",
            "viewtag": "1fef71f1e23036a7e81221e7265773c0"
        },
        "ormtitleeditview": {
            "title": "标准头衔设置",
            "caption": "标准头衔设置",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMTITLEEditView",
            "viewtag": "20409a4000684d60605a2c640c77885f"
        },
        "ormdutyestmanpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYEstManPickupView",
            "viewtag": "2085e4c3c9c8252e6f963b88cc207f4c"
        },
        "ormdepestmanpickupgridview": {
            "title": "部门编制管理选择表格视图",
            "caption": "部门职务编制",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManPickupGridView",
            "viewtag": "2132e1a9136efdcb2c4f21fa4d487655"
        },
        "contractsignorgpickupview": {
            "title": "签约主体单位数据选择视图",
            "caption": "签约主体单位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ContractSignORGPickupView",
            "viewtag": "22ab0ae0967e3c7f533efe0e168fbf1a"
        },
        "ormorgsectorbmbztreeexpview": {
            "title": "部门管理",
            "caption": "部门管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORBMBZTreeExpView",
            "viewtag": "23715a033355eff24ae4bb83980615d9"
        },
        "ormbmkqdzpickupgridview": {
            "title": "部门地址维护选择表格视图",
            "caption": "部门地址维护",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZPickupGridView",
            "viewtag": "2626bf3e8febdad1d9c28c91074f1c43"
        },
        "ormpostnrgwpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTNRGWPickupGridView",
            "viewtag": "27a18db5cd680e4e8eb12499214838a7"
        },
        "ormorgsectorxmbbztreeexpview": {
            "title": "项目部管理",
            "caption": "项目部管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORXMBBZTreeExpView",
            "viewtag": "27b4167c491c41954dad4f28a35e458a"
        },
        "contractsignorgpickupgridview": {
            "title": "签约主体单位选择表格视图",
            "caption": "签约主体单位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ContractSignORGPickupGridView",
            "viewtag": "27fb388dd15b16ee3e92f7c159d87ba7"
        },
        "ormxmbqmpickupview": {
            "title": "项目标签数据多项选择视图",
            "caption": "项目标签",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBQMPickupView",
            "viewtag": "2aa3d073ee5f5fa06cc56211e0fe2e73"
        },
        "ormorgxmbqpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGXMBQPickupView",
            "viewtag": "2b2d9880ef43097b9378bde74e87788d"
        },
        "ormorginfogridview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoGridView",
            "viewtag": "2bca9675dd6b05676e70b87e4e656727"
        },
        "ormerporgpickupview": {
            "title": "ERP组织库",
            "caption": "ERP组织库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGPickupView",
            "viewtag": "2c035a40e2d1b4a241672c1f34ecb875"
        },
        "ormtitleredirectview": {
            "title": "头衔管理数据重定向视图",
            "caption": "头衔管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMTITLERedirectView",
            "viewtag": "2c2cd84c7f69411d4edee83ab22b1254"
        },
        "ormorgeditview2": {
            "title": "组织管理编辑视图",
            "caption": "组织管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMORGEditView2",
            "viewtag": "2d9308a808303b73b9e72203f3ea4f35"
        },
        "contractsignorgmpickupview": {
            "title": "签约主体单位数据多项选择视图",
            "caption": "签约主体单位",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ContractSignORGMPickupView",
            "viewtag": "2f7eadc794fa0e156b25f10ac2a81617"
        },
        "pimpersoncurleaderpickupgridview": {
            "title": "部门负责人选择",
            "caption": "部门负责人选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "PIMPERSONCurLeaderPickupGridView",
            "viewtag": "301c68075489cfeabd55ed788e76e4cc"
        },
        "ormbmkqdzmpickupview": {
            "title": "部门地址维护数据多项选择视图",
            "caption": "部门地址维护",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZMPickupView",
            "viewtag": "31178f6e1eb0a815fa2af2e8fd8dfceb"
        },
        "ormqyglmpickupview": {
            "title": "区域管理数据多项选择视图",
            "caption": "补贴标准",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYGLMPickupView",
            "viewtag": "3283e68449d7c40ba4084b94980756e4"
        },
        "ormdutygridview": {
            "title": "职务设置",
            "caption": "职务设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYGridView",
            "viewtag": "33707b04587e169b829099ecc00f4215"
        },
        "ormtitlempickupview": {
            "title": "标准头衔库",
            "caption": "标准头衔库",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMTITLEMPickupView",
            "viewtag": "337991e5e3d2ae798ba40ee685f3197a"
        },
        "ormorgeditview": {
            "title": "组织信息",
            "caption": "组织信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGEditView",
            "viewtag": "34201778b70a0175b7664955bd8ae2bf"
        },
        "ormpostlibcxgridview": {
            "title": "标准岗位查询",
            "caption": "标准岗位查询",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostLibCXGridView",
            "viewtag": "343ea136eea85ae2077e353b63f159c3"
        },
        "ormorginforedirectview": {
            "title": "组织信息数据重定向视图",
            "caption": "组织信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoRedirectView",
            "viewtag": "361b0b77c05e7358f23b20765d79080f"
        },
        "ormeditiongridview": {
            "title": "版本对照表表格视图",
            "caption": "版本对照表",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMEDITIONGridView",
            "viewtag": "37838993c481449ee1c707851cafcbd1"
        },
        "ormorgsectorxmrlzyeditview": {
            "title": "项目信息完善",
            "caption": "项目信息完善",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORXMRLZYEditView",
            "viewtag": "38d8780f3cdd20ce80f44f03d3c7e933"
        },
        "ormorgsectorredirectview": {
            "title": "部门管理数据重定向视图",
            "caption": "部门管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORRedirectView",
            "viewtag": "3b499b8332625ad5e778ebf48c9c5f8b"
        },
        "ormerporgpickupgridview": {
            "title": "ERP组织库",
            "caption": "ERP组织库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGPickupGridView",
            "viewtag": "3b49d5b35ba893a5721d339ad9c7d952"
        },
        "ormsignorgpickupgridview": {
            "title": "法人主体选择表格视图",
            "caption": "法人主体",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgPickupGridView",
            "viewtag": "3bf75c8fcaea17058c834eb6b08a7a7f"
        },
        "ormpostdetailsgridview": {
            "title": "岗位明细",
            "caption": "岗位明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostDetailsGridView",
            "viewtag": "3c77de98c2fdb19e58c87284875a8d0a"
        },
        "ormpostmpickupview": {
            "title": "岗位管理数据多项选择视图",
            "caption": "岗位",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTMPickupView",
            "viewtag": "3cf4b1f3290d18a0f40dd4438ef76d35"
        },
        "ormorgsectorcurzzbm_kqszpickupview": {
            "title": "部门管理数据选择视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORCurZZBM_KQSZPickupView",
            "viewtag": "3d09187aad197e86a9da61cbb926d745"
        },
        "ormorghtgldwpickupview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGHTGLDWPickupView",
            "viewtag": "419ceeec0dd9fbd29ea1941f9f4a2002"
        },
        "ormrelationpickupgridview": {
            "title": "组织管理关系表选择表格视图",
            "caption": "组织管理关系表",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMRelationPickupGridView",
            "viewtag": "422750489b28ae1ffa779dc7608fdd28"
        },
        "ormeditionmpickupview": {
            "title": "版本对照表数据多项选择视图",
            "caption": "版本对照表",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMEDITIONMPickupView",
            "viewtag": "43b3a77711a9e6bf06d3964f773de398"
        },
        "ormorgsectorfpxxpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORFPXXPickupGridView",
            "viewtag": "442004fe4e1e8b67b0e31e235a23005c"
        },
        "ormxmbqeditview2": {
            "title": "项目标签编辑视图",
            "caption": "项目标签",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMXMBQEditView2",
            "viewtag": "462ee18509b5f6ca55b77ceb485c9066"
        },
        "ormdutypickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYPickupView",
            "viewtag": "46baa3ad6f5ab96693885a3bb5439cc8"
        },
        "ormdepestmanmpickupview": {
            "title": "部门编制管理数据多项选择视图",
            "caption": "部门职务编制",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManMPickupView",
            "viewtag": "47bc9889252f9736e4200328c6fd1b74"
        },
        "ormpostdetailspickupgridview": {
            "title": "岗位明细选择表格视图",
            "caption": "岗位明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostDetailsPickupGridView",
            "viewtag": "482dd93a145f77680ee1d4c7390fedb4"
        },
        "ormdutyestmanpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYEstManPickupGridView",
            "viewtag": "48867f9e6403a20b92fb9f3afde932bc"
        },
        "ormorginfosubsuborggridview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoSubSubOrgGridView",
            "viewtag": "48c992b9c9b2e9103346429123a16f33"
        },
        "ormorgredirectview": {
            "title": "组织管理数据重定向视图",
            "caption": "组织管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGRedirectView",
            "viewtag": "49057ccfd5bf31ffbfa836f8f778d6aa"
        },
        "ormpostgwxhwheditview": {
            "title": "岗位集设置",
            "caption": "岗位集设置",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTGWXHWHEditView",
            "viewtag": "4acc409a4d7965da8ca6216b4b153cc3"
        },
        "ormdutyorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrgSectorPickupGridView",
            "viewtag": "4b818e76181e4b52f49999630bec3683"
        },
        "ormxmbmxpickupview": {
            "title": "项目部明细数据选择视图",
            "caption": "项目部明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBMXPickupView",
            "viewtag": "4b9a502b1f9604541e2fa7d690c226be"
        },
        "ormpostdetailseditview": {
            "title": "岗位明细",
            "caption": "岗位明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostDetailsEditView",
            "viewtag": "4c23c804046de5b0f9af83bda3c44d65"
        },
        "ormorgsectorxmbbzgleditview": {
            "title": "项目部管理",
            "caption": "项目部管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORXMBBZGLEditView",
            "viewtag": "4ef237e2c28057944767d00bd6696459"
        },
        "ormorgfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGFPXXPickupView",
            "viewtag": "5014be708e988772fd28a1b27d38bebd"
        },
        "ormorgsectorbmbzgleditview": {
            "title": "部门管理",
            "caption": "部门管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORBMBZGLEditView",
            "viewtag": "50528e44db72f027c378dfdaa0062b19"
        },
        "ormxmgleditview2": {
            "title": "项目管理编辑视图",
            "caption": "项目管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMXMGLEditView2",
            "viewtag": "51ef3f2edaf1fe177d2eb16893ab1084"
        },
        "ormerporgeditview": {
            "title": "ERP组织中间表编辑视图",
            "caption": "ERP组织中间表",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGEditView",
            "viewtag": "5219c3c559df32121480588a0bfa42c9"
        },
        "ormorgsectorcurbmkqszgridview": {
            "title": "考勤设置",
            "caption": "考勤设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORCurBMKQSZGridView",
            "viewtag": "528a39ea522c7ee93fa2699122a7e309"
        },
        "ormeditioneditview2": {
            "title": "版本对照表编辑视图",
            "caption": "版本对照表",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMEDITIONEditView2",
            "viewtag": "53b6082f71acf71a296529769036410f"
        },
        "ormposteditview2": {
            "title": "岗位管理编辑视图",
            "caption": "岗位",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEditView2",
            "viewtag": "5471f33c6706a4eac8d3ede83581085f"
        },
        "ormerporglegalpickupview": {
            "title": "管理单位",
            "caption": "管理单位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGLegalPickupView",
            "viewtag": "554eb543b49570981a4da3eac2837099"
        },
        "ormorgsectorbmkqszeditview": {
            "title": "部门管理",
            "caption": "部门管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORBMKQSZEditView",
            "viewtag": "55e513ac96021ffa7bc2e6f47048bf39"
        },
        "ormorginfopickupview": {
            "title": "组织信息数据选择视图",
            "caption": "组织信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoPickupView",
            "viewtag": "55ed4f50fb3608851959c20d7ba745cc"
        },
        "ormorgallleveltwoorgpickupview": {
            "title": "管理单位",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGAllLevelTwoOrgPickupView",
            "viewtag": "56467013038a4b887329bae51aa5767d"
        },
        "ormxmglmpickupview": {
            "title": "ERP项目库",
            "caption": "ERP项目库",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMGLMPickupView",
            "viewtag": "5763bbe4eeaf92c9345e3e616625f3f0"
        },
        "ormorgsectorcurzzbm_kqszpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORCurZZBM_KQSZPickupGridView",
            "viewtag": "57e41c1a629999407ba7e766fbe3c089"
        },
        "ormpostgwbzxzmpickupview": {
            "title": "岗位库",
            "caption": "岗位库",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTGWBZXZMPickupView",
            "viewtag": "583b76059b38d2f9baef70383e4922a1"
        },
        "ormxmbqgridview": {
            "title": "项目标签",
            "caption": "项目标签",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBQGridView",
            "viewtag": "59540c7e4db29bd446ff4a470ac24af5"
        },
        "ormorgallsignorgorgpickupview": {
            "title": "签约单位",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGAllSignOrgOrgPickupView",
            "viewtag": "59a8459d9dbf40e30e1d41be8a2219cc"
        },
        "ormorgsectorxmbmgridview": {
            "title": "项目部",
            "caption": "项目部",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORXMBMGridView",
            "viewtag": "5a8a13f0da64a45fdf433bd381077cda"
        },
        "ormbmkqdzbmkqdzgridview": {
            "title": "考勤地址信息",
            "caption": "考勤地址信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZBMKQDZGridView",
            "viewtag": "5b5a2a575f87e5f3a62bdf7fef751bf8"
        },
        "ormorgjqgzsypickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGJQGZSYPickupGridView",
            "viewtag": "5c1fdf499da4d88aa5ab609e26aabd54"
        },
        "ormorgsectorpickupview": {
            "title": "部门管理数据选择视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupView",
            "viewtag": "5cb59e6581d926f5700f66d39409551d"
        },
        "ormdutympickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYMPickupView",
            "viewtag": "5d35b27532c26e87dacd0fa742c1bb0a"
        },
        "ormorginfoorgtreegridview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoOrgTreeGridView",
            "viewtag": "5e353bf207eb1ef0267867b35310e64a"
        },
        "ormorgjqgzsyfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGJQGZSYFPXXPickupView",
            "viewtag": "5ec86c9a7d6fd45a459175e5d5169c62"
        },
        "ormorgsectorydbmpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORYDBMPickupGridView",
            "viewtag": "5fdcb042188e14845ff84d00c71be8ef"
        },
        "ormpostpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTPickupView",
            "viewtag": "5fdcd8003c1e353b80ef2e73f1aab8be"
        },
        "ormorgsjorgpickupview": {
            "title": "上级组织选择视图",
            "caption": "上级组织选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSJOrgPickupView",
            "viewtag": "6062c2d2018e65fc93001312538b2dc8"
        },
        "ormorgsjorgpickupgridview": {
            "title": "上级组织选择视图",
            "caption": "上级组织选择视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSJOrgPickupGridView",
            "viewtag": "60d8da46db2b9a46c6d98b5a6bd4b05b"
        },
        "ormorgsjyxzzqxpickupview": {
            "title": "选择组织",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSJYXZZQXPickupView",
            "viewtag": "6227b3edf60abdce98e0046858f6dd04"
        },
        "ormorgsyzzpickupgridview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSYZZPickupGridView",
            "viewtag": "632c086225a640f911f126bf79195b8b"
        },
        "ormerporgorgsectorgridview": {
            "title": "ERP组织库",
            "caption": "ERP组织库",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGOrgsectorGridView",
            "viewtag": "6541da834889b0a65160a61a90fde45b"
        },
        "ormdepestmanpickupview": {
            "title": "部门编制管理数据选择视图",
            "caption": "部门职务编制",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManPickupView",
            "viewtag": "68d30419564ad80a067d22765a243ae1"
        },
        "ormorgmpickupview": {
            "title": "组织管理数据多项选择视图",
            "caption": "组织管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGMPickupView",
            "viewtag": "69619424de6c2f43def9e86d79472a13"
        },
        "ormpostdetailseditview2": {
            "title": "岗位明细编辑视图",
            "caption": "岗位明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMPostDetailsEditView2",
            "viewtag": "69a6b5564f77c05b5861a64cce47232e"
        },
        "ormorgdzgridview": {
            "title": "地址信息",
            "caption": "地址信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGDZGridView",
            "viewtag": "69d1ca3780b5660c1e6ac964f38a47fa"
        },
        "ormxmbmxmpickupview": {
            "title": "项目部明细数据多项选择视图",
            "caption": "项目部明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBMXMPickupView",
            "viewtag": "6a35612f35068dda8b1e7cf93b5839a1"
        },
        "ormorgsectorxmrlzygridview": {
            "title": "项目信息完善",
            "caption": "项目信息完善",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORXMRLZYGridView",
            "viewtag": "6aa98c7848d800d6d32d82ecc40abefb"
        },
        "ormorgsectorpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupGridView",
            "viewtag": "6b7c50ef65ada8954275cd9bcd415232"
        },
        "ormorginfopickupgridview": {
            "title": "组织信息选择表格视图",
            "caption": "组织信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoPickupGridView",
            "viewtag": "6cc310342474cea3c1050c10fc4d2789"
        },
        "ormdepestmaneditview2": {
            "title": "部门编制管理编辑视图",
            "caption": "部门职务编制",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManEditView2",
            "viewtag": "6edcb1235ea62532cefa6b6c1c3ce935"
        },
        "ormpostlibgridview": {
            "title": "标准岗位设置",
            "caption": "标准岗位设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostLibGridView",
            "viewtag": "6fcc75caf7850e6ca18c135f0916f948"
        },
        "ormxmbmxredirectview": {
            "title": "项目部明细数据重定向视图",
            "caption": "项目部明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBMXRedirectView",
            "viewtag": "704777f8b0faf40b3d68b19a04e32ef0"
        },
        "ormpostdetailsmpickupview": {
            "title": "岗位明细数据多项选择视图",
            "caption": "岗位明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostDetailsMPickupView",
            "viewtag": "710ef89461585d07e1c04703e7c49ee2"
        },
        "ormorgdzmpickupview": {
            "title": "组织地址维护数据多项选择视图",
            "caption": "组织地址维护",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGDZMPickupView",
            "viewtag": "7122bd5b3c427253c1e1f52017141c4a"
        },
        "ormpostgwxhwhgridview": {
            "title": "岗位设置",
            "caption": "岗位设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTGWXHWHGridView",
            "viewtag": "73b7461f2c4789cb2e1c310295ea0d0f"
        },
        "ormbmkqdzpickupview": {
            "title": "部门地址维护数据选择视图",
            "caption": "部门地址维护",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZPickupView",
            "viewtag": "760802cfad305c13dfa9558ab1575e49"
        },
        "ormorgdzpickupgridview": {
            "title": "组织地址维护选择表格视图",
            "caption": "组织地址维护",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGDZPickupGridView",
            "viewtag": "76efd8777d5f917c5eaa2bc11b054a62"
        },
        "contractsignorgeditview": {
            "title": "法人主体设置编辑视图",
            "caption": "签约主体单位",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ContractSignORGEditView",
            "viewtag": "79fe5c0c8ff6e616e9a945a44e224844"
        },
        "ormpostjzbgwpickupview": {
            "title": "局总部岗位",
            "caption": "局总部岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTJZBGWPickupView",
            "viewtag": "7a2d79b0b8a4fb1b8ae2958393feae56"
        },
        "ormorgxjpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGXjPickupView",
            "viewtag": "7ad9113d783e5ed6ecbf193be79981d0"
        },
        "ormorginfoeditview2": {
            "title": "组织信息编辑视图",
            "caption": "组织信息",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoEditView2",
            "viewtag": "7d348936b811eba3358d6ff0ac0e9825"
        },
        "ormxmbmxgridview": {
            "title": "项目部人员明细",
            "caption": "项目部人员明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBMXGridView",
            "viewtag": "7d94c09553961c655a31376f988d3176"
        },
        "ormorgdzeditview": {
            "title": "组织地址维护编辑视图",
            "caption": "组织地址维护",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGDZEditView",
            "viewtag": "7da4fb21031e6fe44577c63910d52141"
        },
        "ormdutyorgsectorpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrgSectorPickupView",
            "viewtag": "7e02c10a381593b621d0fc402426978f"
        },
        "ormbmgwbzeditview2": {
            "title": "部门岗位编制编辑视图",
            "caption": "部门岗位编制",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMBMGWBZEditView2",
            "viewtag": "7e8482bcf5bac0c2967ee9a2b318e819"
        },
        "pimpersonpickupview": {
            "title": "人员信息数据选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "PIMPERSONPickupView",
            "viewtag": "8436eb64bc2d83095beb80cbf1b0e2bc"
        },
        "ormrelationgridview": {
            "title": "组织管理关系表表格视图",
            "caption": "组织管理关系表",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMRelationGridView",
            "viewtag": "84a3849b3c484bc02c75443b4077a83a"
        },
        "ormpostpickupgridview": {
            "title": "岗位管理选择表格视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostPickupGridView",
            "viewtag": "855de99194a1f051419ad4cb529588b8"
        },
        "ormorgsectorkqsztreeexpview": {
            "title": "考勤设置树导航视图",
            "caption": "考勤设置",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORKQSZTreeExpView",
            "viewtag": "87cbe78cdfe94747bb2a6450beece0b9"
        },
        "ormqygleditview2": {
            "title": "区域管理编辑视图",
            "caption": "补贴标准",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMQYGLEditView2",
            "viewtag": "88276e9aa1c6902bff7a12506d2709e9"
        },
        "ormdepestmanzweditview": {
            "title": "职务编制明细",
            "caption": "职务编制明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManZWEditView",
            "viewtag": "887e2fe445bf2c335ea3c9a91de8081f"
        },
        "ormdutyredirectview": {
            "title": "职务管理数据重定向视图",
            "caption": "职务管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYRedirectView",
            "viewtag": "8c11143ae9815525844a449cb705f811"
        },
        "ormxmbmxeditview2": {
            "title": "项目部明细编辑视图",
            "caption": "项目部明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMXMBMXEditView2",
            "viewtag": "8ca24765daf4023d57727122485b4d3e"
        },
        "ormbmgwbzpickupview": {
            "title": "部门岗位编制数据选择视图",
            "caption": "部门岗位编制",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMGWBZPickupView",
            "viewtag": "8d4e79d6a4a2fc437d9804fe611451d4"
        },
        "ormorgsectorxmbbzglgridview": {
            "title": "项目部管理",
            "caption": "项目部管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORXMBBZGLGridView",
            "viewtag": "8e66c854d0943d9602e039a0c9a3e805"
        },
        "ormrelationredirectview": {
            "title": "组织管理关系表数据重定向视图",
            "caption": "组织管理关系表",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMRelationRedirectView",
            "viewtag": "8ea7dedb7766aae57448a00f22df8a11"
        },
        "ormposteditview": {
            "title": "岗位设置",
            "caption": "岗位设置",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEditView",
            "viewtag": "91203040ce0bccce32d1ccf404be2fa4"
        },
        "ormsignorgeditview": {
            "title": "法人主体编辑视图",
            "caption": "法人主体",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgEditView",
            "viewtag": "917714c6b3de7ed13424d76ca50070e2"
        },
        "ormorgsectoreditview9": {
            "title": "部门/项目部管理",
            "caption": "部门/项目部管理",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTOREditView9",
            "viewtag": "91d1827444477b9939c3989b4c924b82"
        },
        "ormeditionredirectview": {
            "title": "版本对照表数据重定向视图",
            "caption": "版本对照表",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMEDITIONRedirectView",
            "viewtag": "91ff0900099e3673ffa5934e43993ffe"
        },
        "ormorgsjyxzzpickupview": {
            "title": "选择组织",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSJYXZZPickupView",
            "viewtag": "941a7bb20b1867385c13364b605b7b8f"
        },
        "ormorgsectorxmbmeditview": {
            "title": "项目部",
            "caption": "项目部",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORXMBMEditView",
            "viewtag": "94eccd3bffee2c24798cbedf65787f90"
        },
        "ormpostlibeditview2": {
            "title": "岗位库编辑视图",
            "caption": "岗位库",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMPostLibEditView2",
            "viewtag": "95aacaf44febff28c01f69ca936f8fd1"
        },
        "ormorgeditview9": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "ORM",
            "viewname": "ORMORGEditView9",
            "viewtag": "975252aa8b53de1912591cca23064124"
        },
        "ormqybzwhmpickupview": {
            "title": "区域标准维护数据多项选择视图",
            "caption": "区域标准维护",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYBZWHMPickupView",
            "viewtag": "98189812410dd413f13e93d35580c179"
        },
        "ormqyglgridview": {
            "title": "区域补贴",
            "caption": "区域补贴",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYGLGridView",
            "viewtag": "9821e481ee7328dfad5ff5fe9f669f46"
        },
        "ormorginfoeditview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoEditView",
            "viewtag": "9851f29e3a4f62727ef164d964f3c2fd"
        },
        "ormsignorggridview": {
            "title": "法人主体维护",
            "caption": "法人主体维护",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgGridView",
            "viewtag": "989a45ab2da4c6aa3c2a0867061a1a95"
        },
        "ormbmgwbzeditview": {
            "title": "岗位编制明细",
            "caption": "岗位编制明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMGWBZEditView",
            "viewtag": "990c768d41e9b43d062a996fa59aa282"
        },
        "ormxmglredirectview": {
            "title": "项目管理数据重定向视图",
            "caption": "项目管理",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMGLRedirectView",
            "viewtag": "99172040009032a7a1eb0afe352f14c8"
        },
        "ormorgsectorpxmbpickupgridview": {
            "title": "项目部选择",
            "caption": "项目部选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORPXMBPickupGridView",
            "viewtag": "9c5a3dc4a1b6d69b8121ce8ba3d91184"
        },
        "ormorgdzpickupview": {
            "title": "组织地址维护数据选择视图",
            "caption": "组织地址维护",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGDZPickupView",
            "viewtag": "9cdae39d672b9245b39ba493ce78c0f9"
        },
        "ormsignorgbdwpickupgridview": {
            "title": "注册单位选择",
            "caption": "注册单位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgBDWPickupGridView",
            "viewtag": "9d20066f4751b9bcf4c14bace026d2e6"
        },
        "ormbmgwbzmpickupview": {
            "title": "部门岗位编制数据多项选择视图",
            "caption": "部门岗位编制",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMGWBZMPickupView",
            "viewtag": "9e36a0160fadc5393ac7a39def748e83"
        },
        "ormorgsectorgridview": {
            "title": "部门/项目部管理",
            "caption": "部门/项目部管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORGridView",
            "viewtag": "9f4101d02ad189096c5513d1896de595"
        },
        "ormorgsjyxzzqxpickupgridview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSJYXZZQXPickupGridView",
            "viewtag": "9f6ce73e8538cadb8176c23ba63a1c04"
        },
        "ormpostxjgridview": {
            "title": "岗位设置",
            "caption": "岗位设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostXJGridView",
            "viewtag": "a103d0ea2d848ed7acc56f4c8679a619"
        },
        "ormpostdetailspickupview": {
            "title": "岗位明细数据选择视图",
            "caption": "岗位明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostDetailsPickupView",
            "viewtag": "a162a2ee899f9c82c1dcd68acc88c6eb"
        },
        "ormorgallleveltwoorgpickupgridview": {
            "title": "管理单位",
            "caption": "管理单位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGAllLevelTwoOrgPickupGridView",
            "viewtag": "a2b9436414dfacd75213950bcccde502"
        },
        "pimpersoncurleaderpickupview": {
            "title": "部门负责人选择",
            "caption": "部门负责人选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "PIMPERSONCurLeaderPickupView",
            "viewtag": "a507d6d767f5aeb2bec795506a8ec06f"
        },
        "ormqyglpickupgridview": {
            "title": "区域补贴",
            "caption": "区域补贴",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYGLPickupGridView",
            "viewtag": "a59ef6c5f63e0e0242a649ad41a631f5"
        },
        "ormerporglegalmpickupview": {
            "title": "管理单位",
            "caption": "管理单位",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGLegalMPickupView",
            "viewtag": "a9e8848adebb1372086602b973419f50"
        },
        "ormpostorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTORGIDPickupView",
            "viewtag": "aae9b5f11943dada61af074ccee0aae0"
        },
        "ormorgypzsyfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGYPZSYFPXXPickupView",
            "viewtag": "abdca6d5e8c5d2f8276356b7185304fd"
        },
        "ormbmgwbzgridview": {
            "title": "岗位编制明细",
            "caption": "岗位编制明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMGWBZGridView",
            "viewtag": "b0616a94480150c34a25745675999617"
        },
        "ormpostgridview": {
            "title": "岗位设置",
            "caption": "岗位设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTGridView",
            "viewtag": "b27907883a10b1fd27afb340307c2661"
        },
        "ormsignorgbdwpickupview": {
            "title": "注册单位选择",
            "caption": "注册单位选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgBDWPickupView",
            "viewtag": "b2bd189c3f5168abeb36f8f04cdd5835"
        },
        "contractsignorgeditview2": {
            "title": "签约主体单位编辑视图",
            "caption": "签约主体单位",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ContractSignORGEditView2",
            "viewtag": "b2ca10907779d36b48f11a13e0b35477"
        },
        "ormorgsectorxmbbzglcxeditview": {
            "title": "项目部管理",
            "caption": "项目部管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORXMBBZGLCXEditView",
            "viewtag": "b302d75ac8f50d53a89dd345ca014eb2"
        },
        "ormpostfpxxpickupview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTFPXXPickupView",
            "viewtag": "b32fd47a6cf8a8672cdc16139fbd6434"
        },
        "ormorgsectorydbmpickupview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORYDBMPickupView",
            "viewtag": "b463a613b3752f0b333551a58d8a445b"
        },
        "ormqybzwhpickupgridview": {
            "title": "区域标准维护选择表格视图",
            "caption": "区域标准维护",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYBZWHPickupGridView",
            "viewtag": "b4fdfec6e978fb274c733b9f834ae9f6"
        },
        "ormerporgmpickupview": {
            "title": "ERP组织中间表数据多项选择视图",
            "caption": "ERP组织中间表",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGMPickupView",
            "viewtag": "b6850f575ddcc241fc3f0b78f3de2786"
        },
        "ormorginfosuborggridview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoSubOrgGridView",
            "viewtag": "b757a8526b784c95dd2a81fd2b90d78b"
        },
        "ormorginfompickupview": {
            "title": "组织信息数据多项选择视图",
            "caption": "组织信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoMPickupView",
            "viewtag": "b799e033de678fc681e6df72f2e5355e"
        },
        "ormtitlepickupgridview": {
            "title": "标准头衔库",
            "caption": "标准头衔库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMTITLEPickupGridView",
            "viewtag": "b80e9d591a8dcff1b37b765569543ebf"
        },
        "ormorginfoorgtreeexpview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGInfoOrgTreeExpView",
            "viewtag": "b8413e7b06a47ff51bd81c164e87c9ea"
        },
        "ormerporglegalpickupgridview": {
            "title": "管理单位",
            "caption": "管理单位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGLegalPickupGridView",
            "viewtag": "b9bdc1f0d93821bd1469c503a4468782"
        },
        "index": {
            "title": "EHR—组织管理",
            "caption": "EHR—组织管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "ORM",
            "viewname": "Index",
            "viewtag": "ba03560f855106a098d38a28cd8b8291"
        },
        "ormqygleditview": {
            "title": "区域补贴",
            "caption": "区域补贴",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYGLEditView",
            "viewtag": "bb8f8363ee628eff78879d048e31d92c"
        },
        "ormqybzwheditview": {
            "title": "区域标准维护编辑视图",
            "caption": "区域标准维护",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYBZWHEditView",
            "viewtag": "bbe5d21a65d912e9b17acac2ecd276fb"
        },
        "ormorgsectoreditview": {
            "title": "部门",
            "caption": "部门管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTOREditView",
            "viewtag": "bd56cd87a670c82e4ab85c12b09dc433"
        },
        "ormorgsectorkqszmpickupview": {
            "title": "部门管理数据多项选择视图",
            "caption": "部门管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORKQSZMPickupView",
            "viewtag": "bf69e3eb9ffeeb74e01270c1bb69f2b9"
        },
        "ormorgsectorsetproleadereditview": {
            "title": "设置项目负责人",
            "caption": "设置项目负责人",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORSetProLeaderEditView",
            "viewtag": "c11c0dab0f7327abb95f0b98b152fee9"
        },
        "ormorgallsignorgpickupgridview": {
            "title": "签约单位",
            "caption": "签约单位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGAllSignOrgPickupGridView",
            "viewtag": "c20d3f7fef5427709f09a1a47bf9e44b"
        },
        "ormorgsectorbzcxgridview": {
            "title": "编制查询",
            "caption": "编制查询",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORBZCXGridView",
            "viewtag": "c21086cfe485c3db5046ec2181eab9f4"
        },
        "ormpostfpxxpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTFPXXPickupGridView",
            "viewtag": "c2ad468d7165a39afbb64b0a42cc6ff8"
        },
        "ormerporggridview": {
            "title": "ERP组织库",
            "caption": "ERP组织库",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGGridView",
            "viewtag": "c347ca60725c3d70a12541ce5c861c16"
        },
        "ormrelationeditview": {
            "title": "组织管理关系表编辑视图",
            "caption": "组织管理关系表",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMRelationEditView",
            "viewtag": "c402adcb2fbab932e05fbda1cbe9e5fd"
        },
        "ormrelationpickupview": {
            "title": "组织管理关系表数据选择视图",
            "caption": "组织管理关系表",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMRelationPickupView",
            "viewtag": "c5008387a2d8931e35771e89859917d7"
        },
        "ormpostejormorgidpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEJORMORGIDPickupGridView",
            "viewtag": "c5971ea6a46c289edbec6dc768c7757b"
        },
        "ormxmbqpickupview": {
            "title": "项目标签数据选择视图",
            "caption": "项目标签",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBQPickupView",
            "viewtag": "c62fb1e72e56cf4a2703a042d8fb1628"
        },
        "ormorgypzxxsypickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGYPZXXSYPickupGridView",
            "viewtag": "c74a3b5653973247d1ca895e48d5ba79"
        },
        "ormxmglpickupgridview": {
            "title": "ERP项目库",
            "caption": "ERP项目库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMGLPickupGridView",
            "viewtag": "ca9382b8c4fa5aa1a99d75a7919fad44"
        },
        "ormbmkqdzbmkqdzeditview": {
            "title": "部门考勤地址",
            "caption": "部门考勤地址",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZBMKQDZEditView",
            "viewtag": "cd73ee9cff31934cf822c903fc857a6a"
        },
        "ormeditioneditview": {
            "title": "版本对照表编辑视图",
            "caption": "版本对照表",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMEDITIONEditView",
            "viewtag": "d008fe2ad1da3e0f5c0b47a989edd018"
        },
        "ormbmkqdzgridview": {
            "title": "考勤地址信息",
            "caption": "考勤地址信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZGridView",
            "viewtag": "d0684dfaccecd7ab7517faea672f1d90"
        },
        "ormtitlegridview": {
            "title": "标准头衔设置",
            "caption": "标准头衔设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMTITLEGridView",
            "viewtag": "d0a1b65bd4e9dc338958169730e9086e"
        },
        "ormeditionpickupgridview": {
            "title": "版本对照表选择表格视图",
            "caption": "版本对照表",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMEDITIONPickupGridView",
            "viewtag": "d3d98ee89379969df1fd76a2982d659d"
        },
        "ormorgorgtreegridview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGOrgTreeGridView",
            "viewtag": "d4cde7471b5b2946fa12d64bb56ee2be"
        },
        "ormxmbqpickupgridview": {
            "title": "项目标签选择表格视图",
            "caption": "项目标签",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBQPickupGridView",
            "viewtag": "d5876cbee6d77c1948ec96b8eb59af1f"
        },
        "ormqybzwhpickupview": {
            "title": "区域标准维护数据选择视图",
            "caption": "区域标准维护",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYBZWHPickupView",
            "viewtag": "d6993cf9c27d98711585b10e9c54a80f"
        },
        "ormpostredirectview": {
            "title": "岗位管理数据重定向视图",
            "caption": "岗位",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTRedirectView",
            "viewtag": "d6afd19cebd843f44d87629160c89ef2"
        },
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGPickupGridView",
            "viewtag": "d709fd6fb0468ebe607ca8407e5a7f55"
        },
        "ormbmkqdzredirectview": {
            "title": "部门地址维护数据重定向视图",
            "caption": "部门地址维护",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZRedirectView",
            "viewtag": "d767fa880cb475dc1d1b6c4b686d51fd"
        },
        "ormdutyestmanmpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYEstManMPickupView",
            "viewtag": "dbff0b2a511066b1783f443c9219de71"
        },
        "ormsignorgredirectview": {
            "title": "法人主体数据重定向视图",
            "caption": "法人主体",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgRedirectView",
            "viewtag": "deea2383f175de0941090857fad7e76b"
        },
        "ormpostlibeditview": {
            "title": "标准岗位设置",
            "caption": "标准岗位设置",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostLibEditView",
            "viewtag": "def85fb885bc5ea11c35f98f9a134761"
        },
        "ormdutyeditview2": {
            "title": "职务管理编辑视图",
            "caption": "职务管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYEditView2",
            "viewtag": "df7ddcb0870be45192d52819b460fb00"
        },
        "ormpostnrgwpickupview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTNRGWPickupView",
            "viewtag": "e0338d790423159bf85c6ba2b32bd3a0"
        },
        "ormbmkqdzeditview2": {
            "title": "部门地址维护编辑视图",
            "caption": "部门地址维护",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMBMKQDZEditView2",
            "viewtag": "e09e677fe2bfd3c3e63dd8a4530e71d7"
        },
        "ormsignorgmpickupview": {
            "title": "法人主体数据多项选择视图",
            "caption": "法人主体",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgMPickupView",
            "viewtag": "e0e5c2df72b509edbdd1e82189d9cafc"
        },
        "ormorgxjpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgXjPickupGridView",
            "viewtag": "e197970aa722788e772f38c9b9d403ac"
        },
        "ormdutyormorgsectorpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrmOrgSectorPickupView",
            "viewtag": "e4bf81653bfd2180a30e70a398acde14"
        },
        "ormsignorgpickupview": {
            "title": "法人主体数据选择视图",
            "caption": "法人主体",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmSignOrgPickupView",
            "viewtag": "e78a1a8961c183dcb063285385b9671a"
        },
        "ormdutyormorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYOrmOrgSectorPickupGridView",
            "viewtag": "e7a88a113548fc44b3853962f35b8dd0"
        },
        "ormpostlibpickupview": {
            "title": "标准岗位",
            "caption": "标准岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostLibPickupView",
            "viewtag": "e8a6f491e8ac8cf3287abbda5492c7ce"
        },
        "ormdutyeditview": {
            "title": "职务设置",
            "caption": "职务设置",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDUTYEditView",
            "viewtag": "e97d29e46761b8948b09515a6e37dbce"
        },
        "ormorgsectorfpxxpickupview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTORFPXXPickupView",
            "viewtag": "e99dc30e9a1ada6370538fe937805cd7"
        },
        "ormtitlepickupview": {
            "title": "标准头衔库",
            "caption": "标准头衔库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMTITLEPickupView",
            "viewtag": "e9a26c099b4ffa061db99fb5d0b11c1d"
        },
        "ormorgfpxxpickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGFPXXPickupGridView",
            "viewtag": "eb1bbb32657d6ca1e5680747977b3169"
        },
        "ormeditionpickupview": {
            "title": "版本对照表数据选择视图",
            "caption": "版本对照表",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMEDITIONPickupView",
            "viewtag": "ec0c6faf5200b91a9ce4ca8233dd357a"
        },
        "ormrelationmpickupview": {
            "title": "组织管理关系表数据多项选择视图",
            "caption": "组织管理关系表",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMRelationMPickupView",
            "viewtag": "eccc6c41422560bf34fb97843fb3acbe"
        },
        "ormpostdetailsredirectview": {
            "title": "岗位明细数据重定向视图",
            "caption": "岗位明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostDetailsRedirectView",
            "viewtag": "ed696bae9bae3cf67b0ffcf5cfae3f3b"
        },
        "ormpostejormorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTEJORMORGIDPickupView",
            "viewtag": "ed9bd766f2fd6e1a990116bad7176d45"
        },
        "ormqybzwheditview2": {
            "title": "区域标准维护编辑视图",
            "caption": "区域标准维护",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMQYBZWHEditView2",
            "viewtag": "f1469146af2cf30758ec0240d4feb797"
        },
        "ormpostorgidpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTORGIDPickupGridView",
            "viewtag": "f17a9fd0f8de26d0caf7f02645cc5e58"
        },
        "ormerporgsuborgsectorgridview": {
            "title": "ERP组织库",
            "caption": "ERP组织库",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMERPORGSubOrgsectorGridView",
            "viewtag": "f2be8cd14141ad9a44648ced3532599c"
        },
        "ormpostjzbgwpickupgridview": {
            "title": "局总部岗位",
            "caption": "局总部岗位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTJZBGWPickupGridView",
            "viewtag": "f3acdcecf3f5acc401d86f423b9312d7"
        },
        "ormtitleeditview2": {
            "title": "头衔管理编辑视图",
            "caption": "头衔管理",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "ORM",
            "viewname": "ORMTITLEEditView2",
            "viewtag": "f41598b0fbd59e6fb14c6f9792474599"
        },
        "ormorgsuborggridview": {
            "title": "组织管理",
            "caption": "组织管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGSubOrgGridView",
            "viewtag": "f48f4ab3198fccc18f177d106869633d"
        },
        "ormdepestmaneditview": {
            "title": "部门编制管理编辑视图",
            "caption": "部门职务编制",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMDepEstManEditView",
            "viewtag": "f589e5b5d0c563d96f2c0582e7700d4a"
        },
        "ormqybzwhgridview": {
            "title": "区域标准维护表格视图",
            "caption": "区域标准维护",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYBZWHGridView",
            "viewtag": "f7164547c0415cb8231582c673ed0831"
        },
        "ormqybzwhredirectview": {
            "title": "区域标准维护数据重定向视图",
            "caption": "区域标准维护",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYBZWHRedirectView",
            "viewtag": "f72fc27e063edf4cb5d69cbf3af78c70"
        },
        "ormorghtgldwqpickupgridview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGHTGLDWQPickupGridView",
            "viewtag": "f797c6c9c7b6410519ceb908dfd0a27f"
        },
        "ormorgsectoreditview9_editmode": {
            "title": "部门/项目部管理",
            "caption": "部门/项目部管理",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "ORM",
            "viewname": "ORMORGSECTOREditView9_EditMode",
            "viewtag": "f8da0542fa59713cb39573af12afc068"
        },
        "ormxmbmxpickupgridview": {
            "title": "项目部明细选择表格视图",
            "caption": "项目部明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMBMXPickupGridView",
            "viewtag": "faeb43cb99913307049edef46cc256bf"
        },
        "ormdutypickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmDutyPickupGridView",
            "viewtag": "fb53017980e4b51d1ef3d6d9c9eeb4ac"
        },
        "ormxmglgridview": {
            "title": "ERP项目信息",
            "caption": "ERP项目",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMXMGLGridView",
            "viewtag": "fb74be88e4689d3acd8a423c89d4b9ba"
        },
        "ormqyglredirectview": {
            "title": "区域管理数据重定向视图",
            "caption": "补贴标准",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMQYGLRedirectView",
            "viewtag": "febdc6dc53b2c8189fb687e14db69506"
        },
        "ormpostgwbzxzpickupgridview": {
            "title": "岗位库",
            "caption": "岗位库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPOSTGWBZXZPickupGridView",
            "viewtag": "ff2e4cd3d9cd47db42449f6900df5b14"
        },
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMORGPickupView",
            "viewtag": "ff44f41e4bc8d67b1054d1d7dd444886"
        },
        "ormpostlibpickupgridview": {
            "title": "标准岗位",
            "caption": "标准岗位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "ORMPostLibPickupGridView",
            "viewtag": "ff9c16f0bcce15390c48b09827d63916"
        }
    }];
});