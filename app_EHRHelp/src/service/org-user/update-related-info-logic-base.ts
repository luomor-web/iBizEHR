import UserService from '@/service/user/user-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 更新关联信息
 *
 * @export
 * @class UpdateRelatedInfoLogicBase
 */
export default class UpdateRelatedInfoLogicBase {

    /**
     * 名称
     * 
     * @memberof  UpdateRelatedInfoLogicBase
     */
    private name:string ="UpdateRelatedInfo";

    /**
     * 唯一标识
     * 
     * @memberof  UpdateRelatedInfoLogicBase
     */
    private id:string = "30cb5745e6c2258e38c07f2c0ca1ac3c";

    /**
     * 默认参数名称
     * 
     * @memberof  UpdateRelatedInfoLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  UpdateRelatedInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateRelatedInfoLogicBase
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

    /**
    * 准备用户对象参数
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{userid:params.orguserid});
        Object.assign(context,{user:params.orguserid});
        Object.assign(params,{username:params.orgusername});
        Object.assign(params,{validflag:params.validflag});
        Object.assign(context,{user:params.validflag});
        if(this.compute1Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
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
        if (targetService['Save'] && targetService['Save'] instanceof Function) {
            result = await targetService['Save'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }


}