import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "attendancesettingseditview": {
            "title": "考勤人员",
            "caption": "考勤人员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceSettingsEditView",
            "viewtag": "03511dfb145e54bb23246d7f2b417a36"
        },
        "pimpersoncurorgpimpersonpickupview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonCurOrgPimpersonPickupView",
            "viewtag": "0df297d269c07a0970657b7f56adb1ea"
        },
        "attendencesetupcurorgkqszgridview": {
            "title": "考勤设置表格视图",
            "caption": "考勤设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupCurOrgKQSZGridView",
            "viewtag": "0e3c8ea0609ff239614c28a75a94ea87"
        },
        "ormorgjqgzsyfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgJQGZSYFPXXPickupView",
            "viewtag": "106a8c5b57b9dc11b0eaf030ef117458"
        },
        "attendencesetupeditview": {
            "title": "考勤设置编辑视图",
            "caption": "考勤设置",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupEditView",
            "viewtag": "1670d8d1ba576d381e759a1968ca96d9"
        },
        "vacleavetipsqjtsgridview": {
            "title": "请假提示",
            "caption": "请假提示",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveTipsQJTSGridView",
            "viewtag": "1964763f853ddc6c622f5de9e7b36f39"
        },
        "ormorgsectorbmkqszeditview": {
            "title": "部门管理",
            "caption": "部门管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorBMKQSZEditView",
            "viewtag": "402c44c268001c72d0260161d2bece56"
        },
        "vacholidayeditview": {
            "title": "节假日/调休上班",
            "caption": "节假日/调休上班",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayEditView",
            "viewtag": "43382b00685ac886ac519967af516ee9"
        },
        "ormorgjqgzsypickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgJQGZSYPickupGridView",
            "viewtag": "46169808698693a25081ae7671f85f3f"
        },
        "attendancesettingsgridview": {
            "title": "考勤人员",
            "caption": "考勤人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceSettingsGridView",
            "viewtag": "49181fed112a6e7d9c86a8a261583959"
        },
        "index": {
            "title": "EHR-假勤管理",
            "caption": "EHR-假勤管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "ATT",
            "viewname": "Index",
            "viewtag": "55D522D7-A7FF-4A3C-9CD9-67755DF8651C"
        },
        "attendencesetupkqszwizardview": {
            "title": "考勤设置向导视图",
            "caption": "考勤设置向导",
            "viewtype": "DEWIZARDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupKQSZWizardView",
            "viewtag": "74aaa92a32b08041d98ae05afa42f240"
        },
        "attendenceormorgscetorgridview": {
            "title": "考勤部门",
            "caption": "考勤部门",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceOrmorgscetorGridView",
            "viewtag": "8994b647b6c3896f2b2a29a78ffffccb"
        },
        "vacleavetipseditview": {
            "title": "请假提示",
            "caption": "请假提示",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveTipsEditView",
            "viewtag": "89e942db8e2df3e581cee366682d8744"
        },
        "attendenceormorgscetoreditview": {
            "title": "考勤部门编辑视图",
            "caption": "考勤部门",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceOrmorgscetorEditView",
            "viewtag": "8dc4b335c6da32e29f4f6f082d4b2020"
        },
        "attendencesetupkqsztreeexpview": {
            "title": "考勤设置树导航视图",
            "caption": "考勤设置",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupKQSZTreeExpView",
            "viewtag": "8dfb451be615b1dd6bd681453572ee50"
        },
        "ormbmkqdzbmkqdzeditview": {
            "title": "部门考勤地址",
            "caption": "部门考勤地址",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmBmkqdzBMKQDZEditView",
            "viewtag": "910cecd4be4a00aa3750092c57aba072"
        },
        "vacholidayrulescurormorgpickupgridview": {
            "title": "考勤规则",
            "caption": "考勤规则",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayRulesCurOrmorgPickupGridView",
            "viewtag": "94ecb4d9f696cdeb9d6aafb13e04c7a3"
        },
        "vacholidayrulescurormorgpickupview": {
            "title": "考勤规则",
            "caption": "考勤规则",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayRulesCurOrmorgPickupView",
            "viewtag": "a0616d69352ba5fc46e1e359b78a810a"
        },
        "ormorgsectorpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupGridView",
            "viewtag": "a0ab24547d6ad910d03d81a5a6e3f83d"
        },
        "vacholidayjjrtxsbgridview": {
            "title": "节假日/调休上班",
            "caption": "节假日/调休上班",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayJJRTXSBGridView",
            "viewtag": "a6c5ff62b4c8ef40868249987ff31957"
        },
        "vacholidayruleskqgzwizardview": {
            "title": "考勤规则向导",
            "caption": "考勤规则向导",
            "viewtype": "DEWIZARDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayRulesKQGZWizardView",
            "viewtag": "b7c9f4962c358749929067f91d7a09f8"
        },
        "vacholidayruleseditview": {
            "title": "考勤规则",
            "caption": "考勤规则",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayRulesEditView",
            "viewtag": "bc7fada1d639bc3887a156c0b6414daf"
        },
        "ormbmkqdzbmkqdzgridview": {
            "title": "考勤地址信息",
            "caption": "考勤地址信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmBmkqdzBMKQDZGridView",
            "viewtag": "bf16301c592e499ae98c922b6a4b54bd"
        },
        "pimpersoncurorgpimpersonpickupgridview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonCurOrgPimpersonPickupGridView",
            "viewtag": "c26ad79b88eb56eb4d6abba57f3f35d1"
        },
        "vacholidayrulesgridview": {
            "title": "考勤规则",
            "caption": "考勤规则",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayRulesGridView",
            "viewtag": "cfe9d69998fd484c2c7bcb0cd98b60d7"
        },
        "ormorgsectorpickupview": {
            "title": "部门管理数据选择视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupView",
            "viewtag": "d40c4a8cb38f7938d2883e90d53d1d9e"
        }
    }];
});