import PCMPROFILEService from '@/service/pcmprofile/pcmprofile-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 公司审批-同意
 *
 * @export
 * @class CompanyConfirmLogicBase
 */
export default class CompanyConfirmLogicBase {

    /**
     * 名称
     * 
     * @memberof  CompanyConfirmLogicBase
     */
    private name:string ="CompanyConfirm";

    /**
     * 唯一标识
     * 
     * @memberof  CompanyConfirmLogicBase
     */
    private id:string = "E6BBB03E-24B3-4037-8133-16164FA93D84";

    /**
     * 默认参数名称
     * 
     * @memberof  CompanyConfirmLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  CompanyConfirmLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  CompanyConfirmLogicBase
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
    * 变更状态为待上报
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PCMPROFILEService = new PCMPROFILEService();
        if (targetService['Update'] && targetService['Update'] instanceof Function) {
            result = await targetService['Update'](context,params, false);
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
        if(this.compute1Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
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
        Object.assign(params,{profiletype:params.profiletype});
        if(this.compute0Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }


}