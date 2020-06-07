import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import UpdateStateLogic from '@/service/pim-archive-sloanandreturn/update-state-logic';
import UpdateArchiveStateLogic from '@/service/pim-archive-sloanandreturn/update-archive-state-logic';



/**
 * 档案借阅及归还记录服务对象基类
 *
 * @export
 * @class PimArchiveSloanandreturnServiceBase
 * @extends {EntityServie}
 */
export default class PimArchiveSloanandreturnServiceBase extends EntityService {

    /**
     * Creates an instance of  PimArchiveSloanandreturnServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchiveSloanandreturnServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pimarchivesloanandreturn';
        this.APPDEKEY = 'pimarchivesloanandreturnid';
        this.APPDENAME = 'pimarchivesloanandreturns';
        this.APPDETEXT = 'pimarchivesloanandreturnname';
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
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/select`,isloading);
        }
        if(context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/select`,isloading);
        }
            return Http.getInstance().get(`/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,isloading);
        }
        if(context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,isloading);
            return res;

    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,data,isloading);
        }
        if(context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().put(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns`,data,isloading);
        }
        if(context.pimarchives && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pimarchivesloanandreturns`,data,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/getdraft`,isloading);
        }
        if(context.pimarchives && true){
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pimarchivesloanandreturns/getdraft`,isloading);
        res.data.pimarchivesloanandreturn = data.pimarchivesloanandreturn;
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/checkkey`,data,isloading);
        }
        if(context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/checkkey`,data,isloading);
    }

    /**
     * UpdateState接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async UpdateState(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:UpdateStateLogic = new UpdateStateLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/save`,data,isloading);
        }
        if(context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().post(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/save`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,isloading);
        }
        if(context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().delete(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,isloading);
        }
            return Http.getInstance().delete(`/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}`,isloading);

    }

    /**
     * UpdateArchiveState接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async UpdateArchiveState(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/updatearchivestate`,data,isloading);
        }
        if(context.pimarchives && context.pimarchivesloanandreturn){
            return Http.getInstance().put(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/updatearchivestate`,data,isloading);
        }
            return Http.getInstance().put(`/pimarchivesloanandreturns/${context.pimarchivesloanandreturn}/updatearchivestate`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PimArchiveSloanandreturnServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/fetchdefault`,tempData,isloading);
        }
        if(context.pimarchives && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimarchives/${context.pimarchives}/pimarchivesloanandreturns/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pimarchivesloanandreturns/fetchdefault`,tempData,isloading);
    }
}