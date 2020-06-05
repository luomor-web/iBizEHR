import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import FillPersonInfoLogic from '@/service/pim-byzzjlmx/fill-person-info-logic';



/**
 * B/Y类员工转正记录引用明细服务对象基类
 *
 * @export
 * @class PimByzzjlmxServiceBase
 * @extends {EntityServie}
 */
export default class PimByzzjlmxServiceBase extends EntityService {

    /**
     * Creates an instance of  PimByzzjlmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimByzzjlmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimByzzjlmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimbyzzjlmx';
        this.APPDEKEY = 'pimbyzzjlmxid';
        this.APPDENAME = 'pimbyzzjlmxes';
        this.APPDETEXT = 'pimbyzzjlmxname';
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
     * @memberof PimByzzjlmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/select`,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/select`,isloading);
        }
            return Http.getInstance().get(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/select`,isloading);
    }

    /**
     * SHTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async SHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/shtg`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/shtg`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/shtg`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}`,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimbyzzjlmxes/${context.pimbyzzjlmx}`,isloading);
            return res;

    }

    /**
     * ReturnYPZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async ReturnYPZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/returnypz`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/returnypz`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/returnypz`,data,isloading);
    }

    /**
     * JSPTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async JSPTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jsptg`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jsptg`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jsptg`,data,isloading);
    }

    /**
     * FillPersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FillPersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:FillPersonInfoLogic = new FillPersonInfoLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/getdraft`,isloading);
        }
        if(context.pimbyygzzsq && true){
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimbyzzjlmxes/getdraft`,isloading);
        res.data.pimbyzzjlmx = data.pimbyzzjlmx;
        return res;
    }

    /**
     * JSHTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async JSHTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jshtg`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jshtg`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jshtg`,data,isloading);
    }

    /**
     * JSHBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async JSHBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jshbtg`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jshbtg`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jshbtg`,data,isloading);
    }

    /**
     * Ensure接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async Ensure(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/ensure`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/ensure`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/ensure`,data,isloading);
    }

    /**
     * SHBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async SHBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/shbtg`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/shbtg`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/shbtg`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}`,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().delete(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}`,isloading);
        }
            return Http.getInstance().delete(`/pimbyzzjlmxes/${context.pimbyzzjlmx}`,isloading);

    }

    /**
     * GSDSZSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async GSDSZSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/gsdszsp`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/gsdszsp`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/gsdszsp`,data,isloading);
    }

    /**
     * ZZCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async ZZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/zzcz`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/zzcz`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/zzcz`,data,isloading);
    }

    /**
     * DSB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async DSB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/dsb`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/dsb`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/dsb`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().put(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimbyzzjlmxes/${context.pimbyzzjlmx}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes`,data,isloading);
        }
        if(context.pimbyygzzsq && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimbyzzjlmxes`,data,isloading);
        return res;
    }

    /**
     * JZBSHQR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async JZBSHQR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jzbshqr`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jzbshqr`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jzbshqr`,data,isloading);
    }

    /**
     * GSDSZSPBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async GSDSZSPBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/gsdszspbtg`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/gsdszspbtg`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/gsdszspbtg`,data,isloading);
    }

    /**
     * GSCSBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async GSCSBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/gscsbtg`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/gscsbtg`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/gscsbtg`,data,isloading);
    }

    /**
     * JSPBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async JSPBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jspbtg`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jspbtg`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jspbtg`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/save`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/save`,data,isloading);
            return res;
    }

    /**
     * GSCS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async GSCS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/gscs`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/gscs`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/gscs`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/checkkey`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/checkkey`,data,isloading);
    }

    /**
     * UpdatePeopleNum接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async UpdatePeopleNum(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/updatepeoplenum`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().put(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/updatepeoplenum`,data,isloading);
        }
            return Http.getInstance().put(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/updatepeoplenum`,data,isloading);
    }

    /**
     * JZBSPQR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async JZBSPQR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jzbspqr`,data,isloading);
        }
        if(context.pimbyygzzsq && context.pimbyzzjlmx){
            return Http.getInstance().post(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/${context.pimbyzzjlmx}/jzbspqr`,data,isloading);
        }
            return Http.getInstance().post(`/pimbyzzjlmxes/${context.pimbyzzjlmx}/jzbspqr`,data,isloading);
    }

    /**
     * FetchZZWSHDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchZZWSHDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchzzwshds`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchzzwshds`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchzzwshds`,tempData,isloading);
    }

    /**
     * FetchUnApproved接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchUnApproved(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchunapproved`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchunapproved`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchunapproved`,tempData,isloading);
    }

    /**
     * FetchDDJZBSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchDDJZBSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchddjzbsh`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchddjzbsh`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchddjzbsh`,tempData,isloading);
    }

    /**
     * FetchBYLZZJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchBYLZZJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchbylzzjl`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchbylzzjl`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchbylzzjl`,tempData,isloading);
    }

    /**
     * FetchDGSDSZSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchDGSDSZSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchdgsdszsh`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchdgsdszsh`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdgsdszsh`,tempData,isloading);
    }

    /**
     * FetchHTRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchHTRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchhtry`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchhtry`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchhtry`,tempData,isloading);
    }

    /**
     * FetchDJZBSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchDJZBSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchdjzbsp`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchdjzbsp`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdjzbsp`,tempData,isloading);
    }

    /**
     * FetchDSB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchDSB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchdsb`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchdsb`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdsb`,tempData,isloading);
    }

    /**
     * FetchFinishYGBH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchFinishYGBH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchfinishygbh`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchfinishygbh`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchfinishygbh`,tempData,isloading);
    }

    /**
     * FetchDJZBSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchDJZBSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchdjzbsh`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchdjzbsh`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdjzbsh`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimByzzjlmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimbyzzjlmxes/fetchdefault`,tempData,isloading);
        }
        if(context.pimbyygzzsq && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimbyygzzsqs/${context.pimbyygzzsq}/pimbyzzjlmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimbyzzjlmxes/fetchdefault`,tempData,isloading);
    }
}