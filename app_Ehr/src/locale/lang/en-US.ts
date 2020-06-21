import pimtitle_en_US from '@locale/lanres/entities/pim-title/pim-title_en_US';
import pimvocational_en_US from '@locale/lanres/entities/pim-vocational/pim-vocational_en_US';
import codelist1_en_US from '@locale/lanres/entities/code-list1/code-list1_en_US';
import pimeducation_en_US from '@locale/lanres/entities/pim-education/pim-education_en_US';
import pimperson_en_US from '@locale/lanres/entities/pim-person/pim-person_en_US';
import codeitem_en_US from '@locale/lanres/entities/code-item/code-item_en_US';
import ormorg_en_US from '@locale/lanres/entities/orm-org/orm-org_en_US';
import pimoutput_en_US from '@locale/lanres/entities/pim-output/pim-output_en_US';
import dynachart_en_US from '@locale/lanres/entities/dyna-chart/dyna-chart_en_US';
import dynadashboard_en_US from '@locale/lanres/entities/dyna-dashboard/dyna-dashboard_en_US';
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
                caption: "iBizEHR",
                title: "iBizEHR",
            },
            ehrportalview: {
                caption: "首页",
                title: "Ehr门户首页",
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            index: {
                menuitem6: "首页",
                menuitem1: "组织管理",
                menuitem2: "基础管理",
                menuitem3: "招聘管理",
                menuitem4: "人员异动",
                menuitem5: "假勤管理",
            },
        },
    },
    entities: {
        pimtitle: pimtitle_en_US,
        pimvocational: pimvocational_en_US,
        codelist1: codelist1_en_US,
        pimeducation: pimeducation_en_US,
        pimperson: pimperson_en_US,
        codeitem: codeitem_en_US,
        ormorg: ormorg_en_US,
        pimoutput: pimoutput_en_US,
        dynachart: dynachart_en_US,
        dynadashboard: dynadashboard_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};