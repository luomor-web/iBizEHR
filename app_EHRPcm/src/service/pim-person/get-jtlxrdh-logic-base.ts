import { Verify } from '@/utils/verify/verify';


/**
 * 获取家庭联系人电话
 *
 * @export
 * @class GetJTLXRDHLogicBase
 */
export default class GetJTLXRDHLogicBase {

    /**
     * 名称
     * 
     * @memberof  GetJTLXRDHLogicBase
     */
    private name:string ="GetJTLXRDH";

    /**
     * 唯一标识
     * 
     * @memberof  GetJTLXRDHLogicBase
     */
    private id:string = "675164ec5bc869a96a3220c2ad27d36d";

    /**
     * 默认参数名称
     * 
     * @memberof  GetJTLXRDHLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  GetJTLXRDHLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  GetJTLXRDHLogicBase
     */
    constructor(opts: any = {}) {
        
    }


    /**
     * 计算0节点结果
     * 
     * @param params 传入参数
     */
    public compute0Cond(params:any):boolean{
        if(Verify.testCond(params.jtlxrid, 'ISNOTNULL', '')){
           return true;
        }else{
            return false;
        }
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
        if(Verify.testCond(params.pimfaminfoid, 'ISNOTNULL', '')){
           return true;
        }else{
            return false;
        }
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
    * 获取联系人信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
    }

    /**
    * 回填电话号码
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{jtlxrdh:params.telphone});
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
            return this.executePrepareparam1(context,params,isloading);   
        }
    }

    /**
    * 设置联系人id
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{pimfaminfoid:params.jtlxrid});
        if(this.compute2Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }


}