import OrgUserService from '@/service/org-user/org-user-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 获取当前用户
 *
 * @export
 * @class GetCurUserLogicBase
 */
export default class GetCurUserLogicBase {

    /**
     * 名称
     * 
     * @memberof  GetCurUserLogicBase
     */
    private name:string ="GetCurUser";

    /**
     * 唯一标识
     * 
     * @memberof  GetCurUserLogicBase
     */
    private id:string = "e73b1b4bfdd8c424a4ba70ff2f949c57";

    /**
     * 默认参数名称
     * 
     * @memberof  GetCurUserLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  GetCurUserLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  GetCurUserLogicBase
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
    * 修改当前用户标示
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{orguserid:params.srfpersonid});
        Object.assign(context,{orguser:params.srfpersonid ? params.srfpersonid : null});
        if(this.compute0Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 获取
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:OrgUserService = new OrgUserService();
        if (targetService['Get'] && targetService['Get'] instanceof Function) {
            result = await targetService['Get'](context,params, false);
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


}