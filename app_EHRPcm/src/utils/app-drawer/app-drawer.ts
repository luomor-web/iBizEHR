import Vue from 'vue';
import { Subject, Observable } from 'rxjs';
import { ViewTool } from '../view-tool/view-tool';
import store from '../../store';
import i18n from '@/locale';
import AppDrawerCompponent from "./app-drawer.vue";
import { crmDrawerController } from '@/crm-core/core/utils/crm-drawer/crm-drawer';

export class AppDrawer {

    /**
     * 实例对象
     *
     * @private
     * @static
     * @memberof AppDrawer
     */
    private static readonly $drawer = new AppDrawer();

    /**
     * 构造方法
     * 
     * @memberof AppDrawer
     */
    constructor() {
        if (AppDrawer.$drawer) {
            return AppDrawer.$drawer;
        }
    }

    /**
     * vue 实例
     *
     * @private
     * @type {Vue}
     * @memberof AppDrawer
     */
    private vueExample!: Vue;

    /**
     * 获取实例对象
     *
     * @static
     * @returns
     * @memberof AppDrawer
     */
    public static getInstance() {
        return AppDrawer.$drawer;
    }

    /**
     * 创建 Vue 实例对象
     *
     * @private
     * @param {{ viewname: string, title: string, width?: number, height?: number, placement?: any }} view
     * @param {*} [context={}] 应用上下文参数
     * @param {*} [viewparams={}] 视图参数
     * @param {string} uuid 标识
     * @returns {Subject<any>}
     * @memberof AppDrawer
     */
    private createVueExample(view: { viewname: string, title: string, width?: number, height?: number, placement?: any }, context: any = {},viewparams: any = {}, uuid: string): Subject<any> {
        try {
            let props = { view: view, viewdata: context,viewparams:viewparams,uuid: uuid };
            let component = AppDrawerCompponent;
            const vm = new Vue({
                store: store,
                i18n: i18n,
                render(h) {
                    return h(component, { props });
                }
            }).$mount();
            this.vueExample = vm;
            document.body.appendChild(vm.$el);
            const comp: any = vm.$children[0];
            return comp.getSubject();
        } catch (error) {
            console.error(error);
            return new Subject<any>();
        }
    }

    /**
     * 打开抽屉
     *
     * @param {({ viewname: string, title: string, width?: number, height?: number, placement?: 'DRAWER_LEFT' | 'DRAWER_RIGHT' })} view 视图
     * @param {*} [context={}] 应用上下文参数
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} [data={}] 行为参数
     * @returns {Subject<any>}
     * @memberof AppDrawer
     */
    public openDrawer(view: { viewname: string, title: string, width?: number, height?: number, placement?: 'DRAWER_LEFT' | 'DRAWER_RIGHT' | 'DRAWER_TOP' | 'DRAWER_BOTTOM' }, context: any = {}, data: any = {}): Observable<any> {
        if (Object.is(view.placement, 'DRAWER_TOP')) {
            return crmDrawerController.openDrawer(view, context, data);
        }
        try {
            let viewdata: any = {};
            Object.assign(viewdata, JSON.parse(JSON.stringify(context)));
            const uuid = this.getUUID();
            const subject = this.createVueExample(view, viewdata,data,uuid);
            return subject;
        } catch (error) {
            return new Subject<any>();
        }
    }

    /**
     * 生成uuid
     *
     * @private
     * @returns {string}
     * @memberof AppDrawer
     */
    private getUUID(): string {
        function s4() {
            return Math.floor((1 + Math.random()) * 0x10000).toString(16).substring(1);
        }
        return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
    }


}