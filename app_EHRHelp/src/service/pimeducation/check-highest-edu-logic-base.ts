import PIMEDUCATIONService from '@/service/pimeducation/pimeducation-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 检查最高学历
 *
 * @export
 * @class CheckHighestEduLogicBase
 */
export default class CheckHighestEduLogicBase {

    /**
     * 名称
     * 
     * @memberof  CheckHighestEduLogicBase
     */
    private name:string ="CheckHighestEdu";

    /**
     * 唯一标识
     * 
     * @memberof  CheckHighestEduLogicBase
     */
    private id:string = "65da6ecbab982a5ae628f7118525752d";

    /**
     * 默认参数名称
     * 
     * @memberof  CheckHighestEduLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  CheckHighestEduLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  CheckHighestEduLogicBase
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
     * 执行逻辑
     * 
     * @param context 应用上下文
     * @param params 传入参数
     */
    public onExecute(context:any,params:any,isloading:boolean){
        return this.executeBegin(context,params,isloading);
    }


    /**
    * 检查最高学历
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PIMEDUCATIONService = new PIMEDUCATIONService();
        if (targetService['CheckHighestEdu'] && targetService['CheckHighestEdu'] instanceof Function) {
            result = await targetService['CheckHighestEdu'](context,params, false);
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
        if(this.compute0Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }


}