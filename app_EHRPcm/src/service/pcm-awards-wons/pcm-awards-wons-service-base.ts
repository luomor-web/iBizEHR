import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 获奖情况服务对象基类
 *
 * @export
 * @class PcmAwardsWonsServiceBase
 * @extends {EntityServie}
 */
export default class PcmAwardsWonsServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmAwardsWonsServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmAwardsWonsServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmAwardsWonsServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmawardswons';
        this.APPDEKEY = 'pcmawardswonsid';
        this.APPDENAME = 'pcmawardswons';
        this.APPDETEXT = 'pcmawardswonsname';
        this.APPNAME = 'ehrpcm';
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
     * @memberof PcmAwardsWonsServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmawardswons){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmawardswons/${context.pcmawardswons}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmawardswons/${context.pcmawardswons}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmAwardsWonsServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmawardswons/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmawardswons/getdraft`,isloading);
        res.data.pcmawardswons = data.pcmawardswons;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmAwardsWonsServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmawardswons){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmawardswons/${context.pcmawardswons}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmawardswons/${context.pcmawardswons}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmAwardsWonsServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmawardswons){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmawardswons/${context.pcmawardswons}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmawardswons/${context.pcmawardswons}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmAwardsWonsServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmawardswons`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmawardswons`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmAwardsWonsServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmawardswons){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmawardswons/${context.pcmawardswons}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmawardswons/${context.pcmawardswons}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmAwardsWonsServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmawardswons){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmawardswons/${context.pcmawardswons}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmawardswons/${context.pcmawardswons}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmAwardsWonsServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmawardswons){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmawardswons/${context.pcmawardswons}`,isloading);
        }
            return Http.getInstance().delete(`/pcmawardswons/${context.pcmawardswons}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmAwardsWonsServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmawardswons/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmawardswons/fetchdefault`,tempData,isloading);
    }
}