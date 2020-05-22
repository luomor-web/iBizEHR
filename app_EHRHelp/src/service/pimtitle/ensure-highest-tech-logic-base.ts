import PIMTITLEService from '@/service/pimtitle/pimtitle-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 确认唯一最高职称
 *
 * @export
 * @class EnsureHighestTechLogicBase
 */
export default class EnsureHighestTechLogicBase {

    /**
     * 名称
     * 
     * @memberof  EnsureHighestTechLogicBase
     */
    private name:string ="EnsureHighestTech";

    /**
     * 唯一标识
     * 
     * @memberof  EnsureHighestTechLogicBase
     */
    private id:string = "838d5d73ddda8d1dc23f89e0f878cd95";

    /**
     * 默认参数名称
     * 
     * @memberof  EnsureHighestTechLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  EnsureHighestTechLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  EnsureHighestTechLogicBase
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
    * 确认唯一最高职称
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PIMTITLEService = new PIMTITLEService();
        if (targetService['EnsureHighestTech'] && targetService['EnsureHighestTech'] instanceof Function) {
            result = await targetService['EnsureHighestTech'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }


}