import { Http,Util } from '@/utils';
import PimQuestionsServiceBase from './pim-questions-service-base';


/**
 * 问题收集服务对象
 *
 * @export
 * @class PimQuestionsService
 * @extends {PimQuestionsServiceBase}
 */
export default class PimQuestionsService extends PimQuestionsServiceBase {

    /**
     * Creates an instance of  PimQuestionsService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimQuestionsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}