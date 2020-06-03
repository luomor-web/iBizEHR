import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import FillPersonInfoLogic from '@/service/pcm-ydjdmx/fill-person-info-logic';
import NewDisInfoLogic from '@/service/pcm-ydjdmx/new-dis-info-logic';
import RyHgLogic from '@/service/pcm-ydjdmx/ry-hg-logic';
import SetCheckstatusLogic from '@/service/pcm-ydjdmx/set-checkstatus-logic';



/**
 * 异动借调明细服务对象基类
 *
 * @export
 * @class PcmYdjdmxServiceBase
 * @extends {EntityServie}
 */
export default class PcmYdjdmxServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmYdjdmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmYdjdmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmYdjdmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmydjdmx';
        this.APPDEKEY = 'pcmydjdmxid';
        this.APPDENAME = 'pcmydjdmxes';
        this.APPDETEXT = 'pcmydjdmxname';
        this.APPNAME = 'ehrpcm2';
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
     * @memberof PcmYdjdmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmydjdmxes/getdraft`,isloading);
        res.data.pcmydjdmx = data.pcmydjdmx;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmydjdmxes/${context.pcmydjdmx}`,isloading);

    }

    /**
     * PersonBack接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async PersonBack(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:RyHgLogic = new RyHgLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * PersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async PersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:FillPersonInfoLogic = new FillPersonInfoLogic();
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
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
        let res:any = await Http.getInstance().post(`/pcmydjdmxes`,data,isloading);
        return res;
    }

    /**
     * FetchJDGLDQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async FetchJDGLDQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
    }

    /**
     * FetchJDLSJLDQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async FetchJDLSJLDQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmydjdmxes/fetchdefault`,tempData,isloading);
    }
}