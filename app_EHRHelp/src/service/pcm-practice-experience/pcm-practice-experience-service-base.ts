import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 实习经验服务对象基类
 *
 * @export
 * @class PcmPracticeExperienceServiceBase
 * @extends {EntityServie}
 */
export default class PcmPracticeExperienceServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmPracticeExperienceServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmPracticeExperienceServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmPracticeExperienceServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmpracticeexperience';
        this.APPDEKEY = 'pcmpracticeexperienceid';
        this.APPDENAME = 'pcmpracticeexperiences';
        this.APPDETEXT = 'pcmpracticeexperiencename';
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
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmpracticeexperience){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences/${context.pcmpracticeexperience}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmpracticeexperiences/${context.pcmpracticeexperience}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmpracticeexperience){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences/${context.pcmpracticeexperience}`,isloading);
        }
            return Http.getInstance().delete(`/pcmpracticeexperiences/${context.pcmpracticeexperience}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmpracticeexperiences`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmpracticeexperience){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences/${context.pcmpracticeexperience}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmpracticeexperiences/${context.pcmpracticeexperience}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmpracticeexperiences/getdraft`,isloading);
        res.data.pcmpracticeexperience = data.pcmpracticeexperience;
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmpracticeexperience){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences/${context.pcmpracticeexperience}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmpracticeexperiences/${context.pcmpracticeexperience}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmpracticeexperience){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences/${context.pcmpracticeexperience}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmpracticeexperiences/${context.pcmpracticeexperience}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmpracticeexperience){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences/${context.pcmpracticeexperience}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmpracticeexperiences/${context.pcmpracticeexperience}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmPracticeExperienceServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmpracticeexperiences/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmpracticeexperiences/fetchdefault`,tempData,isloading);
    }
}