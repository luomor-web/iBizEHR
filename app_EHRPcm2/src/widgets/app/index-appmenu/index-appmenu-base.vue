<script lang='tsx'>
import { Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { AppMenusCtrlBase } from '@/crm-core';
import IndexService from './index-appmenu-service';

import IndexModel from './index-appmenu-model';


/**
 * 应用首页视图默认菜单基类
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
                case 'Auto37': 
                    this.clickAuto37(item);
                    return;
                case 'Auto46': 
                    this.clickAuto46(item);
                    return;
                case 'Auto25': 
                    this.clickAuto25(item);
                    return;
                case 'Auto23': 
                    this.clickAuto23(item);
                    return;
                case 'Auto29': 
                    this.clickAuto29(item);
                    return;
                case 'Auto44': 
                    this.clickAuto44(item);
                    return;
                case 'Auto19': 
                    this.clickAuto19(item);
                    return;
                case 'Auto38': 
                    this.clickAuto38(item);
                    return;
                case 'Auto30': 
                    this.clickAuto30(item);
                    return;
                case 'Auto20': 
                    this.clickAuto20(item);
                    return;
                case 'Auto41': 
                    this.clickAuto41(item);
                    return;
                case 'Auto28': 
                    this.clickAuto28(item);
                    return;
                case 'Auto39': 
                    this.clickAuto39(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 病休管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto37(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
            { pathName: 'bxglgridview', parameterName: 'bxglgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 解聘管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto46(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
            { pathName: 'glgridview', parameterName: 'glgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 借调管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto25(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 待岗管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto23(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
            { pathName: 'dgglgridview', parameterName: 'dgglgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 调动管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto29(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
            { pathName: 'ddmgrgridview', parameterName: 'ddmgrgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 退休管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto44(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'txglgridview', parameterName: 'txglgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 见习期转正审核<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto19(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
            { pathName: 'approavlgridview', parameterName: 'approavlgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 见习期转正申请<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto38(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'sqjxqzzgridview', parameterName: 'sqjxqzzgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 内退管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto30(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
            { pathName: 'ntglgridview', parameterName: 'ntglgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 离职管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto20(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
            { pathName: 'glgridview', parameterName: 'glgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 试用期转正审核<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto41(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
            { pathName: 'approvalgridview', parameterName: 'approvalgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 兼职管理<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto28(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
            { pathName: 'glgridview', parameterName: 'glgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 试用期转正申请<配置管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto39(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'sqsyqzzgridview', parameterName: 'sqsyqzzgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
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