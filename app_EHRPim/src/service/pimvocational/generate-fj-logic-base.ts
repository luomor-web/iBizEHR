import PIMENCLOSUREService from '@/service/pimenclosure/pimenclosure-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 生成附件信息
 *
 * @export
 * @class GenerateFJLogicBase
 */
export default class GenerateFJLogicBase {

    /**
     * 名称
     * 
     * @memberof  GenerateFJLogicBase
     */
    private name:string ="GenerateFJ";

    /**
     * 唯一标识
     * 
     * @memberof  GenerateFJLogicBase
     */
    private id:string = "59bbd0d4e55e776d094a982dd558095e";

    /**
     * 默认参数名称
     * 
     * @memberof  GenerateFJLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * Creates an instance of  GenerateFJLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  GenerateFJLogicBase
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
        if(Verify.testCond(params.fj, 'ISNULL', '')){
           return true;
        }else{
            return false;
        }
    }

    /**
     * 计算3节点结果
     * 
     * @param params 传入参数
     */
    public compute3Cond(params:any):boolean{
        if(Verify.testCond(params.fjkz, 'ISNOTNULL', '')){
           return true;
        }else{
            return false;
        }
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
    * 填充信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{enable:params.enable});
        Object.assign(params,{fjkz:params.fj});
        Object.assign(params,{fj:params.fj});
        Object.assign(params,{pimpersonid:params.pimpersonid});
        Object.assign(context,{pimenclosure:params.pimpersonid});
        Object.assign(params,{pimpersonname:params.pimpersonname});
        Object.assign(params,{pimenclosureid:params.pimvocationalid});
        Object.assign(context,{pimenclosure:params.pimvocationalid});
        Object.assign(params,{pimenclosurename:params.pimvocationalname});
        Object.assign(params,{fjfl:params.fjfl});
        if(this.compute2Cond(params)){
            return this.executePrepareparam2(context,params,isloading);   
        }
        if(this.compute3Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 附件为空时删除附件信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam2(context:any,params:any,isloading:boolean){
        // 准备参数节点
        Object.assign(params,{enable:params.enable});
        if(this.compute1Cond(params)){
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
        if(this.compute0Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }

    /**
    * 保存附件信息
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        const targetService:PIMENCLOSUREService = new PIMENCLOSUREService();
        if (targetService['Save'] && targetService['Save'] instanceof Function) {
            result = await targetService['Save'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
        }
    }


}