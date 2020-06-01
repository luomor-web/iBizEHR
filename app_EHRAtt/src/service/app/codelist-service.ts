import EhrCodeList0098 from '@/codelist/ehr-code-list0098';   
import EhrCodeList0219 from '@/codelist/ehr-code-list0219';   
import EhrCodeList0233 from '@/codelist/ehr-code-list0233';   
import EhrCodeList0249 from '@/codelist/ehr-code-list0249';   
import EhrCodeList0050 from '@/codelist/ehr-code-list0050';   
import EhrCodeList0075 from '@/codelist/ehr-code-list0075';   
import EhrCodeList0013 from '@/codelist/ehr-code-list0013';   
import EhrCodeList0250 from '@/codelist/ehr-code-list0250';   
import EhrCodeList0072 from '@/codelist/ehr-code-list0072';   
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
     * 代码表--考勤类型
     *
     * @type {EhrCodeList0098}
     * @memberof CodeListService
     */
    public EhrCodeList0098: EhrCodeList0098 = new EhrCodeList0098();

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
     * 代码表--婚姻状况
     *
     * @type {EhrCodeList0075}
     * @memberof CodeListService
     */
    public EhrCodeList0075: EhrCodeList0075 = new EhrCodeList0075();

    /**
     * 代码表--休假类型
     *
     * @type {EhrCodeList0013}
     * @memberof CodeListService
     */
    public EhrCodeList0013: EhrCodeList0013 = new EhrCodeList0013();

    /**
     * 代码表--所属区域
     *
     * @type {EhrCodeList0250}
     * @memberof CodeListService
     */
    public EhrCodeList0250: EhrCodeList0250 = new EhrCodeList0250();

    /**
     * 代码表--性别
     *
     * @type {EhrCodeList0072}
     * @memberof CodeListService
     */
    public EhrCodeList0072: EhrCodeList0072 = new EhrCodeList0072();

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
        let isEnableCache:boolean = _this[tag].isEnableCache;
        let cacheTimeout:any = _this[tag].cacheTimeout;
        return new Promise((resolve:any,reject:any) =>{
            // 如有查询参数传递过来，需直接加载，不能使用缓存
            if(data && Object.keys(data).length >0){
                if (_this[tag]) {
                    _this[tag].getItems(context,JSON.parse(JSON.stringify(data)),isloading).then((result:any) =>{
                        resolve(result);
                    }).catch((error:any) =>{
                        Promise.reject([]);
                    })
                }else{
                    return Promise.reject([]);
                }
            }else{
                // 启用缓存
                if(isEnableCache){
                    // 加载完成,从store获取
                    if(this.$store &&  _this.$store.getters){
                        let items:any = _this.$store.getters.getCodeListItems(tag);
                        if(items.length >0){
                            if(cacheTimeout !== -1){
                                if(new Date().getTime() > _this[tag].expirationTime){
                                    _this[tag].getItems(context,data,isloading).then((result:any) =>{
                                        _this.$store.commit('updateCodeList',{srfkey:tag,items:result});
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
                        const callback:Function = (tag:string,promise:Promise<any>) =>{
                            promise.then((result:any) =>{
                                if(result.length > 0){
                                    _this.$store.commit('updateCodeList',{srfkey:tag,items:result});
                                    return resolve(result);
                                }else{
                                    return resolve([]);
                                }
                            }).catch((result:any) =>{
                                return reject(result);
                            })
                        }
                        // 加载中，UI又需要数据，解决连续加载同一代码表问题
                        if(CodeListService.codelistCache.get(tag)){
                            callback(tag,CodeListService.codelistCache.get(tag));
                        }else{
                            let result:Promise<any> = _this[tag].getItems(context,data,isloading);
                            CodeListService.codelistCache.set(tag,result);
                            if(cacheTimeout !== -1){
                                _this[tag].expirationTime = new Date().getTime() + cacheTimeout;
                            }
                            callback(tag,result);
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
            }
        })
    }
}