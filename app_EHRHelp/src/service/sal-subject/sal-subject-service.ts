import { Http,Util } from '@/utils';
import SalSubjectServiceBase from './sal-subject-service-base';


/**
 * 财务科目服务对象
 *
 * @export
 * @class SalSubjectService
 * @extends {SalSubjectServiceBase}
 */
export default class SalSubjectService extends SalSubjectServiceBase {

    /**
     * Creates an instance of  SalSubjectService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalSubjectService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}