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
        "ormorgsectormpickupview": {
            "title": "部门管理数据多项选择视图",
            "caption": "部门管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorMPickupView",
            "viewtag": "07d14c54e2627a1b2fbcd2c5773a89d1"
        },
        "attendencesetupkqbypickupview": {
            "title": "考勤设置数据选择视图",
            "caption": "考勤设置",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupKQBYPickupView",
            "viewtag": "08aa713f08b89900801451e961cf368b"
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
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupView",
            "viewtag": "20fc72240f5e586b7cf92ebf229bffd1"
        },
        "attendancesettingsfygzzkqgridview": {
            "title": "非员工终止考勤",
            "caption": "非员工终止考勤",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceSettingsFYGZZKQGridView",
            "viewtag": "21c8d14633617b68f310969a0f6225c6"
        },
        "vacleavedetailsjqjmx_editview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveDetailSJQJMX_EditView",
            "viewtag": "3262fd74050152966a989a7aa4f46db0"
        },
        "vacsynjcxgridview": {
            "title": "年休假查询",
            "caption": "年休假查询",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacSynjcxGridView",
            "viewtag": "332ebe6a595ac81f1e42a327e3c911e1"
        },
        "vacleavedetailjhqjmx_editview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveDetailJHQJMX_EditView",
            "viewtag": "3451991293c2ae164b404d7a256b348e"
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
        "vacleavedetailjhqjmx_gridview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveDetailJHQJMX_GridView",
            "viewtag": "46624dab5e7a5e5026cab5092952f020"
        },
        "attendancesettingsgridview": {
            "title": "考勤人员",
            "caption": "考勤人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceSettingsGridView",
            "viewtag": "49181fed112a6e7d9c86a8a261583959"
        },
        "vacleavedetailsjqjmx_ck_editview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveDetailSJQJMX_CK_EditView",
            "viewtag": "4f0a59a47a9f69d0c45d34c921233032"
        },
        "vacleavedetailsjqjmx_ck_gridview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveDetailSJQJMX_CK_GridView",
            "viewtag": "5504fe93683e145068c188c9e43ccb68"
        },
        "index": {
            "title": "EHR-假勤管理",
            "caption": "EHR-假勤管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "ATT",
            "viewname": "Index",
            "viewtag": "55D522D7-A7FF-4A3C-9CD9-67755DF8651C"
        },
        "attendencetypegridview": {
            "title": "考勤类型表格视图",
            "caption": "考勤类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceTypeGridView",
            "viewtag": "641ae929e09d36459bd7fa494f762d04"
        },
        "attendencesetuppickupgridview": {
            "title": "考勤设置选择表格视图",
            "caption": "考勤设置",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupPickupGridView",
            "viewtag": "64d9c76c20bf971502eb7c8ea1c2d7e2"
        },
        "attensummarycurzzkqhzgridview": {
            "title": "考勤汇总",
            "caption": "考勤汇总",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEnsummaryCurZZKQHZGridView",
            "viewtag": "64d9d612dfb1fcc1a6f5f599e5f62308"
        },
        "vacleavemanagengeditview": {
            "title": "请假管理",
            "caption": "请假管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveManageNGEditView",
            "viewtag": "674c3fe6e36a1eb0f72af7c6a7f76905"
        },
        "attendancemreporteditview": {
            "title": "考勤月报",
            "caption": "考勤月报",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceMreportEditView",
            "viewtag": "6b3008117fb17fb739d7fa3a19cec37b"
        },
        "attendencesetupkqbpickupgridview": {
            "title": "考勤设置选择表格视图",
            "caption": "考勤设置",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupKQBPickupGridView",
            "viewtag": "6f6f4d9860d050ea30424cb66f86d122"
        },
        "attendancemreportmxgridview": {
            "title": "考勤月报明细",
            "caption": "考勤月报明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceMreportmxGridView",
            "viewtag": "729c5fcb6684b43de26f6004de2ae301"
        },
        "attendencesetupkqszwizardview": {
            "title": "考勤设置向导视图",
            "caption": "考勤设置向导",
            "viewtype": "DEWIZARDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupKQSZWizardView",
            "viewtag": "74aaa92a32b08041d98ae05afa42f240"
        },
        "ormbmkqdzpickupview": {
            "title": "部门地址维护数据选择视图",
            "caption": "部门地址维护",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmBmkqdzPickupView",
            "viewtag": "7c54638d1ecf1a6babc60594c0a32e76"
        },
        "pcmwzd0001ygszkqoptionview": {
            "title": "员工设置考勤",
            "caption": "员工设置考勤",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmWzd0001YGSZKQOptionView",
            "viewtag": "7f5fde30882cd704aa8fdaf922c320fa"
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
        "vacleavedetailjhqjmx_ck_gridview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveDetailJHQJMX_CK_GridView",
            "viewtag": "9971376d76b7b06e5a2d38291f7805e6"
        },
        "attendancerecordgridview": {
            "title": "考勤记录表格视图",
            "caption": "考勤记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceRecordGridView",
            "viewtag": "a02235606b74a1e7ea69396bd40e14c8"
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
        "vacleavedetailjhqjmx_ck_editview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveDetailJHQJMX_CK_EditView",
            "viewtag": "a48d109fb3e4e472f9c86c6b12187d51"
        },
        "vacholidayjjrtxsbgridview": {
            "title": "节假日/调休上班",
            "caption": "节假日/调休上班",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayJJRTXSBGridView",
            "viewtag": "a6c5ff62b4c8ef40868249987ff31957"
        },
        "vacleavedetailsjqjmx_gridview": {
            "title": "请假明细",
            "caption": "请假明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveDetailSJQJMX_GridView",
            "viewtag": "a6f62d2019e0803c18258a097fbb4e78"
        },
        "attendancemreportcurzzkqybgridview": {
            "title": "考勤月报",
            "caption": "考勤月报",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceMreportCurZZKQYBGridView",
            "viewtag": "afe13502a4b571a985bd43564512c74f"
        },
        "attendancemreportkqybtreeexpview": {
            "title": "考勤月报树导航视图",
            "caption": "考勤月报",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceMreportKQYBTreeExpView",
            "viewtag": "b3d5e8674764efcf3f73cf0b6292d898"
        },
        "vacholidayruleskqgzwizardview": {
            "title": "考勤规则向导",
            "caption": "考勤规则向导",
            "viewtype": "DEWIZARDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacHolidayRulesKQGZWizardView",
            "viewtag": "b7c9f4962c358749929067f91d7a09f8"
        },
        "vacleavemanagegridview": {
            "title": "请假管理实体表格视图",
            "caption": "请假管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaveManageGridView",
            "viewtag": "bafd71cd0552e86505f6d85e2dbdd9fb"
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
        "vacsynjcxeditview": {
            "title": "年休假查询编辑视图",
            "caption": "年休假查询",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacSynjcxEditView",
            "viewtag": "c1fae59437ec480d0ebf1b6b9f506bfa"
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
        "ormorgsectorcurzzbm_kqszpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorCurZZBM_KQSZPickupGridView",
            "viewtag": "d276e912d89e2e6e7c9595022aa20189"
        },
        "ormorgsectorpickupview": {
            "title": "部门管理数据选择视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupView",
            "viewtag": "d40c4a8cb38f7938d2883e90d53d1d9e"
        },
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupGridView",
            "viewtag": "d6182a52f2ff9bde43a0581a32703944"
        },
        "ormbmkqdzpickupgridview": {
            "title": "部门地址维护选择表格视图",
            "caption": "部门地址维护",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmBmkqdzPickupGridView",
            "viewtag": "d66a73e83c5a991b3b4093216ddbd5c8"
        },
        "pimpersonkqjrypickupview": {
            "title": "选择请假人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonKQJRYPickupView",
            "viewtag": "d79f2dc2901e71fab8d5fb379f562978"
        },
        "attensummarykqhztreeexpview": {
            "title": "考勤汇总树导航视图",
            "caption": "考勤汇总",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEnsummaryKQHZTreeExpView",
            "viewtag": "dd8870fbf7f0b9e6759dcceb4513643b"
        },
        "vacleacetypegridview": {
            "title": "休假类型管理表格视图",
            "caption": "休假类型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaceTypeGridView",
            "viewtag": "e0aef4185645d7c736afe9da6e2de2a7"
        },
        "attendencetypeeditview": {
            "title": "考勤类型编辑视图",
            "caption": "考勤类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceTypeEditView",
            "viewtag": "e1887c627c5d3e6b1a34311ecc990535"
        },
        "vacleacetypeeditview": {
            "title": "休假类型管理编辑视图",
            "caption": "休假类型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "VAC",
            "viewname": "VacLeaceTypeEditView",
            "viewtag": "eccc30f0a682850771495604f591627d"
        },
        "ormorgsectorkqszmpickupview": {
            "title": "部门管理数据多项选择视图",
            "caption": "部门管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorKQSZMPickupView",
            "viewtag": "efb6d23ba2d645798922bd74edd568ce"
        },
        "pimpersonkqjrypickupgridview": {
            "title": "请假人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonKQJRYPickupGridView",
            "viewtag": "efe1396c9bd99b8aebbe7860de45e567"
        },
        "attendancesettingsygszkqgridview": {
            "title": "员工设置考勤",
            "caption": "员工设置考勤",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceSettingsYGSZKQGridView",
            "viewtag": "f1bf8f7a05fdca378d78e966738be76c"
        },
        "attendancemreportmxeditview": {
            "title": "考勤月报明细",
            "caption": "考勤月报明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceMreportmxEditView",
            "viewtag": "f524f181dee3fe0d33a8a85505f92cb9"
        },
        "attendancerecordeditview": {
            "title": "考勤记录编辑视图",
            "caption": "考勤记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceRecordEditView",
            "viewtag": "fc7bc9568af7274927fd65b023da8b19"
        },
        "attendencesetupmpickupview": {
            "title": "考勤设置数据多项选择视图",
            "caption": "考勤设置",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndenceSetupMPickupView",
            "viewtag": "fda0fddd972d90b7d9335a0aa20c6cf4"
        }
    }];
});