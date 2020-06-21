import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SetRejectStatusLogic from '@/service/trm-train-plan/set-reject-status-logic';
import SetYfbZtLogic from '@/service/trm-train-plan/set-yfb-zt-logic';
import SetDfbZtLogic from '@/service/trm-train-plan/set-dfb-zt-logic';



/**
 * 培训计划服务对象基类
 *
 * @export
 * @class TrmTrainPlanServiceBase
 * @extends {EntityServie}
 */
export default class TrmTrainPlanServiceBase extends EntityService {

    /**
     * Creates an instance of  TrmTrainPlanServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainPlanServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof TrmTrainPlanServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='trmtrainplan';
        this.APPDEKEY = 'trmtrainplanid';
        this.APPDENAME = 'trmtrainplans';
        this.APPDETEXT = 'trmdemdeftionname';
        this.APPNAME = 'ehrtrm';
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
     * @memberof TrmTrainPlanServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainplan){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/select`,isloading);
        }
            return Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainplan){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}`,isloading);
        }
            return Http.getInstance().delete(`/trmtrainplans/${context.trmtrainplan}`,isloading);

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainplan){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/save`,data,isloading);
        }
        let masterData:any = {};
        let trmtrainplantermsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms'),'undefined')){
            trmtrainplantermsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms') as any);
            if(trmtrainplantermsData && trmtrainplantermsData.length && trmtrainplantermsData.length > 0){
                trmtrainplantermsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainplantermid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainplanterms = trmtrainplantermsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
            return res;
    }

    /**
     * SetYfbZt接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async SetYfbZt(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetYfbZtLogic = new SetYfbZtLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/trmtrainplans/getdraft`,isloading);
        res.data.trmtrainplan = data.trmtrainplan;
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainplan){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/checkkey`,data,isloading);
    }

    /**
     * SetDfbZt接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async SetDfbZt(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetDfbZtLogic = new SetDfbZtLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * SetApprovalStatus接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async SetApprovalStatus(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainplan){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}/setapprovalstatus`,data,isloading);
        }
            return Http.getInstance().post(`/trmtrainplans/${context.trmtrainplan}/setapprovalstatus`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainplan){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/trmtrainplans/${context.trmtrainplan}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/trmtrainplans`,data,isloading);
        }
        let masterData:any = {};
        let trmtrainplantermsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms'),'undefined')){
            trmtrainplantermsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms') as any);
            if(trmtrainplantermsData && trmtrainplantermsData.length && trmtrainplantermsData.length > 0){
                trmtrainplantermsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainplantermid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainplanterms = trmtrainplantermsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/trmtrainplans`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
        return res;
    }

    /**
     * SetRejectStatus接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async SetRejectStatus(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:SetRejectStatusLogic = new SetRejectStatusLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.trmtrainplan){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/trmtrainplans/${context.trmtrainplan}`,data,isloading);
        }
        let masterData:any = {};
        let trmtrainplantermsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms'),'undefined')){
            trmtrainplantermsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainplanterms') as any);
            if(trmtrainplantermsData && trmtrainplantermsData.length && trmtrainplantermsData.length > 0){
                trmtrainplantermsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrainplantermid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainplanterms = trmtrainplantermsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/trmtrainplans/${context.trmtrainplan}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainplanterms',JSON.stringify(res.data.trmtrainplanterms));
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof TrmTrainPlanServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/trmtrainplans/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/trmtrainplans/fetchdefault`,tempData,isloading);
    }
}