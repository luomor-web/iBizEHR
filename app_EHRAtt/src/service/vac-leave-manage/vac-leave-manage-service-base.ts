import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 请假管理服务对象基类
 *
 * @export
 * @class VacLeaveManageServiceBase
 * @extends {EntityServie}
 */
export default class VacLeaveManageServiceBase extends EntityService {

    /**
     * Creates an instance of  VacLeaveManageServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  VacLeaveManageServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof VacLeaveManageServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='vacleavemanage';
        this.APPDEKEY = 'vacleavemanageid';
        this.APPDENAME = 'vacleavemanages';
        this.APPDETEXT = 'pimpersonname';
        this.APPNAME = 'ehratt';
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
     * @memberof VacLeaveManageServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}/select`,isloading);
        }
            return Http.getInstance().get(`/vacleavemanages/${context.vacleavemanage}/select`,isloading);
    }

    /**
     * UpdateQJMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async UpdateQJMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}/updateqjmx`,data,isloading);
        }
            return Http.getInstance().put(`/vacleavemanages/${context.vacleavemanage}/updateqjmx`,data,isloading);
    }

    /**
     * CB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async CB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}/cb`,data,isloading);
        }
            return Http.getInstance().post(`/vacleavemanages/${context.vacleavemanage}/cb`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/vacleavemanages/getdraft`,isloading);
        res.data.vacleavemanage = data.vacleavemanage;
        return res;
    }

    /**
     * CX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async CX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}/cx`,data,isloading);
        }
            return Http.getInstance().post(`/vacleavemanages/${context.vacleavemanage}/cx`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/vacleavemanages/${context.vacleavemanage}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}`,isloading);
        }
            return Http.getInstance().delete(`/vacleavemanages/${context.vacleavemanage}`,isloading);

    }

    /**
     * GetFJSJofPerson接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async GetFJSJofPerson(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}/getfjsjofperson`,isloading);
        }
            let res:any = await Http.getInstance().get(`/vacleavemanages/${context.vacleavemanage}/getfjsjofperson`,isloading);
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/vacleavemanages/${context.vacleavemanage}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/vacleavemanages`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/vacleavemanages`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/vacleavemanages/${context.vacleavemanage}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/vacleavemanages/${context.vacleavemanage}/checkkey`,data,isloading);
    }

    /**
     * MobStart接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async MobStart(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.vacleavemanage){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/vacleavemanages/${context.vacleavemanage}/mobstart`,data,isloading);
        }
            return Http.getInstance().post(`/vacleavemanages/${context.vacleavemanage}/mobstart`,data,isloading);
    }

    /**
     * FetchFormType接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async FetchFormType(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/fetchformtype`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacleavemanages/fetchformtype`,tempData,isloading);
    }

    /**
     * FetchGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async FetchGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/fetchgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacleavemanages/fetchgr`,tempData,isloading);
    }

    /**
     * FetchMOBJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async FetchMOBJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/fetchmobjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacleavemanages/fetchmobjlss`,tempData,isloading);
    }

    /**
     * FetchJLSS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async FetchJLSS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/fetchjlss`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacleavemanages/fetchjlss`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacleavemanages/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchOnlySPTY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveManageServiceBase
     */
    public async FetchOnlySPTY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/vacleavemanages/fetchonlyspty`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacleavemanages/fetchonlyspty`,tempData,isloading);
    }
}