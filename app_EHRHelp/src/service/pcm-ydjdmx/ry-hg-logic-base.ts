import PimDistirbutionService from '@/service/pim-distirbution/pim-distirbution-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 人员回归
 *
 * @export
 * @class RyHgLogicBase
 */
export default class RyHgLogicBase {

    /**
     * 名称
     * 
     * @memberof  RyHgLogicBase
     */
    private name:string ="RyHg";

    /**
     * 唯一标识
     * 
     * @memberof  RyHgLogicBase
     */
    private id:string = "C9845525-5396-4599-9BE2-C30F6A890A52";

    /**
     * 默认参数名称
     * 
     * @memberof  RyHgLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  RyHgLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  RyHgLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  RyHgLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  RyHgLogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('Default',opts);
        this.paramsMap.set('pimDistirbution',{});
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
    * 更新分配表
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    let tempSrcParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam0Context,{pimdistirbution:tempSrcParam0Data['pimdistirbutionid']});
    Object.assign(tempDstParam0Data,{pimdistirbutionid:tempSrcParam0Data['pimdistirbutionid']});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam0Data,context:tempDstParam0Context});
    let tempDstParam1Context:any = this.paramsMap.get('pimDistirbution').context?this.paramsMap.get('pimDistirbution').context:{};
    let tempDstParam1Data:any = this.paramsMap.get('pimDistirbution').data?this.paramsMap.get('pimDistirbution').data:{};
    Object.assign(tempDstParam1Data,{fpzt:"ZZFP"});
    this.paramsMap.set('pimDistirbution',{data:tempDstParam1Data,context:tempDstParam1Context});
        if(this.compute1Cond(params)){
            return this.executeDeaction2(context,params,isloading);   
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
            return this.executePrepareparam2(context,params,isloading);   
        }
    }

    /**
    * 更新分配表
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction2(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('pimDistirbution');
        const targetService:PimDistirbutionService = new PimDistirbutionService();
        if (targetService['Update'] && targetService['Update'] instanceof Function) {
            result = await targetService['Update'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
    }


}