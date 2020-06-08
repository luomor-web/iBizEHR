<script lang='tsx'>
import { Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { AppMenusCtrlBase } from '@/crm-core';
import IndexService from './index-appmenu-service';

import IndexModel from './index-appmenu-model';


/**
 * EHR-假勤管理默认菜单基类
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
                case 'Auto22': 
                    this.clickAuto22(item);
                    return;
                case 'Auto43': 
                    this.clickAuto43(item);
                    return;
                case 'Auto33': 
                    this.clickAuto33(item);
                    return;
                case 'Auto45': 
                    this.clickAuto45(item);
                    return;
                case 'Auto21': 
                    this.clickAuto21(item);
                    return;
                case 'Auto26': 
                    this.clickAuto26(item);
                    return;
                case 'Auto35': 
                    this.clickAuto35(item);
                    return;
                case 'Auto40': 
                    this.clickAuto40(item);
                    return;
                case 'Auto42': 
                    this.clickAuto42(item);
                    return;
                case 'Auto27': 
                    this.clickAuto27(item);
                    return;
                case 'Auto31': 
                    this.clickAuto31(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 员工设置考勤
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto22(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'setattrulesgridview', parameterName: 'setattrulesgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 请假管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto43(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 年休假查询
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto33(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'vacsynjcxes', parameterName: 'vacsynjcx' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考勤设置
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto45(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
            { pathName: 'kqsztreeexpview', parameterName: 'kqsztreeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 休假类型
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto21(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'vacleacetypes', parameterName: 'vacleacetype' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考勤月报
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto26(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
            { pathName: 'kqybtreeexpview', parameterName: 'kqybtreeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 非员工终止考勤
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto35(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
            { pathName: 'fygzzkqgridview', parameterName: 'fygzzkqgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考勤规则
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto40(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考勤类型
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto42(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'attendencetypes', parameterName: 'attendencetype' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考勤记录
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto27(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 考勤汇总
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto31(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'attensummaries', parameterName: 'attensummary' },
            { pathName: 'kqhztreeexpview', parameterName: 'kqhztreeexpview' },
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