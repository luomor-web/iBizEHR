import DataViewEngine from './data-view-engine';

/**
 *
 *
 * @export
 * @class EditView9Engine
 * @extends {EditViewEngine}
 */
export default class DataView9Engine extends DataViewEngine {

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof DataView9Engine
     */
    public load(opts: any = {},isnotify:boolean=false): void {
        if(!this.view.isformDruipart){
            super.load(opts);
        }else{
            if(isnotify){
                super.load(opts);
            }
        }
    }
}
