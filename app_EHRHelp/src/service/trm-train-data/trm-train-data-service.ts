import { Http,Util } from '@/utils';
import TrmTrainDataServiceBase from './trm-train-data-service-base';


/**
 * 培训资料服务对象
 *
 * @export
 * @class TrmTrainDataService
 * @extends {TrmTrainDataServiceBase}
 */
export default class TrmTrainDataService extends TrmTrainDataServiceBase {

    /**
     * Creates an instance of  TrmTrainDataService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainDataService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}