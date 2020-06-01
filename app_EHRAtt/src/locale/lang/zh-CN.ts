import vacleavetips_zh_CN from '@locale/lanres/vac-leave-tips/vac-leave-tips_zh_CN';
import ormorg_zh_CN from '@locale/lanres/orm-org/orm-org_zh_CN';
import pimperson_zh_CN from '@locale/lanres/pim-person/pim-person_zh_CN';
import vacholidayrules_zh_CN from '@locale/lanres/vac-holiday-rules/vac-holiday-rules_zh_CN';
import attendenceormorgscetor_zh_CN from '@locale/lanres/att-endence-ormorgscetor/att-endence-ormorgscetor_zh_CN';
import ormorgsector_zh_CN from '@locale/lanres/orm-orgsector/orm-orgsector_zh_CN';
import vacholiday_zh_CN from '@locale/lanres/vac-holiday/vac-holiday_zh_CN';
import attendencesetup_zh_CN from '@locale/lanres/att-endence-setup/att-endence-setup_zh_CN';
import attendancesettings_zh_CN from '@locale/lanres/att-endance-settings/att-endance-settings_zh_CN';
import ormbmkqdz_zh_CN from '@locale/lanres/orm-bmkqdz/orm-bmkqdz_zh_CN';
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
                caption: 'EHR-假勤管理',
                title: 'EHR-假勤管理',
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
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
        vacleavetips: vacleavetips_zh_CN,
        ormorg: ormorg_zh_CN,
        pimperson: pimperson_zh_CN,
        vacholidayrules: vacholidayrules_zh_CN,
        attendenceormorgscetor: attendenceormorgscetor_zh_CN,
        ormorgsector: ormorgsector_zh_CN,
        vacholiday: vacholiday_zh_CN,
        attendencesetup: attendencesetup_zh_CN,
        attendancesettings: attendancesettings_zh_CN,
        ormbmkqdz: ormbmkqdz_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};