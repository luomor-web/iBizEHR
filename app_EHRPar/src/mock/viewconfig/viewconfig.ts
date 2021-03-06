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
        "parintegralruleeditview": {
            "title": "积分规则",
            "caption": "积分规则",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParIntegralRuleEditView",
            "viewtag": "02139952c2ac2e90cbc2d5712c5ded50"
        },
        "parexamcyclepickupview": {
            "title": "考核周期数据选择视图",
            "caption": "考核周期",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCyclePickupView",
            "viewtag": "057fd0a13dc6d8415557b4c0c01ec673"
        },
        "parkhzcmxpickupgridview": {
            "title": "考核组成明细选择表格视图",
            "caption": "考核模板明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhzcmxPickupGridView",
            "viewtag": "0587c03dd8511394456567f75983d68d"
        },
        "parjxjgeditview": {
            "title": "绩效结果编辑视图",
            "caption": "绩效结果",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxjgEditView",
            "viewtag": "05888e4abd44fea4605d6f22c87eb807"
        },
        "pardjbzgridview": {
            "title": "定级标准表格视图",
            "caption": "定级规则",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParDjbzGridView",
            "viewtag": "05d680ece1a89f0182d7aeedeb99c142"
        },
        "parldndlhmbmxmpickupview": {
            "title": "量化目标明细（公司领导类）数据多项选择视图",
            "caption": "年度量化目标明细（公司领导类 ）",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxMPickupView",
            "viewtag": "0d382b04316ae1a40e71d2c35387a0b0"
        },
        "parldkhqzpickupgridview": {
            "title": "评分权重分配选择表格视图",
            "caption": "评分权重分配",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdkhqzPickupGridView",
            "viewtag": "0d56e2cc3a281e2ee9e7724380b870f0"
        },
        "parldndlhmbmxxzeditview": {
            "title": "量化目标明细修正",
            "caption": "量化目标明细修正",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxXZEditView",
            "viewtag": "1019987ec0798eac9458f35c42ce663d"
        },
        "parldndlhmbmxpickupview": {
            "title": "量化目标明细（公司领导类 ）数据选择视图",
            "caption": "年度量化目标明细（公司领导类 ）",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxPickupView",
            "viewtag": "10a541c6abb24b54d0e89c494a7390aa"
        },
        "parjxjgjxpgdjgridview": {
            "title": "绩效评估定级",
            "caption": "绩效评估定级",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxjgJXPGDJGridView",
            "viewtag": "11beb7ce619d4fa3c5286eba91be6d7a"
        },
        "parldkhqzgridview": {
            "title": "评分权重分配表格视图",
            "caption": "评分权重分配",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdkhqzGridView",
            "viewtag": "11e69b35ff04251d7f8e7295a1d63f06"
        },
        "parldndlhmbmxeditview": {
            "title": "量化目标明细（公司领导类 ）",
            "caption": "量化目标明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxEditView",
            "viewtag": "17647fd91026d622fb7e3b49eeeea019"
        },
        "parintegralrulegridview": {
            "title": "积分规则",
            "caption": "积分规则",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParIntegralRuleGridView",
            "viewtag": "188a0a8121edcb88a352a84cf562aa58"
        },
        "parldkhqzmpickupview": {
            "title": "评分权重分配数据多项选择视图",
            "caption": "评分权重分配",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdkhqzMPickupView",
            "viewtag": "1bcb8281ad1a500b56639ce7f6487845"
        },
        "parjxjgeditview2": {
            "title": "绩效结果编辑视图",
            "caption": "绩效结果",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParJxjgEditView2",
            "viewtag": "1d25ec98327f6665fff2fce37634c3bb"
        },
        "parintegralrulepickupview": {
            "title": "积分规则数据选择视图",
            "caption": "积分规则",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParIntegralRulePickupView",
            "viewtag": "23351fc51755a7fdc1a7778e00843604"
        },
        "parassesstemplatempickupview": {
            "title": "考核模板数据多项选择视图",
            "caption": "考核模板",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParAssessTemplateMPickupView",
            "viewtag": "239f64fe862525f2729a4b0ba52d05c5"
        },
        "parexamcyclegridview": {
            "title": "考核周期",
            "caption": "考核周期",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCycleGridView",
            "viewtag": "25a6fb2dc9f85ee002bcbeca2f1a8205"
        },
        "parkhfagridview": {
            "title": "考核对象",
            "caption": "考核对象",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhfaGridView",
            "viewtag": "2698c6c20aa3e029be5d7b71d05d529d"
        },
        "parassesstemplateeditview": {
            "title": "考核模板",
            "caption": "考核模板",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParAssessTemplateEditView",
            "viewtag": "29840f97ec229cf7c791378d26d3b4d0"
        },
        "parjxkhxhzygkhxgridview": {
            "title": "考核方案",
            "caption": "考核方案",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxkhxhzYGKHXGridView",
            "viewtag": "2c011a5df68fea9e14fd6dd50a31b3da"
        },
        "parkhfaeditview9": {
            "title": "考核对象",
            "caption": "考核对象",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PAR",
            "viewname": "ParKhfaEditView9",
            "viewtag": "2cafcda71b14acdc7fbdd67a627f826f"
        },
        "parjxjgpickupview": {
            "title": "绩效结果数据选择视图",
            "caption": "绩效结果",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxjgPickupView",
            "viewtag": "2d530e290e2578a430149e92621edbb1"
        },
        "parldndlhmbmxkheditview": {
            "title": "量化目标明细考核",
            "caption": "量化目标明细考核",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxKHEditView",
            "viewtag": "321a2c02eb80f38bde111ba6ceeda15d"
        },
        "parldndlhmbndlhmbxzgridview": {
            "title": "量化目标修正",
            "caption": "量化目标修正",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbNDLHMBXZGridView",
            "viewtag": "35977acfc0970b347cace0a7d8ccfac5"
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
        "parexamcontentpickupview": {
            "title": "考核内容数据选择视图",
            "caption": "考核内容",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamContentPickupView",
            "viewtag": "4d97fd1cac21c2f95392dd98af103a23"
        },
        "parldndlhmbkhgridview": {
            "title": "年度量化目标考核（公司领导类）",
            "caption": "年度量化目标考核",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbKHGridView",
            "viewtag": "51460be10bc6dc74ec79e53ae545e1c7"
        },
        "parintegralrulempickupview": {
            "title": "积分规则数据多项选择视图",
            "caption": "积分规则",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParIntegralRuleMPickupView",
            "viewtag": "51cc579031d8c7ec91f924af7ca9e32b"
        },
        "parintegralruleeditview9": {
            "title": "积分规则",
            "caption": "积分规则",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PAR",
            "viewname": "ParIntegralRuleEditView9",
            "viewtag": "5367978cf366f005827916576e777686"
        },
        "pardjbzeditview": {
            "title": "定级标准编辑视图",
            "caption": "定级规则",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParDjbzEditView",
            "viewtag": "57f491ddd74f688d3d407010c2c21869"
        },
        "parintegralruleeditview2": {
            "title": "积分规则编辑视图",
            "caption": "积分规则",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParIntegralRuleEditView2",
            "viewtag": "5c54c01bf48769338bb7134b7d0bf089"
        },
        "parkhzcmxgridview": {
            "title": "考核模板明细",
            "caption": "考核模板明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhzcmxGridView",
            "viewtag": "63b45d0d28eff091f82699780bda4b6b"
        },
        "pimpersonpickupview": {
            "title": "人员信息数据选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonPickupView",
            "viewtag": "64e14790f02145378336091f8f95421e"
        },
        "partzggeditview2": {
            "title": "通知公告编辑视图",
            "caption": "通知发布",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParTzggEditView2",
            "viewtag": "6633c1c5f36292278b6d17b103d0d4fa"
        },
        "parldkhqzeditview": {
            "title": "评分权重分配",
            "caption": "评分权重分配",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdkhqzEditView",
            "viewtag": "663fc0adb5dc1b0c3d92e2bdeb30c163"
        },
        "parldndlhmbeditview2": {
            "title": "年度量化目标编辑视图",
            "caption": "年度量化目标（公司领导类）",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbEditView2",
            "viewtag": "6a111cee676fd5fb8c00ddee952e6357"
        },
        "parassesstemplatepickupview": {
            "title": "考核模板数据选择视图",
            "caption": "考核模板",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParAssessTemplatePickupView",
            "viewtag": "6ab6caf3a12b7882065cc3c605659a79"
        },
        "parjxkhxhzgridview": {
            "title": "考核方案",
            "caption": "考核方案",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxkhxhzGridView",
            "viewtag": "6cd1c6cba20f46286bfbfc22377ead00"
        },
        "parldndlhmbmxgridview": {
            "title": "量化目标明细（公司领导类 ）",
            "caption": "量化目标明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxGridView",
            "viewtag": "6dfdcefce006ad3505558f3babcddcde"
        },
        "parldndlhmbmxkhgridview": {
            "title": "量化目标明细考核",
            "caption": "量化目标明细考核",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxKHGridView",
            "viewtag": "6f8eeee8930cde732f5ea274a3ca1dbc"
        },
        "parldndlhmbmxpickupgridview": {
            "title": "量化目标明细（公司领导类 ）选择表格视图",
            "caption": "年度量化目标明细（公司领导类 ）",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxPickupGridView",
            "viewtag": "710e63110ad2c54dd6bd60be979110cc"
        },
        "parldndlhmbmxxzgridview": {
            "title": "量化目标明细修正",
            "caption": "量化目标明细修正",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxXZGridView",
            "viewtag": "71d989522622828ecb9109e34f8d7af5"
        },
        "parexamcontentpickupgridview": {
            "title": "考核内容选择表格视图",
            "caption": "考核内容",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamContentPickupGridView",
            "viewtag": "74382e16e0e984fd5af452531de035aa"
        },
        "parldkhqznewgridview": {
            "title": "评分权重分配表格视图",
            "caption": "评分权重设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdkhqzNewGridView",
            "viewtag": "7f59f30064383fc5ee87bcdf3bc42f9b"
        },
        "parexamcontentgridview": {
            "title": "考核内容",
            "caption": "考核内容",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamContentGridView",
            "viewtag": "86536dfe782911ef08becd8d6bf5b175"
        },
        "parkhfapickupgridview": {
            "title": "考核对象选择表格视图",
            "caption": "考核对象",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhfaPickupGridView",
            "viewtag": "8910086550a4f072fa19ce3ff7478e0e"
        },
        "parintegralrulepickupgridview": {
            "title": "积分规则选择表格视图",
            "caption": "积分规则",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParIntegralRulePickupGridView",
            "viewtag": "8bc55512c2892b095a741fa52c5d0e29"
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
        "parjxkhxhzygkhxeditview": {
            "title": "考核方案",
            "caption": "考核方案",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxkhxhzYGKHXEditView",
            "viewtag": "94611ef3a4827e95f4bea2199ed9b4a2"
        },
        "parexamcontenteditview2": {
            "title": "考核内容编辑视图",
            "caption": "考核内容",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParExamContentEditView2",
            "viewtag": "955d8d1d2679d84e3e5f9ba408f9249e"
        },
        "parexamcycleeditview": {
            "title": "考核周期",
            "caption": "考核周期",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCycleEditView",
            "viewtag": "963f9744f61222f20041022b8b7eba31"
        },
        "parldndlhmbgridview": {
            "title": "量化目标填报",
            "caption": "量化目标填报",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbGridView",
            "viewtag": "99f1bd86d47f8bfefef6803ebda3e437"
        },
        "parjxkhxhzpickupview": {
            "title": "考核方案数据选择视图",
            "caption": "考核方案",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxkhxhzPickupView",
            "viewtag": "9bdc1cc9cf9ca2b125301810308b5714"
        },
        "parkhfaeditview": {
            "title": "考核对象",
            "caption": "考核对象",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhfaEditView",
            "viewtag": "a0562928c523c5554de86ca7cce6cf14"
        },
        "parjxkhxhzmpickupview": {
            "title": "考核方案数据多项选择视图",
            "caption": "考核方案",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxkhxhzMPickupView",
            "viewtag": "a7d2bc301b8e39f028248b90a843c720"
        },
        "pardjbzpickupgridview": {
            "title": "定级标准选择表格视图",
            "caption": "定级规则",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParDjbzPickupGridView",
            "viewtag": "a7e23ba4ab5e9edcf7a30491646deb8e"
        },
        "parjxjgkhdjeditview": {
            "title": "绩效考核定级",
            "caption": "绩效考核定级",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxjgKHDJEditView",
            "viewtag": "a97ed731f303a44f10abb4df79b7bfc5"
        },
        "parldndlhmbpickupgridview": {
            "title": "年度量化目标选择表格视图",
            "caption": "年度量化目标（公司领导类）",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbPickupGridView",
            "viewtag": "aa9b7b690655ae0cdcab869b75410416"
        },
        "pardjbzpickupview": {
            "title": "定级标准数据选择视图",
            "caption": "定级规则",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParDjbzPickupView",
            "viewtag": "af463c28cc5bdc634be9572662def4d0"
        },
        "parkhfampickupview": {
            "title": "考核对象数据多项选择视图",
            "caption": "考核对象",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhfaMPickupView",
            "viewtag": "b47e3dac988f450541acd41aa6dbf5fd"
        },
        "parldndlhmbmxeditview2": {
            "title": "量化目标明细（公司领导类）",
            "caption": "年度量化目标明细（公司领导类 ）",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbmxEditView2",
            "viewtag": "b5a4f4ba9e38a14dd765b0eb429ab871"
        },
        "pardjbzmpickupview": {
            "title": "定级标准数据多项选择视图",
            "caption": "定级规则",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParDjbzMPickupView",
            "viewtag": "b6db0b164e59aa61a83a9c96e5f19d34"
        },
        "partzggeditview": {
            "title": "通知信息",
            "caption": "通知信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParTzggEditView",
            "viewtag": "b7f7b92b88ba971f28bbb5aa18145e46"
        },
        "parjxjggridview": {
            "title": "绩效结果表格视图",
            "caption": "绩效结果",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxjgGridView",
            "viewtag": "b8adaeafac9a1acdbd8f4aef296c22ee"
        },
        "parassesstemplatepickupgridview": {
            "title": "考核模板选择表格视图",
            "caption": "考核模板",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParAssessTemplatePickupGridView",
            "viewtag": "be2e9f41096c9c65982109c44e67b657"
        },
        "parldndlhmbndlhmbxzeditview": {
            "title": "量化目标修正",
            "caption": "量化目标修正",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbNDLHMBXZEditView",
            "viewtag": "c088f921bed521fc40c770bfcf4b980e"
        },
        "index": {
            "title": "EHR—绩效管理",
            "caption": "EHR—绩效管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "PAR",
            "viewname": "Index",
            "viewtag": "C1ABBB2A-7CFE-453A-9531-C33DFC4D0912"
        },
        "parkhzcmxeditview": {
            "title": "考核模板明细",
            "caption": "考核模板明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhzcmxEditView",
            "viewtag": "c254a4abcdeaa4de6c2969b4f4335e9e"
        },
        "parldndlhmbeditview": {
            "title": "量化目标填报",
            "caption": "量化目标填报",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbEditView",
            "viewtag": "c763a9c626af79fb672c3156e55ee38d"
        },
        "partzggeditview9": {
            "title": "通知信息",
            "caption": "通知信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PAR",
            "viewname": "ParTzggEditView9",
            "viewtag": "c7741fa56792325b27e13d323a735061"
        },
        "parldkhqzeditview2": {
            "title": "评分权重分配编辑视图",
            "caption": "评分权重分配",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParLdkhqzEditView2",
            "viewtag": "c88a7c2bf97a15a197051cf5c7ec1294"
        },
        "parldndlhmbpickupview": {
            "title": "年度量化目标数据选择视图",
            "caption": "年度量化目标（公司领导类）",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbPickupView",
            "viewtag": "c97ca88335ef0e1ae4e8de845134d822"
        },
        "parexamcontenteditview": {
            "title": "考核内容",
            "caption": "考核内容",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamContentEditView",
            "viewtag": "c9e455b34eb6902a1c0a6fffffbf6dfe"
        },
        "pimpersonpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonPickupGridView",
            "viewtag": "ccbb9b1dc1b969f43ca9f0d6d6ad16b2"
        },
        "parkhfapickupview": {
            "title": "考核对象数据选择视图",
            "caption": "考核对象",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhfaPickupView",
            "viewtag": "cfb925471f4c701f17eb947d2fbf93f7"
        },
        "parldndlhmbmpickupview": {
            "title": "年度量化目标数据多项选择视图",
            "caption": "年度量化目标（公司领导类）",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbMPickupView",
            "viewtag": "d112742c6cd773a01e91de775f7459e0"
        },
        "parjxjgpickupgridview": {
            "title": "绩效结果选择表格视图",
            "caption": "绩效结果",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxjgPickupGridView",
            "viewtag": "d3268bc15f4d6c5302aee098e045f156"
        },
        "parexamcontentmpickupview": {
            "title": "考核内容数据多项选择视图",
            "caption": "考核内容",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamContentMPickupView",
            "viewtag": "d5d8172d5a7dd93aa00007479d4893c8"
        },
        "pardjbzeditview2": {
            "title": "定级标准编辑视图",
            "caption": "定级规则",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParDjbzEditView2",
            "viewtag": "d6dc79636ec9c777e8c62b03e428b518"
        },
        "parassesstemplateeditview9": {
            "title": "考核模板",
            "caption": "考核模板",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PAR",
            "viewname": "ParAssessTemplateEditView9",
            "viewtag": "d84eab620a82c604d82070edc298611c"
        },
        "parexamcyclenewgridview": {
            "title": "考核周期设置",
            "caption": "考核周期设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParExamCycleNewGridView",
            "viewtag": "e184f5db6e3acb31c15469de5437cf75"
        },
        "parassesstemplategridview": {
            "title": "考核模板表格视图",
            "caption": "考核模板设置",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParAssessTemplateGridView",
            "viewtag": "e28617a43cd83dbace56537236958b1d"
        },
        "parldndlhmbkheditview": {
            "title": "量化目标考核（公司领导类）",
            "caption": "量化目标考核（公司领导类）",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdndlhmbKHEditView",
            "viewtag": "e519a0448aa58cc9ef26d17863520b2b"
        },
        "parldkhqzpickupview": {
            "title": "评分权重分配数据选择视图",
            "caption": "评分权重分配",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParLdkhqzPickupView",
            "viewtag": "e68c7d08c4dec95ad51fab0adfb6261e"
        },
        "parexamcontenteditview9": {
            "title": "考核内容",
            "caption": "考核内容",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PAR",
            "viewname": "ParExamContentEditView9",
            "viewtag": "e7275e1243d582d3cb5fd9f5acb19adb"
        },
        "parkhzcmxpickupview": {
            "title": "考核组成明细数据选择视图",
            "caption": "考核模板明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParKhzcmxPickupView",
            "viewtag": "e9be57ed7f3eaa058e17276a047e1d92"
        },
        "parkhfaeditview2": {
            "title": "考核对象编辑视图",
            "caption": "考核对象",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PAR",
            "viewname": "ParKhfaEditView2",
            "viewtag": "ebbe432aa6782a4f5888f6252adca5c3"
        },
        "parjxkhxhzpickupgridview": {
            "title": "考核方案选择表格视图",
            "caption": "考核方案",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxkhxhzPickupGridView",
            "viewtag": "f81ee66ff74c77926f6c9d5517a5cce3"
        },
        "parjxkhxhzeditview": {
            "title": "考核方案编辑视图",
            "caption": "考核方案",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxkhxhzEditView",
            "viewtag": "f99944d28b7536b1bc2c398035f7482b"
        },
        "parjxjgmpickupview": {
            "title": "绩效结果数据多项选择视图",
            "caption": "绩效结果",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PAR",
            "viewname": "ParJxjgMPickupView",
            "viewtag": "fa3c796f1f77cd9cda9f1d2feab7d9b2"
        }
    }];
});