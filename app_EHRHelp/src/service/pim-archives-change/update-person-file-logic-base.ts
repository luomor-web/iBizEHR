import PimArchivesChangeService from '@/service/pim-archives-change/pim-archives-change-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 更新档案信息
 *
 * @export
 * @class UpdatePersonFileLogicBase
 */
export default class UpdatePersonFileLogicBase {

    /**
     * 名称
     * 
     * @memberof  UpdatePersonFileLogicBase
     */
    private name:string ="UpdatePersonFile";

    /**
     * 唯一标识
     * 
     * @memberof  UpdatePersonFileLogicBase
     */
    private id:string = "9e2a1b908d07ae3e985c6429ef3b8bc3";

    /**
     * 默认参数名称
     * 
     * @memberof  UpdatePersonFileLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  UpdatePersonFileLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UpdatePersonFileLogicBase
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
    * 更新档案信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PimArchivesChangeService = new PimArchivesChangeService();
        if (targetService['UpdatePersonFile'] && targetService['UpdatePersonFile'] instanceof Function) {
            result = await targetService['UpdatePersonFile'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }


}