import pimtitle_zh_CN from '@locale/lanres/entities/pim-title/pim-title_zh_CN';
import pimvocational_zh_CN from '@locale/lanres/entities/pim-vocational/pim-vocational_zh_CN';
import codelist1_zh_CN from '@locale/lanres/entities/code-list1/code-list1_zh_CN';
import pimeducation_zh_CN from '@locale/lanres/entities/pim-education/pim-education_zh_CN';
import pimperson_zh_CN from '@locale/lanres/entities/pim-person/pim-person_zh_CN';
import codeitem_zh_CN from '@locale/lanres/entities/code-item/code-item_zh_CN';
import ormorg_zh_CN from '@locale/lanres/entities/orm-org/orm-org_zh_CN';
import pimoutput_zh_CN from '@locale/lanres/entities/pim-output/pim-output_zh_CN';
import dynachart_zh_CN from '@locale/lanres/entities/dyna-chart/dyna-chart_zh_CN';
import dynadashboard_zh_CN from '@locale/lanres/entities/dyna-dashboard/dyna-dashboard_zh_CN';
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
                caption: "iBizEHR",
                title: "iBizEHR",
            },
            ehrportalview: {
                caption: "首页",
                title: "Ehr门户首页",
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
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
        pimtitle: pimtitle_zh_CN,
        pimvocational: pimvocational_zh_CN,
        codelist1: codelist1_zh_CN,
        pimeducation: pimeducation_zh_CN,
        pimperson: pimperson_zh_CN,
        codeitem: codeitem_zh_CN,
        ormorg: ormorg_zh_CN,
        pimoutput: pimoutput_zh_CN,
        dynachart: dynachart_zh_CN,
        dynadashboard: dynadashboard_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};