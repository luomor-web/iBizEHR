import { Http,Util } from '@/utils';
import TrmTrainPersonServiceBase from './trm-train-person-service-base';


/**
 * 培训记录服务对象
 *
 * @export
 * @class TrmTrainPersonService
 * @extends {TrmTrainPersonServiceBase}
 */
export default class TrmTrainPersonService extends TrmTrainPersonServiceBase {

    /**
     * Creates an instance of  TrmTrainPersonService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainPersonService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}