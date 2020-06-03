import EditViewEngine from './edit-view-engine';

/**
 * 视图引擎基础
 *
 * @export
 * @class WFDynaEditViewEngine
 * @extends {EditViewEngine}
 */
export default class WFDynaEditViewEngine extends EditViewEngine {

    /**
     * Creates an instance of WFDynaEditViewEngine.
     * @memberof WFDynaEditViewEngine
     */
    constructor() {
        super();
    }
    
    /**
     * 表单加载完成
     *
     * @param {*} args
     * @memberof WFDynaEditViewEngine
     */
    public onFormLoad(arg: any): void {
        super.onFormLoad(arg);
        this.view.getWFLinkModel();
    }
}