import CodeList1Service from '@/service/code-list1/code-list1-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 职级晋升（局）
 *
 * @export
 * @class ZJJScodelist3LogicBase
 */
export default class ZJJScodelist3LogicBase {

    /**
     * 名称
     * 
     * @memberof  ZJJScodelist3LogicBase
     */
    private name:string ="ZJJScodelist3";

    /**
     * 唯一标识
     * 
     * @memberof  ZJJScodelist3LogicBase
     */
    private id:string = "5a3a687929db4cb3500caea9569839bc";

    /**
     * 默认参数名称
     * 
     * @memberof  ZJJScodelist3LogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  ZJJScodelist3LogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  ZJJScodelist3LogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ZJJScodelist3LogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  ZJJScodelist3LogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('Default',opts);
        this.paramsMap.set('zjcodeList',{});
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

    /**
    * ZjcodeList
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('zjcodeList').context?this.paramsMap.get('zjcodeList').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('zjcodeList').data?this.paramsMap.get('zjcodeList').data:{};
    Object.assign(tempDstParam0Context,{codelist1:BC61C8E1-837D-4711-9E49-3061DBBFAFEA});
    Object.assign(tempDstParam0Data,{codelistid:"BC61C8E1-837D-4711-9E49-3061DBBFAFEA"});
    this.paramsMap.set('zjcodeList',{data:tempDstParam0Data,context:tempDstParam0Context});
        if(this.compute0Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 刷新代码表
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('zjcodeList');
        const targetService:CodeList1Service = new CodeList1Service();
        if (targetService['RefreshModel'] && targetService['RefreshModel'] instanceof Function) {
            result = await targetService['RefreshModel'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
    }


}