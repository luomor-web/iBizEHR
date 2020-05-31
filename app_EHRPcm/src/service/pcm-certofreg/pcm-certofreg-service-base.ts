import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 注册证书服务对象基类
 *
 * @export
 * @class PcmCertofregServiceBase
 * @extends {EntityServie}
 */
export default class PcmCertofregServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmCertofregServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmCertofregServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmCertofregServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmcertofreg';
        this.APPDEKEY = 'pcmcertofregid';
        this.APPDENAME = 'pcmcertofregs';
        this.APPDETEXT = 'pcmcertofregname';
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
     * @memberof PcmCertofregServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmcertofreg){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs/${context.pcmcertofreg}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmcertofregs/${context.pcmcertofreg}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmCertofregServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmcertofreg){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs/${context.pcmcertofreg}`,isloading);
        }
            return Http.getInstance().delete(`/pcmcertofregs/${context.pcmcertofreg}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmCertofregServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmcertofreg){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs/${context.pcmcertofreg}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmcertofregs/${context.pcmcertofreg}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmCertofregServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmcertofregs/getdraft`,isloading);
        res.data.pcmcertofreg = data.pcmcertofreg;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmCertofregServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmcertofregs`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmCertofregServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmcertofreg){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs/${context.pcmcertofreg}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmcertofregs/${context.pcmcertofreg}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmCertofregServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmcertofreg){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs/${context.pcmcertofreg}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmcertofregs/${context.pcmcertofreg}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmCertofregServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmcertofreg){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs/${context.pcmcertofreg}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmcertofregs/${context.pcmcertofreg}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmCertofregServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmcertofregs/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmcertofregs/fetchdefault`,tempData,isloading);
    }
}