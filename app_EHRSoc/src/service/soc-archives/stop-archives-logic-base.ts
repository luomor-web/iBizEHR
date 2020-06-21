import SocArchivesService from '@/service/soc-archives/soc-archives-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 终止社保
 *
 * @export
 * @class StopArchivesLogicBase
 */
export default class StopArchivesLogicBase {

    /**
     * 名称
     * 
     * @memberof  StopArchivesLogicBase
     */
    private name:string ="StopArchives";

    /**
     * 唯一标识
     * 
     * @memberof  StopArchivesLogicBase
     */
    private id:string = "69A365B8-D226-40D5-87C9-36CB4AA174C9";

    /**
     * 默认参数名称
     * 
     * @memberof  StopArchivesLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  StopArchivesLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  StopArchivesLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  StopArchivesLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  StopArchivesLogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('Default',opts);
    }


    /**
     * 计算0节点结果
     * 
     * @param params 传入参数
     */
    public compute0Cond(params:any):boolean{
        return true;
    }

    /**
     * 计算1节点结果
     * 
     * @param params 传入参数
     */
    public compute1Cond(params:any):boolean{
        return true;
    }

    /**
     * 执行逻辑
     * 
     * @param context 应用上下文
     * @param params 传入参数
     */
    public onExecute(context:any,params:any,isloading:boolean){
        return this.executeBegin(context,params,isloading);
    }


    /**
    * 失效档案
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('Default');
        const targetService:SocArchivesService = new SocArchivesService();
        if (targetService['Update'] && targetService['Update'] instanceof Function) {
            result = await targetService['Update'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
    }

    /**
    * 准备参数
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam0Data,{state:"20"});
    this.paramsMap.set('Default',{data:tempDstParam0Data,context:tempDstParam0Context});
        if(this.compute0Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute1Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }


}