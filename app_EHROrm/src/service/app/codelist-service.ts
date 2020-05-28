import ORMCL_ProCapitalAtt from '@/codelist/ormcl-pro-capital-att';   
import ORMCL_IsDirectlyManage from '@/codelist/ormcl-is-directly-manage';   
import ORMCL_EngineeringScale from '@/codelist/ormcl-engineering-scale';   
import ORMCL_QY from '@/codelist/ormcl-qy';   
import ORMCL_ZW from '@/codelist/ormcl-zw';   
import SysOperator from '@/codelist/sys-operator';   
import ORMCL_GW from '@/codelist/ormcl-gw';   
import ORMCL_EngineeringPurpose from '@/codelist/ormcl-engineering-purpose';   
import ORMCL_EngineeringBusType from '@/codelist/ormcl-engineering-bus-type';   
import EhrCodeListSsqy from '@/codelist/ehr-code-list-ssqy';   
import ORMCL_GWTYPE from '@/codelist/ormcl-gwtype';   
import PIMCL_YGZT from '@/codelist/pimcl-ygzt';   
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
     * 代码表--项目资金属性
     *
     * @type {ORMCL_ProCapitalAtt}
     * @memberof CodeListService
     */
    public ORMCL_ProCapitalAtt: ORMCL_ProCapitalAtt = new ORMCL_ProCapitalAtt();

    /**
     * 代码表--是否局直管
     *
     * @type {ORMCL_IsDirectlyManage}
     * @memberof CodeListService
     */
    public ORMCL_IsDirectlyManage: ORMCL_IsDirectlyManage = new ORMCL_IsDirectlyManage();

    /**
     * 代码表--工程规模
     *
     * @type {ORMCL_EngineeringScale}
     * @memberof CodeListService
     */
    public ORMCL_EngineeringScale: ORMCL_EngineeringScale = new ORMCL_EngineeringScale();

    /**
     * 代码表--补贴标准
     *
     * @type {ORMCL_QY}
     * @memberof CodeListService
     */
    public ORMCL_QY: ORMCL_QY = new ORMCL_QY();

    /**
     * 代码表--职务（基础管理）
     *
     * @type {ORMCL_ZW}
     * @memberof CodeListService
     */
    public ORMCL_ZW: ORMCL_ZW = new ORMCL_ZW();

    /**
     * 代码表--云系统操作者
     *
     * @type {SysOperator}
     * @memberof CodeListService
     */
    public SysOperator: SysOperator = new SysOperator();

    /**
     * 代码表--岗位（基础管理）
     *
     * @type {ORMCL_GW}
     * @memberof CodeListService
     */
    public ORMCL_GW: ORMCL_GW = new ORMCL_GW();

    /**
     * 代码表--工程用途
     *
     * @type {ORMCL_EngineeringPurpose}
     * @memberof CodeListService
     */
    public ORMCL_EngineeringPurpose: ORMCL_EngineeringPurpose = new ORMCL_EngineeringPurpose();

    /**
     * 代码表--工程业务类型
     *
     * @type {ORMCL_EngineeringBusType}
     * @memberof CodeListService
     */
    public ORMCL_EngineeringBusType: ORMCL_EngineeringBusType = new ORMCL_EngineeringBusType();

    /**
     * 代码表--所属区域
     *
     * @type {EhrCodeListSsqy}
     * @memberof CodeListService
     */
    public EhrCodeListSsqy: EhrCodeListSsqy = new EhrCodeListSsqy();

    /**
     * 代码表--岗位类型
     *
     * @type {ORMCL_GWTYPE}
     * @memberof CodeListService
     */
    public ORMCL_GWTYPE: ORMCL_GWTYPE = new ORMCL_GWTYPE();

    /**
     * 代码表--员工状态
     *
     * @type {PIMCL_YGZT}
     * @memberof CodeListService
     */
    public PIMCL_YGZT: PIMCL_YGZT = new PIMCL_YGZT();

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