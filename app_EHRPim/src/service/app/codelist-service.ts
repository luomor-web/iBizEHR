import PIM_XL2 from '@/codelist/pim-xl2';   
import CFPLX from '@/codelist/cfplx';   
import PIMCL_ZCDJ from '@/codelist/pimcl-zcdj';   
import PIMCL_XX from '@/codelist/pimcl-xx';   
import PCMCL_XKML from '@/codelist/pcmcl-xkml';   
import PIMCL_ZJ from '@/codelist/pimcl-zj';   
import PIMCL_TROOPTYPE from '@/codelist/pimcl-trooptype';   
import PIMCL_KHJL from '@/codelist/pimcl-khjl';   
import SysOperator from '@/codelist/sys-operator';   
import PIMCL_HY from '@/codelist/pimcl-hy';   
import PIMCL_ZZMM from '@/codelist/pimcl-zzmm';   
import PIMCL_YYZL from '@/codelist/pimcl-yyzl';   
import PIMCL_RZLB from '@/codelist/pimcl-rzlb';   
import ORMCL_LEVEL2ORG from '@/codelist/ormcl-level2-org';   
import PIMCL_HKLX from '@/codelist/pimcl-hklx';   
import PIMCL_YGZT from '@/codelist/pimcl-ygzt';   
import PIMCL_HTLX from '@/codelist/pimcl-htlx';   
import PIMCL_ZJLX from '@/codelist/pimcl-zjlx';   
import PIMCL_JCLX from '@/codelist/pimcl-jclx';   
import PIMCL_FPLX from '@/codelist/pimcl-fplx';   
import PIMCL_TYPECONTRACT from '@/codelist/pimcl-typecontract';   
import PIMCL_JCJB from '@/codelist/pimcl-jcjb';   
import PIMCL_ZCLX from '@/codelist/pimcl-zclx';   
import PIMCL_DANGJI from '@/codelist/pimcl-dangji';   
import ATTCL_KQLX from '@/codelist/attcl-kqlx';   
import PIMCL_FPZT from '@/codelist/pimcl-fpzt';   
import PIMCL_RANK from '@/codelist/pimcl-rank';   
import PIMCL_XWLX from '@/codelist/pimcl-xwlx';   
import PIMCL_YGLX from '@/codelist/pimcl-yglx';   
import ORMCL_QY from '@/codelist/ormcl-qy';   
import PIMCL_XXXZ from '@/codelist/pimcl-xxxz';   
import NATIVEPLACE from '@/codelist/nativeplace';   
import ORMCL_ZW from '@/codelist/ormcl-zw';   
import ORMCL_GW from '@/codelist/ormcl-gw';   
import EhrCodeListSsqy from '@/codelist/ehr-code-list-ssqy';   
import PIMCL_XB from '@/codelist/pimcl-xb';   
import PIMCL_LEVEL from '@/codelist/pimcl-level';   
import PIMCL_YBRGX from '@/codelist/pimcl-ybrgx';   
import PIMCL_XL from '@/codelist/pimcl-xl';   
import ORMCL_GWTYPE from '@/codelist/ormcl-gwtype';   
import PIMCL_NATION from '@/codelist/pimcl-nation';   
import LanguageLevel from '@/codelist/language-level';   
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
     * 代码表--学历
     *
     * @type {PIM_XL2}
     * @memberof CodeListService
     */
    public PIM_XL2: PIM_XL2 = new PIM_XL2();

    /**
     * 代码表--次分配类型
     *
     * @type {CFPLX}
     * @memberof CodeListService
     */
    public CFPLX: CFPLX = new CFPLX();

    /**
     * 代码表--职称等级
     *
     * @type {PIMCL_ZCDJ}
     * @memberof CodeListService
     */
    public PIMCL_ZCDJ: PIMCL_ZCDJ = new PIMCL_ZCDJ();

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
     * 代码表--专家类型
     *
     * @type {PIMCL_ZJ}
     * @memberof CodeListService
     */
    public PIMCL_ZJ: PIMCL_ZJ = new PIMCL_ZJ();

    /**
     * 代码表--军转类型
     *
     * @type {PIMCL_TROOPTYPE}
     * @memberof CodeListService
     */
    public PIMCL_TROOPTYPE: PIMCL_TROOPTYPE = new PIMCL_TROOPTYPE();

    /**
     * 代码表--考核结论
     *
     * @type {PIMCL_KHJL}
     * @memberof CodeListService
     */
    public PIMCL_KHJL: PIMCL_KHJL = new PIMCL_KHJL();

    /**
     * 代码表--云系统操作者
     *
     * @type {SysOperator}
     * @memberof CodeListService
     */
    public SysOperator: SysOperator = new SysOperator();

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
     * 代码表--语言种类
     *
     * @type {PIMCL_YYZL}
     * @memberof CodeListService
     */
    public PIMCL_YYZL: PIMCL_YYZL = new PIMCL_YYZL();

    /**
     * 代码表--入职渠道
     *
     * @type {PIMCL_RZLB}
     * @memberof CodeListService
     */
    public PIMCL_RZLB: PIMCL_RZLB = new PIMCL_RZLB();

    /**
     * 代码表--二级组织(图表)
     *
     * @type {ORMCL_LEVEL2ORG}
     * @memberof CodeListService
     */
    public ORMCL_LEVEL2ORG: ORMCL_LEVEL2ORG = new ORMCL_LEVEL2ORG();

    /**
     * 代码表--户口类型
     *
     * @type {PIMCL_HKLX}
     * @memberof CodeListService
     */
    public PIMCL_HKLX: PIMCL_HKLX = new PIMCL_HKLX();

    /**
     * 代码表--员工状态
     *
     * @type {PIMCL_YGZT}
     * @memberof CodeListService
     */
    public PIMCL_YGZT: PIMCL_YGZT = new PIMCL_YGZT();

    /**
     * 代码表--合同类别
     *
     * @type {PIMCL_HTLX}
     * @memberof CodeListService
     */
    public PIMCL_HTLX: PIMCL_HTLX = new PIMCL_HTLX();

    /**
     * 代码表--证件类型
     *
     * @type {PIMCL_ZJLX}
     * @memberof CodeListService
     */
    public PIMCL_ZJLX: PIMCL_ZJLX = new PIMCL_ZJLX();

    /**
     * 代码表--惩罚类型
     *
     * @type {PIMCL_JCLX}
     * @memberof CodeListService
     */
    public PIMCL_JCLX: PIMCL_JCLX = new PIMCL_JCLX();

    /**
     * 代码表--分配类型
     *
     * @type {PIMCL_FPLX}
     * @memberof CodeListService
     */
    public PIMCL_FPLX: PIMCL_FPLX = new PIMCL_FPLX();

    /**
     * 代码表--合同类型
     *
     * @type {PIMCL_TYPECONTRACT}
     * @memberof CodeListService
     */
    public PIMCL_TYPECONTRACT: PIMCL_TYPECONTRACT = new PIMCL_TYPECONTRACT();

    /**
     * 代码表--奖惩级别
     *
     * @type {PIMCL_JCJB}
     * @memberof CodeListService
     */
    public PIMCL_JCJB: PIMCL_JCJB = new PIMCL_JCJB();

    /**
     * 代码表--职称类型
     *
     * @type {PIMCL_ZCLX}
     * @memberof CodeListService
     */
    public PIMCL_ZCLX: PIMCL_ZCLX = new PIMCL_ZCLX();

    /**
     * 代码表--档级
     *
     * @type {PIMCL_DANGJI}
     * @memberof CodeListService
     */
    public PIMCL_DANGJI: PIMCL_DANGJI = new PIMCL_DANGJI();

    /**
     * 代码表--考勤类型
     *
     * @type {ATTCL_KQLX}
     * @memberof CodeListService
     */
    public ATTCL_KQLX: ATTCL_KQLX = new ATTCL_KQLX();

    /**
     * 代码表--分配状态
     *
     * @type {PIMCL_FPZT}
     * @memberof CodeListService
     */
    public PIMCL_FPZT: PIMCL_FPZT = new PIMCL_FPZT();

    /**
     * 代码表--职级
     *
     * @type {PIMCL_RANK}
     * @memberof CodeListService
     */
    public PIMCL_RANK: PIMCL_RANK = new PIMCL_RANK();

    /**
     * 代码表--学位
     *
     * @type {PIMCL_XWLX}
     * @memberof CodeListService
     */
    public PIMCL_XWLX: PIMCL_XWLX = new PIMCL_XWLX();

    /**
     * 代码表--员工类型
     *
     * @type {PIMCL_YGLX}
     * @memberof CodeListService
     */
    public PIMCL_YGLX: PIMCL_YGLX = new PIMCL_YGLX();

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
     * 代码表--岗位（基础管理）
     *
     * @type {ORMCL_GW}
     * @memberof CodeListService
     */
    public ORMCL_GW: ORMCL_GW = new ORMCL_GW();

    /**
     * 代码表--所属区域
     *
     * @type {EhrCodeListSsqy}
     * @memberof CodeListService
     */
    public EhrCodeListSsqy: EhrCodeListSsqy = new EhrCodeListSsqy();

    /**
     * 代码表--性别
     *
     * @type {PIMCL_XB}
     * @memberof CodeListService
     */
    public PIMCL_XB: PIMCL_XB = new PIMCL_XB();

    /**
     * 代码表--军转级别
     *
     * @type {PIMCL_LEVEL}
     * @memberof CodeListService
     */
    public PIMCL_LEVEL: PIMCL_LEVEL = new PIMCL_LEVEL();

    /**
     * 代码表--家庭情况-与本人关系
     *
     * @type {PIMCL_YBRGX}
     * @memberof CodeListService
     */
    public PIMCL_YBRGX: PIMCL_YBRGX = new PIMCL_YBRGX();

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
     * 代码表--外语考试等级
     *
     * @type {LanguageLevel}
     * @memberof CodeListService
     */
    public LanguageLevel: LanguageLevel = new LanguageLevel();

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