import PimPersonService from '@/service/pim-person/pim-person-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 填充人员信息
 *
 * @export
 * @class FillPersonInfoLogicBase
 */
export default class FillPersonInfoLogicBase {

    /**
     * 名称
     * 
     * @memberof  FillPersonInfoLogicBase
     */
    private name:string ="FillPersonInfo";

    /**
     * 唯一标识
     * 
     * @memberof  FillPersonInfoLogicBase
     */
    private id:string = "71e17e8a223f7c1448aeabd943f4d64f";

    /**
     * 默认参数名称
     * 
     * @memberof  FillPersonInfoLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  FillPersonInfoLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  FillPersonInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  FillPersonInfoLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  FillPersonInfoLogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('Default',opts);
        this.paramsMap.set('PIMPERSON',{});
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
     * 计算2节点结果
     * 
     * @param params 传入参数
     */
    public compute2Cond(params:any):boolean{
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
            return this.executePrepareparam1(context,params,isloading);   
        }
    }

    /**
    * 填充人员信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam0Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam0Data,{zz:tempSrcParam0Data['ormorgname']});
    this.paramsMap.set('Default',{data:tempDstParam0Data,context:tempDstParam0Context});
    let tempDstParam1Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam1Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam1Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam1Data,{ygbh:tempSrcParam1Data['ygbh']});
    this.paramsMap.set('Default',{data:tempDstParam1Data,context:tempDstParam1Context});
    let tempDstParam2Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam2Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam2Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam2Data,{zzid:tempSrcParam2Data['ormorgid']});
    this.paramsMap.set('Default',{data:tempDstParam2Data,context:tempDstParam2Context});
    let tempDstParam3Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam3Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam3Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam3Data,{bmid:tempSrcParam3Data['ormorgsectorid']});
    this.paramsMap.set('Default',{data:tempDstParam3Data,context:tempDstParam3Context});
    let tempDstParam4Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam4Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam4Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam4Data,{bm:tempSrcParam4Data['ormorgsectorname']});
    this.paramsMap.set('Default',{data:tempDstParam4Data,context:tempDstParam4Context});
    let tempDstParam5Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam5Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam5Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam5Data,{zzgw:tempSrcParam5Data['gw']});
    this.paramsMap.set('Default',{data:tempDstParam5Data,context:tempDstParam5Context});
    let tempDstParam6Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam6Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam6Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam6Data,{duration:tempSrcParam6Data['duration']});
    this.paramsMap.set('Default',{data:tempDstParam6Data,context:tempDstParam6Context});
    let tempDstParam7Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam7Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam7Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam7Data,{rzqd:tempSrcParam7Data['rzqd']});
    this.paramsMap.set('Default',{data:tempDstParam7Data,context:tempDstParam7Context});
    let tempDstParam8Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam8Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam8Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam8Data,{qssj:tempSrcParam8Data['dzjbjsj']});
    this.paramsMap.set('Default',{data:tempDstParam8Data,context:tempDstParam8Context});
    let tempDstParam9Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam9Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam9Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam9Data,{jssj:tempSrcParam9Data['jxdq']});
    this.paramsMap.set('Default',{data:tempDstParam9Data,context:tempDstParam9Context});
        return this.paramsMap.get(this.defaultParamName).data;
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
        let actionParam:any = this.paramsMap.get('PIMPERSON');
        const targetService:PimPersonService = new PimPersonService();
        if (targetService['Get'] && targetService['Get'] instanceof Function) {
            result = await targetService['Get'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        if(this.compute1Cond(params)){
            return this.executePrepareparam2(context,params,isloading);   
        }
        }
    }

    /**
    * 设置人员id
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('PIMPERSON').context?this.paramsMap.get('PIMPERSON').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    let tempSrcParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam0Context,{pimperson:tempSrcParam0Data['pimpersonid']});
    Object.assign(tempDstParam0Data,{pimpersonid:tempSrcParam0Data['pimpersonid']});
    this.paramsMap.set('PIMPERSON',{data:tempDstParam0Data,context:tempDstParam0Context});
        if(this.compute2Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }


}