import { Http,Util } from '@/utils';
import SalSalaryDetailServiceBase from './sal-salary-detail-service-base';


/**
 * 员工薪酬明细服务对象
 *
 * @export
 * @class SalSalaryDetailService
 * @extends {SalSalaryDetailServiceBase}
 */
export default class SalSalaryDetailService extends SalSalaryDetailServiceBase {

    /**
     * Creates an instance of  SalSalaryDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalSalaryDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}