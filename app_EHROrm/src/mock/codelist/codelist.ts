import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: 'ATTCL_Range',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '100',
                label: '100米',
                text: '100米',
                "data":"",
                "codename":"Item_100",
                value: '100',
                
                disabled: false,
            },
            {
                id: '200',
                label: '200米',
                text: '200米',
                "data":"",
                "codename":"Item_200",
                value: '200',
                
                disabled: false,
            },
            {
                id: '300',
                label: '300米',
                text: '300米',
                "data":"",
                "codename":"Item_300",
                value: '300',
                
                disabled: false,
            },
            {
                id: '400',
                label: '400米',
                text: '400米',
                "data":"",
                "codename":"Item_400",
                value: '400',
                
                disabled: false,
            },
            {
                id: '500',
                label: '500米',
                text: '500米',
                "data":"",
                "codename":"Item_500",
                value: '500',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'ORMCL_PostNature',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '标准工时制',
                text: '标准工时制',
                "data":"",
                "codename":"Item_10",
                "color": "Green",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '非标准工时制',
                text: '非标准工时制',
                "data":"",
                "codename":"Item_20",
                "color": "BlueViolet",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'ORMCL_XMBLX',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '项目部',
                text: '项目部',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '子项目部',
                text: '子项目部',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "ORMCL_ProCapitalAtt",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'ORMCL_XMGM',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '特级项目',
                text: '特级项目',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '一级项目',
                text: '一级项目',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '二级项目',
                text: '二级项目',
                "data":"",
                "codename":"Item_30",
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '三级项目',
                text: '三级项目',
                "data":"",
                "codename":"Item_40",
                value: '40',
                
                disabled: false,
            },
            {
                id: '50',
                label: '四级项目',
                text: '四级项目',
                "data":"",
                "codename":"Item_50",
                value: '50',
                
                disabled: false,
            },
            {
                id: '60',
                label: '五级项目',
                text: '五级项目',
                "data":"",
                "codename":"Item_60",
                value: '60',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "ORMCL_IsDirectlyManage",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'ORMCL_QTBS',
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
        "srfkey": "ORMCL_EngineeringScale",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "ORMCL_QY",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"ORMQYGL",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        srfkey: 'ORMCL_ZWLB',
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
        srfkey: 'ORMCL_POST_TYPE',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '0',
                label: '党内',
                text: '党内',
                "data":"",
                "codename":"Item_0",
                value: '0',
                
                disabled: false,
            },
            {
                id: '1',
                label: '行政',
                text: '行政',
                "data":"",
                "codename":"Item_1",
                value: '1',
                
                disabled: false,
            },
            {
                id: '2',
                label: '党内或行政',
                text: '党内或行政',
                "data":"",
                "codename":"Item_2",
                value: '2',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "ORMCL_ZW",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"ORMDUTY",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "SysOperator",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        "srfkey": "ORMCL_GW",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"ORMPOST",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "ORMCL_EngineeringPurpose",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "ORMCL_EngineeringBusType",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'YesNo',
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
    },
    {
        "srfkey": "EhrCodeListSsqy",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PIMCL_BMLX',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '机关部门',
                text: '机关部门',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '项目部门',
                text: '项目部门',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'ORMCL_GWFL',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '0',
                label: '党内',
                text: '党内',
                "data":"",
                "codename":"Item_0",
                "color": "Red",
                value: '0',
                
                disabled: false,
            },
            {
                id: '1',
                label: '行政',
                text: '行政',
                "data":"",
                "codename":"Item_1",
                "color": "Blue",
                value: '1',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_SFLJ',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '1',
                label: '是',
                text: '是',
                "data":"",
                "codename":"Item_1",
                "color": "Blue",
                value: '1',
                
                disabled: false,
            },
            {
                id: '0',
                label: '否',
                text: '否',
                "data":"",
                "codename":"Item_0",
                "color": "Red",
                value: '0',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'ORMCL_LegalEntity',
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
        "srfkey": "ORMCL_GWTYPE",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'ORMCL_XMLX',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '工程总承包',
                text: '工程总承包',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '施工总承包',
                text: '施工总承包',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '专业承包',
                text: '专业承包',
                "data":"",
                "codename":"Item_30",
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '其他',
                text: '其他',
                "data":"",
                "codename":"Item_40",
                value: '40',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_XMRYLX',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '项目经理',
                text: '项目经理',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '安全总监',
                text: '安全总监',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_ZGZT',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '在岗',
                text: '在岗',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '离岗',
                text: '离岗',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_YGZT",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'ORMCL_JZ',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '刚性',
                text: '刚性',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '柔性',
                text: '柔性',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    }
    ]];
});

