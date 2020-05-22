import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import KBLogic from '@/service/trmtrainplanterm/kb-logic';
import QXLogic from '@/service/trmtrainplanterm/qx-logic';
import LXLogic from '@/service/trmtrainplanterm/lx-logic';



/**
 * 培训立项服务对象基类
 *
 * @export
 * @class TRMTRAINPLANTERMServiceBase
 * @extends {EntityServie}
 */
export default class TRMTRAINPLANTERMServiceBase extends EntityService {

    /**
     * Creates an instance of  TRMTRAINPLANTERMServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TRMTRAINPLANTERMServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainplanterm';
        this.APPDEKEY = 'trmtrainplantermid';
        this.APPDENAME = 'trmtrainplanterms';
        this.APPDETEXT = 'trmtrainplanname';
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
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/trmtrainplanterms/${context.trmtrainplanterm}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainplanterms/${context.trmtrainplanterm}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainplanterms/${context.trmtrainplanterm}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/trmtrainplanterms/getdraft`,isloading);
        res.data.trmtrainplanterm = data.trmtrainplanterm;
        return res;
    }

    /**
     * KB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async KB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:KBLogic = new KBLogic();
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
     * @memberof TRMTRAINPLANTERMServiceBase
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
        let res:any = await Http.getInstance().post(`/trmtrainplanterms`,data,isloading);
        return res;
    }

    /**
     * QX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async QX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:QXLogic = new QXLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * LX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async LX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:LXLogic = new LXLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TRMTRAINPLANTERMServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainplanterms/fetchdefault`,tempData,isloading);
    }
}