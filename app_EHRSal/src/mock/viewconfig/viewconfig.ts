import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "salrulempickupview": {
            "title": "薪酬规则数据多项选择视图",
            "caption": "薪酬规则",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalRuleMPickupView",
            "viewtag": "0035bbf9195caf7bb14cc636a3737fd2"
        },
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupGridView",
            "viewtag": "003e6c435a00b644dbb357eed210cb32"
        },
        "salitempickupgridview": {
            "title": "薪酬要素项选择表格视图",
            "caption": "薪酬要素项",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalItemPickupGridView",
            "viewtag": "0a7cdd159443d6b7d164672308194872"
        },
        "salschemepickupview": {
            "title": "薪酬方案数据选择视图",
            "caption": "工资单",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemePickupView",
            "viewtag": "1539fc789566f5acbceceefaf7463912"
        },
        "salruleeditview": {
            "title": "薪酬规则编辑视图",
            "caption": "薪酬规则",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalRuleEditView",
            "viewtag": "2f49a6f63db41f57072f028be1c29756"
        },
        "saltypeeditview": {
            "title": "薪酬类型编辑视图",
            "caption": "薪酬类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalTypeEditView",
            "viewtag": "324016f50d34fa67d0292f68c636b19b"
        },
        "salsubjectpickupview": {
            "title": "财务科目数据选择视图",
            "caption": "财务科目",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSubjectPickupView",
            "viewtag": "32fc17a65032792041ef63ed61741fe3"
        },
        "index": {
            "title": "EHR—薪酬管理",
            "caption": "EHR—薪酬管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "SAL",
            "viewname": "Index",
            "viewtag": "36630F8C-711F-41C5-B9E4-39298985A585"
        },
        "salstdxmgzeditview": {
            "title": "项目工资标准编辑视图",
            "caption": "项目工资标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdXmgzEditView",
            "viewtag": "37c011e01d93d713ab87c482aa2908e8"
        },
        "salruledetaileditview": {
            "title": "薪酬规则明细编辑视图",
            "caption": "薪酬规则明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalRuleDetailEditView",
            "viewtag": "3a0b5636f1cb242c9fac8211b31f9ddb"
        },
        "ormdutypickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmDutyPickupGridView",
            "viewtag": "3a6f2dca81a7ae749a411e670510767c"
        },
        "salparameditview": {
            "title": "薪酬计算指标编辑视图",
            "caption": "薪酬计算指标",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalParamEditView",
            "viewtag": "42956c109010f0879a41dd3266e279a0"
        },
        "salruledetailgridview": {
            "title": "薪酬规则明细表格视图",
            "caption": "薪酬规则明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalRuleDetailGridView",
            "viewtag": "5605a1ba8ee791fefa7eabbec7b285a0"
        },
        "salsourcepickupview": {
            "title": "薪酬计算源数据选择视图",
            "caption": "薪酬计算源",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSourcePickupView",
            "viewtag": "58ac9e12f096070e815322949bd7c478"
        },
        "ormdutypickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmDutyPickupView",
            "viewtag": "5a1c3b6c244e71fd16c6c2d2aa2033af"
        },
        "salstdgwgzgridview": {
            "title": "岗位工资标准表格视图",
            "caption": "岗位工资标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdgwgzGridView",
            "viewtag": "5c199b2795b1d8e13f8efa3353618b9c"
        },
        "salitemmpickupview": {
            "title": "薪酬要素项数据多项选择视图",
            "caption": "薪酬要素项",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalItemMPickupView",
            "viewtag": "7048cb28f0e9f26c9a1515e6238d0580"
        },
        "salsourcepickupgridview": {
            "title": "薪酬计算源选择表格视图",
            "caption": "薪酬计算源",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSourcePickupGridView",
            "viewtag": "75c878ff7d82d0ffb35ca4b9e6ab5ac9"
        },
        "salschemeeditview": {
            "title": "薪酬方案编辑视图",
            "caption": "工资单",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeEditView",
            "viewtag": "817ea8d9a018ecf1d3caad347cf1e09f"
        },
        "salsourceeditview": {
            "title": "薪酬计算源编辑视图",
            "caption": "薪酬计算源",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSourceEditView",
            "viewtag": "a0bfdd5660561dd0f43d46568a486269"
        },
        "salschemempickupview": {
            "title": "薪酬方案数据多项选择视图",
            "caption": "工资单",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeMPickupView",
            "viewtag": "a63122cb1dbda97282ba0741f9859ef4"
        },
        "salparampickupgridview": {
            "title": "薪酬计算指标选择表格视图",
            "caption": "薪酬计算指标",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalParamPickupGridView",
            "viewtag": "ac5ef9f5617c5fc70cdd7a3d23389396"
        },
        "salschemegridview": {
            "title": "薪酬方案表格视图",
            "caption": "工资单",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeGridView",
            "viewtag": "b0359cd7880295cf20f26a6de36b5b7d"
        },
        "salsourcegridview": {
            "title": "薪酬计算源表格视图",
            "caption": "薪酬计算源",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSourceGridView",
            "viewtag": "b82a28f98dabe2147523367af496ce8a"
        },
        "salrulepickupview": {
            "title": "薪酬规则数据选择视图",
            "caption": "薪酬规则",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalRulePickupView",
            "viewtag": "b911fc03f2218e4dd73cc5c963f3031e"
        },
        "salschemepickupgridview": {
            "title": "薪酬方案选择表格视图",
            "caption": "工资单",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemePickupGridView",
            "viewtag": "cac79ffa1ad3275d974dab3a6d377a4b"
        },
        "salschemeitemgridview": {
            "title": "方案要素项表格视图",
            "caption": "工资单要素项",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeItemGridView",
            "viewtag": "d0908e8c3011c16569051fa365a3678e"
        },
        "salitempickupview": {
            "title": "薪酬要素项数据选择视图",
            "caption": "薪酬要素项",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalItemPickupView",
            "viewtag": "d234542fbe434f5c9e6da86c5f3c4304"
        },
        "salparamgridview": {
            "title": "薪酬计算指标表格视图",
            "caption": "薪酬计算指标",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalParamGridView",
            "viewtag": "d3fa27489dfbda569855b3305c9d8e3a"
        },
        "salschemeitemeditview": {
            "title": "方案要素项编辑视图",
            "caption": "工资单要素项",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeItemEditView",
            "viewtag": "df88a72f2eabeebc4e7f05de730938f2"
        },
        "salitemgridview": {
            "title": "薪酬要素项表格视图",
            "caption": "薪酬要素项",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalItemGridView",
            "viewtag": "e428ba00da30a0f44c0415a6c294cebb"
        },
        "salparampickupview": {
            "title": "薪酬计算指标数据选择视图",
            "caption": "薪酬计算指标",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalParamPickupView",
            "viewtag": "e616f28cf9678258f6b776b7618fda78"
        },
        "salrulegridview": {
            "title": "薪酬规则表格视图",
            "caption": "薪酬规则",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalRuleGridView",
            "viewtag": "e713eb5c29d843ac20c1a519648747b6"
        },
        "salrulepickupgridview": {
            "title": "薪酬规则选择表格视图",
            "caption": "薪酬规则",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalRulePickupGridView",
            "viewtag": "eca92f2030382307ae97128ca7c55aab"
        },
        "saltypegridview": {
            "title": "薪酬类型表格视图",
            "caption": "薪酬类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalTypeGridView",
            "viewtag": "ecdae2be14321abf03a8a5498c9d1bf3"
        },
        "salstdgwgzeditview": {
            "title": "岗位工资标准编辑视图",
            "caption": "岗位工资标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdgwgzEditView",
            "viewtag": "eed4386059824f226425556c668ffd46"
        },
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupView",
            "viewtag": "ef4104b2291a9e5496b77cedbb29e007"
        },
        "salstdxmgzgridview": {
            "title": "项目工资标准表格视图",
            "caption": "项目工资标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdXmgzGridView",
            "viewtag": "f169dd9ecee320263c3ff7f3bcf017a2"
        },
        "salsubjectpickupgridview": {
            "title": "财务科目选择表格视图",
            "caption": "财务科目",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSubjectPickupGridView",
            "viewtag": "f72b5f0b1c3fce12d75791c66d5e8878"
        },
        "salitemeditview": {
            "title": "薪酬要素项编辑视图",
            "caption": "薪酬要素项",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalItemEditView",
            "viewtag": "f8c313ecc86037a3c52c2d5322717e43"
        }
    }];
});