import PIMPERSONService from '@/service/pimperson/pimperson-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 更新员工信息表中组织、部门信息
 *
 * @export
 * @class ModInfoLogicBase
 */
export default class ModInfoLogicBase {

    /**
     * 名称
     * 
     * @memberof  ModInfoLogicBase
     */
    private name:string ="ModInfo";

    /**
     * 唯一标识
     * 
     * @memberof  ModInfoLogicBase
     */
    private id:string = "065FC36E-3752-4BFC-AD3E-DDD8D2F72506";

    /**
     * 默认参数名称
     * 
     * @memberof  ModInfoLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  ModInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ModInfoLogicBase
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
    * 更新员工信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PIMPERSONService = new PIMPERSONService();
        if (targetService['Update'] && targetService['Update'] instanceof Function) {
            result = await targetService['Update'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }

    /**
    * 根据分配中的组织、部门更新
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{pimpersonid:params.pimpersonid});
        Object.assign(context,{pimperson:params.pimpersonid ? params.pimpersonid : null});
        Object.assign(params,{ormorgid:params.ormorgid});
        Object.assign(context,{pimperson:params.ormorgid ? params.ormorgid : null});
        Object.assign(params,{ormorgname:params.ormorgname});
        Object.assign(params,{ormorgsectorid:params.ormorgsectorid});
        Object.assign(context,{pimperson:params.ormorgsectorid ? params.ormorgsectorid : null});
        Object.assign(params,{ormorgsectorname:params.ormorgsectorname});
        if(this.compute1Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }


}