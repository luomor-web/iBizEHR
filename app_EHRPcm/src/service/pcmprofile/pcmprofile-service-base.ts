import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 应聘者基本信息服务对象基类
 *
 * @export
 * @class PCMPROFILEServiceBase
 * @extends {EntityServie}
 */
export default class PCMPROFILEServiceBase extends EntityService {

    /**
     * Creates an instance of  PCMPROFILEServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMPROFILEServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PCMPROFILEServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmprofile';
        this.APPDEKEY = 'pcmprofileid';
        this.APPDENAME = 'pcmprofiles';
        this.APPDETEXT = 'pcmprofilename';
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
     * @memberof PCMPROFILEServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/select`,isloading);
    }

    /**
     * JZBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async JZBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/jzbtg`,data,isloading);
    }

    /**
     * SBJZB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async SBJZB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/sbjzb`,data,isloading);
    }

    /**
     * JSPBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async JSPBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/jspbtg`,data,isloading);
    }

    /**
     * PrintSPB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async PrintSPB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/printspb`,data,isloading);
    }

    /**
     * GetYPZNL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async GetYPZNL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/getypznl`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmprofileapprovals',JSON.stringify(res.data.pcmprofileapprovals));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmcertofregs',JSON.stringify(res.data.pcmcertofregs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmschooloffices',JSON.stringify(res.data.pcmschooloffices));
            this.tempStorage.setItem(context.srfsessionkey+'_tdzwxxes',JSON.stringify(res.data.tdzwxxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmawardswons',JSON.stringify(res.data.pcmawardswons));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmworkresumes',JSON.stringify(res.data.pcmworkresumes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmpracticeexperiences',JSON.stringify(res.data.pcmpracticeexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmeducationexperiences',JSON.stringify(res.data.pcmeducationexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_testresults',JSON.stringify(res.data.testresults));
            return res;

    }

    /**
     * ClearPersonUpdateInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async ClearPersonUpdateInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/clearpersonupdateinfo`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmprofileapprovalsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmprofileapprovals'),'undefined')){
            pcmprofileapprovalsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmprofileapprovals') as any);
            if(pcmprofileapprovalsData && pcmprofileapprovalsData.length && pcmprofileapprovalsData.length > 0){
                pcmprofileapprovalsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmprofileapprovalid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmprofileapprovals = pcmprofileapprovalsData;
        let pcmcertofregsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmcertofregs'),'undefined')){
            pcmcertofregsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmcertofregs') as any);
            if(pcmcertofregsData && pcmcertofregsData.length && pcmcertofregsData.length > 0){
                pcmcertofregsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmcertofregid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmcertofregs = pcmcertofregsData;
        let pcmschoolofficesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmschooloffices'),'undefined')){
            pcmschoolofficesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmschooloffices') as any);
            if(pcmschoolofficesData && pcmschoolofficesData.length && pcmschoolofficesData.length > 0){
                pcmschoolofficesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmschoolofficeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmschooloffices = pcmschoolofficesData;
        let tdzwxxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_tdzwxxes'),'undefined')){
            tdzwxxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_tdzwxxes') as any);
            if(tdzwxxesData && tdzwxxesData.length && tdzwxxesData.length > 0){
                tdzwxxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.tdzwxxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.tdzwxxes = tdzwxxesData;
        let pcmawardswonsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmawardswons'),'undefined')){
            pcmawardswonsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmawardswons') as any);
            if(pcmawardswonsData && pcmawardswonsData.length && pcmawardswonsData.length > 0){
                pcmawardswonsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmawardswonsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmawardswons = pcmawardswonsData;
        let pcmworkresumesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmworkresumes'),'undefined')){
            pcmworkresumesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmworkresumes') as any);
            if(pcmworkresumesData && pcmworkresumesData.length && pcmworkresumesData.length > 0){
                pcmworkresumesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmworkresumeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmworkresumes = pcmworkresumesData;
        let pcmpracticeexperiencesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmpracticeexperiences'),'undefined')){
            pcmpracticeexperiencesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmpracticeexperiences') as any);
            if(pcmpracticeexperiencesData && pcmpracticeexperiencesData.length && pcmpracticeexperiencesData.length > 0){
                pcmpracticeexperiencesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmpracticeexperienceid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmpracticeexperiences = pcmpracticeexperiencesData;
        let pcmeducationexperiencesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmeducationexperiences'),'undefined')){
            pcmeducationexperiencesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmeducationexperiences') as any);
            if(pcmeducationexperiencesData && pcmeducationexperiencesData.length && pcmeducationexperiencesData.length > 0){
                pcmeducationexperiencesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmeducationexperienceid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmeducationexperiences = pcmeducationexperiencesData;
        let testresultsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_testresults'),'undefined')){
            testresultsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_testresults') as any);
            if(testresultsData && testresultsData.length && testresultsData.length > 0){
                testresultsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.testresultid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.testresults = testresultsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmprofileapprovals',JSON.stringify(res.data.pcmprofileapprovals));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmcertofregs',JSON.stringify(res.data.pcmcertofregs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmschooloffices',JSON.stringify(res.data.pcmschooloffices));
            this.tempStorage.setItem(context.srfsessionkey+'_tdzwxxes',JSON.stringify(res.data.tdzwxxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmawardswons',JSON.stringify(res.data.pcmawardswons));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmworkresumes',JSON.stringify(res.data.pcmworkresumes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmpracticeexperiences',JSON.stringify(res.data.pcmpracticeexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmeducationexperiences',JSON.stringify(res.data.pcmeducationexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_testresults',JSON.stringify(res.data.testresults));
            return res;
    }

    /**
     * Invalid2接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async Invalid2(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/invalid2`,data,isloading);
    }

    /**
     * BD接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async BD(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/bd`,data,isloading);
    }

    /**
     * JLDTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async JLDTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/jldtg`,data,isloading);
    }

    /**
     * CheckYJSNF接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async CheckYJSNF(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/checkyjsnf`,data,isloading);
    }

    /**
     * GSSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async GSSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/gssp`,data,isloading);
    }

    /**
     * CheckEmail接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async CheckEmail(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/checkemail`,data,isloading);
    }

    /**
     * GetPcmprofileInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async GetPcmprofileInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}/getpcmprofileinfo`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmprofileapprovals',JSON.stringify(res.data.pcmprofileapprovals));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmcertofregs',JSON.stringify(res.data.pcmcertofregs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmschooloffices',JSON.stringify(res.data.pcmschooloffices));
            this.tempStorage.setItem(context.srfsessionkey+'_tdzwxxes',JSON.stringify(res.data.tdzwxxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmawardswons',JSON.stringify(res.data.pcmawardswons));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmworkresumes',JSON.stringify(res.data.pcmworkresumes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmpracticeexperiences',JSON.stringify(res.data.pcmpracticeexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmeducationexperiences',JSON.stringify(res.data.pcmeducationexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_testresults',JSON.stringify(res.data.testresults));
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmprofileapprovalsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmprofileapprovals'),'undefined')){
            pcmprofileapprovalsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmprofileapprovals') as any);
            if(pcmprofileapprovalsData && pcmprofileapprovalsData.length && pcmprofileapprovalsData.length > 0){
                pcmprofileapprovalsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmprofileapprovalid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmprofileapprovals = pcmprofileapprovalsData;
        let pcmcertofregsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmcertofregs'),'undefined')){
            pcmcertofregsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmcertofregs') as any);
            if(pcmcertofregsData && pcmcertofregsData.length && pcmcertofregsData.length > 0){
                pcmcertofregsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmcertofregid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmcertofregs = pcmcertofregsData;
        let pcmschoolofficesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmschooloffices'),'undefined')){
            pcmschoolofficesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmschooloffices') as any);
            if(pcmschoolofficesData && pcmschoolofficesData.length && pcmschoolofficesData.length > 0){
                pcmschoolofficesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmschoolofficeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmschooloffices = pcmschoolofficesData;
        let tdzwxxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_tdzwxxes'),'undefined')){
            tdzwxxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_tdzwxxes') as any);
            if(tdzwxxesData && tdzwxxesData.length && tdzwxxesData.length > 0){
                tdzwxxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.tdzwxxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.tdzwxxes = tdzwxxesData;
        let pcmawardswonsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmawardswons'),'undefined')){
            pcmawardswonsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmawardswons') as any);
            if(pcmawardswonsData && pcmawardswonsData.length && pcmawardswonsData.length > 0){
                pcmawardswonsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmawardswonsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmawardswons = pcmawardswonsData;
        let pcmworkresumesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmworkresumes'),'undefined')){
            pcmworkresumesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmworkresumes') as any);
            if(pcmworkresumesData && pcmworkresumesData.length && pcmworkresumesData.length > 0){
                pcmworkresumesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmworkresumeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmworkresumes = pcmworkresumesData;
        let pcmpracticeexperiencesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmpracticeexperiences'),'undefined')){
            pcmpracticeexperiencesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmpracticeexperiences') as any);
            if(pcmpracticeexperiencesData && pcmpracticeexperiencesData.length && pcmpracticeexperiencesData.length > 0){
                pcmpracticeexperiencesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmpracticeexperienceid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmpracticeexperiences = pcmpracticeexperiencesData;
        let pcmeducationexperiencesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmeducationexperiences'),'undefined')){
            pcmeducationexperiencesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmeducationexperiences') as any);
            if(pcmeducationexperiencesData && pcmeducationexperiencesData.length && pcmeducationexperiencesData.length > 0){
                pcmeducationexperiencesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmeducationexperienceid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmeducationexperiences = pcmeducationexperiencesData;
        let testresultsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_testresults'),'undefined')){
            testresultsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_testresults') as any);
            if(testresultsData && testresultsData.length && testresultsData.length > 0){
                testresultsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.testresultid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.testresults = testresultsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pcmprofiles`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmprofileapprovals',JSON.stringify(res.data.pcmprofileapprovals));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmcertofregs',JSON.stringify(res.data.pcmcertofregs));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmschooloffices',JSON.stringify(res.data.pcmschooloffices));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_tdzwxxes',JSON.stringify(res.data.tdzwxxes));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmawardswons',JSON.stringify(res.data.pcmawardswons));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmworkresumes',JSON.stringify(res.data.pcmworkresumes));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmpracticeexperiences',JSON.stringify(res.data.pcmpracticeexperiences));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmeducationexperiences',JSON.stringify(res.data.pcmeducationexperiences));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_testresults',JSON.stringify(res.data.testresults));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmprofileapprovalsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmprofileapprovals'),'undefined')){
            pcmprofileapprovalsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmprofileapprovals') as any);
            if(pcmprofileapprovalsData && pcmprofileapprovalsData.length && pcmprofileapprovalsData.length > 0){
                pcmprofileapprovalsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmprofileapprovalid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmprofileapprovals = pcmprofileapprovalsData;
        let pcmcertofregsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmcertofregs'),'undefined')){
            pcmcertofregsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmcertofregs') as any);
            if(pcmcertofregsData && pcmcertofregsData.length && pcmcertofregsData.length > 0){
                pcmcertofregsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmcertofregid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmcertofregs = pcmcertofregsData;
        let pcmschoolofficesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmschooloffices'),'undefined')){
            pcmschoolofficesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmschooloffices') as any);
            if(pcmschoolofficesData && pcmschoolofficesData.length && pcmschoolofficesData.length > 0){
                pcmschoolofficesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmschoolofficeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmschooloffices = pcmschoolofficesData;
        let tdzwxxesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_tdzwxxes'),'undefined')){
            tdzwxxesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_tdzwxxes') as any);
            if(tdzwxxesData && tdzwxxesData.length && tdzwxxesData.length > 0){
                tdzwxxesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.tdzwxxid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.tdzwxxes = tdzwxxesData;
        let pcmawardswonsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmawardswons'),'undefined')){
            pcmawardswonsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmawardswons') as any);
            if(pcmawardswonsData && pcmawardswonsData.length && pcmawardswonsData.length > 0){
                pcmawardswonsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmawardswonsid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmawardswons = pcmawardswonsData;
        let pcmworkresumesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmworkresumes'),'undefined')){
            pcmworkresumesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmworkresumes') as any);
            if(pcmworkresumesData && pcmworkresumesData.length && pcmworkresumesData.length > 0){
                pcmworkresumesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmworkresumeid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmworkresumes = pcmworkresumesData;
        let pcmpracticeexperiencesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmpracticeexperiences'),'undefined')){
            pcmpracticeexperiencesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmpracticeexperiences') as any);
            if(pcmpracticeexperiencesData && pcmpracticeexperiencesData.length && pcmpracticeexperiencesData.length > 0){
                pcmpracticeexperiencesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmpracticeexperienceid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmpracticeexperiences = pcmpracticeexperiencesData;
        let pcmeducationexperiencesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmeducationexperiences'),'undefined')){
            pcmeducationexperiencesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmeducationexperiences') as any);
            if(pcmeducationexperiencesData && pcmeducationexperiencesData.length && pcmeducationexperiencesData.length > 0){
                pcmeducationexperiencesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmeducationexperienceid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmeducationexperiences = pcmeducationexperiencesData;
        let testresultsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_testresults'),'undefined')){
            testresultsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_testresults') as any);
            if(testresultsData && testresultsData.length && testresultsData.length > 0){
                testresultsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.testresultid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.testresults = testresultsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmprofileapprovals',JSON.stringify(res.data.pcmprofileapprovals));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmcertofregs',JSON.stringify(res.data.pcmcertofregs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmschooloffices',JSON.stringify(res.data.pcmschooloffices));
            this.tempStorage.setItem(context.srfsessionkey+'_tdzwxxes',JSON.stringify(res.data.tdzwxxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmawardswons',JSON.stringify(res.data.pcmawardswons));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmworkresumes',JSON.stringify(res.data.pcmworkresumes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmpracticeexperiences',JSON.stringify(res.data.pcmpracticeexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmeducationexperiences',JSON.stringify(res.data.pcmeducationexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_testresults',JSON.stringify(res.data.testresults));
            return res;
    }

    /**
     * ReturnYPZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async ReturnYPZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/returnypz`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmprofiles/${context.pcmprofile}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmprofileapprovals',JSON.stringify(res.data.pcmprofileapprovals));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmcertofregs',JSON.stringify(res.data.pcmcertofregs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmschooloffices',JSON.stringify(res.data.pcmschooloffices));
            this.tempStorage.setItem(context.srfsessionkey+'_tdzwxxes',JSON.stringify(res.data.tdzwxxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmawardswons',JSON.stringify(res.data.pcmawardswons));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmworkresumes',JSON.stringify(res.data.pcmworkresumes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmpracticeexperiences',JSON.stringify(res.data.pcmpracticeexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmeducationexperiences',JSON.stringify(res.data.pcmeducationexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_testresults',JSON.stringify(res.data.testresults));
            return res;

    }

    /**
     * CheckYglxIsChanged接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async CheckYglxIsChanged(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/checkyglxischanged`,data,isloading);
    }

    /**
     * SX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async SX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/sx`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/checkkey`,data,isloading);
    }

    /**
     * Invalid接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async Invalid(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/invalid`,data,isloading);
    }

    /**
     * JZBBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async JZBBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/jzbbtg`,data,isloading);
    }

    /**
     * ClearYPZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async ClearYPZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/clearypz`,data,isloading);
    }

    /**
     * CheckFP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async CheckFP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/checkfp`,data,isloading);
    }

    /**
     * SCBH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async SCBH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/scbh`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmprofiles/getdraft`,isloading);
        res.data.pcmprofile = data.pcmprofile;
            this.tempStorage.setItem(context.srfsessionkey+'_pcmprofileapprovals',JSON.stringify(res.data.pcmprofileapprovals));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmcertofregs',JSON.stringify(res.data.pcmcertofregs));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmschooloffices',JSON.stringify(res.data.pcmschooloffices));
            this.tempStorage.setItem(context.srfsessionkey+'_tdzwxxes',JSON.stringify(res.data.tdzwxxes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmawardswons',JSON.stringify(res.data.pcmawardswons));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmworkresumes',JSON.stringify(res.data.pcmworkresumes));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmpracticeexperiences',JSON.stringify(res.data.pcmpracticeexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_pcmeducationexperiences',JSON.stringify(res.data.pcmeducationexperiences));
            this.tempStorage.setItem(context.srfsessionkey+'_testresults',JSON.stringify(res.data.testresults));
        return res;
    }

    /**
     * ClearYYDJMC接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async ClearYYDJMC(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/clearyydjmc`,data,isloading);
    }

    /**
     * Submit接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async Submit(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/submit`,data,isloading);
    }

    /**
     * PersonUpdateInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async PersonUpdateInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().put(`/pcmprofiles/${context.pcmprofile}/personupdateinfo`,data,isloading);
    }

    /**
     * GSCS接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async GSCS(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/gscs`,data,isloading);
    }

    /**
     * FillingYPZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FillingYPZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/fillingypz`,data,isloading);
    }

    /**
     * YQWBD接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async YQWBD(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/yqwbd`,data,isloading);
    }

    /**
     * USEYBH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async USEYBH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/useybh`,data,isloading);
    }

    /**
     * CheckMobieNumber接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async CheckMobieNumber(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/checkmobienumber`,data,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmprofiles/${context.pcmprofile}`,isloading);

    }

    /**
     * JLDBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async JLDBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/jldbtg`,data,isloading);
    }

    /**
     * JSPTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async JSPTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/jsptg`,data,isloading);
    }

    /**
     * SetNQDLDHTQX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async SetNQDLDHTQX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmprofiles/${context.pcmprofile}/setnqdldhtqx`,data,isloading);
    }

    /**
     * FetchYRDWSH_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchYRDWSH_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchyrdwsh_csrcyj`,tempData,isloading);
    }

    /**
     * FetchJLDSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchJLDSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchjldsp`,tempData,isloading);
    }

    /**
     * FetchBD_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchBD_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchbd_csrcyj`,tempData,isloading);
    }

    /**
     * FetchYPZSPB_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchYPZSPB_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchypzspb_csrcyj`,tempData,isloading);
    }

    /**
     * FetchZPDWSH接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchZPDWSH(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchzpdwsh`,tempData,isloading);
    }

    /**
     * FetchBD接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchBD(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchbd`,tempData,isloading);
    }

    /**
     * FetchBHSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchBHSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchbhsp`,tempData,isloading);
    }

    /**
     * FetchLR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchLR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchlr`,tempData,isloading);
    }

    /**
     * FetchRLSB接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchRLSB(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchrlsb`,tempData,isloading);
    }

    /**
     * FetchFormType接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchFormType(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchformtype`,tempData,isloading);
    }

    /**
     * FetchHTRY_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchHTRY_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchhtry_csrcyj`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchJZBSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchJZBSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchjzbsp`,tempData,isloading);
    }

    /**
     * FetchRZSP_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchRZSP_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchrzsp_csrcyj`,tempData,isloading);
    }

    /**
     * FetchJLDSP_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchJLDSP_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchjldsp_csrcyj`,tempData,isloading);
    }

    /**
     * FetchBHSP_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchBHSP_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchbhsp_csrcyj`,tempData,isloading);
    }

    /**
     * FetchLR_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchLR_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchlr_csrcyj`,tempData,isloading);
    }

    /**
     * FetchYPZBB_READ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchYPZBB_READ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchypzbb_read`,tempData,isloading);
    }

    /**
     * FetchHTRY接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchHTRY(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchhtry`,tempData,isloading);
    }

    /**
     * FetchRZSP接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchRZSP(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchrzsp`,tempData,isloading);
    }

    /**
     * FetchYRDWCS_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchYRDWCS_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchyrdwcs_csrcyj`,tempData,isloading);
    }

    /**
     * FetchJZBSP_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchJZBSP_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchjzbsp_csrcyj`,tempData,isloading);
    }

    /**
     * FetchRLSB_CSRCYJ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PCMPROFILEServiceBase
     */
    public async FetchRLSB_CSRCYJ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmprofiles/fetchrlsb_csrcyj`,tempData,isloading);
    }
}