import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 年度量化目标明细（公司领导类 ）服务对象基类
 *
 * @export
 * @class ParLdndlhmbmxServiceBase
 * @extends {EntityServie}
 */
export default class ParLdndlhmbmxServiceBase extends EntityService {

    /**
     * Creates an instance of  ParLdndlhmbmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParLdndlhmbmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParLdndlhmbmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parldndlhmbmx';
        this.APPDEKEY = 'parldndlhmbmxid';
        this.APPDENAME = 'parldndlhmbmxes';
        this.APPDETEXT = 'parldndlhmbmxname';
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
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && context.parldndlhmbmx){
            return Http.getInstance().get(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes/${context.parldndlhmbmx}/select`,isloading);
        }
            return Http.getInstance().get(`/parldndlhmbmxes/${context.parldndlhmbmx}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && context.parldndlhmbmx){
            return Http.getInstance().get(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes/${context.parldndlhmbmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/parldndlhmbmxes/${context.parldndlhmbmx}`,isloading);
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && true){
            return Http.getInstance().get(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/parldndlhmbmxes/getdraft`,isloading);
        res.data.parldndlhmbmx = data.parldndlhmbmx;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/parldndlhmbmxes`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && context.parldndlhmbmx){
            return Http.getInstance().post(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes/${context.parldndlhmbmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parldndlhmbmxes/${context.parldndlhmbmx}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && context.parldndlhmbmx){
            return Http.getInstance().delete(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes/${context.parldndlhmbmx}`,isloading);
        }
            return Http.getInstance().delete(`/parldndlhmbmxes/${context.parldndlhmbmx}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && context.parldndlhmbmx){
            return Http.getInstance().post(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes/${context.parldndlhmbmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/parldndlhmbmxes/${context.parldndlhmbmx}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && context.parldndlhmbmx){
            return Http.getInstance().put(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes/${context.parldndlhmbmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parldndlhmbmxes/${context.parldndlhmbmx}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParLdndlhmbmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parldndlhmb && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/parldndlhmbs/${context.parldndlhmb}/parldndlhmbmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parldndlhmbmxes/fetchdefault`,tempData,isloading);
    }
}