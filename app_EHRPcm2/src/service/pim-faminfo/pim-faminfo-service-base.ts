import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import UpdateContactLogic from '@/service/pim-faminfo/update-contact-logic';



/**
 * 家庭情况服务对象基类
 *
 * @export
 * @class PimFaminfoServiceBase
 * @extends {EntityServie}
 */
export default class PimFaminfoServiceBase extends EntityService {

    /**
     * Creates an instance of  PimFaminfoServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimFaminfoServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimFaminfoServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimfaminfo';
        this.APPDEKEY = 'pimfaminfoid';
        this.APPDENAME = 'pimfaminfos';
        this.APPDETEXT = 'pimfaminfoname';
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
     * @memberof PimFaminfoServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimfaminfo){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/${context.pimfaminfo}/select`,isloading);
        }
            return Http.getInstance().get(`/pimfaminfos/${context.pimfaminfo}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimfaminfo){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimfaminfos/${context.pimfaminfo}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimfaminfos/${context.pimfaminfo}/checkkey`,data,isloading);
    }

    /**
     * UpdateInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async UpdateInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimfaminfo){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimfaminfos/${context.pimfaminfo}/updateinfo`,data,isloading);
        }
            return Http.getInstance().put(`/pimfaminfos/${context.pimfaminfo}/updateinfo`,data,isloading);
    }

    /**
     * UpdateContact接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async UpdateContact(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimfaminfo){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimfaminfos/${context.pimfaminfo}/updatecontact`,data,isloading);
        }
            return Http.getInstance().put(`/pimfaminfos/${context.pimfaminfo}/updatecontact`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimfaminfos`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimfaminfos`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimfaminfo){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimfaminfos/${context.pimfaminfo}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimfaminfos/${context.pimfaminfo}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimfaminfos/getdraft`,isloading);
        res.data.pimfaminfo = data.pimfaminfo;
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimfaminfo){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimfaminfos/${context.pimfaminfo}`,isloading);
        }
            return Http.getInstance().delete(`/pimfaminfos/${context.pimfaminfo}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimfaminfo){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimfaminfos/${context.pimfaminfo}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimfaminfos/${context.pimfaminfo}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimfaminfo){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/${context.pimfaminfo}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimfaminfos/${context.pimfaminfo}`,isloading);
            return res;

    }

    /**
     * FetchJLSSGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async FetchJLSSGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/fetchjlssgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimfaminfos/fetchjlssgr`,tempData,isloading);
    }

    /**
     * FetchJTLXR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async FetchJTLXR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/fetchjtlxr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimfaminfos/fetchjtlxr`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimfaminfos/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchJLSSGLY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async FetchJLSSGLY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/fetchjlssgly`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimfaminfos/fetchjlssgly`,tempData,isloading);
    }

    /**
     * FetchFAZZSY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async FetchFAZZSY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/fetchfazzsy`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimfaminfos/fetchfazzsy`,tempData,isloading);
    }

    /**
     * FetchZIZHU接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async FetchZIZHU(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/fetchzizhu`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimfaminfos/fetchzizhu`,tempData,isloading);
    }

    /**
     * FetchJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimFaminfoServiceBase
     */
    public async FetchJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimfaminfos/fetchjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimfaminfos/fetchjlss`,tempData,isloading);
    }
}