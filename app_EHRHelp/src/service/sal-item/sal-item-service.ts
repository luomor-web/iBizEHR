import { Http,Util } from '@/utils';
import SalItemServiceBase from './sal-item-service-base';


/**
 * 薪酬要素项服务对象
 *
 * @export
 * @class SalItemService
 * @extends {SalItemServiceBase}
 */
export default class SalItemService extends SalItemServiceBase {

    /**
     * Creates an instance of  SalItemService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalItemService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}