import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import PersonUpdateInfoLogic from '@/service/pim-person/person-update-info-logic';
import GetJTLXRDHLogic from '@/service/pim-person/get-jtlxrdh-logic';
import GenratePersonFileLogic from '@/service/pim-person/genrate-person-file-logic';



/**
 * 人员信息服务对象基类
 *
 * @export
 * @class PimPersonServiceBase
 * @extends {EntityServie}
 */
export default class PimPersonServiceBase extends EntityService {

    /**
     * Creates an instance of  PimPersonServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPersonServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimPersonServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimperson';
        this.APPDEKEY = 'pimpersonid';
        this.APPDENAME = 'pimpeople';
        this.APPDETEXT = 'pimpersonname';
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
     * @memberof PimPersonServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormxmbmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbmxes'),'undefined')){
            ormxmbmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbmxes') as any);
            if(ormxmbmxesData && ormxmbmxesData.length && ormxmbmxesData.length > 0){
                ormxmbmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormxmbmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormxmbmxes = ormxmbmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimpeople/${context.pimperson}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormxmbmxes',JSON.stringify(res.data.ormxmbmxes));
            return res;
    }

    /**
     * YZSFYZFP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async YZSFYZFP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/yzsfyzfp`,data,isloading);
    }

    /**
     * ToggleLeader接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async ToggleLeader(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/toggleleader`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pimpeople/${context.pimperson}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormxmbmxes',JSON.stringify(res.data.ormxmbmxes));
            return res;

    }

    /**
     * PersonUpdateInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async PersonUpdateInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/personupdateinfo`,data,isloading);
    }

    /**
     * FillPersonType接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FillPersonType(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/fillpersontype`,data,isloading);
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormxmbmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbmxes'),'undefined')){
            ormxmbmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbmxes') as any);
            if(ormxmbmxesData && ormxmbmxesData.length && ormxmbmxesData.length > 0){
                ormxmbmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormxmbmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormxmbmxes = ormxmbmxesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pimpeople`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ormxmbmxes',JSON.stringify(res.data.ormxmbmxes));
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ormxmbmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbmxes'),'undefined')){
            ormxmbmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ormxmbmxes') as any);
            if(ormxmbmxesData && ormxmbmxesData.length && ormxmbmxesData.length > 0){
                ormxmbmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.ormxmbmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ormxmbmxes = ormxmbmxesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimpeople/${context.pimperson}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ormxmbmxes',JSON.stringify(res.data.ormxmbmxes));
            return res;
    }

    /**
     * GetJTLXRDH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async GetJTLXRDH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:GetJTLXRDHLogic = new GetJTLXRDHLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * SynPerson接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async SynPerson(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/synperson`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}`,isloading);

    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/checkkey`,data,isloading);
    }

    /**
     * QRTX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async QRTX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/qrtx`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pimpeople/getdraft`,isloading);
        res.data.pimperson = data.pimperson;
            this.tempStorage.setItem(context.srfsessionkey+'_ormxmbmxes',JSON.stringify(res.data.ormxmbmxes));
        return res;
    }

    /**
     * GeneratePersonFile接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async GeneratePersonFile(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/generatepersonfile`,data,isloading);
    }

    /**
     * FetchKFPRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchKFPRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchkfpry`,tempData,isloading);
    }

    /**
     * FetchSetAttRules接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchSetAttRules(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchsetattrules`,tempData,isloading);
    }

    /**
     * FetchSetSocArchives接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchSetSocArchives(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchsetsocarchives`,tempData,isloading);
    }

    /**
     * FetchYGXXGLY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchYGXXGLY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchygxxgly`,tempData,isloading);
    }

    /**
     * FetchXMBRYCX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchXMBRYCX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchxmbrycx`,tempData,isloading);
    }

    /**
     * FetchCurOrgPerson接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchCurOrgPerson(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchcurorgperson`,tempData,isloading);
    }

    /**
     * FetchJLSSGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchJLSSGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchjlssgr`,tempData,isloading);
    }

    /**
     * FetchCurLeader接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchCurLeader(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchcurleader`,tempData,isloading);
    }

    /**
     * FetchSFHMD接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchSFHMD(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchsfhmd`,tempData,isloading);
    }

    /**
     * FetchSSTRERSONINFO接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchSSTRERSONINFO(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchsstrersoninfo`,tempData,isloading);
    }

    /**
     * FetchCurJHRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchCurJHRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchcurjhry`,tempData,isloading);
    }

    /**
     * FetchKTXYG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchKTXYG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchktxyg`,tempData,isloading);
    }

    /**
     * FetchBYLYG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchBYLYG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchbylyg`,tempData,isloading);
    }

    /**
     * FetchGBHMC接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchGBHMC(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchgbhmc`,tempData,isloading);
    }

    /**
     * FetchGZDQGL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchGZDQGL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchgzdqgl`,tempData,isloading);
    }

    /**
     * FetchKQJRYCX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchKQJRYCX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchkqjrycx`,tempData,isloading);
    }

    /**
     * FetchLTXSTAFF接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchLTXSTAFF(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchltxstaff`,tempData,isloading);
    }

    /**
     * FetchREP_PERSONORGTYPE接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchREP_PERSONORGTYPE(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchrep_personorgtype`,tempData,isloading);
    }

    /**
     * FetchAuthPerson接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchAuthPerson(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchauthperson`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchKGZRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchKGZRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchkgzry`,tempData,isloading);
    }

    /**
     * FetchSELFHELPID接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchSELFHELPID(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchselfhelpid`,tempData,isloading);
    }

    /**
     * FetchSYQYGCX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchSYQYGCX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchsyqygcx`,tempData,isloading);
    }

    /**
     * FetchLZRYHMC接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchLZRYHMC(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchlzryhmc`,tempData,isloading);
    }

    /**
     * FetchTitleUse接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchTitleUse(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchtitleuse`,tempData,isloading);
    }

    /**
     * FetchJXQYGCX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchJXQYGCX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchjxqygcx`,tempData,isloading);
    }

    /**
     * FetchYXZFPRYDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchYXZFPRYDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchyxzfpryds`,tempData,isloading);
    }

    /**
     * FetchRYZT_30接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchRYZT_30(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchryzt_30`,tempData,isloading);
    }

    /**
     * FetchDTXYG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchDTXYG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchdtxyg`,tempData,isloading);
    }

    /**
     * FetchXZKQRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchXZKQRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchxzkqry`,tempData,isloading);
    }

    /**
     * FetchREP_PERSONAGE接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchREP_PERSONAGE(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchrep_personage`,tempData,isloading);
    }

    /**
     * FetchSYQKZZRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchSYQKZZRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchsyqkzzry`,tempData,isloading);
    }

    /**
     * FetchJXQKZZRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchJXQKZZRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchjxqkzzry`,tempData,isloading);
    }

    /**
     * FetchTXGB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchTXGB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchtxgb`,tempData,isloading);
    }

    /**
     * FetchKZJBDRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchKZJBDRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchkzjbdry`,tempData,isloading);
    }

    /**
     * FetchCurOrgPimperson接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchCurOrgPimperson(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchcurorgpimperson`,tempData,isloading);
    }

    /**
     * FetchTXRYCX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchTXRYCX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchtxrycx`,tempData,isloading);
    }

    /**
     * FetchKXZSYQKZZRYDS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimPersonServiceBase
     */
    public async FetchKXZSYQKZZRYDS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimpeople/fetchkxzsyqkzzryds`,tempData,isloading);
    }
}