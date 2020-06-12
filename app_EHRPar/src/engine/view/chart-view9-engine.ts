import ChartViewEngine from './chart-view-engine';


/**
 * 实体图表视图（部件视图）界面引擎
 *
 * @export
 * @class ChartView9Engine
 * @extends {ChartViewEngine}
 */
export default class ChartView9Engine extends ChartViewEngine {

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof ChartView9Engine
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