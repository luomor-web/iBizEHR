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
     * Creates an instance of  RyHgLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  RyHgLogicBase
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
    * 更新分配表
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{pimdistirbutionid:params.pimdistirbutionid});
        Object.assign(context,{pimdistirbution:params.pimdistirbutionid ? params.pimdistirbutionid : null});
        Object.assign(params,{fpzt:params.fpzt});
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
        const targetService:PimDistirbutionService = new PimDistirbutionService();
        if (targetService['Update'] && targetService['Update'] instanceof Function) {
            result = await targetService['Update'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }


}