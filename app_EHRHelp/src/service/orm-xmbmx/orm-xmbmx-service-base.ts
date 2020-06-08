import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 项目部明细服务对象基类
 *
 * @export
 * @class OrmXmbmxServiceBase
 * @extends {EntityServie}
 */
export default class OrmXmbmxServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmXmbmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmXmbmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmXmbmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormxmbmx';
        this.APPDEKEY = 'ormxmbmxid';
        this.APPDENAME = 'ormxmbmxes';
        this.APPDETEXT = 'ormxmbmxname';
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
     * @memberof OrmXmbmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}/select`,isloading);
        }
        if(context.pimperson && context.ormxmbmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/ormxmbmxes/${context.ormxmbmx}/select`,isloading);
        }
        if(context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}/select`,isloading);
        }
            return Http.getInstance().get(`/ormxmbmxes/${context.ormxmbmx}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmbmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}/save`,data,isloading);
        }
        if(context.pimperson && context.ormxmbmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/ormxmbmxes/${context.ormxmbmx}/save`,data,isloading);
        }
        if(context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormxmbmxes/${context.ormxmbmx}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmbmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes/getdraft`,isloading);
        }
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/ormxmbmxes/getdraft`,isloading);
        }
        if(context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormxmbmxes/getdraft`,isloading);
        res.data.ormxmbmx = data.ormxmbmx;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmbmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}`,data,isloading);
        }
        if(context.pimperson && context.ormxmbmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/ormxmbmxes/${context.ormxmbmx}`,data,isloading);
        }
        if(context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().put(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormxmbmxes/${context.ormxmbmx}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmbmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}`,isloading);
        }
        if(context.pimperson && context.ormxmbmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/ormxmbmxes/${context.ormxmbmx}`,isloading);
        }
        if(context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormxmbmxes/${context.ormxmbmx}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmbmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}/checkkey`,data,isloading);
        }
        if(context.pimperson && context.ormxmbmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/ormxmbmxes/${context.ormxmbmx}/checkkey`,data,isloading);
        }
        if(context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormxmbmxes/${context.ormxmbmx}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmbmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes`,data,isloading);
        }
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/ormxmbmxes`,data,isloading);
        }
        if(context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/ormxmbmxes`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmbmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}`,isloading);
        }
        if(context.pimperson && context.ormxmbmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/ormxmbmxes/${context.ormxmbmx}`,isloading);
        }
        if(context.ormorgsector && context.ormxmbmx){
            return Http.getInstance().delete(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes/${context.ormxmbmx}`,isloading);
        }
            return Http.getInstance().delete(`/ormxmbmxes/${context.ormxmbmx}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmXmbmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/ormxmbmxes/fetchdefault`,tempData,isloading);
        }
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/ormxmbmxes/fetchdefault`,tempData,isloading);
        }
        if(context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/ormxmbmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmbmxes/fetchdefault`,tempData,isloading);
    }
}