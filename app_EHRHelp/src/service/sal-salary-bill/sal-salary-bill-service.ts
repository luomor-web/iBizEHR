import { Http,Util } from '@/utils';
import SalSalaryBillServiceBase from './sal-salary-bill-service-base';


/**
 * 工资表服务对象
 *
 * @export
 * @class SalSalaryBillService
 * @extends {SalSalaryBillServiceBase}
 */
export default class SalSalaryBillService extends SalSalaryBillServiceBase {

    /**
     * Creates an instance of  SalSalaryBillService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalSalaryBillService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}