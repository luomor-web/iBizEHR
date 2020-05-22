import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考核内容评分汇总服务对象基类
 *
 * @export
 * @class PARJXKHXHZServiceBase
 * @extends {EntityServie}
 */
export default class PARJXKHXHZServiceBase extends EntityService {

    /**
     * Creates an instance of  PARJXKHXHZServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PARJXKHXHZServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PARJXKHXHZServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parjxkhxhz';
        this.APPDEKEY = 'parjxkhxhzid';
        this.APPDENAME = 'parjxkhxhzs';
        this.APPDETEXT = 'parjxkhxhzname';
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
     * @memberof PARJXKHXHZServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/parjxkhxhzs/${context.parjxkhxhz}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PARJXKHXHZServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/parjxkhxhzs/getdraft`,isloading);
        res.data.parjxkhxhz = data.parjxkhxhz;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PARJXKHXHZServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parjxkhxhzs/${context.parjxkhxhz}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PARJXKHXHZServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/parjxkhxhzs/${context.parjxkhxhz}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PARJXKHXHZServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/parjxkhxhzs/${context.parjxkhxhz}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PARJXKHXHZServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/parjxkhxhzs/${context.parjxkhxhz}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PARJXKHXHZServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/parjxkhxhzs`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PARJXKHXHZServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parjxkhxhzs/${context.parjxkhxhz}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PARJXKHXHZServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parjxkhxhzs/fetchdefault`,tempData,isloading);
    }
}