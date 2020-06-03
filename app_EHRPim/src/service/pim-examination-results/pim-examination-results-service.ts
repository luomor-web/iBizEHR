import { Http,Util } from '@/utils';
import PimExaminationResultsServiceBase from './pim-examination-results-service-base';


/**
 * B/Y员工转正考核结果记录服务对象
 *
 * @export
 * @class PimExaminationResultsService
 * @extends {PimExaminationResultsServiceBase}
 */
export default class PimExaminationResultsService extends PimExaminationResultsServiceBase {

    /**
     * Creates an instance of  PimExaminationResultsService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimExaminationResultsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}