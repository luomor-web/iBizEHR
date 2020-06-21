import { Verify } from '@/utils/verify/verify';


/**
 * 初始化档案明细
 *
 * @export
 * @class InitArchivesDetailLogicBase
 */
export default class InitArchivesDetailLogicBase {

    /**
     * 名称
     * 
     * @memberof  InitArchivesDetailLogicBase
     */
    private name:string ="InitArchivesDetail";

    /**
     * 唯一标识
     * 
     * @memberof  InitArchivesDetailLogicBase
     */
    private id:string = "D56578BF-FF85-4C93-81B9-CDB420A3D8FF";

    /**
     * 默认参数名称
     * 
     * @memberof  InitArchivesDetailLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  InitArchivesDetailLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  InitArchivesDetailLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  InitArchivesDetailLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  InitArchivesDetailLogicBase
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
    * 初始化档案明细
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