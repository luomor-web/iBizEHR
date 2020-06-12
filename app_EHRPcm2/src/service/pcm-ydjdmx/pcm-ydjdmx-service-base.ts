import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import FillPersonInfoLogic from '@/service/pcm-ydjdmx/fill-person-info-logic';
import SetNewZtLogic from '@/service/pcm-ydjdmx/set-new-zt-logic';
import NewDisInfoLogic from '@/service/pcm-ydjdmx/new-dis-info-logic';
import RyHgLogic from '@/service/pcm-ydjdmx/ry-hg-logic';
import SetCheckstatusLogic from '@/service/pcm-ydjdmx/set-checkstatus-logic';



/**
 * 异动借调明细服务对象基类
 *
 * @export
 * @class PcmYdjdmxServiceBase
 * @extends {EntityServie}
 */
export default class PcmYdjdmxServiceBase extends EntityService {

    /**
     * Creates an instance of  PcmYdjdmxServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmYdjdmxServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof PcmYdjdmxServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='pcmydjdmx';
        this.APPDEKEY = 'pcmydjdmxid';
        this.APPDENAME = 'pcmydjdmxes';
        this.APPDETEXT = 'pcmydjdmxname';
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
     * @memberof PcmYdjdmxServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
        }
        if(context.ormorg && context.ormpost && context.pcmydjdmx){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
        }
        if(context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
        }
        if(context.ormpost && context.pcmydjdmx){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
        }
        if(context.ormorg && context.pcmydjdmx){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
        }
        if(context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
        }
        if(context.ormduty && context.pcmydjdmx){
            return Http.getInstance().get(`/ormduties/${context.ormduty}/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
        }
            return Http.getInstance().get(`/pcmydjdmxes/${context.pcmydjdmx}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormorg && context.ormpost && context.pcmydjdmx){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormpost && context.pcmydjdmx){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormorg && context.pcmydjdmx){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormduty && context.pcmydjdmx){
            return Http.getInstance().get(`/ormduties/${context.ormduty}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
            return res;

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/getdraft`,isloading);
        }
        if(context.ormorg && context.ormpost && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/getdraft`,isloading);
        }
        if(context.ormorg && context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/getdraft`,isloading);
        }
        if(context.pimdistirbution && true){
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/getdraft`,isloading);
        }
        if(context.ormpost && true){
            return Http.getInstance().get(`/ormposts/${context.ormpost}/pcmydjdmxes/getdraft`,isloading);
        }
        if(context.ormorg && true){
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pcmydjdmxes/getdraft`,isloading);
        }
        if(context.ormorgsector && true){
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/getdraft`,isloading);
        }
        if(context.ormduty && true){
            return Http.getInstance().get(`/ormduties/${context.ormduty}/pcmydjdmxes/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/pcmydjdmxes/getdraft`,isloading);
        res.data.pcmydjdmx = data.pcmydjdmx;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().put(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
        }
        if(context.ormorg && context.ormpost && context.pcmydjdmx){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().put(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
        }
        if(context.ormpost && context.pcmydjdmx){
            return Http.getInstance().put(`/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
        }
        if(context.ormorg && context.pcmydjdmx){
            return Http.getInstance().put(`/ormorgs/${context.ormorg}/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
        }
        if(context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().put(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
        }
        if(context.ormduty && context.pcmydjdmx){
            return Http.getInstance().put(`/ormduties/${context.ormduty}/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/pcmydjdmxes/${context.pcmydjdmx}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().delete(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormorg && context.ormpost && context.pcmydjdmx){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().delete(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormpost && context.pcmydjdmx){
            return Http.getInstance().delete(`/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormorg && context.pcmydjdmx){
            return Http.getInstance().delete(`/ormorgs/${context.ormorg}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().delete(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
        if(context.ormduty && context.pcmydjdmx){
            return Http.getInstance().delete(`/ormduties/${context.ormduty}/pcmydjdmxes/${context.pcmydjdmx}`,isloading);
        }
            return Http.getInstance().delete(`/pcmydjdmxes/${context.pcmydjdmx}`,isloading);

    }

    /**
     * PersonBack接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async PersonBack(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:RyHgLogic = new RyHgLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * PersonInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async PersonInfo(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let appLogic:FillPersonInfoLogic = new FillPersonInfoLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(data))});
        const result = await appLogic.onExecute(context,data,isloading?true:false);
        return {status:200,data:result};
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
        }
        if(context.ormorg && context.ormpost && context.pcmydjdmx){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
        }
        if(context.ormpost && context.pcmydjdmx){
            return Http.getInstance().post(`/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
        }
        if(context.ormorg && context.pcmydjdmx){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
        }
        if(context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
        }
        if(context.ormduty && context.pcmydjdmx){
            return Http.getInstance().post(`/ormduties/${context.ormduty}/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/pcmydjdmxes/${context.pcmydjdmx}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
        }
        if(context.ormorg && context.ormpost && context.pcmydjdmx){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
        }
        if(context.ormorg && context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
        }
        if(context.pimdistirbution && context.pcmydjdmx){
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
        }
        if(context.ormpost && context.pcmydjdmx){
            return Http.getInstance().post(`/ormposts/${context.ormpost}/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
        }
        if(context.ormorg && context.pcmydjdmx){
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
        }
        if(context.ormorgsector && context.pcmydjdmx){
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
        }
        if(context.ormduty && context.pcmydjdmx){
            return Http.getInstance().post(`/ormduties/${context.ormduty}/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/pcmydjdmxes/${context.pcmydjdmx}/save`,data,isloading);
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes`,data,isloading);
        }
        if(context.ormorg && context.ormpost && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes`,data,isloading);
        }
        if(context.ormorg && context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes`,data,isloading);
        }
        if(context.pimdistirbution && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes`,data,isloading);
        }
        if(context.ormpost && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormposts/${context.ormpost}/pcmydjdmxes`,data,isloading);
        }
        if(context.ormorg && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgs/${context.ormorg}/pcmydjdmxes`,data,isloading);
        }
        if(context.ormorgsector && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes`,data,isloading);
        }
        if(context.ormduty && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ormduties/${context.ormduty}/pcmydjdmxes`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/pcmydjdmxes`,data,isloading);
        return res;
    }

    /**
     * FetchJDGLDQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async FetchJDGLDQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
        }
        if(context.ormorg && context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
        }
        if(context.ormorg && context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
        }
        if(context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormposts/${context.ormpost}/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
        }
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
        }
        if(context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
        }
        if(context.ormduty && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormduties/${context.ormduty}/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmydjdmxes/fetchjdgldq`,tempData,isloading);
    }

    /**
     * FetchJDLSJLDQ接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async FetchJDLSJLDQ(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
        }
        if(context.ormorg && context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
        }
        if(context.ormorg && context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
        }
        if(context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormposts/${context.ormpost}/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
        }
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
        }
        if(context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
        }
        if(context.ormduty && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormduties/${context.ormduty}/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmydjdmxes/fetchjdlsjldq`,tempData,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PcmYdjdmxServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.pimperson && context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimpeople/${context.pimperson}/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.ormorg && context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormposts/${context.ormpost}/pcmydjdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.ormorg && context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.pimdistirbution && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/pimdistirbutions/${context.pimdistirbution}/pcmydjdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.ormpost && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormposts/${context.ormpost}/pcmydjdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.ormorg && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgs/${context.ormorg}/pcmydjdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.ormorgsector && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormorgsectors/${context.ormorgsector}/pcmydjdmxes/fetchdefault`,tempData,isloading);
        }
        if(context.ormduty && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ormduties/${context.ormduty}/pcmydjdmxes/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/pcmydjdmxes/fetchdefault`,tempData,isloading);
    }
}