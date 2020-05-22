import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SetNQGBXXLogic from '@/service/trmdutycadres/set-nqgbxx-logic';
import UpdateSateteSXLogic from '@/service/trmdutycadres/update-satete-sx-logic';
import UpdateStateXXLogic from '@/service/trmdutycadres/update-state-xx-logic';



/**
 * 优秀年轻干部梯队服务对象基类
 *
 * @export
 * @class TRMDUTYCADRESServiceBase
 * @extends {EntityServie}
 */
export default class TRMDUTYCADRESServiceBase extends EntityService {

    /**
     * Creates an instance of  TRMDUTYCADRESServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TRMDUTYCADRESServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TRMDUTYCADRESServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmdutycadres';
        this.APPDEKEY = 'trmdutycadresid';
        this.APPDENAME = 'trmdutycadres';
        this.APPDETEXT = 'trmdutycadresname';
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
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/trmdutycadres/${context.trmdutycadres}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmdutycadres/${context.trmdutycadres}/save`,data,isloading);
            return res;
    }

    /**
     * SetNQGBXX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async SetNQGBXX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetNQGBXXLogic = new SetNQGBXXLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * SX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async SX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:UpdateSateteSXLogic = new UpdateSateteSXLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmdutycadres`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/trmdutycadres/getdraft`,isloading);
        res.data.trmdutycadres = data.trmdutycadres;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/trmdutycadres/${context.trmdutycadres}/checkkey`,data,isloading);
    }

    /**
     * XX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async XX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:UpdateStateXXLogic = new UpdateStateXXLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/trmdutycadres/${context.trmdutycadres}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmdutycadres/${context.trmdutycadres}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/trmdutycadres/${context.trmdutycadres}`,isloading);

    }

    /**
     * FetchCurCXFW接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async FetchCurCXFW(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmdutycadres/fetchcurcxfw`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMDUTYCADRESServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmdutycadres/fetchdefault`,tempData,isloading);
    }
}