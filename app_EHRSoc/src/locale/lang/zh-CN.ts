import socarea_zh_CN from '@locale/lanres/entities/soc-area/soc-area_zh_CN';
import socarchives_zh_CN from '@locale/lanres/entities/soc-archives/soc-archives_zh_CN';
import soctype_zh_CN from '@locale/lanres/entities/soc-type/soc-type_zh_CN';
import socrule_zh_CN from '@locale/lanres/entities/soc-rule/soc-rule_zh_CN';
import ormorg_zh_CN from '@locale/lanres/entities/orm-org/orm-org_zh_CN';
import socrecord_zh_CN from '@locale/lanres/entities/soc-record/soc-record_zh_CN';
import socaccount_zh_CN from '@locale/lanres/entities/soc-account/soc-account_zh_CN';
import socarchivesdetail_zh_CN from '@locale/lanres/entities/soc-archives-detail/soc-archives-detail_zh_CN';
import socruledetail_zh_CN from '@locale/lanres/entities/soc-rule-detail/soc-rule-detail_zh_CN';
import pimperson_zh_CN from '@locale/lanres/entities/pim-person/pim-person_zh_CN';
import codeitem_zh_CN from '@locale/lanres/entities/code-item/code-item_zh_CN';
import personstatemgr_zh_CN from '@locale/lanres/entities/person-state-mgr/person-state-mgr_zh_CN';
import codelist1_zh_CN from '@locale/lanres/entities/code-list1/code-list1_zh_CN';
import components_zh_CN from '@locale/lanres/components/components_zh_CN';
import codelist_zh_CN from '@locale/lanres/codelist/codelist_zh_CN';
import userCustom_zh_CN from '@locale/lanres/userCustom/userCustom_zh_CN';

export default {
    app: {
        commonWords:{
            error: "失败",
            success: "成功",
            ok: "确认",
            cancel: "取消",
        },
        local:{
            new: "新建"
        },
        gridpage: {
            choicecolumns: "选择列",
            refresh: "刷新",
            show: "显示",
            records: "条",
            totle: "共",
        },
        tabpage: {
            sureclosetip: {
                title: "关闭提醒",
                content: "表单数据已经修改，确定要关闭？",
            },
            closeall: "关闭所有",
            closeother: "关闭其他",
        },
        fileUpload: {
            caption: "上传",
        },
        searchButton: {
            search: "搜索",
            reset: "重置",
        },
        calendar:{
          today: "今天",
          month: "月",
          week: "周",
          day: "天",
          list: "列",
          dateSelectModalTitle: "选择要跳转的时间",
          gotoDate: "跳转",
        },
        // 非实体视图
        views: {
            index: {
                caption: "EHR—社保管理",
                title: "EHR—社保管理",
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
        },
        menus: {
            index: {
                menuitem1: "社保规则",
                menuitem2: "参保地",
                menuitem3: "参保账户",
                menuitem4: "保险类型",
                menuitem5: "社保规则",
                menuitem7: "社保档案",
                menuitem6: "员工社保档案",
                menuitem8: "员工社保设置",
                menuitem9: "非员工终止社保",
            },
        },
    },
    entities: {
        socarea: socarea_zh_CN,
        socarchives: socarchives_zh_CN,
        soctype: soctype_zh_CN,
        socrule: socrule_zh_CN,
        ormorg: ormorg_zh_CN,
        socrecord: socrecord_zh_CN,
        socaccount: socaccount_zh_CN,
        socarchivesdetail: socarchivesdetail_zh_CN,
        socruledetail: socruledetail_zh_CN,
        pimperson: pimperson_zh_CN,
        codeitem: codeitem_zh_CN,
        personstatemgr: personstatemgr_zh_CN,
        codelist1: codelist1_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};