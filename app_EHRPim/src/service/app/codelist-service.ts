import EhrCodeList0117 from '@/codelist/ehr-code-list0117';   
import EhrCodeList0237 from '@/codelist/ehr-code-list0237';   
import EhrCodeList0024 from '@/codelist/ehr-code-list0024';   
import EhrCodeList0018 from '@/codelist/ehr-code-list0018';   
import EhrCodeList0093 from '@/codelist/ehr-code-list0093';   
import EhrCodeList0234 from '@/codelist/ehr-code-list0234';   
import EhrCodeList0035 from '@/codelist/ehr-code-list0035';   
import EhrCodeList0142 from '@/codelist/ehr-code-list0142';   
import EhrCodeList0249 from '@/codelist/ehr-code-list0249';   
import EhrCodeList0075 from '@/codelist/ehr-code-list0075';   
import EhrCodeList0029 from '@/codelist/ehr-code-list0029';   
import EhrCodeList0122 from '@/codelist/ehr-code-list0122';   
import EhrCodeList0041 from '@/codelist/ehr-code-list0041';   
import EhrCodeList0211 from '@/codelist/ehr-code-list0211';   
import EhrCodeList0070 from '@/codelist/ehr-code-list0070';   
import EhrCodeList0014 from '@/codelist/ehr-code-list0014';   
import EhrCodeList0084 from '@/codelist/ehr-code-list0084';   
import EhrCodeList0231 from '@/codelist/ehr-code-list0231';   
import EhrCodeList0136 from '@/codelist/ehr-code-list0136';   
import EhrCodeList0205 from '@/codelist/ehr-code-list0205';   
import EhrCodeList0107 from '@/codelist/ehr-code-list0107';   
import EhrCodeList0159 from '@/codelist/ehr-code-list0159';   
import EhrCodeList0047 from '@/codelist/ehr-code-list0047';   
import EhrCodeList0033 from '@/codelist/ehr-code-list0033';   
import EhrCodeList0098 from '@/codelist/ehr-code-list0098';   
import EhrCodeList0137 from '@/codelist/ehr-code-list0137';   
import EhrCodeList0025 from '@/codelist/ehr-code-list0025';   
import EhrCodeList0155 from '@/codelist/ehr-code-list0155';   
import EhrCodeList0167 from '@/codelist/ehr-code-list0167';   
import EhrCodeList0219 from '@/codelist/ehr-code-list0219';   
import EhrCodeList0208 from '@/codelist/ehr-code-list0208';   
import EhrCodeList0001 from '@/codelist/ehr-code-list0001';   
import EhrCodeList0233 from '@/codelist/ehr-code-list0233';   
import EhrCodeList0050 from '@/codelist/ehr-code-list0050';   
import EhrCodeList0250 from '@/codelist/ehr-code-list0250';   
import EhrCodeList0072 from '@/codelist/ehr-code-list0072';   
import EhrCodeList0198 from '@/codelist/ehr-code-list0198';   
import EhrCodeList0043 from '@/codelist/ehr-code-list0043';   
import EhrCodeList0131 from '@/codelist/ehr-code-list0131';   
import EhrCodeList0140 from '@/codelist/ehr-code-list0140';   
import EhrCodeList0066 from '@/codelist/ehr-code-list0066';   
import EhrCodeList0146 from '@/codelist/ehr-code-list0146';   
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
     * 代码表--学历
     *
     * @type {EhrCodeList0117}
     * @memberof CodeListService
     */
    public EhrCodeList0117: EhrCodeList0117 = new EhrCodeList0117();

    /**
     * 代码表--次分配类型
     *
     * @type {EhrCodeList0237}
     * @memberof CodeListService
     */
    public EhrCodeList0237: EhrCodeList0237 = new EhrCodeList0237();

    /**
     * 代码表--职称等级
     *
     * @type {EhrCodeList0024}
     * @memberof CodeListService
     */
    public EhrCodeList0024: EhrCodeList0024 = new EhrCodeList0024();

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
     * 代码表--专家类型
     *
     * @type {EhrCodeList0234}
     * @memberof CodeListService
     */
    public EhrCodeList0234: EhrCodeList0234 = new EhrCodeList0234();

    /**
     * 代码表--军转类型
     *
     * @type {EhrCodeList0035}
     * @memberof CodeListService
     */
    public EhrCodeList0035: EhrCodeList0035 = new EhrCodeList0035();

    /**
     * 代码表--考核结论
     *
     * @type {EhrCodeList0142}
     * @memberof CodeListService
     */
    public EhrCodeList0142: EhrCodeList0142 = new EhrCodeList0142();

    /**
     * 代码表--云系统操作者
     *
     * @type {EhrCodeList0249}
     * @memberof CodeListService
     */
    public EhrCodeList0249: EhrCodeList0249 = new EhrCodeList0249();

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
     * 代码表--语言种类
     *
     * @type {EhrCodeList0122}
     * @memberof CodeListService
     */
    public EhrCodeList0122: EhrCodeList0122 = new EhrCodeList0122();

    /**
     * 代码表--入职渠道
     *
     * @type {EhrCodeList0041}
     * @memberof CodeListService
     */
    public EhrCodeList0041: EhrCodeList0041 = new EhrCodeList0041();

    /**
     * 代码表--二级组织(图表)
     *
     * @type {EhrCodeList0211}
     * @memberof CodeListService
     */
    public EhrCodeList0211: EhrCodeList0211 = new EhrCodeList0211();

    /**
     * 代码表--户口类型
     *
     * @type {EhrCodeList0070}
     * @memberof CodeListService
     */
    public EhrCodeList0070: EhrCodeList0070 = new EhrCodeList0070();

    /**
     * 代码表--员工状态
     *
     * @type {EhrCodeList0014}
     * @memberof CodeListService
     */
    public EhrCodeList0014: EhrCodeList0014 = new EhrCodeList0014();

    /**
     * 代码表--合同类别
     *
     * @type {EhrCodeList0084}
     * @memberof CodeListService
     */
    public EhrCodeList0084: EhrCodeList0084 = new EhrCodeList0084();

    /**
     * 代码表--证件类型
     *
     * @type {EhrCodeList0231}
     * @memberof CodeListService
     */
    public EhrCodeList0231: EhrCodeList0231 = new EhrCodeList0231();

    /**
     * 代码表--惩罚类型
     *
     * @type {EhrCodeList0136}
     * @memberof CodeListService
     */
    public EhrCodeList0136: EhrCodeList0136 = new EhrCodeList0136();

    /**
     * 代码表--分配类型
     *
     * @type {EhrCodeList0205}
     * @memberof CodeListService
     */
    public EhrCodeList0205: EhrCodeList0205 = new EhrCodeList0205();

    /**
     * 代码表--合同类型
     *
     * @type {EhrCodeList0107}
     * @memberof CodeListService
     */
    public EhrCodeList0107: EhrCodeList0107 = new EhrCodeList0107();

    /**
     * 代码表--奖惩级别
     *
     * @type {EhrCodeList0159}
     * @memberof CodeListService
     */
    public EhrCodeList0159: EhrCodeList0159 = new EhrCodeList0159();

    /**
     * 代码表--职称类型
     *
     * @type {EhrCodeList0047}
     * @memberof CodeListService
     */
    public EhrCodeList0047: EhrCodeList0047 = new EhrCodeList0047();

    /**
     * 代码表--档级
     *
     * @type {EhrCodeList0033}
     * @memberof CodeListService
     */
    public EhrCodeList0033: EhrCodeList0033 = new EhrCodeList0033();

    /**
     * 代码表--考勤类型
     *
     * @type {EhrCodeList0098}
     * @memberof CodeListService
     */
    public EhrCodeList0098: EhrCodeList0098 = new EhrCodeList0098();

    /**
     * 代码表--分配状态
     *
     * @type {EhrCodeList0137}
     * @memberof CodeListService
     */
    public EhrCodeList0137: EhrCodeList0137 = new EhrCodeList0137();

    /**
     * 代码表--职级
     *
     * @type {EhrCodeList0025}
     * @memberof CodeListService
     */
    public EhrCodeList0025: EhrCodeList0025 = new EhrCodeList0025();

    /**
     * 代码表--学位
     *
     * @type {EhrCodeList0155}
     * @memberof CodeListService
     */
    public EhrCodeList0155: EhrCodeList0155 = new EhrCodeList0155();

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
     * 代码表--岗位（基础管理）
     *
     * @type {EhrCodeList0050}
     * @memberof CodeListService
     */
    public EhrCodeList0050: EhrCodeList0050 = new EhrCodeList0050();

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
     * 代码表--军转级别
     *
     * @type {EhrCodeList0198}
     * @memberof CodeListService
     */
    public EhrCodeList0198: EhrCodeList0198 = new EhrCodeList0198();

    /**
     * 代码表--家庭情况-与本人关系
     *
     * @type {EhrCodeList0043}
     * @memberof CodeListService
     */
    public EhrCodeList0043: EhrCodeList0043 = new EhrCodeList0043();

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
     * 代码表--外语考试等级
     *
     * @type {EhrCodeList0146}
     * @memberof CodeListService
     */
    public EhrCodeList0146: EhrCodeList0146 = new EhrCodeList0146();

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