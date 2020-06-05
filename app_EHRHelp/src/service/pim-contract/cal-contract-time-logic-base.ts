import PimContractService from '@/service/pim-contract/pim-contract-service';
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
     * 参数集合
     * 
     * @memberof  CalContractTimeLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  CalContractTimeLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  CalContractTimeLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  CalContractTimeLogicBase
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
    * 计算合同签订次数
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('Default');
        const targetService:PimContractService = new PimContractService();
        if (targetService['CalContractTime'] && targetService['CalContractTime'] instanceof Function) {
            result = await targetService['CalContractTime'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
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