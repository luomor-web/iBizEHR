import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 测评结果摘要信息服务对象基类
 *
 * @export
 * @class PcmTestResultServiceBase
 * @extends {EntityServie}
 */
export default class PcmTestResultServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmTestResultServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmTestResultServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmTestResultServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmtestresult';
        this.APPDEKEY = 'testresultid';
        this.APPDENAME = 'pcmtestresults';
        this.APPDETEXT = 'testresultname';
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
     * @memberof PcmTestResultServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtestresult){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmtestresults/${context.pcmtestresult}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmtestresults/${context.pcmtestresult}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTestResultServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmtestresults/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmtestresults/getdraft`,isloading);
        res.data.pcmtestresult = data.pcmtestresult;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTestResultServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtestresult){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmtestresults/${context.pcmtestresult}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmtestresults/${context.pcmtestresult}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTestResultServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmtestresults`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmtestresults`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTestResultServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtestresult){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/pcmtestresults/${context.pcmtestresult}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmtestresults/${context.pcmtestresult}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTestResultServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtestresult){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmtestresults/${context.pcmtestresult}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmtestresults/${context.pcmtestresult}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTestResultServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtestresult){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/pcmtestresults/${context.pcmtestresult}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmtestresults/${context.pcmtestresult}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTestResultServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.pcmtestresult){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/pcmtestresults/${context.pcmtestresult}`,isloading);
        }
            return Http.getInstance().delete(`/pcmtestresults/${context.pcmtestresult}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmTestResultServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/pcmtestresults/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmtestresults/fetchdefault`,tempData,isloading);
    }
}