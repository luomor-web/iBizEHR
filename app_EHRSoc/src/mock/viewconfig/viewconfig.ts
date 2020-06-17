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
        "soctypepickupgridview": {
            "title": "保险类型选择表格视图",
            "caption": "保险类型",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocTypePickupGridView",
            "viewtag": "25e10faa49dbfa2c6a9054b63ac0bc7a"
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
        "socarchiveseditview": {
            "title": "社保档案编辑视图",
            "caption": "社保档案",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocArchivesEditView",
            "viewtag": "8d8165bf052eb9455044ec39843ef257"
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
        "socruledetailgridview": {
            "title": "社保规则明细表格视图",
            "caption": "社保规则明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocRuleDetailGridView",
            "viewtag": "b90f6f466753e0b928ea594d2a38ab73"
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