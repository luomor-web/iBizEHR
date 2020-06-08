import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 教育背景服务对象基类
 *
 * @export
 * @class PcmEducationExperienceServiceBase
 * @extends {EntityServie}
 */
export default class PcmEducationExperienceServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmEducationExperienceServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmEducationExperienceServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmEducationExperienceServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmeducationexperience';
        this.APPDEKEY = 'pcmeducationexperienceid';
        this.APPDENAME = 'pcmeducationexperiences';
        this.APPDETEXT = 'pcmeducationexperiencename';
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
     * @memberof PcmEducationExperienceServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmeducationexperiences/${context.pcmeducationexperience}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmeducationexperiences/${context.pcmeducationexperience}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmeducationexperiences/${context.pcmeducationexperience}`,isloading);
            return res;

    }

    /**
     * CheckHighestEdu接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async CheckHighestEdu(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}/checkhighestedu`,data,isloading);
        }
            return Http.getInstance().post(`/pcmeducationexperiences/${context.pcmeducationexperience}/checkhighestedu`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmeducationexperiences`,data,isloading);
        return res;
    }

    /**
     * CheckRepeatXL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async CheckRepeatXL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}/checkrepeatxl`,data,isloading);
        }
            return Http.getInstance().post(`/pcmeducationexperiences/${context.pcmeducationexperience}/checkrepeatxl`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmeducationexperiences/${context.pcmeducationexperience}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmeducationexperiences/getdraft`,isloading);
        res.data.pcmeducationexperience = data.pcmeducationexperience;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}`,isloading);
        }
            return Http.getInstance().delete(`/pcmeducationexperiences/${context.pcmeducationexperience}`,isloading);

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmeducationexperiences/${context.pcmeducationexperience}`,data,isloading);
            return res;
    }

    /**
     * CheckTime接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async CheckTime(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmeducationexperience){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/${context.pcmeducationexperience}/checktime`,data,isloading);
        }
            return Http.getInstance().post(`/pcmeducationexperiences/${context.pcmeducationexperience}/checktime`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmEducationExperienceServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmeducationexperiences/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmeducationexperiences/fetchdefault`,tempData,isloading);
    }
}