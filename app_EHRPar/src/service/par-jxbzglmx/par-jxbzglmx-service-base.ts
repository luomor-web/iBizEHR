import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 绩效标准管理明细服务对象基类
 *
 * @export
 * @class ParJxbzglmxServiceBase
 * @extends {EntityServie}
 */
export default class ParJxbzglmxServiceBase extends EntityService {

    /**
     * Creates an instance of  ParJxbzglmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParJxbzglmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParJxbzglmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parjxbzglmx';
        this.APPDEKEY = 'parjxbzglmxid';
        this.APPDENAME = 'parjxbzglmxes';
        this.APPDETEXT = 'parjxbzglmxname';
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
     * @memberof ParJxbzglmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parjxbzglmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parjxbzglmxes/${context.parjxbzglmx}/select`,isloading);
        }
        if(context.parjxbzgl && context.parjxbzglmx){
            return Http.getInstance().get(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes/${context.parjxbzglmx}/select`,isloading);
        }
            return Http.getInstance().get(`/parjxbzglmxes/${context.parjxbzglmx}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parjxbzglmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/parjxbzglmxes/${context.parjxbzglmx}`,data,isloading);
        }
        if(context.parjxbzgl && context.parjxbzglmx){
            return Http.getInstance().put(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes/${context.parjxbzglmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parjxbzglmxes/${context.parjxbzglmx}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parjxbzglmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parjxbzglmxes/${context.parjxbzglmx}/save`,data,isloading);
        }
        if(context.parjxbzgl && context.parjxbzglmx){
            return Http.getInstance().post(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes/${context.parjxbzglmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parjxbzglmxes/${context.parjxbzglmx}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parjxbzglmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parjxbzglmxes/${context.parjxbzglmx}`,isloading);
        }
        if(context.parjxbzgl && context.parjxbzglmx){
            return Http.getInstance().get(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes/${context.parjxbzglmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/parjxbzglmxes/${context.parjxbzglmx}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parjxbzglmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/parjxbzglmxes/${context.parjxbzglmx}`,isloading);
        }
        if(context.parjxbzgl && context.parjxbzglmx){
            return Http.getInstance().delete(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes/${context.parjxbzglmx}`,isloading);
        }
            return Http.getInstance().delete(`/parjxbzglmxes/${context.parjxbzglmx}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parjxbzglmxes`,data,isloading);
        }
        if(context.parjxbzgl && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/parjxbzglmxes`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parjxbzglmxes/getdraft`,isloading);
        }
        if(context.parjxbzgl && true){
            return Http.getInstance().get(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/parjxbzglmxes/getdraft`,isloading);
        res.data.parjxbzglmx = data.parjxbzglmx;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.parjxbzglmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/parjxbzglmxes/${context.parjxbzglmx}/checkkey`,data,isloading);
        }
        if(context.parjxbzgl && context.parjxbzglmx){
            return Http.getInstance().post(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes/${context.parjxbzglmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/parjxbzglmxes/${context.parjxbzglmx}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxbzglmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/parjxbzglmxes/fetchdefault`,tempData,isloading);
        }
        if(context.parjxbzgl && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/parjxbzgls/${context.parjxbzgl}/parjxbzglmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parjxbzglmxes/fetchdefault`,tempData,isloading);
    }
}