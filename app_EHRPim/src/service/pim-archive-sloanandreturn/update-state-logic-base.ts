import { Verify } from '@/utils/verify/verify';


/**
 * 更新档案借阅归还状态
 *
 * @export
 * @class UpdateStateLogicBase
 */
export default class UpdateStateLogicBase {

    /**
     * 名称
     * 
     * @memberof  UpdateStateLogicBase
     */
    private name:string ="UpdateState";

    /**
     * 唯一标识
     * 
     * @memberof  UpdateStateLogicBase
     */
    private id:string = "ac39dd7df9ce92e4ef79c88b97684793";

    /**
     * 默认参数名称
     * 
     * @memberof  UpdateStateLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  UpdateStateLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  UpdateStateLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateStateLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateStateLogicBase
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
        if(Verify.testCond(params.jyqssj, 'ISNOTNULL', '') && Verify.testCond(params.ghrq, 'ISNULL', '')){
           return true;
        }else{
            return false;
        }
    }

    /**
     * 计算1节点结果
     * 
     * @param params 传入参数
     */
    public compute1Cond(params:any):boolean{
        if(Verify.testCond(params.jyqssj, 'ISNOTNULL', '') && Verify.testCond(params.ghrq, 'ISNOTNULL', '')){
           return true;
        }else{
            return false;
        }
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
    * 已归还
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam4(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam0Data,{zt:"20"});
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
            return this.executePrepareparam3(context,params,isloading);   
        }
        if(this.compute1Cond(params)){
            return this.executePrepareparam4(context,params,isloading);   
        }
    }

    /**
    * 借阅中
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam3(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam0Data,{zt:"10"});
    this.paramsMap.set('Default',{data:tempDstParam0Data,context:tempDstParam0Context});
        return this.paramsMap.get(this.defaultParamName).data;
    }


}