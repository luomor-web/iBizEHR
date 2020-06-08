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
    protected menuAlign: string = 'TOP';

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
                case 'EHRAtt': 
                    this.clickEHRAtt(item);
                    return;
                case 'EHRPcm': 
                    this.clickEHRPcm(item);
                    return;
                case 'EHRPcm2': 
                    this.clickEHRPcm2(item);
                    return;
                case 'EHRPim': 
                    this.clickEHRPim(item);
                    return;
                case 'EHROrm': 
                    this.clickEHROrm(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }
    /**
     * 假勤管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickEHRAtt(item: any = {}){
       const localdata: any = this.$store.getters.getLocalData();
       const url = `http://172.16.240.110:6095/#/index`;
       window.open(url, '_blank');
    }
    /**
     * 招聘管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickEHRPcm(item: any = {}){
       const localdata: any = this.$store.getters.getLocalData();
       const url = `http://172.16.240.110:6093/#/index`;
       window.open(url, '_blank');
    }
    /**
     * 人员异动管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickEHRPcm2(item: any = {}){
       const localdata: any = this.$store.getters.getLocalData();
       const url = `http://172.16.240.110:6094/#/index`;
       window.open(url, '_blank');
    }
    /**
     * 基础管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickEHRPim(item: any = {}){
       const localdata: any = this.$store.getters.getLocalData();
       const url = `http://172.16.240.110:6092/#/index`;
       window.open(url, '_blank');
    }
    /**
     * 组织管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickEHROrm(item: any = {}){
       const localdata: any = this.$store.getters.getLocalData();
       const url = `http://172.16.240.110:6091/#/index`;
       window.open(url, '_blank');
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