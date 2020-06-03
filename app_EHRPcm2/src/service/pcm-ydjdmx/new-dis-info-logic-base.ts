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
     * Creates an instance of  NewDisInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  NewDisInfoLogicBase
     */
    constructor(opts: any = {}) {
        
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
        const targetService:PimDistirbutionService = new PimDistirbutionService();
        if (targetService['Create'] && targetService['Create'] instanceof Function) {
            result = await targetService['Create'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
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
        Object.assign(params,{pimpersonid:params.pimpersonid});
        Object.assign(context,{pimdistirbution:params.pimpersonid ? params.pimpersonid : null});
        Object.assign(params,{pimdistirbutionname:params.pimpersonname});
        Object.assign(params,{yzzid:params.zzid});
        Object.assign(context,{pimdistirbution:params.zzid ? params.zzid : null});
        Object.assign(params,{ybmid:params.bmid});
        Object.assign(context,{pimdistirbution:params.bmid ? params.bmid : null});
        Object.assign(params,{ygw:params.ygw});
        Object.assign(params,{yzw:params.yzw});
        Object.assign(params,{ormorgid:params.ormorgid});
        Object.assign(context,{pimdistirbution:params.ormorgid ? params.ormorgid : null});
        Object.assign(params,{ormorgsectorid:params.ormorgsectorid});
        Object.assign(context,{pimdistirbution:params.ormorgsectorid ? params.ormorgsectorid : null});
        Object.assign(params,{ormdutyid:params.ormdutyid});
        Object.assign(context,{pimdistirbution:params.ormdutyid ? params.ormdutyid : null});
        Object.assign(params,{ormpostid:params.ormpostid});
        Object.assign(context,{pimdistirbution:params.ormpostid ? params.ormpostid : null});
        Object.assign(params,{rzkssj:params.jdksrq});
        Object.assign(params,{rzjssj:params.jdjsrq});
        Object.assign(params,{fplx:params.fplx});
        Object.assign(params,{cfplx:params.cfplx});
        Object.assign(params,{fpzt:params.fpzt});
        Object.assign(params,{ydmxid:params.pcmydjdmxid});
        Object.assign(context,{pimdistirbution:params.pcmydjdmxid ? params.pcmydjdmxid : null});
        Object.assign(params,{isoutrecord:params.isoutrecord});
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