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
                case 'Auto13': 
                    this.clickAuto13(item);
                    return;
                case 'Auto9': 
                    this.clickAuto9(item);
                    return;
                case 'Auto16': 
                    this.clickAuto16(item);
                    return;
                case 'Auto15': 
                    this.clickAuto15(item);
                    return;
                case 'Auto4': 
                    this.clickAuto4(item);
                    return;
                case 'Auto18': 
                    this.clickAuto18(item);
                    return;
                case 'Auto17': 
                    this.clickAuto17(item);
                    return;
                case 'Auto14': 
                    this.clickAuto14(item);
                    return;
                case 'Auto1': 
                    this.clickAuto1(item);
                    return;
                case 'Auto8': 
                    this.clickAuto8(item);
                    return;
                case 'Auto3': 
                    this.clickAuto3(item);
                    return;
                case 'Auto11': 
                    this.clickAuto11(item);
                    return;
                case 'Auto7': 
                    this.clickAuto7(item);
                    return;
                case 'Auto12': 
                    this.clickAuto12(item);
                    return;
                case 'Auto499': 
                    this.clickAuto499(item);
                    return;
                case 'Auto6': 
                    this.clickAuto6(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    
    /**
     * 编号审批(社招）
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto13(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'bhsp_csrcyjgridview', parameterName: 'bhsp_csrcyjgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 高校名录
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto9(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
            { pathName: 'gxmltreeexpview', parameterName: 'gxmltreeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 人力上报(校园招聘)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto16(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'rlsbgridview', parameterName: 'rlsbgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 学科目录
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto15(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
            { pathName: 'xkmltreeexpview', parameterName: 'xkmltreeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 用人单位审核(校招)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto4(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'zpdwshgridview', parameterName: 'zpdwshgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 招聘名额
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto18(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmzpmegls', parameterName: 'pcmzpmegl' },
            { pathName: 'treeexpview', parameterName: 'treeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 编号审批(校园招聘)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto17(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'bhspgridview', parameterName: 'bhspgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 应聘者信息(社招)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto14(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'ypzxx_csrcyjgridview', parameterName: 'ypzxx_csrcyjgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 用人单位审核(社招)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto1(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'yrdwcs_csrcyjgridview', parameterName: 'yrdwcs_csrcyjgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 拟录用人员(校园招聘)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto8(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {"n_profiletype_eq":"65"});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'ypzbdgridview', parameterName: 'ypzbdgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 应聘者审批原因
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto3(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofilespyys', parameterName: 'pcmprofilespyy' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 拟录用人员(社招)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto11(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {"n_profiletype_eq":"65"});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'ypzbd_csrcyjgridview', parameterName: 'ypzbd_csrcyjgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 总部初审(校园招聘)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto7(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'rzspgridview', parameterName: 'rzspgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 总部初审(社招)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto12(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'rzsp_csrcyjgridview', parameterName: 'rzsp_csrcyjgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 校招应聘者
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto499(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'ypzxx_lrgridview', parameterName: 'ypzxx_lrgridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        this.$router.push(path);
    }
    
    /**
     * 人力上报(社招)
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto6(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            { pathName: 'rlsb_csrcyjgridview', parameterName: 'rlsb_csrcyjgridview' },
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