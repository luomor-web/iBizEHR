import PimPersonService from '@/service/pim-person/pim-person-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 获取人员组织
 *
 * @export
 * @class GetPersonOrgLogicBase
 */
export default class GetPersonOrgLogicBase {

    /**
     * 名称
     * 
     * @memberof  GetPersonOrgLogicBase
     */
    private name:string ="GetPersonOrg";

    /**
     * 唯一标识
     * 
     * @memberof  GetPersonOrgLogicBase
     */
    private id:string = "07e2b629dfafd1b8bcd7618a2151407a";

    /**
     * 默认参数名称
     * 
     * @memberof  GetPersonOrgLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  GetPersonOrgLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  GetPersonOrgLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  GetPersonOrgLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  GetPersonOrgLogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('Default',opts);
        this.paramsMap.set('GerPersonInfo',{});
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
     * 计算1节点结果
     * 
     * @param params 传入参数
     */
    public compute1Cond(params:any):boolean{
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
    * 填充人员中的组织
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam0Data:any = this.paramsMap.get('GerPersonInfo').data?this.paramsMap.get('GerPersonInfo').data:{};
    Object.assign(tempDstParam0Data,{ormorgid:tempSrcParam0Data['ormorgid']});
    this.paramsMap.set('Default',{data:tempDstParam0Data,context:tempDstParam0Context});
    let tempDstParam1Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam1Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam1Data:any = this.paramsMap.get('GerPersonInfo').data?this.paramsMap.get('GerPersonInfo').data:{};
    Object.assign(tempDstParam1Data,{ormorgname:tempSrcParam1Data['ormorgname']});
    this.paramsMap.set('Default',{data:tempDstParam1Data,context:tempDstParam1Context});
        return this.paramsMap.get(this.defaultParamName).data;
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
    * 获取人员信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('GerPersonInfo');
        const targetService:PimPersonService = new PimPersonService();
        if (targetService['Get'] && targetService['Get'] instanceof Function) {
            result = await targetService['Get'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        if(this.compute1Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
        }
    }


}