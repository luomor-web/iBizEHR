import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 人员信息变更审核服务对象基类
 *
 * @export
 * @class PimPersonChangeServiceBase
 * @extends {EntityServie}
 */
export default class PimPersonChangeServiceBase extends EntityService {

    /**
     * Creates an instance of  PimPersonChangeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPersonChangeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimPersonChangeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimpersonchange';
        this.APPDEKEY = 'pimpersonchangeid';
        this.APPDENAME = 'pimpersonchanges';
        this.APPDETEXT = 'pimpersonchangename';
        this.APPNAME = 'ehrhelp';
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
     * @memberof PimPersonChangeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}/select`,isloading);
        }
            return Http.getInstance().get(`/pimpersonchanges/${context.pimpersonchange}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimpersonchanges/${context.pimpersonchange}/save`,data,isloading);
            return res;
    }

    /**
     * BH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async BH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}/bh`,data,isloading);
        }
            return Http.getInstance().post(`/pimpersonchanges/${context.pimpersonchange}/bh`,data,isloading);
    }

    /**
     * Ensure接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async Ensure(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}/ensure`,data,isloading);
        }
            return Http.getInstance().post(`/pimpersonchanges/${context.pimpersonchange}/ensure`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimpersonchanges/${context.pimpersonchange}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimpersonchanges/${context.pimpersonchange}`,isloading);
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonchanges`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimpersonchanges`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}`,isloading);
        }
            return Http.getInstance().delete(`/pimpersonchanges/${context.pimpersonchange}`,isloading);

    }

    /**
     * QR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async QR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}/qr`,data,isloading);
        }
            return Http.getInstance().post(`/pimpersonchanges/${context.pimpersonchange}/qr`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimpersonchange){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimpersonchanges/${context.pimpersonchange}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimpersonchanges/${context.pimpersonchange}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonchanges/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimpersonchanges/getdraft`,isloading);
        res.data.pimpersonchange = data.pimpersonchange;
        return res;
    }

    /**
     * FetchHistoryRec接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async FetchHistoryRec(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonchanges/fetchhistoryrec`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpersonchanges/fetchhistoryrec`,tempData,isloading);
    }

    /**
     * FetchPIMCL_NOTAPPROVAL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async FetchPIMCL_NOTAPPROVAL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonchanges/fetchpimcl_notapproval`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpersonchanges/fetchpimcl_notapproval`,tempData,isloading);
    }

    /**
     * FetchHeadRed接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async FetchHeadRed(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonchanges/fetchheadred`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpersonchanges/fetchheadred`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonChangeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimpersonchanges/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpersonchanges/fetchdefault`,tempData,isloading);
    }
}