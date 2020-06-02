import { Verify } from '@/utils/verify/verify';


/**
 * 设置审核状态
 *
 * @export
 * @class SetCheckstatusLogicBase
 */
export default class SetCheckstatusLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetCheckstatusLogicBase
     */
    private name:string ="SetCheckstatus";

    /**
     * 唯一标识
     * 
     * @memberof  SetCheckstatusLogicBase
     */
    private id:string = "DC08513D-AA11-47D0-980A-817334349920";

    /**
     * 默认参数名称
     * 
     * @memberof  SetCheckstatusLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  SetCheckstatusLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetCheckstatusLogicBase
     */
    constructor(opts: any = {}) {
        
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
        return params;
    }


}