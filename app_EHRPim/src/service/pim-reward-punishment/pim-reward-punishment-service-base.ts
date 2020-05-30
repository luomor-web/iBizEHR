import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 奖惩信息服务对象基类
 *
 * @export
 * @class PimRewardPunishmentServiceBase
 * @extends {EntityServie}
 */
export default class PimRewardPunishmentServiceBase extends EntityService {

    /**
     * Creates an instance of  PimRewardPunishmentServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimRewardPunishmentServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimRewardPunishmentServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimrewardpunishment';
        this.APPDEKEY = 'pimrewardpunishmentid';
        this.APPDENAME = 'pimrewardpunishments';
        this.APPDETEXT = 'pimrewardpunishmentname';
        this.APPNAME = 'ehrpim';
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
     * @memberof PimRewardPunishmentServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimrewardpunishment){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimrewardpunishments/${context.pimrewardpunishment}/select`,isloading);
        }
            return Http.getInstance().get(`/pimrewardpunishments/${context.pimrewardpunishment}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimrewardpunishment){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimrewardpunishments/${context.pimrewardpunishment}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimrewardpunishments/${context.pimrewardpunishment}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimrewardpunishment){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimrewardpunishments/${context.pimrewardpunishment}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimrewardpunishments/${context.pimrewardpunishment}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimrewardpunishment){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimrewardpunishments/${context.pimrewardpunishment}`,isloading);
        }
            return Http.getInstance().delete(`/pimrewardpunishments/${context.pimrewardpunishment}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimrewardpunishment){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimrewardpunishments/${context.pimrewardpunishment}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimrewardpunishments/${context.pimrewardpunishment}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimrewardpunishments/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimrewardpunishments/getdraft`,isloading);
        res.data.pimrewardpunishment = data.pimrewardpunishment;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimrewardpunishments`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimrewardpunishments`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimrewardpunishment){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimrewardpunishments/${context.pimrewardpunishment}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimrewardpunishments/${context.pimrewardpunishment}`,data,isloading);
            return res;
    }

    /**
     * FetchZIZHU接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async FetchZIZHU(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimrewardpunishments/fetchzizhu`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimrewardpunishments/fetchzizhu`,tempData,isloading);
    }

    /**
     * FetchHONORARY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async FetchHONORARY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimrewardpunishments/fetchhonorary`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimrewardpunishments/fetchhonorary`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimrewardpunishments/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimrewardpunishments/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimRewardPunishmentServiceBase
     */
    public async FetchJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimrewardpunishments/fetchjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimrewardpunishments/fetchjlss`,tempData,isloading);
    }
}