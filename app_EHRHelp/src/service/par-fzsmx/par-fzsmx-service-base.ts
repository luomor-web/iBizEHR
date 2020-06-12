import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 通知选择助总领导明细服务对象基类
 *
 * @export
 * @class ParFzsmxServiceBase
 * @extends {EntityServie}
 */
export default class ParFzsmxServiceBase extends EntityService {

    /**
     * Creates an instance of  ParFzsmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParFzsmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParFzsmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parfzsmx';
        this.APPDEKEY = 'parfzsmxid';
        this.APPDENAME = 'parfzsmxes';
        this.APPDETEXT = 'parfzsmxname';
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
     * @memberof ParFzsmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parfzsmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parfzsmxes/${context.parfzsmx}/select`,isloading);
        }
        if(context.partzgg && context.parfzsmx){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parfzsmxes/${context.parfzsmx}/select`,isloading);
        }
            return Http.getInstance().get(`/parfzsmxes/${context.parfzsmx}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParFzsmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parfzsmxes/getdraft`,isloading);
        }
        if(context.partzgg && true){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parfzsmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/parfzsmxes/getdraft`,isloading);
        res.data.parfzsmx = data.parfzsmx;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParFzsmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parfzsmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/parfzsmxes/${context.parfzsmx}`,data,isloading);
        }
        if(context.partzgg && context.parfzsmx){
            return Http.getInstance().put(`/partzggs/${context.partzgg}/parfzsmxes/${context.parfzsmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parfzsmxes/${context.parfzsmx}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParFzsmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parfzsmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/parfzsmxes/${context.parfzsmx}`,isloading);
        }
        if(context.partzgg && context.parfzsmx){
            return Http.getInstance().delete(`/partzggs/${context.partzgg}/parfzsmxes/${context.parfzsmx}`,isloading);
        }
            return Http.getInstance().delete(`/parfzsmxes/${context.parfzsmx}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParFzsmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parfzsmxes`,data,isloading);
        }
        if(context.partzgg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parfzsmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/parfzsmxes`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParFzsmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parfzsmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parfzsmxes/${context.parfzsmx}/checkkey`,data,isloading);
        }
        if(context.partzgg && context.parfzsmx){
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parfzsmxes/${context.parfzsmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/parfzsmxes/${context.parfzsmx}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParFzsmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parfzsmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parfzsmxes/${context.parfzsmx}/save`,data,isloading);
        }
        if(context.partzgg && context.parfzsmx){
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parfzsmxes/${context.parfzsmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parfzsmxes/${context.parfzsmx}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParFzsmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parfzsmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parfzsmxes/${context.parfzsmx}`,isloading);
        }
        if(context.partzgg && context.parfzsmx){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parfzsmxes/${context.parfzsmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/parfzsmxes/${context.parfzsmx}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParFzsmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parfzsmxes/fetchdefault`,tempData,isloading);
        }
        if(context.partzgg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parfzsmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parfzsmxes/fetchdefault`,tempData,isloading);
    }
}