import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门管理服务对象基类
 *
 * @export
 * @class OrmOrgsectorServiceBase
 * @extends {EntityServie}
 */
export default class OrmOrgsectorServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmOrgsectorServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgsectorServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmOrgsectorServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormorgsector';
        this.APPDEKEY = 'orgsectorid';
        this.APPDENAME = 'ormorgsectors';
        this.APPDETEXT = 'orgsectorname';
        this.APPNAME = 'ehrsal';
        this.SYSTEMNAME = 'ehr';
    }

// 实体接口

    /**
     * Select接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/select`,isloading);
        }
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/select`,isloading);
    }

    /**
     * ChangeEdition接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async ChangeEdition(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/changeedition`,data,isloading);
        }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/changeedition`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ormorgsectors`,data,isloading);
        return res;
    }

    /**
     * SynOrgSectPro接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async SynOrgSectPro(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/synorgsectpro`,data,isloading);
        }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/synorgsectpro`,data,isloading);
    }

    /**
     * CLWC接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async CLWC(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/clwc`,data,isloading);
        }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/clwc`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormorgsectors/getdraft`,isloading);
        res.data.ormorgsector = data.ormorgsector;
        return res;
    }

    /**
     * TJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async TJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/tj`,data,isloading);
        }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/tj`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormorgsectors/${context.ormorgsector}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}`,isloading);
            return res;

    }

    /**
     * SynOrgSectOderNum接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async SynOrgSectOderNum(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/synorgsectodernum`,data,isloading);
        }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/synorgsectodernum`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}`,isloading);
        }
            return Http.getInstance().delete(`/ormorgsectors/${context.ormorgsector}`,isloading);

    }

    /**
     * SynOrgSec接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async SynOrgSec(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/synorgsec`,data,isloading);
        }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/synorgsec`,data,isloading);
    }

    /**
     * FetchCURORMORG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchCURORMORG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchcurormorg`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchcurormorg`,tempData,isloading);
    }

    /**
     * FetchXMBBZGL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchXMBBZGL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchxmbbzgl`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchxmbbzgl`,tempData,isloading);
    }

    /**
     * FetchJSYXMB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchJSYXMB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchjsyxmb`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchjsyxmb`,tempData,isloading);
    }

    /**
     * FetchCurZZBM接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchCurZZBM(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchcurzzbm`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchcurzzbm`,tempData,isloading);
    }

    /**
     * FetchCurZZBM_KQSZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchCurZZBM_KQSZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchcurzzbm_kqsz`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchcurzzbm_kqsz`,tempData,isloading);
    }

    /**
     * FetchCURORG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchCURORG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchcurorg`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchcurorg`,tempData,isloading);
    }

    /**
     * FetchCurOrgSector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchCurOrgSector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchcurorgsector`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchcurorgsector`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchBaseInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchBaseInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchbaseinfo`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchbaseinfo`,tempData,isloading);
    }

    /**
     * FetchDQZZXBM接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchDQZZXBM(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchdqzzxbm`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchdqzzxbm`,tempData,isloading);
    }

    /**
     * FetchRsshInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchRsshInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchrsshinfo`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchrsshinfo`,tempData,isloading);
    }

    /**
     * FetchSubOrgsector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchSubOrgsector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchsuborgsector`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchsuborgsector`,tempData,isloading);
    }

    /**
     * FetchPimpersonInfoOrgsector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchPimpersonInfoOrgsector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchpimpersoninfoorgsector`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchpimpersoninfoorgsector`,tempData,isloading);
    }

    /**
     * FetchHisInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchHisInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchhisinfo`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchhisinfo`,tempData,isloading);
    }

    /**
     * FetchSubZZBM接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchSubZZBM(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchsubzzbm`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchsubzzbm`,tempData,isloading);
    }

    /**
     * FetchProExpandInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchProExpandInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchproexpandinfo`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchproexpandinfo`,tempData,isloading);
    }

    /**
     * FetchBMBZGL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgsectorServiceBase
     */
    public async FetchBMBZGL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/fetchbmbzgl`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgsectors/fetchbmbzgl`,tempData,isloading);
    }
}