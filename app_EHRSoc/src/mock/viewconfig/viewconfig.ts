import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "soctypepickupview": {
            "title": "保险类型数据选择视图",
            "caption": "保险类型",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SOC",
            "viewname": "SocTypePickupView",
            "viewtag": "024088082a2d1099b2a61ee67c986e43"
        },
        "socareagridview": {
            "title": "参保地表格视图",
            "caption": "参保地",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAreaGridView",
            "viewtag": "1a1326e28ef5ec3d85b45c0d9ecf9684"
        },
        "socarchivesquickeditview": {
            "title": "社保档案编辑视图",
            "caption": "社保档案",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesQuickEditView",
            "viewtag": "21bd406d12cd31c62de8b9e78649d229"
        },
        "soctypepickupgridview": {
            "title": "保险类型选择表格视图",
            "caption": "保险类型",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocTypePickupGridView",
            "viewtag": "25e10faa49dbfa2c6a9054b63ac0bc7a"
        },
        "socruledetailpickupview": {
            "title": "社保规则明细数据选择视图",
            "caption": "社保规则明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleDetailPickupView",
            "viewtag": "3f57e5629bd977d652098834972af3a7"
        },
        "socaccountpickupgridview": {
            "title": "参保账户选择表格视图",
            "caption": "参保账户",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAccountPickupGridView",
            "viewtag": "4b9ddc3407aa91875c0e66348644dc43"
        },
        "socareaeditview": {
            "title": "参保地编辑视图",
            "caption": "参保地",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAreaEditView",
            "viewtag": "4d2e62d3fd19327574be8b2c65337faf"
        },
        "socruledetailpickupgridview": {
            "title": "社保规则明细选择表格视图",
            "caption": "社保规则明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleDetailPickupGridView",
            "viewtag": "508a97fa385e02a6c6eaa7cf720e0cec"
        },
        "socruledetaileditview": {
            "title": "社保规则明细编辑视图",
            "caption": "社保规则明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleDetailEditView",
            "viewtag": "59c055b21b497f790371732712f62a30"
        },
        "socarchivesgridview": {
            "title": "社保档案表格视图",
            "caption": "社保档案",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesGridView",
            "viewtag": "67ed4891f00a2d935667f0ec691f7182"
        },
        "socarchivesorggridview": {
            "title": "社保档案表格视图",
            "caption": "社保档案",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesOrgGridView",
            "viewtag": "6b3f2b0a86d1987ee38869613036c1b2"
        },
        "socareapickupgridview": {
            "title": "参保地选择表格视图",
            "caption": "参保地",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAreaPickupGridView",
            "viewtag": "6d44b6e79bb6d6706990592cb59c9f32"
        },
        "socrulegridview": {
            "title": "社保规则表格视图",
            "caption": "社保规则",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleGridView",
            "viewtag": "6f4fb39cb25a702c89dc415245198608"
        },
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupGridView",
            "viewtag": "7ac55b5b5ac68117e990e9ced14e71b9"
        },
        "pimpersonsetsocarchivesgridview": {
            "title": "员工社保设置",
            "caption": "员工社保设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonSetSocArchivesGridView",
            "viewtag": "7c209be889bba2c9a6de317b1bcec291"
        },
        "socarearoweditgridview": {
            "title": "参保地表格视图",
            "caption": "参保地",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAreaRowEditGridView",
            "viewtag": "8560a1fd46139dfc5f1fc71b0a3f59b0"
        },
        "socarchiveseditview": {
            "title": "社保档案编辑视图",
            "caption": "社保档案",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesEditView",
            "viewtag": "8d8165bf052eb9455044ec39843ef257"
        },
        "socarchivesdetaileditview": {
            "title": "社保档案明细编辑视图",
            "caption": "社保档案明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesDetailEditView",
            "viewtag": "8dbbef8d0ad1436fef1c3ba1ed40b05c"
        },
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupView",
            "viewtag": "912c10028c229aaf79d7542c94931417"
        },
        "socruleeditview": {
            "title": "社保规则编辑视图",
            "caption": "社保规则",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleEditView",
            "viewtag": "954c57b4c84541e4769606551de25a05"
        },
        "soctypeeditview": {
            "title": "保险类型编辑视图",
            "caption": "保险类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocTypeEditView",
            "viewtag": "9787d3620f997b0d8f6bc4bcf0826837"
        },
        "soctypegridview": {
            "title": "保险类型表格视图",
            "caption": "保险类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocTypeGridView",
            "viewtag": "a91ca0b2a35fc0bc1c22a613b0af0f04"
        },
        "socarchivesdetailgridview": {
            "title": "社保档案明细表格视图",
            "caption": "社保档案明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesDetailGridView",
            "viewtag": "aa42ee6a3edbf6fc9c11a80fcac3d365"
        },
        "socruledetailgridview": {
            "title": "社保规则明细表格视图",
            "caption": "社保规则明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleDetailGridView",
            "viewtag": "b90f6f466753e0b928ea594d2a38ab73"
        },
        "socarchivesmain2editview": {
            "title": "社保档案编辑视图",
            "caption": "社保档案",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesMain2EditView",
            "viewtag": "bc7184f7d9cd35c81ab755bd2ff2e729"
        },
        "socrulemain2editview": {
            "title": "社保规则编辑视图",
            "caption": "社保规则",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleMain2EditView",
            "viewtag": "bcb4830aa7bbc34a074b36fc48f8f0b6"
        },
        "socaccountgridview": {
            "title": "参保账户表格视图",
            "caption": "参保账户",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAccountGridView",
            "viewtag": "be3603e6155f93c90fc36953c6a4689f"
        },
        "socarchivesstopgridview": {
            "title": "非员工终止社保",
            "caption": "非员工终止社保",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesStopGridView",
            "viewtag": "bf4ef187880e7431032ba8b27f4a2143"
        },
        "socaccountpickupview": {
            "title": "参保账户数据选择视图",
            "caption": "参保账户",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAccountPickupView",
            "viewtag": "c1fe999705dd1adaf588b0dd05baba85"
        },
        "pimpersonpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonPickupGridView",
            "viewtag": "c96fcbc2a8248c568bd0c5c7f6c3de92"
        },
        "socaccounteditview": {
            "title": "参保账户编辑视图",
            "caption": "参保账户",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAccountEditView",
            "viewtag": "dcb1f8a13036f3f4af6199bc475c8680"
        },
        "socarchivestreeexpview": {
            "title": "社保档案树导航视图",
            "caption": "社保档案",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesTreeExpView",
            "viewtag": "e39303bf75ac4d04f6f847df12c9005a"
        },
        "socrulepickupview": {
            "title": "社保规则数据选择视图",
            "caption": "社保规则",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRulePickupView",
            "viewtag": "eb464b83d579a19440a0f65278573bb5"
        },
        "pimpersonpickupview": {
            "title": "人员信息数据选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonPickupView",
            "viewtag": "f131b13e32b5195223f2af77eefa60a9"
        },
        "socrulequickeditview": {
            "title": "社保规则编辑视图",
            "caption": "社保规则",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleQuickEditView",
            "viewtag": "f171820c870830bd35bd19ffce2873ac"
        },
        "socareapickupview": {
            "title": "参保地数据选择视图",
            "caption": "参保地",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAreaPickupView",
            "viewtag": "f2ac208aee9be3a1cbe51f16b6af100e"
        },
        "socrulepickupgridview": {
            "title": "社保规则选择表格视图",
            "caption": "社保规则",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRulePickupGridView",
            "viewtag": "f6dda7f813c86922238b8bad4e67b919"
        },
        "index": {
            "title": "EHR—社保管理",
            "caption": "EHR—社保管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "SOC",
            "viewname": "Index",
            "viewtag": "FFA7990F-3519-4632-9728-B22B32C8D3D5"
        }
    }];
});