import salscheme_en_US from '@locale/lanres/entities/sal-scheme/sal-scheme_en_US';
import salruledetail_en_US from '@locale/lanres/entities/sal-rule-detail/sal-rule-detail_en_US';
import salrule_en_US from '@locale/lanres/entities/sal-rule/sal-rule_en_US';
import salsource_en_US from '@locale/lanres/entities/sal-source/sal-source_en_US';
import salparam_en_US from '@locale/lanres/entities/sal-param/sal-param_en_US';
import ormorg_en_US from '@locale/lanres/entities/orm-org/orm-org_en_US';
import salsubject_en_US from '@locale/lanres/entities/sal-subject/sal-subject_en_US';
import saltype_en_US from '@locale/lanres/entities/sal-type/sal-type_en_US';
import salitem_en_US from '@locale/lanres/entities/sal-item/sal-item_en_US';
import salschemeitem_en_US from '@locale/lanres/entities/sal-scheme-item/sal-scheme-item_en_US';
import components_en_US from '@locale/lanres/components/components_en_US';
import codelist_en_US from '@locale/lanres/codelist/codelist_en_US';
import userCustom_en_US from '@locale/lanres/userCustom/userCustom_en_US';

export default {
    app: {
        commonWords:{
            error: 'Error',
            success: 'Success',
            ok: 'OK',
            cancel: 'Cancel',
        },
        gridpage: {
            choicecolumns: 'Choice columns',
            refresh: 'refresh',
            show: 'Show',
            records: 'records',
            totle: 'totle',
        },
        tabpage: {
            sureclosetip: {
                title: 'Close warning',
                content: 'Form data Changed, are sure close?',
            },
            closeall: 'Close all',
            closeother: 'Close other',
        },
        fileUpload: {
            caption: 'Upload',
        },
        searchButton: {
            search: 'Search',
            reset: 'Reset',
        },
        calendar:{
          today: 'today',
          month: 'month',
          week: 'week',
          day: 'day',
          list: 'list',
          dateSelectModalTitle: 'select the time you wanted',
          gotoDate: 'goto',
        },
        // 非实体视图
        views: {
            index: {
                caption: 'EHR—薪酬管理',
                title: 'EHR—薪酬管理',
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            index: {
                menuitem1: '基础数据',
                menuitem2: '薪酬类型',
                menuitem3: '薪酬计算源',
                menuitem4: '薪酬计算指标',
                menuitem5: '薪酬规则',
                menuitem6: '薪酬要素项',
                menuitem7: '工资单',
            },
        },
    },
    entities: {
        salscheme: salscheme_en_US,
        salruledetail: salruledetail_en_US,
        salrule: salrule_en_US,
        salsource: salsource_en_US,
        salparam: salparam_en_US,
        ormorg: ormorg_en_US,
        salsubject: salsubject_en_US,
        saltype: saltype_en_US,
        salitem: salitem_en_US,
        salschemeitem: salschemeitem_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};