import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 班主任服务对象基类
 *
 * @export
 * @class TrmHmatserServiceBase
 * @extends {EntityServie}
 */
export default class TrmHmatserServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmHmatserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmHmatserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmHmatserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmhmatser';
        this.APPDEKEY = 'trmhmatserid';
        this.APPDENAME = 'trmhmatsers';
        this.APPDETEXT = 'trmhmatsername';
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
     * @memberof TrmHmatserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmhmatser){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers/${context.trmhmatser}/select`,isloading);
        }
            return Http.getInstance().get(`/trmhmatsers/${context.trmhmatser}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmHmatserServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmhmatser){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers/${context.trmhmatser}`,isloading);
        }
            return Http.getInstance().delete(`/trmhmatsers/${context.trmhmatser}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmHmatserServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmhmatser){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers/${context.trmhmatser}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmhmatsers/${context.trmhmatser}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmHmatserServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmhmatser){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers/${context.trmhmatser}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmhmatsers/${context.trmhmatser}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmHmatserServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmhmatsers`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmHmatserServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmhmatser){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers/${context.trmhmatser}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmhmatsers/${context.trmhmatser}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmHmatserServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmhmatsers/getdraft`,isloading);
        res.data.trmhmatser = data.trmhmatser;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmHmatserServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmhmatser){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers/${context.trmhmatser}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmhmatsers/${context.trmhmatser}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmHmatserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmhmatsers/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmhmatsers/fetchdefault`,tempData,isloading);
    }
}