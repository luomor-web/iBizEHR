import TrmTrainPlantermService from '@/service/trm-train-planterm/trm-train-planterm-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 开班
 *
 * @export
 * @class KBLogicBase
 */
export default class KBLogicBase {

    /**
     * 名称
     * 
     * @memberof  KBLogicBase
     */
    private name:string ="KB";

    /**
     * 唯一标识
     * 
     * @memberof  KBLogicBase
     */
    private id:string = "ad2bb3c197f2b1eaaa6e43aaaa9ad9fe";

    /**
     * 默认参数名称
     * 
     * @memberof  KBLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  KBLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  KBLogicBase
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
    * 更新
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{bjzt:params.bjzt});
        return params;
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute1Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 准备参数
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:TrmTrainPlantermService = new TrmTrainPlantermService();
        if (targetService['Update'] && targetService['Update'] instanceof Function) {
            result = await targetService['Update'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        if(this.compute0Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
        }
    }


}