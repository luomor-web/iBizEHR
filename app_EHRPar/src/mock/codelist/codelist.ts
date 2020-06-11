import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: 'EhrCodeList0115',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '2012',
                label: '2012年',
                text: '2012年',
                "data":"",
                "codename":"Item_2012",
                value: '2012',
                
                disabled: false,
            },
            {
                id: '2013',
                label: '2013年',
                text: '2013年',
                "data":"",
                "codename":"Item_2013",
                value: '2013',
                
                disabled: false,
            },
            {
                id: '2014',
                label: '2014年',
                text: '2014年',
                "data":"",
                "codename":"Item_2014",
                value: '2014',
                
                disabled: false,
            },
            {
                id: '2015',
                label: '2015年',
                text: '2015年',
                "data":"",
                "codename":"Item_2015",
                value: '2015',
                
                disabled: false,
            },
            {
                id: '2016',
                label: '2016年',
                text: '2016年',
                "data":"",
                "codename":"Item_2016",
                value: '2016',
                
                disabled: false,
            },
            {
                id: '2017',
                label: '2017年',
                text: '2017年',
                "data":"",
                "codename":"Item_2017",
                value: '2017',
                
                disabled: false,
            },
            {
                id: '2018',
                label: '2018年',
                text: '2018年',
                "data":"",
                "codename":"Item_2018",
                value: '2018',
                
                disabled: false,
            },
            {
                id: '2019',
                label: '2019年',
                text: '2019年',
                "data":"",
                "codename":"Item_2019",
                value: '2019',
                
                disabled: false,
            },
            {
                id: '2020',
                label: '2020年',
                text: '2020年',
                "data":"",
                "codename":"Item_2020",
                value: '2020',
                
                disabled: false,
            },
            {
                id: '2021',
                label: '2021年',
                text: '2021年',
                "data":"",
                "codename":"Item_2021",
                value: '2021',
                
                disabled: false,
            },
            {
                id: '2022',
                label: '2022年',
                text: '2022年',
                "data":"",
                "codename":"Item_2022",
                value: '2022',
                
                disabled: false,
            },
            {
                id: '2023',
                label: '2023年',
                text: '2023年',
                "data":"",
                "codename":"Item_2023",
                value: '2023',
                
                disabled: false,
            },
            {
                id: '2024',
                label: '2024年',
                text: '2024年',
                "data":"",
                "codename":"Item_2024",
                value: '2024',
                
                disabled: false,
            },
            {
                id: '2025',
                label: '2025年',
                text: '2025年',
                "data":"",
                "codename":"Item_2025",
                value: '2025',
                
                disabled: false,
            },
            {
                id: '2026',
                label: '2026年',
                text: '2026年',
                "data":"",
                "codename":"Item_2026",
                value: '2026',
                
                disabled: false,
            },
            {
                id: '2027',
                label: '2027年',
                text: '2027年',
                "data":"",
                "codename":"Item_2027",
                value: '2027',
                
                disabled: false,
            },
            {
                id: '2028',
                label: '2028年',
                text: '2028年',
                "data":"",
                "codename":"Item_2028",
                value: '2028',
                
                disabled: false,
            },
            {
                id: '2029',
                label: '2029年',
                text: '2029年',
                "data":"",
                "codename":"Item_2029",
                value: '2029',
                
                disabled: false,
            },
            {
                id: '2030',
                label: '2030年',
                text: '2030年',
                "data":"",
                "codename":"Item_2030",
                value: '2030',
                
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
        srfkey: 'EhrCodeList0064',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '公司领导类',
                text: '公司领导类',
                "data":"",
                "codename":"Item_10",
                "color": "rgba(0, 187, 255, 1)",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '部门领导类',
                text: '部门领导类',
                "data":"",
                "codename":"Item_20",
                "color": "rgba(0, 115, 255, 1)",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '一般管理人员类',
                text: '一般管理人员类',
                "data":"",
                "codename":"Item_30",
                "color": "rgba(60, 0, 255, 1)",
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '其他类',
                text: '其他类',
                "data":"",
                "codename":"Item_40",
                "color": "rgba(144, 0, 255, 1)",
                value: '40',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'EhrCodeList0077',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '年度',
                text: '年度',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '月度',
                text: '月度',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
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
                "data":"",
                "codename":"Item_01",
                value: '01',
                
                disabled: false,
            },
            {
                id: '02',
                label: '2月',
                text: '2月',
                "data":"",
                "codename":"Item_02",
                value: '02',
                
                disabled: false,
            },
            {
                id: '03',
                label: '3月',
                text: '3月',
                "data":"",
                "codename":"Item_03",
                value: '03',
                
                disabled: false,
            },
            {
                id: '04',
                label: '4月',
                text: '4月',
                "data":"",
                "codename":"Item_04",
                value: '04',
                
                disabled: false,
            },
            {
                id: '05',
                label: '5月',
                text: '5月',
                "data":"",
                "codename":"Item_05",
                value: '05',
                
                disabled: false,
            },
            {
                id: '06',
                label: '6月',
                text: '6月',
                "data":"",
                "codename":"Item_06",
                value: '06',
                
                disabled: false,
            },
            {
                id: '07',
                label: '7月',
                text: '7月',
                "data":"",
                "codename":"Item_07",
                value: '07',
                
                disabled: false,
            },
            {
                id: '08',
                label: '8月',
                text: '8月',
                "data":"",
                "codename":"Item_08",
                value: '08',
                
                disabled: false,
            },
            {
                id: '09',
                label: '9月',
                text: '9月',
                "data":"",
                "codename":"Item_09",
                value: '09',
                
                disabled: false,
            },
            {
                id: '10',
                label: '10月',
                text: '10月',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '11',
                label: '11月',
                text: '11月',
                "data":"",
                "codename":"Item_11",
                value: '11',
                
                disabled: false,
            },
            {
                id: '12',
                label: '12月',
                text: '12月',
                "data":"",
                "codename":"Item_12",
                value: '12',
                
                disabled: false,
            },
        ]
    }
    ]];
});

