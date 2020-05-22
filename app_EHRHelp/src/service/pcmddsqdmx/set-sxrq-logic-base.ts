import { Verify } from '@/utils/verify/verify';


/**
 * 设置生效日期的值为其他时间
 *
 * @export
 * @class SetSXRQLogicBase
 */
export default class SetSXRQLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetSXRQLogicBase
     */
    private name:string ="SetSXRQ";

    /**
     * 唯一标识
     * 
     * @memberof  SetSXRQLogicBase
     */
    private id:string = "72c59a5fff319093161043ea30ec14aa";

    /**
     * 默认参数名称
     * 
     * @memberof  SetSXRQLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  SetSXRQLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetSXRQLogicBase
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

    /**
    * 设置生效日期
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{sxrq:params.jdkssj});
        return params;
    }


}