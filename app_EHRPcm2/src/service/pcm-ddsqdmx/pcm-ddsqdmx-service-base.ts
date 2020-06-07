import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 调动申请单明细服务对象基类
 *
 * @export
 * @class PcmDdsqdmxServiceBase
 * @extends {EntityServie}
 */
export default class PcmDdsqdmxServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmDdsqdmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmDdsqdmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmDdsqdmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmddsqdmx';
        this.APPDEKEY = 'pcmddsqdmxid';
        this.APPDENAME = 'pcmddsqdmxes';
        this.APPDETEXT = 'pcmddsqdmxname';
        this.APPNAME = 'ehrpcm2';
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
     * @memberof PcmDdsqdmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/select`,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/select`,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmddsqdmxes/${context.pcmddsqdmx}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().put(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().put(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmddsqdmxes/${context.pcmddsqdmx}`,data,isloading);
            return res;
    }

    /**
     * DDUpdate接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async DDUpdate(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/ddupdate`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().put(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/ddupdate`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().put(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/ddupdate`,data,isloading);
        }
            return Http.getInstance().put(`/pcmddsqdmxes/${context.pcmddsqdmx}/ddupdate`,data,isloading);
    }

    /**
     * SQBTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async SQBTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/sqbtg`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/sqbtg`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/sqbtg`,data,isloading);
        }
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/sqbtg`,data,isloading);
    }

    /**
     * JDCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async JDCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/jdcz`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/jdcz`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/jdcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/jdcz`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/getdraft`,isloading);
        }
        if(context.pimdistirbution && true){
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/getdraft`,isloading);
        }
        if(context.pcmddsqd && true){
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmddsqdmxes/getdraft`,isloading);
        res.data.pcmddsqdmx = data.pcmddsqdmx;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes`,data,isloading);
        }
        if(context.pimdistirbution && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes`,data,isloading);
        }
        if(context.pcmddsqd && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmddsqdmxes`,data,isloading);
        return res;
    }

    /**
     * DDCreate接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async DDCreate(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/ddcreate`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/ddcreate`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/ddcreate`,data,isloading);
        }
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/ddcreate`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().delete(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().delete(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);
        }
            return Http.getInstance().delete(`/pcmddsqdmxes/${context.pcmddsqdmx}`,isloading);

    }

    /**
     * ZZSQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async ZZSQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/zzsq`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/zzsq`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/zzsq`,data,isloading);
        }
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/zzsq`,data,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/checkkey`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/checkkey`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/checkkey`,data,isloading);
    }

    /**
     * DDCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async DDCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/ddcz`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/ddcz`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/ddcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/ddcz`,data,isloading);
    }

    /**
     * SQTG接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async SQTG(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/sqtg`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/sqtg`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/sqtg`,data,isloading);
        }
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/sqtg`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/save`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/save`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/save`,data,isloading);
            return res;
    }

    /**
     * JZCZ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async JZCZ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/jzcz`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmddsqdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/${context.pcmddsqdmx}/jzcz`,data,isloading);
        }
        if(context.pcmddsqd && context.pcmddsqdmx){
            return Http.getInstance().post(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/${context.pcmddsqdmx}/jzcz`,data,isloading);
        }
            return Http.getInstance().post(`/pcmddsqdmxes/${context.pcmddsqdmx}/jzcz`,data,isloading);
    }

    /**
     * FetchJZSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchJZSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchjzsqmx`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchjzsqmx`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchjzsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchjzsqmx`,tempData,isloading);
    }

    /**
     * FetchJDSQGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchJDSQGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchjdsqgr`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchjdsqgr`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchjdsqgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchjdsqgr`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchJDSQMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchJDSQMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchjdsqmx`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchjdsqmx`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchjdsqmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchjdsqmx`,tempData,isloading);
    }

    /**
     * FetchDDJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchDDJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchddjl`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchddjl`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchddjl`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchddjl`,tempData,isloading);
    }

    /**
     * FetchGBDDJL接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchGBDDJL(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchgbddjl`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchgbddjl`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchgbddjl`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchgbddjl`,tempData,isloading);
    }

    /**
     * FetchDDSQGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchDDSQGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchddsqgr`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchddsqgr`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchddsqgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchddsqgr`,tempData,isloading);
    }

    /**
     * FetchDDMX接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchDDMX(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchddmx`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchddmx`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchddmx`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchddmx`,tempData,isloading);
    }

    /**
     * FetchJZSQGR接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmDdsqdmxServiceBase
     */
    public async FetchJZSQGR(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchjzsqgr`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmddsqdmxes/fetchjzsqgr`,tempData,isloading);
        }
        if(context.pcmddsqd && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pcmddsqds/${context.pcmddsqd}/pcmddsqdmxes/fetchjzsqgr`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmddsqdmxes/fetchjzsqgr`,tempData,isloading);
    }
}