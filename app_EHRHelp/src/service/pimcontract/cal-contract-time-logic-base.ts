import PIMCONTRACTService from '@/service/pimcontract/pimcontract-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 计算合同签订次数
 *
 * @export
 * @class CalContractTimeLogicBase
 */
export default class CalContractTimeLogicBase {

    /**
     * 名称
     * 
     * @memberof  CalContractTimeLogicBase
     */
    private name:string ="CalContractTime";

    /**
     * 唯一标识
     * 
     * @memberof  CalContractTimeLogicBase
     */
    private id:string = "3ee8a2ea63999f6832516f5ef3d08fcf";

    /**
     * 默认参数名称
     * 
     * @memberof  CalContractTimeLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  CalContractTimeLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  CalContractTimeLogicBase
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
    * 计算合同签订次数
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PIMCONTRACTService = new PIMCONTRACTService();
        if (targetService['CalContractTime'] && targetService['CalContractTime'] instanceof Function) {
            result = await targetService['CalContractTime'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute0Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }


}