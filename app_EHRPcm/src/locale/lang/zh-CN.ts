import pcmworkresume_zh_CN from '@locale/lanres/pcmworkresume/pcmworkresume_zh_CN';
import pcmprofileapproval_zh_CN from '@locale/lanres/pcmprofileapproval/pcmprofileapproval_zh_CN';
import pcmgxml_zh_CN from '@locale/lanres/pcmgxml/pcmgxml_zh_CN';
import ormorg_zh_CN from '@locale/lanres/orm-org/orm-org_zh_CN';
import pcmpracticeexperience_zh_CN from '@locale/lanres/pcmpracticeexperience/pcmpracticeexperience_zh_CN';
import ormduty_zh_CN from '@locale/lanres/ormduty/ormduty_zh_CN';
import pimcity_zh_CN from '@locale/lanres/pimcity/pimcity_zh_CN';
import pcmprofileinitnumber_zh_CN from '@locale/lanres/pcmprofileinitnumber/pcmprofileinitnumber_zh_CN';
import pimstafftype_zh_CN from '@locale/lanres/pimstafftype/pimstafftype_zh_CN';
import pcmprofileszyjtj_zh_CN from '@locale/lanres/pcmprofileszyjtj/pcmprofileszyjtj_zh_CN';
import pcmxkml_zh_CN from '@locale/lanres/pcmxkml/pcmxkml_zh_CN';
import pcmprofileyjtjtemp_zh_CN from '@locale/lanres/pcm-profile-yjtj-temp/pcm-profile-yjtj-temp_zh_CN';
import pcmprofilespyy_zh_CN from '@locale/lanres/pcmprofilespyy/pcmprofilespyy_zh_CN';
import ormqygl_zh_CN from '@locale/lanres/ormqygl/ormqygl_zh_CN';
import pcmprofilefj_zh_CN from '@locale/lanres/pcm-profile-fj/pcm-profile-fj_zh_CN';
import pcmzpmeglmx_zh_CN from '@locale/lanres/pcmzpmeglmx/pcmzpmeglmx_zh_CN';
import codeitem_zh_CN from '@locale/lanres/code-item/code-item_zh_CN';
import pcmprofilenumbeprefix_zh_CN from '@locale/lanres/pcm-profile-num-beprefix/pcm-profile-num-beprefix_zh_CN';
import pcmcertofreg_zh_CN from '@locale/lanres/pcm-certofreg/pcm-certofreg_zh_CN';
import tdzwxx_zh_CN from '@locale/lanres/tdzwxx/tdzwxx_zh_CN';
import codelist1_zh_CN from '@locale/lanres/code-list1/code-list1_zh_CN';
import ormorgsector_zh_CN from '@locale/lanres/orm-orgsector/orm-orgsector_zh_CN';
import pcmschooloffice_zh_CN from '@locale/lanres/pcm-school-office/pcm-school-office_zh_CN';
import testresult_zh_CN from '@locale/lanres/test-result/test-result_zh_CN';
import pcmzpmegl_zh_CN from '@locale/lanres/pcmzpmegl/pcmzpmegl_zh_CN';
import pcmprofile_zh_CN from '@locale/lanres/pcm-profile/pcm-profile_zh_CN';
import pcmawardswons_zh_CN from '@locale/lanres/pcmawardswons/pcmawardswons_zh_CN';
import pcmeducationexperience_zh_CN from '@locale/lanres/pcmeducation-experience/pcmeducation-experience_zh_CN';
import ormpost_zh_CN from '@locale/lanres/orm-post/orm-post_zh_CN';
import pimqualmajor_zh_CN from '@locale/lanres/pim-qual-major/pim-qual-major_zh_CN';
import wzd0001_zh_CN from '@locale/lanres/wzd0001/wzd0001_zh_CN';
import pimperson_zh_CN from '@locale/lanres/pimperson/pimperson_zh_CN';
import pcmgxxktemp_zh_CN from '@locale/lanres/pcmgxxk-temp/pcmgxxk-temp_zh_CN';
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
                caption: 'EHR—招聘管理',
                title: 'EHR—招聘管理',
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
        },
        menus: {
            index: {
                menuitem2: '校园招聘',
                menuitem1: '应聘者',
                menuitem3: '用人单位审核',
                menuitem4: '人力上报',
                menuitem5: '总部审核',
                menuitem6: '编号审批',
                menuitem7: '拟录用人员',
                menuitem8: '成熟人才引进',
                menuitem9: '应聘者',
                menuitem10: '用人单位审核',
                menuitem11: '人力上报',
                menuitem12: '总部审核',
                menuitem13: '编号审批',
                menuitem14: '拟录用人员',
                menuitem15: '标准化数据设置',
                menuitem16: '招聘名额管理',
                menuitem17: '高校名录',
                menuitem18: '学科目录',
                menuitem19: '应聘者审批原因',
            },
        },
    },
    entities: {
        pcmworkresume: pcmworkresume_zh_CN,
        pcmprofileapproval: pcmprofileapproval_zh_CN,
        pcmgxml: pcmgxml_zh_CN,
        ormorg: ormorg_zh_CN,
        pcmpracticeexperience: pcmpracticeexperience_zh_CN,
        ormduty: ormduty_zh_CN,
        pimcity: pimcity_zh_CN,
        pcmprofileinitnumber: pcmprofileinitnumber_zh_CN,
        pimstafftype: pimstafftype_zh_CN,
        pcmprofileszyjtj: pcmprofileszyjtj_zh_CN,
        pcmxkml: pcmxkml_zh_CN,
        pcmprofileyjtjtemp: pcmprofileyjtjtemp_zh_CN,
        pcmprofilespyy: pcmprofilespyy_zh_CN,
        ormqygl: ormqygl_zh_CN,
        pcmprofilefj: pcmprofilefj_zh_CN,
        pcmzpmeglmx: pcmzpmeglmx_zh_CN,
        codeitem: codeitem_zh_CN,
        pcmprofilenumbeprefix: pcmprofilenumbeprefix_zh_CN,
        pcmcertofreg: pcmcertofreg_zh_CN,
        tdzwxx: tdzwxx_zh_CN,
        codelist1: codelist1_zh_CN,
        ormorgsector: ormorgsector_zh_CN,
        pcmschooloffice: pcmschooloffice_zh_CN,
        testresult: testresult_zh_CN,
        pcmzpmegl: pcmzpmegl_zh_CN,
        pcmprofile: pcmprofile_zh_CN,
        pcmawardswons: pcmawardswons_zh_CN,
        pcmeducationexperience: pcmeducationexperience_zh_CN,
        ormpost: ormpost_zh_CN,
        pimqualmajor: pimqualmajor_zh_CN,
        wzd0001: wzd0001_zh_CN,
        pimperson: pimperson_zh_CN,
        pcmgxxktemp: pcmgxxktemp_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};