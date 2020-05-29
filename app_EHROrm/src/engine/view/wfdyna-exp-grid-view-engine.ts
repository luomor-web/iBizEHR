import GridViewEngine from './grid-view-engine';

/**
 * 视图引擎基础
 *
 * @export
 * @class WFDynaExpGridViewEngine
 * @extends {GridViewEngine}
 */
export default class WFDynaExpGridViewEngine extends GridViewEngine {

    /**
     * Creates an instance of WFDynaExpGridViewEngine.
     * @memberof WFDynaExpGridViewEngine
     */
    constructor() {
        super();
    }
    
    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof WFDynaExpGridViewEngine
     */
    public load(opts: any = {},isnotify:boolean=false): void {
        this.view.getWFStepModel().then((res:any) =>{
            if(!this.view.isformDruipart){
                super.load(opts);
            }else{
                if(isnotify){
                    super.load(opts);
                }
            }
        })
    }
}