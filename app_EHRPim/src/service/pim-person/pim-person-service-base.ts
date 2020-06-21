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
        this.APPNAME = 'ehrpim';
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
        let pimpersonabilitiesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonabilities'),'undefined')){
            pimpersonabilitiesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonabilities') as any);
            if(pimpersonabilitiesData && pimpersonabilitiesData.length && pimpersonabilitiesData.length > 0){
                pimpersonabilitiesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpersonabilityid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpersonabilities = pimpersonabilitiesData;
        let pimpapersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpapers'),'undefined')){
            pimpapersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpapers') as any);
            if(pimpapersData && pimpapersData.length && pimpapersData.length > 0){
                pimpapersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpaperid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpapers = pimpapersData;
        let pimdistirbutionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimdistirbutions'),'undefined')){
            pimdistirbutionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimdistirbutions') as any);
            if(pimdistirbutionsData && pimdistirbutionsData.length && pimdistirbutionsData.length > 0){
                pimdistirbutionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimdistirbutionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimdistirbutions = pimdistirbutionsData;
        let pimtitlesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimtitles'),'undefined')){
            pimtitlesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimtitles') as any);
            if(pimtitlesData && pimtitlesData.length && pimtitlesData.length > 0){
                pimtitlesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimtitleid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimtitles = pimtitlesData;
        let pimvocationalsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimvocationals'),'undefined')){
            pimvocationalsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimvocationals') as any);
            if(pimvocationalsData && pimvocationalsData.length && pimvocationalsData.length > 0){
                pimvocationalsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimvocationalid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimvocationals = pimvocationalsData;
        let pimarmycadresData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarmycadres'),'undefined')){
            pimarmycadresData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarmycadres') as any);
            if(pimarmycadresData && pimarmycadresData.length && pimarmycadresData.length > 0){
                pimarmycadresData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarmycadresid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarmycadres = pimarmycadresData;
        let pimcorrectionappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies'),'undefined')){
            pimcorrectionappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies') as any);
            if(pimcorrectionappliesData && pimcorrectionappliesData.length && pimcorrectionappliesData.length > 0){
                pimcorrectionappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcorrectionapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcorrectionapplies = pimcorrectionappliesData;
        let pimvacationsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimvacations'),'undefined')){
            pimvacationsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimvacations') as any);
            if(pimvacationsData && pimvacationsData.length && pimvacationsData.length > 0){
                pimvacationsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimvacationid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimvacations = pimvacationsData;
        let trmtrainpeopleData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainpeople'),'undefined')){
            trmtrainpeopleData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainpeople') as any);
            if(trmtrainpeopleData && trmtrainpeopleData.length && trmtrainpeopleData.length > 0){
                trmtrainpeopleData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrianpersonid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainpeople = trmtrainpeopleData;
        let pimcontractsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcontracts'),'undefined')){
            pimcontractsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcontracts') as any);
            if(pimcontractsData && pimcontractsData.length && pimcontractsData.length > 0){
                pimcontractsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcontractid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcontracts = pimcontractsData;
        let pimeducationsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimeducations'),'undefined')){
            pimeducationsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimeducations') as any);
            if(pimeducationsData && pimeducationsData.length && pimeducationsData.length > 0){
                pimeducationsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimeducationid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimeducations = pimeducationsData;
        let pimpersonchangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonchanges'),'undefined')){
            pimpersonchangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonchanges') as any);
            if(pimpersonchangesData && pimpersonchangesData.length && pimpersonchangesData.length > 0){
                pimpersonchangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpersonchangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpersonchanges = pimpersonchangesData;
        let pimachievementsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimachievements'),'undefined')){
            pimachievementsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimachievements') as any);
            if(pimachievementsData && pimachievementsData.length && pimachievementsData.length > 0){
                pimachievementsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimachievementsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimachievements = pimachievementsData;
        let pimresearchfindingsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimresearchfindings'),'undefined')){
            pimresearchfindingsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimresearchfindings') as any);
            if(pimresearchfindingsData && pimresearchfindingsData.length && pimresearchfindingsData.length > 0){
                pimresearchfindingsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimresearchfindingsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimresearchfindings = pimresearchfindingsData;
        let pimexitandentriesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimexitandentries'),'undefined')){
            pimexitandentriesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimexitandentries') as any);
            if(pimexitandentriesData && pimexitandentriesData.length && pimexitandentriesData.length > 0){
                pimexitandentriesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimexitandentryid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimexitandentries = pimexitandentriesData;
        let pimrewardpunishmentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimrewardpunishments'),'undefined')){
            pimrewardpunishmentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimrewardpunishments') as any);
            if(pimrewardpunishmentsData && pimrewardpunishmentsData.length && pimrewardpunishmentsData.length > 0){
                pimrewardpunishmentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimrewardpunishmentid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimrewardpunishments = pimrewardpunishmentsData;
        let pimpatentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpatents'),'undefined')){
            pimpatentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpatents') as any);
            if(pimpatentsData && pimpatentsData.length && pimpatentsData.length > 0){
                pimpatentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpatentid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpatents = pimpatentsData;
        let pimlanguageabilitiesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimlanguageabilities'),'undefined')){
            pimlanguageabilitiesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimlanguageabilities') as any);
            if(pimlanguageabilitiesData && pimlanguageabilitiesData.length && pimlanguageabilitiesData.length > 0){
                pimlanguageabilitiesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimlanguageabilityid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimlanguageabilities = pimlanguageabilitiesData;
        let pimarchivesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchives'),'undefined')){
            pimarchivesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchives') as any);
            if(pimarchivesData && pimarchivesData.length && pimarchivesData.length > 0){
                pimarchivesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchives = pimarchivesData;
        let pimfaminfosData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimfaminfos'),'undefined')){
            pimfaminfosData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimfaminfos') as any);
            if(pimfaminfosData && pimfaminfosData.length && pimfaminfosData.length > 0){
                pimfaminfosData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimfaminfoid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimfaminfos = pimfaminfosData;
        let attendancemreportmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes'),'undefined')){
            attendancemreportmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes') as any);
            if(attendancemreportmxesData && attendancemreportmxesData.length && attendancemreportmxesData.length > 0){
                attendancemreportmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancemreportmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancemreportmxes = attendancemreportmxesData;
        let pimworkhistoriesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimworkhistories'),'undefined')){
            pimworkhistoriesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimworkhistories') as any);
            if(pimworkhistoriesData && pimworkhistoriesData.length && pimworkhistoriesData.length > 0){
                pimworkhistoriesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimworkhistoryid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimworkhistories = pimworkhistoriesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimpeople/${context.pimperson}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimpersonabilities',JSON.stringify(res.data.pimpersonabilities));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpapers',JSON.stringify(res.data.pimpapers));
            this.tempStorage.setItem(context.srfsessionkey+'_pimdistirbutions',JSON.stringify(res.data.pimdistirbutions));
            this.tempStorage.setItem(context.srfsessionkey+'_pimtitles',JSON.stringify(res.data.pimtitles));
            this.tempStorage.setItem(context.srfsessionkey+'_pimvocationals',JSON.stringify(res.data.pimvocationals));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarmycadres',JSON.stringify(res.data.pimarmycadres));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
            this.tempStorage.setItem(context.srfsessionkey+'_pimvacations',JSON.stringify(res.data.pimvacations));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainpeople',JSON.stringify(res.data.trmtrainpeople));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontracts',JSON.stringify(res.data.pimcontracts));
            this.tempStorage.setItem(context.srfsessionkey+'_pimeducations',JSON.stringify(res.data.pimeducations));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpersonchanges',JSON.stringify(res.data.pimpersonchanges));
            this.tempStorage.setItem(context.srfsessionkey+'_pimachievements',JSON.stringify(res.data.pimachievements));
            this.tempStorage.setItem(context.srfsessionkey+'_pimresearchfindings',JSON.stringify(res.data.pimresearchfindings));
            this.tempStorage.setItem(context.srfsessionkey+'_pimexitandentries',JSON.stringify(res.data.pimexitandentries));
            this.tempStorage.setItem(context.srfsessionkey+'_pimrewardpunishments',JSON.stringify(res.data.pimrewardpunishments));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpatents',JSON.stringify(res.data.pimpatents));
            this.tempStorage.setItem(context.srfsessionkey+'_pimlanguageabilities',JSON.stringify(res.data.pimlanguageabilities));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchives',JSON.stringify(res.data.pimarchives));
            this.tempStorage.setItem(context.srfsessionkey+'_pimfaminfos',JSON.stringify(res.data.pimfaminfos));
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pimworkhistories',JSON.stringify(res.data.pimworkhistories));
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
            this.tempStorage.setItem(context.srfsessionkey+'_pimpersonabilities',JSON.stringify(res.data.pimpersonabilities));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpapers',JSON.stringify(res.data.pimpapers));
            this.tempStorage.setItem(context.srfsessionkey+'_pimdistirbutions',JSON.stringify(res.data.pimdistirbutions));
            this.tempStorage.setItem(context.srfsessionkey+'_pimtitles',JSON.stringify(res.data.pimtitles));
            this.tempStorage.setItem(context.srfsessionkey+'_pimvocationals',JSON.stringify(res.data.pimvocationals));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarmycadres',JSON.stringify(res.data.pimarmycadres));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
            this.tempStorage.setItem(context.srfsessionkey+'_pimvacations',JSON.stringify(res.data.pimvacations));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainpeople',JSON.stringify(res.data.trmtrainpeople));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontracts',JSON.stringify(res.data.pimcontracts));
            this.tempStorage.setItem(context.srfsessionkey+'_pimeducations',JSON.stringify(res.data.pimeducations));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpersonchanges',JSON.stringify(res.data.pimpersonchanges));
            this.tempStorage.setItem(context.srfsessionkey+'_pimachievements',JSON.stringify(res.data.pimachievements));
            this.tempStorage.setItem(context.srfsessionkey+'_pimresearchfindings',JSON.stringify(res.data.pimresearchfindings));
            this.tempStorage.setItem(context.srfsessionkey+'_pimexitandentries',JSON.stringify(res.data.pimexitandentries));
            this.tempStorage.setItem(context.srfsessionkey+'_pimrewardpunishments',JSON.stringify(res.data.pimrewardpunishments));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpatents',JSON.stringify(res.data.pimpatents));
            this.tempStorage.setItem(context.srfsessionkey+'_pimlanguageabilities',JSON.stringify(res.data.pimlanguageabilities));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchives',JSON.stringify(res.data.pimarchives));
            this.tempStorage.setItem(context.srfsessionkey+'_pimfaminfos',JSON.stringify(res.data.pimfaminfos));
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pimworkhistories',JSON.stringify(res.data.pimworkhistories));
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
        let pimpersonabilitiesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonabilities'),'undefined')){
            pimpersonabilitiesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonabilities') as any);
            if(pimpersonabilitiesData && pimpersonabilitiesData.length && pimpersonabilitiesData.length > 0){
                pimpersonabilitiesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpersonabilityid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpersonabilities = pimpersonabilitiesData;
        let pimpapersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpapers'),'undefined')){
            pimpapersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpapers') as any);
            if(pimpapersData && pimpapersData.length && pimpapersData.length > 0){
                pimpapersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpaperid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpapers = pimpapersData;
        let pimdistirbutionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimdistirbutions'),'undefined')){
            pimdistirbutionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimdistirbutions') as any);
            if(pimdistirbutionsData && pimdistirbutionsData.length && pimdistirbutionsData.length > 0){
                pimdistirbutionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimdistirbutionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimdistirbutions = pimdistirbutionsData;
        let pimtitlesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimtitles'),'undefined')){
            pimtitlesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimtitles') as any);
            if(pimtitlesData && pimtitlesData.length && pimtitlesData.length > 0){
                pimtitlesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimtitleid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimtitles = pimtitlesData;
        let pimvocationalsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimvocationals'),'undefined')){
            pimvocationalsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimvocationals') as any);
            if(pimvocationalsData && pimvocationalsData.length && pimvocationalsData.length > 0){
                pimvocationalsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimvocationalid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimvocationals = pimvocationalsData;
        let pimarmycadresData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarmycadres'),'undefined')){
            pimarmycadresData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarmycadres') as any);
            if(pimarmycadresData && pimarmycadresData.length && pimarmycadresData.length > 0){
                pimarmycadresData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarmycadresid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarmycadres = pimarmycadresData;
        let pimcorrectionappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies'),'undefined')){
            pimcorrectionappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies') as any);
            if(pimcorrectionappliesData && pimcorrectionappliesData.length && pimcorrectionappliesData.length > 0){
                pimcorrectionappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcorrectionapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcorrectionapplies = pimcorrectionappliesData;
        let pimvacationsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimvacations'),'undefined')){
            pimvacationsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimvacations') as any);
            if(pimvacationsData && pimvacationsData.length && pimvacationsData.length > 0){
                pimvacationsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimvacationid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimvacations = pimvacationsData;
        let trmtrainpeopleData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainpeople'),'undefined')){
            trmtrainpeopleData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainpeople') as any);
            if(trmtrainpeopleData && trmtrainpeopleData.length && trmtrainpeopleData.length > 0){
                trmtrainpeopleData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrianpersonid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainpeople = trmtrainpeopleData;
        let pimcontractsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcontracts'),'undefined')){
            pimcontractsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcontracts') as any);
            if(pimcontractsData && pimcontractsData.length && pimcontractsData.length > 0){
                pimcontractsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcontractid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcontracts = pimcontractsData;
        let pimeducationsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimeducations'),'undefined')){
            pimeducationsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimeducations') as any);
            if(pimeducationsData && pimeducationsData.length && pimeducationsData.length > 0){
                pimeducationsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimeducationid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimeducations = pimeducationsData;
        let pimpersonchangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonchanges'),'undefined')){
            pimpersonchangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonchanges') as any);
            if(pimpersonchangesData && pimpersonchangesData.length && pimpersonchangesData.length > 0){
                pimpersonchangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpersonchangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpersonchanges = pimpersonchangesData;
        let pimachievementsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimachievements'),'undefined')){
            pimachievementsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimachievements') as any);
            if(pimachievementsData && pimachievementsData.length && pimachievementsData.length > 0){
                pimachievementsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimachievementsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimachievements = pimachievementsData;
        let pimresearchfindingsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimresearchfindings'),'undefined')){
            pimresearchfindingsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimresearchfindings') as any);
            if(pimresearchfindingsData && pimresearchfindingsData.length && pimresearchfindingsData.length > 0){
                pimresearchfindingsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimresearchfindingsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimresearchfindings = pimresearchfindingsData;
        let pimexitandentriesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimexitandentries'),'undefined')){
            pimexitandentriesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimexitandentries') as any);
            if(pimexitandentriesData && pimexitandentriesData.length && pimexitandentriesData.length > 0){
                pimexitandentriesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimexitandentryid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimexitandentries = pimexitandentriesData;
        let pimrewardpunishmentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimrewardpunishments'),'undefined')){
            pimrewardpunishmentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimrewardpunishments') as any);
            if(pimrewardpunishmentsData && pimrewardpunishmentsData.length && pimrewardpunishmentsData.length > 0){
                pimrewardpunishmentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimrewardpunishmentid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimrewardpunishments = pimrewardpunishmentsData;
        let pimpatentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpatents'),'undefined')){
            pimpatentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpatents') as any);
            if(pimpatentsData && pimpatentsData.length && pimpatentsData.length > 0){
                pimpatentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpatentid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpatents = pimpatentsData;
        let pimlanguageabilitiesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimlanguageabilities'),'undefined')){
            pimlanguageabilitiesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimlanguageabilities') as any);
            if(pimlanguageabilitiesData && pimlanguageabilitiesData.length && pimlanguageabilitiesData.length > 0){
                pimlanguageabilitiesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimlanguageabilityid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimlanguageabilities = pimlanguageabilitiesData;
        let pimarchivesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchives'),'undefined')){
            pimarchivesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchives') as any);
            if(pimarchivesData && pimarchivesData.length && pimarchivesData.length > 0){
                pimarchivesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchives = pimarchivesData;
        let pimfaminfosData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimfaminfos'),'undefined')){
            pimfaminfosData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimfaminfos') as any);
            if(pimfaminfosData && pimfaminfosData.length && pimfaminfosData.length > 0){
                pimfaminfosData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimfaminfoid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimfaminfos = pimfaminfosData;
        let attendancemreportmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes'),'undefined')){
            attendancemreportmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes') as any);
            if(attendancemreportmxesData && attendancemreportmxesData.length && attendancemreportmxesData.length > 0){
                attendancemreportmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancemreportmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancemreportmxes = attendancemreportmxesData;
        let pimworkhistoriesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimworkhistories'),'undefined')){
            pimworkhistoriesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimworkhistories') as any);
            if(pimworkhistoriesData && pimworkhistoriesData.length && pimworkhistoriesData.length > 0){
                pimworkhistoriesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimworkhistoryid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimworkhistories = pimworkhistoriesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pimpeople`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimpersonabilities',JSON.stringify(res.data.pimpersonabilities));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimpapers',JSON.stringify(res.data.pimpapers));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimdistirbutions',JSON.stringify(res.data.pimdistirbutions));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimtitles',JSON.stringify(res.data.pimtitles));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimvocationals',JSON.stringify(res.data.pimvocationals));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimarmycadres',JSON.stringify(res.data.pimarmycadres));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimvacations',JSON.stringify(res.data.pimvacations));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_trmtrainpeople',JSON.stringify(res.data.trmtrainpeople));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimcontracts',JSON.stringify(res.data.pimcontracts));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimeducations',JSON.stringify(res.data.pimeducations));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimpersonchanges',JSON.stringify(res.data.pimpersonchanges));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimachievements',JSON.stringify(res.data.pimachievements));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimresearchfindings',JSON.stringify(res.data.pimresearchfindings));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimexitandentries',JSON.stringify(res.data.pimexitandentries));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimrewardpunishments',JSON.stringify(res.data.pimrewardpunishments));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimpatents',JSON.stringify(res.data.pimpatents));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimlanguageabilities',JSON.stringify(res.data.pimlanguageabilities));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimarchives',JSON.stringify(res.data.pimarchives));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimfaminfos',JSON.stringify(res.data.pimfaminfos));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pimworkhistories',JSON.stringify(res.data.pimworkhistories));
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
        let pimpersonabilitiesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonabilities'),'undefined')){
            pimpersonabilitiesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonabilities') as any);
            if(pimpersonabilitiesData && pimpersonabilitiesData.length && pimpersonabilitiesData.length > 0){
                pimpersonabilitiesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpersonabilityid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpersonabilities = pimpersonabilitiesData;
        let pimpapersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpapers'),'undefined')){
            pimpapersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpapers') as any);
            if(pimpapersData && pimpapersData.length && pimpapersData.length > 0){
                pimpapersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpaperid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpapers = pimpapersData;
        let pimdistirbutionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimdistirbutions'),'undefined')){
            pimdistirbutionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimdistirbutions') as any);
            if(pimdistirbutionsData && pimdistirbutionsData.length && pimdistirbutionsData.length > 0){
                pimdistirbutionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimdistirbutionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimdistirbutions = pimdistirbutionsData;
        let pimtitlesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimtitles'),'undefined')){
            pimtitlesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimtitles') as any);
            if(pimtitlesData && pimtitlesData.length && pimtitlesData.length > 0){
                pimtitlesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimtitleid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimtitles = pimtitlesData;
        let pimvocationalsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimvocationals'),'undefined')){
            pimvocationalsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimvocationals') as any);
            if(pimvocationalsData && pimvocationalsData.length && pimvocationalsData.length > 0){
                pimvocationalsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimvocationalid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimvocationals = pimvocationalsData;
        let pimarmycadresData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarmycadres'),'undefined')){
            pimarmycadresData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarmycadres') as any);
            if(pimarmycadresData && pimarmycadresData.length && pimarmycadresData.length > 0){
                pimarmycadresData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarmycadresid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarmycadres = pimarmycadresData;
        let pimcorrectionappliesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies'),'undefined')){
            pimcorrectionappliesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcorrectionapplies') as any);
            if(pimcorrectionappliesData && pimcorrectionappliesData.length && pimcorrectionappliesData.length > 0){
                pimcorrectionappliesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcorrectionapplyid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcorrectionapplies = pimcorrectionappliesData;
        let pimvacationsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimvacations'),'undefined')){
            pimvacationsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimvacations') as any);
            if(pimvacationsData && pimvacationsData.length && pimvacationsData.length > 0){
                pimvacationsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimvacationid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimvacations = pimvacationsData;
        let trmtrainpeopleData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainpeople'),'undefined')){
            trmtrainpeopleData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_trmtrainpeople') as any);
            if(trmtrainpeopleData && trmtrainpeopleData.length && trmtrainpeopleData.length > 0){
                trmtrainpeopleData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.trmtrianpersonid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.trmtrainpeople = trmtrainpeopleData;
        let pimcontractsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimcontracts'),'undefined')){
            pimcontractsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimcontracts') as any);
            if(pimcontractsData && pimcontractsData.length && pimcontractsData.length > 0){
                pimcontractsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimcontractid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimcontracts = pimcontractsData;
        let pimeducationsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimeducations'),'undefined')){
            pimeducationsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimeducations') as any);
            if(pimeducationsData && pimeducationsData.length && pimeducationsData.length > 0){
                pimeducationsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimeducationid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimeducations = pimeducationsData;
        let pimpersonchangesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonchanges'),'undefined')){
            pimpersonchangesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpersonchanges') as any);
            if(pimpersonchangesData && pimpersonchangesData.length && pimpersonchangesData.length > 0){
                pimpersonchangesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpersonchangeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpersonchanges = pimpersonchangesData;
        let pimachievementsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimachievements'),'undefined')){
            pimachievementsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimachievements') as any);
            if(pimachievementsData && pimachievementsData.length && pimachievementsData.length > 0){
                pimachievementsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimachievementsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimachievements = pimachievementsData;
        let pimresearchfindingsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimresearchfindings'),'undefined')){
            pimresearchfindingsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimresearchfindings') as any);
            if(pimresearchfindingsData && pimresearchfindingsData.length && pimresearchfindingsData.length > 0){
                pimresearchfindingsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimresearchfindingsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimresearchfindings = pimresearchfindingsData;
        let pimexitandentriesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimexitandentries'),'undefined')){
            pimexitandentriesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimexitandentries') as any);
            if(pimexitandentriesData && pimexitandentriesData.length && pimexitandentriesData.length > 0){
                pimexitandentriesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimexitandentryid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimexitandentries = pimexitandentriesData;
        let pimrewardpunishmentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimrewardpunishments'),'undefined')){
            pimrewardpunishmentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimrewardpunishments') as any);
            if(pimrewardpunishmentsData && pimrewardpunishmentsData.length && pimrewardpunishmentsData.length > 0){
                pimrewardpunishmentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimrewardpunishmentid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimrewardpunishments = pimrewardpunishmentsData;
        let pimpatentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimpatents'),'undefined')){
            pimpatentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimpatents') as any);
            if(pimpatentsData && pimpatentsData.length && pimpatentsData.length > 0){
                pimpatentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimpatentid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimpatents = pimpatentsData;
        let pimlanguageabilitiesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimlanguageabilities'),'undefined')){
            pimlanguageabilitiesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimlanguageabilities') as any);
            if(pimlanguageabilitiesData && pimlanguageabilitiesData.length && pimlanguageabilitiesData.length > 0){
                pimlanguageabilitiesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimlanguageabilityid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimlanguageabilities = pimlanguageabilitiesData;
        let pimarchivesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimarchives'),'undefined')){
            pimarchivesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimarchives') as any);
            if(pimarchivesData && pimarchivesData.length && pimarchivesData.length > 0){
                pimarchivesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimarchivesid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimarchives = pimarchivesData;
        let pimfaminfosData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimfaminfos'),'undefined')){
            pimfaminfosData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimfaminfos') as any);
            if(pimfaminfosData && pimfaminfosData.length && pimfaminfosData.length > 0){
                pimfaminfosData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimfaminfoid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimfaminfos = pimfaminfosData;
        let attendancemreportmxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes'),'undefined')){
            attendancemreportmxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_attendancemreportmxes') as any);
            if(attendancemreportmxesData && attendancemreportmxesData.length && attendancemreportmxesData.length > 0){
                attendancemreportmxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.attendancemreportmxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.attendancemreportmxes = attendancemreportmxesData;
        let pimworkhistoriesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pimworkhistories'),'undefined')){
            pimworkhistoriesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pimworkhistories') as any);
            if(pimworkhistoriesData && pimworkhistoriesData.length && pimworkhistoriesData.length > 0){
                pimworkhistoriesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pimworkhistoryid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pimworkhistories = pimworkhistoriesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimpeople/${context.pimperson}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pimpersonabilities',JSON.stringify(res.data.pimpersonabilities));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpapers',JSON.stringify(res.data.pimpapers));
            this.tempStorage.setItem(context.srfsessionkey+'_pimdistirbutions',JSON.stringify(res.data.pimdistirbutions));
            this.tempStorage.setItem(context.srfsessionkey+'_pimtitles',JSON.stringify(res.data.pimtitles));
            this.tempStorage.setItem(context.srfsessionkey+'_pimvocationals',JSON.stringify(res.data.pimvocationals));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarmycadres',JSON.stringify(res.data.pimarmycadres));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
            this.tempStorage.setItem(context.srfsessionkey+'_pimvacations',JSON.stringify(res.data.pimvacations));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainpeople',JSON.stringify(res.data.trmtrainpeople));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontracts',JSON.stringify(res.data.pimcontracts));
            this.tempStorage.setItem(context.srfsessionkey+'_pimeducations',JSON.stringify(res.data.pimeducations));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpersonchanges',JSON.stringify(res.data.pimpersonchanges));
            this.tempStorage.setItem(context.srfsessionkey+'_pimachievements',JSON.stringify(res.data.pimachievements));
            this.tempStorage.setItem(context.srfsessionkey+'_pimresearchfindings',JSON.stringify(res.data.pimresearchfindings));
            this.tempStorage.setItem(context.srfsessionkey+'_pimexitandentries',JSON.stringify(res.data.pimexitandentries));
            this.tempStorage.setItem(context.srfsessionkey+'_pimrewardpunishments',JSON.stringify(res.data.pimrewardpunishments));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpatents',JSON.stringify(res.data.pimpatents));
            this.tempStorage.setItem(context.srfsessionkey+'_pimlanguageabilities',JSON.stringify(res.data.pimlanguageabilities));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchives',JSON.stringify(res.data.pimarchives));
            this.tempStorage.setItem(context.srfsessionkey+'_pimfaminfos',JSON.stringify(res.data.pimfaminfos));
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pimworkhistories',JSON.stringify(res.data.pimworkhistories));
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
            this.tempStorage.setItem(context.srfsessionkey+'_pimpersonabilities',JSON.stringify(res.data.pimpersonabilities));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpapers',JSON.stringify(res.data.pimpapers));
            this.tempStorage.setItem(context.srfsessionkey+'_pimdistirbutions',JSON.stringify(res.data.pimdistirbutions));
            this.tempStorage.setItem(context.srfsessionkey+'_pimtitles',JSON.stringify(res.data.pimtitles));
            this.tempStorage.setItem(context.srfsessionkey+'_pimvocationals',JSON.stringify(res.data.pimvocationals));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarmycadres',JSON.stringify(res.data.pimarmycadres));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcorrectionapplies',JSON.stringify(res.data.pimcorrectionapplies));
            this.tempStorage.setItem(context.srfsessionkey+'_pimvacations',JSON.stringify(res.data.pimvacations));
            this.tempStorage.setItem(context.srfsessionkey+'_trmtrainpeople',JSON.stringify(res.data.trmtrainpeople));
            this.tempStorage.setItem(context.srfsessionkey+'_pimcontracts',JSON.stringify(res.data.pimcontracts));
            this.tempStorage.setItem(context.srfsessionkey+'_pimeducations',JSON.stringify(res.data.pimeducations));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpersonchanges',JSON.stringify(res.data.pimpersonchanges));
            this.tempStorage.setItem(context.srfsessionkey+'_pimachievements',JSON.stringify(res.data.pimachievements));
            this.tempStorage.setItem(context.srfsessionkey+'_pimresearchfindings',JSON.stringify(res.data.pimresearchfindings));
            this.tempStorage.setItem(context.srfsessionkey+'_pimexitandentries',JSON.stringify(res.data.pimexitandentries));
            this.tempStorage.setItem(context.srfsessionkey+'_pimrewardpunishments',JSON.stringify(res.data.pimrewardpunishments));
            this.tempStorage.setItem(context.srfsessionkey+'_pimpatents',JSON.stringify(res.data.pimpatents));
            this.tempStorage.setItem(context.srfsessionkey+'_pimlanguageabilities',JSON.stringify(res.data.pimlanguageabilities));
            this.tempStorage.setItem(context.srfsessionkey+'_pimarchives',JSON.stringify(res.data.pimarchives));
            this.tempStorage.setItem(context.srfsessionkey+'_pimfaminfos',JSON.stringify(res.data.pimfaminfos));
            this.tempStorage.setItem(context.srfsessionkey+'_attendancemreportmxes',JSON.stringify(res.data.attendancemreportmxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pimworkhistories',JSON.stringify(res.data.pimworkhistories));
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