import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SetOrderNumLogic from '@/service/orm-duty/set-order-num-logic';



/**
 * 职务管理服务对象基类
 *
 * @export
 * @class OrmDutyServiceBase
 * @extends {EntityServie}
 */
export default class OrmDutyServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmDutyServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmDutyServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmDutyServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormduty';
        this.APPDEKEY = 'ormdutyid';
        this.APPDENAME = 'ormduties';
        this.APPDETEXT = 'ormdutyname';
        this.APPNAME = 'ehrorm';
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
     * @memberof OrmDutyServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/ormduties/${context.ormduty}/select`,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormdepestmenData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormdepestmen'),'undefined')){
            ormdepestmenData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormdepestmen') as any);
            if(ormdepestmenData && ormdepestmenData.length && ormdepestmenData.length > 0){
                ormdepestmenData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormdepestmanid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormdepestmen = ormdepestmenData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ormduties`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormdepestmen',JSON.stringify(res.data.ormdepestmen));
        return res;
    }

    /**
     * SynOrderNum接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async SynOrderNum(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormduties/${context.ormduty}/synordernum`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormdepestmenData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormdepestmen'),'undefined')){
            ormdepestmenData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormdepestmen') as any);
            if(ormdepestmenData && ormdepestmenData.length && ormdepestmenData.length > 0){
                ormdepestmenData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormdepestmanid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormdepestmen = ormdepestmenData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormduties/${context.ormduty}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormdepestmen',JSON.stringify(res.data.ormdepestmen));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/ormduties/getdraft`,isloading);
        res.data.ormduty = data.ormduty;
            this.tempStorage.setItem(context.srfsessionkey+'_ormdepestmen',JSON.stringify(res.data.ormdepestmen));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/ormduties/${context.ormduty}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormduties/${context.ormduty}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/ormduties/${context.ormduty}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormdepestmen',JSON.stringify(res.data.ormdepestmen));
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormdepestmenData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormdepestmen'),'undefined')){
            ormdepestmenData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormdepestmen') as any);
            if(ormdepestmenData && ormdepestmenData.length && ormdepestmenData.length > 0){
                ormdepestmenData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormdepestmanid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormdepestmen = ormdepestmenData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormduties/${context.ormduty}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormdepestmen',JSON.stringify(res.data.ormdepestmen));
            return res;
    }

    /**
     * FetchBasDuty接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async FetchBasDuty(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormduties/fetchbasduty`,tempData,isloading);
    }

    /**
     * FetchCurOrgsector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async FetchCurOrgsector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormduties/fetchcurorgsector`,tempData,isloading);
    }

    /**
     * FetchSrfOrgData接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async FetchSrfOrgData(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormduties/fetchsrforgdata`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormduties/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchCurOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async FetchCurOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormduties/fetchcurorg`,tempData,isloading);
    }

    /**
     * FetchCurOrmorgsector接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmDutyServiceBase
     */
    public async FetchCurOrmorgsector(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormduties/fetchcurormorgsector`,tempData,isloading);
    }
}