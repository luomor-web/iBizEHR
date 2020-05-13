import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

//  登录
mock.onPost('v7/login').reply((config: any) => {
    const { data: _data } = config;
    const user: any = {};
    let status = 200;
    try {
        Object.assign(user, JSON.parse(_data));
    } catch (error) {
        status = 400;
    }
    if (!Object.is(user.loginname, 'ibzadmin') || !Object.is(user.password, '123456')) {
        status = 400;
    }
    if (status !== 200) {
        return [status, null];
    }
    return [status, {
        token: Random.string(128),
        user: Object.assign({}, user),
    }];
});

