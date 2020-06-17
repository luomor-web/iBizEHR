import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 培训记录服务对象基类
 *
 * @export
 * @class TrmCouarrangeServiceBase
 * @extends {EntityServie}
 */
export default class TrmCouarrangeServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmCouarrangeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmCouarrangeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmCouarrangeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmcouarrange';
        this.APPDEKEY = 'trmcouarrangeid';
        this.APPDENAME = 'trmcouarranges';
        this.APPDETEXT = 'trmcouarrangename';
        this.APPNAME = 'ehrtrm';
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
     * @memberof TrmCouarrangeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}/select`,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}/select`,isloading);
        }
        if(context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}/select`,isloading);
        }
        if(context.trmtrainagency && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges/${context.trmcouarrange}/select`,isloading);
        }
        if(context.trmtrainaddress && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges/${context.trmcouarrange}/select`,isloading);
        }
        if(context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}/select`,isloading);
        }
            return Http.getInstance().get(`/trmcouarranges/${context.trmcouarrange}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCouarrangeServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges`,data,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges`,data,isloading);
        }
        if(context.trmtrainteacher && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges`,data,isloading);
        }
        if(context.trmtrainagency && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges`,data,isloading);
        }
        if(context.trmtrainaddress && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges`,data,isloading);
        }
        if(context.trmcoursesystem && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/trmcouarranges`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCouarrangeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmtrainagency && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmtrainaddress && context.trmcouarrange){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmcouarranges/${context.trmcouarrange}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCouarrangeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().delete(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmtrainagency && context.trmcouarrange){
            return Http.getInstance().delete(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmtrainaddress && context.trmcouarrange){
            return Http.getInstance().delete(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
        if(context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().delete(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}`,isloading);
        }
            return Http.getInstance().delete(`/trmcouarranges/${context.trmcouarrange}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCouarrangeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/getdraft`,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/getdraft`,isloading);
        }
        if(context.trmtrainteacher && true){
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/getdraft`,isloading);
        }
        if(context.trmtrainagency && true){
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges/getdraft`,isloading);
        }
        if(context.trmtrainaddress && true){
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges/getdraft`,isloading);
        }
        if(context.trmcoursesystem && true){
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmcouarranges/getdraft`,isloading);
        res.data.trmcouarrange = data.trmcouarrange;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCouarrangeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}/checkkey`,data,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}/checkkey`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}/checkkey`,data,isloading);
        }
        if(context.trmtrainagency && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges/${context.trmcouarrange}/checkkey`,data,isloading);
        }
        if(context.trmtrainaddress && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges/${context.trmcouarrange}/checkkey`,data,isloading);
        }
        if(context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmcouarranges/${context.trmcouarrange}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCouarrangeServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}/save`,data,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}/save`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}/save`,data,isloading);
        }
        if(context.trmtrainagency && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges/${context.trmcouarrange}/save`,data,isloading);
        }
        if(context.trmtrainaddress && context.trmcouarrange){
            return Http.getInstance().post(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges/${context.trmcouarrange}/save`,data,isloading);
        }
        if(context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().post(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmcouarranges/${context.trmcouarrange}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCouarrangeServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}`,data,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}`,data,isloading);
        }
        if(context.trmtrainteacher && context.trmcouarrange){
            return Http.getInstance().put(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/${context.trmcouarrange}`,data,isloading);
        }
        if(context.trmtrainagency && context.trmcouarrange){
            return Http.getInstance().put(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges/${context.trmcouarrange}`,data,isloading);
        }
        if(context.trmtrainaddress && context.trmcouarrange){
            return Http.getInstance().put(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges/${context.trmcouarrange}`,data,isloading);
        }
        if(context.trmcoursesystem && context.trmcouarrange){
            return Http.getInstance().put(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/${context.trmcouarrange}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmcouarranges/${context.trmcouarrange}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmCouarrangeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.trmtrainagency && context.trmtrainteacher && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainagency && context.trmcoursesystem && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainteacher && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainteachers/${context.trmtrainteacher}/trmcouarranges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainagency && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainagencies/${context.trmtrainagency}/trmcouarranges/fetchdefault`,tempData,isloading);
        }
        if(context.trmtrainaddress && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmtrainaddresses/${context.trmtrainaddress}/trmcouarranges/fetchdefault`,tempData,isloading);
        }
        if(context.trmcoursesystem && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/trmcoursesystems/${context.trmcoursesystem}/trmcouarranges/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmcouarranges/fetchdefault`,tempData,isloading);
    }
}