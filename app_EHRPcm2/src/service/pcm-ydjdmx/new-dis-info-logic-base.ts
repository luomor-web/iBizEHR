import PimDistirbutionService from '@/service/pim-distirbution/pim-distirbution-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 新增分配信息
 *
 * @export
 * @class NewDisInfoLogicBase
 */
export default class NewDisInfoLogicBase {

    /**
     * 名称
     * 
     * @memberof  NewDisInfoLogicBase
     */
    private name:string ="NewDisInfo";

    /**
     * 唯一标识
     * 
     * @memberof  NewDisInfoLogicBase
     */
    private id:string = "8BFB5EA1-DAFF-4281-A384-8F773203FC4C";

    /**
     * 默认参数名称
     * 
     * @memberof  NewDisInfoLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  NewDisInfoLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  NewDisInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  NewDisInfoLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  NewDisInfoLogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('pimDistirbution',{});
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
    * 创建次分配信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('pimDistirbution');
        const targetService:PimDistirbutionService = new PimDistirbutionService();
        if (targetService['Create'] && targetService['Create'] instanceof Function) {
            result = await targetService['Create'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
    }

    /**
    * 设置分配参数变量
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam0Data,{pimpersonid:tempSrcParam0Data['pimpersonid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam0Data,context:tempDstParam0Context});
    let tempDstParam1Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam1Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam1Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam1Data,{pimdistirbutionname:tempSrcParam1Data['pimpersonname']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam1Data,context:tempDstParam1Context});
    let tempDstParam2Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam2Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam2Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam2Data,{yzzid:tempSrcParam2Data['zzid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam2Data,context:tempDstParam2Context});
    let tempDstParam3Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam3Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam3Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam3Data,{ybmid:tempSrcParam3Data['bmid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam3Data,context:tempDstParam3Context});
    let tempDstParam4Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam4Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam4Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam4Data,{ygw:tempSrcParam4Data['ygw']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam4Data,context:tempDstParam4Context});
    let tempDstParam5Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam5Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam5Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam5Data,{yzw:tempSrcParam5Data['yzw']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam5Data,context:tempDstParam5Context});
    let tempDstParam6Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam6Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam6Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam6Data,{ormorgid:tempSrcParam6Data['ormorgid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam6Data,context:tempDstParam6Context});
    let tempDstParam7Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam7Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam7Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam7Data,{ormorgsectorid:tempSrcParam7Data['ormorgsectorid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam7Data,context:tempDstParam7Context});
    let tempDstParam8Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam8Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam8Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam8Data,{ormdutyid:tempSrcParam8Data['ormdutyid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam8Data,context:tempDstParam8Context});
    let tempDstParam9Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam9Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam9Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam9Data,{ormpostid:tempSrcParam9Data['ormpostid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam9Data,context:tempDstParam9Context});
    let tempDstParam10Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam10Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam10Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam10Data,{rzkssj:tempSrcParam10Data['jdksrq']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam10Data,context:tempDstParam10Context});
    let tempDstParam11Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam11Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam11Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam11Data,{rzjssj:tempSrcParam11Data['jdjsrq']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam11Data,context:tempDstParam11Context});
    let tempDstParam12Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam12Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    Object.assign(tempDstParam12Data,{fplx:"CFP"});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam12Data,context:tempDstParam12Context});
    let tempDstParam13Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam13Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    Object.assign(tempDstParam13Data,{cfplx:"10"});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam13Data,context:tempDstParam13Context});
    let tempDstParam14Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam14Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    Object.assign(tempDstParam14Data,{fpzt:"YXFP"});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam14Data,context:tempDstParam14Context});
    let tempDstParam15Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam15Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam15Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam15Data,{ydmxid:tempSrcParam15Data['pcmydjdmxid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam15Data,context:tempDstParam15Context});
    let tempDstParam16Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam16Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    Object.assign(tempDstParam16Data,{isoutrecord:"0"});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam16Data,context:tempDstParam16Context});
        if(this.compute0Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute1Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }


}