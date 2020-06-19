import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "trmtrainplanmpickupview": {
            "title": "培训计划数据多项选择视图",
            "caption": "培训计划",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlanMPickupView",
            "viewtag": "0124e5a1bc5d05baed67f6df4699bd6a"
        },
        "trmtrainactmenteditview": {
            "title": "培训后评估",
            "caption": "培训后评估",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainActmentEditView",
            "viewtag": "036695ba9629677f58b393c821efa987"
        },
        "ormorgsectorpickupview": {
            "title": "部门管理数据选择视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupView",
            "viewtag": "0900822d03fe33229eb42fc1cb6ff15e"
        },
        "trmtrainteacherpickupview": {
            "title": "培训教师数据选择视图",
            "caption": "培训讲师",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainTeacherPickupView",
            "viewtag": "09b3046784a4b36b2a32a1dddf6e007c"
        },
        "ormbmkqdzpickupview": {
            "title": "部门地址维护数据选择视图",
            "caption": "部门地址维护",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmBmkqdzPickupView",
            "viewtag": "09f8e0ec1aa622435843933e1dfbc655"
        },
        "trmcouarrangeeditview": {
            "title": "培训记录",
            "caption": "培训记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCouarrangeEditView",
            "viewtag": "0d7e1adddca040966bf13121406073d3"
        },
        "trmtrainagencyeditview": {
            "title": "培训机构",
            "caption": "培训机构",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAgencyEditView",
            "viewtag": "11da72e188942aaf631c0a7b419499fb"
        },
        "trmtrainbuapplygridview": {
            "title": "培训费用登记",
            "caption": "培训费用登记",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainBuapplyGridView",
            "viewtag": "13ab30b58a970dfc175b42f4e2541915"
        },
        "trmtrainactmentpickupview": {
            "title": "培训活动评估数据选择视图",
            "caption": "培训活动评估",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainActmentPickupView",
            "viewtag": "150ef13af262c2bc3d87269c451b47c5"
        },
        "trmtraincoursepickupgridview": {
            "title": "培训课程选择表格视图",
            "caption": "培训课程",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainCoursePickupGridView",
            "viewtag": "16ffb3a59b57af1d0756bf39b25fe4e1"
        },
        "trmtrainactapplypickupview": {
            "title": "培训活动申请数据选择视图",
            "caption": "培训活动申请",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainActapplyPickupView",
            "viewtag": "181ae435d96c17b08f27f7402a0d33fa"
        },
        "trmcoursesystemgridview": {
            "title": "培训模块",
            "caption": "培训模块",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCourseSystemGridView",
            "viewtag": "18aed033f3c4553b4b65dacabecbb6a9"
        },
        "trmdemdeftiontbfeditview": {
            "title": "培训需求填报明细",
            "caption": "培训需求填报明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDemdeftionTBFEditView",
            "viewtag": "1f036d542e902abffd5a936897c22562"
        },
        "trmtrainpersoneditview": {
            "title": "培训人员编辑视图",
            "caption": "培训记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPersonEditView",
            "viewtag": "1fbe5d102b5d0982c2f4d0cdb3947b60"
        },
        "trmtrafficgridview": {
            "title": "交通信息",
            "caption": "交通信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrafficGridView",
            "viewtag": "20c3bb3b4f9df48eb2ea927228ee14e9"
        },
        "trmtrainteacherwbgridview": {
            "title": "培训教师表格视图",
            "caption": "外部讲师",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainTeacherWBGridView",
            "viewtag": "237730d637e8755dcf7f818998ef97d5"
        },
        "ormorggridview": {
            "title": "组织单元管理",
            "caption": "组织单元管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgGridView",
            "viewtag": "23c39c9890f7caa60c4ea8eaf9cf2e35"
        },
        "trmtrainbuapplyeditview": {
            "title": "培训费用登记",
            "caption": "培训费用登记",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainBuapplyEditView",
            "viewtag": "26a022910b9c4ab43cfd1d38e2f3a4e6"
        },
        "trmtrainteachermpickupview": {
            "title": "培训教师数据多项选择视图",
            "caption": "培训讲师",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainTeacherMPickupView",
            "viewtag": "277a884d8a8623a9f90077ad885b6d0c"
        },
        "trmtrainfillingridview": {
            "title": "培训需求填报",
            "caption": "培训需求填报",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFillinGridView",
            "viewtag": "29b63786f279c189b905d46ff4dfa9b9"
        },
        "trmtrainteachereditview": {
            "title": "培训教师编辑视图",
            "caption": "内部讲师",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainTeacherEditView",
            "viewtag": "2ac332a36c13e59e2a15e4b86b0feea1"
        },
        "ormorgsjorgpickupview": {
            "title": "上级组织选择视图",
            "caption": "上级组织选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgSJOrgPickupView",
            "viewtag": "2e837b0e5fa89b2dc2608125b8b3852e"
        },
        "trmstaygridview": {
            "title": "培训住宿",
            "caption": "培训住宿",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmStayGridView",
            "viewtag": "30c34b1211a700dd244b47af6ab67002"
        },
        "trmdepartxqhzgridview": {
            "title": "需求填报明细",
            "caption": "需求填报明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDepartXQHZGridView",
            "viewtag": "30f91178ca5210e97370ff71768717d7"
        },
        "trmcoursesystemwmxgridview": {
            "title": "课程体系表格视图",
            "caption": "培训模块",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCourseSystemWMXGridView",
            "viewtag": "31455abfde9592048b2a5f662e61fd5f"
        },
        "trmstayeditview": {
            "title": "培训住宿",
            "caption": "培训住宿",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmStayEditView",
            "viewtag": "35c5d003a2e5573fdf3a5f4de80db878"
        },
        "trmdemdeftionpickupview": {
            "title": "培训需求",
            "caption": "培训需求",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDemdeftionPickupView",
            "viewtag": "36ab48e3ff0b61d2c676d8b76dfca9d5"
        },
        "trmtrainoutapplypickupview": {
            "title": "外部培训申请数据选择视图",
            "caption": "外部培训申请",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainOutApplyPickupView",
            "viewtag": "370ca17609ec8fd7060b5f7b0efff2d7"
        },
        "trmcoursesystemwmxeditview": {
            "title": "培训模块编辑视图",
            "caption": "培训模块",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCourseSystemWMXEditView",
            "viewtag": "37eab1c8843eb9f0d28e3eb8d5432613"
        },
        "trmtraincourseeditview9": {
            "title": "培训课程",
            "caption": "培训课程",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "TRM",
            "viewname": "TrmTrainCourseEditView9",
            "viewtag": "39a7c86e53e95b11e14dd5c92b0083a8"
        },
        "attendancerecordeditview": {
            "title": "考勤记录编辑视图",
            "caption": "考勤记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceRecordEditView",
            "viewtag": "3e14b1a02b1fc2d309850243aa162a92"
        },
        "trmtrainagencypickupgridview": {
            "title": "培训机构选择表格视图",
            "caption": "培训机构",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAgencyPickupGridView",
            "viewtag": "3f8c32889986ffdc4a90d93df2ec744d"
        },
        "trmcouarrangegridview": {
            "title": "课程安排表格视图",
            "caption": "培训记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCouarrangeGridView",
            "viewtag": "425b1c2c7a6ec8ae771c7cec835d767c"
        },
        "trmteacherchargempickupview": {
            "title": "讲师收费记录数据多项选择视图",
            "caption": "讲师收费记录",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTeacherChargeMPickupView",
            "viewtag": "4260d887819e58771461fd4adefa60e6"
        },
        "trmtraincoursegridview": {
            "title": "培训课程",
            "caption": "培训课程",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainCourseGridView",
            "viewtag": "439d470930ee9b3ab1812f825de08c5b"
        },
        "ormerporglegalmpickupview": {
            "title": "管理单位",
            "caption": "管理单位",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmErporgLegalMPickupView",
            "viewtag": "44ff5e2a4abf42ed27a35a139a57836e"
        },
        "trmplanformupickupgridview": {
            "title": "培训计划制定选择表格视图",
            "caption": "培训计划制定",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmPlanFormuPickupGridView",
            "viewtag": "47449b481cca462665f5b419310f5362"
        },
        "trmtrainagencympickupview": {
            "title": "培训机构数据多项选择视图",
            "caption": "培训机构",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAgencyMPickupView",
            "viewtag": "47480ee6de2d80a1ddcca1b18bff6f1c"
        },
        "trmdepartpickupview": {
            "title": "部门需求填报数据选择视图",
            "caption": "培训需求通知",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDepartPickupView",
            "viewtag": "48f643f336298e3dd7d0764bcbf65c04"
        },
        "trmdemdeftionpickupgridview": {
            "title": "培训需求",
            "caption": "培训需求",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDemdeftionPickupGridView",
            "viewtag": "4ac2ba2b52669a4141b96305ac90ee68"
        },
        "trmtrainplanpickupgridview": {
            "title": "培训计划选择表格视图",
            "caption": "培训计划",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlanPickupGridView",
            "viewtag": "4ba1031569be407b55a2669c731f641e"
        },
        "trmdepartxqhzeditview": {
            "title": "需求汇总",
            "caption": "需求汇总",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDepartXQHZEditView",
            "viewtag": "4e408f2e2bc30654e0339ed8fd100baa"
        },
        "pimpersoncurorgpimpersonpickupview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonCurOrgPimpersonPickupView",
            "viewtag": "4fc31de04cbd654cd0a94e22dec55316"
        },
        "trmtrainactapplypickupgridview": {
            "title": "培训活动申请选择表格视图",
            "caption": "培训活动申请",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainActapplyPickupGridView",
            "viewtag": "564e30f921cb26d373ba8c56b68c0344"
        },
        "trmtrainaddresspickupview": {
            "title": "培训地点数据选择视图",
            "caption": "培训场地",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAddressPickupView",
            "viewtag": "5942169579c944d47bed377e6de21a30"
        },
        "trmdemdeftiontbgridview": {
            "title": "培训需求填报明细",
            "caption": "培训需求填报明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDemdeftionTBGridView",
            "viewtag": "596a77856f436c4621e10d8801e93ffd"
        },
        "trmstaympickupview": {
            "title": "培训住宿数据多项选择视图",
            "caption": "培训住宿",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmStayMPickupView",
            "viewtag": "5a7107895d9b66ab8b78d13df1f225e5"
        },
        "trmtraincourseeditview": {
            "title": "培训课程",
            "caption": "培训课程",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainCourseEditView",
            "viewtag": "5da46cd39cd211b4bbd298b79a892206"
        },
        "trmhmatsereditview": {
            "title": "班主任编辑视图",
            "caption": "班主任",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmHmatserEditView",
            "viewtag": "5f5d8eb214a4b5f0007d6b3c7cfd62c7"
        },
        "trmcoursesystempickupgridview": {
            "title": "课程体系选择表格视图",
            "caption": "培训模块",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCourseSystemPickupGridView",
            "viewtag": "61466c9a5dfbfc985e71c00385c15c8f"
        },
        "trmdepartpickupgridview": {
            "title": "部门需求填报选择表格视图",
            "caption": "培训需求通知",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDepartPickupGridView",
            "viewtag": "61c75a7f1080f753ff1e1a66b5eacc1e"
        },
        "trmtraincoursepickupview": {
            "title": "培训课程数据选择视图",
            "caption": "培训课程",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainCoursePickupView",
            "viewtag": "6498423afbd731a15e34492244be55d8"
        },
        "trmtrafficeditview": {
            "title": "交通信息",
            "caption": "交通信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrafficEditView",
            "viewtag": "6671516ef97db2ac9f51ed49aac65fca"
        },
        "trmcouarrangepxjggridview": {
            "title": "课程安排表格视图",
            "caption": "培训记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCouarrangePXJGGridView",
            "viewtag": "66b1d12b94f0b14bf0f9c2f715511171"
        },
        "trmtrainagencyeditview9": {
            "title": "培训机构编辑视图",
            "caption": "机构信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAgencyEditView9",
            "viewtag": "693a64777bc436f97363770cc82631c0"
        },
        "trmstaypickupview": {
            "title": "培训住宿数据选择视图",
            "caption": "培训住宿",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmStayPickupView",
            "viewtag": "7199de1f8082e31ced022faffb5d5244"
        },
        "trmplanformumpickupview": {
            "title": "培训计划制定数据多项选择视图",
            "caption": "培训计划制定",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmPlanFormuMPickupView",
            "viewtag": "73b57038b1d13225f353de917d9225fb"
        },
        "trmtrainactmentmpickupview": {
            "title": "培训活动评估数据多项选择视图",
            "caption": "培训活动评估",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainActmentMPickupView",
            "viewtag": "7611863bd6a1d9986cecefb55a6435f8"
        },
        "pimpersonpickupview": {
            "title": "人员信息数据选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonPickupView",
            "viewtag": "768cea21276a67cf21ea1448b8e0a9ea"
        },
        "trmtrainplanfeditview": {
            "title": "培训计划",
            "caption": "培训计划",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlanFEditView",
            "viewtag": "7a5c10aaa9007b51db506977145e81b6"
        },
        "trmteachertraineditview": {
            "title": "讲师授课记录编辑视图",
            "caption": "讲师授课记录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTeacherTrainEditView",
            "viewtag": "7baa86a07ab62567f156a016800616ac"
        },
        "trmtrainoutapplyeditview": {
            "title": "外出培训申请",
            "caption": "外出培训申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainOutApplyEditView",
            "viewtag": "7ced529233ba55f309f9044e58e48c14"
        },
        "trmplanformugridview": {
            "title": "计划制定",
            "caption": "计划制定",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmPlanFormuGridView",
            "viewtag": "7e9b2f1f660097c455a7ac222609ee63"
        },
        "trmtrainplanfgridview": {
            "title": "计划审批",
            "caption": "计划审批",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlanFGridView",
            "viewtag": "7f581c31adcf1941579ec1bc7eb6b73f"
        },
        "ormorgeditview": {
            "title": "组织信息",
            "caption": "组织信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgEditView",
            "viewtag": "807df9111b4aa66645b149cbebbf33bc"
        },
        "trmdepartmpickupview": {
            "title": "部门需求填报数据多项选择视图",
            "caption": "培训需求通知",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDepartMPickupView",
            "viewtag": "83061502b2224775710aa0509d7e6830"
        },
        "trmhmatserpickupgridview": {
            "title": "班主任选择表格视图",
            "caption": "班主任",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmHmatserPickupGridView",
            "viewtag": "84376a56a4ad11f5bd89fe161fb8d6ff"
        },
        "trmcoursesystemeditview9": {
            "title": "培训模块",
            "caption": "培训模块",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "TRM",
            "viewname": "TrmCourseSystemEditView9",
            "viewtag": "878c6aa215b91f624102716b96aa8a7d"
        },
        "trmdeparteditview": {
            "title": "需求通知",
            "caption": "需求通知",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDepartEditView",
            "viewtag": "886c4bcfa01e0ddccae03a6d05de3443"
        },
        "trmtrainteacherwbeditview": {
            "title": "培训教师编辑视图",
            "caption": "外部讲师",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainTeacherWBEditView",
            "viewtag": "8917862c6bb0ddca9dadac23d1214b89"
        },
        "trmtrainbuapplypickupview": {
            "title": "培训预算申请数据选择视图",
            "caption": "教育经费",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainBuapplyPickupView",
            "viewtag": "8aa90c3786ae31e4cc4143b70dac3934"
        },
        "trmteacherchargepickupgridview": {
            "title": "讲师收费记录选择表格视图",
            "caption": "讲师收费记录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTeacherChargePickupGridView",
            "viewtag": "8c4f2e9634ba8d210e485ddcf6affb32"
        },
        "trmteacherchargepickupview": {
            "title": "讲师收费记录数据选择视图",
            "caption": "讲师收费记录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTeacherChargePickupView",
            "viewtag": "8e4e6a5c966b7ba6e5e269cf04aee068"
        },
        "trmtrainbuapplypickupgridview": {
            "title": "培训预算申请选择表格视图",
            "caption": "教育经费",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainBuapplyPickupGridView",
            "viewtag": "928372d62fe288d0ed36f4ce6e5608c6"
        },
        "trmtrainaddressgridview": {
            "title": "培训场地表格视图",
            "caption": "培训场地",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAddressGridView",
            "viewtag": "931c3b21c30c786bcc9d2a7155999467"
        },
        "trmteacherchargeeditview": {
            "title": "讲师费用台账",
            "caption": "讲师费用台账",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTeacherChargeEditView",
            "viewtag": "96a747b7f18e02a93b85f9c408e74db8"
        },
        "trmtraincoursempickupview": {
            "title": "培训课程数据多项选择视图",
            "caption": "培训课程",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainCourseMPickupView",
            "viewtag": "9b4c417969ac98e3b4548c1876608965"
        },
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupView",
            "viewtag": "9fe562265b37611be2479c3426af87b1"
        },
        "ormorgsectorpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupGridView",
            "viewtag": "a0e2348d960a99edbf7133c22c2fdba7"
        },
        "trmplanformupickupview": {
            "title": "培训计划制定数据选择视图",
            "caption": "培训计划制定",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmPlanFormuPickupView",
            "viewtag": "a140657b6a8d195f9978f10ac474c93c"
        },
        "trmtrainbuapplympickupview": {
            "title": "培训预算申请数据多项选择视图",
            "caption": "教育经费",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainBuapplyMPickupView",
            "viewtag": "a14907ba58995639a039e1bd208d1d0e"
        },
        "index": {
            "title": "EHR—培训管理",
            "caption": "EHR—培训管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "TRM",
            "viewname": "Index",
            "viewtag": "A43D4D65-9C2F-4F50-8B47-3BDE94B4C3D2"
        },
        "trmtrainplangridview": {
            "title": "培训计划详情",
            "caption": "培训计划详情",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlanGridView",
            "viewtag": "aa573e0d521ff8a53584ca166ed04459"
        },
        "ormbmkqdzpickupgridview": {
            "title": "部门地址维护选择表格视图",
            "caption": "部门地址维护",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmBmkqdzPickupGridView",
            "viewtag": "ab093791484a85ac0c13bf1d6d1c7e9e"
        },
        "trmtrainoutapplypickupgridview": {
            "title": "外部培训申请选择表格视图",
            "caption": "外部培训申请",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainOutApplyPickupGridView",
            "viewtag": "b1ff4bbb9a37733f9f9ad5a1d3bd0f65"
        },
        "trmtrainplanpickupview": {
            "title": "培训计划数据选择视图",
            "caption": "培训计划",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlanPickupView",
            "viewtag": "b32c38521d036421cc952cd3a0015225"
        },
        "pimpersonpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonPickupGridView",
            "viewtag": "b608c911a87cbc6a750bc2b0b7e3c744"
        },
        "trmstaypickupgridview": {
            "title": "培训住宿选择表格视图",
            "caption": "培训住宿",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmStayPickupGridView",
            "viewtag": "b6a68353416869b1e555ab6e9d57bfd3"
        },
        "trmcoursesystemeditview": {
            "title": "培训模块",
            "caption": "培训模块",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCourseSystemEditView",
            "viewtag": "b9321a1576cd05e3812617ab7be36a49"
        },
        "trmtrainaddressmpickupview": {
            "title": "培训地点数据多项选择视图",
            "caption": "培训场地",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAddressMPickupView",
            "viewtag": "b932b6f17be101715d4183be2f9e3ba6"
        },
        "trmtrainfaciesgridview": {
            "title": "培训设施表格视图",
            "caption": "培训设施",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFaciesGridView",
            "viewtag": "b9b3c179a3aefeee643255a87c1febca"
        },
        "trmtrainactmentgridview": {
            "title": "培训后评估表格视图",
            "caption": "培训后评估",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainActmentGridView",
            "viewtag": "be9ab607e77dc2cee8e397ecffa3f68a"
        },
        "trmteacherchargegridview": {
            "title": "讲师费用台账",
            "caption": "讲师费用台账",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTeacherChargeGridView",
            "viewtag": "bfd1741ff8c1a4b95d4bf5bb472958b3"
        },
        "trmplanformueditview": {
            "title": "培训计划",
            "caption": "培训计划",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmPlanFormuEditView",
            "viewtag": "c10bb20833ac45e4e058f1378519fae9"
        },
        "trmtrainplantermeditview": {
            "title": "立项信息",
            "caption": "立项信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlantermEditView",
            "viewtag": "c3b9410d4d4fefd15cbba991e96d8171"
        },
        "ormorgsectormpickupview": {
            "title": "部门管理数据多项选择视图",
            "caption": "部门管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorMPickupView",
            "viewtag": "c41d2861ba450b7fcd675bcd0ba8e46f"
        },
        "ormorgsjorgpickupgridview": {
            "title": "上级组织选择视图",
            "caption": "上级组织选择视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgSJOrgPickupGridView",
            "viewtag": "c4e5e876db9b32a639b21e8de18a798f"
        },
        "trmtrainplantermeditview9": {
            "title": "立项信息",
            "caption": "立项信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlantermEditView9",
            "viewtag": "c6f04a3d9e731f216ad501351984984d"
        },
        "trmtrainteacherpickupgridview": {
            "title": "培训教师选择表格视图",
            "caption": "培训讲师",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainTeacherPickupGridView",
            "viewtag": "c7fa47fb70347c041eb3e03b898497fe"
        },
        "trmtrainplaneditview": {
            "title": "培训计划详情",
            "caption": "培训计划详情",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlanEditView",
            "viewtag": "c8ca73a29695c2118a0cc73b299741b3"
        },
        "trmdepartgridview": {
            "title": "需求通知",
            "caption": "需求通知",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDepartGridView",
            "viewtag": "ca1b25c9665b2ff5a948e406387c7463"
        },
        "trmhmatsergridview": {
            "title": "班主任表格视图",
            "caption": "班主任",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmHmatserGridView",
            "viewtag": "cd1674f862673877db7b42eb8a52eb4e"
        },
        "trmdemdeftiontzgridview": {
            "title": "培训需求汇总表格视图",
            "caption": "培训需求汇总",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDemdeftionTZGridView",
            "viewtag": "cf8df35bf156dddc93a1d400881f1fbe"
        },
        "trmtrainfillinfeditview": {
            "title": "需求填报填报编辑视图",
            "caption": "培训需求填报",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFillinFEditView",
            "viewtag": "d00a272b09451fd2ad8c74b7af02a61b"
        },
        "trmtrainfacieseditview": {
            "title": "培训设施",
            "caption": "培训设施",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFaciesEditView",
            "viewtag": "d168ccad822c9f9786218b2fe0e450ac"
        },
        "trmtrainagencygridview": {
            "title": "培训机构",
            "caption": "培训机构",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAgencyGridView",
            "viewtag": "d303d92880e30af678c2535bd131bae3"
        },
        "attendancerecordgridview": {
            "title": "考勤记录表格视图",
            "caption": "考勤记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ATT",
            "viewname": "AttEndanceRecordGridView",
            "viewtag": "d3425907903ff37be55b4d1636c2c6b0"
        },
        "trmtrainagencypickupview": {
            "title": "培训机构数据选择视图",
            "caption": "培训机构",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAgencyPickupView",
            "viewtag": "d44f8f7d7a1c369954fa0d196b28c1cc"
        },
        "trmtrainfillinfgridview": {
            "title": "需求填报表格视图",
            "caption": "培训需求填报",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFillinFGridView",
            "viewtag": "d455ee8a7d23097400276217a47e5590"
        },
        "trmtrainpersongridview": {
            "title": "培训记录表格视图",
            "caption": "培训记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPersonGridView",
            "viewtag": "d5816ab80e805f256fb89aadeb53c178"
        },
        "trmtrainfillinpickupgridview": {
            "title": "培训项目部门填报选择表格视图",
            "caption": "培训需求填报",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFillinPickupGridView",
            "viewtag": "d855d8e60cf3778a2bc126e34888039a"
        },
        "trmtrainaddresspickupgridview": {
            "title": "培训地点选择表格视图",
            "caption": "培训场地",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAddressPickupGridView",
            "viewtag": "d8a56178eb357cf700152e728f51ea59"
        },
        "trmtrainteachergridview": {
            "title": "培训教师表格视图",
            "caption": "内部讲师",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainTeacherGridView",
            "viewtag": "d8a8db81cf25380e25c3f8c4c90d7498"
        },
        "trmdemdeftiontzfeditview": {
            "title": "需求汇总",
            "caption": "需求汇总",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmDemdeftionTZFEditView",
            "viewtag": "e0151a24626d40ca84af6810b41bdd53"
        },
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgPickupGridView",
            "viewtag": "e01a4d8803e38d1a2003156855492757"
        },
        "trmcoursesystemmpickupview": {
            "title": "课程体系数据多项选择视图",
            "caption": "培训模块",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCourseSystemMPickupView",
            "viewtag": "e034c6c5752a1ed214cf88a568d623fa"
        },
        "trmhmatsermpickupview": {
            "title": "班主任数据多项选择视图",
            "caption": "班主任",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmHmatserMPickupView",
            "viewtag": "e0da8d83313b44899a3f9dde3b909571"
        },
        "trmtrainplantermgridview": {
            "title": "培训立项",
            "caption": "培训立项",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlantermGridView",
            "viewtag": "e126cfd8fd9979f69c682f044ebac3de"
        },
        "trmteachertraingridview": {
            "title": "讲师授课记录表格视图",
            "caption": "讲师授课记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTeacherTrainGridView",
            "viewtag": "e2b7f1016363a6dff46ca882b8a46b62"
        },
        "trmtrainagencytabexpview": {
            "title": "培训机构相关",
            "caption": "培训机构相关",
            "viewtype": "DETABEXPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAgencyTabExpView",
            "viewtag": "e3e00a371d740be659600f4165e2d737"
        },
        "trmtrainplantermpickupgridview": {
            "title": "培训立项选择表格视图",
            "caption": "培训立项",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlantermPickupGridView",
            "viewtag": "e8b3d2db14338004052e6dea275f77a7"
        },
        "trmtrainplanjhfbgridview": {
            "title": "计划发布",
            "caption": "计划发布",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlanJHFBGridView",
            "viewtag": "ea64c9b3df245c163363aca2e295c255"
        },
        "trmtrainoutapplympickupview": {
            "title": "外部培训申请数据多项选择视图",
            "caption": "外部培训申请",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainOutApplyMPickupView",
            "viewtag": "ecb9a35acdeb07873c633b5b6ea16c17"
        },
        "trmtrainactmentpickupgridview": {
            "title": "培训活动评估选择表格视图",
            "caption": "培训活动评估",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainActmentPickupGridView",
            "viewtag": "efdd682414339b08589728cb2086762f"
        },
        "pimpersoncurorgpimpersonpickupgridview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonCurOrgPimpersonPickupGridView",
            "viewtag": "f479b3f3012f3e454d9420e711115749"
        },
        "trmtrainfillinpickupview": {
            "title": "培训项目部门填报数据选择视图",
            "caption": "培训需求填报",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFillinPickupView",
            "viewtag": "f4a630eb9b113752091f1a3ec27d0645"
        },
        "ormerporglegalpickupgridview": {
            "title": "管理单位",
            "caption": "管理单位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmErporgLegalPickupGridView",
            "viewtag": "f92032a0cb2fd4616195180160939e2e"
        },
        "trmtrainoutapplygridview": {
            "title": "外出培训申请",
            "caption": "外出培训申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainOutApplyGridView",
            "viewtag": "fb3571753a496236f254caebf9095d0d"
        },
        "trmcoursesystempickupview": {
            "title": "课程体系数据选择视图",
            "caption": "培训模块",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmCourseSystemPickupView",
            "viewtag": "fbf4a99e0789e008c06c97d2d9c872ef"
        },
        "trmtrainaddresseditview": {
            "title": "培训场地",
            "caption": "培训场地",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainAddressEditView",
            "viewtag": "fd64380e656f7ce1b3aa3968dbc60745"
        },
        "trmtrainplantermbjgridview": {
            "title": "培训开班",
            "caption": "培训开班",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlantermBJGridView",
            "viewtag": "fd6f768022331e805d7c95abaa97f185"
        },
        "trmtrainfillineditview": {
            "title": "培训需求填报",
            "caption": "培训需求填报",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFillinEditView",
            "viewtag": "fe79122aaa4dcd03af7c5dfe7982e01f"
        },
        "trmtrainfillinmpickupview": {
            "title": "培训项目部门填报数据多项选择视图",
            "caption": "培训需求填报",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainFillinMPickupView",
            "viewtag": "fe888d1e87bcc324182ad773c1dc063c"
        },
        "trmtrainplantermpickupview": {
            "title": "培训立项数据选择视图",
            "caption": "培训立项",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlantermPickupView",
            "viewtag": "feec8f4be9a41b3097708bb7eb973704"
        },
        "trmtrainplantermmpickupview": {
            "title": "培训立项数据多项选择视图",
            "caption": "培训立项",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "TRM",
            "viewname": "TrmTrainPlantermMPickupView",
            "viewtag": "ff53026daea2a2fb4b3ffa28e6e2cfff"
        }
    }];
});