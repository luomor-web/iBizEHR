import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: 'EhrCodeList0052',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '法定节假日',
                text: '法定节假日',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '年休假',
                text: '年休假',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '调休上班',
                text: '调休上班',
                "data":"",
                "codename":"Item_30",
                value: '30',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'EhrCodeList0110',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '上午',
                text: '上午',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '下午',
                text: '下午',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'EhrCodeList0148',
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
        "srfkey": "EhrCodeList0098",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"AttEndenceType",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        srfkey: 'EhrCodeList0086',
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
        srfkey: 'EhrCodeList0007',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '打卡机',
                text: '打卡机',
                "data":"",
                "codename":"Item_10",
                "color": "Blue",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '定位打卡',
                text: '定位打卡',
                "data":"",
                "codename":"Item_20",
                "color": "Blue",
                value: '20',
                
                disabled: false,
            },
            {
                id: '30',
                label: '不打卡',
                text: '不打卡',
                "data":"",
                "codename":"Item_30",
                "color": "Red",
                value: '30',
                
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
        "srfkey": "EhrCodeList0233",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
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
        "appdataentity":"",
        "appdedataset":"",
        "items": []
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
        srfkey: 'EhrCodeList0134',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '拟稿',
                text: '拟稿',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '审批中',
                text: '审批中',
                "data":"",
                "codename":"Item_20",
                "color": "Blue",
                value: '20',
                
                disabled: false,
            },
            {
                id: '25',
                label: '待销假',
                text: '待销假',
                "data":"",
                "codename":"Item_25",
                "color": "Blue",
                value: '25',
                
                disabled: false,
            },
            {
                id: '30',
                label: '已通过',
                text: '已通过',
                "data":"",
                "codename":"Item_30",
                "color": "Green",
                value: '30',
                
                disabled: false,
            },
            {
                id: '40',
                label: '已驳回',
                text: '已驳回',
                "data":"",
                "codename":"Item_40",
                "color": "Red",
                value: '40',
                
                disabled: false,
            },
            {
                id: '50',
                label: '已取消',
                text: '已取消',
                "data":"",
                "codename":"Item_50",
                "color": "Red",
                value: '50',
                
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
        srfkey: 'EhrCodeList0054',
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
        "srfkey": "EhrCodeList0250",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'EhrCodeList0019',
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
        "srfkey": "EhrCodeList0072",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'EhrCodeList0245',
        emptytext: '',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '探父母',
                text: '探父母',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '探配偶',
                text: '探配偶',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'EhrCodeList0097',
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
        srfkey: 'EhrCodeList0022',
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
        srfkey: 'EhrCodeList0123',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '10',
                label: '可调配',
                text: '可调配',
                "data":"",
                "codename":"Item_10",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '不可调配',
                text: '不可调配',
                "data":"",
                "codename":"Item_20",
                value: '20',
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: 'EhrCodeList0179',
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
        "srfkey": "EhrCodeList0014",
        "emptytext": "",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    },
    {
        srfkey: 'EhrCodeList0100',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '5',
                label: '待生成',
                text: '待生成',
                "data":"",
                "codename":"Item_5",
                "color": "Orange",
                value: '5',
                
                disabled: false,
            },
            {
                id: '10',
                label: '待确认',
                text: '待确认',
                "data":"",
                "codename":"Item_10",
                "color": "Red",
                value: '10',
                
                disabled: false,
            },
            {
                id: '20',
                label: '已确认',
                text: '已确认',
                "data":"",
                "codename":"Item_20",
                "color": "Green",
                value: '20',
                
                disabled: false,
            },
        ]
    }
    ]];
});

