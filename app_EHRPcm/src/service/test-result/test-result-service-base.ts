import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 测评结果摘要信息服务对象基类
 *
 * @export
 * @class TestResultServiceBase
 * @extends {EntityServie}
 */
export default class TestResultServiceBase extends EntityService {

    /**
     * Creates an instance of  TestResultServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TestResultServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TestResultServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='testresult';
        this.APPDEKEY = 'testresultid';
        this.APPDENAME = 'testresults';
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
     * @memberof TestResultServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.testresult){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/testresults/${context.testresult}/select`,isloading);
        }
            return Http.getInstance().get(`/testresults/${context.testresult}/select`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TestResultServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/testresults/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/testresults/getdraft`,isloading);
        res.data.testresult = data.testresult;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TestResultServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.testresult){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/testresults/${context.testresult}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/testresults/${context.testresult}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TestResultServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/testresults`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/testresults`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TestResultServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.testresult){
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/testresults/${context.testresult}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/testresults/${context.testresult}/save`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TestResultServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.testresult){
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/testresults/${context.testresult}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/testresults/${context.testresult}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TestResultServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.testresult){
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/testresults/${context.testresult}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/testresults/${context.testresult}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TestResultServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && context.testresult){
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}/testresults/${context.testresult}`,isloading);
        }
            return Http.getInstance().delete(`/testresults/${context.testresult}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TestResultServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pcmprofile && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/testresults/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/testresults/fetchdefault`,tempData,isloading);
    }
}