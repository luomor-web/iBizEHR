import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 讲师收费记录服务对象基类
 *
 * @export
 * @class TrmTeacherChargeServiceBase
 * @extends {EntityServie}
 */
export default class TrmTeacherChargeServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTeacherChargeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTeacherChargeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTeacherChargeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmteachercharge';
        this.APPDEKEY = 'trmteacherchargeid';
        this.APPDENAME = 'trmteachercharges';
        this.APPDETEXT = 'trmteacherchargename';
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
     * @memberof TrmTeacherChargeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/select`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/select`,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}/select`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/select`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/select`,isloading);
        }
        if(context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}/select`,isloading);
        }
        if(context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/select`,isloading);
        }
            return Http.getInstance().get(`/trmteachercharges/${context.trmteachercharge}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherChargeServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/save`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/save`,data,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}/save`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/save`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/save`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}/save`,data,isloading);
        }
        if(context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmteachercharges/${context.trmteachercharge}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherChargeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmteachercharges/${context.trmteachercharge}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherChargeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().delete(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().delete(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().delete(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
        if(context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().delete(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,isloading);
        }
            return Http.getInstance().delete(`/trmteachercharges/${context.trmteachercharge}`,isloading);

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherChargeServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,data,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().put(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().put(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().put(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}`,data,isloading);
        }
        if(context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().put(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmteachercharges/${context.trmteachercharge}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherChargeServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges`,data,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges`,data,isloading);
        }
        if(context.trmtrainteacher && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges`,data,isloading);
        }
        if(context.trmtrainplanterm && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmteachercharges`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherChargeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/getdraft`,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/getdraft`,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/getdraft`,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && true){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/getdraft`,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && true){
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/getdraft`,isloading);
        }
        if(context.trmtrainteacher && true){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/getdraft`,isloading);
        }
        if(context.trmtrainplanterm && true){
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmteachercharges/getdraft`,isloading);
        res.data.trmteachercharge = data.trmteachercharge;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherChargeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/checkkey`,data,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/checkkey`,data,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}/checkkey`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/checkkey`,data,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/checkkey`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/${context.trmteachercharge}/checkkey`,data,isloading);
        }
        if(context.trmtrainplanterm && context.trmteachercharge){
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/${context.trmteachercharge}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmteachercharges/${context.trmteachercharge}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTeacherChargeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/fetchdefault`,tempData,isloading);
        }
        if(context.pimperson && context.trmtrainplan && context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainagency && context.trmtrainteacher && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainteacher && context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainplan && context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainteacher && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmteachercharges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainplanterm && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/trmteachercharges/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmteachercharges/fetchdefault`,tempData,isloading);
    }
}