import { Vue, Component } from 'vue-property-decorator';
import { Util } from '@/utils';
import { modalBreadcrumbService } from './modal-breadcrumb-service';
import './modal-breadcrumb.less';

/**
 * 模态视图面包屑导航
 *
 * @export
 * @class ModalBreadcrumb
 * @extends {Vue}
 */
@Component({})
export class ModalBreadcrumb extends Vue {

    /**
     * 导航数据服务实例
     *
     * @protected
     * @type {*}
     * @memberof ModalBreadcrumb
     */
    protected viewList: any[] = [];

    /**
     * 组件创建完毕
     *
     * @protected
     * @memberof ModalBreadcrumb
     */
    protected created(): void {
        this.viewList = Util.deepCopy(modalBreadcrumbService.getViewList());
    }

    /**
     * 激活项
     *
     * @protected
     * @param {number} i
     * @memberof ModalBreadcrumb
     */
    protected active(i: number): void {
        modalBreadcrumbService.breadcrumbActive(i);
    }

    /**
     * 绘制面包屑导航
     *
     * @returns {*}
     * @memberof ModalBreadcrumb
     */
    public render(): any {
        return <div class="modal-breadcrumb">
            {this.viewList.map((view: any, i: number) => {
                const isLast: boolean = (this.viewList.length - 1) === i;
                return <div class={{ 'modal-breadcrumb-item': true, 'last': isLast }} on-click={() => this.active(i)}>
                    <div class="name">{isLast ? view.title : <span>{view.title}</span>}</div>
                    {isLast ? null : <div class="breadcrumb">/</div>}
                </div>;
            })}
        </div>;
    }

}