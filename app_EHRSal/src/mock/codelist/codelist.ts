import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: 'EhrCodeList0128',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '增加',
                text: '增加',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '扣减',
                text: '扣减',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0036",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"SalType",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0249",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'EhrCodeList0022',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '法人单位',
                text: '法人单位',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '非法人单位',
                text: '非法人单位',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'EhrCodeList0068',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '>',
                label: '>',
                text: '>',
                "data":"",
                "codename":"GT",
                value: '>',
                
                disabled: false,
            },
            {
                id: '>=',
                label: '>=',
                text: '>=',
                "data":"",
                "codename":"GTEQ",
                value: '>=',
                
                disabled: false,
            },
            {
                id: '=',
                label: '=',
                text: '=',
                "data":"",
                "codename":"EQ",
                value: '=',
                
                disabled: false,
            },
            {
                id: '<=',
                label: '<=',
                text: '<=',
                "data":"",
                "codename":"LTEQ",
                value: '<=',
                
                disabled: false,
            },
            {
                id: '<',
                label: '<',
                text: '<',
                "data":"",
                "codename":"LT",
                value: '<',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'EhrCodeList0086',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '1',
                label: '启用',
                text: '启用',
                "data":"",
                "codename":"Item_1",
                "color": "Blue",
                value: '1',
                
                disabled: false,
            },
            {
                id: '0',
                label: '停用',
                text: '停用',
                "data":"",
                "codename":"Item_0",
                "color": "Red",
                value: '0',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0250",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'EhrCodeList0212',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '手工录入',
                text: '手工录入',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '引用规则',
                text: '引用规则',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '引用公式',
                text: '引用公式',
                "data":"",
                "codename":"Item_30",
                value: '30',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0219",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'EhrCodeList0400',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '1',
                label: '是',
                text: '是',
                "data":"",
                "codename":"Item_1",
                value: 1,
                
                disabled: false,
            },
            {
                id: '0',
                label: '否',
                text: '否',
                "data":"",
                "codename":"Item_0",
                value: 0,
                
                disabled: false,
            },
        ]
    }
    ]];
});

