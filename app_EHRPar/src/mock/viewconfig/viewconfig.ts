import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "partzggpickupgridview": {
            "title": "通知公告选择表格视图",
            "caption": "通知发布",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParTzggPickupGridView",
            "viewtag": "01dbe2eb55658778f14484a5fda6fb52"
        },
        "parexamcyclepickupview": {
            "title": "考核周期数据选择视图",
            "caption": "考核周期",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCyclePickupView",
            "viewtag": "057fd0a13dc6d8415557b4c0c01ec673"
        },
        "parexamcycleeditview2": {
            "title": "考核周期编辑视图",
            "caption": "考核周期",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParExamCycleEditView2",
            "viewtag": "1e42ac493a08f87edf0c49360e4450e3"
        },
        "parexamcyclegridview": {
            "title": "考核周期",
            "caption": "考核周期",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCycleGridView",
            "viewtag": "25a6fb2dc9f85ee002bcbeca2f1a8205"
        },
        "parexamcyclepickupgridview": {
            "title": "考核周期选择表格视图",
            "caption": "考核周期",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCyclePickupGridView",
            "viewtag": "44b5e93634d7355506f37cde5dd7dde8"
        },
        "partzggmpickupview": {
            "title": "通知公告数据多项选择视图",
            "caption": "通知发布",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParTzggMPickupView",
            "viewtag": "48cb9678c112e2bfeceb56c96c8c0de5"
        },
        "partzgggridview": {
            "title": "通知发布",
            "caption": "通知发布",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParTzggGridView",
            "viewtag": "4cb79515b9133499fc74b275a26e2da5"
        },
        "partzggeditview2": {
            "title": "通知公告编辑视图",
            "caption": "通知发布",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParTzggEditView2",
            "viewtag": "6633c1c5f36292278b6d17b103d0d4fa"
        },
        "partzggpickupview": {
            "title": "通知公告数据选择视图",
            "caption": "通知发布",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParTzggPickupView",
            "viewtag": "8f9a8c61f744324353e5c3f1cf7beeb2"
        },
        "parexamcyclempickupview": {
            "title": "考核周期数据多项选择视图",
            "caption": "考核周期",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCycleMPickupView",
            "viewtag": "9154733e9c78288a33d8342cd81eb5f3"
        },
        "parexamcycleeditview": {
            "title": "考核周期",
            "caption": "考核周期",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCycleEditView",
            "viewtag": "963f9744f61222f20041022b8b7eba31"
        },
        "partzggredirectview": {
            "title": "通知公告数据重定向视图",
            "caption": "通知发布",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PAR",
            "viewname": "ParTzggRedirectView",
            "viewtag": "a376a75f645d147c98157fe2f7e4ecaa"
        },
        "partzggeditview": {
            "title": "通知信息",
            "caption": "通知信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParTzggEditView",
            "viewtag": "b7f7b92b88ba971f28bbb5aa18145e46"
        },
        "index": {
            "title": "EHR—绩效管理",
            "caption": "EHR—绩效管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "PAR",
            "viewname": "Index",
            "viewtag": "C1ABBB2A-7CFE-453A-9531-C33DFC4D0912"
        },
        "partzggeditview9": {
            "title": "通知信息",
            "caption": "通知信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PAR",
            "viewname": "ParTzggEditView9",
            "viewtag": "c7741fa56792325b27e13d323a735061"
        },
        "parexamcycleredirectview": {
            "title": "考核周期数据重定向视图",
            "caption": "考核周期",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCycleRedirectView",
            "viewtag": "fb33821a8e2454b3b8166fe954b46b25"
        }
    }];
});