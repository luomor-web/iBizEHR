import PimFaminfoService from '@/service/pim-faminfo/pim-faminfo-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 更新紧急联络人
 *
 * @export
 * @class UpdateContactLogicBase
 */
export default class UpdateContactLogicBase {

    /**
     * 名称
     * 
     * @memberof  UpdateContactLogicBase
     */
    private name:string ="UpdateContact";

    /**
     * 唯一标识
     * 
     * @memberof  UpdateContactLogicBase
     */
    private id:string = "51ae0a161c383983534563771ad4144b";

    /**
     * 默认参数名称
     * 
     * @memberof  UpdateContactLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  UpdateContactLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  UpdateContactLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateContactLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateContactLogicBase
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
    * 更新紧急联络人
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('Default');
        const targetService:PimFaminfoService = new PimFaminfoService();
        if (targetService['UpdateContact'] && targetService['UpdateContact'] instanceof Function) {
            result = await targetService['UpdateContact'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
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


}