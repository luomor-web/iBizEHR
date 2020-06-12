import { Verify } from '@/utils/verify/verify';


/**
 * 设置排序号规则
 *
 * @export
 * @class SetOrderNumLogicBase
 */
export default class SetOrderNumLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetOrderNumLogicBase
     */
    private name:string ="setOrderNum";

    /**
     * 唯一标识
     * 
     * @memberof  SetOrderNumLogicBase
     */
    private id:string = "192fc1d6593ff0a48f8cce039a0da8a0";

    /**
     * 默认参数名称
     * 
     * @memberof  SetOrderNumLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  SetOrderNumLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  SetOrderNumLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetOrderNumLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  SetOrderNumLogicBase
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
    * 设置排序规则
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