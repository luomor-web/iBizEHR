import { Verify } from '@/utils/verify/verify';


/**
 * 设置审核不通过状态
 *
 * @export
 * @class SetRejectStatusLogicBase
 */
export default class SetRejectStatusLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetRejectStatusLogicBase
     */
    private name:string ="SetRejectStatus";

    /**
     * 唯一标识
     * 
     * @memberof  SetRejectStatusLogicBase
     */
    private id:string = "8BC4EC1F-5B94-4DF2-ABAE-7EB2FC557C10";

    /**
     * 默认参数名称
     * 
     * @memberof  SetRejectStatusLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  SetRejectStatusLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  SetRejectStatusLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetRejectStatusLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  SetRejectStatusLogicBase
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
     * 执行逻辑
     * 
     * @param context 应用上下文
     * @param params 传入参数
     */
    public onExecute(context:any,params:any,isloading:boolean){
        return this.executeBegin(context,params,isloading);
    }


    /**
    * 参数准备
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam0Data,{approvalstatus:"4"});
    this.paramsMap.set('Default',{data:tempDstParam0Data,context:tempDstParam0Context});
        return this.paramsMap.get(this.defaultParamName).data;
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute0Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }


}