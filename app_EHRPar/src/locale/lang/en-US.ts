import dynachart_en_US from '@locale/lanres/entities/dyna-chart/dyna-chart_en_US';
import codelist1_en_US from '@locale/lanres/entities/code-list1/code-list1_en_US';
import partzgg_en_US from '@locale/lanres/entities/par-tzgg/par-tzgg_en_US';
import dynadashboard_en_US from '@locale/lanres/entities/dyna-dashboard/dyna-dashboard_en_US';
import codeitem_en_US from '@locale/lanres/entities/code-item/code-item_en_US';
import parexamcycle_en_US from '@locale/lanres/entities/par-exam-cycle/par-exam-cycle_en_US';
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
                caption: 'EHR—绩效管理',
                title: 'EHR—绩效管理',
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            index: {
                menuitem1: '通知发布',
                menuitem7: '通知发布',
                menuitem2: '基础设置',
                menuitem6: '考核周期设置',
                menuitem3: '绩效考核',
                menuitem4: '绩效定级',
                menuitem5: '绩效应用',
            },
        },
    },
    entities: {
        dynachart: dynachart_en_US,
        codelist1: codelist1_en_US,
        partzgg: partzgg_en_US,
        dynadashboard: dynadashboard_en_US,
        codeitem: codeitem_en_US,
        parexamcycle: parexamcycle_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};