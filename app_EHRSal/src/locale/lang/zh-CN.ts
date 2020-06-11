import salscheme_zh_CN from '@locale/lanres/entities/sal-scheme/sal-scheme_zh_CN';
import salruledetail_zh_CN from '@locale/lanres/entities/sal-rule-detail/sal-rule-detail_zh_CN';
import salrule_zh_CN from '@locale/lanres/entities/sal-rule/sal-rule_zh_CN';
import salsource_zh_CN from '@locale/lanres/entities/sal-source/sal-source_zh_CN';
import salparam_zh_CN from '@locale/lanres/entities/sal-param/sal-param_zh_CN';
import ormorg_zh_CN from '@locale/lanres/entities/orm-org/orm-org_zh_CN';
import salsubject_zh_CN from '@locale/lanres/entities/sal-subject/sal-subject_zh_CN';
import saltype_zh_CN from '@locale/lanres/entities/sal-type/sal-type_zh_CN';
import salitem_zh_CN from '@locale/lanres/entities/sal-item/sal-item_zh_CN';
import salschemeitem_zh_CN from '@locale/lanres/entities/sal-scheme-item/sal-scheme-item_zh_CN';
import codelist1_zh_CN from '@locale/lanres/entities/code-list1/code-list1_zh_CN';
import salstdgwgz_zh_CN from '@locale/lanres/entities/sal-stdgwgz/sal-stdgwgz_zh_CN';
import salstdxmgz_zh_CN from '@locale/lanres/entities/sal-std-xmgz/sal-std-xmgz_zh_CN';
import ormduty_zh_CN from '@locale/lanres/entities/orm-duty/orm-duty_zh_CN';
import codeitem_zh_CN from '@locale/lanres/entities/code-item/code-item_zh_CN';
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
                caption: 'EHR—薪酬管理',
                title: 'EHR—薪酬管理',
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
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
                menuitem8: '薪酬标准',
                menuitem11: '岗位工资标准',
                menuitem12: '项目工资标准',
                menuitem13: '工龄工资标准',
                menuitem14: '技术津贴标准',
                menuitem15: '专项津贴标准',
                menuitem21: '执业资格津贴标准',
                menuitem22: '独生子女标准',
                menuitem23: '高温津贴标准',
                menuitem9: '员工薪酬档案',
                menuitem16: '员工薪酬档案',
                menuitem17: '员工薪酬档案确认',
                menuitem10: '薪酬管理',
                menuitem18: '薪酬计算计划',
                menuitem19: '员工工资',
                menuitem20: '薪酬调整日志',
            },
        },
    },
    entities: {
        salscheme: salscheme_zh_CN,
        salruledetail: salruledetail_zh_CN,
        salrule: salrule_zh_CN,
        salsource: salsource_zh_CN,
        salparam: salparam_zh_CN,
        ormorg: ormorg_zh_CN,
        salsubject: salsubject_zh_CN,
        saltype: saltype_zh_CN,
        salitem: salitem_zh_CN,
        salschemeitem: salschemeitem_zh_CN,
        codelist1: codelist1_zh_CN,
        salstdgwgz: salstdgwgz_zh_CN,
        salstdxmgz: salstdxmgz_zh_CN,
        ormduty: ormduty_zh_CN,
        codeitem: codeitem_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};