import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作履历服务对象基类
 *
 * @export
 * @class PimWorkHistoryServiceBase
 * @extends {EntityServie}
 */
export default class PimWorkHistoryServiceBase extends EntityService {

    /**
     * Creates an instance of  PimWorkHistoryServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimWorkHistoryServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimWorkHistoryServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimworkhistory';
        this.APPDEKEY = 'pimworkhistoryid';
        this.APPDENAME = 'pimworkhistories';
        this.APPDETEXT = 'pimworkhistoryname';
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
     * @memberof PimWorkHistoryServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimworkhistory){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/${context.pimworkhistory}/select`,isloading);
        }
            return Http.getInstance().get(`/pimworkhistories/${context.pimworkhistory}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimworkhistory){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/${context.pimworkhistory}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimworkhistories/${context.pimworkhistory}`,isloading);
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimworkhistories`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimworkhistories`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimworkhistory){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimworkhistories/${context.pimworkhistory}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimworkhistories/${context.pimworkhistory}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimworkhistory){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimworkhistories/${context.pimworkhistory}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimworkhistories/${context.pimworkhistory}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimworkhistory){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimworkhistories/${context.pimworkhistory}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimworkhistories/${context.pimworkhistory}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimworkhistory){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimworkhistories/${context.pimworkhistory}`,isloading);
        }
            return Http.getInstance().delete(`/pimworkhistories/${context.pimworkhistory}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimworkhistories/getdraft`,isloading);
        res.data.pimworkhistory = data.pimworkhistory;
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimworkhistories/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchIsMain接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async FetchIsMain(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/fetchismain`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimworkhistories/fetchismain`,tempData,isloading);
    }

    /**
     * FetchJLSSGLY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async FetchJLSSGLY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/fetchjlssgly`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimworkhistories/fetchjlssgly`,tempData,isloading);
    }

    /**
     * FetchZIZHU接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async FetchZIZHU(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/fetchzizhu`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimworkhistories/fetchzizhu`,tempData,isloading);
    }

    /**
     * FetchJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async FetchJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/fetchjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimworkhistories/fetchjlss`,tempData,isloading);
    }

    /**
     * FetchFAZZSY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async FetchFAZZSY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/fetchfazzsy`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimworkhistories/fetchfazzsy`,tempData,isloading);
    }

    /**
     * FetchJLSSGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimWorkHistoryServiceBase
     */
    public async FetchJLSSGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimworkhistories/fetchjlssgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimworkhistories/fetchjlssgr`,tempData,isloading);
    }
}