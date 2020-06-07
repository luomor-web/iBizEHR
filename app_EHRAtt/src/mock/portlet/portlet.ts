import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取全部数组
mock.onGet('./assets/json/portlet-data.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,
    [
        ]];
});