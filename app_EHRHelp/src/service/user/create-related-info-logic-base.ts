import MsgAccountService from '@/service/msg-account/msg-account-service';
import WFUserService from '@/service/wfuser/wfuser-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 建立用户相关信息
 *
 * @export
 * @class CreateRelatedInfoLogicBase
 */
export default class CreateRelatedInfoLogicBase {

    /**
     * 名称
     * 
     * @memberof  CreateRelatedInfoLogicBase
     */
    private name:string ="CreateRelatedInfo";

    /**
     * 唯一标识
     * 
     * @memberof  CreateRelatedInfoLogicBase
     */
    private id:string = "95e110567ab72b21b6e8397eb3a75b3b";

    /**
     * 默认参数名称
     * 
     * @memberof  CreateRelatedInfoLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  CreateRelatedInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  CreateRelatedInfoLogicBase
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
     * 计算2节点结果
     * 
     * @param params 传入参数
     */
    public compute2Cond(params:any):boolean{
        return true;
    }

    /**
     * 计算3节点结果
     * 
     * @param params 传入参数
     */
    public compute3Cond(params:any):boolean{
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
    * 准备流程用户对象
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{wfuserid:params.userid});
        Object.assign(context,{wfuser:params.userid ? params.userid : null});
        Object.assign(params,{wfusername:params.username});
        Object.assign(params,{validflag:params.validflag});
        Object.assign(context,{wfuser:params.validflag ? params.validflag : null});
        if(this.compute2Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 准备消息账户对象
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{msgaccountid:params.userid});
        Object.assign(context,{msgaccount:params.userid ? params.userid : null});
        Object.assign(params,{msgaccountname:params.username});
        Object.assign(params,{islist:params.islist});
        if(this.compute0Cond(params)){
            return this.executeDeaction2(context,params,isloading);   
        }
    }

    /**
    * 建立消息账户
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction2(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:MsgAccountService = new MsgAccountService();
        if (targetService['Save'] && targetService['Save'] instanceof Function) {
            result = await targetService['Save'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        if(this.compute3Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
        }
    }

    /**
    * 建立流程用户
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:WFUserService = new WFUserService();
        if (targetService['Save'] && targetService['Save'] instanceof Function) {
            result = await targetService['Save'](context,params, false);
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
            return this.executePrepareparam2(context,params,isloading);   
        }
    }


}