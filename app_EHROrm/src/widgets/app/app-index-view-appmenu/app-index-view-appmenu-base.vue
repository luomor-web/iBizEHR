<script lang='tsx'>
import { Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { AppMenusCtrlBase } from '@/crm-core';
import AppIndexViewService from './app-index-view-appmenu-service';

import AppIndexViewModel from './app-index-view-appmenu-model';


/**
 * 组织管理默认菜单基类
 *
 * @export
 * @class AppIndexViewBase
 * @extends {AppMenusCtrlBase}
 */
export default class AppIndexViewBase extends AppMenusCtrlBase {

    /**
     * 建构部件服务对象
     *
     * @type {AppIndexViewService}
     * @memberof AppIndexView
     */
    public service: AppIndexViewService = new AppIndexViewService({ $store: this.$store });

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
     * @type {AppIndexViewModel}
     * @memberof AppIndexView
     */
    protected menuModel: AppIndexViewModel = new AppIndexViewModel();

    /**
     * 触发方式，默认click
     *
     * @type {string}
     * @memberof AppIndexView
     */
    @Provide()
    public trigger: string = 'click';

    /**
     * 菜单点击
     *
     * @protected
     * @param {*} item 菜单数据
     * @memberof AppIndexView
     */
    protected click(item: any) {
        if (item) {
            switch (item.appfunctag) {
                case 'Auto461': 
                    this.clickAuto461(item);
                    return;
                case 'Auto482': 
                    this.clickAuto482(item);
                    return;
                case 'Auto453': 
                    this.clickAuto453(item);
                    return;
                case 'Auto468': 
                    this.clickAuto468(item);
                    return;
                case 'Auto486': 
                    this.clickAuto486(item);
                    return;
                case 'Auto465': 
                    this.clickAuto465(item);
                    return;
                case 'Auto483': 
                    this.clickAuto483(item);
                    return;
                case 'Auto456': 
                    this.clickAuto456(item);
                    return;
                case 'Auto497': 
                    this.clickAuto497(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 职务设置<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto461(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormduties', parameterName: 'ormduty' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 标准岗位设置<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto482(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormpostlibs', parameterName: 'ormpostlib' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 法人主体<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto453(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 编制查询<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto468(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
            { pathName: 'bzcxgridview', parameterName: 'bzcxgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 组织管理<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto486(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormorgs', parameterName: 'ormorg' },
            { pathName: 'orgtreeexpview', parameterName: 'orgtreeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 岗位集设置<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto465(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormposts', parameterName: 'ormpost' },
            { pathName: 'gwxhwhgridview', parameterName: 'gwxhwhgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 法人主体设置<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto483(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'contractsignorgs', parameterName: 'contractsignorg' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 项目标签<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto456(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * ERP项目<组织管理模块>
     *
     * @param {*} [item={}]
     * @memberof AppIndexView
     */
    public clickAuto497(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormxmgls', parameterName: 'ormxmgl' },
            { pathName: 'gridview', parameterName: 'gridview' },
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
@import './app-index-view-appmenu.less';
</style>