import ormqygl_zh_CN from '@locale/lanres/entities/orm-qygl/orm-qygl_zh_CN';
import ormpostdetails_zh_CN from '@locale/lanres/entities/orm-post-details/orm-post-details_zh_CN';
import ormsignorg_zh_CN from '@locale/lanres/entities/orm-sign-org/orm-sign-org_zh_CN';
import ormerporg_zh_CN from '@locale/lanres/entities/orm-erporg/orm-erporg_zh_CN';
import ormxmbmx_zh_CN from '@locale/lanres/entities/orm-xmbmx/orm-xmbmx_zh_CN';
import ormorginfo_zh_CN from '@locale/lanres/entities/orm-org-info/orm-org-info_zh_CN';
import codelist1_zh_CN from '@locale/lanres/entities/code-list1/code-list1_zh_CN';
import ormedition_zh_CN from '@locale/lanres/entities/orm-edition/orm-edition_zh_CN';
import ormorgdz_zh_CN from '@locale/lanres/entities/orm-orgdz/orm-orgdz_zh_CN';
import pimcontractsignorg_zh_CN from '@locale/lanres/entities/pim-contract-sign-org/pim-contract-sign-org_zh_CN';
import ormpost_zh_CN from '@locale/lanres/entities/orm-post/orm-post_zh_CN';
import ormbmkqdz_zh_CN from '@locale/lanres/entities/orm-bmkqdz/orm-bmkqdz_zh_CN';
import ormbmgwbz_zh_CN from '@locale/lanres/entities/orm-bmgwbz/orm-bmgwbz_zh_CN';
import ormrelation_zh_CN from '@locale/lanres/entities/orm-relation/orm-relation_zh_CN';
import ormpostlib_zh_CN from '@locale/lanres/entities/orm-post-lib/orm-post-lib_zh_CN';
import ormdepestman_zh_CN from '@locale/lanres/entities/orm-dep-est-man/orm-dep-est-man_zh_CN';
import ormunitedperson_zh_CN from '@locale/lanres/entities/orm-united-person/orm-united-person_zh_CN';
import pimperson_zh_CN from '@locale/lanres/entities/pim-person/pim-person_zh_CN';
import ormorg_zh_CN from '@locale/lanres/entities/orm-org/orm-org_zh_CN';
import ormqybzwh_zh_CN from '@locale/lanres/entities/orm-qybzwh/orm-qybzwh_zh_CN';
import ormduty_zh_CN from '@locale/lanres/entities/orm-duty/orm-duty_zh_CN';
import codeitem_zh_CN from '@locale/lanres/entities/code-item/code-item_zh_CN';
import ormtitle_zh_CN from '@locale/lanres/entities/orm-title/orm-title_zh_CN';
import ormxmgl_zh_CN from '@locale/lanres/entities/orm-xmgl/orm-xmgl_zh_CN';
import ormxmbq_zh_CN from '@locale/lanres/entities/orm-xmbq/orm-xmbq_zh_CN';
import ormorgsector_zh_CN from '@locale/lanres/entities/orm-orgsector/orm-orgsector_zh_CN';
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
                caption: "EHR—组织管理",
                title: "EHR—组织管理",
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
        },
        menus: {
            appindexview: {
                menuitem1: "组织管理",
                menuitem3: "组织管理",
                menuitem2: "编制查询",
                menuitem4: "标准化数据设置",
                menuitem5: "职务设置",
                menuitem9: "岗位设置",
                menuitem10: "项目标签",
                menuitem11: "法人主体维护",
                menuitem12: "法人主体设置",
            },
            orm: {
                menuitem1: "组织管理",
                menuitem2: "组织管理",
                menuitem3: "编制查询",
                menuitem4: "标准化数据设置",
                menuitem5: "职务设置",
                menuitem6: "标准岗位设置",
                menuitem7: "标准岗位查询",
                menuitem8: "岗位集设置",
                menuitem9: "补贴标准",
                menuitem10: "头衔设置",
                menuitem11: "项目标签",
                menuitem12: "ERP项目",
                menuitem13: "法人主体",
                menuitem14: "法人主体设置",
            },
        },
    },
    entities: {
        ormqygl: ormqygl_zh_CN,
        ormpostdetails: ormpostdetails_zh_CN,
        ormsignorg: ormsignorg_zh_CN,
        ormerporg: ormerporg_zh_CN,
        ormxmbmx: ormxmbmx_zh_CN,
        ormorginfo: ormorginfo_zh_CN,
        codelist1: codelist1_zh_CN,
        ormedition: ormedition_zh_CN,
        ormorgdz: ormorgdz_zh_CN,
        pimcontractsignorg: pimcontractsignorg_zh_CN,
        ormpost: ormpost_zh_CN,
        ormbmkqdz: ormbmkqdz_zh_CN,
        ormbmgwbz: ormbmgwbz_zh_CN,
        ormrelation: ormrelation_zh_CN,
        ormpostlib: ormpostlib_zh_CN,
        ormdepestman: ormdepestman_zh_CN,
        ormunitedperson: ormunitedperson_zh_CN,
        pimperson: pimperson_zh_CN,
        ormorg: ormorg_zh_CN,
        ormqybzwh: ormqybzwh_zh_CN,
        ormduty: ormduty_zh_CN,
        codeitem: codeitem_zh_CN,
        ormtitle: ormtitle_zh_CN,
        ormxmgl: ormxmgl_zh_CN,
        ormxmbq: ormxmbq_zh_CN,
        ormorgsector: ormorgsector_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};