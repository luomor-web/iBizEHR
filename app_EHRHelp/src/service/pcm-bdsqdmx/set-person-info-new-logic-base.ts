import PimPersonService from '@/service/pim-person/pim-person-service';
import CodeList1Service from '@/service/code-list1/code-list1-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 设置职级、组织、部门、员工编号、职务、新职级
 *
 * @export
 * @class SetPersonInfoNewLogicBase
 */
export default class SetPersonInfoNewLogicBase {

    /**
     * 名称
     * 
     * @memberof  SetPersonInfoNewLogicBase
     */
    private name:string ="SetPersonInfoNew";

    /**
     * 唯一标识
     * 
     * @memberof  SetPersonInfoNewLogicBase
     */
    private id:string = "2d2aa27fa925b7e79d1015beb068af12";

    /**
     * 默认参数名称
     * 
     * @memberof  SetPersonInfoNewLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  SetPersonInfoNewLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SetPersonInfoNewLogicBase
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
     * 计算2节点结果
     * 
     * @param params 传入参数
     */
    public compute2Cond(params:any):boolean{
        return true;
    }

    /**
     * 计算3节点结果
     * 
     * @param params 传入参数
     */
    public compute3Cond(params:any):boolean{
        return true;
    }

    /**
     * 计算4节点结果
     * 
     * @param params 传入参数
     */
    public compute4Cond(params:any):boolean{
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
    * 获取人员的组织部门职级
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PimPersonService = new PimPersonService();
        if (targetService['Get'] && targetService['Get'] instanceof Function) {
            result = await targetService['Get'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        if(this.compute0Cond(params)){
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
        Object.assign(params,{pimpersonid:params.pimpersonid});
        Object.assign(context,{pimperson:params.pimpersonid ? params.pimpersonid : null});
        if(this.compute4Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 刷新代码表
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction2(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:CodeList1Service = new CodeList1Service();
        if (targetService['RefreshModel'] && targetService['RefreshModel'] instanceof Function) {
            result = await targetService['RefreshModel'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
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
        Object.assign(params,{ygbh:params.ygbh});
        Object.assign(params,{zzid:params.ormorgid});
        Object.assign(context,{pcmbdsqdmx:params.ormorgid ? params.ormorgid : null});
        Object.assign(params,{zz:params.ormorgname});
        Object.assign(params,{ormorgid:params.ormorgid});
        Object.assign(context,{pcmbdsqdmx:params.ormorgid ? params.ormorgid : null});
        Object.assign(params,{ormorgname:params.ormorgname});
        Object.assign(params,{bmid:params.ormorgsectorid});
        Object.assign(context,{pcmbdsqdmx:params.ormorgsectorid ? params.ormorgsectorid : null});
        Object.assign(params,{bm:params.ormorgsectorname});
        Object.assign(params,{ormorgsectorid:params.ormorgsectorid});
        Object.assign(context,{pcmbdsqdmx:params.ormorgsectorid ? params.ormorgsectorid : null});
        Object.assign(params,{ormorgsectorname:params.ormorgsectorname});
        Object.assign(params,{ywg:params.gw});
        Object.assign(params,{rank:params.rank});
        Object.assign(params,{yzw:params.zw});
        Object.assign(params,{zzmm:params.zzmm});
        if(this.compute3Cond(params)){
            return this.executePrepareparam3(context,params,isloading);   
        }
    }

    /**
    * zjcodeList
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam3(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{codelistid:params.codelistid});
        if(this.compute2Cond(params)){
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
        if(this.compute1Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }


}