<script lang='tsx'>
import { Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { AppMenusCtrlBase } from '@/crm-core';
import IndexService from './index-appmenu-service';

import IndexModel from './index-appmenu-model';


/**
 * EHR—薪酬管理默认菜单基类
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
                case 'Auto81': 
                    this.clickAuto81(item);
                    return;
                case 'Auto60': 
                    this.clickAuto60(item);
                    return;
                case 'Auto54': 
                    this.clickAuto54(item);
                    return;
                case 'Auto77': 
                    this.clickAuto77(item);
                    return;
                case 'Auto71': 
                    this.clickAuto71(item);
                    return;
                case 'Auto51': 
                    this.clickAuto51(item);
                    return;
                case 'Auto69': 
                    this.clickAuto69(item);
                    return;
                case 'Auto59': 
                    this.clickAuto59(item);
                    return;
                case 'Auto66': 
                    this.clickAuto66(item);
                    return;
                case 'Auto55': 
                    this.clickAuto55(item);
                    return;
                case 'Auto61': 
                    this.clickAuto61(item);
                    return;
                case 'Auto65': 
                    this.clickAuto65(item);
                    return;
                case 'Auto53': 
                    this.clickAuto53(item);
                    return;
                case 'Auto74': 
                    this.clickAuto74(item);
                    return;
                case 'Auto52': 
                    this.clickAuto52(item);
                    return;
                case 'Auto62': 
                    this.clickAuto62(item);
                    return;
                case 'Auto48': 
                    this.clickAuto48(item);
                    return;
                case 'Auto49': 
                    this.clickAuto49(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 薪酬要素项
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto81(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salitems', parameterName: 'salitem' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 员工工资
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto60(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salsalaries', parameterName: 'salsalary' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 专项津贴标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto54(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salstdzxes', parameterName: 'salstdzx' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 薪酬调整日志
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto77(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sallogs', parameterName: 'sallog' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 薪酬类型
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto71(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'saltypes', parameterName: 'saltype' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 薪酬计算指标
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto51(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salparams', parameterName: 'salparam' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 高温津贴标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto69(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salstdgws', parameterName: 'salstdgw' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 工资单
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto59(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salschemes', parameterName: 'salscheme' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 执业资格津贴标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto66(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salstdzyzgs', parameterName: 'salstdzyzg' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 薪酬计算计划
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto55(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salplans', parameterName: 'salplan' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 技术津贴标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto61(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salstdzcs', parameterName: 'salstdzc' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 岗位工资标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto65(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salstdgwgzs', parameterName: 'salstdgwgz' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 薪酬计算源
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto53(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salsources', parameterName: 'salsource' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 员工薪酬标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto74(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salpersonstds', parameterName: 'salpersonstd' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 项目工资标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto52(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salstdxmgzs', parameterName: 'salstdxmgz' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 独生子女标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto62(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salstddszns', parameterName: 'salstddszn' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 工龄工资标准
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto48(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salstdgls', parameterName: 'salstdgl' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 薪酬规则
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto49(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'salrules', parameterName: 'salrule' },
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
@import './index-appmenu.less';
</style>