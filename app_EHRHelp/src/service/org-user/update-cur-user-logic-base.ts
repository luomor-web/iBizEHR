import OrgUserService from '@/service/org-user/org-user-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 更新当前用户
 *
 * @export
 * @class UpdateCurUserLogicBase
 */
export default class UpdateCurUserLogicBase {

    /**
     * 名称
     * 
     * @memberof  UpdateCurUserLogicBase
     */
    private name:string ="UpdateCurUser";

    /**
     * 唯一标识
     * 
     * @memberof  UpdateCurUserLogicBase
     */
    private id:string = "98a88926ff4adfc395aa8fab596235ba";

    /**
     * 默认参数名称
     * 
     * @memberof  UpdateCurUserLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  UpdateCurUserLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateCurUserLogicBase
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
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:OrgUserService = new OrgUserService();
        if (targetService['Update'] && targetService['Update'] instanceof Function) {
            result = await targetService['Update'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }

    /**
    * 修改当前用户标示
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{orguserid:params.srfpersonid});
        Object.assign(context,{orguser:params.srfpersonid ? params.srfpersonid : null});
        if(this.compute1Cond(params)){
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
        if(this.compute0Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }


}