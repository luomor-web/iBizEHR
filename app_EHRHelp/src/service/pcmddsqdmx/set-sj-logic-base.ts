import { Verify } from '@/utils/verify/verify';


/**
 * 设置其他时间为生效日期
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
    private id:string = "c76c7fbec47e4d902fa2f7603b197c59";

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
    * 设置其他时间
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{jdkssj:params.sxrq});
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