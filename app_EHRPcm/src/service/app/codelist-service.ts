import EhrCodeList0239 from '@/codelist/ehr-code-list0239';   
import EhrCodeList0116 from '@/codelist/ehr-code-list0116';   
import EhrCodeList0231 from '@/codelist/ehr-code-list0231';   
import EhrCodeList0117 from '@/codelist/ehr-code-list0117';   
import EhrCodeList0018 from '@/codelist/ehr-code-list0018';   
import EhrCodeList0093 from '@/codelist/ehr-code-list0093';   
import EhrCodeList0025 from '@/codelist/ehr-code-list0025';   
import EhrCodeList0167 from '@/codelist/ehr-code-list0167';   
import EhrCodeList0219 from '@/codelist/ehr-code-list0219';   
import EhrCodeList0208 from '@/codelist/ehr-code-list0208';   
import EhrCodeList0096 from '@/codelist/ehr-code-list0096';   
import EhrCodeList0001 from '@/codelist/ehr-code-list0001';   
import EhrCodeList0233 from '@/codelist/ehr-code-list0233';   
import EhrCodeList0249 from '@/codelist/ehr-code-list0249';   
import EhrCodeList0050 from '@/codelist/ehr-code-list0050';   
import EhrCodeList0075 from '@/codelist/ehr-code-list0075';   
import EhrCodeList0029 from '@/codelist/ehr-code-list0029';   
import EhrCodeList0216 from '@/codelist/ehr-code-list0216';   
import EhrCodeList0250 from '@/codelist/ehr-code-list0250';   
import EhrCodeList0072 from '@/codelist/ehr-code-list0072';   
import EhrCodeList0041 from '@/codelist/ehr-code-list0041';   
import EhrCodeList0131 from '@/codelist/ehr-code-list0131';   
import EhrCodeList0140 from '@/codelist/ehr-code-list0140';   
import EhrCodeList0066 from '@/codelist/ehr-code-list0066';   
import EhrCodeList0070 from '@/codelist/ehr-code-list0070';   
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
     * 代码表--应聘者审批意见原因
     *
     * @type {EhrCodeList0239}
     * @memberof CodeListService
     */
    public EhrCodeList0239: EhrCodeList0239 = new EhrCodeList0239();

    /**
     * 代码表--学科门类
     *
     * @type {EhrCodeList0116}
     * @memberof CodeListService
     */
    public EhrCodeList0116: EhrCodeList0116 = new EhrCodeList0116();

    /**
     * 代码表--证件类型
     *
     * @type {EhrCodeList0231}
     * @memberof CodeListService
     */
    public EhrCodeList0231: EhrCodeList0231 = new EhrCodeList0231();

    /**
     * 代码表--学历
     *
     * @type {EhrCodeList0117}
     * @memberof CodeListService
     */
    public EhrCodeList0117: EhrCodeList0117 = new EhrCodeList0117();

    /**
     * 代码表--血型
     *
     * @type {EhrCodeList0018}
     * @memberof CodeListService
     */
    public EhrCodeList0018: EhrCodeList0018 = new EhrCodeList0018();

    /**
     * 代码表--学科目录
     *
     * @type {EhrCodeList0093}
     * @memberof CodeListService
     */
    public EhrCodeList0093: EhrCodeList0093 = new EhrCodeList0093();

    /**
     * 代码表--职级
     *
     * @type {EhrCodeList0025}
     * @memberof CodeListService
     */
    public EhrCodeList0025: EhrCodeList0025 = new EhrCodeList0025();

    /**
     * 代码表--员工类型
     *
     * @type {EhrCodeList0167}
     * @memberof CodeListService
     */
    public EhrCodeList0167: EhrCodeList0167 = new EhrCodeList0167();

    /**
     * 代码表--补贴标准
     *
     * @type {EhrCodeList0219}
     * @memberof CodeListService
     */
    public EhrCodeList0219: EhrCodeList0219 = new EhrCodeList0219();

    /**
     * 代码表--学校性质
     *
     * @type {EhrCodeList0208}
     * @memberof CodeListService
     */
    public EhrCodeList0208: EhrCodeList0208 = new EhrCodeList0208();

    /**
     * 代码表--申报类型
     *
     * @type {EhrCodeList0096}
     * @memberof CodeListService
     */
    public EhrCodeList0096: EhrCodeList0096 = new EhrCodeList0096();

    /**
     * 代码表--籍贯（户籍所在地）
     *
     * @type {EhrCodeList0001}
     * @memberof CodeListService
     */
    public EhrCodeList0001: EhrCodeList0001 = new EhrCodeList0001();

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
     * 代码表--政治面貌
     *
     * @type {EhrCodeList0029}
     * @memberof CodeListService
     */
    public EhrCodeList0029: EhrCodeList0029 = new EhrCodeList0029();

    /**
     * 代码表--二级组织(无权限)
     *
     * @type {EhrCodeList0216}
     * @memberof CodeListService
     */
    public EhrCodeList0216: EhrCodeList0216 = new EhrCodeList0216();

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
     * 代码表--入职渠道
     *
     * @type {EhrCodeList0041}
     * @memberof CodeListService
     */
    public EhrCodeList0041: EhrCodeList0041 = new EhrCodeList0041();

    /**
     * 代码表--学习形式
     *
     * @type {EhrCodeList0131}
     * @memberof CodeListService
     */
    public EhrCodeList0131: EhrCodeList0131 = new EhrCodeList0131();

    /**
     * 代码表--岗位类型
     *
     * @type {EhrCodeList0140}
     * @memberof CodeListService
     */
    public EhrCodeList0140: EhrCodeList0140 = new EhrCodeList0140();

    /**
     * 代码表--民族
     *
     * @type {EhrCodeList0066}
     * @memberof CodeListService
     */
    public EhrCodeList0066: EhrCodeList0066 = new EhrCodeList0066();

    /**
     * 代码表--户口类型
     *
     * @type {EhrCodeList0070}
     * @memberof CodeListService
     */
    public EhrCodeList0070: EhrCodeList0070 = new EhrCodeList0070();

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