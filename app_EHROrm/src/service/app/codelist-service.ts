import EhrCodeList0028 from '@/codelist/ehr-code-list0028';   
import EhrCodeList0191 from '@/codelist/ehr-code-list0191';   
import EhrCodeList0240 from '@/codelist/ehr-code-list0240';   
import EhrCodeList0219 from '@/codelist/ehr-code-list0219';   
import EhrCodeList0233 from '@/codelist/ehr-code-list0233';   
import EhrCodeList0249 from '@/codelist/ehr-code-list0249';   
import EhrCodeList0050 from '@/codelist/ehr-code-list0050';   
import EhrCodeList0023 from '@/codelist/ehr-code-list0023';   
import EhrCodeList0193 from '@/codelist/ehr-code-list0193';   
import EhrCodeList0250 from '@/codelist/ehr-code-list0250';   
import EhrCodeList0140 from '@/codelist/ehr-code-list0140';   
import EhrCodeList0014 from '@/codelist/ehr-code-list0014';   
import { Store } from 'vuex';

/**
 * 动态代码表服务类
 *
 * @export
 * @class CodeListService
 */
export default class CodeListService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {(any | null)}
     * @memberof CodeListService
     */
    private $store: Store<any> | null = null;

    constructor(opts: any = {}) {
        this.$store = opts.$store;
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof CodeListService
     */
    public getStore(): Store<any> | null {
        return this.$store;
    }


    /**
     * 动态代码表缓存(加载中)
     *
     * @type {Map<string,any>}
     * @memberof CodeListService
     */
    public static codelistCache:Map<string,any> = new Map();

    /**
     * 动态代码表缓存(已完成)
     *
     * @type {Map<string,any>}
     * @memberof CodeListService
     */
    public static codelistCached:Map<string,any> = new Map();


    /**
     * 代码表--项目资金属性
     *
     * @type {EhrCodeList0028}
     * @memberof CodeListService
     */
    public EhrCodeList0028: EhrCodeList0028 = new EhrCodeList0028();

    /**
     * 代码表--是否局直管
     *
     * @type {EhrCodeList0191}
     * @memberof CodeListService
     */
    public EhrCodeList0191: EhrCodeList0191 = new EhrCodeList0191();

    /**
     * 代码表--工程规模
     *
     * @type {EhrCodeList0240}
     * @memberof CodeListService
     */
    public EhrCodeList0240: EhrCodeList0240 = new EhrCodeList0240();

    /**
     * 代码表--补贴标准
     *
     * @type {EhrCodeList0219}
     * @memberof CodeListService
     */
    public EhrCodeList0219: EhrCodeList0219 = new EhrCodeList0219();

    /**
     * 代码表--职务（基础管理）
     *
     * @type {EhrCodeList0233}
     * @memberof CodeListService
     */
    public EhrCodeList0233: EhrCodeList0233 = new EhrCodeList0233();

    /**
     * 代码表--云系统操作者
     *
     * @type {EhrCodeList0249}
     * @memberof CodeListService
     */
    public EhrCodeList0249: EhrCodeList0249 = new EhrCodeList0249();

    /**
     * 代码表--岗位（基础管理）
     *
     * @type {EhrCodeList0050}
     * @memberof CodeListService
     */
    public EhrCodeList0050: EhrCodeList0050 = new EhrCodeList0050();

    /**
     * 代码表--工程用途
     *
     * @type {EhrCodeList0023}
     * @memberof CodeListService
     */
    public EhrCodeList0023: EhrCodeList0023 = new EhrCodeList0023();

    /**
     * 代码表--工程业务类型
     *
     * @type {EhrCodeList0193}
     * @memberof CodeListService
     */
    public EhrCodeList0193: EhrCodeList0193 = new EhrCodeList0193();

    /**
     * 代码表--所属区域
     *
     * @type {EhrCodeList0250}
     * @memberof CodeListService
     */
    public EhrCodeList0250: EhrCodeList0250 = new EhrCodeList0250();

    /**
     * 代码表--岗位类型
     *
     * @type {EhrCodeList0140}
     * @memberof CodeListService
     */
    public EhrCodeList0140: EhrCodeList0140 = new EhrCodeList0140();

    /**
     * 代码表--员工状态
     *
     * @type {EhrCodeList0014}
     * @memberof CodeListService
     */
    public EhrCodeList0014: EhrCodeList0014 = new EhrCodeList0014();

    /**
     * 获取动态代码表
     *
     * @param {string} tag 代码表标识
     * @param {string} context
     * @returns {Promise<any[]>}
     * @memberof CodeListService
     */
    public getItems(tag: string,context:any = {}, data?: any, isloading?: boolean,): Promise<any[]> {
        let _this: any = this;
        if(context && context.srfsessionid){
            delete context.srfsessionid;
        }
        let isEnableCache:boolean = _this[tag].isEnableCache;
        let cacheTimeout:any = _this[tag].cacheTimeout;
        return new Promise((resolve:any,reject:any) =>{
                // 启用缓存
                if(isEnableCache){
                    // 加载完成,从本地缓存获取
                    if(CodeListService.codelistCached.get(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`)){
                        let items:any = CodeListService.codelistCached.get(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`);
                        if(items.length >0){
                            if(cacheTimeout !== -1){
                                if(new Date().getTime() > _this[tag].expirationTime){
                                    _this[tag].getItems(context,data,isloading).then((result:any) =>{
                                        CodeListService.codelistCached.set(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`,{items:result});
                                        _this[tag].expirationTime = new Date().getTime() + cacheTimeout;
                                        resolve(result);
                                    }).catch((error:any) =>{
                                        Promise.reject([]);
                                    })
                                }else{
                                    return resolve(items); 
                                }
                            }else{
                                return resolve(items);
                            }
                        }
                    }
                    if (_this[tag]) {
                        const callback:Function = (context:any ={},data:any ={},tag:string,promise:Promise<any>) =>{
                            promise.then((result:any) =>{
                                console.log()
                                if(result.length > 0){
                                    CodeListService.codelistCached.set(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`,{items:result});
                                    return resolve(result);
                                }else{
                                    return resolve([]);
                                }
                            }).catch((result:any) =>{
                                return reject(result);
                            })
                        }
                        // 加载中，UI又需要数据，解决连续加载同一代码表问题
                        if(CodeListService.codelistCache.get(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`)){
                            callback(context,data,tag,CodeListService.codelistCache.get(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`));
                        }else{
                            let result:Promise<any> = _this[tag].getItems(context,data,isloading);
                            CodeListService.codelistCache.set(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`,result);
                            if(cacheTimeout !== -1){
                                _this[tag].expirationTime = new Date().getTime() + cacheTimeout;
                            }
                            callback(context,data,tag,result);
                        }
                    }
                }else{
                    if (_this[tag]) {
                        _this[tag].getItems(context,data,isloading).then((result:any) =>{
                            resolve(result);
                        }).catch((error:any) =>{
                            Promise.reject([]);
                        })
                    }else{
                        return Promise.reject([]);
                    } 
                }
        })
    }
}