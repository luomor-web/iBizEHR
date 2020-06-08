import PimPersonService from '@/service/pim-person/pim-person-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 设置职级、组织、部门、员工编号、职务
 *
 * @export
 * @class SetPersonInfoLogicBase
 */
export default class SetPersonInfoLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetPersonInfoLogicBase
     */
    private name:string ="SetPersonInfo";

    /**
     * 唯一标识
     * 
     * @memberof  SetPersonInfoLogicBase
     */
    private id:string = "6922f577da624e5afad2e9108d343928";

    /**
     * 默认参数名称
     * 
     * @memberof  SetPersonInfoLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  SetPersonInfoLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  SetPersonInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetPersonInfoLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  SetPersonInfoLogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('PIMPERSON',{});
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
        if(this.compute1Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 设置职级、部门、组织
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam0Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam0Data,{ygbh:tempSrcParam0Data['ygbh']});
    this.paramsMap.set('Default',{data:tempDstParam0Data,context:tempDstParam0Context});
    let tempDstParam1Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam1Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam1Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam1Data,{zzid:tempSrcParam1Data['ormorgid']});
    this.paramsMap.set('Default',{data:tempDstParam1Data,context:tempDstParam1Context});
    let tempDstParam2Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam2Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam2Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam2Data,{zz:tempSrcParam2Data['ormorgname']});
    this.paramsMap.set('Default',{data:tempDstParam2Data,context:tempDstParam2Context});
    let tempDstParam3Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam3Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam3Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam3Data,{ormorgid:tempSrcParam3Data['ormorgid']});
    this.paramsMap.set('Default',{data:tempDstParam3Data,context:tempDstParam3Context});
    let tempDstParam4Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam4Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam4Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam4Data,{ormorgname:tempSrcParam4Data['ormorgname']});
    this.paramsMap.set('Default',{data:tempDstParam4Data,context:tempDstParam4Context});
    let tempDstParam5Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam5Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam5Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam5Data,{bmid:tempSrcParam5Data['ormorgsectorid']});
    this.paramsMap.set('Default',{data:tempDstParam5Data,context:tempDstParam5Context});
    let tempDstParam6Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam6Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam6Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam6Data,{bm:tempSrcParam6Data['ormorgsectorname']});
    this.paramsMap.set('Default',{data:tempDstParam6Data,context:tempDstParam6Context});
    let tempDstParam7Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam7Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam7Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam7Data,{ormorgsectorid:tempSrcParam7Data['ormorgsectorid']});
    this.paramsMap.set('Default',{data:tempDstParam7Data,context:tempDstParam7Context});
    let tempDstParam8Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam8Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam8Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam8Data,{ormorgsectorname:tempSrcParam8Data['ormorgsectorname']});
    this.paramsMap.set('Default',{data:tempDstParam8Data,context:tempDstParam8Context});
    let tempDstParam9Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam9Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam9Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam9Data,{ywg:tempSrcParam9Data['gw']});
    this.paramsMap.set('Default',{data:tempDstParam9Data,context:tempDstParam9Context});
    let tempDstParam10Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam10Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam10Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam10Data,{rank:tempSrcParam10Data['rank']});
    this.paramsMap.set('Default',{data:tempDstParam10Data,context:tempDstParam10Context});
    let tempDstParam11Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam11Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam11Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam11Data,{yzw:tempSrcParam11Data['zw']});
    this.paramsMap.set('Default',{data:tempDstParam11Data,context:tempDstParam11Context});
    let tempDstParam12Context:any = this.paramsMap.get('Default').context?this.paramsMap.get('Default').context:{};
    let tempDstParam12Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    let tempSrcParam12Data:any = this.paramsMap.get('PIMPERSON').data?this.paramsMap.get('PIMPERSON').data:{};
    Object.assign(tempDstParam12Data,{zzmm:tempSrcParam12Data['zzmm']});
    this.paramsMap.set('Default',{data:tempDstParam12Data,context:tempDstParam12Context});
        return this.paramsMap.get(this.defaultParamName).data;
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute2Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }

    /**
    * 获取人员的组织部门职级
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
        if(this.compute0Cond(params)){
            return this.executePrepareparam2(context,params,isloading);   
        }
        }
    }


}