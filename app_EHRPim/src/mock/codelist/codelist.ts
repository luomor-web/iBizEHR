import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: 'PIMCL_JGXMFB',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '1',
                label: '局机关',
                text: '局机关',
                value: '1',
                
                disabled: false,
            },
            {
                id: '2',
                label: '二级单位',
                text: '二级单位',
                value: '2',
                
                disabled: false,
            },
            {
                id: '3',
                label: '地区机关',
                text: '地区机关',
                value: '3',
                
                disabled: false,
            },
            {
                id: '4',
                label: '项目人员',
                text: '项目人员',
                value: '4',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_LAYERNO',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '上',
                text: '上',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '中',
                text: '中',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '下',
                text: '下',
                value: '30',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_NLFB',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '55',
                label: '55岁以上',
                text: '55岁以上',
                value: '55',
                
                disabled: false,
            },
            {
                id: '51',
                label: '51~55岁',
                text: '51~55岁',
                value: '51',
                
                disabled: false,
            },
            {
                id: '46',
                label: '46~50岁',
                text: '46~50岁',
                value: '46',
                
                disabled: false,
            },
            {
                id: '41',
                label: '41~45岁',
                text: '41~45岁',
                value: '41',
                
                disabled: false,
            },
            {
                id: '36',
                label: '36~40岁',
                text: '36~40岁',
                value: '36',
                
                disabled: false,
            },
            {
                id: '31',
                label: '31~35岁',
                text: '31~35岁',
                value: '31',
                
                disabled: false,
            },
            {
                id: '30',
                label: '30岁以下',
                text: '30岁以下',
                value: '30',
                
                disabled: false,
            },
        ]
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
        "srfkey": "CFPLX",
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
        srfkey: 'PIMCL_GZZT',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '挂职进',
                text: '挂职进',
                "color": "（深蓝）DarkBlue",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '挂职出',
                text: '挂职出',
                "color": "（深绿）DarkGreen",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_ZCDJ",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PARCL_Quarter',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '第一季度',
                text: '第一季度',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '第二季度',
                text: '第二季度',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '第三季度',
                text: '第三季度',
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '第四季度',
                text: '第四季度',
                value: '40',
                
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
        srfkey: 'PIMCL_ND',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '2012',
                label: '2012年',
                text: '2012年',
                value: '2012',
                
                disabled: false,
            },
            {
                id: '2013',
                label: '2013年',
                text: '2013年',
                value: '2013',
                
                disabled: false,
            },
            {
                id: '2014',
                label: '2014年',
                text: '2014年',
                value: '2014',
                
                disabled: false,
            },
            {
                id: '2015',
                label: '2015年',
                text: '2015年',
                value: '2015',
                
                disabled: false,
            },
            {
                id: '2016',
                label: '2016年',
                text: '2016年',
                value: '2016',
                
                disabled: false,
            },
            {
                id: '2017',
                label: '2017年',
                text: '2017年',
                value: '2017',
                
                disabled: false,
            },
            {
                id: '2018',
                label: '2018年',
                text: '2018年',
                value: '2018',
                
                disabled: false,
            },
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
        "srfkey": "PCMCL_XKML",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"PCMXKML",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "PIMCL_ZJ",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PIMCL_YGXXJLSS',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '管理员',
                text: '管理员',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '个人',
                text: '个人',
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_XL3',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '1DR',
                label: '博士',
                text: '博士',
                value: '1DR',
                
                disabled: false,
            },
            {
                id: '2MD',
                label: '硕士',
                text: '硕士',
                value: '2MD',
                
                disabled: false,
            },
            {
                id: '3UNDERGRAD',
                label: '本科',
                text: '本科',
                value: '3UNDERGRAD',
                
                disabled: false,
            },
            {
                id: '4JUNIOR',
                label: '大专',
                text: '大专',
                value: '4JUNIOR',
                
                disabled: false,
            },
            {
                id: '5TECHSECSCH',
                label: '中专及以下',
                text: '中专及以下',
                value: '5TECHSECSCH',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_TROOPTYPE",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'CodeList82',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '01',
                label: '1月',
                text: '1月',
                value: '01',
                
                disabled: false,
            },
            {
                id: '02',
                label: '2月',
                text: '2月',
                value: '02',
                
                disabled: false,
            },
            {
                id: '03',
                label: '3月',
                text: '3月',
                value: '03',
                
                disabled: false,
            },
            {
                id: '04',
                label: '4月',
                text: '4月',
                value: '04',
                
                disabled: false,
            },
            {
                id: '05',
                label: '5月',
                text: '5月',
                value: '05',
                
                disabled: false,
            },
            {
                id: '06',
                label: '6月',
                text: '6月',
                value: '06',
                
                disabled: false,
            },
            {
                id: '07',
                label: '7月',
                text: '7月',
                value: '07',
                
                disabled: false,
            },
            {
                id: '08',
                label: '8月',
                text: '8月',
                value: '08',
                
                disabled: false,
            },
            {
                id: '09',
                label: '9月',
                text: '9月',
                value: '09',
                
                disabled: false,
            },
            {
                id: '10',
                label: '10月',
                text: '10月',
                value: '10',
                
                disabled: false,
            },
            {
                id: '11',
                label: '11月',
                text: '11月',
                value: '11',
                
                disabled: false,
            },
            {
                id: '12',
                label: '12月',
                text: '12月',
                value: '12',
                
                disabled: false,
            },
        ]
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
        "srfkey": "PIMCL_KHJL",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'TRMCL_SPZT',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '已通过',
                text: '已通过',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '已拒绝',
                text: '已拒绝',
                value: '20',
                
                disabled: false,
            },
        ]
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
        srfkey: 'PIMCL_DAGHZT',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '借阅中',
                text: '借阅中',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '已归还',
                text: '已归还',
                value: '20',
                
                disabled: false,
            },
        ]
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
        srfkey: 'PIMCL_EXPACCOUNT',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '老干部活动费',
                text: '老干部活动费',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '津补贴',
                text: '津补贴',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '企业效益奖金',
                text: '企业效益奖金',
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '体检费',
                text: '体检费',
                value: '40',
                
                disabled: false,
            },
            {
                id: '50',
                label: '医疗费',
                text: '医疗费',
                value: '50',
                
                disabled: false,
            },
            {
                id: '60',
                label: '其他费用（备注明细）',
                text: '其他费用（备注明细）',
                value: '60',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_STAFFTYPE',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '1000',
                label: '需审核',
                text: '需审核',
                "color": "Red",
                value: '1000',
                
                disabled: false,
            },
            {
                id: '2000',
                label: '不需审核',
                text: '不需审核',
                "color": "Green",
                value: '2000',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_YYZL",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
                "color": "Red",
                value: '0',
                
                disabled: false,
            },
            {
                id: '1',
                label: '行政',
                text: '行政',
                "color": "Blue",
                value: '1',
                
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
        "srfkey": "ORMCL_LEVEL2ORG",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"ORMORG",
        "appdedataset":"FetchAllLevelTwoOrg",
        "items": []
    },
    {
        srfkey: 'ZQ',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '上半年度',
                text: '上半年度',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '下半年度',
                text: '下半年度',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '年度',
                text: '年度',
                value: '30',
                
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
        srfkey: 'WORKSTATE',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '可调配',
                text: '可调配',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '不可调配',
                text: '不可调配',
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PARCL_JXKHLX',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '月度',
                text: '月度',
                "color": "Blue",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '季度',
                text: '季度',
                "color": "BlueViolet",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '半年度',
                text: '半年度',
                "color": "Brown",
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '年度',
                text: '年度',
                "color": "BurlyWood",
                value: '40',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'DASTATE',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '有效',
                text: '有效',
                value: 10,
                
                disabled: false,
            },
            {
                id: '20',
                label: '失效',
                text: '失效',
                value: 20,
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_HKLX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_YGZT",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PersonStateMGR",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        srfkey: 'PIMCL_EXITANDENTRY_TYPE',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '因公',
                text: '因公',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '因私',
                text: '因私',
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_SPZT',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '正常',
                text: '正常',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '待新增审批',
                text: '待新增审批',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '待删除审批',
                text: '待删除审批',
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '待更新审批',
                text: '待更新审批',
                value: '40',
                
                disabled: false,
            },
            {
                id: '50',
                label: '已拒绝',
                text: '已拒绝',
                value: '50',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_HTLX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PIMCONTRACTTYPE",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "PIMCL_ZJLX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_JCLX",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_FPLX",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_TYPECONTRACT",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"PIMTYPECONTRACT",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "PIMCL_JCJB",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PIMCL_BGLX',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '更新',
                text: '更新',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '更正',
                text: '更正',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '删除',
                text: '删除',
                value: '30',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_ZCLX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_DANGJI",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "ATTCL_KQLX",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'PCMCL_RCXLLX',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: 'GL',
                label: '管理序列',
                text: '管理序列',
                value: 'GL',
                
                disabled: false,
            },
            {
                id: 'GW',
                label: '顾问序列',
                text: '顾问序列',
                value: 'GW',
                
                disabled: false,
            },
            {
                id: 'ZY',
                label: '专业序列',
                text: '专业序列',
                value: 'ZY',
                
                disabled: false,
            },
            {
                id: 'CZ',
                label: '操作序列',
                text: '操作序列',
                value: 'CZ',
                
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
        "srfkey": "PIMCL_FPZT",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'DABGDD',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '局总部',
                text: '局总部',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '公司本部',
                text: '公司本部',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '其他',
                text: '其他',
                value: '30',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "PIMCL_RANK",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"ORMRANK",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "PIMCL_XWLX",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_YGLX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PIMSTAFFTYPE",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "ORMCL_QY",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
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
        "srfkey": "NATIVEPLACE",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
        "srfkey": "ORMCL_GW",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"ORMPOST",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        srfkey: 'ZSLX',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '执（职）业资格证书',
                text: '执（职）业资格证书',
                value: '10',
                
                disabled: false,
            },
            {
                id: '5',
                label: '岗位（技能）证书',
                text: '岗位（技能）证书',
                value: '5',
                
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
        "srfkey": "PIMCL_XB",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_LEVEL",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "PIMCL_YBRGX",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PIMCL_HTZT',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '20',
                label: '存续期',
                text: '存续期',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '已过期',
                text: '已过期',
                value: '30',
                
                disabled: false,
            },
            {
                id: '50',
                label: '已终止',
                text: '已终止',
                value: '50',
                
                disabled: false,
            },
            {
                id: '40',
                label: '已续签',
                text: '已续签',
                value: '40',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_JLCFLX',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: 'REWARD',
                label: '奖励',
                text: '奖励',
                value: 'REWARD',
                
                disabled: false,
            },
            {
                id: 'PUNISHMENT',
                label: '惩罚',
                text: '惩罚',
                value: 'PUNISHMENT',
                
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
        "srfkey": "PIMCL_XL",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: 'PIMCL_FJ',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '学历',
                text: '学历',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '学位',
                text: '学位',
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '证书',
                text: '证书',
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '论文',
                text: '论文',
                value: '40',
                
                disabled: false,
            },
            {
                id: '50',
                label: '科研成果',
                text: '科研成果',
                value: '50',
                
                disabled: false,
            },
            {
                id: '60',
                label: '军转干部',
                text: '军转干部',
                value: '60',
                
                disabled: false,
            },
            {
                id: '70',
                label: '专利',
                text: '专利',
                value: '70',
                
                disabled: false,
            },
            {
                id: '90',
                label: '奖惩',
                text: '奖惩',
                value: '90',
                
                disabled: false,
            },
            {
                id: '80',
                label: '语言能力',
                text: '语言能力',
                value: '80',
                
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
        srfkey: 'PIMCL_EXITANDENTRY_WFState',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '拟稿',
                text: '拟稿',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '审批中',
                text: '审批中',
                "color": "Blue",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '已通过',
                text: '已通过',
                "color": "Green",
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '已驳回',
                text: '已驳回',
                "color": "Red",
                value: '40',
                
                disabled: false,
            },
            {
                id: '50',
                label: '已取消',
                text: '已取消',
                "color": "Red",
                value: '50',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_ARCHICEOPETYPE',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '调出操作',
                text: '调出操作',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '调入操作',
                text: '调入操作',
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_JXQ',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '12',
                label: '1年',
                text: '1年',
                value: '12',
                
                disabled: false,
            },
            {
                id: '6',
                label: '6个月',
                text: '6个月',
                value: '6',
                
                disabled: false,
            },
            {
                id: '3',
                label: '3个月',
                text: '3个月',
                value: '3',
                
                disabled: false,
            },
        ]
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
        srfkey: 'PIMCL_JLCZZ',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: 'ACTION',
                label: '执行',
                text: '执行',
                value: 'ACTION',
                
                disabled: false,
            },
            {
                id: 'UNACTION',
                label: '不执行',
                text: '不执行',
                value: 'UNACTION',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PARCL_PJ',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: 'A',
                label: 'A',
                text: 'A',
                value: 'A',
                
                disabled: false,
            },
            {
                id: 'B',
                label: 'B',
                text: 'B',
                value: 'B',
                
                disabled: false,
            },
            {
                id: 'C',
                label: 'C',
                text: 'C',
                value: 'C',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_DAZT',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '员工在档',
                text: '员工在档',
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '员工不在档',
                text: '员工不在档',
                value: '20',
                
                disabled: false,
            },
            {
                id: '25',
                label: '非员工不在档',
                text: '非员工不在档',
                value: '25',
                
                disabled: false,
            },
            {
                id: '30',
                label: '非员工在档',
                text: '非员工在档',
                value: '30',
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "LanguageLevel",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '离岗',
                text: '离岗',
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'PIMCL_XMJB',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '0',
                label: '特级',
                text: '特级',
                value: '0',
                
                disabled: false,
            },
            {
                id: '1',
                label: '一级',
                text: '一级',
                value: '1',
                
                disabled: false,
            },
            {
                id: '2',
                label: '二级',
                text: '二级',
                value: '2',
                
                disabled: false,
            },
            {
                id: '3',
                label: '三级',
                text: '三级',
                value: '3',
                
                disabled: false,
            },
            {
                id: '4',
                label: '四级',
                text: '四级',
                value: '4',
                
                disabled: false,
            },
            {
                id: '5',
                label: '五级',
                text: '五级',
                value: '5',
                
                disabled: false,
            },
        ]
    }
    ]];
});

