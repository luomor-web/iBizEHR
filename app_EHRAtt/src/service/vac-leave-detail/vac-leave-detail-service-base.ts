import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import CalcPlanDaysLogic from '@/service/vac-leave-detail/calc-plan-days-logic';



/**
 * 请假明细服务对象基类
 *
 * @export
 * @class VacLeaveDetailServiceBase
 * @extends {EntityServie}
 */
export default class VacLeaveDetailServiceBase extends EntityService {

    /**
     * Creates an instance of  VacLeaveDetailServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  VacLeaveDetailServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof VacLeaveDetailServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='vacleavedetail';
        this.APPDEKEY = 'vacleavedetailid';
        this.APPDENAME = 'vacleavedetails';
        this.APPDETEXT = 'vacleavedetailname';
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
     * @memberof VacLeaveDetailServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/vacleavedetails/${context.vacleavedetail}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/vacleavedetails/${context.vacleavedetail}`,isloading);

    }

    /**
     * CalcSJQJTS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async CalcSJQJTS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/vacleavedetails/${context.vacleavedetail}/calcsjqjts`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
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
        let res:any = await Http.getInstance().post(`/vacleavedetails`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/vacleavedetails/${context.vacleavedetail}`,data,isloading);
            return res;
    }

    /**
     * GetNianJia接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async GetNianJia(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/vacleavedetails/${context.vacleavedetail}/getnianjia`,isloading);
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/vacleavedetails/${context.vacleavedetail}/save`,data,isloading);
            return res;
    }

    /**
     * CalcJHQJTS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async CalcJHQJTS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:CalcPlanDaysLogic = new CalcPlanDaysLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/vacleavedetails/${context.vacleavedetail}`,isloading);
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/vacleavedetails/${context.vacleavedetail}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/vacleavedetails/getdraft`,isloading);
        res.data.vacleavedetail = data.vacleavedetail;
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof VacLeaveDetailServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/vacleavedetails/fetchdefault`,tempData,isloading);
    }
}