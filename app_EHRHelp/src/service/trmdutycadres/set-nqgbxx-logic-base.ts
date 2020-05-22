import PIMPERSONService from '@/service/pimperson/pimperson-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 填充年轻干部的信息
 *
 * @export
 * @class SetNQGBXXLogicBase
 */
export default class SetNQGBXXLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetNQGBXXLogicBase
     */
    private name:string ="SetNQGBXX";

    /**
     * 唯一标识
     * 
     * @memberof  SetNQGBXXLogicBase
     */
    private id:string = "5d167ce2904c34c19d4efda4f3d88d64";

    /**
     * 默认参数名称
     * 
     * @memberof  SetNQGBXXLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  SetNQGBXXLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetNQGBXXLogicBase
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
     * 执行逻辑
     * 
     * @param context 应用上下文
     * @param params 传入参数
     */
    public onExecute(context:any,params:any,isloading:boolean){
        return this.executeBegin(context,params,isloading);
    }


    /**
    * 获取年轻干部信息
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
        if(this.compute0Cond(params)){
            return this.executePrepareparam2(context,params,isloading);   
        }
        }
    }

    /**
    * 设置年轻干部信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{ygbh:params.ygbh});
        Object.assign(params,{ormorgname2:params.ormorgname});
        Object.assign(params,{ormorgsectorname2:params.ormorgsectorname});
        Object.assign(params,{rank:params.rank});
        Object.assign(params,{zw:params.zw});
        Object.assign(params,{gw:params.gw});
        return params;
    }

    /**
    * 设置年轻干部id
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{pimpersonid:params.pimpersonid2});
        Object.assign(context,{pimperson:params.pimpersonid2 ? params.pimpersonid2 : null});
        if(this.compute2Cond(params)){
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
        if(this.compute1Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }


}