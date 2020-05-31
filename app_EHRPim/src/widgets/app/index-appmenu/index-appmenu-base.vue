<script lang='tsx'>
import { Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { AppMenusCtrlBase } from '@/crm-core';
import IndexService from './index-appmenu-service';

import IndexModel from './index-appmenu-model';


/**
 * 基础管理默认菜单基类
 *
 * @export
 * @class IndexBase
 * @extends {AppMenusCtrlBase}
 */
export default class IndexBase extends AppMenusCtrlBase {

    /**
     * 建构部件服务对象
     *
     * @type {IndexService}
     * @memberof Index
     */
    public service: IndexService = new IndexService({ $store: this.$store });

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
     * @type {IndexModel}
     * @memberof Index
     */
    protected menuModel: IndexModel = new IndexModel();

    /**
     * 触发方式，默认click
     *
     * @type {string}
     * @memberof Index
     */
    @Provide()
    public trigger: string = 'click';

    /**
     * 菜单点击
     *
     * @protected
     * @param {*} item 菜单数据
     * @memberof Index
     */
    protected click(item: any) {
        if (item) {
            switch (item.appfunctag) {
                case 'Auto459': 
                    this.clickAuto459(item);
                    return;
                case 'Auto489': 
                    this.clickAuto489(item);
                    return;
                case 'Auto462': 
                    this.clickAuto462(item);
                    return;
                case 'Auto498': 
                    this.clickAuto498(item);
                    return;
                case 'Auto479': 
                    this.clickAuto479(item);
                    return;
                case 'Auto471': 
                    this.clickAuto471(item);
                    return;
                case 'Auto492': 
                    this.clickAuto492(item);
                    return;
                case 'Auto484': 
                    this.clickAuto484(item);
                    return;
                case 'Auto451': 
                    this.clickAuto451(item);
                    return;
                case 'Auto488': 
                    this.clickAuto488(item);
                    return;
                case 'Auto473': 
                    this.clickAuto473(item);
                    return;
                case 'Auto481': 
                    this.clickAuto481(item);
                    return;
                case 'Auto474': 
                    this.clickAuto474(item);
                    return;
                case 'Auto454': 
                    this.clickAuto454(item);
                    return;
                case 'Auto472': 
                    this.clickAuto472(item);
                    return;
                case 'Auto460': 
                    this.clickAuto460(item);
                    return;
                case 'Auto467': 
                    this.clickAuto467(item);
                    return;
                case 'Auto455': 
                    this.clickAuto455(item);
                    return;
                case 'Auto480': 
                    this.clickAuto480(item);
                    return;
                case 'Auto477': 
                    this.clickAuto477(item);
                    return;
                case 'Auto491': 
                    this.clickAuto491(item);
                    return;
                case 'Auto457': 
                    this.clickAuto457(item);
                    return;
                case 'Auto496': 
                    this.clickAuto496(item);
                    return;
                case 'Auto494': 
                    this.clickAuto494(item);
                    return;
                case 'Auto464': 
                    this.clickAuto464(item);
                    return;
                case 'Auto469': 
                    this.clickAuto469(item);
                    return;
                case 'Auto487': 
                    this.clickAuto487(item);
                    return;
                case 'Auto475': 
                    this.clickAuto475(item);
                    return;
                case 'Auto493': 
                    this.clickAuto493(item);
                    return;
                case 'Auto458': 
                    this.clickAuto458(item);
                    return;
                case 'Auto476': 
                    this.clickAuto476(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 员工不在档档案<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto459(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimarchives', parameterName: 'pimarchives' },
            { pathName: 'loyeenofilegridview', parameterName: 'loyeenofilegridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 档案转出记录<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto489(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
            { pathName: 'dadcjlgridview', parameterName: 'dadcjlgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 老干部活动管理<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto462(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmlgbcosts', parameterName: 'trmlgbcost' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 合同类型<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto498(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimtypecontracts', parameterName: 'pimtypecontract' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * Pim门户首页
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto479(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimportalview', parameterName: 'pimportalview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 初签/续签提醒<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto471(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
            { pathName: 'signremindgridview', parameterName: 'signremindgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 非员工在档档案<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto492(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimarchives', parameterName: 'pimarchives' },
            { pathName: 'noloyeenofilegridview', parameterName: 'noloyeenofilegridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 人员信息变更审核<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto484(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 档案室设置<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto451(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 证书信息<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto488(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 职称目录管理<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto473(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 合同/协议类型管理<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto481(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimcontracttypes', parameterName: 'pimcontracttype' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 合同信息<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto474(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
            { pathName: 'treeexpview', parameterName: 'treeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 终止提醒<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto454(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
            { pathName: 'stopremindgridview', parameterName: 'stopremindgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 离职员工花名册<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto472(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'lzyghmcgridview', parameterName: 'lzyghmcgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 职称信息<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto460(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimtitles', parameterName: 'pimtitle' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 借调人员花名册<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto467(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
            { pathName: 'jdryhmcgridview', parameterName: 'jdryhmcgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 因私出国境<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto455(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
            { pathName: 'yscgjgridview', parameterName: 'yscgjgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 人员花名册<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto480(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmdetails', parameterName: 'pcmdetail' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 员工信息（树导航）<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto477(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {"n_zgcode_eq":"10"});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'personinfotreeexpview', parameterName: 'personinfotreeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 执业资格专业<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto491(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 离退休员工<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto457(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'ltxyggridview', parameterName: 'ltxyggridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 执业资格类型<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto496(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 档案管理<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto494(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimarchives', parameterName: 'pimarchives' },
            { pathName: 'treeexpview', parameterName: 'treeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 黑名单<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto464(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'hmdgridview', parameterName: 'hmdgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 见习到期员工<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto469(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'jxqyggridview', parameterName: 'jxqyggridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 费用台账<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto487(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimexpaccounts', parameterName: 'pimexpaccount' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 劳务派遣公司管理<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto475(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 因公出国境<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto493(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
            { pathName: 'ygcgjgridview', parameterName: 'ygcgjgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 试用到期员工<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto458(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'syqyggridview', parameterName: 'syqyggridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 挂职人员花名册<基础管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto476(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'gzryhmcgridview', parameterName: 'gzryhmcgridview' },
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
@import './index-appmenu.less';
</style>