import { Verify } from '@/utils/verify/verify';


/**
 * 设置分配名称
 *
 * @export
 * @class SetPIMDISTIRBUTIONNameLogicBase
 */
export default class SetPIMDISTIRBUTIONNameLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetPIMDISTIRBUTIONNameLogicBase
     */
    private name:string ="SetPIMDISTIRBUTIONName";

    /**
     * 唯一标识
     * 
     * @memberof  SetPIMDISTIRBUTIONNameLogicBase
     */
    private id:string = "c8c72dff1f8502b0bb423511258bbf88";

    /**
     * 默认参数名称
     * 
     * @memberof  SetPIMDISTIRBUTIONNameLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  SetPIMDISTIRBUTIONNameLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetPIMDISTIRBUTIONNameLogicBase
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
    * 设置分配名称
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{pimdistirbutionname:params.pimpersonname});
        return params;
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