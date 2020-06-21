import socarea_en_US from '@locale/lanres/entities/soc-area/soc-area_en_US';
import socarchives_en_US from '@locale/lanres/entities/soc-archives/soc-archives_en_US';
import soctype_en_US from '@locale/lanres/entities/soc-type/soc-type_en_US';
import socrule_en_US from '@locale/lanres/entities/soc-rule/soc-rule_en_US';
import ormorg_en_US from '@locale/lanres/entities/orm-org/orm-org_en_US';
import socrecord_en_US from '@locale/lanres/entities/soc-record/soc-record_en_US';
import socaccount_en_US from '@locale/lanres/entities/soc-account/soc-account_en_US';
import socarchivesdetail_en_US from '@locale/lanres/entities/soc-archives-detail/soc-archives-detail_en_US';
import socruledetail_en_US from '@locale/lanres/entities/soc-rule-detail/soc-rule-detail_en_US';
import pimperson_en_US from '@locale/lanres/entities/pim-person/pim-person_en_US';
import codeitem_en_US from '@locale/lanres/entities/code-item/code-item_en_US';
import personstatemgr_en_US from '@locale/lanres/entities/person-state-mgr/person-state-mgr_en_US';
import codelist1_en_US from '@locale/lanres/entities/code-list1/code-list1_en_US';
import components_en_US from '@locale/lanres/components/components_en_US';
import codelist_en_US from '@locale/lanres/codelist/codelist_en_US';
import userCustom_en_US from '@locale/lanres/userCustom/userCustom_en_US';

export default {
    app: {
        commonWords:{
            error: "Error",
            success: "Success",
            ok: "OK",
            cancel: "Cancel",
        },
        local:{
            new: "New"
        },
        gridpage: {
            choicecolumns: "Choice columns",
            refresh: "refresh",
            show: "Show",
            records: "records",
            totle: "totle",
        },
        tabpage: {
            sureclosetip: {
                title: "Close warning",
                content: "Form data Changed, are sure close?",
            },
            closeall: "Close all",
            closeother: "Close other",
        },
        fileUpload: {
            caption: "Upload",
        },
        searchButton: {
            search: "Search",
            reset: "Reset",
        },
        calendar:{
          today: "today",
          month: "month",
          week: "week",
          day: "day",
          list: "list",
          dateSelectModalTitle: "select the time you wanted",
          gotoDate: "goto",
        },
        // 非实体视图
        views: {
            index: {
                caption: "EHR—社保管理",
                title: "EHR—社保管理",
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
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
        socarea: socarea_en_US,
        socarchives: socarchives_en_US,
        soctype: soctype_en_US,
        socrule: socrule_en_US,
        ormorg: ormorg_en_US,
        socrecord: socrecord_en_US,
        socaccount: socaccount_en_US,
        socarchivesdetail: socarchivesdetail_en_US,
        socruledetail: socruledetail_en_US,
        pimperson: pimperson_en_US,
        codeitem: codeitem_en_US,
        personstatemgr: personstatemgr_en_US,
        codelist1: codelist1_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};