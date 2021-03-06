import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "EhrCodeList0020",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "上",
                text: "上",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "中",
                text: "中",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "下",
                text: "下",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
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
        srfkey: "EhrCodeList0110",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "上午",
                text: "上午",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "下午",
                text: "下午",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0117",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0237",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
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
        "srfkey": "EhrCodeList0024",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0177",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "第一季度",
                text: "第一季度",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "第二季度",
                text: "第二季度",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "第三季度",
                text: "第三季度",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "第四季度",
                text: "第四季度",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0018",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0115",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "2012",
                label: "2012年",
                text: "2012年",
                "data":"",
                "codename":"Item_2012",
                value: 2012,
                
                disabled: false,
            },
            {
                id: "2013",
                label: "2013年",
                text: "2013年",
                "data":"",
                "codename":"Item_2013",
                value: 2013,
                
                disabled: false,
            },
            {
                id: "2014",
                label: "2014年",
                text: "2014年",
                "data":"",
                "codename":"Item_2014",
                value: 2014,
                
                disabled: false,
            },
            {
                id: "2015",
                label: "2015年",
                text: "2015年",
                "data":"",
                "codename":"Item_2015",
                value: 2015,
                
                disabled: false,
            },
            {
                id: "2016",
                label: "2016年",
                text: "2016年",
                "data":"",
                "codename":"Item_2016",
                value: 2016,
                
                disabled: false,
            },
            {
                id: "2017",
                label: "2017年",
                text: "2017年",
                "data":"",
                "codename":"Item_2017",
                value: 2017,
                
                disabled: false,
            },
            {
                id: "2018",
                label: "2018年",
                text: "2018年",
                "data":"",
                "codename":"Item_2018",
                value: 2018,
                
                disabled: false,
            },
            {
                id: "2019",
                label: "2019年",
                text: "2019年",
                "data":"",
                "codename":"Item_2019",
                value: 2019,
                
                disabled: false,
            },
            {
                id: "2020",
                label: "2020年",
                text: "2020年",
                "data":"",
                "codename":"Item_2020",
                value: 2020,
                
                disabled: false,
            },
            {
                id: "2021",
                label: "2021年",
                text: "2021年",
                "data":"",
                "codename":"Item_2021",
                value: 2021,
                
                disabled: false,
            },
            {
                id: "2022",
                label: "2022年",
                text: "2022年",
                "data":"",
                "codename":"Item_2022",
                value: 2022,
                
                disabled: false,
            },
            {
                id: "2023",
                label: "2023年",
                text: "2023年",
                "data":"",
                "codename":"Item_2023",
                value: 2023,
                
                disabled: false,
            },
            {
                id: "2024",
                label: "2024年",
                text: "2024年",
                "data":"",
                "codename":"Item_2024",
                value: 2024,
                
                disabled: false,
            },
            {
                id: "2025",
                label: "2025年",
                text: "2025年",
                "data":"",
                "codename":"Item_2025",
                value: 2025,
                
                disabled: false,
            },
            {
                id: "2026",
                label: "2026年",
                text: "2026年",
                "data":"",
                "codename":"Item_2026",
                value: 2026,
                
                disabled: false,
            },
            {
                id: "2027",
                label: "2027年",
                text: "2027年",
                "data":"",
                "codename":"Item_2027",
                value: 2027,
                
                disabled: false,
            },
            {
                id: "2028",
                label: "2028年",
                text: "2028年",
                "data":"",
                "codename":"Item_2028",
                value: 2028,
                
                disabled: false,
            },
            {
                id: "2029",
                label: "2029年",
                text: "2029年",
                "data":"",
                "codename":"Item_2029",
                value: 2029,
                
                disabled: false,
            },
            {
                id: "2030",
                label: "2030年",
                text: "2030年",
                "data":"",
                "codename":"Item_2030",
                value: 2030,
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0093",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"PcmXkml",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0234",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0034",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "管理员",
                text: "管理员",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "个人",
                text: "个人",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0035",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "CodeList82",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "1月",
                text: "1月",
                "data":"",
                "codename":"Item_1",
                value: 1,
                
                disabled: false,
            },
            {
                id: "2",
                label: "2月",
                text: "2月",
                "data":"",
                "codename":"Item_2",
                value: 2,
                
                disabled: false,
            },
            {
                id: "3",
                label: "3月",
                text: "3月",
                "data":"",
                "codename":"Item_3",
                value: 3,
                
                disabled: false,
            },
            {
                id: "4",
                label: "4月",
                text: "4月",
                "data":"",
                "codename":"Item_4",
                value: 4,
                
                disabled: false,
            },
            {
                id: "5",
                label: "5月",
                text: "5月",
                "data":"",
                "codename":"Item_5",
                value: 5,
                
                disabled: false,
            },
            {
                id: "6",
                label: "6月",
                text: "6月",
                "data":"",
                "codename":"Item_6",
                value: 6,
                
                disabled: false,
            },
            {
                id: "7",
                label: "7月",
                text: "7月",
                "data":"",
                "codename":"Item_7",
                value: 7,
                
                disabled: false,
            },
            {
                id: "8",
                label: "8月",
                text: "8月",
                "data":"",
                "codename":"Item_8",
                value: 8,
                
                disabled: false,
            },
            {
                id: "9",
                label: "9月",
                text: "9月",
                "data":"",
                "codename":"Item_9",
                value: 9,
                
                disabled: false,
            },
            {
                id: "10",
                label: "10月",
                text: "10月",
                "data":"",
                "codename":"Item_10",
                value: 10,
                
                disabled: false,
            },
            {
                id: "11",
                label: "11月",
                text: "11月",
                "data":"",
                "codename":"Item_11",
                value: 11,
                
                disabled: false,
            },
            {
                id: "12",
                label: "12月",
                text: "12月",
                "data":"",
                "codename":"Item_12",
                value: 12,
                
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
        "srfkey": "EhrCodeList0142",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
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
        "srfkey": "EhrCodeList0075",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0134",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "拟稿",
                text: "拟稿",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "审批中",
                text: "审批中",
                "data":"",
                "codename":"Item_20",
                "color": "Blue",
                value: "20",
                
                disabled: false,
            },
            {
                id: "25",
                label: "待销假",
                text: "待销假",
                "data":"",
                "codename":"Item_25",
                "color": "Blue",
                value: "25",
                
                disabled: false,
            },
            {
                id: "30",
                label: "已通过",
                text: "已通过",
                "data":"",
                "codename":"Item_30",
                "color": "Green",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "已驳回",
                text: "已驳回",
                "data":"",
                "codename":"Item_40",
                "color": "Red",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "已取消",
                text: "已取消",
                "data":"",
                "codename":"Item_50",
                "color": "Red",
                value: "50",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0029",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0149",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "借阅中",
                text: "借阅中",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "已归还",
                text: "已归还",
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
        srfkey: "EhrCodeList0245",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "探父母",
                text: "探父母",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "探配偶",
                text: "探配偶",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0122",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0041",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
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
        srfkey: "EhrCodeList0092",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "月度",
                text: "月度",
                "data":"",
                "codename":"Item_10",
                "color": "Blue",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "季度",
                text: "季度",
                "data":"",
                "codename":"Item_20",
                "color": "BlueViolet",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "半年度",
                text: "半年度",
                "data":"",
                "codename":"Item_30",
                "color": "Brown",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "年度",
                text: "年度",
                "data":"",
                "codename":"Item_40",
                "color": "BurlyWood",
                value: "40",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0057",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "有效",
                text: "有效",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(0, 98, 255, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "失效",
                text: "失效",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0070",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
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
        srfkey: "EhrCodeList0126",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "因公",
                text: "因公",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "因私",
                text: "因私",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0138",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "正常",
                text: "正常",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "待新增审批",
                text: "待新增审批",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "待删除审批",
                text: "待删除审批",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "待更新审批",
                text: "待更新审批",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "已拒绝",
                text: "已拒绝",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0084",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PimContractType",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0231",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0136",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0205",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0107",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"PimTypeContract",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0159",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0047",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0033",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0238",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "待处理",
                text: "待处理",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "处理中",
                text: "处理中",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "待确认",
                text: "待确认",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "已确认",
                text: "已确认",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "确认未通过",
                text: "确认未通过",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
            {
                id: "60",
                label: "已关闭",
                text: "已关闭",
                "data":"",
                "codename":"Item_60",
                value: "60",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0012",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "GL",
                label: "管理序列",
                text: "管理序列",
                "data":"",
                "codename":"Gl",
                value: "GL",
                
                disabled: false,
            },
            {
                id: "GW",
                label: "顾问序列",
                text: "顾问序列",
                "data":"",
                "codename":"Gw",
                value: "GW",
                
                disabled: false,
            },
            {
                id: "ZY",
                label: "专业序列",
                text: "专业序列",
                "data":"",
                "codename":"Zy",
                value: "ZY",
                
                disabled: false,
            },
            {
                id: "CZ",
                label: "操作序列",
                text: "操作序列",
                "data":"",
                "codename":"Cz",
                value: "CZ",
                
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
        srfkey: "EhrCodeList0007",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "打卡机",
                text: "打卡机",
                "data":"",
                "codename":"Item_10",
                "color": "Blue",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "定位打卡",
                text: "定位打卡",
                "data":"",
                "codename":"Item_20",
                "color": "Blue",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "不打卡",
                text: "不打卡",
                "data":"",
                "codename":"Item_30",
                "color": "Red",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0137",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0040",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "局总部",
                text: "局总部",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "公司本部",
                text: "公司本部",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "其他",
                text: "其他",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0025",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmRank",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0155",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0219",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmQygl",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0208",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0001",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
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
        srfkey: "EhrCodeList0055",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "一般",
                text: "一般",
                "data":"",
                "codename":"Item_10",
                "color": "Green",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "紧急",
                text: "紧急",
                "data":"",
                "codename":"Item_20",
                "color": "Orange",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "特急",
                text: "特急",
                "data":"",
                "codename":"Item_30",
                "color": "Red",
                value: "30",
                
                disabled: false,
            },
        ]
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
        srfkey: "EhrCodeList0109",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "执（职）业资格证书",
                text: "执（职）业资格证书",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "5",
                label: "岗位（技能）证书",
                text: "岗位（技能）证书",
                "data":"",
                "codename":"Item_5",
                value: "5",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0013",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"VacLeaceType",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0250",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0072",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0198",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0043",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0030",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "20",
                label: "存续期",
                text: "存续期",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "已过期",
                text: "已过期",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "50",
                label: "已终止",
                text: "已终止",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
            {
                id: "40",
                label: "已续签",
                text: "已续签",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0124",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "REWARD",
                label: "奖励",
                text: "奖励",
                "data":"",
                "codename":"Reward",
                value: "REWARD",
                
                disabled: false,
            },
            {
                id: "PUNISHMENT",
                label: "惩罚",
                text: "惩罚",
                "data":"",
                "codename":"Punishment",
                value: "PUNISHMENT",
                
                disabled: false,
            },
        ]
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
        "srfkey": "EhrCodeList0131",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0140",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0106",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "拟稿",
                text: "拟稿",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "审批中",
                text: "审批中",
                "data":"",
                "codename":"Item_20",
                "color": "Blue",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "已通过",
                text: "已通过",
                "data":"",
                "codename":"Item_30",
                "color": "Green",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "已驳回",
                text: "已驳回",
                "data":"",
                "codename":"Item_40",
                "color": "Red",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "已取消",
                text: "已取消",
                "data":"",
                "codename":"Item_50",
                "color": "Red",
                value: "50",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0227",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "调出操作",
                text: "调出操作",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "调入操作",
                text: "调入操作",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0066",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0118",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "ACTION",
                label: "执行",
                text: "执行",
                "data":"",
                "codename":"Action",
                value: "ACTION",
                
                disabled: false,
            },
            {
                id: "UNACTION",
                label: "不执行",
                text: "不执行",
                "data":"",
                "codename":"Unaction",
                value: "UNACTION",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0169",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "员工在档",
                text: "员工在档",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "员工不在档",
                text: "员工不在档",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "25",
                label: "非员工不在档",
                text: "非员工不在档",
                "data":"",
                "codename":"Item_25",
                value: "25",
                
                disabled: false,
            },
            {
                id: "30",
                label: "非员工在档",
                text: "非员工在档",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0146",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
    },
    {
        srfkey: "EhrCodeList0201",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "0",
                label: "特级",
                text: "特级",
                "data":"",
                "codename":"Item_0",
                value: "0",
                
                disabled: false,
            },
            {
                id: "1",
                label: "一级",
                text: "一级",
                "data":"",
                "codename":"Item_1",
                value: "1",
                
                disabled: false,
            },
            {
                id: "2",
                label: "二级",
                text: "二级",
                "data":"",
                "codename":"Item_2",
                value: "2",
                
                disabled: false,
            },
            {
                id: "3",
                label: "三级",
                text: "三级",
                "data":"",
                "codename":"Item_3",
                value: "3",
                
                disabled: false,
            },
            {
                id: "4",
                label: "四级",
                text: "四级",
                "data":"",
                "codename":"Item_4",
                value: "4",
                
                disabled: false,
            },
            {
                id: "5",
                label: "五级",
                text: "五级",
                "data":"",
                "codename":"Item_5",
                value: "5",
                
                disabled: false,
            },
        ]
    }
    ]];
});

