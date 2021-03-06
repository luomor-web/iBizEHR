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
        "salschemeitempickupview": {
            "title": "方案要素项数据选择视图",
            "caption": "工资单要素项",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeItemPickupView",
            "viewtag": "032c6651bf5895eb12c622cce64a832e"
        },
        "salsalarydetaileditview": {
            "title": "员工薪酬明细编辑视图",
            "caption": "员工薪酬明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSalaryDetailEditView",
            "viewtag": "03b0dabf4226d8cfd5f1debe7543a91e"
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
        "salstdzxeditview": {
            "title": "专项津贴标准编辑视图",
            "caption": "专项津贴标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdzxEditView",
            "viewtag": "17bf2d24b6ce28ffc40ec1650e067899"
        },
        "salstddszngridview": {
            "title": "独生子女标准表格视图",
            "caption": "独生子女标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStddsznGridView",
            "viewtag": "230755e6c3b7c312acdfceabe73487a7"
        },
        "salschemeitempickupgridview": {
            "title": "方案要素项选择表格视图",
            "caption": "工资单要素项",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeItemPickupGridView",
            "viewtag": "2c1eeac5a276d6e4a90122e9483ce5ca"
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
        "salstdgweditview": {
            "title": "高温津贴标准编辑视图",
            "caption": "高温津贴标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdgwEditView",
            "viewtag": "38453f83b61cdd9b270d6e965f524468"
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
        "salplanpickupgridview": {
            "title": "薪酬计算计划选择表格视图",
            "caption": "薪酬计算计划",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalPlanPickupGridView",
            "viewtag": "3ea143b8fe38da1ec7899551e1fba028"
        },
        "salstdgleditview": {
            "title": "工龄工资标准编辑视图",
            "caption": "工龄工资标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdglEditView",
            "viewtag": "413a44b0e0559d300b5cc17d970f9978"
        },
        "salparameditview": {
            "title": "薪酬计算指标编辑视图",
            "caption": "薪酬计算指标",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalParamEditView",
            "viewtag": "42956c109010f0879a41dd3266e279a0"
        },
        "pimpersonpickupview": {
            "title": "人员信息数据选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonPickupView",
            "viewtag": "42c53769e9715f972f726817185eea6e"
        },
        "salsalarybillpickupview": {
            "title": "工资单数据选择视图",
            "caption": "工资表",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSalaryBillPickupView",
            "viewtag": "442eb40ec649946d8d25cdf10b2fdb72"
        },
        "salplangridview": {
            "title": "薪酬计算计划表格视图",
            "caption": "薪酬计算计划",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalPlanGridView",
            "viewtag": "46cfacbff697ee3aa3704bc44efdb3f3"
        },
        "ormorgsectorpickupview": {
            "title": "部门管理数据选择视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupView",
            "viewtag": "4959432e8ccd53afd9a231dcba7035a5"
        },
        "salstdzyzgeditview": {
            "title": "执业资格津贴标准编辑视图",
            "caption": "执业资格津贴标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdzyzgEditView",
            "viewtag": "51c361a6355fa02f0c659e4616fc63f9"
        },
        "salruledetailgridview": {
            "title": "薪酬规则明细表格视图",
            "caption": "薪酬规则明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalRuleDetailGridView",
            "viewtag": "5605a1ba8ee791fefa7eabbec7b285a0"
        },
        "salplanpickupview": {
            "title": "薪酬计算计划数据选择视图",
            "caption": "薪酬计算计划",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalPlanPickupView",
            "viewtag": "56b0139136984b06b6bddfcc88f4c8b5"
        },
        "salsourcepickupview": {
            "title": "薪酬计算源数据选择视图",
            "caption": "薪酬计算源",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSourcePickupView",
            "viewtag": "58ac9e12f096070e815322949bd7c478"
        },
        "salloggridview": {
            "title": "薪酬调整日志表格视图",
            "caption": "薪酬调整日志",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalLogGridView",
            "viewtag": "591ef016b72d181a6bd6fed984f235a7"
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
        "ormpostpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostPickupView",
            "viewtag": "7ad4a76da72e2f1008df453f9bca4280"
        },
        "salschemeeditview": {
            "title": "薪酬方案编辑视图",
            "caption": "工资单",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeEditView",
            "viewtag": "817ea8d9a018ecf1d3caad347cf1e09f"
        },
        "salsalarydetailgridview": {
            "title": "员工薪酬明细表格视图",
            "caption": "员工薪酬明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSalaryDetailGridView",
            "viewtag": "8211ae61b7d368f63a74af2bc1c38a57"
        },
        "salsalaryeditview": {
            "title": "员工薪酬编辑视图",
            "caption": "员工薪酬",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSalaryEditView",
            "viewtag": "8550c745e3b2fe38208ab9a48ac7ab97"
        },
        "salsalarybillpickupgridview": {
            "title": "工资单选择表格视图",
            "caption": "工资表",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSalaryBillPickupGridView",
            "viewtag": "8eafe3d9252b6c4152ce5f15faef11e9"
        },
        "ormpostpickupgridview": {
            "title": "岗位管理选择表格视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostPickupGridView",
            "viewtag": "94af31faaa7c0dbb621f369e4cfb73fb"
        },
        "salstdzceditview": {
            "title": "职称类别标准编辑视图",
            "caption": "技术津贴标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdzcEditView",
            "viewtag": "98d4615a066ecb708dc968b8dc6fdbec"
        },
        "salstdgwgridview": {
            "title": "高温津贴标准表格视图",
            "caption": "高温津贴标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdgwGridView",
            "viewtag": "9b03c9156c634921bac245a676899e77"
        },
        "salsourceeditview": {
            "title": "薪酬计算源编辑视图",
            "caption": "薪酬计算源",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSourceEditView",
            "viewtag": "a0bfdd5660561dd0f43d46568a486269"
        },
        "salstdzcgridview": {
            "title": "职称类别标准表格视图",
            "caption": "技术津贴标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdzcGridView",
            "viewtag": "a203da68bc71c70f227fe602bfabbd56"
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
        "salpersonstddetaileditview": {
            "title": "员工薪酬标准明细编辑视图",
            "caption": "员工薪酬标准明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SALPERSONSTDDETAILEditView",
            "viewtag": "aeba780ecae8173357248fd20ba7ad9b"
        },
        "salschemegridview": {
            "title": "薪酬方案表格视图",
            "caption": "工资单",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeGridView",
            "viewtag": "b0359cd7880295cf20f26a6de36b5b7d"
        },
        "salstdglgridview": {
            "title": "工龄工资标准表格视图",
            "caption": "工龄工资标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdglGridView",
            "viewtag": "b0d87c562700afae22e6ff83c509c261"
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
        "salpersonstdeditview": {
            "title": "员工薪酬标准编辑视图",
            "caption": "员工薪酬标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalPersonStdEditView",
            "viewtag": "cbdbf28aca33510bd1847738a9a58649"
        },
        "salschemeitemgridview": {
            "title": "方案要素项表格视图",
            "caption": "工资单要素项",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeItemGridView",
            "viewtag": "d0908e8c3011c16569051fa365a3678e"
        },
        "ormorgsectorpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupGridView",
            "viewtag": "d09141f3d44cd13e6fa043871a5278cb"
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
        "pimpersonpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonPickupGridView",
            "viewtag": "d44ef037d312d50fd58de9dec03f4df7"
        },
        "salplaneditview": {
            "title": "薪酬计算计划编辑视图",
            "caption": "薪酬计算计划",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalPlanEditView",
            "viewtag": "d609da2973320af9f65ea17bd06be515"
        },
        "salsalarygridview": {
            "title": "员工薪酬表格视图",
            "caption": "员工薪酬",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSalaryGridView",
            "viewtag": "de531c75dcb9d45eb7cfcaef9faba852"
        },
        "salschemeitemeditview": {
            "title": "方案要素项编辑视图",
            "caption": "工资单要素项",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalSchemeItemEditView",
            "viewtag": "df88a72f2eabeebc4e7f05de730938f2"
        },
        "salstdzyzggridview": {
            "title": "执业资格津贴标准表格视图",
            "caption": "执业资格津贴标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdzyzgGridView",
            "viewtag": "e2a48b9813f6f75da9a600244d3bb362"
        },
        "salpersonstdgridview": {
            "title": "员工薪酬标准表格视图",
            "caption": "员工薪酬标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalPersonStdGridView",
            "viewtag": "e409b21fe364b19d387640a3f72f76c3"
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
        "salstdzxgridview": {
            "title": "专项津贴标准表格视图",
            "caption": "专项津贴标准",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStdzxGridView",
            "viewtag": "f47f878fe543a1755a56a2b9610686f1"
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
        },
        "salpersonstddetailgridview": {
            "title": "员工薪酬标准明细表格视图",
            "caption": "员工薪酬标准明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "SAL",
            "viewname": "SALPERSONSTDDETAILGridView",
            "viewtag": "fa15d184ebbb47458b833c6e7d867e04"
        },
        "salstddszneditview": {
            "title": "独生子女标准编辑视图",
            "caption": "独生子女标准",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "SAL",
            "viewname": "SalStddsznEditView",
            "viewtag": "ffc8d1a046c30170f62bce6f57e5ccdd"
        }
    }];
});