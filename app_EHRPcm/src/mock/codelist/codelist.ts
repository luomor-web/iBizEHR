import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        "srfkey": "PIMCL_ZJLX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIM_XL2",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
                "color": "Green",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '非标准工时制',
                text: '非标准工时制',
                "color": "BlueViolet",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PCM_CONDITION',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '1',
                label: '全符合',
                text: '全符合',
                "color": "Blue",
                value: '1',
                
                disabled: false,
            },
            {
                id: '2',
                label: '学科不符合',
                text: '学科不符合',
                "color": "Red",
                value: '2',
                
                disabled: false,
            },
            {
                id: '3',
                label: '学校不符合',
                text: '学校不符合',
                "color": "Red",
                value: '3',
                
                disabled: false,
            },
            {
                id: '4',
                label: '全不符合',
                text: '全不符合',
                "color": "Red",
                value: '4',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_XX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PCMCL_YYDJ',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: 'CET-4',
                text: 'CET-4',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: 'CET-6',
                text: 'CET-6',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '英语专四',
                text: '英语专四',
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '英语专八',
                text: '英语专八',
                value: '40',
                
                disabled: false,
            },
            {
                id: '50',
                label: '其他语言',
                text: '其他语言',
                value: '50',
                
                disabled: false,
            },
            {
                id: '60',
                label: '无',
                text: '无',
                value: '60',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PCMCL_XKML",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"PCMXKML",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        srfkey: 'PCMCL_PROFILEType',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '录入',
                text: '录入',
                "color": "Green",
                value: '10',
                
                disabled: false,
            },
            {
                id: '15',
                label: '待公司初审',
                text: '待公司初审',
                "color": "Blue",
                value: '15',
                
                disabled: false,
            },
            {
                id: '20',
                label: '公司初审不通过',
                text: '公司初审不通过',
                "color": "Red",
                value: '20',
                
                disabled: false,
            },
            {
                id: '21',
                label: '待公司董事长审批',
                text: '待公司董事长审批',
                "color": "Blue",
                value: '21',
                
                disabled: false,
            },
            {
                id: '22',
                label: '公司董事长不通过',
                text: '公司董事长不通过',
                "color": "Red",
                value: '22',
                
                disabled: false,
            },
            {
                id: '25',
                label: '待上报',
                text: '待上报',
                "color": "Green",
                value: '25',
                
                disabled: false,
            },
            {
                id: '30',
                label: '待局总部初审',
                text: '待局总部初审',
                "color": "Blue",
                value: '30',
                
                disabled: false,
            },
            {
                id: '50',
                label: '局总部初审不通过',
                text: '局总部初审不通过',
                "color": "Red",
                value: '50',
                
                disabled: false,
            },
            {
                id: '55',
                label: '待局总部审核',
                text: '待局总部审核',
                "color": "Blue",
                value: '55',
                
                disabled: false,
            },
            {
                id: '58',
                label: '局总部审核通过',
                text: '局总部审核通过',
                "color": "Blue",
                value: '58',
                
                disabled: false,
            },
            {
                id: '60',
                label: '局总部审核不通过',
                text: '局总部审核不通过',
                "color": "Red",
                value: '60',
                
                disabled: false,
            },
            {
                id: '61',
                label: '待局总部审批',
                text: '待局总部审批',
                "color": "Blue",
                value: '61',
                
                disabled: false,
            },
            {
                id: '62',
                label: '待审批编号',
                text: '待审批编号',
                "color": "Blue",
                value: '62',
                
                disabled: false,
            },
            {
                id: '63',
                label: '局总部审批不通过',
                text: '局总部审批不通过',
                "color": "Red",
                value: '63',
                
                disabled: false,
            },
            {
                id: '65',
                label: '待报到',
                text: '待报到',
                "color": "Blue",
                value: '65',
                
                disabled: false,
            },
            {
                id: '70',
                label: '已报到',
                text: '已报到',
                "color": "Green",
                value: '70',
                
                disabled: false,
            },
            {
                id: '80',
                label: '逾期未报到',
                text: '逾期未报到',
                "color": "Red",
                value: '80',
                
                disabled: false,
            },
            {
                id: '90',
                label: '失效',
                text: '失效',
                "color": "Red",
                value: '90',
                
                disabled: false,
            },
        ]
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
                "color": "Blue",
                value: '1',
                
                disabled: false,
            },
            {
                id: '0',
                label: '停用',
                text: '停用',
                "color": "Red",
                value: '0',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_RANK",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'PCMCL_HJDJ',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '80',
                label: '学校校级',
                text: '学校校级',
                value: '80',
                
                disabled: false,
            },
            {
                id: '90',
                label: '学校院级',
                text: '学校院级',
                value: '90',
                
                disabled: false,
            },
            {
                id: '10',
                label: '国家级',
                text: '国家级',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '省（自治区、直辖市）级',
                text: '省（自治区、直辖市）级',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '部委级',
                text: '部委级',
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '地（市、厅）级',
                text: '地（市、厅）级',
                value: '40',
                
                disabled: false,
            },
            {
                id: '50',
                label: '区（县）级',
                text: '区（县）级',
                value: '50',
                
                disabled: false,
            },
            {
                id: '60',
                label: '基层单位',
                text: '基层单位',
                value: '60',
                
                disabled: false,
            },
            {
                id: '70',
                label: '国际国外',
                text: '国际国外',
                value: '70',
                
                disabled: false,
            },
        ]
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
        "srfkey": "PIMCL_XXXZ",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
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
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '公司级机关',
                text: '公司级机关',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '经理部机关',
                text: '经理部机关',
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '项目部',
                text: '项目部',
                value: '40',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PCMCL_SBLX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PIMSTAFFTYPE",
        "appdedataset":"FetchYPZ",
        "items": []
    },
    {
        "srfkey": "NATIVEPLACE",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PIMCL_ND2',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '2019',
                label: '2019年',
                text: '2019年',
                value: '2019',
                
                disabled: false,
            },
            {
                id: '2020',
                label: '2020年',
                text: '2020年',
                value: '2020',
                
                disabled: false,
            },
            {
                id: '2021',
                label: '2021年',
                text: '2021年',
                value: '2021',
                
                disabled: false,
            },
            {
                id: '2022',
                label: '2022年',
                text: '2022年',
                value: '2022',
                
                disabled: false,
            },
            {
                id: '2023',
                label: '2023年',
                text: '2023年',
                value: '2023',
                
                disabled: false,
            },
            {
                id: '2024',
                label: '2024年',
                text: '2024年',
                value: '2024',
                
                disabled: false,
            },
            {
                id: '2025',
                label: '2025年',
                text: '2025年',
                value: '2025',
                
                disabled: false,
            },
            {
                id: '2026',
                label: '2026年',
                text: '2026年',
                value: '2026',
                
                disabled: false,
            },
            {
                id: '2027',
                label: '2027年',
                text: '2027年',
                value: '2027',
                
                disabled: false,
            },
            {
                id: '2028',
                label: '2028年',
                text: '2028年',
                value: '2028',
                
                disabled: false,
            },
            {
                id: '2029',
                label: '2029年',
                text: '2029年',
                value: '2029',
                
                disabled: false,
            },
            {
                id: '2030',
                label: '2030年',
                text: '2030年',
                value: '2030',
                
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
        "srfkey": "PIMCL_HY",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_ZZMM",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "ORMCL_LEVELTWOORG",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"ORMORG",
        "appdedataset":"FetchAllLevelTwoOrg2",
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
                value: '1',
                
                disabled: false,
            },
            {
                id: '0',
                label: '否',
                text: '否',
                value: '0',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "SSQY",
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
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '项目部门',
                text: '项目部门',
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_XB",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PIMCL_YW',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '0',
                label: '无',
                text: '无',
                value: '0',
                
                disabled: false,
            },
            {
                id: '1',
                label: '有',
                text: '有',
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
                "color": "Blue",
                value: '1',
                
                disabled: false,
            },
            {
                id: '0',
                label: '否',
                text: '否',
                "color": "Red",
                value: '0',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_RZLB",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '非法人单位',
                text: '非法人单位',
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_XL",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
        "srfkey": "PIMCL_NATION",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_HKLX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    }
    ]];
});

