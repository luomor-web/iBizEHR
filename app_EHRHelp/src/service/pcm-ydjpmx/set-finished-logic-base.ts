import { Verify } from '@/utils/verify/verify';


/**
 * 设置完成状态
 *
 * @export
 * @class SetFinishedLogicBase
 */
export default class SetFinishedLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetFinishedLogicBase
     */
    private name:string ="SetFinished";

    /**
     * 唯一标识
     * 
     * @memberof  SetFinishedLogicBase
     */
    private id:string = "56F77A90-0973-4CA2-831D-7109E6BA6803";

    /**
     * 默认参数名称
     * 
     * @memberof  SetFinishedLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  SetFinishedLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetFinishedLogicBase
     */
    constructor(opts: any = {}) {
        
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
    * 设置准备参数
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{isfinished:params.isfinished});
        return params;
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