import { Http,Util } from '@/utils';
import ParExamCycleServiceBase from './par-exam-cycle-service-base';


/**
 * 考核周期服务对象
 *
 * @export
 * @class ParExamCycleService
 * @extends {ParExamCycleServiceBase}
 */
export default class ParExamCycleService extends ParExamCycleServiceBase {

    /**
     * Creates an instance of  ParExamCycleService.
     * 
     * @param {*} [opts={}]
     * @memberof  ParExamCycleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}