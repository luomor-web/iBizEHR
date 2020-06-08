import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "index": {
            "title": "iBizEHR",
            "caption": "iBizEHR",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "Ungroup",
            "viewname": "Index",
            "viewtag": "65C2C358-B688-40A1-B818-47C79CEB16B5"
        },
        "ehrportalview": {
            "title": "Ehr门户首页",
            "caption": "首页",
            "viewtype": "APPPORTALVIEW",
            "viewmodule": "Portal",
            "viewname": "EhrPortalView",
            "viewtag": "7C5E0D47-0C7A-43F4-B137-CB4EC96FE1D6"
        }
    }];
});