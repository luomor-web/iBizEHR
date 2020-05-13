import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 投递职位摘要信息服务对象基类
 *
 * @export
 * @class TDZWXXServiceBase
 * @extends {EntityServie}
 */
export default class TDZWXXServiceBase extends EntityService {

    /**
     * Creates an instance of  TDZWXXServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TDZWXXServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TDZWXXServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='tdzwxx';
        this.APPDEKEY = 'tdzwxxid';
        this.APPDENAME = 'tdzwxxes';
        this.APPDETEXT = 'tdzwxxname';
        this.APPNAME = 'ehrpcm';
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
     * @memberof TDZWXXServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.tdzwxx){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/tdzwxxes/${context.tdzwxx}/select`,isloading);
        }
            return Http.getInstance().get(`/tdzwxxes/${context.tdzwxx}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TDZWXXServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/tdzwxxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/tdzwxxes`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TDZWXXServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/tdzwxxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/tdzwxxes/getdraft`,isloading);
        res.data.tdzwxx = data.tdzwxx;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TDZWXXServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.tdzwxx){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/tdzwxxes/${context.tdzwxx}`,isloading);
        }
            return Http.getInstance().delete(`/tdzwxxes/${context.tdzwxx}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TDZWXXServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.tdzwxx){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/tdzwxxes/${context.tdzwxx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/tdzwxxes/${context.tdzwxx}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TDZWXXServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.tdzwxx){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/tdzwxxes/${context.tdzwxx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/tdzwxxes/${context.tdzwxx}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TDZWXXServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.tdzwxx){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/tdzwxxes/${context.tdzwxx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/tdzwxxes/${context.tdzwxx}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TDZWXXServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.tdzwxx){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/tdzwxxes/${context.tdzwxx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/tdzwxxes/${context.tdzwxx}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TDZWXXServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/tdzwxxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/tdzwxxes/fetchdefault`,tempData,isloading);
    }
}