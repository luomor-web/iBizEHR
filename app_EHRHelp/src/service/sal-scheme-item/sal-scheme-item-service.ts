import { Http,Util } from '@/utils';
import SalSchemeItemServiceBase from './sal-scheme-item-service-base';


/**
 * 工资单要素项服务对象
 *
 * @export
 * @class SalSchemeItemService
 * @extends {SalSchemeItemServiceBase}
 */
export default class SalSchemeItemService extends SalSchemeItemServiceBase {

    /**
     * Creates an instance of  SalSchemeItemService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalSchemeItemService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}