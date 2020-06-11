import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 通知选择职能部门明细服务对象基类
 *
 * @export
 * @class ParZnbmmxServiceBase
 * @extends {EntityServie}
 */
export default class ParZnbmmxServiceBase extends EntityService {

    /**
     * Creates an instance of  ParZnbmmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParZnbmmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParZnbmmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parznbmmx';
        this.APPDEKEY = 'parznbmmxid';
        this.APPDENAME = 'parznbmmxes';
        this.APPDETEXT = 'parznbmmxname';
        this.APPNAME = 'ehrpar';
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
     * @memberof ParZnbmmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && context.parznbmmx){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parznbmmxes/${context.parznbmmx}/select`,isloading);
        }
            return Http.getInstance().get(`/parznbmmxes/${context.parznbmmx}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParZnbmmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && context.parznbmmx){
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parznbmmxes/${context.parznbmmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/parznbmmxes/${context.parznbmmx}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParZnbmmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && context.parznbmmx){
            return Http.getInstance().put(`/partzggs/${context.partzgg}/parznbmmxes/${context.parznbmmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parznbmmxes/${context.parznbmmx}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParZnbmmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && true){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parznbmmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/parznbmmxes/getdraft`,isloading);
        res.data.parznbmmx = data.parznbmmx;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParZnbmmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parznbmmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/parznbmmxes`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParZnbmmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && context.parznbmmx){
            return Http.getInstance().delete(`/partzggs/${context.partzgg}/parznbmmxes/${context.parznbmmx}`,isloading);
        }
            return Http.getInstance().delete(`/parznbmmxes/${context.parznbmmx}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParZnbmmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && context.parznbmmx){
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parznbmmxes/${context.parznbmmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parznbmmxes/${context.parznbmmx}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParZnbmmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && context.parznbmmx){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parznbmmxes/${context.parznbmmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/parznbmmxes/${context.parznbmmx}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParZnbmmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.partzgg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parznbmmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parznbmmxes/fetchdefault`,tempData,isloading);
    }
}