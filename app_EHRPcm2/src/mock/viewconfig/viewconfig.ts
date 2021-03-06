import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "ormorgsjyxzzpickupview": {
            "title": "选择组织",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgSJYXZZPickupView",
            "viewtag": "011561fa43c0f5aed2832158c3eebdb0"
        },
        "pcmydlzmxgridview": {
            "title": "异动离职明细表格视图",
            "caption": "异动离职明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxGridView",
            "viewtag": "05b284308ed6b260eddfbb857b457da4"
        },
        "pcmydbxmxmpickupview": {
            "title": "异动病休明细数据多项选择视图",
            "caption": "异动病休明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxMPickupView",
            "viewtag": "06d6fbd825358a4d7de7d8760a02e12c"
        },
        "pcmyddgmxgridview": {
            "title": "异动待岗明细表",
            "caption": "异动待岗明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxGridView",
            "viewtag": "0721b6b31f252591be03b7115c671651"
        },
        "pcmydjpmxjpjlgridview": {
            "title": "解聘记录",
            "caption": "解聘记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxJPJLGridView",
            "viewtag": "0744c064c5faabac7a65b5f0226ccb03"
        },
        "ormpostorgidpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostORGIDPickupGridView",
            "viewtag": "0767954fb173fcc23173aa97be505f58"
        },
        "pcmydntmxckeditview": {
            "title": "异动内退明细",
            "caption": "异动内退明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxCKEditView",
            "viewtag": "07841041c9809f12d16f17d5238d4b7f"
        },
        "pcmrecruitmentpickupgridview": {
            "title": "内部招聘信息选择表格视图",
            "caption": "内部招聘信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmRecruitmentPickupGridView",
            "viewtag": "07967fc84d6e9abe4e583fb53fc5b4a1"
        },
        "pcmydlzmxxzeditview": {
            "title": "新增离职",
            "caption": "新增离职",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxXZEditView",
            "viewtag": "09ed0f4be9f3ab5b9eb28cd9323a7692"
        },
        "pcmydjzmxeditview9": {
            "title": "兼职明细信息",
            "caption": "兼职明细信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxEditView9",
            "viewtag": "0f74943ebe3d1919f6d166d74e32ae49"
        },
        "pimpersonsyjxeditview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PIM",
            "viewname": "PimPersonSYJXEditView",
            "viewtag": "0fc510e3278ad0b28cca4ac41d8920e1"
        },
        "ormorgsjyxzzqxpickupgridview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgSJYXZZQXPickupGridView",
            "viewtag": "10d0a191376a8330604bb1223df97084"
        },
        "pcmydgzmxmpickupview": {
            "title": "异动挂职明细数据多项选择视图",
            "caption": "异动挂职明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxMPickupView",
            "viewtag": "114f6647f6f6cf489145008536c1bd93"
        },
        "pimfaminfojtlxrpickupview": {
            "title": "家庭联系人",
            "caption": "家庭情况",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimFaminfoJTLXRPickupView",
            "viewtag": "119886ea176244553b9d53bed4d3d618"
        },
        "pcmxygzzjlmxeditview": {
            "title": "试用期员工转正申请",
            "caption": "试用期员工转正申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzjlmxEditView",
            "viewtag": "127a9ba3a71a0255a388142951b7e831"
        },
        "pcmydjpmxeditview": {
            "title": "异动解聘明细",
            "caption": "异动解聘明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxEditView",
            "viewtag": "1296e9fa7cfba6b54cd535ecacbe09fd"
        },
        "pcmydlzmxeditview9": {
            "title": "离职明细信息",
            "caption": "离职明细信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxEditView9",
            "viewtag": "135f884c5d8c04d9ee0e5d12b9d6d050"
        },
        "pcmddsqdmxgbddjlgridview": {
            "title": "干部调动记录",
            "caption": "干部调动记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxGBDDJLGridView",
            "viewtag": "158ab469934d6f022890315eca194b2d"
        },
        "pcmydjpmxredirectview": {
            "title": "异动解聘明细数据重定向视图",
            "caption": "异动解聘明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxRedirectView",
            "viewtag": "159292dd22ecc474ce32296c4689c46f"
        },
        "ormpostpickupgridview": {
            "title": "岗位管理选择表格视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostPickupGridView",
            "viewtag": "17114a21969d91354a3e122609578082"
        },
        "pcmyddgmxjsrqqreditview": {
            "title": "请确认/修改待岗结束日期",
            "caption": "异动待岗明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxJSRQQREditView",
            "viewtag": "187f4ee50c52c2f96407e0df2a799c34"
        },
        "ormorgsjyxzzqxpickupview": {
            "title": "选择组织",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgSJYXZZQXPickupView",
            "viewtag": "189caa42010d28619926827ae4d9d687"
        },
        "pcmyddgmxredirectview": {
            "title": "异动待岗明细数据重定向视图",
            "caption": "异动待岗明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxRedirectView",
            "viewtag": "19385e5cb8a1ad05ef37b71f9a293b6a"
        },
        "pcmydjdmxjdjsqreditview": {
            "title": "请确认/修改借调结束时间",
            "caption": "异动借调明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxJDJSQREditView",
            "viewtag": "1bf4b1a851c85bdb86dced19899be308"
        },
        "pimpersonbylygpickupview": {
            "title": "B/Y类员工选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonBYLYGPickupView",
            "viewtag": "1cc921dbfa1662396f97006e30b12be6"
        },
        "pcmddsqdmxddjlgridview": {
            "title": "调动记录",
            "caption": "调动记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxDDJLGridView",
            "viewtag": "1e3db0f223b69a63e7738f0def95aa68"
        },
        "pcmjxsygzzjlmxsqtemplgridview": {
            "title": "见习生员工转正记录引用明细表",
            "caption": "见习生员工转正记录引用明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxsygzzjlmxSQTEMPLGridView",
            "viewtag": "2033d35fd2c7e7d5a305b6d1f94f312b"
        },
        "pcmydjdmxjdlsjlgridview": {
            "title": "借调记录",
            "caption": "借调记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxJDLSJLGridView",
            "viewtag": "2089403d59596a77197ffc33d0ee717e"
        },
        "pimpersonyxzfppickupview": {
            "title": "员工库",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonYXZFPPickupView",
            "viewtag": "220a5f087f07a2507bb87d71828db112"
        },
        "pcmddsqdmxpickupview": {
            "title": "调动申请单明细数据选择视图",
            "caption": "调动申请单明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxPickupView",
            "viewtag": "23470354895a2fe4e3d5dfcec99bf151"
        },
        "pcmydlzmxckeditview": {
            "title": "异动离职明细查看",
            "caption": "异动离职明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxCKEditView",
            "viewtag": "26afe15295bfa7f302bf704fd618b89a"
        },
        "pcmjxsygzzjlmxxzeditview": {
            "title": "见习期员工转正申请",
            "caption": "见习期员工转正申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxsygzzjlmxXZEditView",
            "viewtag": "27a97b7eacb124875a7ef2c61a832c85"
        },
        "pcmddsqdxzpddeditview": {
            "title": "新增批调动",
            "caption": "调动申请单",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdXZPDDEditView",
            "viewtag": "27e2c7a3f74ea0b6f05bc5012f4ecee6"
        },
        "pcmydbxmxbxjsrqqreditview": {
            "title": "请确认/修改病休结束日期",
            "caption": "异动病休明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxBXJSRQQREditView",
            "viewtag": "2856ac0b7ff32ab4e61b53577f2d50f4"
        },
        "pcmydgzmxjsrqqreditview": {
            "title": "请确认/修改挂职结束时间",
            "caption": "异动挂职明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxJSRQQREditView",
            "viewtag": "29f9fa27438ea356ca1cc1bd5e052530"
        },
        "pcmydntmxmpickupview": {
            "title": "异动内退明细数据多项选择视图",
            "caption": "异动内退明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxMPickupView",
            "viewtag": "2a7a45545c5bce78b7ec22fa6f88b58f"
        },
        "pcmydtxmxmpickupview": {
            "title": "异动病休明细数据多项选择视图",
            "caption": "异动退休明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxMPickupView",
            "viewtag": "2b8da8bc55d6bd7d631cb03f3f8bbee1"
        },
        "pcmydjpmxeditview2": {
            "title": "异动解聘明细编辑视图",
            "caption": "异动解聘明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxEditView2",
            "viewtag": "2c29c49adb00089331b70916ae12573a"
        },
        "ormdutyormorgsectorpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmDutyOrmOrgSectorPickupView",
            "viewtag": "2cf63248151140819172b024c70a018c"
        },
        "ormorgfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgFPXXPickupView",
            "viewtag": "2d973c4e71279b7d36e38351d22297ae"
        },
        "pimpersonmpickupview": {
            "title": "人员信息数据多项选择视图",
            "caption": "人员信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonMPickupView",
            "viewtag": "2e4a6f59ceec5718f083ef7343f5b9a3"
        },
        "ormpostejormorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmPostEJORMORGIDPickupView",
            "viewtag": "2ec2fcb792ced271f874ba92fe260330"
        },
        "pimpersonpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonPickupGridView",
            "viewtag": "301c1c96408f00ca6e559adb2d7f5eed"
        },
        "pcmjxszzkhjgjlpickupgridview": {
            "title": "见习生员工转正考核结果记录选择表格视图",
            "caption": "见习生员工转正考核结果记录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxszzkhjgjlPickupGridView",
            "viewtag": "321462cf013ff5dae2eeaaaf99c56117"
        },
        "pcmxygzzsqgridview": {
            "title": "试用期员工转正申请表格视图",
            "caption": "试用期员工转正申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqGridView",
            "viewtag": "34f739b4b59de8e527e14833b2ac55b8"
        },
        "pcmddsqdmxjdsqmxeditview": {
            "title": "借调申请明细",
            "caption": "借调申请明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxJDSQMXEditView",
            "viewtag": "354427f0670d912b99b3f05d347f6ef4"
        },
        "pcmxygzzsqmpickupview": {
            "title": "试用期员工转正申请数据多项选择视图",
            "caption": "试用期员工转正申请",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqMPickupView",
            "viewtag": "35d3d0f6de3bee6c0a7ccbf87612141e"
        },
        "pcmydbxmxbxglgridview": {
            "title": "病休管理",
            "caption": "病休管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxBXGLGridView",
            "viewtag": "371096cd964f4d024b2bf9cb7924bb54"
        },
        "ormdutypickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmDutyPickupGridView",
            "viewtag": "389e3ed8ad377cd6c118da032f0520e1"
        },
        "pcmddsqdmxddckeditview": {
            "title": "异动调动明细",
            "caption": "调动申请单明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxDDCKEditView",
            "viewtag": "3964818be4518bc7aedf3a4a7dfa8271"
        },
        "pcmydgzmxgzceditview": {
            "title": "新增挂职出",
            "caption": "新增挂职出",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxGZCEditView",
            "viewtag": "3b416d488bc1ae9c3756692a5f1e68ca"
        },
        "pimpersontxrypickupview": {
            "title": "选择退休人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonTXRYPickupView",
            "viewtag": "3c851dd1278ecb803285317cc469bf9c"
        },
        "pcmxygzzjlmxsyqzzjlgridview": {
            "title": "试用期转正记录",
            "caption": "试用期转正记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzjlmxSYQZZJLGridView",
            "viewtag": "3c86db51a9f9692e282d44098444cb6f"
        },
        "pcmydtxmxeditview": {
            "title": "异动病休明细编辑视图",
            "caption": "异动退休明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxEditView",
            "viewtag": "3d87bcde5c7e4c28503705f9ec026b0f"
        },
        "pcmydlzmxredirectview": {
            "title": "异动离职明细数据重定向视图",
            "caption": "异动离职明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxRedirectView",
            "viewtag": "3dc44356f3918afed9cfd0c70d585d24"
        },
        "pimpersonkxzxygpickupview": {
            "title": "试用期员工",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonKXZXYGPickupView",
            "viewtag": "4061e9159d0ed321448b9652a5d6a372"
        },
        "pcmydjzmxjsrqqreditview": {
            "title": "请确认/修改兼职结束时间",
            "caption": "异动兼职明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxJSRQQREditView",
            "viewtag": "40a24d4c9f59b69b0f292923bc922f93"
        },
        "pcmddsqdmxddsqsheditview": {
            "title": "调动",
            "caption": "调动申请单明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxDDSQSHEditView",
            "viewtag": "40a268570393b163af32a72e592a3513"
        },
        "pcmydbxmxgridview": {
            "title": "异动病休明细表格视图",
            "caption": "异动病休明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxGridView",
            "viewtag": "42964fbb39c05ff14badfaa4e2f2b2c6"
        },
        "pcmddsqdmxmpickupview": {
            "title": "调动申请单明细数据多项选择视图",
            "caption": "调动申请单明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxMPickupView",
            "viewtag": "467f25c7822b1b29608934028376cd9c"
        },
        "pcmydjzmxmpickupview": {
            "title": "异动兼职明细数据多项选择视图",
            "caption": "异动兼职明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxMPickupView",
            "viewtag": "46811c36213cf5c0e0c06c3be88bec34"
        },
        "pcmydbxmxpickupgridview": {
            "title": "异动病休明细选择表格视图",
            "caption": "异动病休明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxPickupGridView",
            "viewtag": "46bc5ec5c3f14ca121d8c549fb972451"
        },
        "pcmydjpmxmpickupview": {
            "title": "异动解聘明细数据多项选择视图",
            "caption": "异动解聘明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxMPickupView",
            "viewtag": "46c527e5e4f0aec93ddec88f8e014f43"
        },
        "pcmjxsygzzjlmxzzjlgridview": {
            "title": "见习期转正记录",
            "caption": "见习期转正记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxsygzzjlmxZZJLGridView",
            "viewtag": "472606b801b7bcc144af917f32c36acb"
        },
        "pcmddsqdmxtyddgridview": {
            "title": "调动申请明细",
            "caption": "调动申请单明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxTYDDGridView",
            "viewtag": "47846056d086cc6505ba79ac3c076faf"
        },
        "pcmydjdmxeditview2": {
            "title": "异动借调明细编辑视图",
            "caption": "异动借调明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxEditView2",
            "viewtag": "487c2d426b3ee5975927d50cf2b67a42"
        },
        "pimdistirbutionmaturitydueeditview": {
            "title": "借调到期编辑视图",
            "caption": "借调到期",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionMaturityDueEditView",
            "viewtag": "4880095fa928f20096fe9fce0692351f"
        },
        "pcmydjpmxeditview9": {
            "title": "解聘明细信息",
            "caption": "解聘明细信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxEditView9",
            "viewtag": "48c1378bdb9278289adfeb4d200b02c3"
        },
        "pcmydjdmxjdqroptionview": {
            "title": "请确认/修改借调结束时间",
            "caption": "异动借调明细",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxJDQROptionView",
            "viewtag": "48e498807456278ef6b33b9a936f89e2"
        },
        "pcmddsqdmxjzsqgrgridview": {
            "title": "兼职申请",
            "caption": "兼职申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxJZSQGRGridView",
            "viewtag": "495749f209414f8556f8ee0d109b2817"
        },
        "pcmddsqdmxgrzzsqjdeditview": {
            "title": "借调申请编辑视图",
            "caption": "借调申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxGRZZSQJDEditView",
            "viewtag": "495aa44fbc7bdff95026ac946a2132c2"
        },
        "pcmddsqdmxlgsqmxgridview": {
            "title": "轮岗申请明细",
            "caption": "轮岗申请明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxLGSQMXGridView",
            "viewtag": "49fd2453df7be3b6ad898090da019d3c"
        },
        "pcmydgzmxgzcglgridview": {
            "title": "挂职调出",
            "caption": "挂职调出",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxGZCGLGridView",
            "viewtag": "4a56e8a8d1ddccf00079f21aacd52a0d"
        },
        "pcmddsqdmxddeditview": {
            "title": "调动",
            "caption": "调动申请单明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxDDEditView",
            "viewtag": "4a99687a15282a2616a626be57be52af"
        },
        "pimpersontxglgridview": {
            "title": "退休管理",
            "caption": "退休管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonTXGLGridView",
            "viewtag": "4abb758e93c0bb397ee7084592bbd4e4"
        },
        "pimdistirbutionredirectview": {
            "title": "分配信息数据重定向视图",
            "caption": "分配信息",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionRedirectView",
            "viewtag": "4aff675dc08f7125ee62afd49dcae323"
        },
        "pcmxygzzjlmxckeditview": {
            "title": "试用期员工转正明细",
            "caption": "试用期员工转正记录引用明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzjlmxCKEditView",
            "viewtag": "4d66cd024a4ad18845836220e338982f"
        },
        "pcmxygzzkhjgjlpickupview": {
            "title": "新员工转正考核结果记录数据选择视图",
            "caption": "试用期员工转正考核结果记录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzkhjgjlPickupView",
            "viewtag": "4ebef222c9680de5e2138ea9fad1f87f"
        },
        "pcmydgzmxeditview2": {
            "title": "异动挂职明细编辑视图",
            "caption": "异动挂职明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxEditView2",
            "viewtag": "501e0ad8df3edbe849662fb78bd008ea"
        },
        "pcmydlzmxpickupview": {
            "title": "异动离职明细数据选择视图",
            "caption": "异动离职明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxPickupView",
            "viewtag": "51144a410e729db7fb5145e4c24b65dc"
        },
        "pcmydgzmxgzrlsjlgridview": {
            "title": "挂职进记录",
            "caption": "挂职进记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxGZRLSJLGridView",
            "viewtag": "517fd6f7683348ccf53b593aa584eea2"
        },
        "pcmxygzzsqpickupgridview": {
            "title": "试用期员工转正申请选择表格视图",
            "caption": "试用期员工转正申请",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqPickupGridView",
            "viewtag": "52dfa733a583ee824acb9bc4eda06164"
        },
        "pcmddsqdmxddsqoptionview": {
            "title": "调动",
            "caption": "调动申请单明细",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxDDSQOptionView",
            "viewtag": "55221b154d4eda6a91fc503cf60d85d9"
        },
        "pimdistirbutionddmgrgridview": {
            "title": "调动管理",
            "caption": "调动管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionDDMgrGridView",
            "viewtag": "559fd7ee3353c55129a761c38f68b6fd"
        },
        "pcmydjzmxglgridview": {
            "title": "兼职管理",
            "caption": "兼职管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxGLGridView",
            "viewtag": "55fa31bd5d3123da7490f3ae76b5b54d"
        },
        "pcmydjdmxmpickupview": {
            "title": "异动借调明细数据多项选择视图",
            "caption": "异动借调明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxMPickupView",
            "viewtag": "569e19acb133248dc84d29ed504ccacc"
        },
        "pcmydjzmxeditview2": {
            "title": "异动兼职明细编辑视图",
            "caption": "异动兼职明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxEditView2",
            "viewtag": "5936e54be5c3035ff2b7ad35151f2ac5"
        },
        "pcmydjzmxlsjlgridview": {
            "title": "兼职记录",
            "caption": "兼职记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxLSJLGridView",
            "viewtag": "5a09e844d1a4abd40c599b0d1673495b"
        },
        "pimpersonkxzxygpickupgridview": {
            "title": "人员信息选择表格视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonKXZXYGPickupGridView",
            "viewtag": "5ab7963e08a0c4910facfe2875d945ee"
        },
        "pcmydtxmxredirectview": {
            "title": "异动病休明细数据重定向视图",
            "caption": "异动退休明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxRedirectView",
            "viewtag": "5acc19e3ff72e547ffec23e36ab76f78"
        },
        "pcmydbxmxeditview": {
            "title": "异动病休明细编辑视图",
            "caption": "异动病休明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxEditView",
            "viewtag": "5b0d0c313abec7a9d635b1faf5e83dcc"
        },
        "pcmddsqdmxgrzzsqjzeditview": {
            "title": "兼职申请编辑视图",
            "caption": "兼职申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxGRZZSQJZEditView",
            "viewtag": "5bb09d8d12dee4d5301dcc64078b0dcb"
        },
        "pcmydjdmxjdjlckeditview": {
            "title": "借调记录查看",
            "caption": "借调记录查看",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxJDJLCKEditView",
            "viewtag": "5c2a36e6e8a3cb5d7fbba37494c36c3f"
        },
        "pimdistirbutionygfenpeigridview": {
            "title": "分配信息表格视图",
            "caption": "分配信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionYGFenPeiGridView",
            "viewtag": "5fc2c295abb090da79cd6bfa22422494"
        },
        "pcmydtxmxeditview2": {
            "title": "异动病休明细编辑视图",
            "caption": "异动退休明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxEditView2",
            "viewtag": "60392ec1e472b8f85da89b34faada1f6"
        },
        "pcmydbxmxeditview9": {
            "title": "病休明细信息",
            "caption": "病休明细信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxEditView9",
            "viewtag": "60fbad7a0ec6fd399d6e0fb4c119bda6"
        },
        "pcmydjdmxpickupgridview": {
            "title": "异动借调明细选择表格视图",
            "caption": "异动借调明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxPickupGridView",
            "viewtag": "614f3395434a5a70b261f2e3fbfbd590"
        },
        "pcmxygzzjlmxapprovalgridview": {
            "title": "试用期转正审核",
            "caption": "试用期转正审核",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzjlmxApprovalGridView",
            "viewtag": "61b21d2f8041091311c35e8dc8fef06d"
        },
        "pcmxygzzsqmxeditview": {
            "title": "试用期员工转正申请明细编辑视图",
            "caption": "试用期员工转正申请明细（停用）",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqmxEditView",
            "viewtag": "61e224a44cc2b1ca41013b5b85d177a3"
        },
        "pcmydbxmxredirectview": {
            "title": "异动病休明细数据重定向视图",
            "caption": "异动病休明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxRedirectView",
            "viewtag": "634aeaa7c4db8f6ffaade689f25804f8"
        },
        "pcmxygzzjlmxzzsqlsjmgridview": {
            "title": "试用期员工转正结果引用明细",
            "caption": "试用期员工转正结果引用明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzjlmxZZSQLSJMGridView",
            "viewtag": "64778fdae321216fbcccab69d0ae73d7"
        },
        "pimdistirbutionkddfppickupgridview": {
            "title": "可调动的分配",
            "caption": "分配信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionKDDFPPickupGridView",
            "viewtag": "66d47a748181aeff317a01198e1ef938"
        },
        "pcmydgzmxtype_gzjeditview3": {
            "title": "异动挂职明细编辑视图(挂职进)",
            "caption": "异动挂职明细",
            "viewtype": "DEEDITVIEW3",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxType_GZJEditView3",
            "viewtag": "67d8ae75186cb57f396b4f0ac4f89abe"
        },
        "pcmydlzmxmpickupview": {
            "title": "异动离职明细数据多项选择视图",
            "caption": "异动离职明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxMPickupView",
            "viewtag": "689be5480c691efb3adb56994107220e"
        },
        "pimpersontxrypickupgridview": {
            "title": "退休人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonTXRYPickupGridView",
            "viewtag": "6935affe7325c38a71f28a07eb80a8ef"
        },
        "pimpersonbylygpickupgridview": {
            "title": "B/Y类员工",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonBYLYGPickupGridView",
            "viewtag": "699329644d670e22adc356ddce905540"
        },
        "pcmyddgmxpickupgridview": {
            "title": "异动待岗明细选择表格视图",
            "caption": "异动待岗明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxPickupGridView",
            "viewtag": "6bd804d38011a9f1689fa01166b522c6"
        },
        "pcmydlzmxeditview": {
            "title": "异动离职明细编辑视图",
            "caption": "异动离职明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxEditView",
            "viewtag": "6e3f6f01b37c63a0a738db5fc80f9f74"
        },
        "pcmjxsygzzjlmxckeditview": {
            "title": "见习生员工转正明细",
            "caption": "见习生员工转正记录引用明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxsygzzjlmxCKEditView",
            "viewtag": "709535b1264b99a64c5cba6a067d96d8"
        },
        "pcmxygzzsqpickupview": {
            "title": "试用期员工转正申请数据选择视图",
            "caption": "试用期员工转正申请",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqPickupView",
            "viewtag": "727f4f522e24e5f58477a5eebc56b053"
        },
        "pcmjxsygzzjlmxapproavlgridview": {
            "title": "见习期转正审核",
            "caption": "见习期转正审核",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxsygzzjlmxApproavlGridView",
            "viewtag": "74806f40a80f744d1f9f899fe5bc2aab"
        },
        "pcmjxsygzzjlmxeditview": {
            "title": "见习生员工转正记录引用明细编辑视图",
            "caption": "见习生员工转正记录引用明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxsygzzjlmxEditView",
            "viewtag": "75b62ccd6984832138d637517d537ad4"
        },
        "pimdistirbutionddrmgrgridview": {
            "title": "调入管理",
            "caption": "调入管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionDDRMgrGridView",
            "viewtag": "77ebb4c718553020312d2622c5041415"
        },
        "pcmydjdmxeditview9": {
            "title": "借调信息",
            "caption": "借调信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxEditView9",
            "viewtag": "78f5df1d24b502abd692327db916b875"
        },
        "pcmyddgmxeditview": {
            "title": "异动待岗明细",
            "caption": "异动待岗明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxEditView",
            "viewtag": "79a4775a934c09368ee74433dfbad69c"
        },
        "ormorgypzxxsypickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgYPZXXSYPickupGridView",
            "viewtag": "7a3a830f086da85b0b12576f85d9c873"
        },
        "pcmydjdmxjdglgridview": {
            "title": "借调管理",
            "caption": "借调管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxJDGLGridView",
            "viewtag": "7b11f4b33a5097e773dca5b66a9357e5"
        },
        "pcmjxszzkhjgjlpickupview": {
            "title": "见习生员工转正考核结果记录数据选择视图",
            "caption": "见习生员工转正考核结果记录",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxszzkhjgjlPickupView",
            "viewtag": "7ec5fb97b7ba11433f95907572b724fd"
        },
        "pimpersoncurorgpimpersonpickupgridview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonCurOrgPimpersonPickupGridView",
            "viewtag": "83a391a18e7bd518c14ab05572e6b494"
        },
        "pimfaminfojtlxrpickupgridview": {
            "title": "家庭联系人",
            "caption": "家庭情况",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimFaminfoJTLXRPickupGridView",
            "viewtag": "83c54717ccc3050d92f46679694cc149"
        },
        "pcmddsqdmxjzsqmxeditview": {
            "title": "兼职申请明细",
            "caption": "兼职申请明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxJZSQMXEditView",
            "viewtag": "844f674b829f7675d4c632eeae5de71f"
        },
        "pimpersonyxzfppickupgridview": {
            "title": "有效主分配的人员",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonYXZFPPickupGridView",
            "viewtag": "84604ef010cd2422683b759810bee549"
        },
        "pcmydgzmxgzclsjlgridview": {
            "title": "挂职出记录",
            "caption": "挂职出记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxGZCLSJLGridView",
            "viewtag": "8623dc0cf076ef91bf303f1a64fc5d4a"
        },
        "pcmydjdmxydmxeditview": {
            "title": "新增借调",
            "caption": "异动借调明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxYDMXEditView",
            "viewtag": "8729b8ce6157e8ab636bff909eab106b"
        },
        "pcmydjpmxxzeditview": {
            "title": "新增解聘",
            "caption": "新增解聘",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxXZEditView",
            "viewtag": "880708a2c62910269eb8ae33afdf5e4b"
        },
        "pimpersontxryeditview": {
            "title": "退休人员信息",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonTXRYEditView",
            "viewtag": "88de65d118d034ec62514ec9cc229438"
        },
        "pcmddsqdmxgrzzsqddeditview": {
            "title": "调动申请编辑视图",
            "caption": "调动申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxGRZZSQDDEditView",
            "viewtag": "89d7da6963978b8a7f0c23f62cc194d3"
        },
        "pimdistirbutiongbddmgrgridview": {
            "title": "干部调动",
            "caption": "干部调动",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionGBDDMgrGridView",
            "viewtag": "89d8f4dbdb50b6fb724c0509252a1578"
        },
        "ormdutypickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmDutyPickupView",
            "viewtag": "89f7715eedf04be9cb4cb910eb347230"
        },
        "pimpersontxqreditview": {
            "title": "请确认/修改退休信息",
            "caption": "人员信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonTXQREditView",
            "viewtag": "8a956c3690e308b4a8cf365a643bd6c1"
        },
        "ormorgpickupview": {
            "title": "组织管理数据选择视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgPickupView",
            "viewtag": "8b64d4b8a0e3f209aa52001c312117f1"
        },
        "pcmddsqdmxpddgridview": {
            "title": "调动明细",
            "caption": "调动申请单明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxPDDGridView",
            "viewtag": "8f3eaf9fc89117b038d501fbb05d44db"
        },
        "ormorgsectorpickupgridview": {
            "title": "部门管理选择表格视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgsectorPickupGridView",
            "viewtag": "93910ee5e6c7441c09aa8809597bcba9"
        },
        "ormorgsectorfpxxpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgsectorFPXXPickupGridView",
            "viewtag": "948705b4635f7bcd77a848b6731e3b3c"
        },
        "pcmyddgmxdgglgridview": {
            "title": "待岗管理",
            "caption": "待岗管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxDGGLGridView",
            "viewtag": "949f5b85bbe9b04326627caa6086a289"
        },
        "pcmydjzmxpickupview": {
            "title": "异动兼职明细数据选择视图",
            "caption": "异动兼职明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxPickupView",
            "viewtag": "95e137dc5997202183596373696aa384"
        },
        "pcmjxsygzzjlmxeditview9": {
            "title": "见习期员工转正",
            "caption": "见习期员工转正",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmJxsygzzjlmxEditView9",
            "viewtag": "967f9b0b15d69f68860fbc8ccd67c7a0"
        },
        "pcmydtxmxpickupgridview": {
            "title": "异动病休明细选择表格视图",
            "caption": "异动退休明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxPickupGridView",
            "viewtag": "97c3c3af17a9abad011386ee391f5470"
        },
        "pcmydgzmxpickupview": {
            "title": "异动挂职明细数据选择视图",
            "caption": "异动挂职明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxPickupView",
            "viewtag": "986e88864846c14565b24cce4a5d4deb"
        },
        "pcmydbxmxjlgridview": {
            "title": "病休记录",
            "caption": "病休记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxJLGridView",
            "viewtag": "98ce229597cc6cfcd912f4e9aeb22044"
        },
        "pcmydntmxxzeditview": {
            "title": "新增内退",
            "caption": "新增内退",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxXZEditView",
            "viewtag": "994b7724ecfb0f0e9a157db2b34affd1"
        },
        "pcmxygzzsqredirectview": {
            "title": "试用期员工转正申请数据重定向视图",
            "caption": "试用期员工转正申请",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqRedirectView",
            "viewtag": "999153f1294f6e92da439ff8555f5b50"
        },
        "pcmydjpmxglgridview": {
            "title": "解聘管理",
            "caption": "解聘管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxGLGridView",
            "viewtag": "9aa581b1142b959b87730e54c16e1da3"
        },
        "pimdistirbutioneditview": {
            "title": "分配信息编辑视图",
            "caption": "分配信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionEditView",
            "viewtag": "9c3d3ccdf9f018e612cfd0c6969832f1"
        },
        "pcmrecruitmentpickupview": {
            "title": "内部招聘信息数据选择视图",
            "caption": "内部招聘信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmRecruitmentPickupView",
            "viewtag": "9d844432837c96fe861ddb479ab59c7c"
        },
        "pimpersoneditview9": {
            "title": "人员信息编辑视图（退休）",
            "caption": "退休人员信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PIM",
            "viewname": "PimPersonEditView9",
            "viewtag": "9e47fdb719e865755ac0d5481dc4a166"
        },
        "ormorgypzsyfpxxpickupview": {
            "title": "组织数据选择视图",
            "caption": "组织数据选择视图",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgYPZSYFPXXPickupView",
            "viewtag": "9fedcc358e5bc2a3133833335b77acff"
        },
        "pcmydjzmxgridview": {
            "title": "异动兼职明细表格视图",
            "caption": "异动兼职明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxGridView",
            "viewtag": "a1669417849c3672c26fd59caf9e9d9e"
        },
        "pimdistirbutionkddmpickupview": {
            "title": "可调动的分配",
            "caption": "分配信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionKDDMPickupView",
            "viewtag": "a17267710aad72743e662159e330fd57"
        },
        "pcmydgzmxgridview": {
            "title": "异动挂职明细表格视图",
            "caption": "异动挂职明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxGridView",
            "viewtag": "a1b90688c0eb8088983aa55ae0f468b3"
        },
        "pcmddsqdmxjdsqgrgridview": {
            "title": "借调申请",
            "caption": "借调申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxJDSQGRGridView",
            "viewtag": "a2cfc4eb807985c6082969965bdd0df2"
        },
        "pcmydntmxpickupgridview": {
            "title": "异动内退明细选择表格视图",
            "caption": "异动内退明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxPickupGridView",
            "viewtag": "a71117dfe913aab6b73f4286709f7d24"
        },
        "pcmydlzmxglgridview": {
            "title": "离职管理",
            "caption": "离职管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxGLGridView",
            "viewtag": "a71693acbf5a4d77b4407ccad0899624"
        },
        "pcmydntmxeditview2": {
            "title": "异动内退明细编辑视图",
            "caption": "异动内退明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxEditView2",
            "viewtag": "a93b6b6efe8a9ccf0a6f5a46cdbbc5a5"
        },
        "pcmxygzzjlmxeditview9": {
            "title": "试用期员工转正",
            "caption": "试用期员工转正",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzjlmxEditView9",
            "viewtag": "a9827f5ee0e883f0c48c5a5f2d89b124"
        },
        "pcmydjdmxeditview": {
            "title": "借调明细信息",
            "caption": "借调明细信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxEditView",
            "viewtag": "a9a72f00f6bb8d29263406b4d2ca4354"
        },
        "pimpersoncurorgpimpersonpickupview": {
            "title": "人员信息",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonCurOrgPimpersonPickupView",
            "viewtag": "a9faa19eb252825a9cc700c6c114528b"
        },
        "pcmddsqdmxzwbdsqmxeditview": {
            "title": "职务变动申请明细",
            "caption": "职务变动申请明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxZWBDSQMXEditView",
            "viewtag": "ab3abeb657826f0ca3d6bc5975e6abfe"
        },
        "pcmddsqdmxjdsqwshgridview": {
            "title": "借调查看",
            "caption": "借调查看",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxJDSQWSHGridView",
            "viewtag": "abdcfe13acda7c25247fdcdd483419a4"
        },
        "pcmydntmxredirectview": {
            "title": "异动内退明细数据重定向视图",
            "caption": "异动内退明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxRedirectView",
            "viewtag": "ad08444519dc6c4bdef6d0e117bd3671"
        },
        "pcmydjdmxgridview": {
            "title": "异动借调明细表格视图",
            "caption": "异动借调明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxGridView",
            "viewtag": "ad351fd0541b6454efcf60e840fc6e39"
        },
        "pcmxygzzsqeditview2": {
            "title": "试用期员工转正申请编辑视图",
            "caption": "试用期员工转正申请",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqEditView2",
            "viewtag": "ae79a8c5e519c5ae185b82826828ee27"
        },
        "pcmydjpmxpickupgridview": {
            "title": "异动解聘明细选择表格视图",
            "caption": "异动解聘明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxPickupGridView",
            "viewtag": "afefcaa892dc7bd4537d74f21bbe5119"
        },
        "pcmydntmxpickupview": {
            "title": "异动内退明细数据选择视图",
            "caption": "异动内退明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxPickupView",
            "viewtag": "b133b02d3bbf55190cf28d28fe3714f4"
        },
        "pimpersonjxqpickupgridview": {
            "title": "见习期员工",
            "caption": "人员信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonJXQPickupGridView",
            "viewtag": "b3b3ae90c64e095c9f1d38efa7f320ed"
        },
        "pcmydlzmxpickupgridview": {
            "title": "异动离职明细选择表格视图",
            "caption": "异动离职明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxPickupGridView",
            "viewtag": "b4f37e81894cfd0b8f2c623eb8e565a4"
        },
        "pimdistirbutionmpickupview": {
            "title": "分配信息数据多项选择视图",
            "caption": "分配信息",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionMPickupView",
            "viewtag": "b6dae9ec2c1c6507783434fc9c9fe592"
        },
        "pcmxygzzsqmxgridview": {
            "title": "试用期员工转正申请明细表格视图",
            "caption": "试用期员工转正申请明细（停用）",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqmxGridView",
            "viewtag": "b8417dce40cadb61d0b9559fdbf901ac"
        },
        "pimpersonjxspickupview": {
            "title": "见习生选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonJXSPickupView",
            "viewtag": "b8d4e7512bdcc67e170881d1c642e679"
        },
        "ormdutyorgsectorpickupview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmDutyOrgSectorPickupView",
            "viewtag": "bad958d4f183c84dc9fe9ddadb41f902"
        },
        "pcmydjpmxgridview": {
            "title": "异动解聘明细表",
            "caption": "异动解聘明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxGridView",
            "viewtag": "bafe5b6630f7ef513c5be76c13881f3b"
        },
        "pcmydjdmxredirectview": {
            "title": "异动借调明细数据重定向视图",
            "caption": "异动借调明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxRedirectView",
            "viewtag": "bb2d76ba960ae38e69878295c4e9c2c9"
        },
        "pcmydgzmxredirectview": {
            "title": "异动挂职明细数据重定向视图",
            "caption": "异动挂职明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxRedirectView",
            "viewtag": "be1a0a148707aa2b5d81a55526815fa4"
        },
        "pcmydtxmxpickupview": {
            "title": "异动病休明细数据选择视图",
            "caption": "异动退休明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxPickupView",
            "viewtag": "bf6737d3f96e8bd85ab8f8421b4d2090"
        },
        "pcmxygzzsqzzsqjmeditview": {
            "title": "试用期员工转正",
            "caption": "试用期员工转正申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqZZSQJMEditView",
            "viewtag": "c033c817e7c00e3eda6a72541f396992"
        },
        "pcmydtxmxckeditview": {
            "title": "异动退休明细",
            "caption": "异动退休明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxCKEditView",
            "viewtag": "c1f28d055aab3e2ca57dbb55834f287f"
        },
        "pcmydgzmxeditview": {
            "title": "异动挂职明细编辑视图",
            "caption": "异动挂职明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxEditView",
            "viewtag": "c25d65e47b4897084226ea56e60dfde2"
        },
        "pcmddsqdmxddsqwshgridview": {
            "title": "调动查看",
            "caption": "调动查看",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxDDSQWSHGridView",
            "viewtag": "c3fe6d0bf42e7bfa5db3e5ff7f1c76c8"
        },
        "ormpostorgidpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostORGIDPickupView",
            "viewtag": "c507f3bdcb7df05aef06e375f29a9a9c"
        },
        "ormorgsectorpickupview": {
            "title": "部门管理数据选择视图",
            "caption": "部门管理",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmOrgsectorPickupView",
            "viewtag": "c56eb0c8dc84112d4f696ea5066e1c8c"
        },
        "ormpostpickupview": {
            "title": "岗位管理数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ORM",
            "viewname": "OrmPostPickupView",
            "viewtag": "c5f651d460c0e56f27bebf49905d0afc"
        },
        "pcmddsqdmxsqjdsheditview": {
            "title": "借调明细编辑视图",
            "caption": "调动申请单明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxSQJDSHEditView",
            "viewtag": "c8721c32bf976163f024d614ff156b70"
        },
        "pimdistirbutionpickupview": {
            "title": "分配信息数据选择视图",
            "caption": "分配信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionPickupView",
            "viewtag": "c8742acfe50656da3fdd23bdb49b8432"
        },
        "pcmjxsygzzsqjxszzsqjmeditview": {
            "title": "见习生员工转正",
            "caption": "见习生员工转正申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmJxsygzzsqJXSZZSQJMEditView",
            "viewtag": "c9d851de066f529a7ede68865f9067af"
        },
        "pcmydjzmxpickupgridview": {
            "title": "异动兼职明细选择表格视图",
            "caption": "异动兼职明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxPickupGridView",
            "viewtag": "ca70101b76c2aaf440708283ee7a3142"
        },
        "pcmddsqdmxddsqgridview": {
            "title": "调动申请",
            "caption": "调动申请单明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxDDSQGridView",
            "viewtag": "cabb53f72918b0ffb8a7688faa19af0c"
        },
        "ormorgsectorydbmpickupview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgsectorYDBMPickupView",
            "viewtag": "cacc02b66fa71b9e6d8a326469c643d3"
        },
        "pcmydgzmxtype_gzceditview3": {
            "title": "异动挂职明细编辑视图(挂职出)",
            "caption": "异动挂职明细",
            "viewtype": "DEEDITVIEW3",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxTYPE_GZCEditView3",
            "viewtag": "cba4cbdc06707a0fe65d285c479d827c"
        },
        "pcmydjpmxckeditview": {
            "title": "异动解聘明细",
            "caption": "异动解聘明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxCKEditView",
            "viewtag": "cbe113145c7cda2dc98b928056c33107"
        },
        "pcmxygzzsqeditview": {
            "title": "试用期员工转正申请编辑视图",
            "caption": "试用期员工转正申请",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzsqEditView",
            "viewtag": "ccdc9bfae5d1ca066e16c5b5e674f7b2"
        },
        "pcmyddgmxeditview9": {
            "title": "待岗明细信息",
            "caption": "待岗明细信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxEditView9",
            "viewtag": "ce973658492cf60faa71d3b68bd858d1"
        },
        "ormpostejormorgidpickupgridview": {
            "title": "岗位选择",
            "caption": "岗位选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmPostEJORMORGIDPickupGridView",
            "viewtag": "cfc635a27bc52bbbccd7104aba9f8cd4"
        },
        "ormorgmpickupview": {
            "title": "组织管理数据多项选择视图",
            "caption": "组织管理",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgMPickupView",
            "viewtag": "d11e0e5a43b51d8f4d5d8dfc9bcb3128"
        },
        "pcmydlzmxlsjlgridview": {
            "title": "离职记录",
            "caption": "离职记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxLSJLGridView",
            "viewtag": "d2a7679ac32cbd0cf6b21f54c1113595"
        },
        "pcmyddgmxpickupview": {
            "title": "异动待岗明细数据选择视图",
            "caption": "异动待岗明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxPickupView",
            "viewtag": "d33f85d0b65ac2eede9b679821260c91"
        },
        "ormorgsjyxzzpickupgridview": {
            "title": "组织选择",
            "caption": "组织选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgSJYXZZPickupGridView",
            "viewtag": "d34ab422ca03ac4f98e2d87fdba8c3c5"
        },
        "pcmddsqdmxpickupgridview": {
            "title": "调动申请单明细选择表格视图",
            "caption": "调动申请单明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxPickupGridView",
            "viewtag": "d502fb0084c8e5b3d423a89af1522544"
        },
        "pcmydtxmxjlgridview": {
            "title": "退休记录",
            "caption": "退休记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxJLGridView",
            "viewtag": "d531e69b24c75cc779f57c2a45152243"
        },
        "pimdistirbutionddcoptionview": {
            "title": "调出",
            "caption": "分配信息",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionDDCOptionView",
            "viewtag": "d54722f265cb0c770a693ca748a95bd5"
        },
        "pcmydntmxeditview9": {
            "title": "内退明细信息",
            "caption": "内退明细信息",
            "viewtype": "DEEDITVIEW9",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxEditView9",
            "viewtag": "d5bc5dbf5ec9e9da8f2f80b549e8bbf6"
        },
        "pcmydgzmxpickupgridview": {
            "title": "异动挂职明细选择表格视图",
            "caption": "异动挂职明细",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxPickupGridView",
            "viewtag": "d69d2e874578cbefa7eb773344a14c8c"
        },
        "pcmddsqdmxeditview": {
            "title": "调动申请明细",
            "caption": "调动申请明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxEditView",
            "viewtag": "d754cb941b0de239e7e88c9c8bbfc1d0"
        },
        "ormorgsectorydbmpickupgridview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgsectorYDBMPickupGridView",
            "viewtag": "d88ac323387ec407f54f95a2317ad050"
        },
        "pcmyddgmxckeditview": {
            "title": "异动病休明细",
            "caption": "异动待岗明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxCKEditView",
            "viewtag": "da71cb260f0c8913bc32c357a3e352aa"
        },
        "pcmydjdmxpickupview": {
            "title": "异动借调明细数据选择视图",
            "caption": "异动借调明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjdmxPickupView",
            "viewtag": "da84e14fffd9312f88822a474249ac96"
        },
        "index": {
            "title": "EHR-人员异动管理",
            "caption": "EHR-人员异动管理",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "PCM",
            "viewname": "Index",
            "viewtag": "DACC39C3-357A-41E2-A9B7-382C3FE1FA9A"
        },
        "pcmydntmxntglgridview": {
            "title": "内退管理",
            "caption": "内退管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxNTGLGridView",
            "viewtag": "dbdb48c6a8f3668e25609bac1c4d73de"
        },
        "pcmydbxmxxzeditview": {
            "title": "新增病休",
            "caption": "异动病休明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxXZEditView",
            "viewtag": "dd733da3c7297bc660f8119607576f4d"
        },
        "pcmddsqdmxlgsqmxeditview": {
            "title": "轮岗申请明细",
            "caption": "轮岗申请明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmDdsqdmxLGSQMXEditView",
            "viewtag": "df0b54408a34dc0a8c7c3c9ee9310e7c"
        },
        "pimdistirbutionjddqgridview": {
            "title": "借调人员",
            "caption": "借调人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionJDDQGridView",
            "viewtag": "dfacd62b44a679bc0409d0f876a42bf9"
        },
        "pcmydntmxeditview": {
            "title": "异动内退明细",
            "caption": "异动内退明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxEditView",
            "viewtag": "e03ad9a83084a41ec95f26f7aa38f448"
        },
        "pcmydbxmxpickupview": {
            "title": "异动病休明细数据选择视图",
            "caption": "异动病休明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxPickupView",
            "viewtag": "e1e3af2a358389fa856b6f4fdeba28f2"
        },
        "pcmydbxmxckeditview": {
            "title": "异动病休明细",
            "caption": "异动病休明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxCKEditView",
            "viewtag": "e21d224e74b80c0d56750a5dcf7d9192"
        },
        "pimpersonpickupview": {
            "title": "人员信息数据选择视图",
            "caption": "人员信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonPickupView",
            "viewtag": "e24e284009007c8c0190582460d38f0c"
        },
        "pcmydlzmxeditview2": {
            "title": "异动离职明细编辑视图",
            "caption": "异动离职明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYdlzmxEditView2",
            "viewtag": "e2f17dc1b362d356d85b44c45a0601ee"
        },
        "pcmydjzmxredirectview": {
            "title": "异动兼职明细数据重定向视图",
            "caption": "异动兼职明细",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxRedirectView",
            "viewtag": "e35dfcf60724baf88634f4eba6f6b272"
        },
        "pcmydjzmxeditview": {
            "title": "异动兼职明细编辑视图",
            "caption": "异动兼职明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxEditView",
            "viewtag": "e3d460cef63d656feba9ecc50731a3f3"
        },
        "pcmyddgmxmpickupview": {
            "title": "异动待岗明细数据多项选择视图",
            "caption": "异动待岗明细",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxMPickupView",
            "viewtag": "e58b0632b9beb66d7b86e34d2794cda7"
        },
        "ormorgpickupgridview": {
            "title": "组织管理选择表格视图",
            "caption": "组织管理",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgPickupGridView",
            "viewtag": "e6520ea6af395c725510a4c669951fde"
        },
        "pcmydjzmxxzeditview": {
            "title": "新增兼职",
            "caption": "新增兼职",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxXZEditView",
            "viewtag": "e6bbb2fdf41c855fb2471658e7706248"
        },
        "ormdutyorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmDutyOrgSectorPickupGridView",
            "viewtag": "e83f9ac4f1341d4021acd08a534c67b8"
        },
        "pcmprofilegzjryeditview": {
            "title": "挂职进人员信息",
            "caption": "应聘者基本信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmProfileGZJRYEditView",
            "viewtag": "e8a71f2daabc7af8748d5c702989e250"
        },
        "pcmydntmxgridview": {
            "title": "异动内退明细表",
            "caption": "异动内退明细",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxGridView",
            "viewtag": "e8c3c785a43c571c649829ad78a99f44"
        },
        "ormorgfpxxpickupgridview": {
            "title": "组织选择表格视图",
            "caption": "组织选择表格视图",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgFPXXPickupGridView",
            "viewtag": "e9aa846ecbaa2cf1f4ce1b83ce16c349"
        },
        "ormdutyormorgsectorpickupgridview": {
            "title": "职务库",
            "caption": "职务库",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmDutyOrmOrgSectorPickupGridView",
            "viewtag": "ead6bcb9ad344e016c06871145ae609b"
        },
        "pimdistirbutionkddpickupview": {
            "title": "可调动的分配",
            "caption": "分配信息",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionKDDPickupView",
            "viewtag": "ebb043cf58054089938d982a7fafa0be"
        },
        "pcmyddgmxdgjlgridview": {
            "title": "待岗记录",
            "caption": "待岗记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxDGJLGridView",
            "viewtag": "eef112819fd5981e294172049439758a"
        },
        "pcmydntmxntjsrqqreditview": {
            "title": "请确认/修改内退结束日期",
            "caption": "异动内退明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxNTJSRQQREditView",
            "viewtag": "efb790310f26eb833d6115de419d039b"
        },
        "pcmydntmxntjlgridview": {
            "title": "内退记录",
            "caption": "内退记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdntmxNTJLGridView",
            "viewtag": "f221ce8415e9f9f91e8f1d7a390294b5"
        },
        "pimdistirbutiongridview": {
            "title": "分配信息表格视图",
            "caption": "分配信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionGridView",
            "viewtag": "f258817b8e2c6392f3079a7e380e0dcb"
        },
        "pcmydgzmxgzrglgridview": {
            "title": "挂职调入",
            "caption": "挂职调入",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdgzmxGZRGLGridView",
            "viewtag": "f3643aaced44ed1a742b4ad5ffa29399"
        },
        "pimdistirbutionpickupgridview": {
            "title": "分配信息选择表格视图",
            "caption": "分配信息",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimDistirbutionPickupGridView",
            "viewtag": "f36d97311f976fed4a7a6b253fd77176"
        },
        "pimpersonsqjxqzzgridview": {
            "title": "见习期转正申请",
            "caption": "见习期转正申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonSQJXQZZGridView",
            "viewtag": "f3e7742ed5683077e42010283b9996b6"
        },
        "pcmydjzmxjlckeditview": {
            "title": "异动兼职明细",
            "caption": "异动兼职明细",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjzmxJLCKEditView",
            "viewtag": "f415a9d733d30fc871f2b913161e5bc3"
        },
        "pcmydbxmxeditview2": {
            "title": "异动病休明细编辑视图",
            "caption": "异动病休明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYdbxmxEditView2",
            "viewtag": "f608f6b589e199609bf5405fb457d2c6"
        },
        "pcmyddgmxeditview2": {
            "title": "异动待岗明细编辑视图",
            "caption": "异动待岗明细",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxEditView2",
            "viewtag": "f6454b5a7c7467c1f6bce56b0e13e3ad"
        },
        "ormorgsectorfpxxpickupview": {
            "title": "部门选择",
            "caption": "部门选择",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "OrmOrgsectorFPXXPickupView",
            "viewtag": "f6cbf1fae6d1d16e04649f31728c7bed"
        },
        "pimpersonsqsyqzzgridview": {
            "title": "试用期转正申请",
            "caption": "试用期转正申请",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PimPersonSQSYQZZGridView",
            "viewtag": "f88aeef09f6cf239b0d9fad901c62efd"
        },
        "pcmyddgmxxzeditview": {
            "title": "新增待岗",
            "caption": "新增待岗",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYddgmxXZEditView",
            "viewtag": "f8e8d3d1a30cdb1de8e896725f4722e4"
        },
        "pcmxygzzkhjgjlpickupgridview": {
            "title": "新员工转正考核结果记录选择表格视图",
            "caption": "试用期员工转正考核结果记录",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmXygzzkhjgjlPickupGridView",
            "viewtag": "fca052e638e60cff1070e6ae9bafc0b3"
        },
        "pcmydjpmxpickupview": {
            "title": "异动解聘明细数据选择视图",
            "caption": "异动解聘明细",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdjpmxPickupView",
            "viewtag": "fcc7b3bd6b693c69864959d90b000691"
        },
        "pcmydtxmxgridview": {
            "title": "退休记录",
            "caption": "退休记录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "PCM",
            "viewname": "PcmYdtxmxGridView",
            "viewtag": "ffdf242c2dbce056131f61cf5fdbf54c"
        }
    }];
});