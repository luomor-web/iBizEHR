import dynachart_zh_CN from '@locale/lanres/entities/dyna-chart/dyna-chart_zh_CN';
import codelist1_zh_CN from '@locale/lanres/entities/code-list1/code-list1_zh_CN';
import partzgg_zh_CN from '@locale/lanres/entities/par-tzgg/par-tzgg_zh_CN';
import dynadashboard_zh_CN from '@locale/lanres/entities/dyna-dashboard/dyna-dashboard_zh_CN';
import codeitem_zh_CN from '@locale/lanres/entities/code-item/code-item_zh_CN';
import parexamcycle_zh_CN from '@locale/lanres/entities/par-exam-cycle/par-exam-cycle_zh_CN';
import components_zh_CN from '@locale/lanres/components/components_zh_CN';
import codelist_zh_CN from '@locale/lanres/codelist/codelist_zh_CN';
import userCustom_zh_CN from '@locale/lanres/userCustom/userCustom_zh_CN';

export default {
    app: {
        commonWords:{
            error: '失败',
            success: '成功',
            ok: '确认',
            cancel: '取消',
        },
        gridpage: {
            choicecolumns: '选择列',
            refresh: '刷新',
            show: '显示',
            records: '条',
            totle: '共',
        },
        tabpage: {
            sureclosetip: {
                title: '关闭提醒',
                content: '表单数据已经修改，确定要关闭？',
            },
            closeall: '关闭所有',
            closeother: '关闭其他',
        },
        fileUpload: {
            caption: '上传',
        },
        searchButton: {
            search: '搜索',
            reset: '重置',
        },
        calendar:{
          today: '今天',
          month: '月',
          week: '周',
          day: '天',
          list: '列',
          dateSelectModalTitle: '选择要跳转的时间',
          gotoDate: '跳转',
        },
        // 非实体视图
        views: {
            index: {
                caption: 'EHR—绩效管理',
                title: 'EHR—绩效管理',
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
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
        dynachart: dynachart_zh_CN,
        codelist1: codelist1_zh_CN,
        partzgg: partzgg_zh_CN,
        dynadashboard: dynadashboard_zh_CN,
        codeitem: codeitem_zh_CN,
        parexamcycle: parexamcycle_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};