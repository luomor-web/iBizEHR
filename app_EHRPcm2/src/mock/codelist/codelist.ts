import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "EhrCodeList0401",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "计划内",
                text: "计划内",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(0, 255, 238, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "计划外",
                text: "计划外",
                "data":"",
                "codename":"Item_20",
                "color": "rgba(0, 13, 255, 1)",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0237",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0190",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "标准工时制",
                text: "标准工时制",
                "data":"",
                "codename":"Item_10",
                "color": "Green",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "非标准工时制",
                text: "非标准工时制",
                "data":"",
                "codename":"Item_20",
                "color": "BlueViolet",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0228",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "挂职进",
                text: "挂职进",
                "data":"",
                "codename":"Item_10",
                "color": "（深蓝）DarkBlue",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "挂职出",
                text: "挂职出",
                "data":"",
                "codename":"Item_20",
                "color": "（深绿）DarkGreen",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0018",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0203",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "录入",
                text: "录入",
                "data":"",
                "codename":"Item_10",
                "color": "Green",
                value: "10",
                
                disabled: false,
            },
            {
                id: "15",
                label: "待公司初审",
                text: "待公司初审",
                "data":"",
                "codename":"Item_15",
                "color": "Blue",
                value: "15",
                
                disabled: false,
            },
            {
                id: "20",
                label: "公司初审不通过",
                text: "公司初审不通过",
                "data":"",
                "codename":"Item_20",
                "color": "Red",
                value: "20",
                
                disabled: false,
            },
            {
                id: "21",
                label: "待公司董事长审批",
                text: "待公司董事长审批",
                "data":"",
                "codename":"Item_21",
                "color": "Blue",
                value: "21",
                
                disabled: false,
            },
            {
                id: "22",
                label: "公司董事长不通过",
                text: "公司董事长不通过",
                "data":"",
                "codename":"Item_22",
                "color": "Red",
                value: "22",
                
                disabled: false,
            },
            {
                id: "25",
                label: "待上报",
                text: "待上报",
                "data":"",
                "codename":"Item_25",
                "color": "Green",
                value: "25",
                
                disabled: false,
            },
            {
                id: "30",
                label: "待总部初审",
                text: "待总部初审",
                "data":"",
                "codename":"Item_30",
                "color": "Blue",
                value: "30",
                
                disabled: false,
            },
            {
                id: "50",
                label: "总部初审不通过",
                text: "总部初审不通过",
                "data":"",
                "codename":"Item_50",
                "color": "Red",
                value: "50",
                
                disabled: false,
            },
            {
                id: "55",
                label: "待总部审核",
                text: "待总部审核",
                "data":"",
                "codename":"Item_55",
                "color": "Blue",
                value: "55",
                
                disabled: false,
            },
            {
                id: "58",
                label: "总部审核通过",
                text: "总部审核通过",
                "data":"",
                "codename":"Item_58",
                "color": "Blue",
                value: "58",
                
                disabled: false,
            },
            {
                id: "60",
                label: "总部审核不通过",
                text: "总部审核不通过",
                "data":"",
                "codename":"Item_60",
                "color": "Red",
                value: "60",
                
                disabled: false,
            },
            {
                id: "61",
                label: "待总部审批",
                text: "待总部审批",
                "data":"",
                "codename":"Item_61",
                "color": "Blue",
                value: "61",
                
                disabled: false,
            },
            {
                id: "62",
                label: "待审批编号",
                text: "待审批编号",
                "data":"",
                "codename":"Item_62",
                "color": "Blue",
                value: "62",
                
                disabled: false,
            },
            {
                id: "63",
                label: "总部审批不通过",
                text: "总部审批不通过",
                "data":"",
                "codename":"Item_63",
                "color": "Red",
                value: "63",
                
                disabled: false,
            },
            {
                id: "65",
                label: "待报到",
                text: "待报到",
                "data":"",
                "codename":"Item_65",
                "color": "Blue",
                value: "65",
                
                disabled: false,
            },
            {
                id: "70",
                label: "已报到",
                text: "已报到",
                "data":"",
                "codename":"Item_70",
                "color": "Green",
                value: "70",
                
                disabled: false,
            },
            {
                id: "80",
                label: "逾期未报到",
                text: "逾期未报到",
                "data":"",
                "codename":"Item_80",
                "color": "Red",
                value: "80",
                
                disabled: false,
            },
            {
                id: "90",
                label: "失效",
                text: "失效",
                "data":"",
                "codename":"Item_90",
                "color": "Red",
                value: "90",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0120",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "局级机关",
                text: "局级机关",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "公司级机关",
                text: "公司级机关",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "经理部机关",
                text: "经理部机关",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "项目部",
                text: "项目部",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
        ]
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
        srfkey: "EhrCodeList0247",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "待岗",
                text: "待岗",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "可调配",
                text: "可调配",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0075",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0029",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0174",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "更新",
                text: "更新",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "更正",
                text: "更正",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0054",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "是",
                text: "是",
                "data":"",
                "codename":"Item_1",
                value: "1",
                
                disabled: false,
            },
            {
                id: "0",
                label: "否",
                text: "否",
                "data":"",
                "codename":"Item_0",
                value: "0",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0019",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "机关部门",
                text: "机关部门",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "项目部门",
                text: "项目部门",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0021",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "B/Y类员工转正",
                text: "B/Y类员工转正",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "试用期员工转正",
                text: "试用期员工转正",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "见习期员工转正",
                text: "见习期员工转正",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0073",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "0",
                label: "党内",
                text: "党内",
                "data":"",
                "codename":"Item_0",
                "color": "Red",
                value: "0",
                
                disabled: false,
            },
            {
                id: "1",
                label: "行政",
                text: "行政",
                "data":"",
                "codename":"Item_1",
                "color": "Blue",
                value: "1",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0165",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"PcmReason",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0041",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0022",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "法人单位",
                text: "法人单位",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "非法人单位",
                text: "非法人单位",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0123",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "可调配",
                text: "可调配",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "不可调配",
                text: "不可调配",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0087",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "待审核",
                text: "待审核",
                "data":"",
                "codename":"Item_1",
                "color": "Green",
                value: "1",
                
                disabled: false,
            },
            {
                id: "2",
                label: "审核中",
                text: "审核中",
                "data":"",
                "codename":"Item_2",
                "color": "Brown",
                value: "2",
                
                disabled: false,
            },
            {
                id: "3",
                label: "审核通过",
                text: "审核通过",
                "data":"",
                "codename":"Item_3",
                "color": "Blue",
                value: "3",
                
                disabled: false,
            },
            {
                id: "4",
                label: "审核未通过",
                text: "审核未通过",
                "data":"",
                "codename":"Item_4",
                "color": "Red",
                value: "4",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0070",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0014",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PersonStateMgr",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        srfkey: "EhrCodeList0400",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "是",
                text: "是",
                "data":"",
                "codename":"Item_1",
                value: 1,
                
                disabled: false,
            },
            {
                id: "0",
                label: "否",
                text: "否",
                "data":"",
                "codename":"Item_0",
                value: 0,
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0231",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0205",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0058",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "调动申请",
                text: "调动申请",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "职务变动申请",
                text: "职务变动申请",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "轮岗申请",
                text: "轮岗申请",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "借调申请",
                text: "借调申请",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "兼职申请",
                text: "兼职申请",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0086",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "启用",
                text: "启用",
                "data":"",
                "codename":"Item_1",
                "color": "Blue",
                value: "1",
                
                disabled: false,
            },
            {
                id: "0",
                label: "停用",
                text: "停用",
                "data":"",
                "codename":"Item_0",
                "color": "Red",
                value: "0",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0137",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0182",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "仲裁",
                text: "仲裁",
                "data":"",
                "codename":"Item_1",
                value: "1",
                
                disabled: false,
            },
            {
                id: "2",
                label: "诉讼",
                text: "诉讼",
                "data":"",
                "codename":"Item_2",
                value: "2",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0025",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0167",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
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
        "srfkey": "EhrCodeList0096",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0001",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0233",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmDuty",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0217",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"PcmReason",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0050",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmPost",
        "appdedataset":"FetchDefault",
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
        "srfkey": "EhrCodeList0072",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0043",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0097",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "是",
                text: "是",
                "data":"",
                "codename":"Item_1",
                "color": "Blue",
                value: "1",
                
                disabled: false,
            },
            {
                id: "0",
                label: "否",
                text: "否",
                "data":"",
                "codename":"Item_0",
                "color": "Red",
                value: "0",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0085",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "1个月",
                text: "1个月",
                "data":"",
                "codename":"Item_1",
                value: "1",
                
                disabled: false,
            },
            {
                id: "2",
                label: "2个月",
                text: "2个月",
                "data":"",
                "codename":"Item_2",
                value: "2",
                
                disabled: false,
            },
            {
                id: "6",
                label: "6个月",
                text: "6个月",
                "data":"",
                "codename":"Item_6",
                value: "6",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0140",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0187",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "12",
                label: "1年",
                text: "1年",
                "data":"",
                "codename":"Item_12",
                value: "12",
                
                disabled: false,
            },
            {
                id: "6",
                label: "6个月",
                text: "6个月",
                "data":"",
                "codename":"Item_6",
                value: "6",
                
                disabled: false,
            },
            {
                id: "3",
                label: "3个月",
                text: "3个月",
                "data":"",
                "codename":"Item_3",
                value: "3",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0066",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0197",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "校园招聘",
                text: "校园招聘",
                "data":"",
                "codename":"XYZP",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "社会招聘",
                text: "社会招聘",
                "data":"",
                "codename":"SHZP",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "内部招聘",
                text: "内部招聘",
                "data":"",
                "codename":"NBZP",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0046",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "优秀",
                text: "优秀",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "良好",
                text: "良好",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "一般",
                text: "一般",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "不合格",
                text: "不合格",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0179",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "在岗",
                text: "在岗",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "离岗",
                text: "离岗",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    }
    ]];
});

