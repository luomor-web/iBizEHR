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
                case 'Auto68': 
                    this.clickAuto68(item);
                    return;
                case 'Auto70': 
                    this.clickAuto70(item);
                    return;
                case 'Auto78': 
                    this.clickAuto78(item);
                    return;
                case 'Auto79': 
                    this.clickAuto79(item);
                    return;
                case 'Auto50': 
                    this.clickAuto50(item);
                    return;
                case 'Auto72': 
                    this.clickAuto72(item);
                    return;
                case 'Auto64': 
                    this.clickAuto64(item);
                    return;
                case 'Auto80': 
                    this.clickAuto80(item);
                    return;
                case 'Auto73': 
                    this.clickAuto73(item);
                    return;
                case 'Auto67': 
                    this.clickAuto67(item);
                    return;
                case 'Auto63': 
                    this.clickAuto63(item);
                    return;
                case 'Auto75': 
                    this.clickAuto75(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 考核周期设置<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto68(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
            { pathName: 'newgridview', parameterName: 'newgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 年度量化目标填报（领导类）<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto70(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考核内容设置<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto78(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parexamcontents', parameterName: 'parexamcontent' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 通知发布<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto79(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'partzggs', parameterName: 'partzgg' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 绩效等级评估<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto50(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parjxjgs', parameterName: 'parjxjg' },
            { pathName: 'jxpgdjgridview', parameterName: 'jxpgdjgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 年度量化目标修正（领导类）<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto72(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
            { pathName: 'ndlhmbxzgridview', parameterName: 'ndlhmbxzgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 年度量化目标考核（领导类）<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto64(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
            { pathName: 'khgridview', parameterName: 'khgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 积分规则设置<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto80(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parintegralrules', parameterName: 'parintegralrule' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考核对象设置<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto73(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parkhfas', parameterName: 'parkhfa' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 绩效考核结果<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto67(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parjxjgs', parameterName: 'parjxjg' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考核内容汇总<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto63(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
            { pathName: 'ygkhxgridview', parameterName: 'ygkhxgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 评分权重分配<绩效管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto75(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'parldkhqzs', parameterName: 'parldkhqz' },
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