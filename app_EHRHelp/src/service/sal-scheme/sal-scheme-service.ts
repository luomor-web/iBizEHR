import { Http,Util } from '@/utils';
import SalSchemeServiceBase from './sal-scheme-service-base';


/**
 * 工资单服务对象
 *
 * @export
 * @class SalSchemeService
 * @extends {SalSchemeServiceBase}
 */
export default class SalSchemeService extends SalSchemeServiceBase {

    /**
     * Creates an instance of  SalSchemeService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalSchemeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}