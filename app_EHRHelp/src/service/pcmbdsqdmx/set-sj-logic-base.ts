import { Verify } from '@/utils/verify/verify';


/**
 * 设置其他时间的值为生效日期
 *
 * @export
 * @class SetSJLogicBase
 */
export default class SetSJLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetSJLogicBase
     */
    private name:string ="SetSJ";

    /**
     * 唯一标识
     * 
     * @memberof  SetSJLogicBase
     */
    private id:string = "55bb44ab32411a47f3e6d54cf9fc0b4d";

    /**
     * 默认参数名称
     * 
     * @memberof  SetSJLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  SetSJLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetSJLogicBase
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
    * 设置其他的时间为生效日期
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{gzkssj:params.sxrq});
        Object.assign(params,{lzsj:params.sxrq});
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