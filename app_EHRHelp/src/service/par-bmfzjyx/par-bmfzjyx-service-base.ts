import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 通知选择部门副职及以下服务对象基类
 *
 * @export
 * @class ParBmfzjyxServiceBase
 * @extends {EntityServie}
 */
export default class ParBmfzjyxServiceBase extends EntityService {

    /**
     * Creates an instance of  ParBmfzjyxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParBmfzjyxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParBmfzjyxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parbmfzjyx';
        this.APPDEKEY = 'parbmfzjyxid';
        this.APPDENAME = 'parbmfzjyxes';
        this.APPDETEXT = 'parbmfzjyxname';
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
     * @memberof ParBmfzjyxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parbmfzjyx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parbmfzjyxes/${context.parbmfzjyx}/select`,isloading);
        }
        if(context.partzgg && context.parbmfzjyx){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parbmfzjyxes/${context.parbmfzjyx}/select`,isloading);
        }
            return Http.getInstance().get(`/parbmfzjyxes/${context.parbmfzjyx}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParBmfzjyxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parbmfzjyx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parbmfzjyxes/${context.parbmfzjyx}/save`,data,isloading);
        }
        if(context.partzgg && context.parbmfzjyx){
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parbmfzjyxes/${context.parbmfzjyx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parbmfzjyxes/${context.parbmfzjyx}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParBmfzjyxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parbmfzjyxes/getdraft`,isloading);
        }
        if(context.partzgg && true){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parbmfzjyxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/parbmfzjyxes/getdraft`,isloading);
        res.data.parbmfzjyx = data.parbmfzjyx;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParBmfzjyxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parbmfzjyxes`,data,isloading);
        }
        if(context.partzgg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parbmfzjyxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/parbmfzjyxes`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParBmfzjyxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parbmfzjyx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parbmfzjyxes/${context.parbmfzjyx}/checkkey`,data,isloading);
        }
        if(context.partzgg && context.parbmfzjyx){
            return Http.getInstance().post(`/partzggs/${context.partzgg}/parbmfzjyxes/${context.parbmfzjyx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/parbmfzjyxes/${context.parbmfzjyx}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParBmfzjyxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parbmfzjyx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/parbmfzjyxes/${context.parbmfzjyx}`,isloading);
        }
        if(context.partzgg && context.parbmfzjyx){
            return Http.getInstance().delete(`/partzggs/${context.partzgg}/parbmfzjyxes/${context.parbmfzjyx}`,isloading);
        }
            return Http.getInstance().delete(`/parbmfzjyxes/${context.parbmfzjyx}`,isloading);

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParBmfzjyxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parbmfzjyx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/parbmfzjyxes/${context.parbmfzjyx}`,data,isloading);
        }
        if(context.partzgg && context.parbmfzjyx){
            return Http.getInstance().put(`/partzggs/${context.partzgg}/parbmfzjyxes/${context.parbmfzjyx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parbmfzjyxes/${context.parbmfzjyx}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParBmfzjyxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parbmfzjyx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parbmfzjyxes/${context.parbmfzjyx}`,isloading);
        }
        if(context.partzgg && context.parbmfzjyx){
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parbmfzjyxes/${context.parbmfzjyx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/parbmfzjyxes/${context.parbmfzjyx}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParBmfzjyxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parbmfzjyxes/fetchdefault`,tempData,isloading);
        }
        if(context.partzgg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/partzggs/${context.partzgg}/parbmfzjyxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parbmfzjyxes/fetchdefault`,tempData,isloading);
    }
}