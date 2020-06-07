import PimPersonService from '@/service/pim-person/pim-person-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 根据证件号更改出生日期、性别、年龄
 *
 * @export
 * @class PersonUpdateInfoLogicBase
 */
export default class PersonUpdateInfoLogicBase {

    /**
     * 名称
     * 
     * @memberof  PersonUpdateInfoLogicBase
     */
    private name:string ="PersonUpdateInfo";

    /**
     * 唯一标识
     * 
     * @memberof  PersonUpdateInfoLogicBase
     */
    private id:string = "409244cc0e60f19fea36af9366157170";

    /**
     * 默认参数名称
     * 
     * @memberof  PersonUpdateInfoLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  PersonUpdateInfoLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  PersonUpdateInfoLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PersonUpdateInfoLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  PersonUpdateInfoLogicBase
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
    * 计算出生日期、性别、年龄
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('Default');
        const targetService:PimPersonService = new PimPersonService();
        if (targetService['PersonUpdateInfo'] && targetService['PersonUpdateInfo'] instanceof Function) {
            result = await targetService['PersonUpdateInfo'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
    }


}