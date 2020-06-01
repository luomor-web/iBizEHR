import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 在校职务服务对象基类
 *
 * @export
 * @class PcmSchoolOfficeServiceBase
 * @extends {EntityServie}
 */
export default class PcmSchoolOfficeServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmSchoolOfficeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmSchoolOfficeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmSchoolOfficeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmschooloffice';
        this.APPDEKEY = 'pcmschoolofficeid';
        this.APPDENAME = 'pcmschooloffices';
        this.APPDETEXT = 'pcmschoolofficename';
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
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmschooloffice){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices/${context.pcmschooloffice}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmschooloffices/${context.pcmschooloffice}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmschooloffice){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices/${context.pcmschooloffice}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmschooloffices/${context.pcmschooloffice}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmschooloffice){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices/${context.pcmschooloffice}`,isloading);
        }
            return Http.getInstance().delete(`/pcmschooloffices/${context.pcmschooloffice}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmschooloffice){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices/${context.pcmschooloffice}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmschooloffices/${context.pcmschooloffice}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmschooloffices/getdraft`,isloading);
        res.data.pcmschooloffice = data.pcmschooloffice;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmschooloffice){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices/${context.pcmschooloffice}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmschooloffices/${context.pcmschooloffice}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmschooloffice){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices/${context.pcmschooloffice}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmschooloffices/${context.pcmschooloffice}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmschooloffices`,data,isloading);
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmSchoolOfficeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmschooloffices/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmschooloffices/fetchdefault`,tempData,isloading);
    }
}