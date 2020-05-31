import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 高校名录服务对象基类
 *
 * @export
 * @class PcmGxmlServiceBase
 * @extends {EntityServie}
 */
export default class PcmGxmlServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmGxmlServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmGxmlServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmGxmlServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmgxml';
        this.APPDEKEY = 'pcmgxmlid';
        this.APPDENAME = 'pcmgxmls';
        this.APPDETEXT = 'pcmgxmlname';
        this.APPNAME = 'ehrhelp';
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
     * @memberof PcmGxmlServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/pcmgxmls/${context.pcmgxml}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmgxxktempsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps'),'undefined')){
            pcmgxxktempsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps') as any);
            if(pcmgxxktempsData && pcmgxxktempsData.length && pcmgxxktempsData.length > 0){
                pcmgxxktempsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmgxxktempid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmgxxktemps = pcmgxxktempsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmgxmls/${context.pcmgxml}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmgxxktempsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps'),'undefined')){
            pcmgxxktempsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps') as any);
            if(pcmgxxktempsData && pcmgxxktempsData.length && pcmgxxktempsData.length > 0){
                pcmgxxktempsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmgxxktempid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmgxxktemps = pcmgxxktempsData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmgxmls/${context.pcmgxml}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/pcmgxmls/getdraft`,isloading);
        res.data.pcmgxml = data.pcmgxml;
            this.tempStorage.setItem(context.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/pcmgxmls/${context.pcmgxml}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/pcmgxmls/${context.pcmgxml}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let pcmgxxktempsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps'),'undefined')){
            pcmgxxktempsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_pcmgxxktemps') as any);
            if(pcmgxxktempsData && pcmgxxktempsData.length && pcmgxxktempsData.length > 0){
                pcmgxxktempsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.pcmgxxktempid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.pcmgxxktemps = pcmgxxktempsData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/pcmgxmls`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_pcmgxxktemps',JSON.stringify(res.data.pcmgxxktemps));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/pcmgxmls/${context.pcmgxml}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmgxmls/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchCurND接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmGxmlServiceBase
     */
    public async FetchCurND(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmgxmls/fetchcurnd`,tempData,isloading);
    }
}