import { Http,Util } from '@/utils';
import SalSalaryServiceBase from './sal-salary-service-base';


/**
 * 员工薪酬服务对象
 *
 * @export
 * @class SalSalaryService
 * @extends {SalSalaryServiceBase}
 */
export default class SalSalaryService extends SalSalaryServiceBase {

    /**
     * Creates an instance of  SalSalaryService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalSalaryService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}