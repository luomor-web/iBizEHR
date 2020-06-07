import { Subject, Observable } from 'rxjs';

/**
 * 模态面包屑导航服务
 *
 * @export
 * @class ModalBreadcrumbService
 */
export class ModalBreadcrumbService {

    /**
     * 数据变更订阅
     *
     * @protected
     * @type {Subject<any>}
     * @memberof ModalBreadcrumbService
     */
    protected subject: Subject<any> = new Subject();

    /**
     * 当前模态打开视图列表
     *
     * @protected
     * @type {any[]}
     * @memberof ModalBreadcrumbService
     */
    protected viewList: any[] = [];

    /**
     * 项激活事件
     *
     * @protected
     * @type {Subject<any>}
     * @memberof ModalBreadcrumbService
     */
    protected breadcrumbActiveSubject: Subject<any> = new Subject();

    /**
     * 设置激活项
     *
     * @param {number} index
     * @memberof ModalBreadcrumbService
     */
    public breadcrumbActive(index: number): void {
        this.breadcrumbActiveSubject.next(index);
    }

    /**
     * 订阅激活事件
     *
     * @returns {Observable<any>}
     * @memberof ModalBreadcrumbService
     */
    public subBreadcrumbActive(): Observable<any> {
        return this.breadcrumbActiveSubject.asObservable();
    }

    /**
     * 打开视图列表变更
     *
     * @returns {Observable<any>}
     * @memberof ModalBreadcrumbService
     */
    public change(): Observable<any> {
        return this.subject.asObservable();
    }

    /**
     * 设置视图列表
     *
     * @param {any[]} list
     * @memberof ModalBreadcrumbService
     */
    public setViewList(list: any[]): void {
        this.viewList = list;
    }

    /**
     * 获取视图列表
     *
     * @returns {any[]}
     * @memberof ModalBreadcrumbService
     */
    public getViewList(): any[] {
        return this.viewList;
    }

}

// 模态面包屑导航实例
export const modalBreadcrumbService: ModalBreadcrumbService = new ModalBreadcrumbService();