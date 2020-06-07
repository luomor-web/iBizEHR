import GridViewEngine from './grid-view-engine';

/**
 * 实体选择表格视图（部件视图）界面引擎
 *
 * @export
 * @class PickupGridViewEngine
 * @extends {GridViewEngine}
 */
export default class PickupGridViewEngine extends GridViewEngine {

    /**
     * Creates an instance of PickupGridViewEngine.
     * 
     * 
     * @memberof PickupGridViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 选中激活数据
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof PickupGridViewEngine
     */
    public MDCtrlEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'rowdblclick') && this.gridRowAllowActive(2)) {
            this.view.$emit('viewdatasactivated', args);
            return ;
        }
        super.MDCtrlEvent(eventName, args);
    }
}