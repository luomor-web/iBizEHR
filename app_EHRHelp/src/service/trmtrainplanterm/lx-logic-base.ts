import TRMTRAINPLANTERMService from '@/service/trmtrainplanterm/trmtrainplanterm-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 立项
 *
 * @export
 * @class LXLogicBase
 */
export default class LXLogicBase {

    /**
     * 名称
     * 
     * @memberof  LXLogicBase
     */
    private name:string ="LX";

    /**
     * 唯一标识
     * 
     * @memberof  LXLogicBase
     */
    private id:string = "e71e445b9876b3613271f677e863d01d";

    /**
     * 默认参数名称
     * 
     * @memberof  LXLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  LXLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  LXLogicBase
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
    * 准备参数
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:TRMTRAINPLANTERMService = new TRMTRAINPLANTERMService();
        if (targetService['Update'] && targetService['Update'] instanceof Function) {
            result = await targetService['Update'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        if(this.compute0Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
        }
    }

    /**
    * 更新状态
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{bjzt:params.bjzt});
        return params;
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute1Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }


}