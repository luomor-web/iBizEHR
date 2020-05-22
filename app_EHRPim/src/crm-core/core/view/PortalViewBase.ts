import { ViewBase } from './ViewBase';

/**
 * 门户视图基类
 *
 * @export
 * @class PortalViewBase
 * @extends {ViewBase}
 */
export class PortalViewBase extends ViewBase {

    /**
     * 组件挂载完毕
     *
     * @memberof PortalViewBase
     */
    public mounted(): void {
        super.mounted();
        this.viewState.next({ tag: 'dashboard', action: 'load', data: {} });
    }

}