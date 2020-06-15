import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考核模板明细服务对象基类
 *
 * @export
 * @class ParKhzcmxServiceBase
 * @extends {EntityServie}
 */
export default class ParKhzcmxServiceBase extends EntityService {

    /**
     * Creates an instance of  ParKhzcmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParKhzcmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParKhzcmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parkhzcmx';
        this.APPDEKEY = 'parkhzcmxid';
        this.APPDENAME = 'parkhzcmxes';
        this.APPDETEXT = 'parkhzcmxname';
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
     * @memberof ParKhzcmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && context.parkhzcmx){
            return Http.getInstance().get(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes/${context.parkhzcmx}/select`,isloading);
        }
        if(context.parassesstemplate && context.parkhzcmx){
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes/${context.parkhzcmx}/select`,isloading);
        }
            return Http.getInstance().get(`/parkhzcmxes/${context.parkhzcmx}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParKhzcmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes`,data,isloading);
        }
        if(context.parassesstemplate && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/parkhzcmxes`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParKhzcmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && context.parkhzcmx){
            return Http.getInstance().post(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes/${context.parkhzcmx}/save`,data,isloading);
        }
        if(context.parassesstemplate && context.parkhzcmx){
            return Http.getInstance().post(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes/${context.parkhzcmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/parkhzcmxes/${context.parkhzcmx}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParKhzcmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && context.parkhzcmx){
            return Http.getInstance().get(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes/${context.parkhzcmx}`,isloading);
        }
        if(context.parassesstemplate && context.parkhzcmx){
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes/${context.parkhzcmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/parkhzcmxes/${context.parkhzcmx}`,isloading);
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParKhzcmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && true){
            return Http.getInstance().get(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes/getdraft`,isloading);
        }
        if(context.parassesstemplate && true){
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/parkhzcmxes/getdraft`,isloading);
        res.data.parkhzcmx = data.parkhzcmx;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParKhzcmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && context.parkhzcmx){
            return Http.getInstance().delete(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes/${context.parkhzcmx}`,isloading);
        }
        if(context.parassesstemplate && context.parkhzcmx){
            return Http.getInstance().delete(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes/${context.parkhzcmx}`,isloading);
        }
            return Http.getInstance().delete(`/parkhzcmxes/${context.parkhzcmx}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParKhzcmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && context.parkhzcmx){
            return Http.getInstance().post(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes/${context.parkhzcmx}/checkkey`,data,isloading);
        }
        if(context.parassesstemplate && context.parkhzcmx){
            return Http.getInstance().post(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes/${context.parkhzcmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/parkhzcmxes/${context.parkhzcmx}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParKhzcmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && context.parkhzcmx){
            return Http.getInstance().put(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes/${context.parkhzcmx}`,data,isloading);
        }
        if(context.parassesstemplate && context.parkhzcmx){
            return Http.getInstance().put(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes/${context.parkhzcmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/parkhzcmxes/${context.parkhzcmx}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParKhzcmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parjxkhjcsz && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/parjxkhjcszs/${context.parjxkhjcsz}/parkhzcmxes/fetchdefault`,tempData,isloading);
        }
        if(context.parassesstemplate && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/parkhzcmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parkhzcmxes/fetchdefault`,tempData,isloading);
    }
}