import { Http,Util } from '@/utils';
import SalLogServiceBase from './sal-log-service-base';


/**
 * 薪酬调整日志服务对象
 *
 * @export
 * @class SalLogService
 * @extends {SalLogServiceBase}
 */
export default class SalLogService extends SalLogServiceBase {

    /**
     * Creates an instance of  SalLogService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalLogService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}