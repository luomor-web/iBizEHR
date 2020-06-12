import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 应聘者审批表服务对象基类
 *
 * @export
 * @class PcmProfileApprovalServiceBase
 * @extends {EntityServie}
 */
export default class PcmProfileApprovalServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmProfileApprovalServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmProfileApprovalServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmProfileApprovalServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmprofileapproval';
        this.APPDEKEY = 'pcmprofileapprovalid';
        this.APPDENAME = 'pcmprofileapprovals';
        this.APPDETEXT = 'pcmprofileapprovalname';
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
     * @memberof PcmProfileApprovalServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmprofileapproval){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/${context.pcmprofileapproval}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmprofileapprovals/${context.pcmprofileapproval}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmprofileapproval){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/${context.pcmprofileapproval}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmprofileapprovals/${context.pcmprofileapproval}`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmprofileapprovals/getdraft`,isloading);
        res.data.pcmprofileapproval = data.pcmprofileapproval;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmprofileapprovals`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmprofileapproval){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/${context.pcmprofileapproval}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmprofileapprovals/${context.pcmprofileapproval}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmprofileapproval){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/${context.pcmprofileapproval}`,isloading);
        }
            return Http.getInstance().delete(`/pcmprofileapprovals/${context.pcmprofileapproval}`,isloading);

    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmprofileapproval){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/${context.pcmprofileapproval}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmprofileapprovals/${context.pcmprofileapproval}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmprofileapproval){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/${context.pcmprofileapproval}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmprofileapprovals/${context.pcmprofileapproval}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofileapprovals/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchDisagree接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmProfileApprovalServiceBase
     */
    public async FetchDisagree(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmprofileapprovals/fetchdisagree`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofileapprovals/fetchdisagree`,tempData,isloading);
    }
}