import Vue from 'vue';
import { Subject } from 'rxjs';
import store from '../../store';
import i18n from '@/locale';
import { ViewTool } from '../view-tool/view-tool';
import AppModalCompponent from "./app-modal.vue";
import './app-modal.less';

export class AppModal {

    /**
     * 实例对象
     *
     * @private
     * @static
     * @memberof AppModal
     */
    private static modal = new AppModal();

    /**
     * vue 实例
     *
     * @private
     * @type {Vue}
     * @memberof AppModal
     */
    private vueExample!: Vue;

    /**
     * Creates an instance of AppModal.
     * 
     * @memberof AppModal
     */
    private constructor() {
        if (AppModal.modal) {
            return AppModal.modal;
        }
    }

    /**
     * 获取单例对象
     *
     * @static
     * @returns {AppModal}
     * @memberof AppModal
     */
    public static getInstance(): AppModal {
        if (!AppModal.modal) {
            AppModal.modal = new AppModal();
        }
        return AppModal.modal;
    }

    /**
     * 创建 Vue 实例对象
     *
     * @private
     * @param {{ viewname: string, title: string, width?: number, height?: number,isfullscreen?:boolean }} view 视图数据
     * @param {*} [context={}] 应用上下文参数
     * @param {*} [viewparams={}] 视图参数
     * @param {string} uuid 标识
     * @returns {Subject<any>}
     * @memberof AppModal
     */
    private createVueExample(view: { viewname: string, title: string, width?: number, height?: number,isfullscreen?:boolean }, context: any = {},viewparams:any ={}, uuid: string): Subject<any> {
        try {
            let props = { view: view, viewdata: context,viewparams:viewparams,uuid: uuid };
            let component = AppModalCompponent;
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
     * 打开模态视图
     *
     * @param {{ viewname: string, title: string, width?: number, height?: number }} view 视图
     * @param {*} [viewParam={}] 应用上下文参数
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} [data={}] 行为参数
     * @returns {Subject<any>}
     * @memberof AppModal
     */
    public openModal(view: { viewname: string, title: string, width?: number, height?: number }, context: any = {}, data: any = {}): Subject<any> {
        try {
            let viewdata: any = {};
            Object.assign(viewdata, JSON.parse(JSON.stringify(context)));
            const uuid = this.getUUID();
            const subject = this.createVueExample(view, viewdata,data,uuid);
            return subject;
        } catch (error) {
            console.log(error);
            return new Subject<any>();
        }
    }

    /**
     * 获取节点标识
     *
     * @private
     * @returns {string}
     * @memberof AppModal
     */
    private getUUID(): string {
        function s4() {
            return Math.floor((1 + Math.random()) * 0x10000).toString(16).substring(1);
        }
        return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
    }

}