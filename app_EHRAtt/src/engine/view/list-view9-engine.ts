import ListViewEngine from './list-view-engine';

/**
 *
 *
 * @export
 * @class EditView9Engine
 * @extends {EditViewEngine}
 */
export default class ListView9Engine extends ListViewEngine { 
    
    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof ListView9Engine
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
