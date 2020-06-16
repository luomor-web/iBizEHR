import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "socareagridview": {
            "title": "参保地表格视图",
            "caption": "参保地",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAreaGridView",
            "viewtag": "1a1326e28ef5ec3d85b45c0d9ecf9684"
        },
        "socareaeditview": {
            "title": "参保地编辑视图",
            "caption": "参保地",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAreaEditView",
            "viewtag": "4d2e62d3fd19327574be8b2c65337faf"
        },
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupGridView",
            "viewtag": "7ac55b5b5ac68117e990e9ced14e71b9"
        },
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupView",
            "viewtag": "912c10028c229aaf79d7542c94931417"
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
        "socaccountgridview": {
            "title": "参保账户表格视图",
            "caption": "参保账户",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAccountGridView",
            "viewtag": "be3603e6155f93c90fc36953c6a4689f"
        },
        "socaccounteditview": {
            "title": "参保账户编辑视图",
            "caption": "参保账户",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SOC",
            "viewname": "SocAccountEditView",
            "viewtag": "dcb1f8a13036f3f4af6199bc475c8680"
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