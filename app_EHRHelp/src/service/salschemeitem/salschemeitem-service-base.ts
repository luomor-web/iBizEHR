import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 工资单要素项服务对象基类
 *
 * @export
 * @class SALSCHEMEITEMServiceBase
 * @extends {EntityServie}
 */
export default class SALSCHEMEITEMServiceBase extends EntityService {

    /**
     * Creates an instance of  SALSCHEMEITEMServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SALSCHEMEITEMServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SALSCHEMEITEMServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='salschemeitem';
        this.APPDEKEY = 'salschemeitemid';
        this.APPDENAME = 'salschemeitems';
        this.APPDETEXT = 'salitemname';
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
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && context.salschemeitem){
            return Http.getInstance().get(`/salschemes/${context.salscheme}/salschemeitems/${context.salschemeitem}/select`,isloading);
        }
        if(context.salitem && context.salschemeitem){
            return Http.getInstance().get(`/salitems/${context.salitem}/salschemeitems/${context.salschemeitem}/select`,isloading);
        }
            return Http.getInstance().get(`/salschemeitems/${context.salschemeitem}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && context.salschemeitem){
            return Http.getInstance().put(`/salschemes/${context.salscheme}/salschemeitems/${context.salschemeitem}`,data,isloading);
        }
        if(context.salitem && context.salschemeitem){
            return Http.getInstance().put(`/salitems/${context.salitem}/salschemeitems/${context.salschemeitem}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/salschemeitems/${context.salschemeitem}`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && context.salschemeitem){
            return Http.getInstance().post(`/salschemes/${context.salscheme}/salschemeitems/${context.salschemeitem}/save`,data,isloading);
        }
        if(context.salitem && context.salschemeitem){
            return Http.getInstance().post(`/salitems/${context.salitem}/salschemeitems/${context.salschemeitem}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/salschemeitems/${context.salschemeitem}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && context.salschemeitem){
            return Http.getInstance().get(`/salschemes/${context.salscheme}/salschemeitems/${context.salschemeitem}`,isloading);
        }
        if(context.salitem && context.salschemeitem){
            return Http.getInstance().get(`/salitems/${context.salitem}/salschemeitems/${context.salschemeitem}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/salschemeitems/${context.salschemeitem}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && context.salschemeitem){
            return Http.getInstance().delete(`/salschemes/${context.salscheme}/salschemeitems/${context.salschemeitem}`,isloading);
        }
        if(context.salitem && context.salschemeitem){
            return Http.getInstance().delete(`/salitems/${context.salitem}/salschemeitems/${context.salschemeitem}`,isloading);
        }
            return Http.getInstance().delete(`/salschemeitems/${context.salschemeitem}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && context.salschemeitem){
            return Http.getInstance().post(`/salschemes/${context.salscheme}/salschemeitems/${context.salschemeitem}/checkkey`,data,isloading);
        }
        if(context.salitem && context.salschemeitem){
            return Http.getInstance().post(`/salitems/${context.salitem}/salschemeitems/${context.salschemeitem}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/salschemeitems/${context.salschemeitem}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/salschemes/${context.salscheme}/salschemeitems`,data,isloading);
        }
        if(context.salitem && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/salitems/${context.salitem}/salschemeitems`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/salschemeitems`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && true){
            return Http.getInstance().get(`/salschemes/${context.salscheme}/salschemeitems/getdraft`,isloading);
        }
        if(context.salitem && true){
            return Http.getInstance().get(`/salitems/${context.salitem}/salschemeitems/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/salschemeitems/getdraft`,isloading);
        res.data.salschemeitem = data.salschemeitem;
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SALSCHEMEITEMServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.salscheme && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/salschemes/${context.salscheme}/salschemeitems/fetchdefault`,tempData,isloading);
        }
        if(context.salitem && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/salitems/${context.salitem}/salschemeitems/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/salschemeitems/fetchdefault`,tempData,isloading);
    }
}