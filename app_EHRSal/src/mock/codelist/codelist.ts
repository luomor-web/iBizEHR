import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
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
        "srfkey": "EhrCodeList0250",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
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
        "srfkey": "EhrCodeList0033",
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
        srfkey: 'EhrCodeList0120',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '局级机关',
                text: '局级机关',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '公司级机关',
                text: '公司级机关',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '经理部机关',
                text: '经理部机关',
                "data":"",
                "codename":"Item_30",
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '项目部',
                text: '项目部',
                "data":"",
                "codename":"Item_40",
                value: '40',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'EhrCodeList0201',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '0',
                label: '特级',
                text: '特级',
                "data":"",
                "codename":"Item_0",
                value: '0',
                
                disabled: false,
            },
            {
                id: '1',
                label: '一级',
                text: '一级',
                "data":"",
                "codename":"Item_1",
                value: '1',
                
                disabled: false,
            },
            {
                id: '2',
                label: '二级',
                text: '二级',
                "data":"",
                "codename":"Item_2",
                value: '2',
                
                disabled: false,
            },
            {
                id: '3',
                label: '三级',
                text: '三级',
                "data":"",
                "codename":"Item_3",
                value: '3',
                
                disabled: false,
            },
            {
                id: '4',
                label: '四级',
                text: '四级',
                "data":"",
                "codename":"Item_4",
                value: '4',
                
                disabled: false,
            },
            {
                id: '5',
                label: '五级',
                text: '五级',
                "data":"",
                "codename":"Item_5",
                value: '5',
                
                disabled: false,
            },
        ]
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

