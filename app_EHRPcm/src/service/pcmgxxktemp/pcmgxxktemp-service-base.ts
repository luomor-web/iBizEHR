import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 高校学科中间表服务对象基类
 *
 * @export
 * @class PCMGXXKTEMPServiceBase
 * @extends {EntityServie}
 */
export default class PCMGXXKTEMPServiceBase extends EntityService {

    /**
     * Creates an instance of  PCMGXXKTEMPServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMGXXKTEMPServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PCMGXXKTEMPServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmgxxktemp';
        this.APPDEKEY = 'pcmgxxktempid';
        this.APPDENAME = 'pcmgxxktemps';
        this.APPDETEXT = 'pcmgxxktempname';
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
     * @memberof PCMGXXKTEMPServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmgxxktemps/${context.pcmgxxktemp}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGXXKTEMPServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmgxxktemps/getdraft`,isloading);
        res.data.pcmgxxktemp = data.pcmgxxktemp;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGXXKTEMPServiceBase
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
        let res:any = await Http.getInstance().post(`/pcmgxxktemps`,data,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGXXKTEMPServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmgxxktemps/${context.pcmgxxktemp}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGXXKTEMPServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmgxxktemps/${context.pcmgxxktemp}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGXXKTEMPServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmgxxktemps/${context.pcmgxxktemp}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGXXKTEMPServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmgxxktemps/${context.pcmgxxktemp}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGXXKTEMPServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmgxxktemps/${context.pcmgxxktemp}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMGXXKTEMPServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmgxxktemps/fetchdefault`,tempData,isloading);
    }
}