import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "EhrCodeList0083",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "局机关",
                text: "局机关",
                "data":"",
                "codename":"Item_1",
                value: "1",
                
                disabled: false,
            },
            {
                id: "2",
                label: "二级单位",
                text: "二级单位",
                "data":"",
                "codename":"Item_2",
                value: "2",
                
                disabled: false,
            },
            {
                id: "3",
                label: "地区机关",
                text: "地区机关",
                "data":"",
                "codename":"Item_3",
                value: "3",
                
                disabled: false,
            },
            {
                id: "4",
                label: "项目人员",
                text: "项目人员",
                "data":"",
                "codename":"Item_4",
                value: "4",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0211",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmOrg",
        "appdedataset":"FetchAllLevelTwoOrg",
        "items": []
    },
    {
        srfkey: "EhrCodeList0236",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "1DR",
                label: "博士",
                text: "博士",
                "data":"",
                "codename":"Item_1",
                value: "1DR",
                
                disabled: false,
            },
            {
                id: "2MD",
                label: "硕士",
                text: "硕士",
                "data":"",
                "codename":"Item_2",
                value: "2MD",
                
                disabled: false,
            },
            {
                id: "3UNDERGRAD",
                label: "本科",
                text: "本科",
                "data":"",
                "codename":"Item_3",
                value: "3UNDERGRAD",
                
                disabled: false,
            },
            {
                id: "4JUNIOR",
                label: "大专",
                text: "大专",
                "data":"",
                "codename":"Item_4",
                value: "4JUNIOR",
                
                disabled: false,
            },
            {
                id: "5TECHSECSCH",
                label: "中专及以下",
                text: "中专及以下",
                "data":"",
                "codename":"Item_5",
                value: "5TECHSECSCH",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0056",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "55",
                label: "55岁以上",
                text: "55岁以上",
                "data":"",
                "codename":"Item_55",
                value: "55",
                
                disabled: false,
            },
            {
                id: "51",
                label: "51~55岁",
                text: "51~55岁",
                "data":"",
                "codename":"Item_51",
                value: "51",
                
                disabled: false,
            },
            {
                id: "46",
                label: "46~50岁",
                text: "46~50岁",
                "data":"",
                "codename":"Item_46",
                value: "46",
                
                disabled: false,
            },
            {
                id: "41",
                label: "41~45岁",
                text: "41~45岁",
                "data":"",
                "codename":"Item_41",
                value: "41",
                
                disabled: false,
            },
            {
                id: "36",
                label: "36~40岁",
                text: "36~40岁",
                "data":"",
                "codename":"Item_36",
                value: "36",
                
                disabled: false,
            },
            {
                id: "31",
                label: "31~35岁",
                text: "31~35岁",
                "data":"",
                "codename":"Item_31",
                value: "31",
                
                disabled: false,
            },
            {
                id: "30",
                label: "30岁以下",
                text: "30岁以下",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0024",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    }
    ]];
});

