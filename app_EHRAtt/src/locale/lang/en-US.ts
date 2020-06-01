import vacleavetips_en_US from '@locale/lanres/vac-leave-tips/vac-leave-tips_en_US';
import ormorg_en_US from '@locale/lanres/orm-org/orm-org_en_US';
import pimperson_en_US from '@locale/lanres/pim-person/pim-person_en_US';
import vacholidayrules_en_US from '@locale/lanres/vac-holiday-rules/vac-holiday-rules_en_US';
import attendenceormorgscetor_en_US from '@locale/lanres/att-endence-ormorgscetor/att-endence-ormorgscetor_en_US';
import ormorgsector_en_US from '@locale/lanres/orm-orgsector/orm-orgsector_en_US';
import vacholiday_en_US from '@locale/lanres/vac-holiday/vac-holiday_en_US';
import attendencesetup_en_US from '@locale/lanres/att-endence-setup/att-endence-setup_en_US';
import attendancesettings_en_US from '@locale/lanres/att-endance-settings/att-endance-settings_en_US';
import ormbmkqdz_en_US from '@locale/lanres/orm-bmkqdz/orm-bmkqdz_en_US';
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
                caption: 'EHR-假勤管理',
                title: 'EHR-假勤管理',
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            index: {
                menuitem1: '考勤管理',
                menuitem2: '考勤规则',
                menuitem3: '考勤设置',
                menuitem4: '考勤记录',
                menuitem5: '考勤月报',
                menuitem6: '考勤汇总',
                menuitem7: '员工设置考勤',
                menuitem8: '非员工终止考勤',
                menuitem9: '休假管理',
                menuitem11: '请假管理',
                menuitem12: '年休假查询',
                menuitem10: '标准化数据设置',
                menuitem13: '休假类型',
                menuitem14: '考勤类型',
            },
        },
    },
    entities: {
        vacleavetips: vacleavetips_en_US,
        ormorg: ormorg_en_US,
        pimperson: pimperson_en_US,
        vacholidayrules: vacholidayrules_en_US,
        attendenceormorgscetor: attendenceormorgscetor_en_US,
        ormorgsector: ormorgsector_en_US,
        vacholiday: vacholiday_en_US,
        attendencesetup: attendencesetup_en_US,
        attendancesettings: attendancesettings_en_US,
        ormbmkqdz: ormbmkqdz_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};