<script lang='tsx'>
import { Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { AppMenusCtrlBase } from '@/crm-core';
import ZIZHUService from './zizhu-appmenu-service';

import ZIZHUModel from './zizhu-appmenu-model';


/**
 * 员工自助基类
 *
 * @export
 * @class ZIZHUBase
 * @extends {AppMenusCtrlBase}
 */
export default class ZIZHUBase extends AppMenusCtrlBase {

    /**
     * 建构部件服务对象
     *
     * @type {ZIZHUService}
     * @memberof ZIZHU
     */
    public service: ZIZHUService = new ZIZHUService({ $store: this.$store });

    /**
     * 菜单对齐方向
     *
     * @type {CrmIndexService}
     * @memberof CrmIndex
     */
    protected menuAlign: string = 'LEFT';

    /**
     * 菜单模型
     *
     * @protected
     * @type {ZIZHUModel}
     * @memberof ZIZHU
     */
    protected menuModel: ZIZHUModel = new ZIZHUModel();

    /**
     * 触发方式，默认click
     *
     * @type {string}
     * @memberof ZIZHU
     */
    @Provide()
    public trigger: string = 'click';

    /**
     * 菜单点击
     *
     * @protected
     * @param {*} item 菜单数据
     * @memberof ZIZHU
     */
    protected click(item: any) {
        if (item) {
            switch (item.appfunctag) {
                case 'Auto180': 
                    this.clickAuto180(item);
                    return;
                case 'Auto311': 
                    this.clickAuto311(item);
                    return;
                case 'Auto385': 
                    this.clickAuto385(item);
                    return;
                case 'Auto5': 
                    this.clickAuto5(item);
                    return;
                case 'Auto58': 
                    this.clickAuto58(item);
                    return;
                case 'Auto57': 
                    this.clickAuto57(item);
                    return;
                case 'Auto87': 
                    this.clickAuto87(item);
                    return;
                case 'Auto110': 
                    this.clickAuto110(item);
                    return;
                case 'Auto400': 
                    this.clickAuto400(item);
                    return;
                case 'Auto430': 
                    this.clickAuto430(item);
                    return;
                case 'Auto178': 
                    this.clickAuto178(item);
                    return;
                case 'Auto416': 
                    this.clickAuto416(item);
                    return;
                case 'Auto319': 
                    this.clickAuto319(item);
                    return;
                case 'Auto297': 
                    this.clickAuto297(item);
                    return;
                case 'Auto276': 
                    this.clickAuto276(item);
                    return;
                case 'Auto56': 
                    this.clickAuto56(item);
                    return;
                case 'Auto272': 
                    this.clickAuto272(item);
                    return;
                case 'Auto36': 
                    this.clickAuto36(item);
                    return;
                case 'Auto159': 
                    this.clickAuto159(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 绩效信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto180(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimachievements', parameterName: 'pimachievements' },
            { pathName: 'grpimjixgridview', parameterName: 'grpimjixgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 语言信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto311(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
            { pathName: 'gryynlgridview', parameterName: 'gryynlgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 科研成果
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto385(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
            { pathName: 'grresearchgridview', parameterName: 'grresearchgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 出入境管理
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto5(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
            { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 家庭信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto58(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
            { pathName: 'grpimfimgridview', parameterName: 'grpimfimgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 合同信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto57(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
            { pathName: 'grcontractgridview', parameterName: 'grcontractgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 教育信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto87(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimeducations', parameterName: 'pimeducation' },
            { pathName: 'grpimedugridview', parameterName: 'grpimedugridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 工作履历
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto110(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
            { pathName: 'grpimworkgridview', parameterName: 'grpimworkgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 个人自助信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto400(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {"srfkey":"person"});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'grzzeditview', parameterName: 'grzzeditview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 职称管理
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto430(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimtitles', parameterName: 'pimtitle' },
            { pathName: 'grpimzhicgridview', parameterName: 'grpimzhicgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 奖惩信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto178(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
            { pathName: 'grpimjanglgridview', parameterName: 'grpimjanglgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 军转干部
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto416(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
            { pathName: 'grarmygridview', parameterName: 'grarmygridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 专利信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto319(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpatents', parameterName: 'pimpatent' },
            { pathName: 'grpatentgridview', parameterName: 'grpatentgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 附件预览
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto297(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimenclosures', parameterName: 'pimenclosure' },
        ];
        const view = { 
            viewname: 'pimenclosurefile-pre-view-custom-view', 
            title: (this.$t('entities.pimenclosure.views.filepreviewcustomview.title') as any),
            height: 0, 
            width: 0, 
        };
        const appmodal = this.$appmodal.openModal(view, JSON.parse(JSON.stringify(this.context)),viewparam);
        appmodal.subscribe((result: any) => {
            console.log(result);
        });
    }
    
    /**
     * 档案信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto276(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimarchives', parameterName: 'pimarchives' },
            { pathName: 'grpimdangagridview', parameterName: 'grpimdangagridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 论文信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto56(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpapers', parameterName: 'pimpaper' },
            { pathName: 'grpapergridview', parameterName: 'grpapergridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 证书信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto272(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
            { pathName: 'grpimziggridview', parameterName: 'grpimziggridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 休假申请
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto36(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
            { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 分配信息
     *
     * @param {*} [item={}]
     * @memberof ZIZHU
     */
    public clickAuto159(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
            { pathName: 'grpimfenpgridview', parameterName: 'grpimfenpgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }

    public render(): any {
        return (
            <div class="app-app-menu">
                <app-menus menuAlign={this.menuAlign} menus={this.menus} on-menu-click={(item: any) => this.click(item)}/>
            </div>
        );
    }
    
}
</script>

<style lang='less'>
@import './zizhu-appmenu.less';
</style>