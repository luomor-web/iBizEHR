import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "index": {
            "title": "应用首页视图",
            "caption": "EHR",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "Ungroup",
            "viewname": "Index",
            "viewtag": "65C2C358-B688-40A1-B818-47C79CEB16B5"
        }
    }];
});