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
        srfkey: "EhrCodeList0074",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "待确认",
                text: "待确认",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "已确认",
                text: "已确认",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "已取消",
                text: "已取消",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
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
        "srfkey": "EhrCodeList0033",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0068",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: ">",
                label: ">",
                text: ">",
                "data":"",
                "codename":"GT",
                value: ">",
                
                disabled: false,
            },
            {
                id: ">=",
                label: ">=",
                text: ">=",
                "data":"",
                "codename":"GTEQ",
                value: ">=",
                
                disabled: false,
            },
            {
                id: "=",
                label: "=",
                text: "=",
                "data":"",
                "codename":"EQ",
                value: "=",
                
                disabled: false,
            },
            {
                id: "<=",
                label: "<=",
                text: "<=",
                "data":"",
                "codename":"LTEQ",
                value: "<=",
                
                disabled: false,
            },
            {
                id: "<",
                label: "<",
                text: "<",
                "data":"",
                "codename":"LT",
                value: "<",
                
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
        "srfkey": "EhrCodeList0219",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmQygl",
        "appdedataset":"FetchDefault",
        "items": []
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
        "srfkey": "EhrCodeList0233",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmDuty",
        "appdedataset":"FetchDefault",
        "items": []
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
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
        srfkey: "EhrCodeList0128",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "增加",
                text: "增加",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "扣减",
                text: "扣减",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
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
        "srfkey": "EhrCodeList0140",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0102",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "待执行",
                text: "待执行",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "已执行",
                text: "已执行",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "已取消",
                text: "已取消",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0212",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "手工录入",
                text: "手工录入",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "引用规则",
                text: "引用规则",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "引用公式",
                text: "引用公式",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
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
    },
    {
        "srfkey": "EhrCodeList0014",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
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

