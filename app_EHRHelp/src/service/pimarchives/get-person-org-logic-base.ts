import PIMPERSONService from '@/service/pimperson/pimperson-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 获取人员组织
 *
 * @export
 * @class GetPersonOrgLogicBase
 */
export default class GetPersonOrgLogicBase {

    /**
     * 名称
     * 
     * @memberof  GetPersonOrgLogicBase
     */
    private name:string ="GetPersonOrg";

    /**
     * 唯一标识
     * 
     * @memberof  GetPersonOrgLogicBase
     */
    private id:string = "07e2b629dfafd1b8bcd7618a2151407a";

    /**
     * 默认参数名称
     * 
     * @memberof  GetPersonOrgLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  GetPersonOrgLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  GetPersonOrgLogicBase
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
    * 填充人员中的组织
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{ormorgid:params.ormorgid});
        Object.assign(context,{pimarchives:params.ormorgid ? params.ormorgid : null});
        Object.assign(params,{ormorgname:params.ormorgname});
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
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 获取人员信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PIMPERSONService = new PIMPERSONService();
        if (targetService['Get'] && targetService['Get'] instanceof Function) {
            result = await targetService['Get'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        if(this.compute1Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
        }
    }


}