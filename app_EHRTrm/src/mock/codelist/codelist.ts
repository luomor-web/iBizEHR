import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "EhrCodeList0405",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "培训课程",
                text: "培训课程",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(255, 0, 140, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "培训讲师",
                text: "培训讲师",
                "data":"",
                "codename":"Item_20",
                "color": "rgba(42, 56, 165, 1)",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "培训机构",
                text: "培训机构",
                "data":"",
                "codename":"Item_30",
                "color": "rgba(103, 58, 183, 1)",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "培训设施",
                text: "培训设施",
                "data":"",
                "codename":"Item_40",
                "color": "rgba(209, 196, 233, 1)",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "其他",
                text: "其他",
                "data":"",
                "codename":"Item_50",
                "color": "rgba(225, 0, 255, 1)",
                value: "50",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0011",
        "emptytext": "未定义",
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
        srfkey: "EhrCodeList0161",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "优秀",
                text: "优秀",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(0, 30, 255, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "良好",
                text: "良好",
                "data":"",
                "codename":"Item_20",
                "color": "rgba(234, 0, 255, 1)",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "一般",
                text: "一般",
                "data":"",
                "codename":"Item_30",
                "color": "rgba(4, 255, 0, 1)",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "差",
                text: "差",
                "data":"",
                "codename":"Item_40",
                "color": "rgba(203, 55, 10, 0.97)",
                value: "40",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0130",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
    },
    {
        srfkey: "EhrCodeList0402",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "待发布",
                text: "待发布",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(255, 0, 140, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "已发布",
                text: "已发布",
                "data":"",
                "codename":"Item_20",
                "color": "rgba(42, 56, 165, 1)",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0112",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "标间",
                text: "标间",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "大床房",
                text: "大床房",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "套房",
                text: "套房",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0067",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "培训经费",
                text: "培训经费",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "考试经费",
                text: "考试经费",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "个人外出培训经费",
                text: "个人外出培训经费",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0017",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "立项中",
                text: "立项中",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(255, 0, 85, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "已立项",
                text: "已立项",
                "data":"",
                "codename":"Item_20",
                "color": "rgba(0, 106, 255, 1)",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "已开班",
                text: "已开班",
                "data":"",
                "codename":"Item_30",
                "color": "rgba(213, 0, 255, 1)",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "已取消",
                text: "已取消",
                "data":"",
                "codename":"Item_40",
                "color": "rgba(0, 238, 255, 1)",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "已关闭",
                text: "已关闭",
                "data":"",
                "codename":"Item_50",
                "color": "rgba(49, 27, 146, 1)",
                value: "50",
                
                disabled: false,
            },
        ]
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
        srfkey: "EhrCodeList0171",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "海外工程管理业务能力提升",
                text: "海外工程管理业务能力提升",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "投融资板块业务能力提升",
                text: "投融资板块业务能力提升",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "基础设施管理能力提升",
                text: "基础设施管理能力提升",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "总承包管理能力提升",
                text: "总承包管理能力提升",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "其他",
                text: "其他",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0111",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "内部",
                text: "内部",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(0, 115, 255, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "外部",
                text: "外部",
                "data":"",
                "codename":"Item_20",
                "color": "rgba(242, 0, 255, 1)",
                value: "20",
                
                disabled: false,
            },
        ]
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
        srfkey: "EhrCodeList0403",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "年度",
                text: "年度",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(255, 0, 140, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "季度",
                text: "季度",
                "data":"",
                "codename":"Item_20",
                "color": "rgba(42, 56, 165, 1)",
                value: "20",
                
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
        srfkey: "EhrCodeList0189",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "同声传译机",
                text: "同声传译机",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "舞台效果设备",
                text: "舞台效果设备",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "会议环节特制设备",
                text: "会议环节特制设备",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "投票设备",
                text: "投票设备",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0175",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "公交",
                text: "公交",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "地铁",
                text: "地铁",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "CodeList83",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "1季度",
                text: "1季度",
                "data":"",
                "codename":"Item_1",
                value: "1",
                
                disabled: false,
            },
            {
                id: "2",
                label: "2季度",
                text: "2季度",
                "data":"",
                "codename":"Item_2",
                value: "2",
                
                disabled: false,
            },
            {
                id: "3",
                label: "3季度",
                text: "3季度",
                "data":"",
                "codename":"Item_3",
                value: "3",
                
                disabled: false,
            },
            {
                id: "4",
                label: "4季度",
                text: "4季度",
                "data":"",
                "codename":"Item_4",
                value: "4",
                
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
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0154",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "企业培训需求",
                text: "企业培训需求",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "个人外出培训需求",
                text: "个人外出培训需求",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
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
        srfkey: "EhrCodeList0248",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "投影设备",
                text: "投影设备",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "LED设备",
                text: "LED设备",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "等离子设备",
                text: "等离子设备",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "电脑",
                text: "电脑",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "视频播放器",
                text: "视频播放器",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
            {
                id: "60",
                label: "音响设备",
                text: "音响设备",
                "data":"",
                "codename":"Item_60",
                value: "60",
                
                disabled: false,
            },
            {
                id: "70",
                label: "无线麦克",
                text: "无线麦克",
                "data":"",
                "codename":"Item_70",
                value: "70",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0233",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0032",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "5",
                label: "教授级",
                text: "教授级",
                "data":"",
                "codename":"Item_5",
                "color": "rgba(77, 255, 0, 1)",
                value: "5",
                
                disabled: false,
            },
            {
                id: "10",
                label: "高级",
                text: "高级",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "中级",
                text: "中级",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "初级",
                text: "初级",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0127",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "已通过",
                text: "已通过",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "已拒绝",
                text: "已拒绝",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
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
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: "EhrCodeList0091",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "办公文具",
                text: "办公文具",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "复印机",
                text: "复印机",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "打印机",
                text: "打印机",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "扫描仪",
                text: "扫描仪",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0039",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "普通发票",
                text: "普通发票",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "增值税专用发票",
                text: "增值税专用发票",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
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
        srfkey: "EhrCodeList0230",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "集团级",
                text: "集团级",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "公司级",
                text: "公司级",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
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
        srfkey: "EhrCodeList0082",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "高级",
                text: "高级",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "中级",
                text: "中级",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "初级",
                text: "初级",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
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
        "srfkey": "EhrCodeList0185",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
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
        srfkey: "EhrCodeList0404",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "优秀",
                text: "优秀",
                "data":"",
                "codename":"Item_10",
                "color": "rgba(255, 0, 140, 1)",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "良好",
                text: "良好",
                "data":"",
                "codename":"Item_20",
                "color": "rgba(42, 56, 165, 1)",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "合格",
                text: "合格",
                "data":"",
                "codename":"Item_30",
                "color": "rgba(103, 58, 183, 1)",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "不合格",
                text: "不合格",
                "data":"",
                "codename":"Item_40",
                "color": "rgba(209, 196, 233, 1)",
                value: "40",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "EhrCodeList0186",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "安徽省",
                text: "安徽省",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "20",
                label: "澳门特别行政区",
                text: "澳门特别行政区",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
            {
                id: "30",
                label: "北京市",
                text: "北京市",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "重庆市",
                text: "重庆市",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "福建省",
                text: "福建省",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
            {
                id: "60",
                label: "甘肃省",
                text: "甘肃省",
                "data":"",
                "codename":"Item_60",
                value: "60",
                
                disabled: false,
            },
            {
                id: "70",
                label: "广东省",
                text: "广东省",
                "data":"",
                "codename":"Item_70",
                value: "70",
                
                disabled: false,
            },
            {
                id: "80",
                label: "广西壮族自治区",
                text: "广西壮族自治区",
                "data":"",
                "codename":"Item_80",
                value: "80",
                
                disabled: false,
            },
            {
                id: "90",
                label: "贵州省",
                text: "贵州省",
                "data":"",
                "codename":"Item_90",
                value: "90",
                
                disabled: false,
            },
            {
                id: "100",
                label: "海南省",
                text: "海南省",
                "data":"",
                "codename":"Item_100",
                value: "100",
                
                disabled: false,
            },
            {
                id: "110",
                label: "河北省",
                text: "河北省",
                "data":"",
                "codename":"Item_110",
                value: "110",
                
                disabled: false,
            },
            {
                id: "120",
                label: "黑龙江省",
                text: "黑龙江省",
                "data":"",
                "codename":"Item_120",
                value: "120",
                
                disabled: false,
            },
            {
                id: "130",
                label: "河南省",
                text: "河南省",
                "data":"",
                "codename":"Item_130",
                value: "130",
                
                disabled: false,
            },
            {
                id: "140",
                label: "湖北省",
                text: "湖北省",
                "data":"",
                "codename":"Item_140",
                value: "140",
                
                disabled: false,
            },
            {
                id: "150",
                label: "湖南省",
                text: "湖南省",
                "data":"",
                "codename":"Item_150",
                value: "150",
                
                disabled: false,
            },
            {
                id: "160",
                label: "江苏省",
                text: "江苏省",
                "data":"",
                "codename":"Item_160",
                value: "160",
                
                disabled: false,
            },
            {
                id: "170",
                label: "江西省",
                text: "江西省",
                "data":"",
                "codename":"Item_170",
                value: "170",
                
                disabled: false,
            },
            {
                id: "180",
                label: "吉林省",
                text: "吉林省",
                "data":"",
                "codename":"Item_180",
                value: "180",
                
                disabled: false,
            },
            {
                id: "190",
                label: "辽宁省",
                text: "辽宁省",
                "data":"",
                "codename":"Item_190",
                value: "190",
                
                disabled: false,
            },
            {
                id: "200",
                label: "内蒙古",
                text: "内蒙古",
                "data":"",
                "codename":"Item_200",
                value: "200",
                
                disabled: false,
            },
            {
                id: "210",
                label: "宁夏回族自治区",
                text: "宁夏回族自治区",
                "data":"",
                "codename":"Item_210",
                value: "210",
                
                disabled: false,
            },
            {
                id: "220",
                label: "青海省",
                text: "青海省",
                "data":"",
                "codename":"Item_220",
                value: "220",
                
                disabled: false,
            },
            {
                id: "230",
                label: "陕西省",
                text: "陕西省",
                "data":"",
                "codename":"Item_230",
                value: "230",
                
                disabled: false,
            },
            {
                id: "240",
                label: "山东省",
                text: "山东省",
                "data":"",
                "codename":"Item_240",
                value: "240",
                
                disabled: false,
            },
            {
                id: "250",
                label: "上海市",
                text: "上海市",
                "data":"",
                "codename":"Item_250",
                value: "250",
                
                disabled: false,
            },
            {
                id: "260",
                label: "山西省",
                text: "山西省",
                "data":"",
                "codename":"Item_260",
                value: "260",
                
                disabled: false,
            },
            {
                id: "270",
                label: "四川省",
                text: "四川省",
                "data":"",
                "codename":"Item_270",
                value: "270",
                
                disabled: false,
            },
            {
                id: "280",
                label: "天津市",
                text: "天津市",
                "data":"",
                "codename":"Item_280",
                value: "280",
                
                disabled: false,
            },
            {
                id: "290",
                label: "新疆维吾尔族自治区",
                text: "新疆维吾尔族自治区",
                "data":"",
                "codename":"Item_290",
                value: "290",
                
                disabled: false,
            },
            {
                id: "300",
                label: "西藏自治区",
                text: "西藏自治区",
                "data":"",
                "codename":"Item_300",
                value: "300",
                
                disabled: false,
            },
            {
                id: "310",
                label: "云南省",
                text: "云南省",
                "data":"",
                "codename":"Item_310",
                value: "310",
                
                disabled: false,
            },
            {
                id: "320",
                label: "浙江省",
                text: "浙江省",
                "data":"",
                "codename":"Item_320",
                value: "320",
                
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
        srfkey: "EhrCodeList0010",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "10",
                label: "电脑灯",
                text: "电脑灯",
                "data":"",
                "codename":"Item_10",
                value: "10",
                
                disabled: false,
            },
            {
                id: "30",
                label: "追光灯",
                text: "追光灯",
                "data":"",
                "codename":"Item_30",
                value: "30",
                
                disabled: false,
            },
            {
                id: "40",
                label: "地排灯",
                text: "地排灯",
                "data":"",
                "codename":"Item_40",
                value: "40",
                
                disabled: false,
            },
            {
                id: "50",
                label: "激光灯",
                text: "激光灯",
                "data":"",
                "codename":"Item_50",
                value: "50",
                
                disabled: false,
            },
            {
                id: "20",
                label: "PAR灯",
                text: "PAR灯",
                "data":"",
                "codename":"Item_20",
                value: "20",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "EhrCodeList0145",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"CodeItem",
        "appdedataset":"FetchCurCL",
        "items": []
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
    }
    ]];
});

