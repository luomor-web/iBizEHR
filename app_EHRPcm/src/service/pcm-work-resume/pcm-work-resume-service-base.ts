import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工作履历服务对象基类
 *
 * @export
 * @class PcmWorkResumeServiceBase
 * @extends {EntityServie}
 */
export default class PcmWorkResumeServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmWorkResumeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmWorkResumeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmWorkResumeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmworkresume';
        this.APPDEKEY = 'pcmworkresumeid';
        this.APPDENAME = 'pcmworkresumes';
        this.APPDETEXT = 'pcmworkresumename';
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
     * @memberof PcmWorkResumeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmworkresume){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes/${context.pcmworkresume}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmworkresumes/${context.pcmworkresume}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmWorkResumeServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmworkresumes`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmWorkResumeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmworkresumes/getdraft`,isloading);
        res.data.pcmworkresume = data.pcmworkresume;
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmWorkResumeServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmworkresume){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes/${context.pcmworkresume}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmworkresumes/${context.pcmworkresume}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmWorkResumeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmworkresume){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes/${context.pcmworkresume}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmworkresumes/${context.pcmworkresume}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmWorkResumeServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmworkresume){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes/${context.pcmworkresume}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmworkresumes/${context.pcmworkresume}`,data,isloading);
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmWorkResumeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmworkresume){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes/${context.pcmworkresume}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmworkresumes/${context.pcmworkresume}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmWorkResumeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmworkresume){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes/${context.pcmworkresume}`,isloading);
        }
            return Http.getInstance().delete(`/pcmworkresumes/${context.pcmworkresume}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmWorkResumeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmworkresumes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmworkresumes/fetchdefault`,tempData,isloading);
    }
}