import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训住宿服务对象基类
 *
 * @export
 * @class TrmStayServiceBase
 * @extends {EntityServie}
 */
export default class TrmStayServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmStayServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmStayServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmStayServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmstay';
        this.APPDEKEY = 'trmstayid';
        this.APPDENAME = 'trmstays';
        this.APPDETEXT = 'trmstayname';
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
     * @memberof TrmStayServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmstay){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays/${context.trmstay}/select`,isloading);
        }
            return Http.getInstance().get(`/trmstays/${context.trmstay}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmStayServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmstays/getdraft`,isloading);
        res.data.trmstay = data.trmstay;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmStayServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmstay){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays/${context.trmstay}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmstays/${context.trmstay}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmStayServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmstay){
            return Http.getInstance().delete(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays/${context.trmstay}`,isloading);
        }
            return Http.getInstance().delete(`/trmstays/${context.trmstay}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmStayServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmstay){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays/${context.trmstay}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmstays/${context.trmstay}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmStayServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmstay){
            return Http.getInstance().put(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays/${context.trmstay}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmstays/${context.trmstay}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmStayServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmstays`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmStayServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmstay){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays/${context.trmstay}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmstays/${context.trmstay}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmStayServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmstays/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmstays/fetchdefault`,tempData,isloading);
    }
}