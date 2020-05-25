import TreeViewEngine from './tree-view-engine';

/**
 * 实体选择树视图（部件视图）界面引擎
 *
 * @export
 * @class PickupTreeViewEngine
 * @extends {TreeViewEngine}
 */
export default class PickupTreeViewEngine extends TreeViewEngine {

    /**
     * 部件加载完
     *
     * @param {*} args
     * @memberof PickupTreeViewEngine
     */
    public onLoad(args: any): void { 
        super.onLoad(args);
        if (this.view) {
            this.view.$emit('viewload', args);
        }
    }

    /**
     * 选中处理
     *
     * @param {any[]} args
     * @memberof PickupTreeViewEngine
     */
    public onSelectionChange(args: any[]): void {
        super.onSelectionChange(args);
        if (this.view) {
            this.view.viewSelections =  [...args];
            this.view.$emit('viewdataschange', args);
        }
    }
}