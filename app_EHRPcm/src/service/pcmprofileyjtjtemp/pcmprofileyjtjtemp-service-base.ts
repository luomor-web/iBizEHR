import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 应聘者引进条件中间表（停用）服务对象基类
 *
 * @export
 * @class PCMPROFILEYJTJTEMPServiceBase
 * @extends {EntityServie}
 */
export default class PCMPROFILEYJTJTEMPServiceBase extends EntityService {

    /**
     * Creates an instance of  PCMPROFILEYJTJTEMPServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMPROFILEYJTJTEMPServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmprofileyjtjtemp';
        this.APPDEKEY = 'pcmprofileyjtjtempid';
        this.APPDENAME = 'pcmprofileyjtjtemps';
        this.APPDETEXT = 'pcmprofileyjtjtempname';
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
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmprofileyjtjtemps/${context.pcmprofileyjtjtemp}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmprofileyjtjtemps/${context.pcmprofileyjtjtemp}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmprofileyjtjtemps/getdraft`,isloading);
        res.data.pcmprofileyjtjtemp = data.pcmprofileyjtjtemp;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEYJTJTEMPServiceBase
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
        let res:any = await Http.getInstance().post(`/pcmprofileyjtjtemps`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofileyjtjtemps/${context.pcmprofileyjtjtemp}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmprofileyjtjtemps/${context.pcmprofileyjtjtemp}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmprofileyjtjtemps/${context.pcmprofileyjtjtemp}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmprofileyjtjtemps/${context.pcmprofileyjtjtemp}`,isloading);
            return res;

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEYJTJTEMPServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofileyjtjtemps/fetchdefault`,tempData,isloading);
    }
}