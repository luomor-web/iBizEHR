import { Vue, Component } from 'vue-property-decorator';
import { CreateElement } from 'vue/types/umd';
import { Subject, Observable } from 'rxjs';
import { Util } from '@/utils';
import { on } from '@/utils/dom/dom';
import store from '@/store';
import i18n from '@/locale';
import { ModalBreadcrumbService, modalBreadcrumbService } from '@/crm-core/components/modal-breadcrumb/modal-breadcrumb-service';
import './crm-drawer.less';

/**
 * 模态承载组件
 *
 * @export
 * @class CrmModal
 * @extends {Vue}
 */
@Component({})
export class CrmModal extends Vue {

    /**
     * 导航数据服务实例
     *
     * @protected
     * @type {ModalBreadcrumbService}
     * @memberof ModalBreadcrumb
     */
    protected mbs: ModalBreadcrumbService = modalBreadcrumbService;

    /**
     * 已呈现视图列表
     *
     * @protected
     * @type {any[]}
     * @memberof CrmModal
     */
    protected viewList: any[] = [];

    /**
     * 关闭模态数据传递
     *
     * @protected
     * @type {*}
     * @memberof CrmModal
     */
    protected closeModalData: any;

    /**
     * 待关闭视图
     *
     * @protected
     * @type {any[]}
     * @memberof CrmModal
     */
    protected toBeClosedViews: any[] = [];

    /**
     * 是否展示模态
     *
     * @protected
     * @type {boolean}
     * @memberof CrmModal
     */
    protected isShow: boolean = false;

    /**
     * 视图层级
     *
     * @protected
     * @type {number}
     * @memberof CrmModal
     */
    protected zIndex: number = 100;

    /**
     * 组件创建完毕
     *
     * @protected
     * @memberof CrmModal
     */
    protected created(): void {
        this.mbs.subBreadcrumbActive().subscribe((i: number) => {
            this.toBeClosedViews = [];
            for (let index = i + 1; index < this.viewList.length - 1; index++) {
                this.toBeClosedViews.push({
                    viewname: this.viewList[index].viewname,
                    index: index
                });
            }
            this.refCloseView(this.viewList[this.viewList.length - 1], this.viewList.length - 1);
        });
        on(document, 'keydown', ($event: KeyboardEvent) => {
            if ($event && $event.keyCode === 27 && this.viewList.length > 0) {
                this.refCloseView(this.viewList[this.viewList.length - 1], this.viewList.length - 1);
            }
        });
    }

    /**
     * 使用实例方法关闭视图
     *
     * @protected
     * @param {*} view
     * @param {number} i
     * @returns {*}
     * @memberof CrmModal
     */
    protected refCloseView(view: any, i: number): any {
        const ref: any = this.$refs[view.viewname + i];
        if (ref && ref.closeView) {
            ref.closeView();
        }
    }

    /**
     * 打开模态视图
     *
     * @param {*} [param={}]
     * @returns {Promise<any>}
     * @memberof CrmModal
     */
    public openModal(param: any = {}): Promise<any> {
        return new Promise((resolve: (res: any) => void) => {
            if (!this.isShow) {
                const zIndex: number = this.$store.getters.getZIndex();
                if (zIndex) {
                    this.zIndex = zIndex + 100;
                    this.$store.commit('updateZIndex', this.zIndex);
                }
                setTimeout(() => this.isShow = true, 50);
            }
            this.viewList.push(Object.assign(Util.deepCopy(param), { resolve }));
            this.mbs.setViewList(this.viewList);
        });
    }

    /**
     * 关闭模态视图
     *
     * @memberof CrmModal
     */
    public closeView(item: any): void {
        if (this.closeModalData) {
            item.resolve({ ret: 'OK', datas: this.closeModalData});
        } else {
            item.resolve({ ret: '', datas: this.closeModalData});
        }
        this.viewList.pop();
        if (this.toBeClosedViews.length > 0) {
            const view: any = this.toBeClosedViews[this.toBeClosedViews.length - 1];
            const viewname: string = view.viewname;
            const i: number = view.index;
            this.toBeClosedViews.pop();
            this.refCloseView({ viewname }, i);
        }
    }

    /**
     * 绘制模态内容
     *
     * @returns {*}
     * @memberof CrmModal
     */
    public render(h: CreateElement): any {
        return <div class="crm-modal" key="crm-modal" style={{ 'z-index': this.zIndex, 'margin-top': this.isShow ? '0px' : '-100vh' }}>
            {
                this.viewList.map((view: any, i: number) => {
                    const props: any = { openMode: 'MODAL', viewDefaultUsage: false, viewdata: JSON.stringify(view.viewdata), viewparams: view.viewparams };
                    const style: any = { 'z-index': i + 1 };
                    return <div class="crm-modal-item">
                        {h(view.viewname, {
                            key: view.viewname + i,
                            ref: view.viewname + i,
                            style,
                            props,
                            on: {
                                viewdataschange: (data: any) => this.closeModalData = data,
                                close: () => {
                                    if (this.viewList.length === 1) {
                                        this.isShow = false;
                                        setTimeout(() => this.closeView(view), 500);
                                    } else {
                                        this.closeView(view);
                                    }
                                }
                            }
                        })}
                    </div>;
                })
            }
        </div>;
    }

}

/**
 * 模态
 *
 * @export
 * @class CrmDrawerController
 */
export class CrmDrawerController {

    /**
     * 唯一实例
     *
     * @protected
     * @static
     * @type {CrmDrawerController}
     * @memberof CrmDrawerController
     */
    protected static readonly instance: CrmDrawerController = new CrmDrawerController();

    /**
     * 模态承载容器
     *
     * @protected
     * @type {HTMLDivElement}
     * @memberof CrmDrawerController
     */
    protected modalContainer: HTMLDivElement;

    /**
     * Vue实例
     *
     * @protected
     * @type {*}
     * @memberof CrmDrawerController
     */
    protected vueInstance!: any;

    /**
     * Creates an instance of CrmDrawerController.
     * @memberof CrmDrawerController
     */
    constructor() {
        this.modalContainer = document.createElement('div');
        document.body.appendChild(this.modalContainer);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof CrmDrawerController
     */
    protected init(): void {
        this.vueInstance = new Vue({
            i18n,
            store,
            render: (h: any) => h(CrmModal, { ref: 'crmModal' })
        }).$mount(this.modalContainer);
    }

    /**
     * 顶部抽屉模式打开视图
     *
     * @param {{ viewname: string, title: string, width?: number, height?: number }} view 视图
     * @param {*} [viewParam={}] 视图参数
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} [data={}] 行为参数
     * @returns {Observable<any>}
     * @memberof CrmDrawerController
     */
    public openDrawer(view: { viewname: string, title: string, width?: number, height?: number, placement?: string }, context: any, data: any = {}): Observable<any> {
        const subject: Subject<any> = new Subject();
        this.getVueInstance().$refs.crmModal.openModal({ ...view, viewdata: Util.deepCopy(context), viewparams: data }).then((data: any) => {
            subject.next(data);
            subject.complete();
            subject.unsubscribe();
        });
        return subject.asObservable();
    }

    /**
     * 获取Vue容器实例
     *
     * @protected
     * @returns {*}
     * @memberof CrmDrawerController
     */
    protected getVueInstance(): any {
        if (!this.vueInstance) {
            this.init();
        }
        return this.vueInstance;
    }

}

// 模态服务控制器实例
export const crmDrawerController: CrmDrawerController = new CrmDrawerController();