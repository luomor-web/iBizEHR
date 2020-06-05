import PortalViewEngine from './portal-view-engine';

/**
 * 实体数据看板视图（部件视图）界面引擎
 *
 * @export
 * @class PortalViewEngine
 * @extends {PortalViewEngine}
 */
export default class PortalView9Engine extends PortalViewEngine {

    /**
     * 引擎加载
     *
     * @memberof PortalView9Engine
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