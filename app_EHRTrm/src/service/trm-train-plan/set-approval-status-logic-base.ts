import { Verify } from '@/utils/verify/verify';


/**
 * 设置审核通过状态
 *
 * @export
 * @class SetApprovalStatusLogicBase
 */
export default class SetApprovalStatusLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetApprovalStatusLogicBase
     */
    private name:string ="SetApprovalStatus";

    /**
     * 唯一标识
     * 
     * @memberof  SetApprovalStatusLogicBase
     */
    private id:string = "D275E4C7-CEDB-463E-9FFE-1070CB103A41";

    /**
     * 默认参数名称
     * 
     * @memberof  SetApprovalStatusLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  SetApprovalStatusLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  SetApprovalStatusLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetApprovalStatusLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  SetApprovalStatusLogicBase
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
    Object.assign(tempDstParam0Data,{approvalstatus:"3"});
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