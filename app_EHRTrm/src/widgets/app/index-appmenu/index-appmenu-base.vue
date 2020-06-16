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
                case '_7': 
                    this.click_7(item);
                    return;
                case '_6': 
                    this.click_6(item);
                    return;
                case '_14': 
                    this.click_14(item);
                    return;
                case '_5': 
                    this.click_5(item);
                    return;
                case '_16': 
                    this.click_16(item);
                    return;
                case '_11': 
                    this.click_11(item);
                    return;
                case '_15': 
                    this.click_15(item);
                    return;
                case '_3': 
                    this.click_3(item);
                    return;
                case '_18': 
                    this.click_18(item);
                    return;
                case '_2': 
                    this.click_2(item);
                    return;
                case '_10': 
                    this.click_10(item);
                    return;
                case '_17': 
                    this.click_17(item);
                    return;
                case '_9': 
                    this.click_9(item);
                    return;
                case '_12': 
                    this.click_12(item);
                    return;
                case '_19': 
                    this.click_19(item);
                    return;
                case '_8': 
                    this.click_8(item);
                    return;
                case '_13': 
                    this.click_13(item);
                    return;
                case '_4': 
                    this.click_4(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 培训计划制定<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_7(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmplanformus', parameterName: 'trmplanformu' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训计划审批<开发管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_6(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训费用登记<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_14(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训场地<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_5(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 外部讲师<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_16(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
            { pathName: 'wbgridview', parameterName: 'wbgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训需求填报<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_11(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训班级<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_15(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训模块<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_3(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训课程<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_18(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 内部讲师费用<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_2(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训后评估<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_10(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainactments', parameterName: 'trmtrainactment' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训机构<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_17(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 个人教育经费<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_9(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainoutapplies', parameterName: 'trmtrainoutapply' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训需求汇总<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_12(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
            { pathName: 'xqhzgridview', parameterName: 'xqhzgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训立项<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_19(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训计划发布<开发管理模块>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_8(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 内部讲师<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_13(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 培训需求通知<培训管理>
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public click_4(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
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