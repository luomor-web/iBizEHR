import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        "srfkey": "EhrCodeList0239",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PcmProfileSpyy",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0116",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
        srfkey: "EhrCodeList0173",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "通过",
                text: "通过",
                "data":"",
                "codename":"Item_10",
                "color": "Blue",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "拒绝",
                text: "拒绝",
                "data":"",
                "codename":"Item_20",
                "color": "Red",
                value: "20",
                
                disabled: false,
            },
        ]
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
        "srfkey": "EhrCodeList0117",
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
        srfkey: "EhrCodeList0204",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "CET-4",
                text: "CET-4",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "CET-6",
                text: "CET-6",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "英语专四",
                text: "英语专四",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "英语专八",
                text: "英语专八",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "其他语言",
                text: "其他语言",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
            {
                id: "60",
                label: "无",
                text: "无",
                "data":"",
                "codename":"Item_60",
                value: "60",
                
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
        "srfkey": "EhrCodeList0025",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0152",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "80",
                label: "学校校级",
                text: "学校校级",
                "data":"",
                "codename":"Item_80",
                value: "80",
                
                disabled: false,
            },
            {
                id: "90",
                label: "学校院级",
                text: "学校院级",
                "data":"",
                "codename":"Item_90",
                value: "90",
                
                disabled: false,
            },
            {
                id: "10",
                label: "国家级",
                text: "国家级",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "省（自治区、直辖市）级",
                text: "省（自治区、直辖市）级",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "部委级",
                text: "部委级",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "地（市、厅）级",
                text: "地（市、厅）级",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "区（县）级",
                text: "区（县）级",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
            {
                id: "60",
                label: "基层单位",
                text: "基层单位",
                "data":"",
                "codename":"Item_60",
                value: "60",
                
                disabled: false,
            },
            {
                id: "70",
                label: "国际国外",
                text: "国际国外",
                "data":"",
                "codename":"Item_70",
                value: "70",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0167",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PimStafftype",
        "appdedataset":"FetchDefault",
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
        "srfkey": "EhrCodeList0096",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"PimStafftype",
        "appdedataset":"FetchYPZ",
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
        srfkey: "EhrCodeList0009",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "2019",
                label: "2019年",
                text: "2019年",
                "data":"",
                "codename":"Item_2019",
                value: "2019",
                
                disabled: false,
            },
            {
                id: "2020",
                label: "2020年",
                text: "2020年",
                "data":"",
                "codename":"Item_2020",
                value: "2020",
                
                disabled: false,
            },
            {
                id: "2021",
                label: "2021年",
                text: "2021年",
                "data":"",
                "codename":"Item_2021",
                value: "2021",
                
                disabled: false,
            },
            {
                id: "2022",
                label: "2022年",
                text: "2022年",
                "data":"",
                "codename":"Item_2022",
                value: "2022",
                
                disabled: false,
            },
            {
                id: "2023",
                label: "2023年",
                text: "2023年",
                "data":"",
                "codename":"Item_2023",
                value: "2023",
                
                disabled: false,
            },
            {
                id: "2024",
                label: "2024年",
                text: "2024年",
                "data":"",
                "codename":"Item_2024",
                value: "2024",
                
                disabled: false,
            },
            {
                id: "2025",
                label: "2025年",
                text: "2025年",
                "data":"",
                "codename":"Item_2025",
                value: "2025",
                
                disabled: false,
            },
            {
                id: "2026",
                label: "2026年",
                text: "2026年",
                "data":"",
                "codename":"Item_2026",
                value: "2026",
                
                disabled: false,
            },
            {
                id: "2027",
                label: "2027年",
                text: "2027年",
                "data":"",
                "codename":"Item_2027",
                value: "2027",
                
                disabled: false,
            },
            {
                id: "2028",
                label: "2028年",
                text: "2028年",
                "data":"",
                "codename":"Item_2028",
                value: "2028",
                
                disabled: false,
            },
            {
                id: "2029",
                label: "2029年",
                text: "2029年",
                "data":"",
                "codename":"Item_2029",
                value: "2029",
                
                disabled: false,
            },
            {
                id: "2030",
                label: "2030年",
                text: "2030年",
                "data":"",
                "codename":"Item_2030",
                value: "2030",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0004",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "房屋建筑类",
                text: "房屋建筑类",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "基础设施类",
                text: "基础设施类",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "金融投资类",
                text: "金融投资类",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "勘察设计类",
                text: "勘察设计类",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "职能管理类",
                text: "职能管理类",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
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
        srfkey: "EhrCodeList0181",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "是",
                text: "是",
                "data":"",
                "codename":"Item_1",
                "color": "Red",
                value: 1,
                
                disabled: false,
            },
            {
                id: "0",
                label: "否",
                text: "否",
                "data":"",
                "codename":"Item_0",
                "color": "Feldspar",
                value: 0,
                
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
        "srfkey": "EhrCodeList0050",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmPost",
        "appdedataset":"FetchDefault",
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
        "srfkey": "EhrCodeList0029",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        "srfkey": "EhrCodeList0216",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"OrmOrg",
        "appdedataset":"FetchAllLevelTwoOrg2",
        "items": []
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
        "srfkey": "EhrCodeList0072",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0222",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "0",
                label: "无",
                text: "无",
                "data":"",
                "codename":"Item_0",
                value: "0",
                
                disabled: false,
            },
            {
                id: "1",
                label: "有",
                text: "有",
                "data":"",
                "codename":"Item_1",
                value: "1",
                
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
        "srfkey": "EhrCodeList0066",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0071",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "40",
                label: "建筑系统调入",
                text: "建筑系统调入",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "60",
                label: "军人安置",
                text: "军人安置",
                "data":"",
                "codename":"Item_60",
                value: "60",
                
                disabled: false,
            },
            {
                id: "90",
                label: "其他",
                text: "其他",
                "data":"",
                "codename":"Item_90",
                value: "90",
                
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
        srfkey: "EhrCodeList0078",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
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
        ]
    },
    {
        srfkey: "EhrCodeList0062",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "待上报",
                text: "待上报",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "待局总部审批",
                text: "待局总部审批",
                "data":"",
                "codename":"Item_20",
                "color": "Blue",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "局总部审批不通过",
                text: "局总部审批不通过",
                "data":"",
                "codename":"Item_30",
                "color": "Red",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "待审批编号",
                text: "待审批编号",
                "data":"",
                "codename":"Item_40",
                "color": "Green",
                value: "40",
                
                disabled: false,
            },
        ]
    }
    ]];
});

