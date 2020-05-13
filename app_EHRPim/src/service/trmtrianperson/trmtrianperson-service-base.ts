import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训记录服务对象基类
 *
 * @export
 * @class TRMTRIANPERSONServiceBase
 * @extends {EntityServie}
 */
export default class TRMTRIANPERSONServiceBase extends EntityService {

    /**
     * Creates an instance of  TRMTRIANPERSONServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TRMTRIANPERSONServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TRMTRIANPERSONServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrianperson';
        this.APPDEKEY = 'trmtrianpersonid';
        this.APPDENAME = 'trmtrianpeople';
        this.APPDETEXT = 'trmtrianpersonname';
        this.APPNAME = 'ehrpim';
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
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrianperson){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrianpeople/${context.trmtrianperson}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtrianpeople/${context.trmtrianperson}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrianpeople/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtrianpeople/getdraft`,isloading);
        res.data.trmtrianperson = data.trmtrianperson;
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrianperson){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrianpeople/${context.trmtrianperson}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrianpeople/${context.trmtrianperson}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrianperson){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/trmtrianpeople/${context.trmtrianperson}`,isloading);
        }
            return Http.getInstance().delete(`/trmtrianpeople/${context.trmtrianperson}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrianperson){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrianpeople/${context.trmtrianperson}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrianpeople/${context.trmtrianperson}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrianpeople`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmtrianpeople`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrianperson){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrianpeople/${context.trmtrianperson}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtrianpeople/${context.trmtrianperson}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrianperson){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/trmtrianpeople/${context.trmtrianperson}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrianpeople/${context.trmtrianperson}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRIANPERSONServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrianpeople/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrianpeople/fetchdefault`,tempData,isloading);
    }
}