import PIMPERSONService from '@/service/pimperson/pimperson-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 填充人员信息
 *
 * @export
 * @class FillPersonInfoLogicBase
 */
export default class FillPersonInfoLogicBase {

    /**
     * 名称
     * 
     * @memberof  FillPersonInfoLogicBase
     */
    private name:string ="FillPersonInfo";

    /**
     * 唯一标识
     * 
     * @memberof  FillPersonInfoLogicBase
     */
    private id:string = "8303b457fcfdce816f137dc55e677275";

    /**
     * 默认参数名称
     * 
     * @memberof  FillPersonInfoLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  FillPersonInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  FillPersonInfoLogicBase
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
    * 填充人员信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{csrq:params.csrq});
        Object.assign(params,{lxdh:params.lxdh});
        Object.assign(params,{nl:params.nl});
        Object.assign(params,{zzid:params.ormorgid});
        Object.assign(context,{pcmydmx:params.ormorgid ? params.ormorgid : null});
        Object.assign(params,{zz:params.ormorgname});
        Object.assign(params,{bmid:params.ormorgsectorid});
        Object.assign(context,{pcmydmx:params.ormorgsectorid ? params.ormorgsectorid : null});
        Object.assign(params,{bm:params.ormorgsectorname});
        Object.assign(params,{pimpersonname:params.pimpersonname});
        Object.assign(params,{ygbh:params.ygbh});
        Object.assign(params,{ygw:params.gw});
        Object.assign(params,{yrank:params.rank});
        Object.assign(params,{yzw:params.zw});
        Object.assign(params,{nj:params.nj});
        return params;
    }

    /**
    * 设置人员id
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{pimpersonid:params.pimpersonid});
        Object.assign(context,{pimperson:params.pimpersonid ? params.pimpersonid : null});
        if(this.compute2Cond(params)){
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
        if(this.compute0Cond(params)){
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
        if(this.compute1Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }


}