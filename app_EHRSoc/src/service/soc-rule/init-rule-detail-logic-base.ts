import { Verify } from '@/utils/verify/verify';


/**
 * 初始化社保规则明细
 *
 * @export
 * @class InitRuleDetailLogicBase
 */
export default class InitRuleDetailLogicBase {

    /**
     * 名称
     * 
     * @memberof  InitRuleDetailLogicBase
     */
    private name:string ="InitRuleDetail";

    /**
     * 唯一标识
     * 
     * @memberof  InitRuleDetailLogicBase
     */
    private id:string = "6947FEA4-6F58-42BD-91CC-F413F202ED7B";

    /**
     * 默认参数名称
     * 
     * @memberof  InitRuleDetailLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  InitRuleDetailLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  InitRuleDetailLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  InitRuleDetailLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  InitRuleDetailLogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('Default',opts);
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
            return this.executeRawsqlcall1(context,params,isloading);   
        }
    }

    /**
    * 初始化明细
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeRawsqlcall1(context:any,params:any,isloading:boolean){
        // RAWSQLCALL暂未支持
        console.log("RAWSQLCALL暂未支持");
        return this.paramsMap.get(this.defaultParamName).data;
    }


}