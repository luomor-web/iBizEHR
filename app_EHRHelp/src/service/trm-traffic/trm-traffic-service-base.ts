import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 交通服务对象基类
 *
 * @export
 * @class TrmTrafficServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrafficServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrafficServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrafficServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrafficServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtraffic';
        this.APPDEKEY = 'trmtrafficid';
        this.APPDENAME = 'trmtraffics';
        this.APPDETEXT = 'trmtrafficname';
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
     * @memberof TrmTrafficServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtraffic){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics/${context.trmtraffic}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtraffics/${context.trmtraffic}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrafficServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtraffics/getdraft`,isloading);
        res.data.trmtraffic = data.trmtraffic;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrafficServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtraffic){
            return Http.getInstance().delete(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics/${context.trmtraffic}`,isloading);
        }
            return Http.getInstance().delete(`/trmtraffics/${context.trmtraffic}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrafficServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtraffic){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics/${context.trmtraffic}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtraffics/${context.trmtraffic}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrafficServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtraffic){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics/${context.trmtraffic}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtraffics/${context.trmtraffic}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrafficServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtraffic){
            return Http.getInstance().put(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics/${context.trmtraffic}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtraffics/${context.trmtraffic}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrafficServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmtraffics`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrafficServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && context.trmtraffic){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics/${context.trmtraffic}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtraffics/${context.trmtraffic}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrafficServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainaddress && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmtraffics/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtraffics/fetchdefault`,tempData,isloading);
    }
}