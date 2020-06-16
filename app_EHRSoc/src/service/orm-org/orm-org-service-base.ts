import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组织管理服务对象基类
 *
 * @export
 * @class OrmOrgServiceBase
 * @extends {EntityServie}
 */
export default class OrmOrgServiceBase extends EntityService {

    /**
     * Creates an instance of  OrmOrgServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof OrmOrgServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ormorg';
        this.APPDEKEY = 'orgid';
        this.APPDENAME = 'ormorgs';
        this.APPDETEXT = 'orgname';
        this.APPNAME = 'ehrsoc';
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
     * @memberof OrmOrgServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs'),'undefined')){
            ormorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs') as any);
            if(ormorgsData && ormorgsData.length && ormorgsData.length > 0){
                ormorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgs = ormorgsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ormorgs/${context.ormorg}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
            return res;
    }

    /**
     * SynOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async SynOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/synorg`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/ormorgs/getdraft`,isloading);
        res.data.ormorg = data.ormorg;
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/ormorgs/${context.ormorg}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
            return res;

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/checkkey`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs'),'undefined')){
            ormorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs') as any);
            if(ormorgsData && ormorgsData.length && ormorgsData.length > 0){
                ormorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgs = ormorgsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ormorgs`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormorgsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs'),'undefined')){
            ormorgsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormorgs') as any);
            if(ormorgsData && ormorgsData.length && ormorgsData.length > 0){
                ormorgsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.orgid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormorgs = ormorgsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ormorgs/${context.ormorg}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormorgs',JSON.stringify(res.data.ormorgs));
            return res;
    }

    /**
     * FetchALLSIGNORG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchALLSIGNORG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchallsignorg`,tempData,isloading);
    }

    /**
     * FetchAllLevelTwoOrg2接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchAllLevelTwoOrg2(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchallleveltwoorg2`,tempData,isloading);
    }

    /**
     * FetchOrglist_Profile接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchOrglist_Profile(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchorglist_profile`,tempData,isloading);
    }

    /**
     * FetchREP_ORG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchREP_ORG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchrep_org`,tempData,isloading);
    }

    /**
     * FetchAuthOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchAuthOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchauthorg`,tempData,isloading);
    }

    /**
     * FetchGSGWZY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchGSGWZY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchgsgwzy`,tempData,isloading);
    }

    /**
     * FetchSubSubOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchSubSubOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchsubsuborg`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchCurChild接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchCurChild(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchcurchild`,tempData,isloading);
    }

    /**
     * FetchSJYXZZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchSJYXZZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchsjyxzz`,tempData,isloading);
    }

    /**
     * FetchREP_ORGPNUM接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchREP_ORGPNUM(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchrep_orgpnum`,tempData,isloading);
    }

    /**
     * FetchKZSJZZXZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchKZSJZZXZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchkzsjzzxz`,tempData,isloading);
    }

    /**
     * FetchDanQian接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchDanQian(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchdanqian`,tempData,isloading);
    }

    /**
     * FetchAllLevelTwoOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchAllLevelTwoOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchallleveltwoorg`,tempData,isloading);
    }

    /**
     * FetchSubOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchSubOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchsuborg`,tempData,isloading);
    }

    /**
     * FetchHTGLDW接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchHTGLDW(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchhtgldw`,tempData,isloading);
    }

    /**
     * FetchKZXLXZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchKZXLXZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchkzxlxz`,tempData,isloading);
    }

    /**
     * FetchAuthSJYXZZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchAuthSJYXZZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchauthsjyxzz`,tempData,isloading);
    }

    /**
     * FetchUseByFP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchUseByFP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchusebyfp`,tempData,isloading);
    }

    /**
     * FetchCurPorg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof OrmOrgServiceBase
     */
    public async FetchCurPorg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ormorgs/fetchcurporg`,tempData,isloading);
    }
}