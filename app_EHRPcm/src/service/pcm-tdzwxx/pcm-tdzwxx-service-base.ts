import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 投递职位摘要信息服务对象基类
 *
 * @export
 * @class PcmTdzwxxServiceBase
 * @extends {EntityServie}
 */
export default class PcmTdzwxxServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmTdzwxxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmTdzwxxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmTdzwxxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmtdzwxx';
        this.APPDEKEY = 'tdzwxxid';
        this.APPDENAME = 'pcmtdzwxxes';
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
     * @memberof PcmTdzwxxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtdzwxx){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes/${context.pcmtdzwxx}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmtdzwxxes/${context.pcmtdzwxx}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTdzwxxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmtdzwxxes`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTdzwxxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmtdzwxxes/getdraft`,isloading);
        res.data.pcmtdzwxx = data.pcmtdzwxx;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTdzwxxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtdzwxx){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes/${context.pcmtdzwxx}`,isloading);
        }
            return Http.getInstance().delete(`/pcmtdzwxxes/${context.pcmtdzwxx}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTdzwxxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtdzwxx){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes/${context.pcmtdzwxx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmtdzwxxes/${context.pcmtdzwxx}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTdzwxxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtdzwxx){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes/${context.pcmtdzwxx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmtdzwxxes/${context.pcmtdzwxx}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTdzwxxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtdzwxx){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes/${context.pcmtdzwxx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmtdzwxxes/${context.pcmtdzwxx}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTdzwxxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtdzwxx){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes/${context.pcmtdzwxx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmtdzwxxes/${context.pcmtdzwxx}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTdzwxxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmtdzwxxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmtdzwxxes/fetchdefault`,tempData,isloading);
    }
}