import TreeViewEngine from './tree-view-engine';

/**
 *
 *
 * @export
 * @class TreeView9Engine
 * @extends {TreeViewEngine}
 */
export default class TreeView9Engine extends TreeViewEngine {

    /**
     * 引擎加载
     *
     * @memberof TreeView9Engine
     */
    public load(opts: any = {},isnotify:boolean=false): void {
        if(!this.view.isformDruipart){
            super.load();
        }else{
            if(isnotify){
                super.load();
            }
        }
    }

}