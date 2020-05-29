import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 项目标签服务对象基类
 *
 * @export
 * @class ORMXMBQServiceBase
 * @extends {EntityServie}
 */
export default class ORMXMBQServiceBase extends EntityService {

    /**
     * Creates an instance of  ORMXMBQServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ORMXMBQServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ORMXMBQServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormxmbq';
        this.APPDEKEY = 'ormxmbqid';
        this.APPDENAME = 'ormxmbqs';
        this.APPDETEXT = 'ormxmbqname';
        this.APPNAME = 'ehrorm';
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
     * @memberof ORMXMBQServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormxmbq){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormxmbqs/${context.ormxmbq}/select`,isloading);
        }
            return Http.getInstance().get(`/ormxmbqs/${context.ormxmbq}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMXMBQServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormxmbq){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormxmbqs/${context.ormxmbq}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ormxmbqs/${context.ormxmbq}`,isloading);
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMXMBQServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormxmbqs`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/ormxmbqs`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMXMBQServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormxmbq){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormxmbqs/${context.ormxmbq}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormxmbqs/${context.ormxmbq}/save`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMXMBQServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormxmbq){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormxmbqs/${context.ormxmbq}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ormxmbqs/${context.ormxmbq}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMXMBQServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormxmbqs/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ormxmbqs/getdraft`,isloading);
        res.data.ormxmbq = data.ormxmbq;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMXMBQServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormxmbq){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormxmbqs/${context.ormxmbq}`,isloading);
        }
            return Http.getInstance().delete(`/ormxmbqs/${context.ormxmbq}`,isloading);

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMXMBQServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && context.ormxmbq){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormxmbqs/${context.ormxmbq}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormxmbqs/${context.ormxmbq}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMXMBQServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormxmbqs/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormxmbqs/fetchdefault`,tempData,isloading);
    }
}