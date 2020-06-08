import PimArchiveSloanandreturnService from '@/service/pim-archive-sloanandreturn/pim-archive-sloanandreturn-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 更新档案信息归还状态
 *
 * @export
 * @class UpdateArchiveStateLogicBase
 */
export default class UpdateArchiveStateLogicBase {

    /**
     * 名称
     * 
     * @memberof  UpdateArchiveStateLogicBase
     */
    private name:string ="UpdateArchiveState";

    /**
     * 唯一标识
     * 
     * @memberof  UpdateArchiveStateLogicBase
     */
    private id:string = "fc5898c25a9166f18bb7c3246fea86e8";

    /**
     * 默认参数名称
     * 
     * @memberof  UpdateArchiveStateLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  UpdateArchiveStateLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  UpdateArchiveStateLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateArchiveStateLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  UpdateArchiveStateLogicBase
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
    * 更新档案信息归还状态
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('Default');
        const targetService:PimArchiveSloanandreturnService = new PimArchiveSloanandreturnService();
        if (targetService['UpdateArchiveState'] && targetService['UpdateArchiveState'] instanceof Function) {
            result = await targetService['UpdateArchiveState'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
    }


}