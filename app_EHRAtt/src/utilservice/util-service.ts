import { Store } from 'vuex';

/**
 * 功能服务基类
 *
 * @export
 * @class UtilService
 */
export default class UtilService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {(any | null)}
     * @memberof UtilService
     */
    private $store: Store<any> | null = null;

    /**
     * 模型标识属性
     * 
     * @memberof  UtilService
     */ 
    protected modelIdField: string = "";

    /**
     * 模型存储属性
     * 
     * @memberof  UtilService
     */ 
    protected modelField: string = "";

    /**
     * 应用标识属性
     * 
     * @memberof  UtilService
     */ 
    protected appIdField: string = "";

    /**
     * 用户标识属性
     * 
     * @memberof  UtilService
     */ 
    protected userIdField: string = "";

    /**
     * 存储实体Name
     * 
     * @memberof  UtilService
     */ 
    protected stoageEntityName:string ="";

    /**
     * 存储实体Id
     * 
     * @memberof  UtilService
     */ 
    protected stoageEntityKey:string ="";

    /**
     * Creates an instance of UtilService.
     * 
     * @param {*} [opts={}]
     * @memberof UtilService
     */
    constructor(opts: any = {}) {
        this.$store = opts.$store;
        this.initBasicParam();
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof UtilService
     */
    public getStore(): Store<any> | null {
        return this.$store;
    }

    /**
     * 初始化基础参数
     *
     * @returns {(any | null)}
     * @memberof UtilService
     */
    public initBasicParam(){
        console.log("UtilService初始化参数未实现");
    }

    /**
     * 获取功能服务
     *
     * @protected
     * @param {string} name 功能实体名称
     * @returns {Promise<any>}
     * @memberof UtilService
     */
    public getService(name: string): Promise<any> {
        return (window as any)['utilServiceRegister'].getService(name);
    }

    /**
     * 处理请求参数
     * 
     * @param context 应用上下文 
     * @param data 传入模型数据
     * @param isloading 是否加载
     * @memberof  UtilService
     */    
    protected handlePreParam(context:any,data:any ={}){
        let tempContext:Object = {};
        let tempData:Object = {};
        if(context.modelid){
            Object.defineProperty(tempContext,this.modelIdField,{
                value: context.modelid,
                writable: true,
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(tempContext,this.stoageEntityName,{
                value: context.modelid,
                writable: true,
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(tempData,this.modelIdField,{
                value: context.modelid,
                writable: true,
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(tempData,this.stoageEntityKey,{
                value: context.modelid,
                writable: true,
                enumerable: true,
                configurable: true
            });
        }
        Object.defineProperty(tempData,this.modelField,{
            value: data,
            writable: true,
            enumerable: true,
            configurable: true
        });
        return {context:tempContext,data:tempData};
    }

    /**
     * 获取模型数据
     * 
     * @param context 应用上下文 
     * @param data 传入模型数据
     * @param isloading 是否加载
     * @memberof  UtilService
     */ 
    protected loadModelData(context: any = {},data: any = {}, isloading?: boolean):Promise<any>{
        return Promise.resolve(null);
    }

    /**
     * 保存模型数据
     * 
     * @param context 应用上下文 
     * @param data 传入模型数据
     * @param isloading 是否加载
     * @memberof  UtilService
     */ 
    protected saveModelData(context: any = {},data: any = {}, isloading?: boolean):Promise<any>{
        return Promise.resolve(null);
    }

   
}