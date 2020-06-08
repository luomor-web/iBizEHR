import CodeList1Service from '@/service/code-list1/code-list1-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 职级晋升（公司）
 *
 * @export
 * @class ZJJScodelist2LogicBase
 */
export default class ZJJScodelist2LogicBase {

    /**
     * 名称
     * 
     * @memberof  ZJJScodelist2LogicBase
     */
    private name:string ="ZJJScodelist2";

    /**
     * 唯一标识
     * 
     * @memberof  ZJJScodelist2LogicBase
     */
    private id:string = "b6bf31a68e76ad00dd7e0f68eb294a67";

    /**
     * 默认参数名称
     * 
     * @memberof  ZJJScodelist2LogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  ZJJScodelist2LogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  ZJJScodelist2LogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ZJJScodelist2LogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  ZJJScodelist2LogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('zjcodeList',{});
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
    Object.assign(tempDstParam0Context,{codelist1:8DC14D09-48F5-44E7-B912-BE4A6B4CCF6E});
    Object.assign(tempDstParam0Data,{codelistid:"8DC14D09-48F5-44E7-B912-BE4A6B4CCF6E"});
    this.paramsMap.set('zjcodeList',{data:tempDstParam0Data,context:tempDstParam0Context});
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