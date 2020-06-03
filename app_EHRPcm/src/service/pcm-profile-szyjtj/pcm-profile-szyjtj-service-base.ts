import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 应聘者社招引进条件服务对象基类
 *
 * @export
 * @class PcmProfileSzyjtjServiceBase
 * @extends {EntityServie}
 */
export default class PcmProfileSzyjtjServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmProfileSzyjtjServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmProfileSzyjtjServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmprofileszyjtj';
        this.APPDEKEY = 'pcmprofileszyjtjid';
        this.APPDENAME = 'pcmprofileszyjtjs';
        this.APPDETEXT = 'pcmprofileszyjtjname';
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
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmprofileszyjtjs/${context.pcmprofileszyjtj}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmprofileszyjtjs/${context.pcmprofileszyjtj}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
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
        let res:any = await Http.getInstance().post(`/pcmprofileszyjtjs`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmprofileszyjtjs/getdraft`,isloading);
        res.data.pcmprofileszyjtj = data.pcmprofileszyjtj;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofileszyjtjs/${context.pcmprofileszyjtj}/checkkey`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmprofileszyjtjs/${context.pcmprofileszyjtj}`,isloading);

    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmprofileszyjtjs/${context.pcmprofileszyjtj}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmprofileszyjtjs/${context.pcmprofileszyjtj}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofileszyjtjs/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchYGLX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileSzyjtjServiceBase
     */
    public async FetchYGLX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofileszyjtjs/fetchyglx`,tempData,isloading);
    }
}