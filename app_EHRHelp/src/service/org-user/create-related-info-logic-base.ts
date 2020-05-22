import UserService from '@/service/user/user-service';
import UserDictService from '@/service/user-dict/user-dict-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 建立关联信息
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
    private id:string = "ed5ed9180129f9727c830590c176c8cd";

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
    * 保存用户
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:UserService = new UserService();
        if (targetService['Create'] && targetService['Create'] instanceof Function) {
            result = await targetService['Create'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        if(this.compute1Cond(params)){
            return this.executePrepareparam2(context,params,isloading);   
        }
        }
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute3Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }

    /**
    * 准备用户对象参数
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{userid:params.orguserid});
        Object.assign(context,{user:params.orguserid ? params.orguserid : null});
        Object.assign(params,{username:params.orgusername});
        if(this.compute2Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 建立用户词典
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction2(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:UserDictService = new UserDictService();
        if (targetService['Create'] && targetService['Create'] instanceof Function) {
            result = await targetService['Create'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }

    /**
    * 准备用户词典数据对象
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{ownerid:params.orguserid});
        Object.assign(context,{userdict:params.orguserid ? params.orguserid : null});
        Object.assign(params,{userdictid:params.orguserid});
        Object.assign(context,{userdict:params.orguserid ? params.orguserid : null});
        Object.assign(params,{userdictname:params.orgusername});
        Object.assign(params,{ownertype:params.ownertype});
        if(this.compute0Cond(params)){
            return this.executeDeaction2(context,params,isloading);   
        }
    }


}