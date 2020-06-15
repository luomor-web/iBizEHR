import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考核方案服务对象基类
 *
 * @export
 * @class ParJxkhxhzServiceBase
 * @extends {EntityServie}
 */
export default class ParJxkhxhzServiceBase extends EntityService {

    /**
     * Creates an instance of  ParJxkhxhzServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParJxkhxhzServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParJxkhxhzServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parjxkhxhz';
        this.APPDEKEY = 'parjxkhxhzid';
        this.APPDENAME = 'parjxkhxhzs';
        this.APPDETEXT = 'parjxkhxhzname';
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
     * @memberof ParJxkhxhzServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && context.parjxkhxhz){
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs/${context.parjxkhxhz}/select`,isloading);
        }
            return Http.getInstance().get(`/parjxkhxhzs/${context.parjxkhxhz}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhxhzServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && true){
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs/getdraft`,isloading);
        }
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
     * @memberof ParJxkhxhzServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && context.parjxkhxhz){
            return Http.getInstance().put(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs/${context.parjxkhxhz}`,data,isloading);
        }
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
     * @memberof ParJxkhxhzServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && context.parjxkhxhz){
            return Http.getInstance().post(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs/${context.parjxkhxhz}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/parjxkhxhzs/${context.parjxkhxhz}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhxhzServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && context.parjxkhxhz){
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs/${context.parjxkhxhz}`,isloading);
        }
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
     * @memberof ParJxkhxhzServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && context.parjxkhxhz){
            return Http.getInstance().delete(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs/${context.parjxkhxhz}`,isloading);
        }
            return Http.getInstance().delete(`/parjxkhxhzs/${context.parjxkhxhz}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParJxkhxhzServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs`,data,isloading);
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
     * @memberof ParJxkhxhzServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && context.parjxkhxhz){
            return Http.getInstance().post(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs/${context.parjxkhxhz}/save`,data,isloading);
        }
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
     * @memberof ParJxkhxhzServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.parassesstemplate && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/parassesstemplates/${context.parassesstemplate}/parjxkhxhzs/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parjxkhxhzs/fetchdefault`,tempData,isloading);
    }
}