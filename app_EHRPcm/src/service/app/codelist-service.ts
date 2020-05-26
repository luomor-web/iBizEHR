import PCMCL_REASON from '@/codelist/pcmcl-reason';   
import PIMCL_ZJLX from '@/codelist/pimcl-zjlx';   
import PIM_XL2 from '@/codelist/pim-xl2';   
import PIMCL_XX from '@/codelist/pimcl-xx';   
import PCMCL_XKML from '@/codelist/pcmcl-xkml';   
import PIMCL_RANK from '@/codelist/pimcl-rank';   
import ORMCL_QY from '@/codelist/ormcl-qy';   
import PIMCL_XXXZ from '@/codelist/pimcl-xxxz';   
import PCMCL_SBLX from '@/codelist/pcmcl-sblx';   
import NATIVEPLACE from '@/codelist/nativeplace';   
import ORMCL_ZW from '@/codelist/ormcl-zw';   
import SysOperator from '@/codelist/sys-operator';   
import ORMCL_GW from '@/codelist/ormcl-gw';   
import PIMCL_HY from '@/codelist/pimcl-hy';   
import PIMCL_ZZMM from '@/codelist/pimcl-zzmm';   
import ORMCL_LEVELTWOORG from '@/codelist/ormcl-leveltwoorg';   
import SSQY from '@/codelist/ssqy';   
import PIMCL_XB from '@/codelist/pimcl-xb';   
import PIMCL_RZLB from '@/codelist/pimcl-rzlb';   
import PIMCL_XL from '@/codelist/pimcl-xl';   
import ORMCL_GWTYPE from '@/codelist/ormcl-gwtype';   
import PIMCL_NATION from '@/codelist/pimcl-nation';   
import PIMCL_HKLX from '@/codelist/pimcl-hklx';   
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
     * 代码表--应聘者审批意见原因
     *
     * @type {PCMCL_REASON}
     * @memberof CodeListService
     */
    public PCMCL_REASON: PCMCL_REASON = new PCMCL_REASON();

    /**
     * 代码表--证件类型
     *
     * @type {PIMCL_ZJLX}
     * @memberof CodeListService
     */
    public PIMCL_ZJLX: PIMCL_ZJLX = new PIMCL_ZJLX();

    /**
     * 代码表--学历
     *
     * @type {PIM_XL2}
     * @memberof CodeListService
     */
    public PIM_XL2: PIM_XL2 = new PIM_XL2();

    /**
     * 代码表--血型
     *
     * @type {PIMCL_XX}
     * @memberof CodeListService
     */
    public PIMCL_XX: PIMCL_XX = new PIMCL_XX();

    /**
     * 代码表--学科目录
     *
     * @type {PCMCL_XKML}
     * @memberof CodeListService
     */
    public PCMCL_XKML: PCMCL_XKML = new PCMCL_XKML();

    /**
     * 代码表--职级
     *
     * @type {PIMCL_RANK}
     * @memberof CodeListService
     */
    public PIMCL_RANK: PIMCL_RANK = new PIMCL_RANK();

    /**
     * 代码表--补贴标准
     *
     * @type {ORMCL_QY}
     * @memberof CodeListService
     */
    public ORMCL_QY: ORMCL_QY = new ORMCL_QY();

    /**
     * 代码表--学校性质
     *
     * @type {PIMCL_XXXZ}
     * @memberof CodeListService
     */
    public PIMCL_XXXZ: PIMCL_XXXZ = new PIMCL_XXXZ();

    /**
     * 代码表--申报类型
     *
     * @type {PCMCL_SBLX}
     * @memberof CodeListService
     */
    public PCMCL_SBLX: PCMCL_SBLX = new PCMCL_SBLX();

    /**
     * 代码表--籍贯（户籍所在地）
     *
     * @type {NATIVEPLACE}
     * @memberof CodeListService
     */
    public NATIVEPLACE: NATIVEPLACE = new NATIVEPLACE();

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
     * 代码表--婚姻状况
     *
     * @type {PIMCL_HY}
     * @memberof CodeListService
     */
    public PIMCL_HY: PIMCL_HY = new PIMCL_HY();

    /**
     * 代码表--政治面貌
     *
     * @type {PIMCL_ZZMM}
     * @memberof CodeListService
     */
    public PIMCL_ZZMM: PIMCL_ZZMM = new PIMCL_ZZMM();

    /**
     * 代码表--二级组织(无权限)
     *
     * @type {ORMCL_LEVELTWOORG}
     * @memberof CodeListService
     */
    public ORMCL_LEVELTWOORG: ORMCL_LEVELTWOORG = new ORMCL_LEVELTWOORG();

    /**
     * 代码表--所属区域
     *
     * @type {SSQY}
     * @memberof CodeListService
     */
    public SSQY: SSQY = new SSQY();

    /**
     * 代码表--性别
     *
     * @type {PIMCL_XB}
     * @memberof CodeListService
     */
    public PIMCL_XB: PIMCL_XB = new PIMCL_XB();

    /**
     * 代码表--入职渠道
     *
     * @type {PIMCL_RZLB}
     * @memberof CodeListService
     */
    public PIMCL_RZLB: PIMCL_RZLB = new PIMCL_RZLB();

    /**
     * 代码表--学习形式
     *
     * @type {PIMCL_XL}
     * @memberof CodeListService
     */
    public PIMCL_XL: PIMCL_XL = new PIMCL_XL();

    /**
     * 代码表--岗位类型
     *
     * @type {ORMCL_GWTYPE}
     * @memberof CodeListService
     */
    public ORMCL_GWTYPE: ORMCL_GWTYPE = new ORMCL_GWTYPE();

    /**
     * 代码表--民族
     *
     * @type {PIMCL_NATION}
     * @memberof CodeListService
     */
    public PIMCL_NATION: PIMCL_NATION = new PIMCL_NATION();

    /**
     * 代码表--户口类型
     *
     * @type {PIMCL_HKLX}
     * @memberof CodeListService
     */
    public PIMCL_HKLX: PIMCL_HKLX = new PIMCL_HKLX();

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