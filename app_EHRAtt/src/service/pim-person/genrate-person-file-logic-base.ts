import PimPersonService from '@/service/pim-person/pim-person-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 生成人员档案
 *
 * @export
 * @class GenratePersonFileLogicBase
 */
export default class GenratePersonFileLogicBase {

    /**
     * 名称
     * 
     * @memberof  GenratePersonFileLogicBase
     */
    private name:string ="GenratePersonFile";

    /**
     * 唯一标识
     * 
     * @memberof  GenratePersonFileLogicBase
     */
    private id:string = "a5b1ff5492fb257102e028e77a897e42";

    /**
     * 默认参数名称
     * 
     * @memberof  GenratePersonFileLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  GenratePersonFileLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  GenratePersonFileLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  GenratePersonFileLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  GenratePersonFileLogicBase
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
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 生成档案
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('Default');
        const targetService:PimPersonService = new PimPersonService();
        if (targetService['GeneratePersonFile'] && targetService['GeneratePersonFile'] instanceof Function) {
            result = await targetService['GeneratePersonFile'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
    }


}