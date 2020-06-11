import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考核周期服务对象基类
 *
 * @export
 * @class ParExamCycleServiceBase
 * @extends {EntityServie}
 */
export default class ParExamCycleServiceBase extends EntityService {

    /**
     * Creates an instance of  ParExamCycleServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParExamCycleServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParExamCycleServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parexamcycle';
        this.APPDEKEY = 'parexamcycleid';
        this.APPDENAME = 'parexamcycles';
        this.APPDETEXT = 'parexamcyclename';
        this.APPNAME = 'ehrpar';
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
     * @memberof ParExamCycleServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/parexamcycles/${context.parexamcycle}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParExamCycleServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parexamcycles/select`,tempData,isloading);
    }
}